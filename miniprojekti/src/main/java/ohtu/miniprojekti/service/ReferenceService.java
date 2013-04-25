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
    
//    /**
//     * Returns a list of references in BibTex Format.
//     * 
//     * Scandic letters are replaced with appropriate characters.
//     * @return  list of all references in the database in BibTex Format
//     */
//    public List<Reference> getBibTexList() {
//        List<Reference> references = rr.getList();
//        for (Reference reference : references) {
//            reference.setAuthor(editScandinavianLetters(reference.getAuthor()));
//            reference.setTitle(editScandinavianLetters(reference.getTitle()));
//            reference.setJournal(editScandinavianLetters(reference.getJournal()));
//            reference.setAddress(editScandinavianLetters(reference.getAddress()));
//            reference.setPublisher(editScandinavianLetters(reference.getPublisher()));
//            reference.setBooktitle(editScandinavianLetters(reference.getBooktitle()));
//            reference.setTextid(editScandinavianLetters(reference.getTextid()));
//        }
//        return references;
//    }
    
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
            returnable += checkFieldForBibTex("author", reference.getAuthor())
                            + checkFieldForBibTex("booktitle", reference.getBooktitle())
                            + checkFieldForBibTex("title", reference.getTitle())
                            + checkFieldForBibTex("journal", reference.getJournal())
                            + checkFieldForBibTex("volume", reference.getVolume())
                            + checkFieldForBibTex("number", reference.getNumber())
                            + checkFieldForBibTex("year", reference.getYear())
                            + checkFieldForBibTex("month", reference.getMonth())
                            + checkFieldForBibTex("pages", reference.getPages())
                            + checkFieldForBibTex("publisher", reference.getPublisher())
                            + checkFieldForBibTex("address", reference.getAddress())
                            + checkFieldForBibTex("series", reference.getSeries())
                            + checkFieldForBibTex("edition", reference.getEdition())
                            + checkFieldForBibTex("note", reference.getNote())
                            + checkFieldForBibTex("editor", reference.getEditor())
                            + checkFieldForBibTex("organisation", reference.getOrganisation());
            returnable += "}\n";
        }
        return returnable;
    }
    
    private String checkFieldForBibTex(String fieldname, String field) {
        if (field != null && !field.equals("")) {
            field = editScandinavianLetters(field);
            return "" + "    " + fieldname + " = {" + field + "},"+"\n";
        } else {
            return "";
        }
    }

    private String validate(Map<String, String> values) {
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
        
        String error = "";
        if (values.get("author") == null || values.get("author").equals("")) {
            error += "Author kenttä ei saa olla tyhjä. \n";
        }
         if (values.get("title") == null || values.get("title").equals("")) {
            error += "Title kenttä ei saa olla tyhjä. \n";
        }
        if (values.get("author") != null && !authorGivenCorrectly(values.get("author"))) {
            error += "Author kenttä on oltava muodossa Sukunimi, Etunimi ; Sukunimi2, Etunimi. Erottele nimet pilkuilla ja kirjailijat puolipisteellä. \n";
        }
        if (values.get("volume") != null && !onlyNumbers(values.get("volume"))) {
            error += "Volume kentän täytyy sisältää pelkkiä numeroita.\n ";
        }
        if (values.get("number") != null && !onlyNumbers(values.get("number"))) {
            error += "Number kentän täytyy sisältää pelkkiä numeroita.\n ";
        }
        if (values.get("year") != null && !fourNumbers(values.get("year"))) {
            error += "Year täytyy sisältää 4 numeroa.\n ";
        }
        if (values.get("pages") != null && !twoNumbersSeparatedWIthTwoLines(values.get("pages"))) {
            error += "Sivunumerot tulee erotella kahdella viivalla. \n";
        }
        return error;
    }
    
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
