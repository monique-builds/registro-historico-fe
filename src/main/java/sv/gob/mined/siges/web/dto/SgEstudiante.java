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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "estudiantePK", scope = SgEstudiante.class)
public class SgEstudiante implements Serializable {
    private Long estudiantePK;
    private String nombres;
    private String apellidos;

    public Long getEstudiantePK() {
        return estudiantePK;
    }

    public void setEstudiantePK(Long estudiantePK) {
        this.estudiantePK = estudiantePK;
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

    public SgEstudiante(Long estudiantePK, String nombres, String apellidos) {
        this.estudiantePK = estudiantePK;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public SgEstudiante() {
    }



}
