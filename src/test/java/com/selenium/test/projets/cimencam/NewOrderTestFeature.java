package com.selenium.test.projets.cimencam;

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

import static org.junit.Assert.fail;

/**
 * Created by KEPYA Christian on 30.11.23.
 * Uses JUnit test framework
 * Class for testing new order feature (client and admin login)
 */
public class NewOrderTestFeature {
    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }


    /**
     * Created by KEPYA Christian on 28.11.23.
     * Uses JUnit test framework
     * Method for client pickup testing.
     * Here we are testing the order process with pick up withdrawal
     * For that we started by login, after that we realized the order normally
     * Here we use Mtn for payment
     */
    @Test
    public void newPickUpOrderAndMtnPayment() throws InterruptedException {
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

        By elementLocator = By.className("menubar-container");

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        } catch (TimeoutException e) {
            fail("Login failed");
        }

        /***** Order Proces ****/
        boolean storeSelectInProgress = true;
        By newPurchaseBtnLocator = By.className("new-purchase-btn");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(newPurchaseBtnLocator));
            //get purchase btn element by classname
            WebElement newPurchaseBtn = WebDriverFactory.getDriver().findElement(By.className("new-purchase-btn"));
            newPurchaseBtn.click();
        } catch (TimeoutException e) {
            fail("Purchase btn does not exist so we didn't login already");
        }

        By storeSelectLocator = By.id("storeSelect");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(storeSelectLocator));
            // Find the select element
            WebElement storeSelect = WebDriverFactory.getDriver().findElement(storeSelectLocator);
            storeSelect.click();
        } catch (TimeoutException e) {
            fail("store select does not exist so we didn't login already");
        }

        By storeSelectOptionLocator = By.id("nb-option-0");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(storeSelectOptionLocator));
            // Find the select option element
            WebElement storeSelectOption = WebDriverFactory.getDriver().findElement(storeSelectOptionLocator);
            storeSelectOption.click();
            TimeUtils.waitForSeconds(4);
        } catch (TimeoutException e) {
            fail("store select option does not exist so we got a problem");
        }

        //get add article btn element by xpath
        By addArticleBtnLocator = By.className("add-elt-btn");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(addArticleBtnLocator));
            // Find the select option element
            WebElement addArticleBtn = WebDriverFactory.getDriver().findElement(addArticleBtnLocator);
            if (addArticleBtn.isDisplayed() && addArticleBtn.isEnabled()) {
                addArticleBtn.click();
            }
        } catch (TimeoutException e) {
            fail("article btn add does not exist so we got a problem");
        }

        // Show the list of product
        By productSelectLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-order-form/mcw-step-store-and-items/div/nb-card/nb-card-body/div[2]/ul/li[2]/div[2]/nb-select");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(productSelectLocator));
            // Find the select option element
            WebElement productSelect = WebDriverFactory.getDriver().findElement(productSelectLocator);
            if (productSelect.isDisplayed() && productSelect.isEnabled()) {
                productSelect.click();
            }
        } catch (TimeoutException e) {
            fail("product select does not exist so we got a problem");
        }

        // Show the list of product
        By productSelectOptionLocator = By.id("nb-option-9");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(productSelectOptionLocator));
            // Find the select option element
            WebElement productSelectOption = WebDriverFactory.getDriver().findElement(productSelectOptionLocator);
            if (productSelectOption.isDisplayed() && productSelectOption.isEnabled()) {
                productSelectOption.click();
            }
        } catch (TimeoutException e) {
            fail("product select option does not exist so we got a problem");
        }

        // Find the quantity field element for add quantity of product
        By quantityInBagFieldLocator = By.className("quantity-field");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(quantityInBagFieldLocator));
            // Find the select option element
            WebElement quantityInBagField = WebDriverFactory.getDriver().findElement(quantityInBagFieldLocator);
            if (quantityInBagField.isDisplayed() && quantityInBagField.isEnabled()) {
                quantityInBagField.sendKeys("1");
            }
        } catch (TimeoutException e) {
            fail("Input field quantity does not exist so we got a problem");
        }

        //get schedule article btn element by xpath
        By scheduleArticleBtnLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-order-form/mcw-step-store-and-items/div/nb-card/nb-card-body/div[2]/div[2]/button");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(scheduleArticleBtnLocator));
            // Find the select option element
            WebElement scheduleArticleBtn = WebDriverFactory.getDriver().findElement(scheduleArticleBtnLocator);
            if (scheduleArticleBtn.isDisplayed() && scheduleArticleBtn.isEnabled()) {
                scheduleArticleBtn.click();
            }
        } catch (TimeoutException e) {
            fail("article btn schedule does not exist so we got a problem");
        }

        //get schedule product in schedule page btn element
        By schedule1ArticleBtnLocator = By.className("add-elt-btn");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(schedule1ArticleBtnLocator));
            // Find the select option element
            WebElement schedule1ArticleBtn = WebDriverFactory.getDriver().findElement(schedule1ArticleBtnLocator);
            if (schedule1ArticleBtn.isDisplayed() && schedule1ArticleBtn.isEnabled()) {
                schedule1ArticleBtn.click();
            }
        } catch (TimeoutException e) {
            fail("article btn schedule 1 does not exist so we got a problem");
        }

        // Find the withdrawal date field element
        By withdrawalInputLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-delivery-pick-up/div/div[2]/nb-card[1]/nb-card-body/div/div[1]/input");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(withdrawalInputLocator));
            // Find the select option element
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
        } catch (TimeoutException e) {
            fail("withdrawal input does not exist so we got a problem");
        }

        // Show the list of quart time
        By quartTimeSelectLocator = By.id("quartSelect");
