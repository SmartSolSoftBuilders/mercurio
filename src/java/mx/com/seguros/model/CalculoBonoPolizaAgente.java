/**
 * 
 */
package mx.com.seguros.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase de mapero para la tabla CalculoBonoPolizaAgente de la BD
 * @author Emigdio Hernandez
 *
 */
public class CalculoBonoPolizaAgente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * IDentificador del registro
	 */
	int idCalculoBonoPolizaAgente = 0;
	/**
	 * N�mero de la p�liza
	 */
	int numPoliza = 0;
	/**
	 * N�mero de consignatario
	 */
	int numConsignatario = 0;
	/**
	 * Clave del agente de la comisi�n
	 */
	Integer cveAgente = 0;
	/**
	 * Tarifa utilizada para el c�lculo
	 */
	double tarifa = 0;
	/**
	 * Porcentaje de bono utilizado para el c�lculo
	 */
	double porcentaje = 0;
	/**
	 * N�mero de quincenas consideradas para este c�lculo
	 */
	int numeroQuincenas = 0;
	/**
	 * N�mero de quincena entre 13 y 48 inicial del c�lculo
	 */
	int numeroQuincenaBase = 0;
	/**
	 * N�mero de la quincena inicial qqyyyy
	 */
	int quincenaFinal = 0;
	/**
	 * N�mero de la quincena inicial qqyyyy
	 */
	int quincenaInicial = 0;
	/**
	 * Monto calculado del bono
	 */
	double montoBono = 0;
	/**
	 * Fecha de c�lculo del bono
	 */
	Date fechaCalculo = null;
	/**
	 * ID del registro de resumen del c�lculo del bono del agente
	 */
	Integer idResumenCalculoBonoPolizaAgente = null;
	/**
	 * @return the idCalculoBonoPolizaAgente
	 */
	public int getIdCalculoBonoPolizaAgente() {
		return idCalculoBonoPolizaAgente;
	}
	/**
	 * @param idCalculoBonoPolizaAgente the idCalculoBonoPolizaAgente to set
	 */
	public void setIdCalculoBonoPolizaAgente(int idCalculoBonoPolizaAgente) {
		this.idCalculoBonoPolizaAgente = idCalculoBonoPolizaAgente;
	}
	/**
	 * @return the numPoliza
	 */
	public int getNumPoliza() {
		return numPoliza;
	}
	/**
	 * @param numPoliza the numPoliza to set
	 */
	public void setNumPoliza(int numPoliza) {
		this.numPoliza = numPoliza;
	}
	/**
	 * @return the numConsignatario
	 */
	public int getNumConsignatario() {
		return numConsignatario;
	}
	/**
	 * @param numConsignatario the numConsignatario to set
	 */
	public void setNumConsignatario(int numConsignatario) {
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
	 * @return the tarifa
	 */
	public double getTarifa() {
		return tarifa;
	}
	/**
	 * @param tarifa the tarifa to set
	 */
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	/**
	 * @return the porcentaje
	 */
	public double getPorcentaje() {
		return porcentaje;
	}
	/**
	 * @param porcentaje the porcentaje to set
	 */
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	/**
	 * @return the numeroQuincenas
	 */
	public int getNumeroQuincenas() {
		return numeroQuincenas;
	}
	/**
	 * @param numeroQuincenas the numeroQuincenas to set
	 */
	public void setNumeroQuincenas(int numeroQuincenas) {
		this.numeroQuincenas = numeroQuincenas;
	}
	/**
	 * @return the numeroQuincenaBase
	 */
	public int getNumeroQuincenaBase() {
		return numeroQuincenaBase;
	}
	/**
	 * @param numeroQuincenaBase the numeroQuincenaBase to set
	 */
	public void setNumeroQuincenaBase(int numeroQuincenaBase) {
		this.numeroQuincenaBase = numeroQuincenaBase;
	}
	/**
	 * @return the quincenaFinal
	 */
	public int getQuincenaFinal() {
		return quincenaFinal;
	}
	/**
	 * @param quincenaFinal the quincenaFinal to set
	 */
	public void setQuincenaFinal(int quincenaFinal) {
		this.quincenaFinal = quincenaFinal;
	}
	/**
	 * @return the quincenaInicial
	 */
	public int getQuincenaInicial() {
		return quincenaInicial;
	}
	/**
	 * @param quincenaInicial the quincenaInicial to set
	 */
	public void setQuincenaInicial(int quincenaInicial) {
		this.quincenaInicial = quincenaInicial;
	}
	/**
	 * @return the montoBono
	 */
	public double getMontoBono() {
		return montoBono;
	}
	/**
	 * @param montoBono the montoBono to set
	 */
	public void setMontoBono(double montoBono) {
		this.montoBono = montoBono;
	}
	/**
	 * @return the fechaCalculo
	 */
	public Date getFechaCalculo() {
		return fechaCalculo;
	}
	/**
	 * @param fechaCalculo the fechaCalculo to set
	 */
	public void setFechaCalculo(Date fechaCalculo) {
		this.fechaCalculo = fechaCalculo;
	}
	/**
	 * @return the idResumenCalculoBonoPolizaAgente
	 */
	public Integer getIdResumenCalculoBonoPolizaAgente() {
		return idResumenCalculoBonoPolizaAgente;
	}
	/**
	 * @param idResumenCalculoBonoPolizaAgente the idResumenCalculoBonoPolizaAgente to set
	 */
	public void setIdResumenCalculoBonoPolizaAgente(
			Integer idResumenCalculoBonoPolizaAgente) {
		this.idResumenCalculoBonoPolizaAgente = idResumenCalculoBonoPolizaAgente;
	}
}
