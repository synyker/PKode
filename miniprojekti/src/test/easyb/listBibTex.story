import ohtu.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;



description 'user can list all added articles in BibTex format'
 
scenario "user can list all added articles in BibTexFormat when no articles in the database", {
    given 'command list all in BibTex format is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.id("bib"));       
        element.click(); 
    }
    when 'page is loaded', {

    }
    then 'title of the page should be printed', {
        driver.getPageSource().contains("listaus BibTex").shouldBe true
    }
    and 'no articles are listed', {
        driver.getPageSource().contains("@Article{").shouldBe false
    }
}

scenario "user can list all added articles in BibTexFormat after adding an article to database", {
    given 'an article has been added to database', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.id("add"));
        element.click();
        element = driver.findElement(By.name("author"));
        element.sendKeys("Testaaja, Kalle");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Hieno Juttu");
        element = driver.findElement(By.name("send"));
        element.submit();
        element = driver.findElement(By.id("back"));
        element.click();

    }
    when 'command list all in BibTex format is selected', {
        element = driver.findElement(By.id("bib"));
        element.click();
    }
    then 'title and articles in BibTex Format should be printed', {
        driver.getPageSource().contains("listaus BibTex").shouldBe true
    }
    and 'the added article is listed', {
        driver.getPageSource().contains("author = {Testaaja, Kalle}").shouldBe true
    }
}
 
