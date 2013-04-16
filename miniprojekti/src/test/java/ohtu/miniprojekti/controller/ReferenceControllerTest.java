package ohtu.miniprojekti.controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 *
 * @author krista
 */
public class ReferenceControllerTest {
    private WebDriver driver;
    private ReferenceController controller;
    
    public ReferenceControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        controller = new ReferenceController();
        driver = new HtmlUnitDriver();
    }
    
    @After
    public void tearDown() {
        driver.close();
    }
    @Test
    public void hello() {
        
    }
//   @Test
//    public void afterAddingArticleSuccessMessageIsShown() {
//        driver.get("http://localhost:8080");
//        //System.out.println( driver.getPageSource() );
//        WebElement element = driver.findElement(By.id("add"));
//        element.click();
// 
//        //System.out.println( driver.getPageSource() );
//        element = driver.findElement(By.name("author"));
//        element.sendKeys("Kirjoittaja, Kalle");
//        element = driver.findElement(By.name("title"));
//        element.sendKeys("Hieno Juttu");
//        element = driver.findElement(By.name("send"));
//        element.submit();
//        //System.out.println(driver.getPageSource());
//        assertTrue((driver.getPageSource().contains("Artikkelin lisääminen onnistui!")));  
//    }
//   
//    @Test
//    public void listInBibTexFormatIsShown() {  
//        driver.get("http://localhost:8080");
//        WebElement element = driver.findElement(By.id("bib"));
//        element.click(); 
//        assertTrue((driver.getPageSource().contains("listaus BibTex")));  
//    }
//    
//    @Test
//    public void listInNormalFormatIsShown() {
//        driver.get("http://localhost:8080");
//        WebElement element = driver.findElement(By.id("normal"));
//        element.click(); 
//        assertTrue((driver.getPageSource().contains("listaus ymmärrettävässä muodossa")));  
//    }
//    
//    @Test
//    public void afterAddingArticleItIsListedInBibTexFormat() {
//       
//        driver.get("http://localhost:8080");
//        //System.out.println( driver.getPageSource() );
//        WebElement element = driver.findElement(By.id("add"));
//        element.click();
// 
//        //System.out.println( driver.getPageSource() );
//        element = driver.findElement(By.name("author"));
//        element.sendKeys("Kalle Kirjoittaja");
//        element = driver.findElement(By.name("title"));
//        element.sendKeys("Hieno Juttu");
//        element = driver.findElement(By.name("send"));
//        element.submit();
//        element = driver.findElement(By.id("back"));
//        element.click();
//        driver.findElement(By.id("bib"));
//        element.click(); 
//        assertTrue((driver.getPageSource().contains("author = {Kirjoittaja, Kalle}"))); 
//    }
//    
//    @Test
//    public void afterAddingArticleItIsListedInNormalFormat() {
//       
//        driver.get("http://localhost:8080");
//        WebElement element = driver.findElement(By.id("add"));
//        element.click();
//        element = driver.findElement(By.name("author"));
//        element.sendKeys("Kalle Kirjoittaja");
//        element = driver.findElement(By.name("title"));
//        element.sendKeys("Hieno Juttu");
//        element = driver.findElement(By.name("send"));
//        element.submit();
//        System.out.println( driver.getPageSource() );
//        element = driver.findElement(By.id("back"));
//        element.click();
//        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
//        System.out.println( driver.getPageSource() );
//        element = driver.findElement(By.id("normal"));
//        System.out.println("kkkkk");
//        element.click();
//        System.out.println( driver.getPageSource() );
//        assertTrue((driver.getPageSource().contains("Author: Kirjoittaja, Kalle"))); 
//    }
//
}