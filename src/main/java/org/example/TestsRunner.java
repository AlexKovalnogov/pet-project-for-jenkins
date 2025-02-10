package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.configInitialization.AppConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class TestsRunner {
    public WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        new AppConfig();


    }

    @BeforeClass
    public void beforeClass() {
        if (AppConfig.BROWSER.equals("chrome")) ;
        {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--dev-shm-usage");
            try{
                driver = new ChromeDriver(chromeOptions);}
            catch (Exception e){
                System.out.printf("Issue "+ e );
            }
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(AppConfig.MAIN_URL);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @AfterClass
    public void afterClass() {

    }
}
