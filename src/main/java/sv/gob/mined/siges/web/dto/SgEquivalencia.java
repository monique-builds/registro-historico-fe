/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.gob.mined.siges.web.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author tiffa
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "resolucionId", scope = SgCertificacion.class)
public class SgEquivalencia implements Serializable {

    private Long equivalenciaPk;
    private String nombres;
    private String apellidos;
    private String paisEstudio;
    private String correoElectronico;
    private Integer telefono;
    private String gradoExtranjero;
    private Integer ultimoAnioEstudio;
    private String municipioResidencia;
    private String nacionalidad;
    private Date fechaRecepcion;
    private Boolean convenioHaya;

    // Campos adicionales para funcionario
    private String gradoAMatricular;
    private String institucionExtranjera;
    private String ubicacionInstitucionExtranjera;
    private String observaciones;
    private String numeroResolucion;
    private Date fechaResolucion;
    private String estado; // PENDIENTE, EN_REVISION, COMPLETADA, RECHAZADA
    private Date fechaCreacion;

    public Long getEquivalenciaPk() {
        return equivalenciaPk;
    }

    public void setEquivalenciaPk(Long equivalenciaPk) {
        this.equivalenciaPk = equivalenciaPk;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPaisEstudio() {
        return paisEstudio;
    }

    public void setPaisEstudio(String paisEstudio) {
        this.paisEstudio = paisEstudio;
    }

    public String getGradoExtranjero() {
        return gradoExtranjero;
    }

    public void setGradoExtranjero(String gradoExtranjero) {
        this.gradoExtranjero = gradoExtranjero;
    }

    public Integer getUltimoAnioEstudio() {
        return ultimoAnioEstudio;
    }

    public void setUltimoAnioEstudio(Integer ultimoAnioEstudio) {
        this.ultimoAnioEstudio = ultimoAnioEstudio;
    }

    public String getMunicipioResidencia() {
        return municipioResidencia;
    }

    public void setMunicipioResidencia(String municipioResidencia) {
        this.municipioResidencia = municipioResidencia;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGradoAMatricular() {
        return gradoAMatricular;
    }

    public void setGradoAMatricular(String gradoAMatricular) {
        this.gradoAMatricular = gradoAMatricular;
    }

    public String getInstitucionExtranjera() {
        return institucionExtranjera;
    }

    public void setInstitucionExtranjera(String institucionExtranjera) {
        this.institucionExtranjera = institucionExtranjera;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Boolean getConvenioHaya() {
        return convenioHaya;
    }

    public void setConvenioHaya(Boolean convenioHaya) {
        this.convenioHaya = convenioHaya;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getUbicacionInstitucionExtranjera() {
        return ubicacionInstitucionExtranjera;
    }

    public void setUbicacionInstitucionExtranjera(String ubicacionInstitucionExtranjera) {
        this.ubicacionInstitucionExtranjera = ubicacionInstitucionExtranjera;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNumeroResolucion() {
        return numeroResolucion;
    }

    public void setNumeroResolucion(String numeroResolucion) {
        this.numeroResolucion = numeroResolucion;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }



    public SgEquivalencia() {
    }

}
