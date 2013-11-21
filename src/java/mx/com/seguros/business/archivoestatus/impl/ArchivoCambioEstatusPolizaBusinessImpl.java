/**
 * 
 */
package mx.com.seguros.business.archivoestatus.impl;

import java.util.Date;
import java.util.List;

import mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness;
import mx.com.seguros.data.dao.ArchivoTramitePolizaDao;
import mx.com.seguros.data.dao.IPolizaDao;
import mx.com.seguros.model.ArchivoTramitePoliza;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.utils.ConstantesGenerales;

import org.apache.commons.lang.math.NumberUtils;

/**
 * Implementación del servicio de negocio para la manipulación y carga
 * de archivos de cambio de estatus de póliza.
 * @author Emigdio Hernández
 * 
 *
 */
public class ArchivoCambioEstatusPolizaBusinessImpl implements	ArchivoCambioEstatusPolizaBusiness {

	private ArchivoTramitePolizaDao archivoTramitePolizaDao;
	private IPolizaDao polizaDao;
	/* (non-Javadoc)
	 * @see mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness#obtenerArchivosTramitePoliza()
	 */
	@Override
	public List<ArchivoTramitePoliza> obtenerArchivosTramitePoliza() {
		return archivoTramitePolizaDao.obtenerArchivosTramitePoliza();
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness#obtenerArchivosTramitePolizaPorId(java.lang.Integer)
	 */
	@Override
	public ArchivoTramitePoliza obtenerArchivosTramitePolizaPorId(Integer idArchivoTramitePoliza) {
		return archivoTramitePolizaDao.obtenerArchivosTramitePolizaPorId(idArchivoTramitePoliza);
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness#insertarArchivoTramitePoliza(mx.com.seguros.model.ArchivoTramitePoliza)
	 */
	@Override
	public void insertarArchivoTramitePoliza(ArchivoTramitePoliza archivoTramitePoliza) {
		archivoTramitePolizaDao.insertarArchivoTramitePoliza(archivoTramitePoliza);
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness#actualizarArchivoTramitePoliza(mx.com.seguros.model.ArchivoTramitePoliza)
	 */
	@Override
	public void actualizarArchivoTramitePoliza(ArchivoTramitePoliza archivoTramitePoliza) {
		archivoTramitePolizaDao.actualizarArchivoTramitePoliza(archivoTramitePoliza);
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness#eliminarArchivoTramitePoliza(java.lang.Integer)
	 */
	@Override
	public void eliminarArchivoTramitePoliza(Integer idArchivoTramitePoliza) {
		archivoTramitePolizaDao.eliminarArchivoTramitePoliza(idArchivoTramitePoliza);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness#cargarArchivoCambioEstatusPoliza(java.util.List, byte[], java.lang.String, java.lang.String)
	 */
	@Override
	public void cargarArchivoCambioEstatusPoliza(List<String[]> datosArchivo,byte[] contenidoArchivo, String usuario, String nombreArchivo)	throws Exception {
		StringBuffer log = new StringBuffer();
		if(datosArchivo != null){
			Integer numPoliza  = 0;
			Integer numConsignatario = 0;
			int numRegistro = 0;
			int numRegistrosActualizados = 0;
			PolizaIndividual polizaActualizar = new PolizaIndividual();
			ArchivoTramitePoliza archivo = new ArchivoTramitePoliza();
			archivo.setFechaCarga(new Date());
			archivo.setFechaHoraInicio(new Date());
			for(String[] registro : datosArchivo){
				//Validar contenido del registro
				if(registro != null && registro.length > 2){
					numRegistro++;
					numPoliza = NumberUtils.toInt(registro[0], 0);
					numConsignatario = NumberUtils.toInt(registro[1], 0);
					//validar formatos
					if(numPoliza <= 0 || numConsignatario <=0 ){
						log.append("Registro " + numRegistro + ": Formato no reconocido de póliza o emisor ("+registro[0]+"-"+registro[1]+")\n");
					}else{
						polizaActualizar.setIdEstatusPolizaSeguimiento(0);
						polizaActualizar.setNumConsignatario(numConsignatario);
						polizaActualizar.setNumPoliza(numPoliza);
						//Procesar el registro
						if(ENTREGADO_AGENTE.equalsIgnoreCase(registro[2]!=null?registro[2].trim():null)){
							polizaActualizar.setIdEstatusPolizaSeguimiento(ConstantesGenerales.ESTATUS_SEGUIMIENTO_POLIZA_ENTREGADA_AGENTE);
						}
						if(ENTREGADO_CLIENTE.equalsIgnoreCase(registro[2]!=null?registro[2].trim():null)){
							polizaActualizar.setIdEstatusPolizaSeguimiento(ConstantesGenerales.ESTATUS_SEGUIMIENTO_POLIZA_ENTREGADA_ASEGURADO);
						}
						if(polizaActualizar.getIdEstatusPolizaSeguimiento() > 0){
							if(polizaDao.actualizaEstatusPolizaSeguimiento(polizaActualizar)>0){
								numRegistrosActualizados ++;
							}else{
								log.append("Registro " + numRegistro + ": Póliza no encontrada ("+numPoliza+"-"+numConsignatario+")\n");
							}
						}
					}
					
				}else{
					log.append("Registro " + numRegistro + ": Columnas incompletas\n");
				}
				
			}
			log.append("Proceso Finalizado --\n\nNúmero de registros con cambio de estatus: " + numRegistrosActualizados + "\n");
			
			archivo.setFechaHoraFin(new Date());
			archivo.setArchivo(contenidoArchivo);
			archivo.setLog(log.toString());
			archivo.setNombreArchivo(nombreArchivo);
			archivo.setUsuario(usuario);
			archivo.setNumeroRegistros(numRegistro);
			insertarArchivoTramitePoliza(archivo);
		}
		
	}
	/**
	 * @param archivoTramitePolizaDao the archivoTramitePolizaDao to set
	 */
	public void setArchivoTramitePolizaDao(ArchivoTramitePolizaDao archivoTramitePolizaDao) {
		this.archivoTramitePolizaDao = archivoTramitePolizaDao;
	}

	/**
	 * @param polizaDao the polizaDao to set
	 */
	public void setPolizaDao(IPolizaDao polizaDao) {
		this.polizaDao = polizaDao;
	}
	

}
