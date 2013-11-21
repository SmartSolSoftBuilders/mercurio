/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.seguros.web.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.business.solicitud.ISolicitudBusiness;
import mx.com.seguros.model.Agente;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.model.TarifaAportMensual;
import mx.com.seguros.utils.ConstantesGenerales;
import mx.com.seguros.web.poliza.ConsultaPolizaCommand;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Controller dedicado a atender las solicitudes de una consulta detallada de
 * solicitud de seguro
 * @author Emigdio Hern�ndez
 */
public class ConsultaDetalleSolicitudController extends AbstractController{

    private IPolizaBusiness polizaBusiness;

    private ISolicitudBusiness solicitudBusiness;
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        boolean emitirReporteDescuentos = request.getParameter("_finish")!=null;
        ModelAndView mv = null;
        Integer numPoliza = NumberUtils.toInt(request.getParameter("numPoliza"));
        Integer emisor = NumberUtils.toInt(request.getParameter("emisor"));
        if(emitirReporteDescuentos){
        	ConsultaPolizaCommand datosPoliza = new ConsultaPolizaCommand();
        	datosPoliza.getPolizaIndividual().setNumPoliza(numPoliza);
        	datosPoliza.getPolizaIndividual().setNumConsignatario(emisor);
            polizaBusiness.generarReportes5(datosPoliza);
            request.getSession().setAttribute("ReportesPDF",polizaBusiness.obtenerReportesGenerados5(datosPoliza));
            mv = new ModelAndView("registroPoliza/reporteAplicDescExitoso");
        }else{
        	mv = new ModelAndView("consulta/detalleSolicitud");
        	
            Integer folioSolicitud = NumberUtils.toInt(request.getParameter("folioSolicitud"));
            String formatoSolicitud = request.getParameter("formatoSolicitud");
            PolizaIndividual poliza = polizaBusiness.obtenerDetallePolizaPorNumero(numPoliza,emisor);

            Solicitud sol = solicitudBusiness.obtenerDetalleSolicitudPorFolio(folioSolicitud,formatoSolicitud);
            
            
            if(sol.getCveAgente() != null){
            	Agente agente = solicitudBusiness.obtenerAgentePorCveAgente(sol.getCveAgente());
                sol.setAgente(agente);
                if(sol.getAgente() != null){
                	sol.getAgente().setEmpleado(solicitudBusiness.obtenerEmpleadoPorCveEmpleado(agente.getCveEmpleado()));
                }
            }
            if(poliza == null){
            	poliza = new PolizaIndividual();
            }
            //Preparar la suma asegurada total
            double totalBeneficios = 0;
            double totalTarifaBeneficio = 0;
            if(poliza.getBeneficiosAdicionales() != null){
            	for(BeneficioAdicionalPoliza benef:poliza.getBeneficiosAdicionales()){
                	totalBeneficios+=benef.getMontoCobertura()!=null?benef.getMontoCobertura():0;
                	totalTarifaBeneficio+=benef.getSumaBeneficio()!=null?benef.getSumaBeneficio():0;
                }
            }
            
            
            
            
            
            poliza.setSumaAseguradaTotal(
            		(poliza.getSumaAseguradaIndividual()!=null?poliza.getSumaAseguradaIndividual():0) + 
            		(poliza.getSumaSEVI()!=null?poliza.getSumaSEVI():0) + 
            		(poliza.getSumaGastosFunerarios()!=null?poliza.getSumaGastosFunerarios():0) + 
            		(poliza.getSumaBAF()!=null?poliza.getSumaBAF():0.00)+totalBeneficios+sol.getTarifa().getPrimaMensualSeguroColectivo().getSumaAseguradaColectiva());
          
           
            if(poliza!=null && sol!=null){
                poliza.setSolicitud(sol);
                sol.setTarifaTotal(totalTarifaBeneficio+sol.getTarifa().getImporteTarifa());
            }

            mv.addObject("poliza",poliza);

            mv.addObject("historicoTarifas",solicitudBusiness.consultarHistoricoTarifaSolicitud(sol));
            
            mv.addObject("listaTramites",polizaBusiness.obtenerTramitesDePoliza(poliza.getNumPoliza(), poliza.getNumConsignatario()));
            
            if(sol.getIdEstatusSolicitud() == ConstantesGenerales.ESTATUS_SOLICITUD_PRECAPTURA ||
            		sol.getIdEstatusSolicitud() == ConstantesGenerales.ESTATUS_SOLICITUD_SIN_EMISION ||
            		sol.getIdEstatusSolicitud() == ConstantesGenerales.ESTATUS_SOLICITUD_REQUERIMIENTO_MEDICO){
            	mv.addObject("puedeModificar",true);
            }else{
            	mv.addObject("puedeModificar",false);
            }
        }
        	
        
        
        

        return mv;
    }

    /**
     * @return the polizaBusiness
     */
    public IPolizaBusiness getPolizaBusiness() {
        return polizaBusiness;
    }

    /**
     * @param polizaBusiness the polizaBusiness to set
     */
    public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
        this.polizaBusiness = polizaBusiness;
    }

    /**
     * @return the solicitudBusiness
     */
    public ISolicitudBusiness getSolicitudBusiness() {
        return solicitudBusiness;
    }

    /**
     * @param solicitudBusiness the solicitudBusiness to set
     */
    public void setSolicitudBusiness(ISolicitudBusiness solicitudBusiness) {
        this.solicitudBusiness = solicitudBusiness;
    }

    

}
