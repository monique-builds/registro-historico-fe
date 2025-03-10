package sv.gob.mined.siges.web.beans;

import java.io.InputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Named
@ApplicationScoped
public class ApplicationBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(ApplicationBean.class.getName());

    @Inject
    @ConfigProperty(name = "project.stage")
    private String ambiente;

    @Inject
    @ConfigProperty(name = "project.name")
    private String nombreAplicacion;

    @Inject
    @ConfigProperty(name = "project.version")
    private String version;

    private String timestamp;

    private final String patternFecha = "dd/MM/yyyy";
    private final DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern(patternFecha);

     @Inject
    @ConfigProperty(name = "files.allowed-size.images", defaultValue = "5242880") //5MB
    private String fotosTamPermitido;

    public ApplicationBean() {
        // Constructor vacío (requerido)
    }

    @PostConstruct
    private void init() {
        try {
            InputStream is = FacesContext.getCurrentInstance()
                    .getExternalContext().getResourceAsStream("/META-INF/MANIFEST.MF");
            if (is != null) {
                Manifest manifest = new Manifest();
                manifest.read(is);
                // Por ejemplo, se lee el build-time desde el MANIFEST
                timestamp = manifest.getMainAttributes().getValue("build-time");
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error leyendo el MANIFEST", ex);
        }
    }

    // Getters para las propiedades inyectadas y otros parámetros
    public String getAmbiente() {
        return ambiente;
    }

    public String getNombreAplicacion() {
        return nombreAplicacion;
    }

    public String getVersion() {
        return version;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public DateTimeFormatter getDateFormater() {
        return dateFormater;
    }

    public LocalDate today() {
        return LocalDate.now();
    }

    // Add this getter method for patternFecha
    public String getPatternFecha() {
        return patternFecha;
    }
}