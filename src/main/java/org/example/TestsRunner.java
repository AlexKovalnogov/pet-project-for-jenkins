package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
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
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--dev-shm-usage");
            try{
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            }

            catch (Exception e){
                System.out.printf("Issue "+ e );
            }
            DriverHolder.availableDrivers.add(driver);
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(AppConfig.MAIN_URL);
        Allure.step("Website is opened");
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @AfterClass
    public void afterClass() {

    }

    public WebDriver getDriver(){
        return driver;
    }
}
