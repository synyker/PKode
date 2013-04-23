import ohtu.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;



description 'user can directly access the list of references in BibTex format from the list of references in readable format '
 
scenario "user can list all added articles in readable format", {
    given 'command list all in readable format selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8736");
        element = driver.findElement(By.id("normal"));       
        element.click(); 
    }
    when 'user clicks the link to show references in BibTex Format', {
        element = driver.findElement(By.id("bib"));
        element.click()
    }
    then 'the references are shown in BibTex format', {
        driver.getPageSource().contains("listaus BibTex").shouldBe true
    }

}