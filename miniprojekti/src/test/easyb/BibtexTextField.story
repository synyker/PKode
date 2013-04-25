import ohtu.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;



description 'user can list all added articles in BibTex format in a textfield'

scenario "Page that lists all references in bibtex format includes a text field for the references", {
    given 'command list all in bibtex format is selected', {
         driver = new HtmlUnitDriver();
         driver.get("http://localhost:8736");
         element = driver.findElement(By.id("bib"));
         element.click();
    }
    when 'the page has loaded', {

    }
    then 'there is a textfield on the page', {
         driver.getPageSource().contains("textarea").shouldBe true
    }
}
 
scenario "after adding an article to database it is shown in the list in BibTex Format", {
    given 'an article has been added to database', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8736");
        element = driver.findElement(By.id("what-to-add"));
        element.click();
        element = driver.findElement(By.id("addA"));
        element.click();
        element = driver.findElement(By.name("author"));
        element.sendKeys("Testaaja, Heikki");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Hieno Juttu");
        element = driver.findElement(By.name("send"));
        element.submit();
    }
    when 'command list all in BibTex format is selected', {
        driver.get("http://localhost:8736");
        element = driver.findElement(By.id("bib"));
        element.click();
    }
    then 'title and articles in BibTex Format should be printed', {
        driver.getPageSource().contains("listaus BibTex").shouldBe true
    }
    and 'the added article is listed', {
        driver.getPageSource().contains("author = {Testaaja, Heikki}").shouldBe true
    }
    and 'the added article is listed inside a textfield', {
        driver.getPageSource().contains("<textarea rows=\"20\" cols=\"100\">@Article").shouldBe true
    }
}
 
