/**
 * 
 */
package mx.com.seguros.business.empresa;

import java.util.List;

import mx.com.seguros.dto.CriteriosConsultaEscuelasDTO;
import mx.com.seguros.model.Colonia;
import mx.com.seguros.model.Empresa;
import mx.com.seguros.model.Sucursal;
import mx.com.seguros.model.TipoEmpresa;
import mx.com.seguros.model.TurnoEmpresa;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

/**
 * Interfaz del servicio de negocio para la administraci�n
 * del cat�logo de escuelas dentro del sistema.
 * @author Emigdio Hernandez
 *
 */
public interface AdministracionEmpresasService {
	/**
     * Consulta el cat�logo de empresas, de forma paginada y aplicando los criterios de filtrado enviados
     * como par�metro
     * @param criterios Criterios de b�squeda
     * @param resultadoPaginado Configuraci�n de la paginaci�n
     */
	void consultaGeneralEmpresas(CriteriosConsultaEscuelasDTO criterios,ResultadoPaginadoDTO<Empresa> resultadoPaginado);
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
     * Almacena o actualiza los datos de una empresa en la base de datos
     * Si existe el ID de la empresa se actualiza, si no, se agrega una nueva
     * @param empresa Datos de la empresa a guardar
     */
    void guardarEscuela(Empresa empresa);
    /**
     * Consulta los datos de una empresa por su PK
     * @param cveEmpresa Llave primaria a buscar
     * @return Datos de la empresa
     */
    Empresa consultaEscuelaPorClave(Integer cveEmpresa);
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
