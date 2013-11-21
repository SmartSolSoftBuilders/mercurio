/*
 * Proyecto: Estrategas Seguros - Inbursa
 * Archivo: BaseServiceTest.java
 * Fecha de creaci�n: 04/06/2011
 * �ltima Modificaci�n: 04/06/2011
 */

package mx.com.seguros.test;

import java.sql.Connection;

import javax.sql.DataSource;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Clase base para pruebas unitarias de los servicios de negocio o
 * de objetos de acceso a datos
 * @author Emigdio
 */
public class BaseServiceTest extends TestCase {

    //protected final Log logger = LogFactory.getLog(BaseServiceTest.class);
    private static ApplicationContext ctxl = null;
    /*
     * (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp() throws Exception{

            if(ctxl == null){
                String[] paths = {

                    "/WEB-INF/applicationContext.xml",
                    "/WEB-INF/ibatis-map-dao.xml",
                    "/WEB-INF/principal-context.xml",
                    "/WEB-INF/moduloPagosContext.xml"
                };

                    ctxl = new ClassPathXmlApplicationContext(paths);
            }

    }

    /**
     * Recupera un bean de spring de la f�brica de spring configurada para la prueba unitaria
     * @param bean
     * @return
     */
    protected Object getBean(String bean){

            return ctxl.getBean(bean);
    }
    @Override
    protected void tearDown() throws Exception{
            super.tearDown();

    }
    /**
     * Ejecuta un query en la conecci�n de BD por defecto
     * @param query Query a ejecutar
     * @return Estado de la ejecuci�n del query
     */
    protected int ejecutarQuery(String query){
    	DataSource ds = (DataSource)getBean("jdbcDataSource");
    	int res = 0;
    	Connection conn =null;
    	java.sql.PreparedStatement st = null;
    	try{
    		conn = ds.getConnection();
    		st = conn.prepareStatement(query);
    		res = st.executeUpdate();
    	}catch (Exception e){
    		e.printStackTrace();
    	}finally{
    		try{
    			if(st != null){
    				st.close();
    			}
    			if(conn != null){
    				conn.close();
    			}
    		}catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	return res;
    	
    	
    }

}
