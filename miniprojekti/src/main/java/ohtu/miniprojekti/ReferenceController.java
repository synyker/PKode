/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniprojekti;

import com.avaje.ebean.EbeanServer;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ohtu.miniprojekti.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author jonne
 */
@Controller
public class ReferenceController {
    
    @Autowired
    private ReferenceRepository rr;
    
    @RequestMapping("")
    public String getFront() {
        return "front";
    }
        
    @RequestMapping(value="add", method = RequestMethod.GET)
    public String getAdd() {
        return "add";
    }
    
    @RequestMapping(value="add", method = RequestMethod.POST)
    public String postAdd() {
        return "front";
    }
    
    @RequestMapping(value="list-bib", method = RequestMethod.GET)
    public String getBib() {
        return "list-bib";
    }
    
    @RequestMapping(value="list-norm", method = RequestMethod.GET)
    public String getNorm() {
        return "list-norm";
    }
}
