package sv.gob.mined.siges.web.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.Param;
import sv.gob.mined.siges.web.constantes.ConstantesComponentesId;
import sv.gob.mined.siges.web.constantes.ConstantesOperaciones;
import sv.gob.mined.siges.web.dto.SgDocumento;
import sv.gob.mined.siges.web.dto.SgIncorporacion;
import sv.gob.mined.siges.web.dto.catalogo.SgDepartamento;
import sv.gob.mined.siges.web.dto.catalogo.SgEstadoCivil;
import sv.gob.mined.siges.web.dto.catalogo.SgNacionalidad;
import sv.gob.mined.siges.web.dto.catalogo.SgPais;
import sv.gob.mined.siges.web.dto.catalogo.SgSexo;
import sv.gob.mined.siges.web.excepciones.BusinessException;
import sv.gob.mined.siges.web.filtrosbusqueda.FiltroCodiguera;
import sv.gob.mined.siges.web.mensajes.Etiquetas;
import sv.gob.mined.siges.web.mensajes.Mensajes;
import sv.gob.mined.siges.web.restclient.CatalogosRestClient;
import sv.gob.mined.siges.web.restclient.IncorporacionRestClient;
import sv.gob.mined.siges.web.utilidades.JSFUtils;
import sv.gob.mined.siges.web.utilidades.SofisComboG;

@Named
@ViewScoped
public class IncorporacionBean implements Serializable {

    @Inject
    private CatalogosRestClient catalogoClient;

    @Inject
    private IncorporacionRestClient incorporacionClient;

    @Inject
    private SessionBean sessionBean;

    @Inject
    @Param(name = "id")
    private Long incId;

    @Inject
    @Param(name = "edit")
    private Boolean editable;

    private SgIncorporacion entidadEnEdicion = new SgIncorporacion();
    private SofisComboG<SgSexo> comboSexos;
    private SofisComboG<SgNacionalidad> comboNacionalidad;
    private SofisComboG<SgEstadoCivil> comboEstadoCivil;
    private SofisComboG<SgPais> comboPaisEmisor;
    private List<SgDepartamento> listaDepartamentos;
    private List<SgDocumento> documentosSeleccionados = new ArrayList<>();
    private List<SgDocumento> documentosDeIncorporacion = new ArrayList<>();

