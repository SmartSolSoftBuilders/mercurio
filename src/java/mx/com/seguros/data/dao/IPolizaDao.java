/*
 * IPolizaDao.java
 *
 * Created on 25 de septiembre de 2007, 11:41 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;
import java.util.Date;
import java.util.List;
import java.util.Map;

import mx.com.seguros.model.BeneficioAdicional;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.CalendarioEnvioMovimientosDependencias;
import mx.com.seguros.model.HistorialMovimientosContratante;
import mx.com.seguros.model.PaqueteVidaDxN;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Retenedor;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

/**
 *
 * @author Cesar
 */
public interface IPolizaDao {
    public void autofinarciarPolizaCancel(PolizaIndividual polizaIndividual);
    public void cancelarPoliza(PolizaIndividual polizaIndividual);
    void insertarPoliza(PolizaIndividual poliza);
    void actualizaPolizaCambio(PolizaIndividual poliza);
    public void actualizarSolicitud(int folioSolicitud, String formatoSolicitud);
    public String obtenerPlaza(int folioSolicitud, String formatoSolicitud);
    public List obtenerPolizaNumPoliza(Map params);
    public List obtenerPolizaNumContratante(Map params);
    public List obtenerPolizaApPaternoContratante(Map params);
    public List obtenerPolizaCertificado (Map params);
    public List obtenerRfcAsegurado (Map params);
    public List obtenerApellidoAsegurado (Map params);
    public List obtenerPolizaEntregadaEmitidaAgente(String agente);
    public void actualizaEstatusPoliza (PolizaIndividual polizaIndividual);
    void actualizaEstatusPolizaPago(PolizaIndividual polizaIndivididual);
    int actualizaEstatusPolizaSeguimiento(PolizaIndividual polizaIndivididual);
    void actualizaEstatusPolizaAmbos(PolizaIndividual polizaIndivididual);
    public List obtenerEstatusPoliza ();
    public List obtenerPolizasPorEntregarAsegurado(String agente);
    public void actualizaIndicadorPagoComisionEntregaPoliza(PolizaIndividual polizaIndividual);
    public void actualizaIndicadorDescuentoComision(PolizaIndividual polizaIndividual);
    public Object obtenerPolizaPorSolicitud(int folioSolicitud, String formatoSolicitud);
    public List obtenListaDescuentosAplicados(int numPoliza);
    public String contarListaDescuentosAplicados(int numPoliza);
    public List buscarFechaCalendario(CalendarioEnvioMovimientosDependencias calendario);
    public List obtenerListaHistorialMovContratante(String contratante);
    public Retenedor obtenerRetenedor(int folioSolicitud, String formatoSolicitud);
    public Integer obtenerPolizasPorNumNominaContratante(String numNominaContratante);
    public Integer consultaContadorPolizasVigentes(String numNominaContratante);
    public List consultaPolizasVigentes(String numNominaContratante);
    public Integer consultaContadorPolizasMvtoQnaCliente(HistorialMovimientosContratante historial);
    public List consultaPolizasMvtoQnaCliente(HistorialMovimientosContratante historial);
    public String consultarClaveDescuentoPorSolicitud(int folioSolicitud, String formatoSolicitud);
    public void insertarHistorial(HistorialMovimientosContratante historial);
    public Object obtenerPolizaNumPolizaNumConsignatario(PolizaIndividual poliza);    
    public void actualizarQnaProgEnvioPoliza(PolizaIndividual poliza);
    public Object obtenerPolizasPorFolioSolicitudNoCancelada(int folioSolicitud, String formatoSolicitud);
    public List obtenListaPolizasCambio(String numNominaContratante);

    /**
     * Obtiene el detalle de una p�liza
     * @param numPoliza
     * @return
     */
    PolizaIndividual obtenerDetallePolizaPorNumero(int numPoliza,int emisor);
    /**
     * Actualiza la informaci�n general de una p�liza 
     * @param poliza Datos de origen de la p�liza
     */
	void actuzalizarPoliza(PolizaIndividual poliza);
	/**
	 * Obtiene el cat�logo de beneficios adicionales
	 * @return Lista de beneficios adicionales encontrados
	 */
	List<BeneficioAdicional> consultarCatalogoBeneficiosAdicionales();
	
