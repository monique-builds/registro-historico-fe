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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "centroEscolarPK", scope = SgIncorporacion.class)
public class SgCentroEscolar implements Serializable {
   private Long centroEscolarPK;
   private String nombreCentroEscolar;

    public SgCentroEscolar(Long centroEscolarPK, String nombreCentroEscolar) {
        this.centroEscolarPK = centroEscolarPK;
        this.nombreCentroEscolar = nombreCentroEscolar;
    }

    public Long getCentroEscolarPK() {
        return centroEscolarPK;
    }

    public void setCentroEscolarPK(Long centroEscolarPK) {
        this.centroEscolarPK = centroEscolarPK;
    }

    public String getNombreCentroEscolar() {
        return nombreCentroEscolar;
    }

    public void setNombreCentroEscolar(String nombreCentroEscolar) {
        this.nombreCentroEscolar = nombreCentroEscolar;
    }

    public SgCentroEscolar() {
    }
   



    
}
