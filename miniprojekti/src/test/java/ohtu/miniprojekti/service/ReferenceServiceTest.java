package ohtu.miniprojekti.service;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ohtu.miniprojekti.domain.Reference;
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
    }
    
    @After
    public void tearDown() {
    }
 
//     @Test
//     public void ListBibTexReturnsNoScandicLettersWhenOneAdded() {
//         rs.addArticle(new Reference("Tekijä", "Otsikko", "Lehti", "", "", "2009", "", "", ""));
//         assertEquals("Tekij\\\"{a}yr\\\"", rs.getBibTexList().get(0));
//     }
    
    @Test
    public void editingRemovesScandicLetters() {
        assertEquals("\\\"{a}yr\\\"", rs.editScandinavianLetters("ä"));
    }
    
    @Test
    public void editingWorksWithEmptyString() {
        assertEquals("", rs.editScandinavianLetters(""));
    }
}