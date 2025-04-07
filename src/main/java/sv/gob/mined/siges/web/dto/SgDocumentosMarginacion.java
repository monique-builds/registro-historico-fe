/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.gob.mined.siges.web.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Objects;
import java.io.Serializable;


/**
 *
 * @author tiffa
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "documentoMarginacionPK", scope = SgDocumentosMarginacion.class)
public class SgDocumentosMarginacion implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long documentoMarginacionPK;
    private SgDocumento documentoFK;

    public Long getDocumentoMarginacionPK() {
        return documentoMarginacionPK;
    }

    public void setDocumentoMarginacionPK(Long documentoMarginacionPK) {
        this.documentoMarginacionPK = documentoMarginacionPK;
    }

    public SgDocumento getDocumentoFK() {
        return documentoFK;
    }

    public void setDocumentoFK(SgDocumento documentoFK) {
        this.documentoFK = documentoFK;
    }

 @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.documentoMarginacionPK);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SgDocumentosMarginacion other = (SgDocumentosMarginacion) obj;
        if (!Objects.equals(this.documentoMarginacionPK, other.documentoMarginacionPK)) {
            return false;
        }
        return true;
    }

    public SgDocumentosMarginacion(Long documentoMarginacionPK, SgDocumento documentoFK) {
        this.documentoMarginacionPK = documentoMarginacionPK;
        this.documentoFK = documentoFK;
    }
    



}
