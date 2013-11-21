/*
 * Smart Solutions 2012
 */
package mx.com.seguros.web.pagos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mx.com.seguros.business.pagos.PagosBusiness;
import mx.com.seguros.dto.CriteriosConsultaArchivosAplicacionCargadosDTO;
import mx.com.seguros.utils.CargaArchivo;
import mx.com.seguros.utils.CargaArchivoVO;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
/**
 * Controller para la atenci�n a las solicitudes del usuario de cargar un archivo de aplicaci�n de pagos 
 * Excel 2003-2007 con las siguientes columnas:
 * QUINCENA QUE SE EST� PAGANDO: Almacenada como cadena con los datos del n�mero de quincena y el a�o, separadas por un espacio ejemplo: '20 2012' quincena 20 del 2012 -- campo que ser� le�do
 * INICIO DE VIGENCIA: Fecha con el formato yyyyMMdd ejemplo: 20110615 -- campo que ser� le�do
 * EMISIOR: N�mero entero
 * CARPETA: n�mero entero -- campo que ser� le�do
 * P�LIZA: n�mero entero -- campo que ser� le�do
 * RFC: informativo
 * RFC: informativo
 * NOMBRE: informativo
 * PAGO: n�mero decimal  --- Campo que ser� le�do
 * OV: n�mero decimal
 * COLECTIVO : n�mero decimal
 * El primero rengl�n ser� desechado, en este rengl�n deben de ir los t�tulos
 * Se leera �nicamente la primera hoja del libro
 * 
 * @author Emigdio Hernandez
 *
 */
public class CargaArchivoAplicacionPagosController extends SimpleFormController {

	public CargaArchivoAplicacionPagosController() {
		setFormView("CargaArchivos/cargaArchivoAplicacion");
		setSuccessView(successView);
		setCommandClass(CargaArchivoVO.class);
	}

	@Override
	public ModelAndView onSubmit(Object command) throws Exception {
		SeguridadUtil utl = new SeguridadUtil();
		logger.info("Inicia carga de archivo de pagos del retenedor...");
		CargaArchivoVO cargaArchivoVO = (CargaArchivoVO) command;
		logger.debug("cargaArchivoVO: " + cargaArchivoVO);
		MultipartFile file = cargaArchivoVO.getFile();
		CargaArchivo cargaArchivo = new CargaArchivo();
		List<List<String>> datosArchivo = null;
		String error = null;
		
	
		try {
			datosArchivo = cargaArchivo.cargaInformacionArchivo(file.getInputStream());
			if(pagosBusiness.validarContenidoArchivoAplicacion(datosArchivo)){
				pagosBusiness.cargarArchivoAplicacionPagos(datosArchivo, file.getBytes(),utl.getUsuario().getUsername(),file.getOriginalFilename() );
				error = "Archivo de Aplicaci�n de Pagos Cargado Exit�samente";
			}else{
				error = "El archivo de aplicaci�n contiene registros de aplicaci�n de descuentos que ya han sido aplicados en el sistema, no se carg� el archivo.";
			}
			
			setSuccessView(successView);
		} catch (Exception pbe) {
			pbe.printStackTrace();
			error = "Error al cargar el archivo de aplicaci�n de pagos: " + pbe.getMessage();
			setSuccessView(errorView);
		}

		
		ModelAndView mav = new ModelAndView(getSuccessView());
	
		mav.addObject("error", error);
		mav.addObject("listaArchivosAplicacion", pagosBusiness.consultarArchivosAplicacionCargados(new CriteriosConsultaArchivosAplicacionCargadosDTO()));
		return mav;
		
	}
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest, java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
    protected Map referenceData(HttpServletRequest request,Object command, Errors errors) throws java.lang.Exception{
        Map data = new HashMap();

        data.put("listaArchivosAplicacion", pagosBusiness.consultarArchivosAplicacionCargados(new CriteriosConsultaArchivosAplicacionCargadosDTO()));
        
        
        return data;
	}
	
	
	public void setPagosBusiness(PagosBusiness pagosBusiness) {
		this.pagosBusiness = pagosBusiness;
	}

	private PagosBusiness pagosBusiness;

	private static final String successView;
	private static final String errorView;
	private static final Logger logger;

	static {
		successView = "CargaArchivos/cargaArchivoAplicacion";
		errorView = "CargaArchivos/cargaArchivoAplicacion";
		logger = LoggerFactory.getLogger(CargaArchivoAplicacionPagosController.class);
	}

}
