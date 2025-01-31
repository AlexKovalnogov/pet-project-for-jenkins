package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

public class TestsRunner {

    public WebDriver driver;
    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void beforeClass() {

    }

    @BeforeMethod
    public void beforeMethod() {

    }


    @AfterMethod
    public void afterMethod() {

    }

    @AfterClass
    public void afterClass() {

    }



}
