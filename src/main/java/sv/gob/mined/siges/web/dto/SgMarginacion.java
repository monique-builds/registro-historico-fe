package sv.gob.mined.siges.web.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Objects;

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
    private SgDocumento SgMarginacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SgDocumento getSgMarginacion() {
        return SgMarginacion;
    }

    public void setSgMarginacion(SgDocumento SgMarginacion) {
        this.SgMarginacion = SgMarginacion;
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
}