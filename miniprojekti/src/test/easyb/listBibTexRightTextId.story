import ohtu.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;



description 'A reference has a correct textId when listed in BibTex format'
 
scenario "Reference has correct textId when only one with same id added to database", {
    given 'article with id AB09 is added', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:20357");
        element = driver.findElement(By.id("what-to-add"));
        element.click();
        element = driver.findElement(By.id("addA"));
        element.click();
        element = driver.findElement(By.name("author"));
        element.sendKeys("Aapeli, Kalle; Baabeli, Nalle");
		element = driver.findElement(By.name("title"));
        element.sendKeys("otsikkopotsikko");
        element = driver.findElement(By.name("year"));
        element.sendKeys("2009");
        element = driver.findElement(By.name("send"));
        element.submit(); 
    }
    when 'command list all in BibTex format is selecte', {
        driver.get("http://localhost:20357");
        element = driver.findElement(By.id("bib"));       
        element.click(); 
    }
    then 'reference with textid AB09 is shown', {
        driver.getPageSource().contains("AB09").shouldBe true
    }
}

scenario "Reference has correct textid when another with same original id is added to database", {
    given 'another article with id AB09 has been added to the database', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:20357");
        element = driver.findElement(By.id("what-to-add"));
        element.click();
        element = driver.findElement(By.id("addA"));
        element.click();
        element = driver.findElement(By.name("author"));
        element.sendKeys("Aapeli, Kalle; Baabeli, Pekka");
		element = driver.findElement(By.name("title"));
        element.sendKeys("otsikkopotsikko");
        element = driver.findElement(By.name("year"));
        element.sendKeys("2009");
        element = driver.findElement(By.name("send"));
        element.submit(); 
    }
    when 'command list all in BibTex format is selected', {
        driver.get("http://localhost:20357");
        element = driver.findElement(By.id("bib"));
        element.click();
    }
    then 'reference with textId AB09a is shown', {
        driver.getPageSource().contains("AB09a").shouldBe true
    }
}
 
