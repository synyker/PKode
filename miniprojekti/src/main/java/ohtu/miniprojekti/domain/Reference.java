/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniprojekti.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jonne
 */
@Entity
@Table(name = "Reference")
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "author")
    private String author;
    @Column(name = "title")
    private String title;
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
    }

    public void setId(Integer id) {
        this.id = id;
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
