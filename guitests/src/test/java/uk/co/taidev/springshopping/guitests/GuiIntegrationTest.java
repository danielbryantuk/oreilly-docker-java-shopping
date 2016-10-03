package uk.co.taidev.springshopping.guitests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

﻿

@RunWith(SerenityRunner.class)
public class GuiIntegrationTest {

    private static final String SUT_BASE_URI = "http://localhost:8010";

    @Managed
    WebDriver driver;

    @Test
    public void productOneHasCorrectPrice() {
        driver.get(SUT_BASE_URI);

        WebElement tableEl =
                driver.findElement(By.id("product-table"));
        WebElement productOnePriceEl = tableEl.findElement(By.xpath("tbody/tr/td[5]"));

        assertThat(productOnePriceEl.getText(), is("1.20"));
    }
}
