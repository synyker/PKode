package ohtu.miniprojekti.domain;

import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Reference
 *
 * all information of a reference is saved here.
 *
 * @author jonne, krista, markus
 */
@Entity
@Table(name = "Reference")
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String textid;
    private String type;
    private String author;
    private String title;
    private String booktitle;
    private String journal;
    private String volume;
    private String number;
    private String year;
    private String pages;
    private String publisher;
    private String address;
    private String series;
    private String edition;
    private String month;
    private String note;
    private String editor;
    private String organisation;
    

    public Reference() {}
    
    public Reference(Map<String,String[]> map) {
        this.type = getValue(map, "type");
        this.author = getValue(map, "author");
        this.title = getValue(map, "title");
        this.booktitle = getValue(map, "booktitle");
        this.journal = getValue(map, "journal");
        this.volume = getValue(map, "volume");
        this.number = getValue(map, "number");
        this.year = getValue(map, "year");
        this.pages = getValue(map, "pages");
        this.publisher = getValue(map, "publisher");
        this.address = getValue(map, "address");
        this.series = getValue(map, "series");
        this.edition = getValue(map, "edition");
        this.month = getValue(map, "month");
        this.note = getValue(map, "note");
        this.editor = getValue(map, "editor");
        this.organisation = getValue(map, "organisation");
        this.textid = generateTextId(this.author, this.year);
    }
    
    private String getValue(Map<String,String[]> map,String key) {
        if(map.get(key) != null)
            return map.get(key)[0];
        return null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Constructor that takes all the information needed for an inproceedings as
     * a parameter.
     *
     * If there is no information for a field, an empty string should be saved.
     *
     * @param author
     * @param title
     * @param booktitle
     * @param year
     * @param pages
     * @param publisher
     * @param address
     */
    
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

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextid() {
        return textid;
    }

    public void setTextid(String textid) {
        this.textid = textid;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public Integer getId() {
        return this.id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getJournal() {
        return this.journal;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getVolume() {
        return this.volume;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return this.year;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPages() {
        return this.pages;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }
}
