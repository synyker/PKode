package ohtu.miniprojekti.service;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.Map;
import ohtu.miniprojekti.domain.Reference;
import ohtu.miniprojekti.repository.ReferenceRepository;
import org.h2.engine.Database;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author krista
 */
public class ReferenceServiceTest {

    ReferenceService rs;
    Map<String, String[]> map;
    String[] arr;

    public ReferenceServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        rs = new ReferenceService();
        rs.setRepository(new ReferenceRepository(true, ReferenceRepository.Database.H2));
        map = new HashMap<String, String[]>();

        arr = new String[1];
        arr[0] = "Tekijä, Tauno";
        map.put("author", arr);
        arr = new String[1];
        arr[0] = "2009";
        map.put("year", arr);
        arr = new String[1];
        arr[0] = "Article";
        map.put("type", arr);
        arr = new String[1];
        arr[0] = "Otsikko";
        map.put("title", arr);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getListReturnsListWithCorrectSizeWhenNoneAdded() {
        assertEquals(0, rs.getList().size());
    }

    @Test
    public void getListReturnsListWithCorrectSizeWhenOneAdded() {
        rs.addArticle(map);
        assertEquals(1, rs.getList().size());
    }

    @Test
    public void textIdGeneratedCorrectlyWhenOneAuthor() {
        rs.addArticle(map);
        assertEquals("T09", rs.getList().get(0).getTextid());
    }

    @Test
    public void textIdGeneratedCorrectlyWhenMoreThanOneAuthor() {
        arr = new String[1];
        arr[0] = "Tekijä, Kalle; Sukunimi, Seppo; ääpeli, olli";
        map.put("author", arr);
        rs.addArticle(map);
        assertEquals("TSä09", rs.getList().get(0).getTextid());
    }

    @Test
    public void textIdGeneratedCorrectlyWhenMoreThanOneAuthorAndWhiteSpaces() {
        arr = new String[1];
        arr[0] = "Tekijä, Kalle         ;   Sukunimi, Seppo;         ääpeli, olli";
        map.put("author", arr);
        rs.addArticle(map);
        assertEquals("TSä09", rs.getList().get(0).getTextid());
    }

    @Test
    public void textidWorksIfNoYearGiven() {
        arr = new String[1];
        arr[0] = "";
        map.put("year", arr);
        rs.addArticle(map);
        assertEquals("T", rs.getList().get(0).getTextid());
    }

    @Test
    public void authorFieldModifiedCorrectly() {
        arr = new String[1];
        arr[0] = "Tekijä, Kalle;Sukunimi, Seppo; ääpeli, olli";
        map.put("author", arr);
        rs.addArticle(map);
        assertEquals("Tekijä, Kalle and Sukunimi, Seppo and ääpeli, olli", rs.getList().get(0).getAuthor());
    }

    @Test
    public void searchDoesntFindAnythinWhenWrongAuthor() {
        rs.addArticle(map);
        assertEquals(0, rs.findList("eilöydy").size());
    }

    @Test
    public void searcFindsWhenRightAuthor() {
        rs.addArticle(map);
        assertEquals(1, rs.findList("Teki").size());
    }

    @Test
    public void bibtexStringCorrectWhenOneReferenceAdded() {
        rs.addArticle(map);
        assertEquals("@Article{T09,\n    author = {Tekij\\\"{a}yr\\\", Tauno},\n    title = {Otsikko},\n    year = {2009},\n}\n", rs.generateBibtexString());
    }

    @Test
    public void bibtexStringCorrectWhenEmptyFieldsAdded() {
        arr = new String[1];
        arr[0] = "";
        map.put("journal", arr);
        rs.addArticle(map);
        assertEquals("@Article{T09,\n    author = {Tekij\\\"{a}yr\\\", Tauno},\n    title = {Otsikko},\n    year = {2009},\n}\n", rs.generateBibtexString());
    }

    @Test
    public void referenceNotAddedWhenNoAuthor() {
        arr = new String[1];
        arr[0] = "";
        map.put("author", arr);
        rs.addArticle(map);
        assertEquals(0, rs.getList().size());
    }

    @Test
    public void referenceNotAddedWhenAuthorNotInRightFormat() {
        arr = new String[1];
        arr[0] = "Kalle";
        map.put("author", arr);
        rs.addArticle(map);
        assertEquals(0, rs.getList().size());
    }

    @Test
    public void referenceNotAddedWhenNoTitle() {
        arr = new String[1];
        arr[0] = "";
        map.put("title", arr);
        rs.addArticle(map);
        assertEquals(0, rs.getList().size());
    }

    @Test
    public void referenceNotAddedWhenVolumeNotInRightFormat() {
        arr = new String[1];
        arr[0] = "k";
        map.put("volume", arr);
        rs.addArticle(map);
        assertEquals(0, rs.getList().size());
    }

    @Test
    public void referenceNotAddedWhenNumberNotInRightFormat() {
        arr = new String[1];
        arr[0] = "k";
        map.put("number", arr);
        rs.addArticle(map);
        assertEquals(0, rs.getList().size());
    }

    @Test
    public void referenceNotAddedWhenYearNotInRightFormat() {
        arr = new String[1];
        arr[0] = "12";
        map.put("year", arr);
        rs.addArticle(map);
        assertEquals(0, rs.getList().size());
    }

    @Test
    public void referenceNotAddedWhenPagesNotInRightFormat() {
        arr = new String[1];
        arr[0] = "1-2";
        map.put("pages", arr);
        rs.addArticle(map);
        assertEquals(0, rs.getList().size());
    }
    
     @Test
    public void correctErrorWhenPagesNotInRightFormat() {
        arr = new String[1];
        arr[0] = "1-2";
        map.put("pages", arr);
        assertEquals("Sivunumerot tulee erotella kahdella viivalla. \n", rs.addArticle(map));
    }
     @Test
    public void correctErrorWhenTwoFieldsNotInRightFormat() {
        arr = new String[1];
        arr[0] = "1-2";
        map.put("pages", arr);
        arr = new String[1];
        arr[0] = "k";
        map.put("number", arr);
        assertEquals("Number kentän täytyy sisältää pelkkiä numeroita.\n Sivunumerot tulee erotella kahdella viivalla. \n", rs.addArticle(map));
    }


}