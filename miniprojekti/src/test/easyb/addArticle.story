import ohtu.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


description 'User can add an article'
 
scenario "user can add an article", {
    given 'command add article selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.id("add"));       
        element.click(); 
    }
    when 'information for the article to be added is entered', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("TestiKirjoittaja");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Testinimi");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Testinimi");
        element = driver.findElement(By.name("year"));
        element.sendKeys("Testilehti");
        element = driver.findElement(By.name("send"));
        element.submit();
    }
    then 'succes message is shown', {
        driver.getPageSource().contains("lisääminen onnistui!").shouldBe true
    }
}
 
