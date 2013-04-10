/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniprojekti;

import com.avaje.ebean.EbeanServer;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ohtu.miniprojekti.domain.Reference;
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
    public String postAdd(HttpServletRequest request, HttpServletResponse response) {
        Reference reference = new Reference(request.getParameter("author"), 
                request.getParameter("title"), 
                request.getParameter("journal"), 
                request.getParameter("volume"), 
                request.getParameter("number"), 
                request.getParameter("year"), 
                request.getParameter("pages"), 
                request.getParameter("publisher"), 
                request.getParameter("address"));
        rr.addArticle(reference);
        return "front";
    }
    
    @RequestMapping(value="list-bib", method = RequestMethod.GET)
    public String getBib() {
        return "list-bib";
    }
    
    @RequestMapping(value="list-norm", method = RequestMethod.GET)
    public String getNorm(HttpServletRequest request, HttpServletResponse response) {
        List<Reference> list = rr.getList();
        request.setAttribute("list", list);
        return "list-norm";
    }
}
