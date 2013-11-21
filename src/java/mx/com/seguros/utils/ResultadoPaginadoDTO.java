/*
 * Proyecto: Estrategas Seguros - Inbursa
 * Archivo: ResultadoPaginadoDTO.java
 * Fecha de creaci�n: 10/06/2011
 * �ltima Modificaci�n: 10/06/2011
 */

package mx.com.seguros.utils;

import java.util.List;

/**
 * Contiene los datos necesarios as� como los resultados de una consulta paginada
 * @author Emigdio Hern�ndez
 */
public class ResultadoPaginadoDTO <T> {
    private long totalResultados = 0;
    private int registrosPorPagina = 50;
    private int totalPaginas = 0;
    private int paginaActual = 0;
    private boolean primerVez = true;
    private List<T> resultados = null;

    /**
     * @return the totalResultados
     */
    public long getTotalResultados() {
        return totalResultados;
    }

    /**
     * @param totalResultados the totalResultados to set
     */
    public void setTotalResultados(long totalResultados) {
        this.totalResultados = totalResultados;
    }

    /**
     * @return the registrosPorPagina
     */
    public int getRegistrosPorPagina() {
        return registrosPorPagina;
    }

    /**
     * @param registrosPorPagina the registrosPorPagina to set
     */
    public void setRegistrosPorPagina(int registrosPorPagina) {
        this.registrosPorPagina = registrosPorPagina;
    }

    /**
     * @return the totalPaginas
     */
    public int getTotalPaginas() {
        return totalPaginas;
    }

    /**
     * @param totalPaginas the totalPaginas to set
     */
    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    /**
     * @return the paginaActual
     */
    public int getPaginaActual() {
        return paginaActual;
    }

    /**
     * @param paginaActual the paginaActual to set
     */
    public void setPaginaActual(int paginaActual) {
        this.paginaActual = paginaActual;
    }

    /**
     * @return the primerVez
     */
    public boolean isPrimerVez() {
        return primerVez;
    }

    /**
     * @param primerVez the primerVez to set
     */
    public void setPrimerVez(boolean primerVez) {
        this.primerVez = primerVez;
    }

    /**
     * @return the resultados
     */
    public List<T> getResultados() {
        return resultados;
    }

    /**
     * @param resultados the resultados to set
     */
    public void setResultados(List<T> resultados) {
        this.resultados = resultados;
    }

}
