package ohtu.miniprojekti;

import java.util.HashMap;
import java.util.Map;
import ohtu.miniprojekti.domain.Reference;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author krista, jonne, markus
 */
public class ReferenceTest {

    Reference reference;
    Map<String,String> map;
    public ReferenceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        map = new HashMap<String,String>();
        map.put("author", "Tekijä");
        map.put("title","Otsikko");
        map.put("journal","Lehti");
        map.put("year","2009");
        map.put("type","Article");
        map.put("volume","");
        reference = new Reference(map);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void authorSetCorrectlyWhenCreatedandNameGiven() {
        assertEquals("Tekijä", reference.getAuthor());
    }

    @Test
    public void titleSetCorrectlyWhenCreatedandNameGiven() {
        assertEquals("Otsikko", reference.getTitle());
    }

    @Test
    public void journalSetCorrectlyWhenCreatedandNameGiven() {
        assertEquals("Lehti", reference.getJournal());
    }

    @Test
    public void volumeSetCorrectlyWhenCreatedandEmptyStringGiven() {
        assertEquals("", reference.getVolume());
    }

    @Test
    public void typeCorrectWhenAddingArticle() {
        assertEquals("Article", reference.getType());
    }

    @Test
    public void typeCorrectWhenAddingBook() {
        map.put("type","Book");
        reference = new Reference(map);
        assertEquals("Book", reference.getType());
    }

    @Test
    public void typeCorrectWhenAddingInproceedings() {
        map.put("type", "InProceedings");
        reference = new Reference(map);
        assertEquals("InProceedings", reference.getType());
    }
    
    @Test
    public void updateValuesUpdates() {
        map.put("author", "Uusi, Ulla");
        reference.updateValues(map);
        assertEquals("Uusi, Ulla", reference.getAuthor());
    }
}
