package uk.co.taidev.springshopping.guitests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@RunWith(SerenityRunner.class)
public class GuiIntegrationTests {

    @Managed
    WebDriver driver;

    @Test
    public void shouldInstantiateAWebDriverInstanceForAWebTest() {
        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys("firefly", Keys.ENTER);

        new WebDriverWait(driver,5).until(titleContains("Google Search"));

        assertThat(driver.getTitle(), is("firefly - Google Search"));
    }
}
