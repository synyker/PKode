/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniprojekti;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author jonne
 */
@Controller
public class ReferenceController {
    
    @RequestMapping("")
    public String processFront() {
        return "front";
    }
        
    @RequestMapping(value="add", method = RequestMethod.GET)
    public String processAdd() {
        return "add";
    }
    
    @RequestMapping(value="list-bib", method = RequestMethod.GET)
    public String processBib() {
        return "list-bib";
    }
    
    @RequestMapping(value="list-norm", method = RequestMethod.GET)
    public String processNorm() {
        return "list-norm";
    }
}
