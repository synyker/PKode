import ohtu.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


description 'User can edit an added reference'
 
scenario "when user edits author field of added article new information is saved", {
    given 'article has been added and command edit article has been given', {
      	driver = new HtmlUnitDriver();
        driver.get("http://localhost:8736");
        element = driver.findElement(By.id("what-to-add"));
        element.click();
        element = driver.findElement(By.id("addA"));
        element.click();
        element = driver.findElement(By.name("author"));
        element.sendKeys("Alussa, Arto");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Testinimi");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Testinimi");
        element = driver.findElement(By.name("year"));
        element.sendKeys("1987");
        element = driver.findElement(By.name("send"));
        element.submit();
		element = driver.findElement(By.name("edit"));
        element.submit();
    }
    when 'new information for author field is given', {
		element = driver.findElement(By.name("author"));
        element.sendKeys("Uusi, Ulla");
		element.submit(); 
    }
    then 'old name can not be found', {
        driver.getPageSource().contains("Alussa, Arto").shouldBe false
    }

    and 'new name is shown in the list', {
        driver.getPageSource().contains("Uusi, Ulla").shouldBe true
    }

}


 
