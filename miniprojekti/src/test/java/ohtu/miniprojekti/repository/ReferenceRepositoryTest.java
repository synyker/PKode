/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniprojekti.repository;

import java.util.HashMap;
import java.util.Map;
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
    Map<String,String> map;
    
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
        rr = new ReferenceRepository(true, Database.H2);
        map = new HashMap<String,String>();
        map.put("author", "Tekijä");
        map.put("title","Otsikko");
        map.put("journal","Lehti");
        map.put("year","2009");
        map.put("textid", "T09");
        reference = new Reference(map);
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
         rr.addArticle(new Reference(map));
         assertTrue(rr.getList().size() == 2);
     }
     
     @Test
     public void addedArticleHasCorrectTextIdWhenOnlyOneAdded() {
         rr.addArticle(reference);
         assertEquals("T09", rr.getList().get(0).getTextid());
     }
     
     @Test
     public void addedArticleHasCorrectTextIdWhenTwoWithSameId() {
         rr.addArticle(reference);
         rr.addArticle(new Reference(map));
         assertEquals("T09a", rr.getList().get(1).getTextid());
     }
     
      @Test
     public void addedArticleHasCorrectTextIdWhenFourWithSameId() {
         rr.addArticle(reference);
         rr.addArticle(new Reference(map));
         rr.addArticle(new Reference(map));
         rr.addArticle(new Reference(map));
         assertEquals("T09c", rr.getList().get(3).getTextid());
     }
      
     @Test
     public void addedArticleHasCorrectTextIdWhenTwoWithSimilarID() {
         rr.addArticle(reference);
         Map<String,String> map1 = map;
         map1.put("textid", "TT09");
         rr.addArticle(new Reference(map));
         assertEquals("TT09", rr.getList().get(1).getTextid());
     }
}