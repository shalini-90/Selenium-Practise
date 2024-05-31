package com.shalini.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchCatalogue extends Abstract
{
    WebDriver driver;
    public SearchCatalogue(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[text()=\"SAMSUNG\"]")
            WebElement checkboxBrand;
    @FindBy(css = "img[height='21']:nth-child(1)")
    WebElement checkboxFAssured;
    @FindBy(xpath = "//div[contains(text(),'High to Low')]")
    WebElement sort;

    public SearchCatalogue selectCheckbox() throws InterruptedException {
        waitForElementToBeClickable(checkboxBrand);
        Thread.sleep(3000);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",checkboxFAssured);
        return this;
    }

    public SearchResults sortPrice()
    {

        waitForElementToBeClickable(sort);
        SearchResults results=new SearchResults(driver);
        return results;
    }

}
