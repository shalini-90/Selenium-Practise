package com.shalini.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Abstract {

    WebDriver driver;
    WebDriverWait wait;
    public Abstract(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("driver isnside of Abstract => "+driver);
    }

    public void goTo()
    {
        driver.get("https://www.flipkart.com/");
    }
    public void waitForElementVisibility(By name)
    {
        System.out.println("By name:"+name.toString());
        System.out.println("driver => "+driver);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(name));
    }

    public void waitForElementToBeClickable(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void sleep() throws InterruptedException {
        Thread.sleep(3000);
    }
}
