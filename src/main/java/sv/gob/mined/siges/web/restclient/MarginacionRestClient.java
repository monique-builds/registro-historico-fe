/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.gob.mined.siges.web.restclient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
import org.eclipse.microprofile.faulttolerance.exceptions.TimeoutException;
import org.eclipse.microprofile.opentracing.Traced;
import sv.gob.mined.siges.web.constantes.ConstantesServiciosRest;
import sv.gob.mined.siges.web.dto.RevHistorico;
import sv.gob.mined.siges.web.dto.SgMarginacion;
import sv.gob.mined.siges.web.dto.centroseducativos.SgSede;
import sv.gob.mined.siges.web.excepciones.BusinessException;
import sv.gob.mined.siges.web.excepciones.HttpClientException;
import sv.gob.mined.siges.web.excepciones.HttpServerException;
import sv.gob.mined.siges.web.excepciones.HttpServerUnavailableException;
import sv.gob.mined.siges.web.filtrosbusqueda.FiltroMarginacion;

/**
 *
 * @author tiffa
 */
@Named
@RequestScoped
@Traced
@Bulkhead
@CircuitBreaker
@Retry(maxRetries = 2, retryOn = {HttpServerUnavailableException.class}, delay = 250)
@Timeout(value = 3000L)
public class MarginacionRestClient implements Serializable {

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
    
    public MarginacionRestClient() {
    }

@Retry(maxRetries = 2, retryOn = {HttpServerUnavailableException.class, HttpServerException.class, TimeoutException.class}, delay = 250)
    public List<SgMarginacion> buscar(FiltroMarginacion filtro) throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        if (filtro == null) {
            return new ArrayList<>();
        }
        WebTarget webTarget = RestClient.getWebTarget(client, ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/marginaciones/buscar");
        SgMarginacion[] marginacion = restClient.invokePost(webTarget, filtro, SgMarginacion[].class);
        return Arrays.asList(marginacion);
    }

    @Retry(maxRetries = 2, retryOn = {HttpServerUnavailableException.class, HttpServerException.class, TimeoutException.class}, delay = 250)
    public Long buscarTotal(FiltroMarginacion filtro) throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        if (filtro == null) {
            return 0L;
        }
        WebTarget webTarget = RestClient.getWebTarget(client,ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/marginaciones/buscar/total");
        return restClient.invokePost(webTarget, filtro, Long.class);
    }

    public SgMarginacion guardar(SgMarginacion marginacion) throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        if (marginacion == null) {
            return null;
        }
        if (marginacion.getId()== null) {
            WebTarget webTarget = RestClient.getWebTarget(client,ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/marginaciones");
            return restClient.invokePost(webTarget, marginacion, SgMarginacion.class);
        } else {
            WebTarget webTarget = RestClient.getWebTarget(client,ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/marginaciones");
            webTarget = webTarget.path(marginacion.getId().toString());
            return restClient.invokePut(webTarget, marginacion, SgMarginacion.class);
        }
    }

	@Retry(maxRetries = 2, retryOn = {HttpServerUnavailableException.class, HttpServerException.class, TimeoutException.class}, delay = 250)
    public SgMarginacion obtenerPorId(Long marginacionPk) throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        if (marginacionPk == null) {
            return null;
        }
        WebTarget webTarget = RestClient.getWebTarget(client, ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/marginaciones");
        webTarget = webTarget.path(marginacionPk.toString());
        return restClient.invokeGet(webTarget, SgMarginacion.class);
    }

    public void eliminar(Long marginacionPk) throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        if (marginacionPk == null) {
            return;
        }
        WebTarget webTarget = RestClient.getWebTarget(client, ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/marginaciones");
        webTarget = webTarget.path(marginacionPk.toString());
        restClient.invokeDelete(webTarget);
    }


   @Retry(maxRetries = 2, retryOn = {HttpServerUnavailableException.class, HttpServerException.class, TimeoutException.class}, delay = 1000)
    public List<RevHistorico> obtenerHistorialPorId(Long sedeId) throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        if (sedeId == null) {
            return new ArrayList<>();
        }
        WebTarget webTarget = RestClient.getWebTarget(client, ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/marginaciones/historial");
        webTarget = webTarget.path(sedeId.toString());
        RevHistorico[] revs = restClient.invokeGet(webTarget, RevHistorico[].class);
        return Arrays.asList(revs);
    }

    @Retry(maxRetries = 2, retryOn = {HttpServerUnavailableException.class, HttpServerException.class, TimeoutException.class}, delay = 1000)
    @Timeout(value = 12000L)
    public SgSede obtenerEnRevision(Long sedeId, Long sedeRev) throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        if (sedeId == null || sedeRev == null) {
            return null;
        }
        WebTarget webTarget = RestClient.getWebTarget(client, ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/marginaciones/revision");
        webTarget = webTarget.path(sedeId.toString());
        webTarget = webTarget.path(sedeRev.toString());
        return restClient.invokeGet(webTarget, SgSede.class);
    }

    

    
}
