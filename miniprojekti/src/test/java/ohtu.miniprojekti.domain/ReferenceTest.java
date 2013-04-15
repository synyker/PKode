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
 * @author krista, jonne, markus
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
        assertEquals("article", reference.getType());
    }

    @Test
    public void textIdGeneratedCorrectlyWhenOneAuthor() {
        assertEquals("T09", reference.getTextid());
    }

    @Test
    public void textIdGeneratedCorrectlyWhenMoreThanOneAuthor() {
        reference = new Reference("Tekijä, Kalle; Sukunimi, Seppo; ääpeli, olli", "Otsikko", "Lehti", "", "", "2013", "", "", "");
        assertEquals("TSä13", reference.getTextid());
    }

    @Test
    public void textIdGeneratedCorrectlyWhenMoreThanOneAuthorAndWhiteSpaces() {
        reference = new Reference("Tekijä, Kalle   ; Sukunimi, Seppo  ;  ääpeli, olli", "Otsikko", "Lehti", "", "", "2013", "", "", "");
        assertEquals("TSä13", reference.getTextid());
    }

    @Test
    public void textIdGeneratedCorrectlyWhenYearTooLong() {
        reference = new Reference("Tekijä, Kalle; Sukunimi, Seppo; ääpeli, olli", "Otsikko", "Lehti", "", "", "20000000000013", "", "", "");
        assertEquals("TSä13", reference.getTextid());
    }

    @Test
    public void typeCorrectWhenAddingBook() {
        reference = new Reference("Tekijä, Kalle; Sukunimi, Seppo; ääpeli, olli", "Otsikko", "2009", "", "");
        assertEquals("book", reference.getType());
    }

    @Test
    public void typeCorrectWhenAddingInproceedings() {
        reference = new Reference("Tekijä, Kalle; Sukunimi, Seppo; ääpeli, olli", "Otsikko", "Lehti", "2009", "", "", "");
        assertEquals("inproceedings", reference.getType());
    }
    
    @Test
    public void textidWorksIfNoAUthorGiven() {
        reference = new Reference("", "Otsikko", "Lehti", "", "", "2013", "", "", "");
        assertEquals("13", reference.getTextid());
    }
    
     @Test
    public void textidWorksIfNoYearGiven() {
        reference = new Reference("Kalle", "Otsikko", "Lehti", "", "", "", "", "", "");
        assertEquals("K", reference.getTextid());
    }
}
