/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniprojekti.controller;

import ohtu.miniprojekti.*;
import com.avaje.ebean.EbeanServer;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ohtu.miniprojekti.domain.Reference;
import ohtu.miniprojekti.repository.ReferenceRepository;
import ohtu.miniprojekti.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jonne, krista, markus
 */
@Controller
public class ReferenceController {

    @Autowired
    private ReferenceService rs;

    @RequestMapping("")
    public String getAll() {
        return "front";
    }

    @RequestMapping("front")
    public String getFront() {
        return "front";
    }

    @RequestMapping("what-to-add")
    public String getWhatToAdd() {
        return "what-to-add";
    }

    @RequestMapping(value = "add-article", method = RequestMethod.GET)
    public String getAddArticle(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("type", "Article");
        return "add";
    }

    @RequestMapping(value = "add-book", method = RequestMethod.GET)
    public String getAddBook(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("type", "Book");
        return "add";
    }

    @RequestMapping(value = "add-inproceedings", method = RequestMethod.GET)
    public String getAddInproceedings(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("type", "InProceedings");
        return "add";
    }

    /**
     * Defines what happens when an article is added.
     *
     * The info from all fields is saved into a Reference object, which is then
     * added to the database.
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String postAdd(HttpServletRequest request, HttpServletResponse response) {
//        Reference reference = new Reference(request.getParameter("author"),
//                request.getParameter("title"),
//                request.getParameter("journal"),
//                request.getParameter("volume"),
//                request.getParameter("number"),
//                request.getParameter("year"),
//                request.getParameter("pages"),
//                request.getParameter("publisher"),
//                request.getParameter("address"));
        Map<String,String[]> map = request.getParameterMap();
        rs.addArticle(new Reference(map));
        List<Reference> list = rs.getList();
        request.setAttribute("list", list);
        return "list-norm";
    }

    /**
     * Defnes what happens when we want to list all references in BibTex Format.
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "list-bib", method = RequestMethod.GET)
    public String getBib(HttpServletRequest request, HttpServletResponse response) {
        List<Reference> list = rs.getList();
        request.setAttribute("list", list);
        return "list-bib";
    }

    /**
     * Defines what happens when we want to list all references in readable
     * format.
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "list-norm", method = RequestMethod.GET)
    public String getNorm(HttpServletRequest request, HttpServletResponse response) {
        List<Reference> list = rs.getList();
        request.setAttribute("list", list);

        return "list-norm";
    }
//    public ReferenceRepository getReferenceRepository() {
//        return rr;
//    }
}
