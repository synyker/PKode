package ohtu.miniprojekti.domain;

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
    @Column(name = "id")
    private Integer id;
    @Column(name = "textid")
    private String textid;
    @Column(name="type")
    private String type;
    @Column(name = "author")
    private String author;
    @Column(name = "title")
    private String title;
    @Column(name = "booktitle")
    private String booktitle;
    @Column(name = "journal")
    private String journal;
    @Column(name = "volume")
    private String volume;
    @Column(name = "number")
    private String number;
    @Column(name = "year")
    private String year;
    @Column(name = "pages")
    private String pages;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "address")
    private String address;

    public Reference() {
    }

    /**
     * Constructor that takes all the information for an article as a parameter.
     *
     * If there is no information for a field, an empty string should be saved.
     *
     * @param author
     * @param title
     * @param journal
     * @param volume
     * @param number
     * @param year
     * @param pages
     * @param publisher
     * @param address
     */
    public Reference(String author, String title, String journal, String volume, String number, String year, String pages, String publisher, String address) {
        this.author = author;
        this.title = title;
        this.journal = journal;
        this.volume = volume;
        this.number = number;
        this.year = year;
        this.pages = pages;
        this.publisher = publisher;
        this.address = address;
        this.textid = generateTextId(author, year);
        this.type = "article";
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
    public Reference(String author, String title, String booktitle, String year, String pages, String publisher, String address) {
        this.author = author;
        this.title = title;
        this.booktitle = booktitle;
        this.year = year;
        this.pages = pages;
        this.publisher = publisher;
        this.address = address;
        this.textid = generateTextId(author, year);
        this.type = "inproceedings";
    }

    /**
     * Constructor that takes as a parameter all the information needed for a
     * book.
     *
     * @param author
     * @param title
     * @param year
     * @param publisher
     * @param address
     */
    public Reference(String author, String title, String year, String publisher, String address) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.address = address;
        this.textid = generateTextId(author, year);
        this.type = "book";
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
}
