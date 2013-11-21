/**
 * 
 */
package mx.com.seguros.dto;

import java.io.Serializable;

/**
 * DTO que representa los bonos pendientes por calcular a la fecha de una p�liza
 * @author Emigdio Hernandez
 *
 */
public class BonoPolizaPorCalcularDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * N�mero de p�liza
	 */
	Integer numPoliza = null;
	/**
	 * N�mero de consignatario
	 */
	Integer numConsignatario = null;
	/**
	 * Clave del agente
	 */
	Integer cveAgente = null;
	/**
	 * N�mero de descuentos aplicados a la prima de la p�liza
	 */
	Integer descuentosAplicados = 0;
	/**
	 * N�mero de quincenas aplicadas a la prima que han sido ya calculadas para la p�liza
	 */
	Integer numQuincenasPagadas = 0;
	
	@Override
	public String toString(){
		
	return numPoliza + ", " + numConsignatario + ", " + cveAgente + ", " + descuentosAplicados + " ," + numQuincenasPagadas;
		
		
	}

	
	/**
	 * @param numQuincenasPagadas the numQuincenasPagadas to set
	 */
	public void setNumQuincenasPagadas(Integer numQuincenasPagadas) {
		this.numQuincenasPagadas = numQuincenasPagadas;
	}


	/**
	 * @return the numPoliza
	 */
	public Integer getNumPoliza() {
		return numPoliza;
	}


	/**
	 * @param numPoliza the numPoliza to set
	 */
	public void setNumPoliza(Integer numPoliza) {
		this.numPoliza = numPoliza;
	}


	/**
	 * @return the numConsignatario
	 */
	public Integer getNumConsignatario() {
		return numConsignatario;
	}


	/**
	 * @param numConsignatario the numConsignatario to set
	 */
	public void setNumConsignatario(Integer numConsignatario) {
		this.numConsignatario = numConsignatario;
	}


	/**
	 * @return the cveAgente
	 */
	public Integer getCveAgente() {
		return cveAgente;
	}


	/**
	 * @param cveAgente the cveAgente to set
	 */
	public void setCveAgente(Integer cveAgente) {
		this.cveAgente = cveAgente;
	}


	/**
	 * @return the descuentosAplicados
	 */
	public Integer getDescuentosAplicados() {
		return descuentosAplicados;
	}


	/**
	 * @param descuentosAplicados the descuentosAplicados to set
	 */
	public void setDescuentosAplicados(Integer descuentosAplicados) {
		this.descuentosAplicados = descuentosAplicados;
	}


	/**
	 * @return the numQuincenasPagadas
	 */
	public Integer getNumQuincenasPagadas() {
		return numQuincenasPagadas;
	}

}
