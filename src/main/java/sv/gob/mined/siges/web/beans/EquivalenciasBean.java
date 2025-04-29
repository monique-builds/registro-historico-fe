package sv.gob.mined.siges.web.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.PrimeFaces;
import sv.gob.mined.siges.web.constantes.ConstantesComponentesId;
import sv.gob.mined.siges.web.dto.SgEquivalencia;
import sv.gob.mined.siges.web.excepciones.BusinessException;
import sv.gob.mined.siges.web.filtrosbusqueda.FiltroEquivalencia;
import sv.gob.mined.siges.web.filtrosbusqueda.FiltroNombreCompleto;
import sv.gob.mined.siges.web.lazymodels.LazyEquivalenciaDataModel;
import sv.gob.mined.siges.web.mensajes.Mensajes;
import sv.gob.mined.siges.web.restclient.EquivalenciaRestClient;
import sv.gob.mined.siges.web.utilidades.JSFUtils;

/**
 *
 * @author tiffa
 */
@Named
@ViewScoped
public class EquivalenciasBean implements Serializable {
//private static final Logger LOGGER = Logger.getLogger(EquivalenciasBean.class.getName());

    @Inject
    private EquivalenciaRestClient restClient;

    private FiltroEquivalencia filtro = new FiltroEquivalencia();
    private SgEquivalencia entidadEnEdicion = new SgEquivalencia();
    private Integer paginado = 10;
    private Long totalResultados;
    private LazyEquivalenciaDataModel equivalenciaLazyModel;
    private FiltroNombreCompleto filtroNombreCompleto = new FiltroNombreCompleto();

    private String rolUsuario; // "USUARIO" o "ADMINISTRADOR"
    private boolean modoEdicionAdmin = false;

    public EquivalenciasBean() {
    }

    @PostConstruct
    public void init() {
        try {
            this.rolUsuario = obtenerRolUsuario();
            this.modoEdicionAdmin = "ADMINISTRADOR".equals(rolUsuario);

            cargarCombos();
            buscar();
        } catch (Exception ex) {
            // LOGGER.log(Level.SEVERE, "Error during initialization: " + ex.getMessage(), ex);
            JSFUtils.agregarError(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ERROR_GENERAL), "");
        }
    }

    private String obtenerRolUsuario() {
        // Implementación real para obtener el rol del usuario
        // Ejemplo usando SecurityContext (depende de tu implementación de seguridad)
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getExternalContext().isUserInRole("ADMINISTRADOR")) {
            return "ADMINISTRADOR";
        }
        return "USUARIO";
    }

    public boolean isModoEdicionAdmin() {
        return modoEdicionAdmin;
    }

    public void cargarCombos() {
        // Implement logic to load combos if needed
    }

    private void limpiarCombos() {
        // Implement logic to clear combos if needed
    }

    public void buscar() {
        try {
            // Ensure the filter is not null
            if (filtro == null) {
                filtro = new FiltroEquivalencia();
            }

            // Ensure the restClient is properly initialized
            if (restClient == null) {
                // LOGGER.log(Level.SEVERE, "RestClient is not initialized");
                throw new IllegalStateException("RestClient is not initialized");
            }

            // Call the REST client to get the total results
            totalResultados = restClient.buscarTotal(filtro);

            // Initialize the lazy data model
            equivalenciaLazyModel = new LazyEquivalenciaDataModel(restClient, filtro, totalResultados, paginado);
        } catch (Exception ex) {
            // LOGGER.log(Level.SEVERE, "Error in buscar method: " + ex.getMessage(), ex);
            JSFUtils.agregarError(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ERROR_GENERAL), "");
        }
    }

    public void filtroNombreCompletoSeleccionar(FiltroNombreCompleto filtroNombre) {
        if (filtroNombre != null) {
            filtro.setPrimerNombre(filtroNombre.getPerPrimerNombre());
            filtro.setSegundoNombre(filtroNombre.getPerSegundoNombre());
            filtro.setTercerNombre(filtroNombre.getPerTercerNombre());
            filtro.setPrimerApellido(filtroNombre.getPerPrimerApellido());
            filtro.setSegundoApellido(filtroNombre.getPerSegundoApellido());
            filtro.setTercerApellido(filtroNombre.getPerTercerApellido());
            if (!StringUtils.isBlank(filtroNombre.getNombreCompleto())) {
                filtro.setNombreCompleto(null);
            }
        }
        PrimeFaces.current().ajax().update("form:pnlSearch");
    }

    public void eliminar() {
        try {
            if (entidadEnEdicion == null || entidadEnEdicion.getEquivalenciaPk() == null) {
                // LOGGER.log(Level.SEVERE, "Entity to delete is null or has no primary key");
                JSFUtils.agregarError(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ERROR_GENERAL), "");
                return;
            }

            restClient.eliminar(entidadEnEdicion.getEquivalenciaPk());
            JSFUtils.agregarInfo(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ELIMINADO_CORRECTO), "");
            buscar();
            entidadEnEdicion = null;
        } catch (BusinessException be) {
            JSFUtils.agregarMensajes(ConstantesComponentesId.ID_MSG_TEMPLATE, FacesMessage.SEVERITY_ERROR, be.getErrores());
        } catch (Exception ex) {
            // LOGGER.log(Level.SEVERE, "Error in eliminar method: " + ex.getMessage(), ex);
            JSFUtils.agregarError(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ERROR_GENERAL), "");
        }
    }

    public void actualizar(SgEquivalencia var) {
        JSFUtils.limpiarMensajesError();
        entidadEnEdicion = var;
    }

    public EquivalenciaRestClient getRestClient() {
        return restClient;
    }

    public void setRestClient(EquivalenciaRestClient restClient) {
        this.restClient = restClient;
    }

    public FiltroEquivalencia getFiltro() {
        return filtro;
    }

    public void setFiltro(FiltroEquivalencia filtro) {
        this.filtro = filtro;
    }

    public SgEquivalencia getEntidadEnEdicion() {
        return entidadEnEdicion;
    }

    public void setEntidadEnEdicion(SgEquivalencia entidadEnEdicion) {
        this.entidadEnEdicion = entidadEnEdicion;
    }

    public Integer getPaginado() {
        return paginado;
    }

    public void setPaginado(Integer paginado) {
        this.paginado = paginado;
    }

    public Long getTotalResultados() {
        return totalResultados;
    }

    public void setTotalResultados(Long totalResultados) {
        this.totalResultados = totalResultados;
    }

    public LazyEquivalenciaDataModel getEquivalenciaLazyModel() {
        return equivalenciaLazyModel;
    }

    public void setEquivalenciaLazyModel(LazyEquivalenciaDataModel equivalenciaLazyModel) {
        this.equivalenciaLazyModel = equivalenciaLazyModel;
    }

    public FiltroNombreCompleto getFiltroNombreCompleto() {
        return filtroNombreCompleto;
    }

    public void setFiltroNombreCompleto(FiltroNombreCompleto filtroNombreCompleto) {
        this.filtroNombreCompleto = filtroNombreCompleto;
    }

}
