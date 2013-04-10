package ohtu.miniprojekti;



import ohtu.miniprojekti.domain.Reference;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author klongi
 */
public class ReferenceTest {
    Reference reference;
    
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
        reference = new Reference("Tekijä", "Otsikko", "Lehti", "", "", "2009", "", "", "");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void authorSetCorrectlyWhenCreatedandNameGiven() {
        assertEquals(reference.getAuthor(), "Tekijä");
    }
    
    @Test
    public void titleSetCorrectlyWhenCreatedandNameGiven() {
        assertEquals(reference.getTitle(), "Otsikko");
    }
    
    @Test
    public void journalSetCorrectlyWhenCreatedandNameGiven() {
        assertEquals(reference.getJournal(), "Lehti");
    }
    
    @Test
    public void volumeSetCorrectlyWhenCreatedandEmptyStringGiven() {
        assertEquals(reference.getVolume(), "");
    }
}
