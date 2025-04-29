/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.gob.mined.siges.web.lazymodels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import sv.gob.mined.siges.web.constantes.ConstantesComponentesId;
import sv.gob.mined.siges.web.dto.SgEquivalencia;
import sv.gob.mined.siges.web.filtrosbusqueda.FiltroEquivalencia;
import sv.gob.mined.siges.web.mensajes.Mensajes;
import sv.gob.mined.siges.web.restclient.EquivalenciaRestClient;
import sv.gob.mined.siges.web.utilidades.JSFUtils;

/**
 *
 * @author tiffa
 */
public class LazyEquivalenciaDataModel extends LazyDataModel<SgEquivalencia> implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(LazyEquivalenciaDataModel.class.getName());
    private static final long serialVersionUID = 1L;
    private EquivalenciaRestClient restClient;
    private FiltroEquivalencia filtro;

    public LazyEquivalenciaDataModel(EquivalenciaRestClient restClient, FiltroEquivalencia filtro, Long rowCount, Integer pageSize) {
        this.restClient = restClient;
        this.filtro = filtro;
        this.setRowCount(rowCount.intValue());
        this.setPageSize(pageSize);
    }

    @Override
    public SgEquivalencia getRowData(String rowKey) {
        try {
            return restClient.obtenerPorId(Long.valueOf(rowKey));
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            JSFUtils.agregarError(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ERROR_GENERAL), "");
            return null;
        }
    }

    @Override
    public Object getRowKey(SgEquivalencia c) {
        return c.getEquivalenciaPk();
    }

    @Override
    public List<SgEquivalencia> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        try {
            filtro.setFirst(new Long(first));
            filtro.setMaxResults(new Long(pageSize));
            if (sortField != null) {
                filtro.setOrderBy(new String[]{sortField});
                filtro.setAscending(new boolean[]{sortOrder.equals(SortOrder.ASCENDING)});
            }
            return restClient.buscar(filtro);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            JSFUtils.agregarError(ConstantesComponentesId.ID_MSG_TEMPLATE, Mensajes.obtenerMensaje(Mensajes.ERROR_GENERAL), "");
            return new ArrayList<>();
        }
    }

    public void setFiltro(FiltroEquivalencia filtro) {
        this.filtro = filtro;
    }

}
