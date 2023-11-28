package com.selenium.test.projets.cimencam;

import com.selenium.test.junit.rules.ScreenShotOnFailRule;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

/**
 * Created by KEPYA Christian on 28.11.23.
 * Uses JUnit test framework
 * Test demonstrates simple webdriver functions : how to start browser, open url, insert some text and check that this text was inserted
 */
public class AdministrationTestFeatures {
    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }

    @Test
    public void login() {
        //open browser to link https://mcm-test.londo-tech.com/
        WebDriverFactory.getDriver().get("https://mcm-test.londo-tech.com/");

        //get login btn element by classname
        WebElement button = WebDriverFactory.getDriver().findElement(By.className("login-btn"));
        button.click();

        //get email input element by xpath
        WebElement emailInput = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/div/div[1]/div/input"));
        emailInput.sendKeys("admin@mycimencam.com");

        //get password input element by xpat
        WebElement passwordInput = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/div/div[2]/div/input"));
        passwordInput.sendKeys("TlpH9t");

        //get login btn element by classname
        WebElement LoginBtn = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/footer/button[1]"));
        LoginBtn.click();
    }

    @Test
    public void testFillGoogleForm() {
        WebDriverFactory.getDriver().get("https://mcm-test.londo-tech.com/");

    }

}
