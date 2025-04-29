/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.gob.mined.siges.web.dto;

import java.util.Date;

/**
 *
 * @author tiffa
 */
public class SgLlenadoDeSolicitud {
    private String nombreSolicitante;
    private String personaAtiende;
    private String grado;
    private String institucionEducativa;
    private String bachilleratoEstudio;
    private String departamento;
    private String correoElectronico;
    private String telefono;
    private Date fechaNacimiento;
    private Integer anioFinalizacion;
    private String opcionBachillerato;
    private String municipio;
    private String observaciones;

    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public String getPersonaAtiende() {
        return personaAtiende;
    }

    public void setPersonaAtiende(String personaAtiende) {
        this.personaAtiende = personaAtiende;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getInstitucionEducativa() {
        return institucionEducativa;
    }

    public void setInstitucionEducativa(String institucionEducativa) {
        this.institucionEducativa = institucionEducativa;
    }

    public String getBachilleratoEstudio() {
        return bachilleratoEstudio;
    }

    public void setBachilleratoEstudio(String bachilleratoEstudio) {
        this.bachilleratoEstudio = bachilleratoEstudio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getAnioFinalizacion() {
        return anioFinalizacion;
    }

    public void setAnioFinalizacion(Integer anioFinalizacion) {
        this.anioFinalizacion = anioFinalizacion;
    }

    public String getOpcionBachillerato() {
        return opcionBachillerato;
    }

    public void setOpcionBachillerato(String opcionBachillerato) {
        this.opcionBachillerato = opcionBachillerato;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }




}
