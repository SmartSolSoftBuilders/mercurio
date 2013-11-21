/**
 * 
 */
package mx.com.seguros.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Resumen del c�lculo del bono del agente de un conjunto de p�lizas y meses
 * Este objeto de mapeo almacena el c�lculo final del bono para un agente despu�s de ejecutar
 * el proceso del c�lculo de bono
 * @author Emigdio Hernandez
 *
 */
public class ResumenCalculoBonoPolizaAgente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Identificador �nico
	 */
	private Integer idResumenCalculoBonoPolizaAgente = null;
	/**
	 * Monto del bono total para el agente
	 */
	private BigDecimal montoBono = null;
	/**
	 * Fecha de c�lculo del bono
	 */
	private Date fechaCalculo = null;
	/**
	 * Clave del agente para el cu�l es el bono
	 */
	private Integer cveAgente = null;
	/**
	 * Objeto de agente con los dem�s datos
	 */
	private Agente agente = null;
	/**
	 * Detalle del c�lculo del bono por p�liza del agente
	 */
	private List<CalculoBonoPolizaAgente> listaDetalleCalculo = new ArrayList<CalculoBonoPolizaAgente>();
	/**
	 * ID del registro del resuemn del proceso del c�lculo del bono
	 */
	private Integer idResumenProcesoCalculoBono = null;
	/**
	 * @return the idResumenCalculoBonoPolizaAgente
	 */
	public Integer getIdResumenCalculoBonoPolizaAgente() {
		return idResumenCalculoBonoPolizaAgente;
	}

	/**
	 * @param idResumenCalculoBonoPolizaAgente the idResumenCalculoBonoPolizaAgente to set
	 */
	public void setIdResumenCalculoBonoPolizaAgente(Integer idResumenCalculoBonoPolizaAgente) {
		this.idResumenCalculoBonoPolizaAgente = idResumenCalculoBonoPolizaAgente;
	}

	/**
	 * @return the montoBono
	 */
	public BigDecimal getMontoBono() {
		return montoBono;
	}

	/**
	 * @param montoBono the montoBono to set
	 */
	public void setMontoBono(BigDecimal montoBono) {
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
	 * @return the agente
	 */
	public Agente getAgente() {
		return agente;
	}

	/**
	 * @param agente the agente to set
	 */
	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	/**
	 * @return the listaDetalleCalculo
	 */
	public List<CalculoBonoPolizaAgente> getListaDetalleCalculo() {
		return listaDetalleCalculo;
	}

	/**
	 * @param listaDetalleCalculo the listaDetalleCalculo to set
	 */
	public void setListaDetalleCalculo(
			List<CalculoBonoPolizaAgente> listaDetalleCalculo) {
		this.listaDetalleCalculo = listaDetalleCalculo;
	}

	/**
	 * @return the idResumenProcesoCalculoBono
	 */
	public Integer getIdResumenProcesoCalculoBono() {
		return idResumenProcesoCalculoBono;
	}

	/**
	 * @param idResumenProcesoCalculoBono the idResumenProcesoCalculoBono to set
	 */
	public void setIdResumenProcesoCalculoBono(Integer idResumenProcesoCalculoBono) {
		this.idResumenProcesoCalculoBono = idResumenProcesoCalculoBono;
	}
	
	

}
