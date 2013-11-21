/**
 * 
 */
package mx.com.seguros.data.dao.impl;

import java.util.List;

import mx.com.seguros.data.dao.TramiteRetiroDao;
import mx.com.seguros.model.TramiteRetiro;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * Implementación del objeto de acceso a datos para la manipulación
 * de los registros de trámite de retiros
 * @author Emigdio Hernández
 *
 */
public class TramiteRetiroSqlMapDao extends SqlMapClientDaoSupport implements TramiteRetiroDao {

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.TramiteRetiroDao#insertarTramiteRetiro(mx.com.seguros.model.TramiteRetiro)
	 */
	@Override
	public void insertarTramiteRetiro(TramiteRetiro tramite) {
		getSqlMapClientTemplate().insert("insertarTramiteRetiro",tramite);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.TramiteRetiroDao#consultarTramitesRetiroPorAsegurado(java.lang.String)
	 */
	@Override
	public List<TramiteRetiro> consultarTramitesRetiroPorAsegurado(String numNominaContratante) {
		return getSqlMapClientTemplate().queryForList("obtenerTramitesRetiroDeAsegurado",numNominaContratante);
	}

}
