package sv.gob.mined.siges.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import sv.gob.mined.siges.web.dto.SgDocumento;
import sv.gob.mined.siges.web.dto.SgMarginacion;

@Named
@ViewScoped
public class MarginacionBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(MarginacionBean.class.getName());

    private SgMarginacion solicitudMarginacion = new SgMarginacion();
    private List<SgDocumento> documentosAcademicos = new ArrayList<>();
    private List<SgDocumento> documentosSeleccionados = new ArrayList<>();

    @PostConstruct
    public void cargarDocumentosAcademicos() {
        documentosAcademicos.add(new SgDocumento(1L, "Título de Educación Media", "PDF"));
        documentosAcademicos.add(new SgDocumento(2L, "Certificados de Educación Media", "PDF"));
        documentosAcademicos.add(new SgDocumento(3L, "Certificación de Registro de Títulos", "PDF"));
        documentosAcademicos.add(new SgDocumento(4L, "Certificación de notas de Educación Media", "PDF"));
        documentosAcademicos.add(new SgDocumento(5L, "Certificados de Educación Básica", "PDF"));
        documentosAcademicos.add(new SgDocumento(6L, "Certificación de notas de Educación Básica", "PDF"));

        System.out.println("Documentos académicos cargados: " + documentosAcademicos.size());
    }

    public void handleFileUpload(FileUploadEvent event) {
        UploadedFile file = event.getFile();
        if (file != null) {
            // Procesar el archivo subido
            byte[] contenido = file.getContents();
            String nombreArchivo = file.getFileName();
            String tipoArchivo = file.getContentType();

            // Asignar el archivo al documento seleccionado
            if (!documentosSeleccionados.isEmpty()) {
                SgDocumento documento = documentosSeleccionados.get(0); // O el que corresponda
                documento.setArchivo(contenido);
                documento.setTipoDocumento(tipoArchivo);
            }
        }
    }

    public void guardarSolicitud() {
        // Procesar la solicitud
        System.out.println("Solicitud guardada:");
        System.out.println("Nombre del solicitante: " + solicitudMarginacion.getNombreSolicitante());
        System.out.println("Correo Electrónico: " + solicitudMarginacion.getCorreoElectronico());
        System.out.println("Teléfono: " + solicitudMarginacion.getTelefono());
        System.out.println("Fecha de Recepción: " + solicitudMarginacion.getFechaRecepcion());

        // Procesar los documentos seleccionados
        System.out.println("Documentos seleccionados: " + documentosSeleccionados.size());
        for (SgDocumento documento : documentosSeleccionados) {
            System.out.println("Documento: " + documento.getNombreDocumento());
            if (documento.getArchivo() != null) {
                System.out.println("Archivo adjunto: " + documento.getArchivo().length + " bytes");
            }
        }

    }

    // Getters y setters para la información de contacto
    public SgMarginacion getSolicitudMarginacion() {
        return solicitudMarginacion;
    }

    public void setSolicitudMarginacion(SgMarginacion solicitudMarginacion) {
        this.solicitudMarginacion = solicitudMarginacion;
    }

    // Getters y setters para las listas y propiedades relacionadas con documentos
    public List<SgDocumento> getDocumentosAcademicos() {
        return documentosAcademicos;
    }

    public List<SgDocumento> getDocumentosSeleccionados() {
        return documentosSeleccionados;
    }

    public void setDocumentosSeleccionados(List<SgDocumento> documentosSeleccionados) {
        this.documentosSeleccionados = documentosSeleccionados;
    }

}
