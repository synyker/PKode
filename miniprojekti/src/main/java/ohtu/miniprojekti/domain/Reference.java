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
    
    public Reference(Map<String,String> map) {
        this.type = map.get("type");
        this.author = map.get("author");
        this.title = map.get("title");
        this.booktitle = map.get("booktitle");
        this.journal = map.get("journal");
        this.volume = map.get("volume");
        this.number = map.get("number");
        this.year = map.get("year");
        this.pages = map.get("pages");
        this.publisher = map.get("publisher");
        this.address = map.get("address");
        this.series = map.get("series");
        this.edition = map.get("edition");
        this.month = map.get("month");
        this.note = map.get("note");
        this.editor = map.get("editor");
        this.organisation = map.get("organisation");
        this.textid = map.get("textid");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public void updateValues(Map<String, String> map) {
        setType(map.get("type"));
        setAuthor(map.get("author"));
        setTitle(map.get("title"));
        setBooktitle(map.get("booktitle"));
        setJournal(map.get("journal"));
        setVolume(map.get("volume"));
        setNumber(map.get("number"));
        setYear(map.get("year"));
        setPages(map.get("pages"));
        setPublisher(map.get("publisher"));
        setAddress(map.get("address"));
        setSeries(map.get("series"));
        setEdition(map.get("edition"));
        setMonth(map.get("month"));
        setNote(map.get("note"));
        setEditor(map.get("editor"));
        setOrganisation(map.get("organisation"));
        setTextid(map.get("textid"));
    }
}
