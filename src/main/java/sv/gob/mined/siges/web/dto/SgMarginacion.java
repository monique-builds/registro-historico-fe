package sv.gob.mined.siges.web.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.List;

/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author monique-builds 
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = SgMarginacion.class)
public class SgMarginacion implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nombresSolicitante;
    private String apellidosSolicitante;
    private String correoElectronico;
    private String telefono;
    private Date fechaRecepcion;
    private String nombreSegunPartidaMarginada;
    private String nombreSegunDocumentoAcademico;
    private String domicilio;

    //Datos ingresados por funcionario;
    private String dui;
    private String documentoAMarginar;
    private String datosDelDocumentoAMarginar;
    private String centroEducativo;
    private String datosDePartidaDeNacimiento;
    private String alcaldiaMunicipal;
    private String anioPartidaNacimiento;
    private String nombreCorrecto;
    private Date fechaExtensionPartidaNacimiento;
    private Date fechaMarginacion;  //Marginación por fecha de marginación
    private Date fechaAcuerdo;
    private Date fechaResolucion;
    private String observaciones;

    //Datos sistema
    private String numeroReferencia;
    private String elaborado;

   //Estado de la solicitud
   private String estadoSolicitud; //pendiente, en revision, aprovada, rechazada, cancelada

    private List<SgDocumento> documentos;

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public List<SgDocumento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<SgDocumento> documentos) {
        this.documentos = documentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SgMarginacion other = (SgMarginacion) obj;
        return Objects.equals(id, other.id);
    }

    public String getNombresSolicitante() {
        return nombresSolicitante;
    }

    public void setNombresSolicitante(String nombresSolicitante) {
        this.nombresSolicitante = nombresSolicitante;
    }

    public String getApellidosSolicitante() {
        return apellidosSolicitante;
    }

    public void setApellidosSolicitante(String apellidosSolicitante) {
        this.apellidosSolicitante = apellidosSolicitante;
    }

    public String getNombreSegunPartidaMarginada() {
        return nombreSegunPartidaMarginada;
    }

    public void setNombreSegunPartidaMarginada(String nombreSegunPartidaMarginada) {
        this.nombreSegunPartidaMarginada = nombreSegunPartidaMarginada;
    }

    public String getNombreSegunDocumentoAcademico() {
        return nombreSegunDocumentoAcademico;
    }

    public void setNombreSegunDocumentoAcademico(String nombreSegunDocumentoAcademico) {
        this.nombreSegunDocumentoAcademico = nombreSegunDocumentoAcademico;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getDocumentoAMarginar() {
        return documentoAMarginar;
    }

    public void setDocumentoAMarginar(String documentoAMarginar) {
        this.documentoAMarginar = documentoAMarginar;
    }

    public String getDatosDelDocumentoAMarginar() {
        return datosDelDocumentoAMarginar;
    }

    public void setDatosDelDocumentoAMarginar(String datosDelDocumentoAMarginar) {
        this.datosDelDocumentoAMarginar = datosDelDocumentoAMarginar;
    }

    public String getCentroEducativo() {
        return centroEducativo;
    }

    public void setCentroEducativo(String centroEducativo) {
        this.centroEducativo = centroEducativo;
    }

    public String getDatosDePartidaDeNacimiento() {
        return datosDePartidaDeNacimiento;
    }

    public void setDatosDePartidaDeNacimiento(String datosDePartidaDeNacimiento) {
        this.datosDePartidaDeNacimiento = datosDePartidaDeNacimiento;
    }

    public String getAlcaldiaMunicipal() {
        return alcaldiaMunicipal;
    }

    public void setAlcaldiaMunicipal(String alcaldiaMunicipal) {
        this.alcaldiaMunicipal = alcaldiaMunicipal;
    }

    public String getAnioPartidaNacimiento() {
        return anioPartidaNacimiento;
    }

    public void setAnioPartidaNacimiento(String anioPartidaNacimiento) {
        this.anioPartidaNacimiento = anioPartidaNacimiento;
    }

    public String getNombreCorrecto() {
        return nombreCorrecto;
    }

    public void setNombreCorrecto(String nombreCorrecto) {
        this.nombreCorrecto = nombreCorrecto;
    }

    public Date getFechaExtensionPartidaNacimiento() {
        return fechaExtensionPartidaNacimiento;
    }

    public void setFechaExtensionPartidaNacimiento(Date fechaExtensionPartidaNacimiento) {
        this.fechaExtensionPartidaNacimiento = fechaExtensionPartidaNacimiento;
    }

    public Date getFechaMarginacion() {
        return fechaMarginacion;
    }

    public void setFechaMarginacion(Date fechaMarginacion) {
        this.fechaMarginacion = fechaMarginacion;
    }

    public Date getFechaAcuerdo() {
        return fechaAcuerdo;
    }

    public void setFechaAcuerdo(Date fechaAcuerdo) {
        this.fechaAcuerdo = fechaAcuerdo;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setNumeroReferencia(String numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

    public String getElaborado() {
        return elaborado;
    }

    public void setElaborado(String elaborado) {
        this.elaborado = elaborado;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }



}
