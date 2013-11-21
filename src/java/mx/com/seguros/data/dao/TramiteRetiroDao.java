/**
 * 
 */
package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.model.TramiteRetiro;

/**
 * Interfaz del objeto de acceso a datos para la manipulaci�n
 * de los registors de tr�mites de retiros realizados por asegurados
 * @author Emigdio Hern�ndez
 *
 */
public interface TramiteRetiroDao {
	/**
	 * Inserta un nuevo registro de tr�mite de retiro en la BD
	 * @param tramite
	 */
	void insertarTramiteRetiro(TramiteRetiro tramite);
	/**
	 * Consulta la lista de tr�mites de retiro asociados a un asegurado en espec�fico
	 * @param numNominaContratante
	 * @return
	 */
	List<TramiteRetiro> consultarTramitesRetiroPorAsegurado(String numNominaContratante);
}
