/*
 * IPolizaBusiness.java
 *
 * Created on 24 de septiembre de 2007, 07:27 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.business.poliza;

import java.util.Date;
import java.util.List;

import mx.com.seguros.business.reporte.ReportesPDF;
import mx.com.seguros.model.BeneficioAdicional;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.EstatusPolizaPagos;
import mx.com.seguros.model.EstatusPolizaSeguimiento;
import mx.com.seguros.model.Oficina;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.TipoTramite;
import mx.com.seguros.model.TramitePoliza;
import mx.com.seguros.web.poliza.AutofinanciarPolizaCancelCommand;
import mx.com.seguros.web.poliza.CancelarPolizaCommand;
import mx.com.seguros.web.poliza.ConsultaPolizaCommand;
import mx.com.seguros.web.poliza.GenerarEntregaPolizaCommand;
import mx.com.seguros.web.poliza.GenerarFormatoAplicDescCommand;
import mx.com.seguros.web.poliza.GenerarFormatoDescuentoCommand;
import mx.com.seguros.web.poliza.RegistroPolizaCommand;
/**
 *
 * @author Cesar
 */
public interface IPolizaBusiness {
    /** Creates a new instance of IPolizaBusiness */
    void autofinanciarPoliza(AutofinanciarPolizaCancelCommand datosPoliza);
    void actualizarPoliza(CancelarPolizaCommand datosPoliza);
    void registrarPoliza(RegistroPolizaCommand datosPoliza);
    void registrarAsegurado(RegistroPolizaCommand datosPoliza);
    void generarReportes(RegistroPolizaCommand datosPoliza);
    ReportesPDF obtenerReportesGenerados (RegistroPolizaCommand datosPoliza);
    String generarReportes2(GenerarEntregaPolizaCommand datosPoliza);
    ReportesPDF obtenerReportesGenerados2 (GenerarEntregaPolizaCommand datosPoliza);
    String generarReportes3(GenerarFormatoDescuentoCommand datosPoliza);
    ReportesPDF obtenerReportesGenerados3 (GenerarFormatoDescuentoCommand datosPoliza);
    String generarReportes4(GenerarFormatoAplicDescCommand datosPoliza);
    ReportesPDF obtenerReportesGenerados4 (GenerarFormatoAplicDescCommand datosPoliza);
    String generarReportes5(ConsultaPolizaCommand datosPoliza);
    ReportesPDF obtenerReportesGenerados5 (ConsultaPolizaCommand datosPoliza);
    List obtenerEstatusPoliza();
    List obtenerPolizaEntregadaEmitidaAgente(String agente);
    void actualizaEstatusPoliza (int poliza,int numConsignatario,int estatus);
    void actualizaEstatusPolizaPago(int poliza,int numConsignatario,int estatus);
    void actualizaEstatusPolizaSeguimiento(int poliza,int numConsignatario,int estatus);
    void actualizaEstatusPolizaAmbos(int poliza,int numConsignatario,int estatusPago,int estatusSeguimiento);
    List obtenerPolizasPorEntregarAsegurado(String agente);
    void actualizaPolizaEntregadaAsegurado(int poliza,int numConsignatario,int estatus,String nombreReceptor, Date fechaRecepcion);
    /**
     * Mantenimieto: QTX Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
     */
    Object obtenerPolizasPorFolioSolicitudNoCancelada(int folioSolicitud,String formatoSolicitud);
    /**
     * Obtiene el detalle de una p�liza
     * @param numPoliza numero de poliza
     * @param emisor numero de consignatario
     * @return
     */
    PolizaIndividual obtenerDetallePolizaPorNumero(int numPoliza,int emisor);
    
    void actualizarPolizaIndividual(PolizaIndividual poliza);
    
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
	 * Guardar los beneficios adicionales para una p�liza, se recalcular�n los valores
	 * de tarifa total y de suma asegurada total
	 * @param poliza Poliza Individual para la cu�l almacenar los beneficios adicionales, los beneficios adicionales
	 * se deben de encontrar dentro de este objeto de solicitud para ser almacenados
	 */
	void guardarBeneficiosAdicionales(PolizaIndividual poliza);
    
    //Smart solutions diciembre 2011
    //Integraci�n del m�dulo de pagos
	List<PolizaIndividual> obtenerPolizasVigentesContratante(String numNominaContratante, Date fechaLimiteCarga);
    
    Integer recuperarQnaPrimerIntentoPago(PolizaIndividual poliza);
    
    void insertarFechaPrimerIntentoPago(PolizaIndividual poliza, Integer qnaPrimerIntentoPago);
    
    /**
	 * Consulta el cat�logo de estados de p�liza de seguimiento
	 * @return Lista de estados de p�liza
	 */
	List<EstatusPolizaSeguimiento> consultarEstatusPolizaSeguimiento();
	/**
     * Consulta el cat�logo de estatus de pagos de p�liza    
     * @return Lista de valores del cat�logo de p�lizas
     */
    List<EstatusPolizaPagos>  consultarEstatusPolizaPagos();
    
    public PolizaIndividual findPolizaById(PolizaIndividual poliza);
   /**
    * Engloba los proceso de alta de p�liza para incluirlas en una sola transacci�n
    * @param datosPoliza
    */
    void registrarPolizaCompleto(RegistroPolizaCommand datosPoliza);
    
    /**
	 * Consulta el cat�lgo de tipos de tr�mites
	 * @return Los tipos de tr�mite disponibles en el sistema
	 */
	List<TipoTramite> obtenerCatalogTipoTramite();
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
    
	/**
	 * Consulta el cat�lgo de oficinas de estrategas
	 * @return Las oficinas disponibles en el sistema
	 */
	List<Oficina> obtenerCatalogOficinas();
}
