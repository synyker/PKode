import ohtu.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;



description 'user can download a file with a selected name containing all references'

scenario "user downloads file and gives the file a name", {
    given 'an article has been added to database', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:10736");
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
    when 'command list all in bibtex format is selected', {
        driver.get("http://localhost:10736");
        element = driver.findElement(By.id("bib"));
        element.click();
        element = driver.findElement(By.id("filename"));
        element.sendKeys("integration-test");
        element = driver.findElement(By.id("download"));
        element.click();
    }
    then 'file should contain references', {
        driver.getPageSource().contains("@Article").shouldBe true
    }

    and 'current url should contain the filename', {
        driver.getCurrentUrl().contains("integration-test").shouldBe true
    }
}
 
