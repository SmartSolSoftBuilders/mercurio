/**
 * 
 */
package mx.com.seguros.business.comisiones;

import java.util.List;

import mx.com.seguros.business.pagos.exception.PagosBusinessException;
import mx.com.seguros.model.ResumenCalculoBonoPolizaAgente;
import mx.com.seguros.model.ResumenProcesoCalculoBono;

/**
 * Interfaz del servicio para las operaciones  del c�lculo de bono de comisiones de p�lizas
 * @author Emigdio Hernandez
 *
 */
public interface CalculoBonoPolizaBusiness {
	
	/**
	 * Obtiene el c�lculo de los bonos nuevos para las p�lizas que tengan suficientes pagos 
	 * y que no tengan completamente calculados los bonos
	 * Opcionalmente se puede enviar el n�mero de p�liza y n�mero de consignatario 
	 * para obtener el c�lculo de s�lo una p�liza.
	 * Este c�lculo no se almacena en BD, �nicamente es calculado
	 * @param numPoliza N�mero opcional de p�liza
	 * @param numConsignatario N�mro opcional de consignatario
	 * @param Identificador opcional de la plaza que debe ser considerada para el c�lculo
	 */
	 List<ResumenCalculoBonoPolizaAgente>  obtenerCalculoDeBonosAFechaActual(Integer numPoliza, Integer numConsignatario, Integer idPlaza);
	 /**
	  * Calcula y registra de forma definitiva el bono de conservaci�n a la fecha actual.
	  * Opcionalmente se puede enviar el n�mero de p�liza y n�mero de consignatario 
	  * para obtener el c�lculo de s�lo una p�liza.
	  * @param numPoliza N�mero opcional de p�liza
	  * @param numConsignatario N�mro opcional de consignatario
	  * @return Objeto creado y registrado ya en BD
	  */
	 ResumenProcesoCalculoBono registrarCalculoBonoFinal(Integer numPoliza, Integer numConsignatario,String usuario, Integer idPlaza) throws PagosBusinessException;
	 /**
	  * Consulta todos los res�menes de proces de c�lculo de bonos registrados en el sistema
	  * ordenados por fecha de c�lculo
	  * @return Lista de resumenes de proceso de c�lculo de bonos
	  */
	 List<ResumenProcesoCalculoBono> consultarResumenProcesosCalculoBono();
	 /**
	  * Consulta los detalles por agente y por p�liza de un proceso de c�lculo de bono
	  * @param idResumenProcesoCalculoBono ID del proceso a consultar
	  * @return Objeto de resumen de proceso de c�lculo con las lista de detalle llenas
	  */
	 ResumenProcesoCalculoBono consultaDetalleProcesoCalculoBono(Integer idResumenProcesoCalculoBono);
	
}
