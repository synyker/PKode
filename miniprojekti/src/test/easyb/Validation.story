import ohtu.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


description 'Information that user gives is validated before reference is added to the database'
 
scenario "when user adds an article with no author it is not saved to the database", {
    given 'command add article selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:10736");
        element = driver.findElement(By.id("what-to-add"));
        element.click();
        element = driver.findElement(By.id("addA"));
        element.click();
    }
    when 'information for the article to be added is entered', {
        element = driver.findElement(By.name("title"));
        element.sendKeys("EiKirjoittajaa");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Testinimi");
        element = driver.findElement(By.name("year"));
        element.sendKeys("1987");
        element = driver.findElement(By.name("send"));
        element.submit();
    }

    then 'article just added is not shown in the list', {
        driver.getPageSource().contains("EiKirjoittajaa").shouldBe false
    }

	and 'correct error message is shown', {
		driver.getPageSource().contains("Author kenttä ei saa olla tyhjä.").shouldBe true
	}
}

scenario "when user adds an article with author in wrong format it is not saved to the database", {
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
        element.sendKeys("Yksinimi");
        element = driver.findElement(By.name("title"));
        element.sendKeys("HuonoAuthor");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Testinimi");
        element = driver.findElement(By.name("year"));
        element.sendKeys("1987");
        element = driver.findElement(By.name("send"));
        element.submit();
    }

    then 'article just added is not shown in the list', {
        driver.getPageSource().contains("Yksinimi").shouldBe false
    }

	and 'correct error message is shown', {
		driver.getPageSource().contains("Author kenttä on oltava muodossa Sukunimi, Etunimi ; Sukunimi2, Etunimi. Erottele nimet pilkuilla ja kirjailijat puolipisteellä.").shouldBe true
	}
}

scenario "when user adds an article with no title it is not saved to the database", {
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
        element.sendKeys("Yksinimi, Hyvin");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Testinimi");
        element = driver.findElement(By.name("year"));
        element.sendKeys("1987");
        element = driver.findElement(By.name("send"));
        element.submit();
    }

    then 'article just added is not shown in the list', {
        driver.getPageSource().contains("Yksinimi, Hyvin").shouldBe false
    }

	and 'correct error message is shown', {
		driver.getPageSource().contains("Title kenttä ei saa olla tyhjä.").shouldBe true
	}
}

scenario "when user adds an article in correct format and a title it is saved to the database", {
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
        element.sendKeys("Nimi, Hyvin");
		element = driver.findElement(By.name("title"));
        element.sendKeys("Hyväotsikko");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Testinimi");
        element = driver.findElement(By.name("year"));
        element.sendKeys("1987");
        element = driver.findElement(By.name("send"));
        element.submit();
    }

    then 'article just added is shown in the list', {
        driver.getPageSource().contains("Nimi, Hyvin").shouldBe true
    }
}

scenario "when user adds an article with year that has less than 4 digitd it is not saved to the database", {
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
        element.sendKeys("Huonovuosi, Kalle");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Testinimi");
        element = driver.findElement(By.name("year"));
        element.sendKeys("19");
        element = driver.findElement(By.name("send"));
        element.submit();
    }

    then 'article just added is not shown in the list', {
        driver.getPageSource().contains("Huonovuosi, Kalle").shouldBe false
    }
	and 'correct error message is shown', {
		driver.getPageSource().contains("Year täytyy sisältää 4 numeroa.").shouldBe true
	}
}

scenario "when user adds an article with year that has other characters than 4 digitd it is not saved to the database", {
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
        element.sendKeys("Huonovuosi, Kalle");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Testinimi");
        element = driver.findElement(By.name("year"));
        element.sendKeys("19hi");
        element = driver.findElement(By.name("send"));
        element.submit();
    }

    then 'article just added is not shown in the list', {
        driver.getPageSource().contains("Huonovuosi, Kalle").shouldBe false
    }
	and 'correct error message is shown', {
		driver.getPageSource().contains("Year täytyy sisältää 4 numeroa.").shouldBe true
	}
}
 
