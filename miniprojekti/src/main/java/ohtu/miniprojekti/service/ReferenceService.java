/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniprojekti.service;

import java.util.List;
import ohtu.miniprojekti.domain.Reference;
import ohtu.miniprojekti.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author krista
 */

@Component
public class ReferenceService {
    
    @Autowired
    private ReferenceRepository rr;
    
    public ReferenceService() {
        
    }

    public void addArticle(Reference reference) {
        rr.addArticle(reference);
    }

    public List<Reference> getList() {
        return rr.getList();
    }
    
    public List<Reference> getBibTexList() {
        List<Reference> references = rr.getList();
        for (Reference reference : references) {
           reference.setAuthor(editScandinavianLetters(reference.getAuthor()));
           reference.setTitle(editScandinavianLetters(reference.getTitle()));
           reference.setJournal(editScandinavianLetters(reference.getJournal()));
           reference.setAddress(editScandinavianLetters(reference.getAddress()));
           reference.setPublisher(editScandinavianLetters(reference.getPublisher()));
           reference.setBooktitle(editScandinavianLetters(reference.getBooktitle()));
           reference.setTextid(editScandinavianLetters(reference.getTextid()));
        }
        return references;
    }
    
    public String editScandinavianLetters(String text) {
        if (text == null || text.equals("")) {
            return text;
        }
        
        text = text.replace("ä", "\\\"{a}yr\\\"");
        text = text.replace("ö", "\\\"{o}yr\\\"");
        return text;
    }
    
    
}
