/*
 * ControllerAuxiliar.java
 *
 * Created on 1 de febrero de 2008, 11:55 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Capacitacion
 */
public class ControllerAuxiliar extends MultiActionController {
    
    /** Creates a new instance of ControllerAuxiliar */
    public ModelAndView metodoControlador(HttpServletRequest req, HttpServletResponse res){
        return new ModelAndView("CargaArchivos/cargaArchivoDescuentos");
    }
}