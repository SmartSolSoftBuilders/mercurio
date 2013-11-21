/*
 * Proyecto: Estrategas Seguros - Inbursa
 * Archivo: RegistroArchivoPolizasSqlMapDaoTest.java
 * Fecha de creaci�n: 10/06/2011
 * �ltima Modificaci�n: 10/06/2011
 */

package mx.com.seguros.business.archivopolizas;

import java.io.InputStream;
import java.util.List;

import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.RegistroArchivoPolizas;
import mx.com.seguros.model.ResumenCargaArchivoPolizas;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

/**
 * Interfaz de negocio para la manipulaci�n de los archivos de p�lizas cargados
 * @author Emigdio
 */
public interface IArchivoPolizasBusiness {

    /**
     * Consulta las p�lizas cargadas pendientes cargadas desde archivo de acuerdo
     * al estado enviado como par�metro
     * @param estadoRegistroPoliza Estado requerido del registro
     * @param resultado Resultado de la consulta y configuraci�n del paginador
     */
    void consultarRegistroArchivoPolizasPorEstatus(Integer estadoRegistroPoliza, ResultadoPaginadoDTO resultado);
    /**
     * Valida, Transforma y copia los valores de un registro cargado por archivo en un objeto Poliza:
     * Solicitud, Contratante, Solicitante, Beneficiario, Poliza
     * TODO: Describir validaciones, reglas y posibilidades de actualizar una p�liza ya encontrada
     * @param idRegistroArchivoPolizas ID del registro a copiar
     * @return Poliza copiada, null en caso de error
     */
    PolizaIndividual copiarRegistroArchivoPolizaASistema(Long idRegistroArchivoPolizas);
    /**
     * Consulta un registro cargado en el archivo de p�liza por Identificador
     * @param idArchivoPoliza Identificador a buscar
     * @return Registro encontrado, null en caso de no encontrarlo
     */
    RegistroArchivoPolizas consultarRegistroArchivoPolizaPorId(Integer idArchivoPoliza);
    /**
     * Actualiza el registro de poliza cargado de archivo al estatus indicado
     * @param registroId Registro a actualizar
     * @param estatus Estatus destino
     */
    void actualizarEstatusRegistro(Long registroId,Integer estatus);
    /**
     * Inserta un nuevo registro de resumen de carga de archivo
     * @param resumenCarga Datos a insertar
     */
    void insertarResumenCargaArchivoPolizas(ResumenCargaArchivoPolizas resumenCarga);
    /**
     * Consulta los archivos que han sido cargados en el sistema
     * @return Lista con los archivos cargados
     */
    List<ResumenCargaArchivoPolizas> consultarArchivosCargados();
    /**
     * Consulta los registros cargados para cierto archivo de p�lizas y que tengan cierto estado,
     * si el estado se env�a nulo entonces no se utiliza en los criterios de b�squeda
     * @param idResumenCargaArchivoPolizas  ID del archivo para el cual se desea obtener su contenido
     * @param idEstadoRegistroPoliza Estado (opcional) de los registros
     * @return
     */
    List<RegistroArchivoPolizas> consultarRegistrosArchivoPolizaPorArchivoCargado(Integer IdResumenCargaArchivoPolizas,Integer idEstadoRegistroPoliza);
    
    /**
     * Procesa un archivo de p�lizas de inbursa
     * @param streamArchivo Stream del archivo a cargar
     * @param nombreArchivo Nombre f�sico del archivo	
     * @param usuarioCarga Nombre del usuario que realiza la carga
     */
    ResumenCargaArchivoPolizas procesarArchivoInbursa(InputStream streamArchivo, String nombreArchivo, String usuarioCarga) throws Exception;
    /**
     * Consulta un registro de resumen de carga de archivo basado en su ID
     * @param id ID a buscar
     * @return Objeto resumen econtrado, null en caso de no encontrarlos
     */
    ResumenCargaArchivoPolizas consultarArchivoPolizasPorId(Integer id);
    /**
     * Elimina un registro de archivo de p�lizas por ID
     * @param idRegistro ID a eliminar
     */
    void eliminarRegistroArchivoPolizas(Integer idRegistro);
}