	/**
	 * Obtiene el conjunto de beneficios adicionales capturados para una p�liza
	 * @param numPoliza N�mero de p�liza a buscar sus beneficios
	 * @param numConsignatario N�mero de consignatario de la p�liza a buscar sus beneficios
	 * @return Lista de beneficios adicionales
	 */
	List<BeneficioAdicionalPoliza> consultarBeneficiosAdicionalesDePoliza(int numPoliza,int numConsignatario);
	/**
	 * Elimina todos los beneficios adicionales asociados a una p�liza
	 * @param numPoliza N�emro de la p�liza a eliminar sus beneficios
	 * @param numConsignatario N�mero de consignatarios de la p�liza para 
	 * eliminar sus benficiarios
	 */
	void eliminarBeneficiosAdicionalesDePoliza(int numPoliza,int numConsignatario);
	/**
	 * Guardar los beneficios adicionales para una p�liza
	 * @param beneficios Lista de beneficios a insertar
	 */
	void guardarBeneficiosAdicionales(List<BeneficioAdicionalPoliza> beneficios);
	/**
	 * Obtiene el nombre del paquete del seguro de vida en base a su nombre clave
	 * @param nombrePaquete Nombre del paquete a buscar
	 * @return Paquete encontrado, null en caso de no encontrar
	 */
	PaqueteVidaDxN obtenerPaqueteSeguroPorNombre(String nombrePaquete);
	
	//Smart Solutions diciembre 2011
	//Inclusi�n del m�dulo de pagos
	
	PolizaIndividual obtenerPolizaById(PolizaIndividual poliza);
	
	List<PolizaIndividual> consultaPolizasVigentesNew(String numNominaContratante, Date fechaLimiteCarga);
	
	Integer recuperarQnaPrimerIntentoPago(PolizaIndividual poliza);

    void insertarQnaPrimerIntentoPago(PolizaIndividual poliza, Integer qnaPrimerIntentoPago);
    
    /**
     * Actualiza el campo de Suma Asegurada Total de una cierta p�liza
     * @param poliza Objeto de p�liza con el valor de la suma asegurada total a actualizar
     * y los valores de numero de p�liza y n�mero de consignatario de la p�liza a actualizar
     */
    void actualizarSumaAseguradaTotal(PolizaIndividual poliza);
    /**
     * Actualiza �nicamente la PK de p�liza individual
     * @param datosOriginales PK original
     * @param datosNuevos PK nueva
     */
    void actualizarPkPolizaIndividual(PolizaIndividual datosOriginales, PolizaIndividual datosNuevos);
    /**
     * Carga de la BD un conjunto de p�liza por su llave primaria en bloques de 50 p�lizas
     * @param numerosPoliza N�meros de p�liza a cargar
     * @param numerosConsignatario N�meros de emisor de p�lizas a cargar que corresponden a los n�meros de p�liza a cargar
     * @return
     */
    List<PolizaIndividual> cargarPolizasPorPKBatch(List<Integer> numerosPoliza, List<Integer> numerosConsignatario);
    /**
     * Realiza una consulta paginada para obtener en forma de batch los resultados de todas
     * aquellas p�lizas candidatas al autofinanciamiento
     * @param resultados Configuraci�n de paginaci�n
     */
    void consultarPolizasParaAutofinanciar(ResultadoPaginadoDTO<PolizaIndividual> resultados);
    /**
     * Consulta �nicamente los campos de la tabla de p�liza sin hacer ning�n cruce con otra tabla
     * @param numPoliza N�mero de p�liza
     * @param numConsignatario N�mero de consignatario
     * @return Objeto de p�liza encontrado
     */
    PolizaIndividual obtenerResumenPoliza(Integer numPoliza,Integer numConsignatario);
}

