package sv.gob.mined.siges.web.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = SgCertificacion.class)
public class SgCertificacion implements Serializable {

    private Long certificacionPK;
    private String centroEscolarFK;
    private int anio;
    private String grado;
    private String estudiante;

    public SgCertificacion() {
        // Constructor vacío necesario para JSF
    }

    public SgCertificacion(Long certificacionPK, String centroEscolarFK, int anio, String grado, String estudiante) {
        this.certificacionPK = certificacionPK;
        this.centroEscolarFK = centroEscolarFK;
        this.anio = anio;
        this.grado = grado;
        this.estudiante = estudiante;
    }

    // Getters y Setters
    public Long getCertificacionPK() {
        return certificacionPK;
    }

    public void setCertificacionPK(Long certificacionPK) {
        this.certificacionPK = certificacionPK;
    }

    public String getCentroEscolarFK() {
        return centroEscolarFK;
    }

    public void setCentroEscolarFK(String centroEscolarFK) {
        this.centroEscolarFK = centroEscolarFK;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }
}
