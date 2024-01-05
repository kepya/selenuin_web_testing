package com.selenium.test.projets.cimencam;

import com.selenium.test.junit.rules.ScreenShotOnFailRule;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by KEPYA Christian on 28.11.23.
 * Uses JUnit test framework
 * Class for testing login feature (client and admin login)
 */
public class LoginFeatureTest {
    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }

    /**
     * Created on 28.11.23.
     * Uses JUnit test framework
     * Method for admin login testing. This test should pass without any problems
     */
    @Test
    public void adminLoginSuccessfully() {
        try {
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

            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
            By elementLocator = By.className("menubar-container");

            boolean isLogin = false;
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
                System.out.println("Element exists");
                isLogin = true;
            } catch (TimeoutException e) {
                System.out.println("Element does not exist");
                isLogin = false;
            }

            Assert.assertTrue(isLogin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Created on 28.11.23.
     * Uses JUnit test framework
     * Method for client login testing. This test should pass without any problems
     */
    @Test
    public void clientCompanyLoginSuccessfully() {
        try {
            //open browser to link https://mcm-test.londo-tech.com/
            WebDriverFactory.getDriver().get("https://mcm-test.londo-tech.com/");

            //get login btn element by classname
            WebElement button = WebDriverFactory.getDriver().findElement(By.className("login-btn"));
            button.click();

            //get email input element by xpath
            WebElement emailInput = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/div/div[1]/div/input"));
            emailInput.sendKeys("soceprob111@gmail.com");

            //get password input element by xpat
            WebElement passwordInput = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/div/div[2]/div/input"));
            passwordInput.sendKeys("SOCEPROB");

            //get login btn element by classname
            WebElement LoginBtn = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/footer/button[1]"));
            LoginBtn.click();

            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
            By elementLocator = By.className("menubar-container");

            boolean isLogin = false;
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
                System.out.println("Element exists");
                isLogin = true;
            } catch (TimeoutException e) {
                System.out.println("Element does not exist");
                isLogin = false;
            }

            Assert.assertTrue(isLogin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Created by KEPYA Christian on 28.11.23.
     * Uses JUnit test framework
     * Method for admin login testing. This test should fail. This method with code on this purpose.
     */
    @Test
    public void adminLoginFailed() {
        try {
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
            passwordInput.sendKeys("TlpH9tk");

            //get login btn element by classname
            WebElement LoginBtn = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/footer/button[1]"));
            LoginBtn.click();

            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
            By elementLocator = By.className("menubar-container");

            boolean isLogin = false;
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
                System.out.println("Element exists");
                isLogin = true;
            } catch (TimeoutException e) {
                System.out.println("Element does not exist");
                isLogin = false;
            }

            Assert.assertFalse(isLogin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Created by KEPYA Christian on 28.11.23.
     * Uses JUnit test framework
     * Method for client login testing. This test should fail. This method with code on this purpose.
     */
    @Test
    public void clientCompanyLoginFailed() {
        try {
            //open browser to link https://mcm-test.londo-tech.com/
            WebDriverFactory.getDriver().get("https://mcm-test.londo-tech.com/");

            //get login btn element by classname
            WebElement button = WebDriverFactory.getDriver().findElement(By.className("login-btn"));
            button.click();

            //get email input element by xpath
            WebElement emailInput = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/div/div[1]/div/input"));
            emailInput.sendKeys("soceprob111@gmail.com");

            //get password input element by xpat
            WebElement passwordInput = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/div/div[2]/div/input"));
            passwordInput.sendKeys("SOCEPROB1");

            //get login btn element by classname
            WebElement LoginBtn = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div/div/div/div/div/nb-layout-column/mcw-home/div/section[1]/div/div[1]/footer/button[1]"));
            LoginBtn.click();

            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
            By elementLocator = By.className("menubar-container");

            boolean isLogin = false;
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
                System.out.println("Element exists");
                isLogin = true;
            } catch (TimeoutException e) {
                System.out.println("Element does not exist");
                isLogin = false;
            }

            Assert.assertFalse(isLogin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void afterTest() {
        WebDriverFactory.takeScreenShot();
        WebDriverFactory.finishBrowser();
    }
}
