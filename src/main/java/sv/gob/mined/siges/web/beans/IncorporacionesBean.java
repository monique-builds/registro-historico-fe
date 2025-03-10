/*
 *  SIGES
 *  Desarrollado por Sofis Solutions
 */
package sv.gob.mined.siges.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
// import java.util.logging.Level;
// import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.PrimeFaces;
import sv.gob.mined.siges.web.constantes.ConstantesComponentesId;
import sv.gob.mined.siges.web.dto.RevHistorico;
import sv.gob.mined.siges.web.dto.SgIncorporacion;
import sv.gob.mined.siges.web.excepciones.BusinessException;
import sv.gob.mined.siges.web.filtrosbusqueda.FiltroIncorporacion;
import sv.gob.mined.siges.web.filtrosbusqueda.FiltroNombreCompleto;
import sv.gob.mined.siges.web.lazymodels.LazyIncorporacionDataModel;
import sv.gob.mined.siges.web.mensajes.Mensajes;
import sv.gob.mined.siges.web.restclient.IncorporacionRestClient;
import sv.gob.mined.siges.web.utilidades.JSFUtils;

/**
 *
 * @author Sofis Solutions
 */
@Named
@ViewScoped
public class IncorporacionesBean implements Serializable {

    // private static final Logger LOGGER = Logger.getLogger(IncorporacionesBean.class.getName());

    @Inject
    private IncorporacionRestClient restClient; // Ensure this is properly injected and initialized

    private FiltroIncorporacion filtro = new FiltroIncorporacion();
    private SgIncorporacion entidadEnEdicion = new SgIncorporacion();
    private List<RevHistorico> historialIncorporacion = new ArrayList<>();
    private Integer paginado = 10;
    private Long totalResultados;
    private LazyIncorporacionDataModel incorporacionLazyModel;
    private FiltroNombreCompleto filtroNombreCompleto = new FiltroNombreCompleto();

    public IncorporacionesBean() {
    }

    @PostConstruct
    public void init() {
        try {
            cargarCombos();
            buscar();
        } catch (Exception ex) {
            // LOGGER.log(Level.SEVERE, "Error during initialization: " + ex.getMessage(), ex);
            JSFUtils.agregarError(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ERROR_GENERAL), "");
        }
    }

    public void buscar() {
        try {
            // Ensure the filter is not null
            if (filtro == null) {
                filtro = new FiltroIncorporacion();
            }

            // Ensure the restClient is properly initialized
            if (restClient == null) {
                // LOGGER.log(Level.SEVERE, "RestClient is not initialized");
                throw new IllegalStateException("RestClient is not initialized");
            }

            // Call the REST client to get the total results
            totalResultados = restClient.buscarTotal(filtro);

            // Initialize the lazy data model
            incorporacionLazyModel = new LazyIncorporacionDataModel(restClient, filtro, totalResultados, paginado);
        } catch (Exception ex) {
            // LOGGER.log(Level.SEVERE, "Error in buscar method: " + ex.getMessage(), ex);
            JSFUtils.agregarError(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ERROR_GENERAL), "");
        }
    }

    public void cargarCombos() {
        // Implement logic to load combos if needed
    }

    private void limpiarCombos() {
        // Implement logic to clear combos if needed
    }

    public void limpiar() {
        filtro = new FiltroIncorporacion();
        buscar();
    }

    public void agregar() {
        JSFUtils.limpiarMensajesError();
        limpiarCombos();
        entidadEnEdicion = new SgIncorporacion();
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
            if (entidadEnEdicion == null || entidadEnEdicion.getIncPk() == null) {
                // LOGGER.log(Level.SEVERE, "Entity to delete is null or has no primary key");
                JSFUtils.agregarError(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ERROR_GENERAL), "");
                return;
            }

            restClient.eliminar(entidadEnEdicion.getIncPk());
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

    public void actualizar(SgIncorporacion var) {
        JSFUtils.limpiarMensajesError();
        entidadEnEdicion = var;
    }

    public void historial(Long id) {
        try {
            if (id == null) {
                // LOGGER.log(Level.SEVERE, "ID for historial is null");
                JSFUtils.agregarError(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ERROR_GENERAL), "");
                return;
            }

            historialIncorporacion = restClient.obtenerHistorialPorId(id);
        } catch (Exception ex) {
            // LOGGER.log(Level.SEVERE, "Error in historial method: " + ex.getMessage(), ex);
            JSFUtils.agregarError(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ERROR_GENERAL), "");
        }
    }

    // Getters and Setters
    public FiltroIncorporacion getFiltro() {
        return filtro;
    }

    public void setFiltro(FiltroIncorporacion filtro) {
        this.filtro = filtro;
    }

    public SgIncorporacion getEntidadEnEdicion() {
        return entidadEnEdicion;
    }

    public void setEntidadEnEdicion(SgIncorporacion entidadEnEdicion) {
        this.entidadEnEdicion = entidadEnEdicion;
    }

    public List<RevHistorico> getHistorialIncorporacion() {
        return historialIncorporacion;
    }

    public void setHistorialIncorporacion(List<RevHistorico> historialIncorporacion) {
        this.historialIncorporacion = historialIncorporacion;
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

    public LazyIncorporacionDataModel getIncorporacionLazyModel() {
        return incorporacionLazyModel;
    }

    public void setIncorporacionLazyModel(LazyIncorporacionDataModel incorporacionLazyModel) {
        this.incorporacionLazyModel = incorporacionLazyModel;
    }

    public FiltroNombreCompleto getFiltroNombreCompleto() {
        return filtroNombreCompleto;
    }

    public void setFiltroNombreCompleto(FiltroNombreCompleto filtroNombreCompleto) {
        this.filtroNombreCompleto = filtroNombreCompleto;
    }
}