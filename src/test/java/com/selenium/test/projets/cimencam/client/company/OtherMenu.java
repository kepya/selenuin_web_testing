package com.selenium.test.projets.cimencam.client.company;

import com.selenium.test.junit.rules.ScreenShotOnFailRule;
import com.selenium.test.utils.TimeUtils;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.fail;

public class OtherMenu {
    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }

    @After
    public void afterTest() {
//        WebDriverFactory.takeScreenShot();
//        TimeUtils.waitForSeconds(2);
//        WebDriverFactory.finishBrowser();
    }

    @Test
    public void bankStatementWithSendBtn() {
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 30);

            /***** Login Proces ****/
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

            TimeUtils.waitForSeconds(1);
            By elementLocator = By.className("menubar-container");

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
            } catch (TimeoutException e) {
                fail("Login failed");
            }

            /***** Order List Proces ****/
            TimeUtils.waitForSeconds(1);
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
                WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
                if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                    orderMenu.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }
            TimeUtils.waitForSeconds(1);

            By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[1]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderListFirstOptionLocator));
                WebElement orderListFirstOption1 = WebDriverFactory.getDriver().findElement(orderListFirstOptionLocator);
                if (orderListFirstOption1.isEnabled() && orderListFirstOption1.isDisplayed()) {
                    orderListFirstOption1.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }

            // Find the withdrawal date field element
            By withdrawalInputLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-age-balance-form/div/nb-card/nb-card-body/div/div[1]/input");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(withdrawalInputLocator));
                WebElement withdrawalInput = WebDriverFactory.getDriver().findElement(withdrawalInputLocator);
                if (withdrawalInput.isDisplayed() && withdrawalInput.isEnabled()) {
                    withdrawalInput.click();

                    By withdrawalCalendarLocator = By.className("today");
                    try {
                        wait.until(ExpectedConditions.presenceOfElementLocated(withdrawalCalendarLocator));
                        WebElement withdrawalCalendar = WebDriverFactory.getDriver().findElement(withdrawalCalendarLocator);
                        if (withdrawalCalendar.isDisplayed() && withdrawalCalendar.isEnabled()) {
                            JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                            executor.executeScript("arguments[0].click();", withdrawalCalendar);
                        }
                    } catch (TimeoutException e) {
                        fail("withdrawal calendar does not showing so we got a problem");
                    }
                }

                // Find the withdrawal date field element
                By withdrawalInputEndDateLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-age-balance-form/div/nb-card/nb-card-body/div/div[2]/input");
                try {
                    wait.until(ExpectedConditions.presenceOfElementLocated(withdrawalInputEndDateLocator));
                    WebElement withdrawalInputEndDate = WebDriverFactory.getDriver().findElement(withdrawalInputEndDateLocator);
                    if (withdrawalInputEndDate.isDisplayed() && withdrawalInputEndDate.isEnabled()) {
                        withdrawalInputEndDate.click();

                        By withdrawalCalendarLocator = By.className("today");
                        try {
                            wait.until(ExpectedConditions.presenceOfElementLocated(withdrawalCalendarLocator));
                            WebElement withdrawalCalendar = WebDriverFactory.getDriver().findElement(withdrawalCalendarLocator);
                            if (withdrawalCalendar.isDisplayed() && withdrawalCalendar.isEnabled()) {
                                JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                                executor.executeScript("arguments[0].click();", withdrawalCalendar);
                            }
                        } catch (TimeoutException e) {
                            fail("withdrawal calendar does not showing so we got a problem");
                        }
                    }
                } catch (TimeoutException e) {
                    fail("withdrawal input does not exist so we got a problem");
                }

            } catch (Exception e) {
                fail("We cannot view schedule");
            }

            //get login btn element by classname
            By sendButtonLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-age-balance-form/div/nb-card/nb-card-footer/button[1]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(sendButtonLocator));
                WebElement sendButton = WebDriverFactory.getDriver().findElement(sendButtonLocator);
                if (sendButton.isEnabled() && sendButton.isDisplayed()) {
                    sendButton.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }

            TimeUtils.waitForSeconds(1);
            // view detail of order
            By elementListOrderLocator = By.className("list-elt");
            List<WebElement> elementOrderLists = WebDriverFactory.getDriver().findElements(elementListOrderLocator);
            if (elementOrderLists.size() > 1) {
                // so add 1 to make it inclusive
                int randomNum = ThreadLocalRandom.current().nextInt(0, elementOrderLists.size() + 1);
                WebElement webElement = elementOrderLists.get(randomNum);
                List<WebElement> btnOrderLists = webElement.findElements(By.className("order-list-btn"));
                TimeUtils.waitForSeconds(1);
                btnOrderLists.get(0).click();
            } else {
                WebElement webElement = elementOrderLists.get(0);
                List<WebElement> btnOrderLists = webElement.findElements(By.className("order-list-btn"));
                TimeUtils.waitForSeconds(1);
                btnOrderLists.get(0).click();
            }
        } catch (Exception e) {
            fail("We cannot view schedule");
        }
    }

    @Test
    public void bankStatementWithCancelBtn() {
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 30);

            /***** Login Proces ****/
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

            TimeUtils.waitForSeconds(1);
            By elementLocator = By.className("menubar-container");

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
            } catch (TimeoutException e) {
                fail("Login failed");
            }

            /***** Order List Proces ****/
            TimeUtils.waitForSeconds(1);
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
                WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
                if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                    orderMenu.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }
            TimeUtils.waitForSeconds(1);

            By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[1]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderListFirstOptionLocator));
                WebElement orderListFirstOption1 = WebDriverFactory.getDriver().findElement(orderListFirstOptionLocator);
                if (orderListFirstOption1.isEnabled() && orderListFirstOption1.isDisplayed()) {
                    orderListFirstOption1.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }

            // Find the withdrawal date field element
            By withdrawalInputLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-age-balance-form/div/nb-card/nb-card-body/div/div[1]/input");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(withdrawalInputLocator));
                WebElement withdrawalInput = WebDriverFactory.getDriver().findElement(withdrawalInputLocator);
                if (withdrawalInput.isDisplayed() && withdrawalInput.isEnabled()) {
                    withdrawalInput.click();

                    By withdrawalCalendarLocator = By.className("today");
                    try {
                        wait.until(ExpectedConditions.presenceOfElementLocated(withdrawalCalendarLocator));
                        WebElement withdrawalCalendar = WebDriverFactory.getDriver().findElement(withdrawalCalendarLocator);
                        if (withdrawalCalendar.isDisplayed() && withdrawalCalendar.isEnabled()) {
                            JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                            executor.executeScript("arguments[0].click();", withdrawalCalendar);
                        }
                    } catch (TimeoutException e) {
                        fail("withdrawal calendar does not showing so we got a problem");
                    }
                }

                // Find the withdrawal date field element
                By withdrawalInputEndDateLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-age-balance-form/div/nb-card/nb-card-body/div/div[2]/input");
                try {
                    wait.until(ExpectedConditions.presenceOfElementLocated(withdrawalInputEndDateLocator));
                    WebElement withdrawalInputEndDate = WebDriverFactory.getDriver().findElement(withdrawalInputEndDateLocator);
                    if (withdrawalInputEndDate.isDisplayed() && withdrawalInputEndDate.isEnabled()) {
                        withdrawalInputEndDate.click();

                        By withdrawalCalendarLocator = By.className("today");
                        try {
                            wait.until(ExpectedConditions.presenceOfElementLocated(withdrawalCalendarLocator));
                            WebElement withdrawalCalendar = WebDriverFactory.getDriver().findElement(withdrawalCalendarLocator);
                            if (withdrawalCalendar.isDisplayed() && withdrawalCalendar.isEnabled()) {
                                JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                                executor.executeScript("arguments[0].click();", withdrawalCalendar);
                            }
                        } catch (TimeoutException e) {
                            fail("withdrawal calendar does not showing so we got a problem");
                        }
                    }
                } catch (TimeoutException e) {
                    fail("withdrawal input does not exist so we got a problem");
                }

            } catch (Exception e) {
                fail("We cannot view schedule");
            }

            //get login btn element by classname
            By cancelButtonLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-age-balance-form/div/nb-card/nb-card-footer/button[2]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(cancelButtonLocator));
                WebElement cancelButton = WebDriverFactory.getDriver().findElement(cancelButtonLocator);
                if (cancelButton.isEnabled() && cancelButton.isDisplayed()) {
                    cancelButton.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }

        } catch (Exception e) {
            fail("We cannot view schedule");
        }
    }

    @Test
    public void showAccountValue() {
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 30);

            /***** Login Proces ****/
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

            TimeUtils.waitForSeconds(1);
            By elementLocator = By.className("menubar-container");

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
            } catch (TimeoutException e) {
                fail("Login failed");
            }

            /***** Order List Proces ****/
            TimeUtils.waitForSeconds(1);
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
                WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
                if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                    orderMenu.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }
            TimeUtils.waitForSeconds(1);

            By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[2]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderListFirstOptionLocator));
                WebElement orderListFirstOption1 = WebDriverFactory.getDriver().findElement(orderListFirstOptionLocator);
                if (orderListFirstOption1.isEnabled() && orderListFirstOption1.isDisplayed()) {
                    orderListFirstOption1.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }
            TimeUtils.waitForSeconds(2);

            //get login btn element by classname
            By cancelButtonLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-balance-account/div/nb-card/nb-card-footer/button");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(cancelButtonLocator));
                WebElement cancelButton = WebDriverFactory.getDriver().findElement(cancelButtonLocator);
                if (cancelButton.isEnabled() && cancelButton.isDisplayed()) {
                    cancelButton.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }

        } catch (Exception e) {
            fail("We cannot view schedule");
        }
    }

    @Test
    public void aeNotChargedWithCancelButton() {
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 30);

            /***** Login Proces ****/
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

            TimeUtils.waitForSeconds(1);
            By elementLocator = By.className("menubar-container");

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
            } catch (TimeoutException e) {
                fail("Login failed");
            }

            /***** Order List Proces ****/
            TimeUtils.waitForSeconds(1);
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
                WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
                if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                    orderMenu.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }
            TimeUtils.waitForSeconds(1);

            By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[3]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderListFirstOptionLocator));
                WebElement orderListFirstOption1 = WebDriverFactory.getDriver().findElement(orderListFirstOptionLocator);
                if (orderListFirstOption1.isEnabled() && orderListFirstOption1.isDisplayed()) {
                    orderListFirstOption1.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }
            TimeUtils.waitForSeconds(1);

            //get login btn element by classname
            By cancelButtonLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-ae-not-charged/div/nb-card/nb-card-footer/button[2]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(cancelButtonLocator));
                WebElement cancelButton = WebDriverFactory.getDriver().findElement(cancelButtonLocator);
                if (cancelButton.isEnabled() && cancelButton.isDisplayed()) {
                    cancelButton.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }

            TimeUtils.waitForSeconds(3);
            // view detail of order
            By elementListOrderLocator = By.className("list-elt");
            List<WebElement> elementOrderLists = WebDriverFactory.getDriver().findElements(elementListOrderLocator);
            if (elementOrderLists.size() > 1) {
                // so add 1 to make it inclusive
                int randomNum = ThreadLocalRandom.current().nextInt(0, elementOrderLists.size() + 1);
                WebElement webElement = elementOrderLists.get(randomNum);
                List<WebElement> btnOrderLists = webElement.findElements(By.className("order-list-btn"));
                TimeUtils.waitForSeconds(1);
                btnOrderLists.get(0).click();
            } else {
                WebElement webElement = elementOrderLists.get(0);
                List<WebElement> btnOrderLists = webElement.findElements(By.className("order-list-btn"));
                TimeUtils.waitForSeconds(1);
                btnOrderLists.get(0).click();
            }
        } catch (Exception e) {
            fail("We cannot view schedule");
        }
    }


    @Test
    public void aeNotChargedWithSendButton() {
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 30);

            /***** Login Proces ****/
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

            TimeUtils.waitForSeconds(1);
            By elementLocator = By.className("menubar-container");

            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
            } catch (TimeoutException e) {
                fail("Login failed");
            }

            /***** Order List Proces ****/
            TimeUtils.waitForSeconds(1);
            By orderMenuLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/nb-layout-header/nav/mcw-menu-bar/div/button[3]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderMenuLocator));
                WebElement orderMenu = WebDriverFactory.getDriver().findElement(orderMenuLocator);
                if (orderMenu.isEnabled() && orderMenu.isDisplayed()) {
                    orderMenu.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }
            TimeUtils.waitForSeconds(1);

            By orderListFirstOptionLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div/div/nb-popover/nb-overlay-container/nb-card/nb-list/nb-list-item[3]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(orderListFirstOptionLocator));
                WebElement orderListFirstOption1 = WebDriverFactory.getDriver().findElement(orderListFirstOptionLocator);
                if (orderListFirstOption1.isEnabled() && orderListFirstOption1.isDisplayed()) {
                    orderListFirstOption1.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }
            TimeUtils.waitForSeconds(2);

            //get login btn element by classname
            By sendButtonLocator = By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-ae-not-charged/div/nb-card/nb-card-footer/button[1]");
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(sendButtonLocator));
                WebElement sendButton = WebDriverFactory.getDriver().findElement(sendButtonLocator);
                if (sendButton.isEnabled() && sendButton.isDisplayed()) {
                    sendButton.click();
                }
            } catch (TimeoutException e) {
                fail("You are not log in, please login");
            }

        } catch (Exception e) {
            fail("We cannot view schedule");
        }
    }

}
