/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.gob.mined.siges.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import org.apache.commons.lang3.SerializationUtils;
import sv.gob.mined.siges.web.constantes.ConstantesComponentesId;
import sv.gob.mined.siges.web.dto.SgCertificacion;
import sv.gob.mined.siges.web.dto.centroseducativos.SgNivel;
import sv.gob.mined.siges.web.excepciones.BusinessException;
import sv.gob.mined.siges.web.mensajes.Mensajes;
import sv.gob.mined.siges.web.restclient.NivelRestClient;
import java.util.logging.Level;
import sv.gob.mined.siges.web.utilidades.JSFUtils;
import sv.gob.mined.siges.web.utilidades.SofisComboG;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.omnifaces.cdi.Param;
import sv.gob.mined.siges.web.dto.SgMateria;
import sv.gob.mined.siges.web.dto.catalogo.SgDepartamento;
import sv.gob.mined.siges.web.dto.catalogo.SgMunicipio;
import sv.gob.mined.siges.web.restclient.CertificacionRestClient;

/**
 *
 * @author tiffa
 */
@Named
@ViewScoped
public class CertificacionBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(CertificacionBean.class.getName());

    @Inject
    private NivelRestClient nivelClient;

    @Inject
    private CertificacionRestClient restClient;

    @Inject
    @Param(name = "id")
    private Long certificacionId;

    @Inject
    @Param(name = "edit")
    private Boolean editar;

    private SgCertificacion entidadEnEdicion = new SgCertificacion();

    private SofisComboG<SgNivel> comboNivel;
    private SofisComboG<SgDepartamento> comboDepartamento;
    private SofisComboG<SgMunicipio> comboMunicipio;

    // Lista de materias
    private List<SgMateria> materias = new ArrayList<>();

    // Objeto para la nueva materia
    private SgMateria nuevaMateria = new SgMateria();

    @PostConstruct
    public void init() {
        try {
            //cargarCombos();
            if (certificacionId != null) {
                this.actualizar(restClient.obtenerPorId(certificacionId));
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public void buscar() {
    }

    public void limpiar() {
        buscar();
    }

    public void agregar() {
        JSFUtils.limpiarMensajesError();
        entidadEnEdicion = new SgCertificacion();
    }

    public void agregarMateria() {
        if (nuevaMateria.getMateria() != null && !nuevaMateria.getMateria().trim().isEmpty()) {
            System.out.println("Agregando materia: " + nuevaMateria.getMateria());
            materias.add(new SgMateria(
                    nuevaMateria.getMateria(),
                    nuevaMateria.getArea(),
                    nuevaMateria.getResultado(),
                    nuevaMateria.getNota()
            ));
            nuevaMateria = new SgMateria();
        } else {
            System.out.println("La materia no puede estar vacía.");
        }
    }

    public void eliminarMateria(SgMateria materia) {
        if (materia != null) {
            materias.remove(materia);
        } else {
            System.out.println("No se ha seleccionado ninguna materia para eliminar.");
        }
    }

    public void actualizar(SgCertificacion var) {
        JSFUtils.limpiarMensajesError();
        entidadEnEdicion = (SgCertificacion) SerializationUtils.clone(var);
    }

    public void guardar() {
        try {
            // entidadEnEdicion.setCertificacionNivel(comboNivel.getSelectedT());
            entidadEnEdicion = restClient.guardar(entidadEnEdicion);
            JSFUtils.agregarInfo(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.GUARDADO_CORRECTO), "");
        } catch (BusinessException be) {
            JSFUtils.agregarMensajes(ConstantesComponentesId.ID_MSG_TEMPLATE, FacesMessage.SEVERITY_ERROR, be.getErrores());
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            JSFUtils.agregarError(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ERROR_GENERAL), "");
        }
    }

    public void eliminar() {
        try {
            restClient.eliminar(entidadEnEdicion.getCertificacionPK());
            JSFUtils.agregarInfo(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ELIMINADO_CORRECTO), "");
            buscar();
            entidadEnEdicion = null;
        } catch (BusinessException be) {
            JSFUtils.agregarMensajes(ConstantesComponentesId.ID_MSG_TEMPLATE, FacesMessage.SEVERITY_ERROR, be.getErrores());
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            JSFUtils.agregarError(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ERROR_GENERAL), "");
        }
    }

    public SofisComboG<SgNivel> getComboNivel() {
        return comboNivel;
    }

    public void setComboNivel(SofisComboG<SgNivel> comboNivel) {
        this.comboNivel = comboNivel;
    }

    public CertificacionRestClient getRestClient() {
        return restClient;
    }

    public void setRestClient(CertificacionRestClient restClient) {
        this.restClient = restClient;
    }

    public SgCertificacion getEntidadEnEdicion() {
        return entidadEnEdicion;
    }

    public void setEntidadEnEdicion(SgCertificacion entidadEnEdicion) {
        this.entidadEnEdicion = entidadEnEdicion;
    }

    public SofisComboG<SgDepartamento> getComboDepartamento() {
        return comboDepartamento;
    }

    public void setComboDepartamento(SofisComboG<SgDepartamento> comboDepartamento) {
        this.comboDepartamento = comboDepartamento;
    }

    public SofisComboG<SgMunicipio> getComboMunicipio() {
        return comboMunicipio;
    }

    public void setComboMunicipio(SofisComboG<SgMunicipio> comboMunicipio) {
        this.comboMunicipio = comboMunicipio;
    }

    public List<SgMateria> getMaterias() {
        return materias;
    }

    public void setMaterias(List<SgMateria> materias) {
        this.materias = materias;
    }

    public SgMateria getNuevaMateria() {
        return nuevaMateria;
    }

    public void setNuevaMateria(SgMateria nuevaMateria) {
        this.nuevaMateria = nuevaMateria;
    }

    public NivelRestClient getNivelClient() {
        return nivelClient;
    }

    public void setNivelClient(NivelRestClient nivelClient) {
        this.nivelClient = nivelClient;
    }

    public Boolean getEditar() {
        return editar;
    }

    public void setEditar(Boolean editar) {
        this.editar = editar;
    }

}
