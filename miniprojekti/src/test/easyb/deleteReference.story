import ohtu.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can delete an article properly'
 
scenario "when user adds an article it is saved to the database", {
    given 'command add article selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:10736");
        element = driver.findElement(By.id("what-to-add"));
        element.click();
        element = driver.findElement(By.id("addA"));
        element.click();
    }
    when 'information for the article to be added is entered', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("TestiKirjoittaja, Kalle");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Testinimi");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Testinimi");
        element = driver.findElement(By.name("year"));
        element.sendKeys("1987");
        element = driver.findElement(By.name("send"));
        element.submit();
    }
    then 'clicking on the delete button clears the reference from the database', {
        element = driver.findElement(By.name("delete"));
        element.submit();
    }

    and 'the database is free of the just added entry', {
        driver.getPageSource().contains("TestiKirjoittaja, Kalle").shouldBe false
    }

}