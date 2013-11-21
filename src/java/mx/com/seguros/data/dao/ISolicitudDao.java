/*
 * ISolicitudDao.java
 *
 * Created on 29 de agosto de 2007, 02:49 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import mx.com.seguros.dto.CriteriosConsultaSolicitudesDTO;
import mx.com.seguros.model.Beneficiario;
import mx.com.seguros.model.ComisionBrutaAgente;
import mx.com.seguros.model.DetalleDescuentoComisionSolicitud;
import mx.com.seguros.model.EstatusSolicitud;
import mx.com.seguros.model.HistoricoTarifa;
import mx.com.seguros.model.Promotor;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.model.TarifaAportMensual;
import mx.com.seguros.utils.ResultadoPaginadoDTO;
/**
 *
 * @author QTX
 */
public interface ISolicitudDao {
    void insertarSolicitud(Solicitud solicitud);
    public List obtenSolicitudPorEstatusYnumNominaContratante(Solicitud solicitud);
    public Object obtenTarifaMensualPorClaveTarifa(int cveTarifa);
    List obtenListaSolicitudesVencidas(ComisionBrutaAgente comisionBrutaAgente);
    List obtenSolicitudesAgente(Solicitud solicitud);
    public Object obtenerDetalleComisionSolicitud(int folioSolicitud,String formatoSolicitud);
    public List obtenDetalleDescuentoComisionSolicitud(int folioSolicitud, String formatoSolicitud);
    public void actualizaDetalleDescuentoComisionSolicitud(DetalleDescuentoComisionSolicitud detalleDescComSolic);
    public void insertaDetalleDescuentoComisionSolicitud(DetalleDescuentoComisionSolicitud detalleDescComSolic);
    public Object obtenSolicitudPorFolioSolicitud(int folioSolicitud, String formatoSolicitud);
    /**
     * Busca un registro de tarifa mensual utilizando filtro de importe
     * @param importeTarifa Importe a buscar
     * @return Tarifa encontrada, null si no se localiza
     */
    TarifaAportMensual obtenerTarifaMensualPorImporte(double importeTarifa);
    
   
    /**
     * Inserta los datos m�nimos de la solicitud
     * @param solicitud Datos fuente
     */
    void insertarSolicitudDeArchivo(Solicitud solicitud);
    /**
     * Realiza la consulta general de solicitudes de seguro utilizando
     * el objeto de criterios enviado como par�metro al m�todo
     * @param criterios Criterios a utiliza
     * @param resultado Banderas de control y resultado de la ejecucion
     */
    void consultarSolicitudes(CriteriosConsultaSolicitudesDTO criterios, ResultadoPaginadoDTO resultado);
    /**
     * Consulta el detalle completo de una solicitud de seguro en base a su folio
     * @param folioSolicitud Folio de la solicitud a consultar
     * @return folio
     */
    Solicitud obtenerDetalleSolicitudPorFolio(int folioSolicitud, String formatoSolicitud);
    /**
     * Actualiza los datos de una solicitud en la BD
     * @param solicitud Datos de origen a actualizar
     */
    public void actualizarSolicitud(Solicitud solicitud);
    /**
     * Consulta el cat�logo de estados solicitudes
     * @return Lista de estados de solicitud
     */
    List<EstatusSolicitud> consultarEstatusSolicitud();
    
    public Collection<Solicitud> obtenSolicitudCollPorNumNominaContratante(String numNominaContratante, Date parseFromQnaToDate);
    /**
     * Actualiza el campo de tarifaTotal para una cierta solicitud
     * @param solicitud Solicitud de la cu�l tomar el valor de tarifa total para actualizar
     * una solicitud basado en su folioSolicitud y numeroFormato
     */
    void actualizarTarifaTotal(Solicitud solicitud);
    /**
     * Realiza una consulta de los beneficiarios de una solicitud
     * @param foliosSolicitud Folio de la solicitud para buscar sus beneficiarios
     * @param formatoSolicitud Formato de la solicitus para buscar sus beneficiarios
     * @return Lista de beneficiarios asociados a la solicitud
     */
    List<Beneficiario> consultarBeneficiarios(Integer foliosSolicitud, String formatoSolicitud);
    /**
     * Consulta el promotor por su llave primaria 
     * @param cvePromotor PK del promotor a buscar
     * @return El promotor encontrado, null en otro caso
     */
    Promotor buscarPromotor(Integer cvePromotor);
    /**
     * Realiza la actualizaci�n �nicamente de la llave primaria del objeto Solicitud
     * @param datosOriginales Objeto con la PK actual
     * @param datosNuevos Objeto con la PK nueva
     */
    void actualizarPKSolicitud(Solicitud datosOriginales,Solicitud datosNuevos);
    /**
     * Inserta un nuevo registro de HistoricoTarifa
     * @param historico Datos para relizar la inserci�n
     */
    void insertarHistoricoTarifa(HistoricoTarifa historico);
    /**
     * Consulta el hist�rico de tarifas de una solicitud
     * @param solicitud Solicitud para la cu�l consultar el hist�rico de tarifas
     * @return Lista con el hist�rico de tarifas de solicitud
     */
    List<HistoricoTarifa> consultarHistoricoTarifaSolicitud(Solicitud solicitud);
    /**
     * Consulta el hist�rico de tarifa con la fecha m�s grande que sea menor o igual a la fecha
     * en que se desea cosultar el hist�rico
     * @param sol Solicitud
     * @param fecha Fecha de consulta para la tarifa
     * @return Objeto de hist�rico, null si no se encuentra tarifa
     */
    HistoricoTarifa consultarHistoricoTarifaEnFecha(Solicitud sol, Date fecha);
    
}
