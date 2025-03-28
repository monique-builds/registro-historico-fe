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
 * @author tiffa
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = SgMarginacion.class)
public class SgMarginacion implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nombresSolicitante;
    private String apellidosSolicitante;
    private Date fechaRecepcion;
    private String correoElectronico;
    private String telefono;
    private String domicilio;
    private String nombreSegunPartidaMarginada;
    private String nombreSegunDocumentoAcademico;

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

}
