/**
 * 
 */
package mx.com.seguros.business.archivoestatus;

import java.util.List;

import mx.com.seguros.model.ArchivoTramitePoliza;

/**
 * Interfase de negocio para las operaciones sobre el archivo de carga en el sistema
 * para cambios de estaus de p�liza
 * @author Emigdio Hern�ndez
 *
 */
public interface ArchivoCambioEstatusPolizaBusiness {
	
	/**
	 * Obtiene todos los registros de los archivos de tr�mite de p�liza cargados
	 * en el sistema
	 * Nota este m�todo no retorna el archivo cargado, para obtener el archivo cargado
	 * se debe utilizar el m�todo de consultar por ID nu registro de ArchivoTramitePoliza
	 * @return
	 */
	List<ArchivoTramitePoliza> obtenerArchivosTramitePoliza();
	/**
	 * Obtiene los datos completos, incluyendo el archivo de un registro
	 * de archivo de tr�mtes de p�liza
	 * @return
	 */
	ArchivoTramitePoliza obtenerArchivosTramitePolizaPorId(Integer idArchivoTramitePoliza);
	/**
	 * Inserta un nuevo registro del archivo de tr�mites de p�liza cargdos en el sistema
	 * @param archivoTramitePoliza Datos para insertar
	 */
	void insertarArchivoTramitePoliza(ArchivoTramitePoliza archivoTramitePoliza);
	/**
	 * Actualiza los datos de un registro de archivo de tr�mites de p�liza existente
	 * @param archivoTramitePoliza Datos para la actualizaci�n
	 */
	void actualizarArchivoTramitePoliza(ArchivoTramitePoliza archivoTramitePoliza);
	/**
	 * Eliminar un registor de archivi de tr�mites de p�liza en base 
	 * a su PK
	 * @param idArchivoTramitePoliza PK a eliminar
	 */
	void eliminarArchivoTramitePoliza(Integer idArchivoTramitePoliza);
	/**
	 * Por cada rengl�n le�do del archivo de cambio de estatus actualiza el estatus de la p�liza correspondiente, 
	 * en caso de que pueda cambiarse. Genera el log del proceso e inserta el registro del archivo de cambio de estatus.
	 * Contenido de la lista:
	 * [0] N�mero de p�liza
	 * [1] N�mero de Emisor
	 * [2] Identificador de estatus
	 * Valores del Identificador de estatus que causan actualizaci�n:
	 * ENTREGADO = Cambio de Estatus Seguimiento a: P�liza Entregada a Agente
	 * SI = P�liza Entregada al Asegurado
	 * Otros valores = no se aplica cambio de estatus
	 * No se consideran validaciones de cambio de estatus
	 * @param datosArchivo Datos cargados del archivo
	 * @param contenidoArchivo Contenido binario del archivo
	 * @param usuario Usuario que carga el archivo
	 * @param nombreArchivo Nombre f�sico del archivo
	 * @throws Exception En caso de error al guardar el archivo
	 */
	void cargarArchivoCambioEstatusPoliza(List<String[]> datosArchivo, byte[] contenidoArchivo, String usuario, String nombreArchivo) throws Exception;

	/**
	 * Indicador de estatus de P�liza Entregada a Agente
	 */
	String ENTREGADO_AGENTE = "ENTREGADO";
	/**
	 * Indicador de estatus de p�liza en el archivo para P�liza Entregada al Asegurado
	 */
	String ENTREGADO_CLIENTE = "SI";
}
