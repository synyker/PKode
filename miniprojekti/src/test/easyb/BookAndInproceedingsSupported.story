import ohtu.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;



description 'user can also add books and inproceedings, and these are shown when listing references in either BibTex or readable format'
 
scenario "when user adds a book it is saved to the database", {
    given 'command add book selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:10375");
        element = driver.findElement(By.id("what-to-add"));
        element.click();
        element = driver.findElement(By.id("addB"));
        element.click();
}
    when 'information for the book to be added is entered', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("TestiKirjoittaja, Heikki");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Testinimi");
        element = driver.findElement(By.name("booktitle"));
        element.sendKeys("Testikirjatitle");
        element = driver.findElement(By.name("year"));
        element.sendKeys("1999");
        element = driver.findElement(By.name("send"));
        element.submit();
}
    then 'all books in readable format are shown', {
        driver.getPageSource().contains("listaus ymmärrettävässä muodossa").shouldBe true
    }

    and 'book just added is shown in the list', {
        driver.getPageSource().contains("TestiKirjoittaja, Heikki").shouldBe true
    }
}

scenario "when user adds inproceedings they are saved to the database", {
    given 'command add inproceedings selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:10375");
        element = driver.findElement(By.id("what-to-add"));
        element.click();
        element = driver.findElement(By.id("addI"));
        element.click();
}
    when 'information for the inproceedings to be added is entered', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("TestiKirjoittaja, Ville");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Testinimi");
        element = driver.findElement(By.name("series"));
        element.sendKeys("testiseries");
        element = driver.findElement(By.name("edition"));
        element.sendKeys("testiedition");
        element = driver.findElement(By.name("send"));
        element.submit();
}
    then 'all inproceedings in readable format are shown', {
        driver.getPageSource().contains("listaus ymmärrettävässä muodossa").shouldBe true
    }

    and 'inproceedings just added is shown in the list', {
        driver.getPageSource().contains("TestiKirjoittaja, Ville").shouldBe true
    }
}
