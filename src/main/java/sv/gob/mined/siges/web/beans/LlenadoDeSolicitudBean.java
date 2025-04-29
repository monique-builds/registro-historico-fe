/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.gob.mined.siges.web.beans;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import sv.gob.mined.siges.web.dto.SgLlenadoDeSolicitud;

/**
 *
 * @author tiffa
 */
@Named
@ViewScoped
public class LlenadoDeSolicitudBean implements Serializable{
    private SgLlenadoDeSolicitud entidadEnEdicion = new SgLlenadoDeSolicitud();

    public SgLlenadoDeSolicitud getEntidadEnEdicion() {
        return entidadEnEdicion;
    }

    public void setEntidadEnEdicion(SgLlenadoDeSolicitud entidadEnEdicion) {
        this.entidadEnEdicion = entidadEnEdicion;
    }



    
}
