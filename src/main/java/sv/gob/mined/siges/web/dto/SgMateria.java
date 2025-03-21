/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.gob.mined.siges.web.dto;

import java.io.Serializable;

/**
 *
 * @author tiffa
 */
public class SgMateria implements Serializable {

    private String materia;
    private String area;
    private String resultado;
    private int nota;

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public SgMateria(String materia, String area, String resultado, int nota) {
        this.materia = materia;
        this.area = area;
        this.resultado = resultado;
        this.nota = nota;
    }

    public SgMateria() {
    }

}
