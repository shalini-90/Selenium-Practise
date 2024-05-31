package com.shalini.test;

import com.shalini.pageobject.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;
import java.util.List;


public class PractiseTest_copy {
    @Test
    public void test() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //HomePage homePage = new HomePage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        driver.findElement(By.name("q")).sendKeys("Samsung Galaxy S10", Keys.ENTER);

        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("//*[text()=\"SAMSUNG\"]"))));
        checkbox.click();
        //takeSnapShot(driver, "/Users/venky.webhook/Documents/Resume/Shalini Kalyanam/Shalini Java Practise/Shalini Java Practise/SeleniumJava/src/test/resources/Screenshots/samsung.jpeg");
        Thread.sleep(3000);
        WebElement checkbox2 = driver.findElement(By.cssSelector("img[height='21']:nth-child(1)"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",checkbox2);
        WebElement sort = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("//div[contains(text(),'High to Low')]"))));
        sort.click();
        Boolean stale = wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.
                        cssSelector("div[class*='-7-12']>div:nth-child(1)"))));
        List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.
                cssSelector("div[class*='-7-12']>div:nth-child(1)")));
        List<WebElement> productsPrice = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.
                cssSelector(".hl05eU>div:nth-child(1)"))));
        List<WebElement> productLinks =wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.
                        cssSelector("a[href*='/samsung']"))));

        String[][] result=new String[24][3];
        for(int i=0; i< products.size(); i++)
        {
            result[i][0]=products.get(i).getText();
            result[i][1]=productsPrice.get(i).getText();
            result[i][2]=productLinks.get(i).getAttribute("href");
        }

        for(String[] arr: result)
        {
            System.out.println("Item => "+ arr[0]);
            System.out.println("Price => "+ arr[1]);
            System.out.println("Link => " +arr[2]);
        }
        Thread.sleep(7000);
        driver.quit();
    }

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
//Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
        File DestFile=new File(fileWithPath);
//Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }

    //public void Asserts() {
        //SoftAssert softAssert= new SoftAssert();


    }



