package mx.com.seguros.data.dao;

import mx.com.seguros.model.CuentaCliente;

public interface CuentaClienteDao {

	CuentaCliente obtenerCuentaClienteByNumNominaContratante(
			String numNominaContratante);

	/** @return true si la actualizacion fue exitosa */
	Boolean updateCuentaCliente(CuentaCliente cuentaCliente);

	/**
	 * NOTE Cuando se invoque a este metodo la cuenta del cliente debe estar
	 * completamente llena, con los 4 parametros debidamente inicializados:
	 * numNominaContratante, fechaCalculo, transId & saldoCuenta.
	 * 
	 * @param cuentaCliente
	 */
	void createCuentaCliente(CuentaCliente cuentaCliente);

	// boolean registrarPagoRecibido(String numNominaContratante,
	// BigDecimal importeReportado, int numQna);

}
