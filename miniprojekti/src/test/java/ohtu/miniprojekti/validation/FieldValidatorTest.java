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
public class FieldValidatorTest {
    FieldValidator rs;
    
    public FieldValidatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        rs = new FieldValidator();
    }
    
    @After
    public void tearDown() {
    }
       @Test
    public void onlyNumbersReturnsTrueWhenEmpty() {
        assertTrue(rs.onlyNumbers(""));
    }

    @Test
    public void onlyNumbersReturnsTrueWhenOnlyNumbers() {
        assertTrue(rs.onlyNumbers("12"));
    }

    @Test
    public void onlyNumbersReturnsFalseWhenOtherThanNumbers() {
        assertTrue(!rs.onlyNumbers("12e"));
    }

    @Test
    public void fourNumbersReturnsTrueWhenEmpty() {
        assertTrue(rs.fourNumbers(""));
    }

    @Test
    public void fourNumbersReturnsTrueWhenOnlyNumbers() {
        assertTrue(rs.fourNumbers("1245"));
    }

    @Test
    public void fourNumbersReturnsFalseWhenOtherThanNumbers() {
        assertTrue(!rs.fourNumbers("12e"));
    }

    @Test
    public void fourNumbersReturnsFalseWhenOnlyNumbersButNotFour() {
        assertTrue(!rs.fourNumbers("12876"));
    }

    @Test
    public void twoNumbersSeparatedWIthTwoLinesReturnsTrueWhenEmpty() {
        assertTrue(rs.twoNumbersSeparatedWIthTwoLines(""));
    }

    @Test
    public void twoNumbersSeparatedWIthTwoLinesReturnsTrueWhenCorrect() {
        assertTrue(rs.twoNumbersSeparatedWIthTwoLines("12--45"));
    }

    @Test
    public void twoNumbersSeparatedWIthTwoLinesReturnsFalseWhenOnlyOneLine() {
        assertTrue(!rs.twoNumbersSeparatedWIthTwoLines("12-2"));
    }

    @Test
    public void twoNumbersSeparatedWIthTwoLinesReturnsFalseWhenOnlyOneNumberAndLines() {
        assertTrue(!rs.twoNumbersSeparatedWIthTwoLines("1--"));
    }

    @Test
    public void authorGivenCorrectlyReturnsTrueWhenOneAuthor() {
        assertTrue(rs.authorGivenCorrectly("Tekijä, Teemu"));
    }

    @Test
    public void authorGivenCorrectlyReturnsTrueWhenTwoAuthors() {
        assertTrue(rs.authorGivenCorrectly("Tekijä, Teemu ; Laulaja, lalli"));
    }

    @Test
    public void authorGivenCorrectlyReturnsTrueWhenThreeAuthorsr() {
        assertTrue(rs.authorGivenCorrectly("Tekijä, Teemu ; Ääliö, Olli ; poro, kalle"));
    }

    @Test
    public void authorGivenCorrectlyReturnsTrueWhenWhiteSpaces() {
        assertTrue(rs.authorGivenCorrectly("Tekijä   , Teemu    ; Ääliö,    Olli; poro   ,kalle  "));
    }

    @Test
    public void authorGivenCorrectlyReturnsFalseWhenAUthorsNotSeparatedCorrectly() {
        assertTrue(!rs.authorGivenCorrectly("Tekijä, Teemu ; Ääliö, Olli : poro, kalle"));
    }

    @Test
    public void authorGivenCorrectlyReturnsFalseWhenNamesNotSeparatedCorrectly() {
        assertTrue(!rs.authorGivenCorrectly("Tekijä Teemu ; Ääliö Olli ; poro kalle"));
    }

    @Test
    public void authorGivenCorrectlyReturnsFalseWhenOnlyOneNameForAUthor() {
        assertTrue(!rs.authorGivenCorrectly("Tekijä ; Ääliö"));
    }
}