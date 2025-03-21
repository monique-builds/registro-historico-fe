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
import sv.gob.mined.siges.web.constantes.ConstantesComponentesId;
import sv.gob.mined.siges.web.dto.SgCertificacion;
import sv.gob.mined.siges.web.excepciones.BusinessException;
import sv.gob.mined.siges.web.lazymodels.LazyPaginaDataModel;
import sv.gob.mined.siges.web.mensajes.Mensajes;
import sv.gob.mined.siges.web.restclient.CertificacionRestClient;
import sv.gob.mined.siges.web.utilidades.JSFUtils;
import java.util.logging.Logger;
import org.apache.commons.lang3.SerializationUtils;

/**
 *
 * @author monique-builds
 */
@Named
@ViewScoped
public class CertificacionesBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(CertificacionesBean.class.getName());

    private Integer paginado = 10;
    private Long totalResultados;
    private LazyPaginaDataModel paginaLazyModel;

    private List<SgCertificacion> certificaciones;
    private SgCertificacion entidadEnEdicion = new SgCertificacion();

    @Inject
    private CertificacionRestClient restClient;

    @PostConstruct
    public void init() {
        certificaciones = new ArrayList<>();
//        certificaciones.add(new SgCertificacion(1L, "Centro Educativo A", 2023, "Primer Grado", "Juan Pérez", "123456", new SgNivel(), "Sin observaciones", new SgDepartamento(), new SgMunicipio()));
//        certificaciones.add(new SgCertificacion(2L, "Centro Educativo B", 2023, "Segundo Grado", "María López", "654321", new SgNivel(), "Observación especial" , new SgDepartamento(), new SgMunicipio()));
//        certificaciones.add(new SgCertificacion(3L, "Centro Educativo C", 2022, "Tercer Grado", "Carlos Gómez", "789012", new SgNivel(), "Requiere revisión", new SgDepartamento(), new SgMunicipio()));
//        certificaciones.add(new SgCertificacion(4L, "Centro Educativo D", 2021, "Cuarto Grado", "Ana Torres", "890123", new SgNivel(), "Certificado en proceso", new SgDepartamento(), new SgMunicipio()));
//        certificaciones.add(new SgCertificacion(5L, "Centro Educativo E", 2020, "Quinto Grado", "Luis Martínez", "901234", new SgNivel(), "Entregado correctamente", new SgDepartamento(), new SgMunicipio()));
//        certificaciones.add(new SgCertificacion(6L, "Centro Educativo F", 2019, "Sexto Grado", "Sofía Herrera", "012345", new SgNivel(), "Pendiente de firma", new SgDepartamento(), new SgMunicipio()));
//        certificaciones.add(new SgCertificacion(7L, "Centro Educativo G", 2018, "Séptimo Grado", "David Castro", "543210", new SgNivel(), "En revisión", new SgDepartamento(), new SgMunicipio()));
//        certificaciones.add(new SgCertificacion(8L, "Centro Educativo H", 2017, "Octavo Grado", "Paula Rivas", "678901", new SgNivel(), "Requiere modificación", new SgDepartamento(), new SgMunicipio()));
//        certificaciones.add(new SgCertificacion(9L, "Centro Educativo I", 2016, "Noveno Grado", "Fernando Salinas", "234567", new SgNivel(), "Aprobado", new SgDepartamento(), new SgMunicipio()));
//        certificaciones.add(new SgCertificacion(10L, "Centro Educativo J", 2015, "Décimo Grado", "Elena Mendoza", "345678", new SgNivel(), "Listo para entrega", new SgDepartamento(), new SgMunicipio()));
//        certificaciones.add(new SgCertificacion(11L, "Centro Educativo K", 2014, "Undécimo Grado", "Gabriel Ortiz", "456789", new SgNivel(), "Duplicado generado", new SgDepartamento(), new SgMunicipio()));
//        certificaciones.add(new SgCertificacion(12L, "Centro Educativo L", 2013, "Duodécimo Grado", "Andrea Navarro", "567890", new SgNivel(), "Sin observaciones", new SgDepartamento(), new SgMunicipio()));
//        certificaciones.add(new SgCertificacion(13L, "Centro Educativo M", 2012, "Educación Media", "Manuel Flores", "678901", new SgNivel(), "Esperando confirmación", new SgDepartamento(), new SgMunicipio()));

        certificaciones.add(new SgCertificacion(1L, "Centro Educativo A", 2023, "Primer Grado", "Juan Pérez", "123456", "Nivel", "Sin observaciones", "Departamento 1", "Municipio 1"));
        certificaciones.add(new SgCertificacion(2L, "Centro Educativo B", 2023, "Segundo Grado", "María López", "654321", "Nivel", "Observación especial", "Departamento 2", "Municipio 2"));
        certificaciones.add(new SgCertificacion(3L, "Centro Educativo C", 2022, "Tercer Grado", "Carlos Gómez", "789012", "Nivel", "Requiere revisión", "Departamento 3", "Municipio 3"));
        certificaciones.add(new SgCertificacion(4L, "Centro Educativo D", 2021, "Cuarto Grado", "Ana Torres", "890123", "Nivel", "Certificado en proceso", "Departamento 4", "Municipio 4"));
        certificaciones.add(new SgCertificacion(5L, "Centro Educativo E", 2020, "Quinto Grado", "Luis Martínez", "901234", "Nivel", "Entregado correctamente", "Departamento 5", "Municipio 5"));
        certificaciones.add(new SgCertificacion(6L, "Centro Educativo F", 2019, "Sexto Grado", "Sofía Herrera", "012345", "Nivel", "Pendiente de firma", "Departamento 6", "Municipio 6"));
        certificaciones.add(new SgCertificacion(7L, "Centro Educativo G", 2018, "Séptimo Grado", "David Castro", "543210", "Nivel", "En revisión", "Departamento 7", "Municipio 7"));
        certificaciones.add(new SgCertificacion(8L, "Centro Educativo H", 2017, "Octavo Grado", "Paula Rivas", "678901", "Nivel", "Requiere modificación", "Departamento 8", "Municipio 8"));
        certificaciones.add(new SgCertificacion(9L, "Centro Educativo I", 2016, "Noveno Grado", "Fernando Salinas", "234567", "Nivel", "Aprobado", "Departamento 9", "Municipio 9"));
        certificaciones.add(new SgCertificacion(10L, "Centro Educativo J", 2015, "Décimo Grado", "Elena Mendoza", "345678", "Nivel", "Listo para entrega", "Departamento 10", "Municipio 10"));
//        certificaciones.add(new SgCertificacion(11L, "Centro Educativo K", 2014, "Undécimo Grado", "Gabriel Ortiz", "456789", "Nivel", "Duplicado generado", "Departamento 11", "Municipio 11"));
//        certificaciones.add(new SgCertificacion(12L, "Centro Educativo L", 2013, "Duodécimo Grado", "Andrea Navarro", "567890", "Nivel", "Sin observaciones", "Departamento 12", "Municipio 12"));
//        certificaciones.add(new SgCertificacion(13L, "Centro Educativo M", 2012, "Educación Media", "Manuel Flores", "678901", "Nivel", "Esperando confirmación", "Departamento 13", "Municipio 13"));

    }

    public void actualizar(SgCertificacion var) {
        JSFUtils.limpiarMensajesError();
        entidadEnEdicion = (SgCertificacion) SerializationUtils.clone(var);
    }


    public void eliminar() {
        try {
            restClient.eliminar(entidadEnEdicion.getCertificacionPK());
            JSFUtils.agregarInfo(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ELIMINADO_CORRECTO), "");
            //buscar();
            entidadEnEdicion = null;
        } catch (BusinessException be) {
            JSFUtils.agregarMensajes(ConstantesComponentesId.ID_MSG_TEMPLATE, FacesMessage.SEVERITY_ERROR, be.getErrores());
        } catch (Exception ex) {
            //LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            JSFUtils.agregarError(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ERROR_GENERAL), "");
        }
    }

    public LazyPaginaDataModel getPaginaLazyModel() {
        return paginaLazyModel;
    }

    public void setPaginaLazyModel(LazyPaginaDataModel paginaLazyModel) {
        this.paginaLazyModel = paginaLazyModel;
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

    public List<SgCertificacion> getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(List<SgCertificacion> certificaciones) {
        this.certificaciones = certificaciones;
    }

    public SgCertificacion getEntidadEnEdicion() {
        return entidadEnEdicion;
    }

    public void setEntidadEnEdicion(SgCertificacion entidadEnEdicion) {
        this.entidadEnEdicion = entidadEnEdicion;
    }

    public CertificacionRestClient getRestClient() {
        return restClient;
    }

    public void setRestClient(CertificacionRestClient restClient) {
        this.restClient = restClient;
    }

}
