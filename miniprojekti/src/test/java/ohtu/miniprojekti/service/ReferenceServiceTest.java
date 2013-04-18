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
        rs.setRepository(new ReferenceRepository(true,ReferenceRepository.Database.H2));
    }
    
    @After
    public void tearDown() {
    }
 
    @Test
    public void ListBibTexReturnsNoScandicLettersWhenOneAdded() {
         Map<String,String[]> map = new HashMap<String,String[]>();
         String[] arr = new String[1];
         arr[0] = "Tekijä";
         map.put("author",arr);
         arr = new String[1];
         arr[0] = "2009";
         map.put("year",arr);
         rs.addArticle(map);
         assertEquals("Tekij\\\"{a}yr\\\"", rs.getBibTexList().get(0).getAuthor());
    }
    
    @Test
    public void editingRemovesScandicLetters() {
        assertEquals("\\\"{a}yr\\\"", rs.editScandinavianLetters("ä"));
    }
    
    @Test
    public void removingScandicLettersReturnsNullIfParameterIsNull() {
        assertEquals(null, rs.editScandinavianLetters(null));
    }
    
    @Test
    public void removingScandicLettersReturnsEmptyStringIfParameterIsEmptyString() {
        assertEquals("", rs.editScandinavianLetters(""));
    }
    
    @Test
    public void getListReturnsListWithCorrectSizeWhenNoneAdded() {
        assertEquals(0,rs.getList().size());
    }
    
    @Test
    public void getListReturnsListWithCorrectSizeWhenOneAdded() {
        Map<String,String[]> map = new HashMap<String,String[]>();
        String[] arr = new String[1];
        arr[0] = "Tekijä";
        map.put("author",arr);
        arr = new String[1];
        arr[0] = "2009";
        map.put("year",arr);
        rs.addArticle(map);
        assertEquals(1,rs.getList().size());
    }
}