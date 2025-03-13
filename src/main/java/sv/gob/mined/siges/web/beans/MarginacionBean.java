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

@Named
@ViewScoped
public class MarginacionBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(MarginacionBean.class.getName());

    // Campos para la información de contacto
    private String nombreSolicitante;
    private Date fechaRecepcion;
    private String correoElectronico;
    private String telefono;

    // Campos para la información del estudiante
    private String nombreEstudiante;
    private String domicilio;

    // Listas y propiedades relacionadas con documentos
    private final List<SgDocumento> documentosAcademicos = new ArrayList();
    ;
    private List<SgDocumento> documentosSeleccionados = new ArrayList();

    ;

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
        System.out.println("Nombre del solicitante: " + nombreSolicitante);
        System.out.println("Documentos seleccionados: " + documentosSeleccionados.size());

        // Guardar los documentos seleccionados (aquí iría la lógica de persistencia)
        for (SgDocumento documento : documentosSeleccionados) {
            System.out.println("Documento: " + documento.getNombreDocumento());
            if (documento.getArchivo() != null) {
                System.out.println("Archivo adjunto: " + documento.getArchivo().length + " bytes");
            }
        }
    }

    // Getters y setters para la información de contacto
    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Getters y setters para la información del estudiante
    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
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
