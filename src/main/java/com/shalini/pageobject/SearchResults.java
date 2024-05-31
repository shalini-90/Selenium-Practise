package com.shalini.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResults extends Abstract {
    WebDriver driver;

    public SearchResults(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[class*='-7-12']>div:nth-child(1)")
    List<WebElement> products;
    @FindBy(css = ".hl05eU>div:nth-child(1)")
    List<WebElement> productsPrice;
    @FindBy(css = "a[href*='/samsung']")
    List<WebElement> productLinks;



    public String[][] getProductDetails() {
        String[][] result=new String[24][3];
        Boolean stale = wait.until(ExpectedConditions.stalenessOf(products.get(0)));
        List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.
                cssSelector("div[class*='-7-12']>div:nth-child(1)")));
        List<WebElement> productsPrice = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.
                cssSelector(".hl05eU>div:nth-child(1)"))));
        List<WebElement> productLinks = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.
                cssSelector("a[href*='/samsung']"))));

        for(int i=0; i< products.size(); i++)
        {
            result[i][0]=products.get(i).getText();
            result[i][1]=productsPrice.get(i).getText();
            result[i][2]=productLinks.get(i).getAttribute("href");
        }
        return result;
    }









}
