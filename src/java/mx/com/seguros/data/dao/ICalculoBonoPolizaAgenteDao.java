package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.dto.BonoPolizaPorCalcularDTO;
import mx.com.seguros.model.CalculoBonoPolizaAgente;
import mx.com.seguros.model.ResumenCalculoBonoPolizaAgente;
import mx.com.seguros.model.ResumenProcesoCalculoBono;

/**
 * Interfaz del objeto de acceso a datos para las operaciones
 * sobre la tabla de calculo de bono de p�liza
 * @author Emigdio Hern�ndez
 *
 */
public interface ICalculoBonoPolizaAgenteDao {
	/**
	 * Consulta el conjunto de p�lizas con descuentos aplicados suficientes para calcular bonos y cuyos bonos
	 * no han sido calculados a�n.
	 * Se puede enviar opcionalmente como par�metro la p�liza para obtener sus bonos por calcular
	 * @param numPoliza Opcionalmente par�metro de n�mero de p�liza
	 * @param numConsignatario Opcionalmente par�metro de n�mero de consignatario
	 * @param idPlaza par�metro opcional para limitar a cierta plaza el c�lculo del bono
	 * @return
	 */
	List<BonoPolizaPorCalcularDTO> consultarBonosPendientesPorCalcular(Integer numPoliza, Integer numConsignatario, Integer idPlaza);
	/**
	 * Insertar un registro de resumen de proceso de c�lculo de bono
	 * @param resumenProceso Datos de origen
	 */
	void insertarResumenProcesoCalculoBono(ResumenProcesoCalculoBono resumenProceso);
	/**
	 * Inserta un registro de resumen de c�lculo de bono de p�liza para agente
	 * @param resumenCalculo Datos de origen
	 */
	void insertarResumenCalculoBonoPolizaAgente(ResumenCalculoBonoPolizaAgente resumenCalculo);
	/**
	 * Inserta un registro de c�lculo de bono de p�liza a agente
	 * @param calculo Datos de origen
	 */
	void insertarCalculoBonoPolizaAgente(CalculoBonoPolizaAgente calculo);
	
	/**
	  * Consulta todos los res�menes de proces de c�lculo de bonos registrados en el sistema
	  * ordenados por fecha de c�lculo
	  * @return Lista de resumenes de proceso de c�lculo de bonos
	  */
	 List<ResumenProcesoCalculoBono> consultarResumenProcesosCalculoBono();
	 /**
	  * Consulta los res�menes de c�lculo de bonos por agente de un proceso de c�lculo de bonos
	  * @param idResumenProcesoCalculoBono ID del proceso de c�lculo a filtrar
	  * @return Lista de res�menes de c�lculo de bono por agente
	  */
	 List<ResumenCalculoBonoPolizaAgente> consultarResumenCalculoBonoPolizaAgentePorIdResumenCalculo(Integer idResumenProcesoCalculoBono);
	 /**
	  * Consulta todos los detalles de c�lculo de bono de un cierto proceso de c�lculo ordenados por agente
	  * @param idResumenProcesoCalculoBono ID del proceso de c�lculo a filtrar
	  * @return Lista de detalle de c�lculo de bono de p�liza
	  */
	 List<CalculoBonoPolizaAgente> consultarDetalleCalculoBonoPolizaAgentePorIdResumenProcesoCalculoBono(Integer idResumenProcesoCalculoBono);
	 /**
	  * Consulta un registro de resumen de proceso de c�lculo por llave primaria
	  * @param idResumenProcesoCalculoBono ID a filtrar
	  * @return Resumen de c�lculo encontrado
	  */
	 ResumenProcesoCalculoBono consultarResumenProcesoCalculoBonoPorId(Integer idResumenProcesoCalculoBono);
}
