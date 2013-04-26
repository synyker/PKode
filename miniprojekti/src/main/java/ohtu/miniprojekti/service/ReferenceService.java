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
import ohtu.miniprojekti.validation.BibTexValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ohtu.miniprojekti.validation.FieldValidator;

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
        error = validate(values);
        if (error.equals("")) {
            values.put("textid", generateTextId(values.get("author"), values.get("year")));
            values.put("author", values.get("author").replace(";", " and "));
            values.put("author", values.get("author").replace("  ", " "));
            
            Reference r = new Reference(values);
            rr.addArticle(r);
        }
        return error;
    }
    
    public String editArticle(Map<String, String[]> map) {
        String error = "";
        Map<String,String> values = modifyMap(map);
        error = validate(values);
        
        if (error.equals("")) {
            values.put("textid", generateTextId(values.get("author"), values.get("year")));
            values.put("author", values.get("author").replace(";", " and "));
            values.put("author", values.get("author").replace("  ", " "));
            Reference ref = rr.findUnique(values.get("id"));
            ref.updateValues(values);
            rr.editReference(ref);
            
        }
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
        BibTexValidator bibValidator = new BibTexValidator();
        List<Reference> bibtexlist = getList();
        String returnable = "";
        for (Reference reference : bibtexlist) {
            returnable += "@" + reference.getType() + "{" + reference.getTextid()+","+"\n";
            returnable += bibValidator.checkFieldForBibTex("author", reference.getAuthor())
                            + bibValidator.checkFieldForBibTex("booktitle", reference.getBooktitle())
                            + bibValidator.checkFieldForBibTex("title", reference.getTitle())
                            + bibValidator.checkFieldForBibTex("journal", reference.getJournal())
                            + bibValidator.checkFieldForBibTex("volume", reference.getVolume())
                            + bibValidator.checkFieldForBibTex("number", reference.getNumber())
                            + bibValidator.checkFieldForBibTex("year", reference.getYear())
                            + bibValidator.checkFieldForBibTex("month", reference.getMonth())
                            + bibValidator.checkFieldForBibTex("pages", reference.getPages())
                            + bibValidator.checkFieldForBibTex("publisher", reference.getPublisher())
                            + bibValidator.checkFieldForBibTex("address", reference.getAddress())
                            + bibValidator.checkFieldForBibTex("series", reference.getSeries())
                            + bibValidator.checkFieldForBibTex("edition", reference.getEdition())
                            + bibValidator.checkFieldForBibTex("note", reference.getNote())
                            + bibValidator.checkFieldForBibTex("editor", reference.getEditor())
                            + bibValidator.checkFieldForBibTex("organisation", reference.getOrganisation());
            returnable += "}\n";
        }
        return returnable;
    }
   

    private String validate(Map<String, String> values) {
        FieldValidator validator = new FieldValidator();
        String error = "";
        if (values.get("author") == null || values.get("author").equals("")) {
            error += "Author kenttä ei saa olla tyhjä. \n";
        }
         if (values.get("title") == null || values.get("title").equals("")) {
            error += "Title kenttä ei saa olla tyhjä. \n";
        }
        if (values.get("author") != null && !validator.authorGivenCorrectly(values.get("author"))) {
            error += "Author kenttä on oltava muodossa Sukunimi, Etunimi ; Sukunimi2, Etunimi. Erottele nimet pilkuilla ja kirjailijat puolipisteellä. \n";
        }
        if (values.get("volume") != null && !validator.onlyNumbers(values.get("volume"))) {
            error += "Volume kentän täytyy sisältää pelkkiä numeroita.\n ";
        }
        if (values.get("number") != null && !validator.onlyNumbers(values.get("number"))) {
            error += "Number kentän täytyy sisältää pelkkiä numeroita.\n ";
        }
        if (values.get("year") != null && !validator.fourNumbers(values.get("year"))) {
            error += "Year täytyy sisältää 4 numeroa.\n ";
        }
        if (values.get("pages") != null && !validator.twoNumbersSeparatedWIthTwoLines(values.get("pages"))) {
            error += "Sivunumerot tulee erotella kahdella viivalla. \n";
        }
        return error;
    }

    public void deleteArticle(String id) {
        rr.deleteArticle(id);
    }

    

    public Reference findUnique(String id) {
        return rr.findUnique(id);
    }
}
