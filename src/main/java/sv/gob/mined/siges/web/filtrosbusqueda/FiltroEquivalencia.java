/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.gob.mined.siges.web.filtrosbusqueda;

import java.io.Serializable;

/**
 *
 * @author tiffa
 */
public class FiltroEquivalencia implements Serializable {

    private Long equiPk;
    private String nombreCompleto;
    private String primerNombre;
    private String segundoNombre;
    private String tercerNombre;
    private String primerApellido;
    private String segundoApellido;
    private String tercerApellido;
    private String estadoEquivalencia;
    private String pais;
    private String fechaRecepcion;

    private Long first;
    private Long maxResults;
    private String[] orderBy;
    private boolean[] ascending;

    private String[] incluirCampos;

    public FiltroEquivalencia() {
        this.first = 0L;
    }

    public Long getEquiPk() {
        return equiPk;
    }

    public void setEquiPk(Long equiPk) {
        this.equiPk = equiPk;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getTercerNombre() {
        return tercerNombre;
    }

    public void setTercerNombre(String tercerNombre) {
        this.tercerNombre = tercerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTercerApellido() {
        return tercerApellido;
    }

    public void setTercerApellido(String tercerApellido) {
        this.tercerApellido = tercerApellido;
    }

    public String getEstadoEquivalencia() {
        return estadoEquivalencia;
    }

    public void setEstadoEquivalencia(String estadoEquivalencia) {
        this.estadoEquivalencia = estadoEquivalencia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Long getFirst() {
        return first;
    }

    public void setFirst(Long first) {
        this.first = first;
    }

    public Long getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Long maxResults) {
        this.maxResults = maxResults;
    }

    public String[] getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String[] orderBy) {
        this.orderBy = orderBy;
    }

    public boolean[] getAscending() {
        return ascending;
    }

    public void setAscending(boolean[] ascending) {
        this.ascending = ascending;
    }

    public String[] getIncluirCampos() {
        return incluirCampos;
    }

    public void setIncluirCampos(String[] incluirCampos) {
        this.incluirCampos = incluirCampos;
    }

    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }



}
