/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.seguros.business.consulta;

import mx.com.seguros.data.dao.ISolicitudDao;
import mx.com.seguros.dto.CriteriosConsultaSolicitudesDTO;
import mx.com.seguros.dto.ResultadoConsultaSolicitudDTO;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

/**
 * Implementación del servicio de negocio para la consulta de solicitudes de seguro
 * @author Emigdio Hernández
 */
public class ConsultaGeneralSolicitudesBusiness implements IConsultaGeneralSolicitudesBusiness{

    private ISolicitudDao solicitudDao;
    @Override
    public void consultarSolicitudes(CriteriosConsultaSolicitudesDTO criterios, 
    		ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO> resultado) {
        solicitudDao.consultarSolicitudes(criterios, resultado);
    }

    /**
     * @return the solicitudDao
     */
    public ISolicitudDao getSolicitudDao() {
        return solicitudDao;
    }

    /**
     * @param solicitudDao the solicitudDao to set
     */
    public void setSolicitudDao(ISolicitudDao solicitudDao) {
        this.solicitudDao = solicitudDao;
    }

}
