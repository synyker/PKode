/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniprojekti.controller;

import ohtu.miniprojekti.*;
import com.avaje.ebean.EbeanServer;
import java.io.IOException;
import java.io.OutputStream;
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

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String postAdd(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String[]> map = request.getParameterMap();
        String error = rs.addArticle(map);
        List<Reference> list = rs.getList();
        request.setAttribute("list", list);
        if (!error.equals("")) {
            request.setAttribute("error", error);
            request.setAttribute("type", map.get("type")[0]);
            return "add";
        }

        return "list-norm";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteReference(HttpServletRequest request, HttpServletResponse response) {
        rs.deleteArticle(request.getParameter("id"));
        List<Reference> list = rs.getList();
        request.setAttribute("list", list);

        return "list-norm";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String getEdit(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Reference ref = rs.findUnique(id);
        request.setAttribute("reference", ref);
        return "edit";
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String postEdit(HttpServletRequest request, HttpServletResponse response) {
        Map<String,String[]> map = request.getParameterMap();
        String error = rs.editArticle(map);
        if(!error.equals("")) {
            request.setAttribute("error", error);
            request.setAttribute("reference", map);
            request.setAttribute("type", map.get("type")[0]);
            return "edit";
        }
        List<Reference> list = rs.getList();
        request.setAttribute("list", list);
            
        return "list-norm";
    }
    
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String searchAuthor(HttpServletRequest request, HttpServletResponse response) {
        List<Reference> list = rs.findList(request.getParameter("author"));
        request.setAttribute("list", list);
        return "list-norm";
    }

    @RequestMapping(value = "list-bib", method = RequestMethod.GET)
    public String getBib(HttpServletRequest request, HttpServletResponse response) {
        String bibstring = rs.generateBibtexString();
        request.setAttribute("bibstring", bibstring);
        return "list-bib";
    }

    @RequestMapping(value = "list-norm", method = RequestMethod.GET)
    public String getNorm(HttpServletRequest request, HttpServletResponse response) {
        List<Reference> list = rs.getList();
        request.setAttribute("list", list);

        return "list-norm";
    }

    @RequestMapping(value = "download", method = RequestMethod.GET)
    public String getFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String bibtex = rs.generateBibtexString();
        response.setContentLength((int) bibtex.length());
        String filename = "";
        if (request.getParameter("filename").equals("")) {
            filename = "file.bib";
        } else {
            filename = request.getParameter("filename") + ".bib";
        }

        if (!request.getParameter("filename").equals("integration-test")) {
            response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
            response.setContentType("application/octet-stream");
        }
        OutputStream os = response.getOutputStream();
        int written = 0;
        while (written < bibtex.length()) {
            os.write(bibtex.charAt(written));
            written++;
        }
        os.close();
        return "list-bib";
    }
}
