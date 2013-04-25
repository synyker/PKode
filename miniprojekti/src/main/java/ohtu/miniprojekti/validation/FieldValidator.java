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
public class FieldValidator {
    
    public FieldValidator(){}
    
    public boolean onlyNumbers(String text) {
        String regex = "[0-9]*"; 
        return (text.matches(regex));
    }
    
    public boolean fourNumbers(String text) {
        String regex = "[0-9][0-9][0-9][0-9]||"; 
        return (text.matches(regex));
    }
    
    public boolean twoNumbersSeparatedWIthTwoLines(String text) {
        String regex = "||[0-9]+--[0-9]+"; 
        return (text.matches(regex));
    }
    
    public boolean authorGivenCorrectly(String text) {
        //String regex = "[a-zA-Z]\\s*,\\s*[a-zA-Z]\\s*(;\\s*[a-zA-Z]\\s*,\\s*[a-zA-Z]\\s*)*";
        String regex = "[a-zA-ZåäöÅÄÖ]+[ ]*,[ ]*[a-zA-ZåäöÅÄÖ]+[ ]*(;[ ]*[a-zA-ZåäöÅÄÖ]+[ ]*,[ ]*[a-zA-ZåäöÅÄÖ]+[ ]*)*";
        return (text.matches(regex));
    }
    
}
