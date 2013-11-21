/**
 * 
 */
package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.model.Oficina;
import mx.com.seguros.model.TipoTramite;
import mx.com.seguros.model.TramitePoliza;

/**
 * Definici�n de la interfaz del objeto de acceso a datos
 * para las operaciones relacionadas con la bit�cora de tr�mites
 * de p�liza
 * @author Emigdio HErn�ndez
 *
 */
public interface TramitePolizaDao {
	/**
	 * Consulta el cat�lgo de tipos de tr�mites
	 * @return Los tipos de tr�mite disponibles en el sistema
	 */
	List<TipoTramite> obtenerCatalogTipoTramite();
	
	/**
	 * Consulta el cat�lgo de oficinas de estrategas
	 * @return Las oficinas disponibles en el sistema
	 */
	List<Oficina> obtenerCatalogOficinas();
	/**
	 * Obtiene un registro del tipo de tr�mite por su llave primara
	 * @param idTipoTramite Llave primaria del tipo de tr�mite a buscar
	 * @return Tipo de Tr�mite encontrado
	 */
	TipoTramite obtenerTipoTramitePorId(Integer idTipoTramite);
	/**
	 * Consulta la bit�cora de tr�mites relacionados con una p�liza ordenados por fecha
	 * @param numPoliza Criterio de b�squeda
	 * @param numConsignatario Criterio de b�queda
	 * @return Lista de tr�mites relacionados a una p�liza
	 */
	List<TramitePoliza> obtenerTramitesDePoliza(Integer numPoliza, Integer numConsignatario);
	/**
	 * Inserta en la base de datos un nuevo registro de tr�mite p�liza con los datos
	 * enviados como par�metro.
	 * @param tramite Datos del tr�mite
	 */
	void insertarTramitePoliza(TramitePoliza tramite);
}
