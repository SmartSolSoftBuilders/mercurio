/**
 * 
 */
package mx.com.seguros.business.archivoretiros;

import java.util.List;

import mx.com.seguros.model.ArchivoRetirosCargado;
import mx.com.seguros.model.ArchivoTramitePoliza;
import mx.com.seguros.model.TramiteRetiro;

/**
 * Interfase de negocio para las operaciones sobre el archivo de carga en el sistema
 * para la aplicaci�n de retiros
 * @author Emigdio Hern�ndez
 *
 */
public interface ArchivoTramiteRetirosBusiness {
	
	/**
	 * Obtiene todos los registros de los archivos de tr�mite de retiros cargados
	 * en el sistema
	 * Nota este m�todo no retorna el archivo cargado, para obtener el archivo cargado
	 * se debe utilizar el m�todo de consultar por ID nu registro de ArchivoRetirosCargado
	 * @return
	 */
	List<ArchivoRetirosCargado> obtenerArchivosRetiroCargados();
	/**
	 * Obtiene los datos completos, incluyendo el archivo de un registro
	 * de archivo de tr�mites de retiro
	 * @return
	 */
	ArchivoRetirosCargado obtenerArchivoRetirosPorId(Long idArchivo);
	/**
	 * Inserta un nuevo registro del archivo de tr�mites de retiro cargdos en el sistema
	 * @param archivoTramitePoliza Datos para insertar
	 */
	void insertarArchivoRetiros(ArchivoRetirosCargado archivo);
	/**
	 * Actualiza los datos de un registro de archivo de tr�mites de retiro existente
	 * @param archivo Datos para la actualizaci�n
	 */
	void actualizarArchivoRetiros(ArchivoRetirosCargado archivo);
	/**
	 * Eliminar un registor de archivo de retiros en base
	 * a su PK
	 * @param idArchivo PK a eliminar
	 */
	void eliminarArchivoRetiros(Long idArchivo);
	
	/**
	 * Por cada rengl�n le�do del archivo de tr�mite de retiros de asegurados correspondiente. 
	 * Genera el log del proceso e inserta el registro del archivo de tr�mites de retiro
	 * Contenido de la lista:
	 * [0] N�mero de Emisor
	 * [1] N�mero de Poliza
	 * [2] Concepto del retiro
	 * [3] Monto del retiro
	 * [4] Operador
	 * [5] Sucursal
	 * [6] Fecha del tr�mite
	 * @param datosArchivo Datos cargados del archivo
	 * @param contenidoArchivo Contenido binario del archivo
	 * @param usuario Usuario que carga el archivo
	 * @param nombreArchivo Nombre f�sico del archivo
	 * @throws Exception En caso de error al guardar el archivo
	 */
	void cargarArchivoRetiros(List<String[]> datosArchivo, byte[] contenidoArchivo, String usuario, String nombreArchivo) throws Exception;
	/**
	 * Consulta el detalle de la lista de retiros realizados por un asegurado
	 * @param numNominaContratante N�mero de n�mina del contratante del cu�l se buscan sus retiros
	 * @return Lista de retiros
	 */
	List<TramiteRetiro> consultarTramitesDeRetiroDeAsegurado(String numNominaContratante);
}
