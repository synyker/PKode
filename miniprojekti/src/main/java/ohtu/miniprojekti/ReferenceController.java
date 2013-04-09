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
/**
 *
 * @author jonne
 */
@Controller
public class ReferenceController {
    
    @RequestMapping("add")
    public void processAdd(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().write("Hello World!");
        } catch (IOException ex) {
            System.out.println("Ei onnistunut!");
        }
    }
    @RequestMapping("index")
    public void processIndex(HttpServletRequest request, HttpServletResponse response) {
        
    }
}
