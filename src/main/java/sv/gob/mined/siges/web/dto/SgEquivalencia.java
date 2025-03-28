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

    private Long resolucionId;
    private String nombres;
    private String apellidos;
    private String paisEstudio;
    private String correoElectronico;
    private Integer telefono;
    private String gradoExtranjero;
    private Integer ultimoAnioEstudio;
    private String municipioResidencia;
    private String nacionalidad;
    private String gradoAMatricular;
    private String institucionExtranjera;
    private Date fechaRecepcion;
    private Boolean convenioHaya;

    public Long getResolucionId() {
        return resolucionId;
    }

    public void setResolucionId(Long resolucionId) {
        this.resolucionId = resolucionId;
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



    public SgEquivalencia() {
    }




}
