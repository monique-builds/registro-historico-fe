package sv.gob.mined.siges.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import sv.gob.mined.siges.web.dto.catalogo.SgEstadoCivil;
import sv.gob.mined.siges.web.dto.catalogo.SgNacionalidad;
import sv.gob.mined.siges.web.dto.catalogo.SgPais;
import sv.gob.mined.siges.web.dto.catalogo.SgSexo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "incPk", scope = SgIncorporacion.class)
public class SgIncorporacion implements Serializable {

    private Long incPk;
    private String incDui;
    private String incCarneResidente;
    private String incPasaporte;
    private SgPais incPasaportePaisEmisor;
    private String incPrimerNombre;
    private String incSegundoNombre;
    private String incTercerNombre;
    private String incPrimerApellido;
    private String incSegundoApellido;
    private String incTercerApellido;
    private String incNombreBusqueda;
    private LocalDate incFechaNacimiento;
    private SgSexo incSexo;
    private SgEstadoCivil incEstadoCivil;
    private SgNacionalidad incNacionalidad;
    private String incNombreSede;
    private String nombreSolicitante;
    private LocalDate fechaRecepcion;
    private String incUltimoGradoEstudio;
    private Integer incAnioEstudio;
    private String incCiudad;
    private String incNumeroTramite;
    private String incNumeroResolucion;
    private LocalDate incFechaAprobacion;
    private LocalDateTime incUltModFecha;
    private String incUltModUsuario;
    private Integer incVersion;
    private String correoElectronico;
    private String telefono;
    private String nombreEstudiante;
    private String municipio;
    private String departamento;
    private String institucion;
    private String gradoAcademico;
    private String paisGraduacion;
    private Integer anioTitulo;
    private SgArchivo indFormula;

    public SgArchivo getIndFormula() {
        return indFormula;
    }

    public void setIndFormula(SgArchivo indFormula) {
        this.indFormula = indFormula;
    }


    public SgIncorporacion() {
    }

    // Getters and Setters for existing fields
    public Long getIncPk() {
        return incPk;
    }

    public void setIncPk(Long incPk) {
        this.incPk = incPk;
    }

    public String getIncDui() {
        return incDui;
    }

    public void setIncDui(String incDui) {
        this.incDui = incDui;
    }

    public String getIncCarneResidente() {
        return incCarneResidente;
    }

    public void setIncCarneResidente(String incCarneResidente) {
        this.incCarneResidente = incCarneResidente;
    }

    public String getIncPasaporte() {
        return incPasaporte;
    }

    public void setIncPasaporte(String incPasaporte) {
        this.incPasaporte = incPasaporte;
    }

    public SgPais getIncPasaportePaisEmisor() {
        return incPasaportePaisEmisor;
    }

    public void setIncPasaportePaisEmisor(SgPais incPasaportePaisEmisor) {
        this.incPasaportePaisEmisor = incPasaportePaisEmisor;
    }

    public String getIncPrimerNombre() {
        return incPrimerNombre;
    }

    public void setIncPrimerNombre(String incPrimerNombre) {
        this.incPrimerNombre = incPrimerNombre;
    }

    public String getIncSegundoNombre() {
        return incSegundoNombre;
    }

    public void setIncSegundoNombre(String incSegundoNombre) {
        this.incSegundoNombre = incSegundoNombre;
    }

    public String getIncTercerNombre() {
        return incTercerNombre;
    }

    public void setIncTercerNombre(String incTercerNombre) {
        this.incTercerNombre = incTercerNombre;
    }

    public String getIncPrimerApellido() {
        return incPrimerApellido;
    }

    public void setIncPrimerApellido(String incPrimerApellido) {
        this.incPrimerApellido = incPrimerApellido;
    }

    public String getIncSegundoApellido() {
        return incSegundoApellido;
    }

    public void setIncSegundoApellido(String incSegundoApellido) {
        this.incSegundoApellido = incSegundoApellido;
    }

    public String getIncTercerApellido() {
        return incTercerApellido;
    }

