/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.gob.mined.siges.web.beans;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import sv.gob.mined.siges.web.dto.SgCertificacion;
import sv.gob.mined.siges.web.lazymodels.LazyPaginaDataModel;

/**
 *
 * @author tiffa
 */
@Named
@ViewScoped
public class CertificacionesBean implements Serializable {

    private Integer paginado = 10;
    private Long totalResultados;
    private LazyPaginaDataModel paginaLazyModel;
    
private List<SgCertificacion> certificaciones;
 @PostConstruct
    public void init() {
        certificaciones = new ArrayList<>();
        certificaciones.add(new SgCertificacion(1L, "Centro Educativo A", 2023, "Primer Grado", "Juan Pérez"));
        certificaciones.add(new SgCertificacion(2L, "Centro Educativo B", 2023, "Segundo Grado", "María López"));
        certificaciones.add(new SgCertificacion(3L, "Centro Educativo B", 2023, "Segundo Grado", "María López"));
        certificaciones.add(new SgCertificacion(4L, "Centro Educativo B", 2023, "Segundo Grado", "María López"));
        certificaciones.add(new SgCertificacion(5L, "Centro Educativo B", 2023, "Segundo Grado", "María López"));
        certificaciones.add(new SgCertificacion(6L, "Centro Educativo B", 2023, "Segundo Grado", "María López"));
        certificaciones.add(new SgCertificacion(7L, "Centro Educativo B", 2023, "Segundo Grado", "María López"));
        certificaciones.add(new SgCertificacion(8L, "Centro Educativo B", 2023, "Segundo Grado", "María López"));
        certificaciones.add(new SgCertificacion(9L, "Centro Educativo B", 2023, "Segundo Grado", "María López"));
        certificaciones.add(new SgCertificacion(10L, "Centro Educativo B", 2023, "Segundo Grado", "María López"));
        certificaciones.add(new SgCertificacion(11L, "Centro Educativo B", 2023, "Segundo Grado", "María López"));
        certificaciones.add(new SgCertificacion(12L, "Centro Educativo B", 2023, "Segundo Grado", "María López"));
        certificaciones.add(new SgCertificacion(13L, "Centro Educativo B", 2023, "Segundo Grado", "María López"));

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

    public void eliminar(CertificacionBean certificacion) {
        certificaciones.remove(certificacion);
    }

    public List<SgCertificacion> getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(List<SgCertificacion> certificaciones) {
        this.certificaciones = certificaciones;
    }



}
