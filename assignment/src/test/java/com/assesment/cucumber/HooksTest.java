package com.assesment.cucumber;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


public class HooksTest {

    public static WebDriver driver;


    @Before
    public void openbrowser() {
        FirefoxProfile fp = new FirefoxProfile();
        fp.setPreference("browser.startup.homepage", "about:blank");
        fp.setPreference("startup.homepage_welcome_url", "about:blank");
        fp.setPreference("startup.homepage_welcome_url.additional", "about:blank");
        driver = new FirefoxDriver(fp);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @After
    public void closebrowser() {
        driver.close();

    }
}