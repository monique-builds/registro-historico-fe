/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.gob.mined.siges.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.PrimeFaces;
import sv.gob.mined.siges.web.constantes.ConstantesComponentesId;
import sv.gob.mined.siges.web.dto.SgMarginacion;
import sv.gob.mined.siges.web.excepciones.BusinessException;
import sv.gob.mined.siges.web.filtrosbusqueda.FiltroMarginacion;
import sv.gob.mined.siges.web.filtrosbusqueda.FiltroNombreCompleto;
import sv.gob.mined.siges.web.lazymodels.LazyMarginacionDataModel;
import sv.gob.mined.siges.web.mensajes.Mensajes;
import sv.gob.mined.siges.web.restclient.MarginacionRestClient;
import sv.gob.mined.siges.web.utilidades.JSFUtils;

/**
 *
 * @author tiffa
 */
@Named
@ViewScoped
public class MarginacionesBean implements Serializable{
    //private static final Logger LOGGER = Logger.getLogger(MarginacionesBean.class.getName());

    @Inject
    private MarginacionRestClient restClient;

    private FiltroMarginacion filtro = new FiltroMarginacion();
    private SgMarginacion entidadEnEdicion = new SgMarginacion();
    private Integer paginado = 10;
    private Long totalResultados;
    private LazyMarginacionDataModel marginacionLazyModel;
    private FiltroNombreCompleto filtroNombreCompleto = new FiltroNombreCompleto();

    public MarginacionesBean() {
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
                filtro = new FiltroMarginacion();
            }

            // Ensure the restClient is properly initialized
            if (restClient == null) {
                // LOGGER.log(Level.SEVERE, "RestClient is not initialized");
                throw new IllegalStateException("RestClient is not initialized");
            }

            // Call the REST client to get the total results
            totalResultados = restClient.buscarTotal(filtro);

            // Initialize the lazy data model
            marginacionLazyModel = new LazyMarginacionDataModel(restClient, filtro, totalResultados, paginado);
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
            if (entidadEnEdicion == null || entidadEnEdicion.getId() == null) {
                // LOGGER.log(Level.SEVERE, "Entity to delete is null or has no primary key");
                JSFUtils.agregarError(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ERROR_GENERAL), "");
                return;
            }

            restClient.eliminar(entidadEnEdicion.getId());
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

    public void actualizar(SgMarginacion var) {
        JSFUtils.limpiarMensajesError();
        entidadEnEdicion = var;
    }

    public MarginacionRestClient getRestClient() {
        return restClient;
    }

    public void setRestClient(MarginacionRestClient restClient) {
        this.restClient = restClient;
    }

    public FiltroMarginacion getFiltro() {
        return filtro;
    }

    public void setFiltro(FiltroMarginacion filtro) {
        this.filtro = filtro;
    }

    public SgMarginacion getEntidadEnEdicion() {
        return entidadEnEdicion;
    }

    public void setEntidadEnEdicion(SgMarginacion entidadEnEdicion) {
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

    public LazyMarginacionDataModel getMarginacionLazyModel() {
        return marginacionLazyModel;
    }

    public void setMarginacionLazyModel(LazyMarginacionDataModel marginacionLazyModel) {
        this.marginacionLazyModel = marginacionLazyModel;
    }

    public FiltroNombreCompleto getFiltroNombreCompleto() {
        return filtroNombreCompleto;
    }

    public void setFiltroNombreCompleto(FiltroNombreCompleto filtroNombreCompleto) {
        this.filtroNombreCompleto = filtroNombreCompleto;
    }




}
