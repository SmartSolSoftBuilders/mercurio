package mx.com.seguros.business.pagos;

import java.math.BigDecimal;

import mx.com.seguros.business.pagos.exception.SaldoNegativoException;
import mx.com.seguros.model.CuentaCliente;

public interface CuentaClienteBusiness {

	/**
	 * Recupera la cuenta del cliente.
	 * 
	 * @param numNominaContratante
	 * @return null si no existe una cuenta asociada al cliente de RFC dado.
	 */
	CuentaCliente findById(String numNominaContratante);

	Boolean updateCuentaCliente(CuentaCliente cuentaCliente,
			BigDecimal importeTransaccion) throws SaldoNegativoException;

	/**
	 * Crea una cuenta nueva para el cliente, con saldo en cero.
	 * @param numNominaContratante
	 */
	CuentaCliente createCuentaCliente(String numNominaContratante);

}