    public void setIncTercerApellido(String incTercerApellido) {
        this.incTercerApellido = incTercerApellido;
    }

    public String getIncNombreBusqueda() {
        return incNombreBusqueda;
    }

    public void setIncNombreBusqueda(String incNombreBusqueda) {
        this.incNombreBusqueda = incNombreBusqueda;
    }

    public LocalDate getIncFechaNacimiento() {
        return incFechaNacimiento;
    }

    public void setIncFechaNacimiento(LocalDate incFechaNacimiento) {
        this.incFechaNacimiento = incFechaNacimiento;
    }

    public SgSexo getIncSexo() {
        return incSexo;
    }

    public void setIncSexo(SgSexo incSexo) {
        this.incSexo = incSexo;
    }

    public SgEstadoCivil getIncEstadoCivil() {
        return incEstadoCivil;
    }

    public void setIncEstadoCivil(SgEstadoCivil incEstadoCivil) {
        this.incEstadoCivil = incEstadoCivil;
    }

    public SgNacionalidad getIncNacionalidad() {
        return incNacionalidad;
    }

    public void setIncNacionalidad(SgNacionalidad incNacionalidad) {
        this.incNacionalidad = incNacionalidad;
    }

    public String getIncNombreSede() {
        return incNombreSede;
    }

    public void setIncNombreSede(String incNombreSede) {
        this.incNombreSede = incNombreSede;
    }

    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public LocalDate getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDate fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getIncUltimoGradoEstudio() {
        return incUltimoGradoEstudio;
    }

    public void setIncUltimoGradoEstudio(String incUltimoGradoEstudio) {
        this.incUltimoGradoEstudio = incUltimoGradoEstudio;
    }

    public Integer getIncAnioEstudio() {
        return incAnioEstudio;
    }

    public void setIncAnioEstudio(Integer incAnioEstudio) {
        this.incAnioEstudio = incAnioEstudio;
    }

    public String getIncCiudad() {
        return incCiudad;
    }

    public void setIncCiudad(String incCiudad) {
        this.incCiudad = incCiudad;
    }

    public String getIncNumeroTramite() {
        return incNumeroTramite;
    }

    public void setIncNumeroTramite(String incNumeroTramite) {
        this.incNumeroTramite = incNumeroTramite;
    }

    public String getIncNumeroResolucion() {
        return incNumeroResolucion;
    }

    public void setIncNumeroResolucion(String incNumeroResolucion) {
        this.incNumeroResolucion = incNumeroResolucion;
    }

    public LocalDate getIncFechaAprobacion() {
        return incFechaAprobacion;
    }

    public void setIncFechaAprobacion(LocalDate incFechaAprobacion) {
        this.incFechaAprobacion = incFechaAprobacion;
    }

    public LocalDateTime getIncUltModFecha() {
        return incUltModFecha;
    }

    public void setIncUltModFecha(LocalDateTime incUltModFecha) {
        this.incUltModFecha = incUltModFecha;
    }

    public String getIncUltModUsuario() {
        return incUltModUsuario;
    }

    public void setIncUltModUsuario(String incUltModUsuario) {
        this.incUltModUsuario = incUltModUsuario;
    }

    public Integer getIncVersion() {
        return incVersion;
    }

    public void setIncVersion(Integer incVersion) {
        this.incVersion = incVersion;
    }

    // Getters and Setters for new fields
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

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public String getPaisGraduacion() {
        return paisGraduacion;
    }

    public void setPaisGraduacion(String paisGraduacion) {
        this.paisGraduacion = paisGraduacion;
    }

    public Integer getAnioTitulo() {
        return anioTitulo;
    }

    public void setAnioTitulo(Integer anioTitulo) {
        this.anioTitulo = anioTitulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (incPk != null ? incPk.hashCode() : 0);
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
        final SgIncorporacion other = (SgIncorporacion) obj;
        if (!Objects.equals(this.incPk, other.incPk)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sofis.entidades.SgIncorporacion[ incPk=" + incPk + " ]";
    }
}
