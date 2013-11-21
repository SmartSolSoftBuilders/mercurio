/**
 * 
 */
package mx.com.seguros.data.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import mx.com.seguros.data.dao.IBitacoraEmisionReporteDao;
import mx.com.seguros.model.BitacoraEmisionReporte;

/**
 * Implementaci�n del objeto de acceso a datos para la Bit�cora de Emisi�n de Reportes
 * @author Emigdio Hern�ndez
 *
 */
public class BitacoraEmisionReporteSqlMapDao extends SqlMapClientDaoSupport implements
		IBitacoraEmisionReporteDao {

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IBitacoraEmisionReporteDao#insertarBitacoraEmisionReporte(mx.com.seguros.model.BitacoraEmisionReporte)
	 */
	@Override
	public void insertarBitacoraEmisionReporte(
			BitacoraEmisionReporte datosEntrada) {

		getSqlMapClientTemplate().insert("insertarBitacoraEmisionReporte",datosEntrada);

	}

}
