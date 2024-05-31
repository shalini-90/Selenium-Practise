package com.shalini.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Abstract
{
    WebDriver driver;
    @FindBy(name = "q")
    WebElement search;


    public HomePage(WebDriver driver)
    {
        super(driver);
        //System.out.println("driver inside of HomePage => "+driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public SearchCatalogue enterSearch(String searchText, By nameSearch)
    {
        //System.out.println("driver inside of enterSearch => "+driver);
        waitForElementVisibility(nameSearch);
        search.sendKeys(searchText ,Keys.ENTER);
        SearchCatalogue searchCatalogue = new SearchCatalogue(driver);
        return searchCatalogue;

    }
    }


