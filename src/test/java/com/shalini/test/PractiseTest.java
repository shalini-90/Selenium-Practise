package com.shalini.test;

import com.shalini.pageobject.HomePage;
import com.shalini.pageobject.SearchCatalogue;
import com.shalini.pageobject.SearchResults;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class PractiseTest extends BaseTest
{
    //WebDriver driver;

    @Test
    public void test() throws Exception {

        HomePage homePage = new HomePage(driver);
        homePage.goTo();
        String[][] result = homePage.enterSearch("Samsung Galaxy S10",By.name("q"))
                                    .selectCheckbox()
                                    .sortPrice()
                                    .getProductDetails();
        int[] price=new int[24];
        int i=0;
        for(String[] arr: result)
        {
            System.out.println("Item => "+ arr[0]);
            System.out.println("Price => "+ arr[1]);
            System.out.println("Link => " +arr[2]);
            //price[i++]= Integer.parseInt(arr[1]);
        }

        Assert.assertEquals(result.length, 24);
        //Assert.assertTrue(ArrayUtils.isSorted(price));
        Thread.sleep(7000);
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
}


