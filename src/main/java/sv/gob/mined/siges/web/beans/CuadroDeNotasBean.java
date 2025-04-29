/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.gob.mined.siges.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.gob.mined.siges.web.constantes.ConstantesComponentesId;
import sv.gob.mined.siges.web.dto.SgArchivo;
import sv.gob.mined.siges.web.dto.SgCentroEscolar;
import sv.gob.mined.siges.web.dto.SgCuadroNotas;
import sv.gob.mined.siges.web.dto.SgEstudiante;
import sv.gob.mined.siges.web.filtrosbusqueda.FiltroCuadroNotas;
import sv.gob.mined.siges.web.filtrosbusqueda.FiltroNombreCompleto;
import sv.gob.mined.siges.web.lazymodels.LazyPaginaDataModel;
import sv.gob.mined.siges.web.mensajes.Mensajes;
import sv.gob.mined.siges.web.restclient.CuadroNotasRestClient;
import sv.gob.mined.siges.web.utilidades.JSFUtils;

/**
 *
 * @author tiffa
 */
@Named
@ViewScoped
public class CuadroDeNotasBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(CertificacionesBean.class.getName());

    private Integer paginado = 10;
    private Long totalResultados;
    private LazyPaginaDataModel paginaLazyModel;
    private List<SgCuadroNotas> cuadroNotas;

    private FiltroCuadroNotas filtro = new FiltroCuadroNotas();
    private FiltroNombreCompleto filtroNombreCompleto = new FiltroNombreCompleto();

    private SgCuadroNotas entidadEnEdicion = new SgCuadroNotas();

    @Inject
    private CuadroNotasRestClient restClient;

    public CuadroDeNotasBean() {
    }

    @PostConstruct
    public void init() {
        cuadroNotas = new ArrayList<>();
        LOGGER.info("Datos inicializados: " + cuadroNotas.size() + " registros");

        // Estudiante 1: Justin Alejandro Zamora Esquivel
        SgEstudiante estudiante1 = new SgEstudiante();
        estudiante1.setNombres("Justin Alejandro");
        estudiante1.setApellidos("Zamora Esquivel");

        SgCentroEscolar centro1 = new SgCentroEscolar();
        centro1.setNombreCentroEscolar("CENTRO ESCOLAR CASERÚN HELEN, CANTÓN SITIO VIEJO");

        SgArchivo archivo1 = new SgArchivo();
        archivo1.setAchNombre("ACTA_BACHILLERATO_2016.PDF");

        SgCuadroNotas cuadro1 = new SgCuadroNotas();
        cuadro1.setEstudianteFK(estudiante1);
        cuadro1.setCentroEscolarFK(centro1);
        cuadro1.setAnio(2016);
        cuadro1.setArchivo(archivo1);
        cuadroNotas.add(cuadro1);

        // Estudiante 2: Jose María Figueres Ferrer
        SgEstudiante estudiante2 = new SgEstudiante();
        estudiante2.setNombres("Jose María");
        estudiante2.setApellidos("Figueres Ferrer");

        SgCentroEscolar centro2 = new SgCentroEscolar();
        centro2.setNombreCentroEscolar("CENTRO ESCOLAR \"CANTON LA LABOR\"");

        SgArchivo archivo2 = new SgArchivo();
        archivo2.setAchNombre("ACTA_BACHILLERATO_2016.PDF");

        SgCuadroNotas cuadro2 = new SgCuadroNotas();
        cuadro2.setEstudianteFK(estudiante2);
        cuadro2.setCentroEscolarFK(centro2);
        cuadro2.setAnio(2016);
        cuadro2.setArchivo(archivo2);
        cuadroNotas.add(cuadro2);

        // Estudiante 3: Oswald Céspedes Torres
        SgEstudiante estudiante3 = new SgEstudiante();
        estudiante3.setNombres("Oswald");
        estudiante3.setApellidos("Céspedes Torres");

        SgCentroEscolar centro3 = new SgCentroEscolar();
        centro3.setNombreCentroEscolar("CENTRO ESCOLAR DE SAN ISIDRO");

        SgArchivo archivo3 = new SgArchivo();
        archivo3.setAchNombre("ACTA_BACHILLERATO_2015.PDF");

        SgCuadroNotas cuadro3 = new SgCuadroNotas();
        cuadro3.setEstudianteFK(estudiante3);
        cuadro3.setCentroEscolarFK(centro3);
        cuadro3.setAnio(2015);
        cuadro3.setArchivo(archivo3);
        cuadroNotas.add(cuadro3);

        // Estudiante 4: Alex Andrey Araya Lobo
        SgEstudiante estudiante4 = new SgEstudiante();
        estudiante4.setNombres("Alex Andrey");
        estudiante4.setApellidos("Araya Lobo");

        SgCentroEscolar centro4 = new SgCentroEscolar();
        centro4.setNombreCentroEscolar("CENTRO ESCOLAR CANTÓN SAN BENTO");

        SgArchivo archivo4 = new SgArchivo();
        archivo4.setAchNombre("ACTA_BACHILLERATO_2014.PDF");

        SgCuadroNotas cuadro4 = new SgCuadroNotas();
        cuadro4.setEstudianteFK(estudiante4);
        cuadro4.setCentroEscolarFK(centro4);
        cuadro4.setAnio(2014);
        cuadro4.setArchivo(archivo4);
        cuadroNotas.add(cuadro4);

        // Estudiante 5: Jorge Zapata Godoy
        SgEstudiante estudiante5 = new SgEstudiante();
        estudiante5.setNombres("Jorge");
        estudiante5.setApellidos("Zapata Godoy");

        SgCentroEscolar centro5 = new SgCentroEscolar();
        centro5.setNombreCentroEscolar("CENTRO ESCOLAR \"CANTON AGUA ZARCA\"");

        SgArchivo archivo5 = new SgArchivo();
        archivo5.setAchNombre("ACTA_BACHILLERATO_2018.PDF");

        SgCuadroNotas cuadro5 = new SgCuadroNotas();
        cuadro5.setEstudianteFK(estudiante5);
        cuadro5.setCentroEscolarFK(centro5);
        cuadro5.setAnio(2018);
        cuadro5.setArchivo(archivo5);
        cuadroNotas.add(cuadro5);
    }

    public void buscar() {
        try {
            // Ensure the filter is not null
            if (filtro == null) {
                filtro = new FiltroCuadroNotas();
            }

            // Ensure the restClient is properly initialized
            if (restClient == null) {
                // LOGGER.log(Level.SEVERE, "RestClient is not initialized");
                throw new IllegalStateException("RestClient is not initialized");
            }

            // Call the REST client to get the total results
            totalResultados = restClient.buscarTotal(filtro);

            // Initialize the lazy data model
        } catch (Exception ex) {
            // LOGGER.log(Level.SEVERE, "Error in buscar method: " + ex.getMessage(), ex);
            JSFUtils.agregarError(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ERROR_GENERAL), "");
        }
    }

    public void limpiar() {
        filtro = new FiltroCuadroNotas();
        buscar();
    }

    public Integer getPaginado() {
        return paginado;
    }

    public void setPaginado(Integer paginado) {
        this.paginado = paginado;
    }

    public Long getTotalResultados() {
        return totalResultados;
    }

    public void setTotalResultados(Long totalResultados) {
        this.totalResultados = totalResultados;
    }

    public LazyPaginaDataModel getPaginaLazyModel() {
        return paginaLazyModel;
    }

    public void setPaginaLazyModel(LazyPaginaDataModel paginaLazyModel) {
        this.paginaLazyModel = paginaLazyModel;
    }

    public SgCuadroNotas getEntidadEnEdicion() {
        return entidadEnEdicion;
    }

    public void setEntidadEnEdicion(SgCuadroNotas entidadEnEdicion) {
        this.entidadEnEdicion = entidadEnEdicion;
    }

    public List<SgCuadroNotas> getCuadroNotas() {
        return cuadroNotas;
    }

    public void setCuadroNotas(List<SgCuadroNotas> cuadroNotas) {
        this.cuadroNotas = cuadroNotas;
    }

    public FiltroCuadroNotas getFiltro() {
        return filtro;
    }

    public void setFiltro(FiltroCuadroNotas filtro) {
        this.filtro = filtro;
    }

    public FiltroNombreCompleto getFiltroNombreCompleto() {
        return filtroNombreCompleto;
    }

    public void setFiltroNombreCompleto(FiltroNombreCompleto filtroNombreCompleto) {
        this.filtroNombreCompleto = filtroNombreCompleto;
    }

}
