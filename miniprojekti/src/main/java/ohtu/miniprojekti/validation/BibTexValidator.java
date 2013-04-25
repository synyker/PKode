/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniprojekti.validation;

import org.springframework.stereotype.Component;

/**
 *
 * @author krista
 */

@Component
public class BibTexValidator {
    
    public BibTexValidator() {}
    
    /**
     * Replaces scandivanian letters with characters needed for BibTex Format
     * 
     * @param text to be edited
     * @return edited text
     */
    public String editScandinavianLetters(String text) {
        if (text == null || text.equals("")) {
            return text;
        }
        
        text = text.replace("ä", "\\\"{a}yr\\\"");
        text = text.replace("ö", "\\\"{o}yr\\\"");
        text = text.replace("Ä", "\\\"{A}yr\\\"");
        text = text.replace("Ö", "\\\"{O}yr\\\"");
        return text;
    }
    
    /**
     * Edits each field saved to database to bibtex format
     * @param fieldname field to be edited
     * @param field value of the field
     * @return edited value
     */
      public String checkFieldForBibTex(String fieldname, String field) {
        if (field != null && !field.equals("")) {
            field = editScandinavianLetters(field);
            return "" + "    " + fieldname + " = {" + field + "},"+"\n";
        } else {
            return "";
        }
    }
    
    
}
