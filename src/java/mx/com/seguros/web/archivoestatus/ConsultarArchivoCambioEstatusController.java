/**
 * 
 */
package mx.com.seguros.web.archivoestatus;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness;
import mx.com.seguros.business.pagos.PagosBusiness;
import mx.com.seguros.model.ArchivoTramitePoliza;
import mx.com.seguros.model.ArchivosAplicacionCargados;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Controller para atender la petici�n de consultar el archivo de 
 * cambio de estatus de p�lizas
 * @author Emigdio Hernandez
 *
 */
public class ConsultarArchivoCambioEstatusController extends AbstractController {

	private ArchivoCambioEstatusPolizaBusiness archivoCambioEstatusPolizaBusiness;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idArchivo = request.getParameter("idArchivosCambioEstatus");
		
		ArchivoTramitePoliza archivo = archivoCambioEstatusPolizaBusiness.
				obtenerArchivosTramitePolizaPorId(NumberUtils.toInt(idArchivo));
		
		if(archivo != null && archivo.getArchivo() != null){
			response.setContentType("application/ms-excel");
            response.setHeader("Content-Disposition",
            		"attachment; filename=" +  archivo.getNombreArchivo());
            response.setHeader("Cache-Control","no-cache");
            response.setHeader("pragma","no-cache");
            response.setContentLength(archivo.getArchivo().length);
            ServletOutputStream sos = response.getOutputStream();
            sos.write(archivo.getArchivo());
            sos.flush();
		}
		
		return null;
	}
	
	/**
	 * @param archivoCambioEstatusPolizaBusiness the archivoCambioEstatusPolizaBusiness to set
	 */
	public void setArchivoCambioEstatusPolizaBusiness(
			ArchivoCambioEstatusPolizaBusiness archivoCambioEstatusPolizaBusiness) {
		this.archivoCambioEstatusPolizaBusiness = archivoCambioEstatusPolizaBusiness;
	}

}
