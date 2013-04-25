/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.miniprojekti.validation;

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
public class BibTexValidatorTest {
    BibTexValidator bibVal;
    
    public BibTexValidatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        bibVal = new BibTexValidator();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void editingRemovesScandicLetters() {
        assertEquals("\\\"{a}yr\\\"", bibVal.editScandinavianLetters("ä"));
    }

    @Test
    public void removingScandicLettersReturnsNullIfParameterIsNull() {
        assertEquals(null, bibVal.editScandinavianLetters(null));
    }

    @Test
    public void removingScandicLettersReturnsEmptyStringIfParameterIsEmptyString() {
        assertEquals("", bibVal.editScandinavianLetters(""));
    }
}