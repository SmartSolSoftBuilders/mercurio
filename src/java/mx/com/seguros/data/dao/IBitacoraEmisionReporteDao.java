/**
 * 
 */
package mx.com.seguros.data.dao;

import mx.com.seguros.model.BitacoraEmisionReporte;

/**
 * Definici�n de la interfaz del objeto de acceso a datos a la tabla de BitacoraEmisionReporte
 * @author Emigdio Hern�ndez
 *
 */
public interface IBitacoraEmisionReporteDao {

	/**
	 * Inserta un nuevo registro en la bit�cora de emisi�n de reportes
	 * @param datosEntrada Datos origen
	 */
	void insertarBitacoraEmisionReporte(BitacoraEmisionReporte datosEntrada);
}
