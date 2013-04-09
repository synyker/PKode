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
    
    @RequestMapping("hello")
    public String process() {
        return "front";
    }
    @RequestMapping("index")
    public void processIndex(HttpServletRequest request, HttpServletResponse response) {
        
    }
}
