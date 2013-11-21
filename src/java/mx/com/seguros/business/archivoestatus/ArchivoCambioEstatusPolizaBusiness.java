/**
 * 
 */
package mx.com.seguros.business.archivoestatus;

import java.util.List;

import mx.com.seguros.model.ArchivoTramitePoliza;

/**
 * Interfase de negocio para las operaciones sobre el archivo de carga en el sistema
 * para cambios de estaus de póliza
 * @author Emigdio Hernández
 *
 */
public interface ArchivoCambioEstatusPolizaBusiness {
	
	/**
	 * Obtiene todos los registros de los archivos de trámite de póliza cargados
	 * en el sistema
	 * Nota este método no retorna el archivo cargado, para obtener el archivo cargado
	 * se debe utilizar el método de consultar por ID nu registro de ArchivoTramitePoliza
	 * @return
	 */
	List<ArchivoTramitePoliza> obtenerArchivosTramitePoliza();
	/**
	 * Obtiene los datos completos, incluyendo el archivo de un registro
	 * de archivo de trámtes de póliza
	 * @return
	 */
	ArchivoTramitePoliza obtenerArchivosTramitePolizaPorId(Integer idArchivoTramitePoliza);
	/**
	 * Inserta un nuevo registro del archivo de trámites de póliza cargdos en el sistema
	 * @param archivoTramitePoliza Datos para insertar
	 */
	void insertarArchivoTramitePoliza(ArchivoTramitePoliza archivoTramitePoliza);
	/**
	 * Actualiza los datos de un registro de archivo de trámites de póliza existente
	 * @param archivoTramitePoliza Datos para la actualización
	 */
	void actualizarArchivoTramitePoliza(ArchivoTramitePoliza archivoTramitePoliza);
	/**
	 * Eliminar un registor de archivi de trámites de póliza en base 
	 * a su PK
	 * @param idArchivoTramitePoliza PK a eliminar
	 */
	void eliminarArchivoTramitePoliza(Integer idArchivoTramitePoliza);
	/**
	 * Por cada renglón leído del archivo de cambio de estatus actualiza el estatus de la póliza correspondiente, 
	 * en caso de que pueda cambiarse. Genera el log del proceso e inserta el registro del archivo de cambio de estatus.
	 * Contenido de la lista:
	 * [0] Número de póliza
	 * [1] Número de Emisor
	 * [2] Identificador de estatus
	 * Valores del Identificador de estatus que causan actualización:
	 * ENTREGADO = Cambio de Estatus Seguimiento a: Póliza Entregada a Agente
	 * SI = Póliza Entregada al Asegurado
	 * Otros valores = no se aplica cambio de estatus
	 * No se consideran validaciones de cambio de estatus
	 * @param datosArchivo Datos cargados del archivo
	 * @param contenidoArchivo Contenido binario del archivo
	 * @param usuario Usuario que carga el archivo
	 * @param nombreArchivo Nombre físico del archivo
	 * @throws Exception En caso de error al guardar el archivo
	 */
	void cargarArchivoCambioEstatusPoliza(List<String[]> datosArchivo, byte[] contenidoArchivo, String usuario, String nombreArchivo) throws Exception;

	/**
	 * Indicador de estatus de Póliza Entregada a Agente
	 */
	String ENTREGADO_AGENTE = "ENTREGADO";
	/**
	 * Indicador de estatus de póliza en el archivo para Póliza Entregada al Asegurado
	 */
	String ENTREGADO_CLIENTE = "SI";
}
