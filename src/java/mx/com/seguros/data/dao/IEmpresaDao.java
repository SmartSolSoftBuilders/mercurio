/*
 * IEmpresaDao.java
 *
 * Created on 29 de agosto de 2007, 03:00 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.dto.CriteriosConsultaEscuelasDTO;
import mx.com.seguros.model.Colonia;
import mx.com.seguros.model.Empresa;
import mx.com.seguros.model.Plaza;
import mx.com.seguros.model.Sucursal;
import mx.com.seguros.model.TipoEmpresa;
import mx.com.seguros.model.TurnoEmpresa;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

/**
 *
 * @author QTX
 */
public interface IEmpresaDao {
    
    void insertarEmpresa(Empresa empresa);
    /**
     * Consulta el cat�logo de las plazas disponibles en el sistema
     * @return Listado de Plazas
     */
    List<Plaza> consultarPlazas();
    /**
     * Consulta el cat�logo de empresas, de forma paginada y aplicando los criterios de filtrado enviados
     * como par�metro
     * @param criterios Criterios de b�squeda
     * @param resultadoPaginado Configuraci�n de la paginaci�n
     */
    void consultarListadoEmpresas(CriteriosConsultaEscuelasDTO criterios, ResultadoPaginadoDTO<Empresa> resultadoPaginado);
    /**
     * Consulta el cat�logo de tipos de empresa
     * @return Cat�log de tipos de empresa
     */
    List<TipoEmpresa> consultarTiposEmpresa();
    /**
     * Consulta el cat�logo de turnos de la empresa
     * @return Cat�logo de Turnos de la empresa
     */
    List<TurnoEmpresa> consultarTurnosEmpresa();
    /**
     * Consulta los datos de una empresa por su llave primaria
     * @param claveEmpresa PK de la empresa
     * @return Datos de la empresa
     */
    Empresa consultarEmpresaPorClave(Integer claveEmpresa);
    /**
     * Agrega una nueva empresa al cat�logo
     * @param empresa
     */
    void agregarEmpresa(Empresa empresa);
    /**
     * Actualiza una empresa existente en el cat�logo
     * @param empresa
     */
    void actualizarEmpresa(Empresa empresa);
    /**
     * Inserta una nueva sucursal
     * @param sucursal
     */
    void agregarSucursal(Sucursal sucursal);
    /**
     * Inserta una nueva colonia
     * @param colonia
     */
    void agregarColonia(Colonia colonia);
}
