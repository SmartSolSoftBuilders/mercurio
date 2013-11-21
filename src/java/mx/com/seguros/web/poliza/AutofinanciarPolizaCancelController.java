/*
 * AutofinanciarPolizaCancelController.java
 *
 * Created on 4 de marzo de 2008, 01:12 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.poliza;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.seguros.business.poliza.IPolizaBusiness;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;
import org.springframework.web.servlet.view.RedirectView;
/**
 *
 * @author QTX
 */
public class AutofinanciarPolizaCancelController extends AbstractWizardFormController {
    private IPolizaBusiness polizaBusiness;
    /** Creates a new instance of AutofinanciarPolizaCancelController */
    public AutofinanciarPolizaCancelController() {
         this.setSupportedMethods(new String[] {METHOD_POST, METHOD_GET});
        setPages(new String[]{"registroPoliza/autofinanciarPolizaPorCancelacion"});
        setCommandClass(AutofinanciarPolizaCancelCommand.class);
        setCommandName("datosPoliza");
        setSessionForm(true);
        setValidator(new AutofinanciarPolizaCancelValidator());
        setValidateOnBinding(false);
    }
    
    protected void validatePage(Object command, Errors errors, int page) {
       /* ConsultaPolizaCommand datosPoliza = (ConsultaPolizaCommand) command;
        ConsultaPolizaValidator validator = (ConsultaPolizaValidator) getValidator();
        switch (page) {
            case 0:
                validator.validatePage0(datosPoliza, errors);
                break;
            }*/
    }
    protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command, BindException bindException) throws Exception {
        AutofinanciarPolizaCancelCommand datosPoliza = (AutofinanciarPolizaCancelCommand) command;
        polizaBusiness.autofinanciarPoliza(datosPoliza);
          ModelAndView mav = new ModelAndView("registroPoliza/polizaAutofinanciadaCorrectamente");
       return mav;
    }
    
     protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        return new ModelAndView(new RedirectView("autofinanciarPolizaCancelController"));
    }
     
     public IPolizaBusiness getPolizaBusiness() {
        return polizaBusiness;
    }
    
    public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
        this.polizaBusiness = polizaBusiness;
    }
    
}
