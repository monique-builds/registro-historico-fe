package sv.gob.mined.siges.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import sv.gob.mined.siges.web.dto.SgDocumento;
import sv.gob.mined.siges.web.dto.SgDocumentosMarginacion;
import sv.gob.mined.siges.web.dto.SgMarginacion;

@Named
@ViewScoped
public class MarginacionBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(MarginacionBean.class.getName());

    private SgMarginacion solicitudMarginacion = new SgMarginacion();
    private List<SgDocumentosMarginacion> documentosAcademicos = new ArrayList<>();
    private List<SgDocumentosMarginacion> documentosSeleccionados = new ArrayList<>();

    @PostConstruct
    public void cargarDocumentosAcademicos() {
        documentosAcademicos.add(new SgDocumentosMarginacion(1L, new SgDocumento(1L, "Título de Educación Media", "PDF")));
        documentosAcademicos.add(new SgDocumentosMarginacion(2L, new SgDocumento(2L, "Certificados de Educación Media", "PDF")));
        documentosAcademicos.add(new SgDocumentosMarginacion(3L, new SgDocumento(3L, "Certificación de Registro de Títulos", "PDF")));
        documentosAcademicos.add(new SgDocumentosMarginacion(4L, new SgDocumento(4L, "Certificación de notas de Educación Media", "PDF")));
        documentosAcademicos.add(new SgDocumentosMarginacion(5L, new SgDocumento(5L, "Certificados de Educación Básica", "PDF")));
        documentosAcademicos.add(new SgDocumentosMarginacion(6L, new SgDocumento(6L, "Certificación de notas de Educación Básica", "PDF")));

        System.out.println("Documentos académicos cargados: " + documentosAcademicos.size());
    }

//    public void handleFileUpload(FileUploadEvent event) {
//        UploadedFile file = event.getFile();
//        if (file != null) {
//            byte[] contenido = file.getContents();
//            String nombreArchivo = file.getFileName();
//            String tipoArchivo = file.getContentType();
//
//            if (!documentosSeleccionados.isEmpty()) {
//                SgDocumentosMarginacion documento = documentosSeleccionados.get(0);
//                documento.setArchivo(contenido);
//                documento.setTipoDocumento(tipoArchivo);
//            }
//        }
//    }
//
//    public void guardarSolicitud() {
//        System.out.println("Solicitud guardada:");
//        System.out.println("Nombre del solicitante: " + solicitudMarginacion.getNombresSolicitante());
//        System.out.println("Correo Electrónico: " + solicitudMarginacion.getCorreoElectronico());
//        System.out.println("Teléfono: " + solicitudMarginacion.getTelefono());
//        System.out.println("Fecha de Recepción: " + solicitudMarginacion.getFechaRecepcion());
//
//        System.out.println("Documentos seleccionados: " + documentosSeleccionados.size());
//        for (SgDocumento documento : documentosSeleccionados) {
//            System.out.println("Documento: " + documento.getNombreDocumento());
//            if (documento.getArchivo() != null) {
//                System.out.println("Archivo adjunto: " + documento.getArchivo().length + " bytes");
//            }
//        }
//
//    }

    // Getters y setters para la información de contacto
    public SgMarginacion getSolicitudMarginacion() {
        return solicitudMarginacion;
    }

    public void setSolicitudMarginacion(SgMarginacion solicitudMarginacion) {
        this.solicitudMarginacion = solicitudMarginacion;
    }

    // Getters y setters para las listas y propiedades relacionadas con documentos
    public List<SgDocumentosMarginacion> getDocumentosAcademicos() {
        return documentosAcademicos;
    }

    public List<SgDocumentosMarginacion> getDocumentosSeleccionados() {
        return documentosSeleccionados;
    }

    public void setDocumentosSeleccionados(List<SgDocumentosMarginacion> documentosSeleccionados) {
        this.documentosSeleccionados = documentosSeleccionados;
    }

}
