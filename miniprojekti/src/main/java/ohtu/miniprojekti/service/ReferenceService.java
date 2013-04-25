/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniprojekti.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
    
    public ReferenceService() {}

    public String addArticle(Map<String,String[]> map) {
        String error = "";
        Map<String,String> values = modifyMap(map);
        //error = validate(values);
        values.put("textid", generateTextId(values.get("author"), values.get("year")));
        values.put("author", values.get("author").replace(";", " and "));
        values.put("author", values.get("author").replace("  ", " "));
        Reference r = new Reference(values);
        rr.addArticle(r);
        
        return error;
    }
    
    /**
     * 
     * @return list of all references in the database
     */
    public List<Reference> getList() {
        return rr.getList();
    }
    
    /**
     * Returns a list of all references where the author field includes the string given as a parameter.
     * @param author
     * @return 
     */
    public List<Reference> findList(String author) {
        return rr.findList(author);
    }
    
    /**
     * Returns a list of references in BibTex Format.
     * 
     * Scandic letters are replaced with appropriate characters.
     * @return  list of all references in the database in BibTex Format
     */
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
     * Changes a Map<String, String[]> into Map<String, String>
     * 
     * @param map to be changed
     * @return new map
     */
    private Map<String, String> modifyMap(Map<String, String[]> map) {
        Map<String,String> map1 = new HashMap<String,String>();
        Iterator i = map.entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry pairs = (Map.Entry<String,String[]>)i.next();
            String key = (String) pairs.getKey();
            String value = ((String[]) pairs.getValue())[0];
            map1.put(key, value);
        }
        return map1;
    }
    
    public void setRepository(ReferenceRepository repo) {
        this.rr = repo;
    }
    
    /**
     * Generates a textid for the reference.
     * 
     * Textid is the first letter of all lastnames of authors and two of the last numbers in the year.
     * It is assumed that authors are given in a format "Lastname1, Firstname1 ; Lastname2, Firstname2".
     * It does not check whether the id is unique. This must be done before saving to the database.
     * 
     * @param author 
     */
    private String generateTextId(String author, String year) {
        String id = "";
        String[] authors = author.split(";");
        for (int i = 0; i < authors.length; i++) {
            id += authors[i].trim().substring(0, Math.min(1, authors[i].length()));    
        }
        if (year.length() > 1) {
            id += year.substring(year.length()-2, year.length());
        }
        
        return id;
    }
    
    public String generateBibtexString() {
        List<Reference> bibtexlist = getList();
        String returnable = "";
        for (Reference reference : bibtexlist) {
            returnable += "@" + reference.getType() + "{" + reference.getTextid()+","+"\n";
            returnable += checkField("author", reference.getAuthor())
                            + checkField("booktitle", reference.getBooktitle())
                            + checkField("title", reference.getTitle())
                            + checkField("journal", reference.getJournal())
                            + checkField("volume", reference.getVolume())
                            + checkField("number", reference.getNumber())
                            + checkField("year", reference.getYear())
                            + checkField("month", reference.getMonth())
                            + checkField("pages", reference.getPages())
                            + checkField("publisher", reference.getPublisher())
                            + checkField("address", reference.getAddress())
                            + checkField("series", reference.getSeries())
                            + checkField("edition", reference.getEdition())
                            + checkField("note", reference.getNote())
                            + checkField("editor", reference.getEditor())
                            + checkField("organisation", reference.getOrganisation());
            returnable += "}\n";
        }
        return returnable;
    }
    
    private String checkField(String fieldname, String field) {
        if (field != null && !field.equals("")) {
            field = editScandinavianLetters(field);
            return "" + "    " + fieldname + " = {" + field + "},"+"\n";
        } else {
            return "";
        }
    }

    private String validate(Map<String, String> values) {
        throw new UnsupportedOperationException("Not yet implemented");
        /**
         * Tässä käy läpi nuo kaikki arvot siellä mapissa jotka vaatii validointia
         * eli nuo mitkä on listattu backlogissa. 
         * 
         * Tekee erilliset metodit, jotka palauttaa kans stringiä, jotka katenoidaan
         * tohon erroriin. Ne erilliset Virheet sit muotoon 
         * "Vuosiluvun täytyy olla nelinumeroinen kokonaisluku. "
         * eli väli perään, niin seuraava katenoiduu kivasti perään kiinni.
         * 
         * Controllerissa ja add.jsp:ssä toimii kaikki jo täysin.
         */
        
        //String error = "";
    }
    public void deleteArticle(String id) {
        rr.deleteArticle(id);
    }
    
    
}
