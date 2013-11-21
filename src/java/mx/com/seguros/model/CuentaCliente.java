/**
 * 
 */
package mx.com.seguros.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Objeto del modelo que representa la tabla CuentaCliente
 * @author SmartSolutions
 *
 */
public class CuentaCliente {
	
	private String numNominaContratante;
	private BigDecimal saldoCuenta;
	private Date fechaCalculoSaldo;
	private int transaccionId;
	/**
	 * @return the numNominaContratante
	 */
	public String getNumNominaContratante() {
		return numNominaContratante;
	}
	/**
	 * @param numNominaContratante the numNominaContratante to set
	 */
	public void setNumNominaContratante(String numNominaContratante) {
		this.numNominaContratante = numNominaContratante;
	}
	/**
	 * @return the saldoCuenta
	 */
	public BigDecimal getSaldoCuenta() {
		return saldoCuenta;
	}
	/**
	 * @param saldoCuenta the saldoCuenta to set
	 */
	public void setSaldoCuenta(BigDecimal saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}
	/**
	 * @return the fechaCalculoSaldo
	 */
	public Date getFechaCalculoSaldo() {
		return fechaCalculoSaldo;
	}
	/**
	 * @param fechaCalculoSaldo the fechaCalculoSaldo to set
	 */
	public void setFechaCalculoSaldo(Date fechaCalculoSaldo) {
		this.fechaCalculoSaldo = fechaCalculoSaldo;
	}
	/**
	 * @return the transaccionId
	 */
	public int getTransaccionId() {
		return transaccionId;
	}
	/**
	 * @param transaccionId the transaccionId to set
	 */
	public void setTransaccionId(int transaccionId) {
		this.transaccionId = transaccionId;
	}

}
