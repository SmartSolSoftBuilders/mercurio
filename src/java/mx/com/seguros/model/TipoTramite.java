/**
 * 
 */
package mx.com.seguros.model;

import java.io.Serializable;

/**
 * DTO que representa un registro del cat�logo de tipos de tr�mite
 * @author Emigdio Hern�ndez
 *
 */
public class TipoTramite implements Serializable{
	//Identificador �nico
	private Integer idTipoTramite = null;
	//Nombre del tipo de tr�mite
	private String nombre = null;
	//Descripci�n adicional del tipo de tr�mite
	private String descripcion = null;
	/**
	 * @return the idTipoTramite
	 */
	public Integer getIdTipoTramite() {
		return idTipoTramite;
	}
	/**
	 * @param idTipoTramite the idTipoTramite to set
	 */
	public void setIdTipoTramite(Integer idTipoTramite) {
		this.idTipoTramite = idTipoTramite;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
