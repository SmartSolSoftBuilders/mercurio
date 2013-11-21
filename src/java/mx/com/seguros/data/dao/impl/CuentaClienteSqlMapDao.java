package mx.com.seguros.data.dao.impl;

import mx.com.seguros.data.dao.CuentaClienteDao;
import mx.com.seguros.model.CuentaCliente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class CuentaClienteSqlMapDao extends SqlMapClientDaoSupport implements
        CuentaClienteDao {

    @Override
    public CuentaCliente obtenerCuentaClienteByNumNominaContratante(
            String numNominaContratante) {
        return (CuentaCliente) getSqlMapClientTemplate().queryForObject(
                "obtenerCuentaClienteByNumNominaContratante",
                numNominaContratante);
    }

    @Override
    public Boolean updateCuentaCliente(CuentaCliente cuentaCliente) {
        Boolean actualizacionExitosa;
        actualizacionExitosa = (1 == getSqlMapClientTemplate().update(
                "updateCuentaCliente", cuentaCliente));
        if (!actualizacionExitosa) {
            StringBuilder msg = new StringBuilder();
            msg.append("No se ha completado la actualizaci\u00F3n de ");
            msg.append("la cuenta del cliente");
            LOG.warn(msg.toString());
        }
        // LOG.debug("CtaCliente: "
        // + obtenerCuentaClienteByNumNominaContratante(cuentaCliente
        // .getNumNominaContratante()));
        LOG.debug("" + cuentaCliente);
        return actualizacionExitosa;
    }

    @Override
    public void createCuentaCliente(CuentaCliente cuentaCliente) {
       
            getSqlMapClientTemplate().insert("insert", cuentaCliente);
        

    }
    private static final Logger LOG;

    static {
        LOG = LoggerFactory.getLogger(CuentaClienteSqlMapDao.class);
    }
}