//        By quartTimeSelectLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-delivery-pick-up/div/div[2]/nb-card[1]/nb-card-body/div/div[2]/nb-select");

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(quartTimeSelectLocator));
            wait.until(ExpectedConditions.elementToBeClickable(quartTimeSelectLocator));
            WebElement quartTimeSelect = WebDriverFactory.getDriver().findElement(quartTimeSelectLocator);
            if (quartTimeSelect.isDisplayed() && quartTimeSelect.isEnabled()) {
//                quartTimeSelect.click();
                JavascriptExecutor executor = (JavascriptExecutor) WebDriverFactory.getDriver();
                executor.executeScript("arguments[0].click();", quartTimeSelect);
            }
        } catch (TimeoutException e) {
            fail("quartTime select does not exist so we got a problem");
        }

        // Show the list of quart time option
        By quartTimeSelectOptionLocator = By.id("nb-option-12");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(quartTimeSelectOptionLocator));
            // Find the select option element
            WebElement quartTimeSelectOption = WebDriverFactory.getDriver().findElement(quartTimeSelectOptionLocator);
            if (quartTimeSelectOption.isDisplayed() && quartTimeSelectOption.isEnabled()) {
                quartTimeSelectOption.click();
            }
        } catch (TimeoutException e) {
            fail("quartTime select option does not exist so we got a problem");
        }

        // get the quantity field element in tone
        By quantityInToneInputLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-delivery-pick-up/div/div[2]/nb-card[1]/nb-card-body/div/div[5]/div/div[1]/input");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(quantityInToneInputLocator));
            // Find the select option element
            WebElement quantityInToneInput = WebDriverFactory.getDriver().findElement(quantityInToneInputLocator);
            if (quantityInToneInput.isDisplayed() && quantityInToneInput.isEnabled()) {
                quantityInToneInput.sendKeys("0.05");
            }
        } catch (TimeoutException e) {
            fail("quantity in tonne field does not exist so we got a problem");
        }

        // get the quantity of truck element in tone
        By quantityOfTruckInputLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-delivery-pick-up/div/div[2]/nb-card[1]/nb-card-body/div/div[5]/div/div[2]/input");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(quantityOfTruckInputLocator));
            // Find the select option element
            WebElement quantityOfTruckInput = WebDriverFactory.getDriver().findElement(quantityOfTruckInputLocator);
            if (quantityOfTruckInput.isDisplayed() && quantityOfTruckInput.isEnabled()) {
                quantityOfTruckInput.sendKeys("1");
            }
        } catch (TimeoutException e) {
            fail("quantity of truck field does not exist so we got a problem");
        }

        // Save schedule
        By saveScheduleBtnLocator = By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-delivery-pick-up/div/div[2]/nb-card[1]/nb-card-footer/button[2]");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(saveScheduleBtnLocator));
            // Find the select option element
            WebElement saveScheduleBtn = WebDriverFactory.getDriver().findElement(saveScheduleBtnLocator);
            if (saveScheduleBtn.isDisplayed() && saveScheduleBtn.isEnabled()) {
                saveScheduleBtn.click();
            }
        } catch (TimeoutException e) {
            fail("save schedule btn does not exist so we got a problem");
        }
    }

    @After
    public void afterTest() {
        WebDriverFactory.takeScreenShot();
//        WebDriverFactory.finishBrowser();
    }

}
