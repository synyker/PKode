import ohtu.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


description 'User can add an article'
 
scenario "when user adds an article it is saved to the database", {
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
    then 'all articles in readable format are shown', {
        driver.getPageSource().contains("listaus ymmärrettävässä muodossa").shouldBe true
    }

    and 'article just added is shown in the list', {
        driver.getPageSource().contains("TestiKirjoittaja").shouldBe true
    }

}


 
