package mx.com.seguros.business.pagos;

/*
 * PagosBusiness.java
 *
 * Created on 07 de abril de 2010, 07:40 PM
 *
 */
import java.util.ArrayList;
import java.util.List;

import mx.com.seguros.dto.CriteriosConsultaArchivosAplicacionCargadosDTO;
import mx.com.seguros.model.ArchivosAplicacionCargados;

/**
 *
 * @author Cesar Garcia Mauricio
 */
public interface PagosBusiness {

    // void readPayFile(List<List<String>> datosArchivo);
    void readPayFile(ArrayList<List<String>> datosArchivo);
    /**
     * Una vez le�do el archivo de aplicaci�n de pagos
     * se obtienen las siguientes columnas
	 * QUINCENA QUE SE EST� PAGANDO: Almacenada como cadena con los datos del n�mero de quincena y el a�o, separadas por un espacio ejemplo: '20 2012' quincena 20 del 2012 -- campo que ser� le�do
	 * INICIO DE VIGENCIA: Fecha con el formato yyyyMMdd ejemplo: 20110615 -- campo que ser� le�do
	 * EMISIOR: N�mero entero
	 * CARPETA: n�mero entero -- campo que ser� le�do (n�mero de p�liza)
	 * P�LIZA: n�mero entero -- campo que ser� le�do
	 * RFC: informativo
	 * RFC: informativo
	 * NOMBRE: informativo
	 * PAGO: n�mero decimal  --- Campo que ser� le�do
	 * OV: n�mero decimal
	 * COLECTIVO : n�mero decimal
	 * El primero rengl�n ser� desechado, en este rengl�n deben de ir los t�tulos
	 * 
     * @param datosArchivo
     */
    void cargarArchivoAplicacionPagos(List<List<String>> datosArchivo, byte[] contenidoArchivo, String usuario, String nombreArchivo) throws Exception ;
    
    /**
     * Consulta un conjunto de archivos de aplicaci�n en base a un criterio proporcionado
     * @param criterio Criterios de filtrado
     * @return Resultados encontrados
     */
    List<ArchivosAplicacionCargados> consultarArchivosAplicacionCargados(CriteriosConsultaArchivosAplicacionCargadosDTO criterio);
    
    /**
     * Consulta un archivo de aplicaci�n cargado en base a su llave primaria
     * @param idArchivo Llave primaria
     * @return Archivo de aplicaci�n, null si no se encuentra
     */
    ArchivosAplicacionCargados consultaArcivoAplicacionCargadoPorId(Long idArchivo);
    
    /**
     * Proceso batch para la revisi�n de la cartera  de las p�lizas que no han sido canceladas
     * por el cliente y que no han tenido pagos pero cuentan con fondo de ahorro, se tomar�
     * en cuenta el ahorro para pagar la vigencia de la p�liza
     */
    void autoFinanciarPolizasAutomaticamente() throws Exception;
    /**
     * Valida si los primeros 10 registros del archivo de aplicaci�n y a se encuentran cargados en los descuentos aplicados de sus
     * p�lizas correspondientes. Retorna true en caso de que ningun descuento est� aplicado en el sistema
     * Retorna false si existe al menos un descuento que ya se aplic�.
     * @param datosArchivo Datos cargados del archivo
     * @return True si es v�lido, false en otro caso
     */
    boolean validarContenidoArchivoAplicacion(List<List<String>> datosArchivo);
    /**
     * Revierte las aplicaciones de pagos del archivo enviado como par�metro, elimina el archivo y las aplicaciones del pago
     * restando los posibles ahorros del asegurado
     * @param idArchivoAplicacion Identificador del archivo de aplicaci�n de pagos a revertir
     * @return True si se logr� revertir el archivo exit�samente, false si existen condiciones en las que no se puedan revertir
     */
    boolean revertirArchivoAplicacionCargado(Long idArchivoAplicacion);
    
    
    
}
