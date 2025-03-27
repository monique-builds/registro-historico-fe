package sv.gob.mined.siges.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import sv.gob.mined.siges.web.dto.SgDocumento;
import sv.gob.mined.siges.web.dto.SgEquivalencia;

@Named
@ViewScoped
public class EquivalenciaBean implements Serializable {

    private SgEquivalencia entidadEnEdicion = new SgEquivalencia();
    private List<SgDocumento> documentosConConvenio = new ArrayList<>();
    private List<SgDocumento> documentosSinConvenio = new ArrayList<>();
    private List<SgDocumento> documentosSeleccionados = new ArrayList<>();

    @PostConstruct
    public void init() {
        if (entidadEnEdicion == null) {
            entidadEnEdicion = new SgEquivalencia();
        }
        entidadEnEdicion.setConvenioHaya(null);

        // Documentos para países SIN convenio de la Haya
        documentosSinConvenio.add(new SgDocumento(1L, "Certificado o Certificación de notas del último grado aprobado con auténticas", "PDF"));
        documentosSinConvenio.add(new SgDocumento(2L, "Auténtica de autoridades educativas del país de procedencia", "PDF"));
        documentosSinConvenio.add(new SgDocumento(3L, "Auténtica del Ministerio de Relaciones Exteriores del país de procedencia", "PDF"));
        documentosSinConvenio.add(new SgDocumento(4L, "Auténtica del Consulado de El Salvador en el país de procedencia", "PDF"));
        documentosSinConvenio.add(new SgDocumento(5L, "Auténtica del Ministerio de Relaciones Exteriores de El Salvador", "PDF"));
        documentosSinConvenio.add(new SgDocumento(6L, "Partida de nacimiento (salvadoreños) o Pasaporte vigente (extranjeros)", "PDF/JPG"));

        // Documentos para países CON convenio de la Haya
        documentosConConvenio.add(new SgDocumento(7L, "Certificado de notas con sello de APOSTILLA", "PDF"));
        documentosConConvenio.add(new SgDocumento(8L, "Auténtica del Ministerio de Educación del país de procedencia", "PDF"));
        documentosConConvenio.add(new SgDocumento(9L, "Traducción notariada (si está en idioma extranjero)", "PDF"));
        documentosConConvenio.add(new SgDocumento(10L, "Partida de nacimiento (salvadoreños) o Pasaporte vigente (extranjeros)", "PDF/JPG"));
    }

    // Getters y Setters
    public SgEquivalencia getEntidadEnEdicion() {
        if (entidadEnEdicion == null) {
            entidadEnEdicion = new SgEquivalencia();
        }
        return entidadEnEdicion;
    }

    public void setEntidadEnEdicion(SgEquivalencia entidadEnEdicion) {
        this.entidadEnEdicion = entidadEnEdicion;
    }

    public List<SgDocumento> getDocumentosConConvenio() {
        return documentosConConvenio;
    }

    public void setDocumentosConConvenio(List<SgDocumento> documentosConConvenio) {
        this.documentosConConvenio = documentosConConvenio;
    }

    public List<SgDocumento> getDocumentosSinConvenio() {
        return documentosSinConvenio;
    }

    public void setDocumentosSinConvenio(List<SgDocumento> documentosSinConvenio) {
        this.documentosSinConvenio = documentosSinConvenio;
    }

    public List<SgDocumento> getDocumentosSeleccionados() {
        return documentosSeleccionados;
    }

    public void setDocumentosSeleccionados(List<SgDocumento> documentosSeleccionados) {
        this.documentosSeleccionados = documentosSeleccionados;
    }
}
