import ohtu.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;



description 'user can list all added articles in a readable form'
 
scenario "user can list all added articles in readable format", {
    given 'command list all selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:10375");
        element = driver.findElement(By.id("normal"));       
        element.click(); 
    }
    when 'page is loaded', {

    }
    then 'title of the page should be printed', {
        driver.getPageSource().contains("listaus ymmärrettävässä muodossa").shouldBe true
    }

    and 'there is at least one author field in the list', {
       driver.getPageSource().contains("Author:").shouldBe true 
    }

}