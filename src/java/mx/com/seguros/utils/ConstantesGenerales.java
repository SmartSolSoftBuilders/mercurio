/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.seguros.utils;

/**
 * Clase de constantes generales del sistema
 * @author Emigdio Hern�ndez
 */
public abstract class ConstantesGenerales {

    public static final int ESTATUS_SOLICITUD_PRECAPTURA = 6;
    public static final int ESTATUS_SOLICITUD_SIN_EMISION = 1;
    public static final int ESTATUS_SOLICITUD_REQUERIMIENTO_MEDICO = 5;
    public static final int ESTATUS_SOLICITUD_POLIZA_EMITIDA = 2;
    public static final int ESTATUS_PAGOS_POLIZA_SIN_PAGOS_APLICADOS = 1;
    public static final int ESTATUS_PAGOS_POLIZA_NORMAL = 2;
    public static final int ESTATUS_SEGUIMIENTO_POLIZA_ENTREGADA_AGENTE = 2;
    public static final int ESTATUS_SEGUIMIENTO_POLIZA_ENTREGADA_ASEGURADO = 3;
    public static final String[] NO =  new String[]{"NO","N","false"};
    public static final String[] SI =  new String[]{"SI","S","true"};
    public static final String[] MASCULINO = new String[]{"M","H","HOMBRE","MASCULINO"};
    
    //Constantes para leer el archivo de aplicaci�n de pagos
    
    public static final int COLUMNA_APLICACION_QUINCENA = 0;
    public static final int COLUMNA_INICIO_VIGENCIA = 1;
    public static final int COLUMNA_EMISOR = 2;
    public static final int COLUMNA_NUMERO_POLIZA = 3;
    public static final int COLUMNA_PAGO = 8;
    
    
    public static final String FORMATO_FECHA_ARCHIVO = "yyyyMMdd";
    
    public static final String SUFIJO_REPORTES_CON_AHORRO = "";
    public static final String SUFIJO_REPORTES_SIN_AHORRO = "_sinahorro";


}
