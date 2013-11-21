/**
 * 
 */
package mx.com.seguros.web.bonos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.comisiones.CalculoBonoPolizaBusiness;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Controller que atiende la solicitud de consulta del detalle por agente y p�lizas
 * de un proceso de c�lculo de bonos de p�liza
 * @author Emigdio Hernandez
 *
 */
public class ConsultaDetalleProcesoCalculoBonoController extends AbstractController{
	/**
	 * Servicio para consulta de la informaci�n del proceso
	 */
	private CalculoBonoPolizaBusiness calculoBonoPolizaBusiness = null;
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Integer idResumenProceso = Integer.valueOf(request.getParameter("id"));
		ModelAndView resultado = new ModelAndView();
		resultado.setViewName("bonos/detalleBonoPolizaAgente");
		resultado.addObject("resumen", calculoBonoPolizaBusiness.consultaDetalleProcesoCalculoBono(idResumenProceso));
		return resultado;
	}
	/**
	 * @param calculoBonoPolizaBusiness the calculoBonoPolizaBusiness to set
	 */
	public void setCalculoBonoPolizaBusiness(
			CalculoBonoPolizaBusiness calculoBonoPolizaBusiness) {
		this.calculoBonoPolizaBusiness = calculoBonoPolizaBusiness;
	}

}
