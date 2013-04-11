import ohtu.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;



description 'user can list all added articles in BibTex format'
 
scenario "user can list all added articles in BibTexFormat", {
    given 'command list all selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.id("bib"));       
        element.click(); 
    }
    when 'page is loadede', {

    }
    then 'title of the page should be printed', {
        driver.getPageSource().contains("listaus BibTex").shouldBe true
    }
}

scenario "user can list all added articles in BibTexFormat", {
    given 'command list all selected', {

    }
    when 'page is loaded and there are articles in database', {

    }
    then 'title and articles in BibTex Format should be printed', {

    }
}
 
