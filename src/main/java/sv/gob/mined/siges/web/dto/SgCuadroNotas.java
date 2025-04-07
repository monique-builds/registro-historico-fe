/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.gob.mined.siges.web.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;

/**
 *
 * @author tiffa
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cuadroNotaPK", scope = SgCertificacion.class)
public class SgCuadroNotas  implements Serializable{

    private Long cuadroNotaPK;
    private SgEstudiante estudianteFK;
    private SgCentroEscolar centroEscolarFK;
    private Integer anio;
    private SgArchivo archivo;

    public Long getCuadroNotaPK() {
        return cuadroNotaPK;
    }

    public void setCuadroNotaPK(Long cuadroNotaPK) {
        this.cuadroNotaPK = cuadroNotaPK;
    }

    public SgEstudiante getEstudianteFK() {
        return estudianteFK;
    }

    public void setEstudianteFK(SgEstudiante estudianteFK) {
        this.estudianteFK = estudianteFK;
    }

    public SgCentroEscolar getCentroEscolarFK() {
        return centroEscolarFK;
    }

    public void setCentroEscolarFK(SgCentroEscolar centroEscolarFK) {
        this.centroEscolarFK = centroEscolarFK;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public SgArchivo getArchivo() {
        return archivo;
    }

    public void setArchivo(SgArchivo archivo) {
        this.archivo = archivo;
    }

    public SgCuadroNotas(Long cuadroNotaPK, SgEstudiante estudianteFK, SgCentroEscolar centroEscolarFK, Integer anio, SgArchivo archivo) {
        this.cuadroNotaPK = cuadroNotaPK;
        this.estudianteFK = estudianteFK;
        this.centroEscolarFK = centroEscolarFK;
        this.anio = anio;
        this.archivo = archivo;
    }

    public SgCuadroNotas() {
    }


}
