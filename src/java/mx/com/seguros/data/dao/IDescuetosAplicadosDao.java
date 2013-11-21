package mx.com.seguros.data.dao;

/**
 *
 * @author Capacitacion
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mx.com.seguros.model.ArchivosDescuentosCargados;
import mx.com.seguros.model.CifrasControlProcesoAutofinanciar;
import mx.com.seguros.model.DescuentosAplicados;
import mx.com.seguros.model.PolizaIndividual;

public interface IDescuetosAplicadosDao {
    
	public List obtenDescuentosPorPoliza(PolizaIndividual poliza);

    public void insertarDescuentoAplicado(DescuentosAplicados descuento);

    public Object obtenIndiceArchivo(Integer numQuincena);

    public List obtenArchivosCargados();

    public void insertaDatosArchivo(ArchivosDescuentosCargados archivoCargado);

    public Object obtenerUltimoImporteRealPagoPrima(DescuentosAplicados descuento);

    /**
     * Recupera a todas las quincenas donde se ha reportado pago de la poliza
     * definida.
     *
     * @param poliza
     * @return
     */
    List<Integer> findQnasPagoReportadoByPoliza(PolizaIndividual poliza);

    /**
     * En este caso, se recupera al descuento final pagado (ie numQnaArchivo =
     * numQnaPagada) para ese id de archivo
     *
     * @param poliza
     * @param numQnaArchivo
     * @return
     */
    DescuentosAplicados findDescuentoByPolizaQuincenaReportada(PolizaIndividual poliza, Integer numQnaArchivo);

    /**
     * Regresa la lista de todos los descuentos asociados a pagos (de prima y
     * fondo) que se han cubierto con el monto reportado en el archivo del
     * retenedor definido por el numero de quincena dado.
     *
     * @param poliza
     * @param numQnaArchivo
     * @return
     */
    List<DescuentosAplicados> findDescuentoPrimaByPolizaQnaArchivo(PolizaIndividual poliza, Integer numQnaArchivo);

    Integer findFechaPrimerPagoInt(PolizaIndividual poliza);

    int obtenerNumeroPagosAplicadosPoliza(PolizaIndividual poliza);

    BigDecimal obtenerMontoTotalFondoAhorro(PolizaIndividual poliza);

    Integer obtenerUltimaQuincenaPagadaPoliza(PolizaIndividual poliza);

    List obtenDescuentosPorPoliza(DescuentosAplicados descuento);

    /**
     * Recupera los parametros necesarios en el reporte de descuentos aplicados.
     * Se trata de datos de diversas tablas, tales como el contratante, la
     * solicitud, la plaza, y la poliza.
     *
     * @param poliza
     * @return
     */
    Map<String, Object> findParametrosReporteDescuentos(PolizaIndividual poliza);
    /**
     * Obtiene el �ltimo descuento aplicado a la p�liza
     * @return Objeto que representa el �ltimo descuento aplicado
     */
    DescuentosAplicados obtenUltimoDescuentoConVigenciaPorPoliza(PolizaIndividual poliza);
    /**
     * Isertar un nuevo registro de cifras de control del proceso de autofinanciar p�lizas
     * @param cifras Datos de origen
     */
    void insertarCifrasControlProcesoAutofinanciar(CifrasControlProcesoAutofinanciar cifras);
    /**
     * Consulta los descuentos aplicados de una cierta p�liza proveniente de cierto archivo de aplicaci�n
     * @param params Datos para realizar la consulta
     * @return Lista de descuentos encontrados
     */
    List<DescuentosAplicados> obtenerDescuentosAplicadosPorPolizayQuincenaArchivo(DescuentosAplicados params);
    /**
     * Verificar si existe al mens un descuento por poliza y quincena de archivo
     * @param descuento Datos del descuento a aplicar
     * @return True si existe al menos un descuento para la p�liza cuya quincena de archivo corresponda a la
     * quincena del archivo de par�metro
     */
	boolean existeDescuentoAplicadoPorPolizayQuincenaArchivo(DescuentosAplicados descuento);
	/**
	 * Obtiene una lista de los descuentos de una p�liza que han sido aplicados como pago de prima de seguro
	 * @param numPoliza N�mero de p�liza a filtrar
	 * @param numConsignatario N�mero de consignatario a filtrar
	 * @return Lista de descuentos encontrados
	 */
	List<DescuentosAplicados> obtenerDescuentosAplicadosConPagoPrima(Integer numPoliza, Integer numConsignatario);
	/**
	 * Varifica si los descuentos aplicados de un archivo de aplicaci�n de pagos intervienen en alg�n c�lculo de bonos de p�liza
	 * de agente
	 * @param idArchivoAplicacionDescuentos Identificador del archvo a verificar
	 * @return True si intervienen, false en otro caso
	 */
	boolean existenCalculosDeBonoDeArchivoDeAplicacionDePagos(Long idArchivoAplicacionDescuentos);
	/**
	 * Obtiene una lista de los descuentos que fueron aplicados desde cierto archivo de aplicaci�n
	 * de pagos.
	 * @param idArchivoAplicacion Identificador del archivo de aplicaci�n de pagos
	 * @return Lista con los descuentos aplicados
	 */
	List<DescuentosAplicados> obtenerDescuentosAplicadosDeArchivoDeAplicacion(Long idArchivoAplicacion);
	/**
	 * Elimina un registro de descuento aplicado de la base de datos
	 * @param descuentos descuento a eliminar
	 */
	void eliminarDescuentoAplicado(DescuentosAplicados descuento);
}
