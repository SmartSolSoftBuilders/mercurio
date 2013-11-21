/**
 * 
 */
package mx.com.seguros.web.seguridad.util;

import java.util.Iterator;

import org.acegisecurity.ConfigAttributeDefinition;
import org.acegisecurity.ConfigAttributeEditor;
import org.acegisecurity.intercept.web.AbstractFilterInvocationDefinitionSource;
import org.acegisecurity.intercept.web.FilterInvocationDefinitionSource;

/**
 * Implementaci�n del definition source para spring que permite autorizar a todos los roles para cualquier URL
 * El filtrado posterior se har� �nicamente por menu
 * @author Emigdio Hern�ndez
 *
 */
public class LocalFilterInvocationDefinitionSource extends AbstractFilterInvocationDefinitionSource {

	AutenticacionDaoJdbcImpl authenticationDao = null;
 
	private static ConfigAttributeEditor configEditor = new ConfigAttributeEditor();
    
	/*
	 * (non-Javadoc)
	 * @see org.acegisecurity.intercept.ObjectDefinitionSource#getConfigAttributeDefinitions()
	 */
	@Override
	public Iterator getConfigAttributeDefinitions() {
		
		return null;
	}
	/*
	 * (non-Javadoc)
	 * @see org.acegisecurity.intercept.web.AbstractFilterInvocationDefinitionSource#lookupAttributes(java.lang.String)
	 */
	@Override
	public ConfigAttributeDefinition lookupAttributes(String arg0) {
		if(AutenticacionDaoJdbcImpl.ROLES == null){
			
			authenticationDao.cargarRoles(0);
		}
		configEditor.setAsText(AutenticacionDaoJdbcImpl.ROLES);
		return (ConfigAttributeDefinition)configEditor.getValue();
	}
	/**
	 * @param authenticationDao the authenticationDao to set
	 */
	public void setAuthenticationDao(AutenticacionDaoJdbcImpl authenticationDao) {
		this.authenticationDao = authenticationDao;
	}

	

}
