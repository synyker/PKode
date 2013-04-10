/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniprojekti.repository;

import ohtu.miniprojekti.domain.Reference;
import ohtu.miniprojekti.repository.ReferenceRepository.Database;
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
public class ReferenceRepositoryTest {
    ReferenceRepository rr;
    Reference reference;
    
    public ReferenceRepositoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        rr = new ReferenceRepository(Database.H2);
        reference = new Reference("Tekijä", "Otsikko", "Lehti", "", "", "2009", "", "", "");
    }
    
    @After
    public void tearDown() {
    }
    
     @Test
     public void referenceIsAddedToDatabase() {
         rr.addArticle(reference);
         assertEquals("Tekijä", ((Reference)rr.getList().get(0)).getAuthor());
     }
     
     @Test
     public void getListReturnsListWithRightSizeWhenOneAdded() {
         rr.addArticle(reference);
         assertTrue(rr.getList().size() == 1);
     }
     
     @Test
     public void getListReturnsRightSizeWhenNothingAdded() {
         assertTrue(rr.getList().size() == 0);
     }
     
     @Test
     public void getListReturnsListWithRightSizeWhenMoreThanOneAdded() {
         rr.addArticle(reference);
         rr.addArticle(new Reference("Tekijä2", "Otsikko2", "Lehti2", "", "", "1886", "", "", ""));
         assertTrue(rr.getList().size() == 2);
     }
}