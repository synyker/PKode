import ohtu.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;



description 'user search references with the name of the author'
 
scenario "user can search for references with a certain authors name", {
    given 'an article has been added to database', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
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
    when 'article is added successfully we can search for it with the name of its author' {
        element = driver.findElement(By.id("search"));
        element.sendKeys("Testaaja, Kalle");
        element = driver.findElement(By.name("send"));
        element.submit();
}
    then 'we will see all the articles with the authors name on it' {
        driver.getPageSource().contains("Testaaja, Kalle").shouldBe true
}

scenario "user can search for references with a certain author's name and it wont return other authors articles" {
given 'an article has been added to database', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.id("what-to-add"));
        element.click();
        element = driver.findElement(By.id("addA"));
        element.click();
        element = driver.findElement(By.name("author"));
        element.sendKeys("Kirjoittaja, Pekka");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Kiva Homma");
        element = driver.findElement(By.name("send"));
        element.submit();
    }
    when 'we search an article with another name' {
        element = driver.findElement(By.id("search"));
        element.sendKeys("Skriivaaja, Saku");
        element = driver.findElement(By.name("send"));
        element.submit();
}
 then 'we wont see any articles' {
        driver.getPageSource().contains("Kirjoittaja, Pekka").shouldBe false
}
}
}
 
