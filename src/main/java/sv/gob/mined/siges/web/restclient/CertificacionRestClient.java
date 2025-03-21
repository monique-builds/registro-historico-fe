/*
 *  SIGES
 *  
 */
package sv.gob.mined.siges.web.restclient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import org.eclipse.microprofile.faulttolerance.Bulkhead;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.opentracing.Traced;
import sv.gob.mined.siges.web.dto.SgCertificacion;
import sv.gob.mined.siges.web.dto.catalogo.SgDepartamento;
import sv.gob.mined.siges.web.dto.catalogo.SgMunicipio;
import sv.gob.mined.siges.web.dto.centroseducativos.SgNivel;
import sv.gob.mined.siges.web.excepciones.BusinessException;
import sv.gob.mined.siges.web.excepciones.HttpClientException;
import sv.gob.mined.siges.web.excepciones.HttpServerException;
import sv.gob.mined.siges.web.excepciones.HttpServerUnavailableException;
import sv.gob.mined.siges.web.constantes.ConstantesServiciosRest;

@Named
@RequestScoped
@Traced
@Bulkhead
@CircuitBreaker
@Retry(maxRetries = 2, retryOn = {HttpServerUnavailableException.class}, delay = 1000)
@Timeout(value = 10000L)
public class CertificacionRestClient implements Serializable {

    @Inject
    private RestClient restClient;

    private Client client = null;

    @PostConstruct
    public void init() {
        client = RestClient.getClient();
    }

    @PreDestroy
    public void preDestroy() {
        if (client != null) {
            client.close();
        }
    }

    public CertificacionRestClient() {
    }

    // Método para obtener la lista de niveles desde el servicio REST
    @Retry(maxRetries = 2, retryOn = {HttpServerUnavailableException.class, HttpServerException.class, TimeoutException.class}, delay = 1000)
    public List<SgNivel> obtenerNiveles() throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        WebTarget webTarget = RestClient.getWebTarget(client, ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/niveles");
        SgNivel[] niveles = restClient.invokeGet(webTarget, SgNivel[].class);
        return Arrays.asList(niveles);
    }

    // Método para obtener la lista de departamentos desde el servicio REST
    @Retry(maxRetries = 2, retryOn = {HttpServerUnavailableException.class, HttpServerException.class, TimeoutException.class}, delay = 1000)
    public List<SgDepartamento> obtenerDepartamentos() throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        WebTarget webTarget = RestClient.getWebTarget(client, ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/departamentos");
        SgDepartamento[] departamentos = restClient.invokeGet(webTarget, SgDepartamento[].class);
        return Arrays.asList(departamentos);
    }

    // Método para obtener la lista de municipios desde el servicio REST
    @Retry(maxRetries = 2, retryOn = {HttpServerUnavailableException.class, HttpServerException.class, TimeoutException.class}, delay = 1000)
    public List<SgMunicipio> obtenerMunicipios() throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        WebTarget webTarget = RestClient.getWebTarget(client, ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/municipios");
        SgMunicipio[] municipios = restClient.invokeGet(webTarget, SgMunicipio[].class);
        return Arrays.asList(municipios);
    }

    // Método para guardar una certificación
    public SgCertificacion guardar(SgCertificacion certificacion) throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        if (certificacion == null) {
            return null;
        }
        if (certificacion.getCertificacionPK() == null) {
            WebTarget webTarget = RestClient.getWebTarget(client, ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/certificaciones");
            return restClient.invokePost(webTarget, certificacion, SgCertificacion.class);
        } else {
            WebTarget webTarget = RestClient.getWebTarget(client, ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/certificaciones");
            webTarget = webTarget.path(certificacion.getCertificacionPK().toString());
            return restClient.invokePut(webTarget, certificacion, SgCertificacion.class);
        }
    }

    // Método para obtener una certificación por su ID
    @Retry(maxRetries = 2, retryOn = {HttpServerUnavailableException.class, HttpServerException.class, TimeoutException.class}, delay = 1000)
    public SgCertificacion obtenerPorId(Long certificacionPK) throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        if (certificacionPK == null) {
            return null;
        }
        WebTarget webTarget = RestClient.getWebTarget(client, ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/certificaciones");
        webTarget = webTarget.path(certificacionPK.toString());
        return restClient.invokeGet(webTarget, SgCertificacion.class);
    }

    // Método para eliminar una certificación por su ID
    public void eliminar(Long certificacionPK) throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        if (certificacionPK == null) {
            return;
        }
        WebTarget webTarget = RestClient.getWebTarget(client, ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/certificaciones");
        webTarget = webTarget.path(certificacionPK.toString());
        restClient.invokeDelete(webTarget);
    }
}