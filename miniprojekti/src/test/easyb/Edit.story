import ohtu.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


description 'User can edit an added reference'
 
scenario "when user edits author field of added article new information is saved", {
    given 'article has been added and command edit article has been given', {
      	driver = new HtmlUnitDriver();
        driver.get("http://localhost:10736");
        element = driver.findElement(By.id("normal"));
        element.click();
		element = driver.findElement(By.id("editbutton"));
        element.submit();
    }
    when 'new information for author field is given', {
		element = driver.findElement(By.name("author"));
        element.sendKeys("uusi, ulla");
		element = driver.findElement(By.name("send"));
		element.submit(); 
    }
    then 'old name can not be found', {
        driver.getPageSource().contains("Alussa, Arto").shouldBe false
    }

    and 'new name is shown in the list', {
		driver.getPageSource().contains("listaus").shouldBe true
		//driver.getPageSource().contains("uusi").shouldBe true
    }

}


 
