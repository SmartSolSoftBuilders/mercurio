/**
 * 
 */
package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.model.ArchivoTramitePoliza;

/**
 * Interfaz para el objeto de acceso a datos para las operaciones sobre la entidad
 * de archivos de tr�mites de p�liza cargados en el sistema
 * @author Emigdio Hernandez
 *
 */
public interface ArchivoTramitePolizaDao {
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
	
}
