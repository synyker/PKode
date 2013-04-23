import ohtu.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;



description 'user can list all added articles in BibTex format and all lines except the title and ending have 4 whitespaces in front of them'

 
scenario "When references are listed in textarea there are 4 whitespaces in  front of each line", {
    given 'an article has been added to database', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8736");
        element = driver.findElement(By.id("what-to-add"));
        element.click();
        element = driver.findElement(By.id("addA"));
        element.click();
        element = driver.findElement(By.name("author"));
        element.sendKeys("Testaaja, Kalle");
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
    and 'there are 4 whitespaces in front of the author field', {
        driver.getPageSource().contains("    author = {Testaaja, Kalle}").shouldBe true
    }
    and 'the added article is listed inside a textfield', {
        driver.getPageSource().contains(">@Article").shouldBe true
    }
}
 