    @PostConstruct
    public void init() {
        documentosDeIncorporacion = new ArrayList<>();
        documentosDeIncorporacion.add(new SgDocumento(1L, "Título de Educación Media", "PDF"));
        documentosDeIncorporacion.add(new SgDocumento(2L, "Certificados de Educación Media", "PDF"));
        documentosDeIncorporacion.add(new SgDocumento(3L, "Traduccion de Certificación de titulo", "PDF"));
        try {
            soloLectura = editable != null ? !editable : soloLectura;
            cargarCombos();

            if (incId != null) {
                this.actualizar(incorporacionClient.obtenerPorId(incId));
            } else {
                agregar();
            }
            validarAcceso();
        } catch (Exception ex) {
            // LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    private LocalDate fechaRecepcion;

    public LocalDate getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDate fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    private Boolean soloLectura;

    public IncorporacionBean() {
    }

    public void validarAcceso() {
        if (incId != null) {
            if (soloLectura) {
                if (!sessionBean.getOperaciones().contains(ConstantesOperaciones.BUSCAR_INCORPORACIONES)) {
                    JSFUtils.redirectToIndex();
                }
            } else {
                if (!sessionBean.getOperaciones().contains(ConstantesOperaciones.ACTUALIZAR_INCORPORACIONES)) {
                    JSFUtils.redirectToIndex();
                }
            }
        } else {
            if (!sessionBean.getOperaciones().contains(ConstantesOperaciones.CREAR_INCORPORACIONES)) {
                JSFUtils.redirectToIndex();
            }
        }
    }

    public void cargarCombos() {
        try {
            FiltroCodiguera fc = new FiltroCodiguera();
            fc.setHabilitado(Boolean.TRUE);
            fc.setAscending(new boolean[]{true});

            // Cargar sexos
            fc.setOrderBy(new String[]{"sexNombre"});
            fc.setIncluirCampos(new String[]{"sexNombre", "sexVersion"});
            List<SgSexo> sexos = catalogoClient.buscarSexo(fc);
            comboSexos = new SofisComboG(new ArrayList(sexos), "sexNombre");
            comboSexos.addEmptyItem(Etiquetas.getValue("comboEmptyItem"));

            // Cargar estados civiles
            fc.setOrderBy(new String[]{"eciNombre"});
            fc.setIncluirCampos(new String[]{"eciNombre", "eciVersion"});
            List<SgEstadoCivil> estadosCivil = catalogoClient.buscarEstadoCivil(fc);
            comboEstadoCivil = new SofisComboG(new ArrayList(estadosCivil), "eciNombre");
            comboEstadoCivil.addEmptyItem(Etiquetas.getValue("comboEmptyItem"));

            // Cargar nacionalidades
            fc.setIncluirCampos(new String[]{"nacCodigo", "nacNombre", "nacVersion"});
            fc.setOrderBy(new String[]{"nacNombre"});
            List<SgNacionalidad> listNac = catalogoClient.buscarNacionalidad(fc);

            // Si la lista de nacionalidades está vacía, cargar datos de prueba
            if (listNac == null || listNac.isEmpty()) {
                listNac = cargarNacionalidadesMock();
            }

            comboNacionalidad = new SofisComboG(new ArrayList(listNac), "nacNombre");
            comboNacionalidad.addEmptyItem(Etiquetas.getValue("comboEmptyItem"));

            // Cargar países
            fc.setOrderBy(new String[]{"paiNombre"});
            fc.setIncluirCampos(new String[]{"paiNombre", "paiVersion", "paiCodigo"});
            List<SgPais> paises = catalogoClient.buscarPais(fc);
            comboPaisEmisor = new SofisComboG(new ArrayList(paises), "paiNombre");
            comboPaisEmisor.addEmptyItem(Etiquetas.getValue("comboEmptyItem"));

            // Cargar departamentos de prueba
            listaDepartamentos = cargarDepartamentosMock();
        } catch (Exception ex) {
            // Si ocurre una excepción, cargar datos de prueba
            List<SgNacionalidad> listNac = cargarNacionalidadesMock();
            comboNacionalidad = new SofisComboG(new ArrayList(listNac), "nacNombre");
            comboNacionalidad.addEmptyItem(Etiquetas.getValue("comboEmptyItem"));
        }
    }

    private List<SgNacionalidad> cargarNacionalidadesMock() {
        List<SgNacionalidad> nacionalidades = new ArrayList<>();
        nacionalidades.add(new SgNacionalidad(1L, "Salvadoreño", 1));
        nacionalidades.add(new SgNacionalidad(2L, "Guatemalteco", 1));
        nacionalidades.add(new SgNacionalidad(3L, "Hondureño", 1));
        nacionalidades.add(new SgNacionalidad(4L, "Nicaragüense", 1));
        nacionalidades.add(new SgNacionalidad(5L, "Costarricense", 1));
        nacionalidades.add(new SgNacionalidad(6L, "Panameño", 1));
        nacionalidades.add(new SgNacionalidad(7L, "Mexicano", 1));
        nacionalidades.add(new SgNacionalidad(8L, "Estadounidense", 1));
        nacionalidades.add(new SgNacionalidad(9L, "Español", 1));
        nacionalidades.add(new SgNacionalidad(10L, "Colombiano", 1));
        return nacionalidades;
    }

    private List<SgDepartamento> cargarDepartamentosMock() {
        List<SgDepartamento> departamentos = new ArrayList<>();
        departamentos.add(new SgDepartamento(1L, "San Salvador"));
        departamentos.add(new SgDepartamento(2L, "Santa Ana"));
        departamentos.add(new SgDepartamento(3L, "San Miguel"));
        departamentos.add(new SgDepartamento(4L, "La Libertad"));
        departamentos.add(new SgDepartamento(5L, "Sonsonate"));
        return departamentos;
    }

    public void limpiar() {
        comboEstadoCivil.setSelected(-1);
        comboSexos.setSelected(-1);
        comboNacionalidad.setSelected(-1);
        comboPaisEmisor.setSelected(-1);
    }

    public void agregar() {
        JSFUtils.limpiarMensajesError();
        entidadEnEdicion = new SgIncorporacion();
    }

    public void actualizar(SgIncorporacion var) {
        JSFUtils.limpiarMensajesError();
        entidadEnEdicion = var;
        this.comboSexos.setSelectedT(entidadEnEdicion.getIncSexo());
        this.comboNacionalidad.setSelectedT(entidadEnEdicion.getIncNacionalidad());
        this.comboEstadoCivil.setSelectedT(entidadEnEdicion.getIncEstadoCivil());
        this.comboPaisEmisor.setSelectedT(entidadEnEdicion.getIncPasaportePaisEmisor());
    }

    public void guardar() {
        try {
            if (!this.soloLectura) {
                entidadEnEdicion.setIncSexo(this.comboSexos.getSelectedT());
                entidadEnEdicion.setIncEstadoCivil(this.comboEstadoCivil.getSelectedT());
                entidadEnEdicion.setIncNacionalidad(this.comboNacionalidad.getSelectedT());
                entidadEnEdicion.setIncPasaportePaisEmisor(this.comboPaisEmisor.getSelectedT());
                entidadEnEdicion = incorporacionClient.guardar(entidadEnEdicion);
            }
            JSFUtils.agregarInfo(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.GUARDADO_CORRECTO), "");
        } catch (BusinessException be) {
            JSFUtils.agregarMensajes(ConstantesComponentesId.ID_MSG_TEMPLATE, FacesMessage.SEVERITY_ERROR, be.getErrores());
        } catch (Exception ex) {
            // LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            JSFUtils.agregarError(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ERROR_GENERAL), "");
        }
    }

    public SgIncorporacion getEntidadEnEdicion() {
        return entidadEnEdicion;
    }

    public void setEntidadEnEdicion(SgIncorporacion entidadEnEdicion) {
        this.entidadEnEdicion = entidadEnEdicion;
    }

    public SofisComboG<SgSexo> getComboSexos() {
        return comboSexos;
    }

    public void setComboSexos(SofisComboG<SgSexo> comboSexos) {
        this.comboSexos = comboSexos;
    }

    public SofisComboG<SgNacionalidad> getComboNacionalidad() {
        return comboNacionalidad;
    }

    public void setComboNacionalidad(SofisComboG<SgNacionalidad> comboNacionalidad) {
        this.comboNacionalidad = comboNacionalidad;
    }

    public SofisComboG<SgEstadoCivil> getComboEstadoCivil() {
        return comboEstadoCivil;
    }

    public void setComboEstadoCivil(SofisComboG<SgEstadoCivil> comboEstadoCivil) {
        this.comboEstadoCivil = comboEstadoCivil;
    }

    public Boolean getSoloLectura() {
        return soloLectura;
    }

    public void setSoloLectura(Boolean soloLectura) {
        this.soloLectura = soloLectura;
    }

    public SofisComboG<SgPais> getComboPaisEmisor() {
        return comboPaisEmisor;
    }

    public void setComboPaisEmisor(SofisComboG<SgPais> comboPaisEmisor) {
        this.comboPaisEmisor = comboPaisEmisor;
    }

    public List<SgDepartamento> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<SgDepartamento> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public CatalogosRestClient getCatalogoClient() {
        return catalogoClient;
    }

    public void setCatalogoClient(CatalogosRestClient catalogoClient) {
        this.catalogoClient = catalogoClient;
    }

    public IncorporacionRestClient getIncorporacionClient() {
        return incorporacionClient;
    }

    public void setIncorporacionClient(IncorporacionRestClient incorporacionClient) {
        this.incorporacionClient = incorporacionClient;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public Long getIncId() {
        return incId;
    }

    public void setIncId(Long incId) {
        this.incId = incId;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public List<SgDocumento> getDocumentosSeleccionados() {
        return documentosSeleccionados;
    }

    public void setDocumentosSeleccionados(List<SgDocumento> documentosSeleccionados) {
        this.documentosSeleccionados = documentosSeleccionados;
    }

    public List<SgDocumento> getDocumentosDeIncorporacion() {
        return documentosDeIncorporacion;
    }

    public void setDocumentosDeIncorporacion(List<SgDocumento> documentosDeIncorporacion) {
        this.documentosDeIncorporacion = documentosDeIncorporacion;
    }

}
