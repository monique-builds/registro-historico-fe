package sv.gob.mined.siges.web.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import sv.gob.mined.siges.web.dto.catalogo.SgDepartamento;
import sv.gob.mined.siges.web.dto.catalogo.SgMunicipio;
import sv.gob.mined.siges.web.dto.centroseducativos.SgNivel;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = SgCertificacion.class)
public class SgCertificacion implements Serializable {

    private Long certificacionPK;
    private String centroEscolarFK;
    private int anio;
    private String grado;
    private String estudiante;
    private String nie;
    private String certiObservaciones;
//    private SgDepartamento certiDepartamento;
//    private SgMunicipio certiMunicipio;
//    private SgNivel certificacionNivel;
    private String certiDepartamento;
    private String certiMunicipio;
    private String certificacionNivel;

    private List<SgMateria> materias = new ArrayList<>();

    public SgCertificacion() {
        // Constructor vacío necesario para JSF
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

    public String getCertificacionNivel() {
        return certificacionNivel;
    }

    public void setCertificacionNivel(String certificacionNivel) {
        this.certificacionNivel = certificacionNivel;
    }

    public String getCertiObservaciones() {
        return certiObservaciones;
    }

    public void setCertiObservaciones(String certiObservaciones) {
        this.certiObservaciones = certiObservaciones;
    }

    public String getNie() {
        return nie;
    }

    public void setNie(String nie) {
        this.nie = nie;
    }

    public String getCertiDepartamento() {
        return certiDepartamento;
    }

    public void setCertiDepartamento(String certiDepartamento) {
        this.certiDepartamento = certiDepartamento;
    }

    public String getCertiMunicipio() {
        return certiMunicipio;
    }

    public void setCertiMunicipio(String certiMunicipio) {
        this.certiMunicipio = certiMunicipio;
    }

    public List<SgMateria> getMaterias() {
        return materias;
    }

    public void setMaterias(List<SgMateria> materias) {
        this.materias = materias;
    }

    public SgCertificacion(Long certificacionPK, String centroEscolarFK, int anio, String grado, String estudiante, String nie, String certificacionNivel, String certiObservaciones, String certiDepartamento, String certiMunicipio) {
        this.certificacionPK = certificacionPK;
        this.centroEscolarFK = centroEscolarFK;
        this.anio = anio;
        this.grado = grado;
        this.estudiante = estudiante;
        this.nie = nie;
        this.certificacionNivel = certificacionNivel;
        this.certiObservaciones = certiObservaciones;
        this.certiDepartamento = certiDepartamento;
        this.certiMunicipio = certiMunicipio;
    }

}
