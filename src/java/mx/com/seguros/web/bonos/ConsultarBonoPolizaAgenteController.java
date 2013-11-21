/**
 * 
 */
package mx.com.seguros.web.bonos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mx.com.seguros.business.comisiones.CalculoBonoPolizaBusiness;
import mx.com.seguros.dto.CriteriosConsultaArchivosAplicacionCargadosDTO;
import mx.com.seguros.model.ResumenCalculoBonoPolizaAgente;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controller para la atenci�n de solicitudes de consulta del cat�logo de escuelas
 * de la aplicaci�n.
 * Cuenta con funcionalidad de b�squeda para los distintos campos del cat�logo
 * @author Emigdio Hernnadez
 *
 */
public class ConsultarBonoPolizaAgenteController extends SimpleFormController{
	/**
	 * Servicio para la consulta del bono
	 */
	private CalculoBonoPolizaBusiness calculoBonoPolizaBusiness = null;
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	public ModelAndView onSubmit(Object command) throws Exception {
		return null;
	}
		
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest, java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
    protected Map referenceData(HttpServletRequest request,Object command, Errors errors) throws java.lang.Exception{
        Map data = new HashMap();
        
        data.put("listaResumenProceso", calculoBonoPolizaBusiness.consultarResumenProcesosCalculoBono());
        
        return data;
	}

	/**
	 * @return the calculoBonoPolizaBusiness
	 */
	public CalculoBonoPolizaBusiness getCalculoBonoPolizaBusiness() {
		return calculoBonoPolizaBusiness;
	}

	/**
	 * @param calculoBonoPolizaBusiness the calculoBonoPolizaBusiness to set
	 */
	public void setCalculoBonoPolizaBusiness(
			CalculoBonoPolizaBusiness calculoBonoPolizaBusiness) {
		this.calculoBonoPolizaBusiness = calculoBonoPolizaBusiness;
	}

}
