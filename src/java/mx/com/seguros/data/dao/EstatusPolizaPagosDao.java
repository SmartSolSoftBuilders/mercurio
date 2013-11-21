/*
 * EstatusPolizaPagosDao.java
 *
 * Created on 30 de marzo de 2010, 05:14 AM
*/
package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.model.EstatusPolizaPagos;

import mx.com.seguros.model.PolizaIndividual;

/**
 * 
 * @author Cesar Garcia Mauricio
 */
public interface EstatusPolizaPagosDao {
	EstatusPolizaPagos obtenerEstatusPolizaPagosById(int statusId);
	EstatusPolizaPagos obtenerEstatusPolizaPagosByDescripcion(String descripcion);
        Integer obtenerEstatusPolizaPagosByPoliza(PolizaIndividual pol);
        
    /**
     * Consulta el cat�logo de estatus de pagos de p�liza    
     * @return Lista de valores del cat�logo de p�lizas
     */
    List<EstatusPolizaPagos>  consultarEstatusPolizaPagos();
}