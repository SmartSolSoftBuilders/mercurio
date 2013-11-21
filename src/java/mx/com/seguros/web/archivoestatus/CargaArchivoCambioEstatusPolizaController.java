/*
 * Smart Solutions 2013
 */
package mx.com.seguros.web.archivoestatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness;
import mx.com.seguros.business.pagos.PagosBusiness;
import mx.com.seguros.dto.CriteriosConsultaArchivosAplicacionCargadosDTO;
import mx.com.seguros.utils.CargaArchivo;
import mx.com.seguros.utils.CargaArchivoCambioEstatusPoliza;
import mx.com.seguros.utils.CargaArchivoVO;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
/**
 * Controller que muestra la lista de los archivos de cambio de estatus de p�liza cargados, permite ver su detalle
 * y permite cargar un nuevo archivo.
 * 
 * @author Emigdio Hernandez
 *
 */
public class CargaArchivoCambioEstatusPolizaController extends SimpleFormController {

	private ArchivoCambioEstatusPolizaBusiness archivoCambioEstatusPolizaBusiness;
	private SeguridadUtil seguridadUtil;
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	public ModelAndView onSubmit(Object command) throws Exception {
		
		
		CargaArchivoVO cargaArchivoVO = (CargaArchivoVO) command;
		
		MultipartFile file = cargaArchivoVO.getFile();
		CargaArchivoCambioEstatusPoliza cargaArchivo = new CargaArchivoCambioEstatusPoliza();
		List<String[]> datosArchivo = null;
		String error = null;
	
		try {
				datosArchivo = cargaArchivo.cargaInformacionArchivo(file.getInputStream());
				archivoCambioEstatusPolizaBusiness.cargarArchivoCambioEstatusPoliza(datosArchivo, file.getBytes(),seguridadUtil.getUsuario().getUsername(),file.getOriginalFilename());
				error = "Archivo de Aplicaci�n de Pagos Cargado Exit�samente";
		} catch (Throwable pbe) {
			pbe.printStackTrace();
			error = "Error al cargar el archivo de cambio de estatus: " + pbe.getMessage();
		}
		
		ModelAndView mav = new ModelAndView(getSuccessView());
		mav.addObject("error", error);
		mav.addAllObjects(referenceData(null, command, null));
		return mav;
		
	}
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest, java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
    protected Map referenceData(HttpServletRequest request,Object command, Errors errors) throws java.lang.Exception{
        Map data = new HashMap();
        data.put("listaArchivosCambioEstatus", archivoCambioEstatusPolizaBusiness.obtenerArchivosTramitePoliza());
        return data;
	}
	
	
	/**
	 * @param archivoCambioEstatusPolizaBusiness the archivoCambioEstatusPolizaBusiness to set
	 */
	public void setArchivoCambioEstatusPolizaBusiness(
			ArchivoCambioEstatusPolizaBusiness archivoCambioEstatusPolizaBusiness) {
		this.archivoCambioEstatusPolizaBusiness = archivoCambioEstatusPolizaBusiness;
	}
	/**
	 * @param seguridadUtil the seguridadUtil to set
	 */
	public void setSeguridadUtil(SeguridadUtil seguridadUtil) {
		this.seguridadUtil = seguridadUtil;
	}

}
