package mx.com.seguros.business.pagos.impl;

import java.math.BigDecimal;
import java.util.Date;

import mx.com.seguros.business.pagos.CuentaClienteBusiness;
import mx.com.seguros.business.pagos.exception.SaldoNegativoException;
import mx.com.seguros.data.dao.CuentaClienteDao;
import mx.com.seguros.model.CuentaCliente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CuentaClienteBusinessImpl implements CuentaClienteBusiness {

    @Override
    public CuentaCliente findById(String numNominaContratante) {
        CuentaCliente cuentaCliente;
        try {
            cuentaCliente = cuentaClienteDao.obtenerCuentaClienteByNumNominaContratante(numNominaContratante);
        } catch (Exception e) {
            cuentaCliente = null;
            handleMissingCuentaCliente(numNominaContratante);
            e.printStackTrace();
        }
        if (cuentaCliente == null) {
            handleMissingCuentaCliente(numNominaContratante);
        } else {
            log.debug(cuentaCliente.toString());
        }
        return cuentaCliente;
    }

    private void handleMissingCuentaCliente(String numNominaContratante) {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("No fue posible recuperar la cuenta del cliente");
        sb.append(" - RFC del contratante ");
        sb.append(numNominaContratante);
        if(log.isTraceEnabled()) {
            log.trace(sb.toString());
        }
        return;
    }

    @Override
    public Boolean updateCuentaCliente(CuentaCliente cuentaCliente,
            BigDecimal importeTransaccion) throws SaldoNegativoException {
        // if (log.isDebugEnabled()) {
        // log.debug("Antes de actualizar saldo cuentaCliente: "
        // + cuentaCliente);
        // log.debug("importeTransaccion: " + importeTransaccion);
        // }
        BigDecimal saldoCuenta;
        saldoCuenta = cuentaCliente.getSaldoCuenta();
        BigDecimal saldoCuentaNuevo;
        // El importe de la transaccion ya trae el signo adecuado de modo que
        // este add a veces es subtract.
        saldoCuentaNuevo = saldoCuenta.add(importeTransaccion);
       /*if (saldoCuentaNuevo.compareTo(BigDecimal.ZERO) < 0) {
            StringBuilder msgExc = new StringBuilder();
            msgExc.append("No se permiten saldos de cuenta negativos: ");
            msgExc.append("saldo actual = ");
            msgExc.append(saldoCuenta);
            if (log.isInfoEnabled()) {
                log.info(msgExc.toString());
            }
            throw new SaldoNegativoException(msgExc.toString());
        } else {
            
        }*/
        cuentaCliente.setSaldoCuenta(saldoCuentaNuevo);
        cuentaCliente.setFechaCalculoSaldo(new Date());
        Boolean pagoRegistrado;
        pagoRegistrado = cuentaClienteDao.updateCuentaCliente(cuentaCliente);
        // log.info(cuentaCliente.toString());
        return pagoRegistrado;
    }

    @Override
    public CuentaCliente createCuentaCliente(String numNominaContratante) {

        CuentaCliente cuentaCliente;
        cuentaCliente = new CuentaCliente();

        cuentaCliente.setNumNominaContratante(numNominaContratante);
        cuentaCliente.setSaldoCuenta(BigDecimal.ZERO);

        cuentaCliente.setFechaCalculoSaldo(new Date());
        // cuentaCliente.setTrId (No existe!);
        cuentaClienteDao.createCuentaCliente(cuentaCliente);

        return cuentaCliente;
    }
    private CuentaClienteDao cuentaClienteDao;

    public void setCuentaClienteDao(CuentaClienteDao cuentaClienteDao) {
        this.cuentaClienteDao = cuentaClienteDao;
    }
    private static final Logger log;

    static {
        log = LoggerFactory.getLogger(CuentaClienteBusinessImpl.class);
    }
}
