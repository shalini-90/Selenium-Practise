package com.shalini.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Enumeration;
import java.util.Properties;

public class BaseTest
{
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/Global.properties");
        prop.load(fis);
        /*while(prop.keys().hasMoreElements())
        {
            System.out.println(prop.keys().nextElement());
        }*/
        String browserName = prop.getProperty("browser");
        System.out.println("BrowserName => "+ browserName);
        if(browserName.equalsIgnoreCase("chrome")) {
            System.out.println("init chrome driver");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox"))
        {
            System.out.println("init firefox driver");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge"))
        {
            System.out.println("init edge driver");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        if(driver !=null)
        {
            driver.quit();
        }
    }


}
