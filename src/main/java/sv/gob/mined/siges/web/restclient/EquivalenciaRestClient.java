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
import sv.gob.mined.siges.web.dto.SgEquivalencia;
import sv.gob.mined.siges.web.dto.centroseducativos.SgSede;
import sv.gob.mined.siges.web.excepciones.BusinessException;
import sv.gob.mined.siges.web.excepciones.HttpClientException;
import sv.gob.mined.siges.web.excepciones.HttpServerException;
import sv.gob.mined.siges.web.excepciones.HttpServerUnavailableException;
import sv.gob.mined.siges.web.filtrosbusqueda.FiltroEquivalencia;

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
public class EquivalenciaRestClient implements Serializable {
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
    
    public EquivalenciaRestClient() {
    }
    

 @Retry(maxRetries = 2, retryOn = {HttpServerUnavailableException.class, HttpServerException.class, TimeoutException.class}, delay = 250)
    public List<SgEquivalencia> buscar(FiltroEquivalencia filtro) throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        if (filtro == null) {
            return new ArrayList<>();
        }
        WebTarget webTarget = RestClient.getWebTarget(client, ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/equivalencias/buscar");
        SgEquivalencia[] equivalencia = restClient.invokePost(webTarget, filtro, SgEquivalencia[].class);
        return Arrays.asList(equivalencia);
    }

    @Retry(maxRetries = 2, retryOn = {HttpServerUnavailableException.class, HttpServerException.class, TimeoutException.class}, delay = 250)
    public Long buscarTotal(FiltroEquivalencia filtro) throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        if (filtro == null) {
            return 0L;
        }
        WebTarget webTarget = RestClient.getWebTarget(client,ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/equivalencias/buscar/total");
        return restClient.invokePost(webTarget, filtro, Long.class);
    }

    public SgEquivalencia guardar(SgEquivalencia equivalencia) throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        if (equivalencia == null) {
            return null;
        }
        if (equivalencia.getEquivalenciaPk()== null) {
            WebTarget webTarget = RestClient.getWebTarget(client,ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/equivalencias");
            return restClient.invokePost(webTarget, equivalencia, SgEquivalencia.class);
        } else {
            WebTarget webTarget = RestClient.getWebTarget(client,ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/equivalencias");
            webTarget = webTarget.path(equivalencia.getEquivalenciaPk().toString());
            return restClient.invokePut(webTarget, equivalencia, SgEquivalencia.class);
        }
    }

	@Retry(maxRetries = 2, retryOn = {HttpServerUnavailableException.class, HttpServerException.class, TimeoutException.class}, delay = 250)
    public SgEquivalencia obtenerPorId(Long equivalenciaPK) throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        if (equivalenciaPK == null) {
            return null;
        }
        WebTarget webTarget = RestClient.getWebTarget(client, ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/equivalencias");
        webTarget = webTarget.path(equivalenciaPK.toString());
        return restClient.invokeGet(webTarget, SgEquivalencia.class);
    }

    public void eliminar(Long equivalenciaPK) throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        if (equivalenciaPK == null) {
            return;
        }
        WebTarget webTarget = RestClient.getWebTarget(client, ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/equivalencias");
        webTarget = webTarget.path(equivalenciaPK.toString());
        restClient.invokeDelete(webTarget);
    }


   @Retry(maxRetries = 2, retryOn = {HttpServerUnavailableException.class, HttpServerException.class, TimeoutException.class}, delay = 1000)
    public List<RevHistorico> obtenerHistorialPorId(Long sedeId) throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
        if (sedeId == null) {
            return new ArrayList<>();
        }
        WebTarget webTarget = RestClient.getWebTarget(client, ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/equivalencias/historial");
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
        WebTarget webTarget = RestClient.getWebTarget(client, ConstantesServiciosRest.SERVICIO_REGISTRO_HISTORICO, "v1/equivalencias/revision");
        webTarget = webTarget.path(sedeId.toString());
        webTarget = webTarget.path(sedeRev.toString());
        return restClient.invokeGet(webTarget, SgSede.class);
    }

}
