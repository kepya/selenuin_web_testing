package com.selenium.test.projets.cimencam;

import com.selenium.test.junit.rules.ScreenShotOnFailRule;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;

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
    public void newPickUpOrderAndMtnPayment() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);

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
            fail("Login failed" );
        }

        /***** Order Proces ****/

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
        } catch (TimeoutException e) {
            fail("store select option does not exist so we got a problem");
        }

        //get add article btn element by xpath
        WebElement addArticleBtn = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-order-form/mcw-step-store-and-items/div/nb-card/nb-card-body/div[2]/button"));
        addArticleBtn.click();

        // Show the list of product
        WebElement productSelect = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-order-form/mcw-step-store-and-items/div/nb-card/nb-card-body/div[2]/ul/li[2]/div[2]/nb-select"));
        productSelect.click();

        WebElement productSelectOption =  WebDriverFactory.getDriver().findElement(By.id("nb-option-11"));
        productSelectOption.click();

        // Find the quantity field element for add quantity of product
        WebElement quantityInBagField = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-order-form/mcw-step-store-and-items/div/nb-card/nb-card-body/div[2]/ul/li[2]/div[3]/input"));
        quantityInBagField.sendKeys("1");

        //add another line to select product
        addArticleBtn.click();
        WebElement deleteArticleBtn = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-order-form/mcw-step-store-and-items/div/nb-card/nb-card-body/div[2]/ul/li[3]/div[6]/nb-icon"));
        deleteArticleBtn.click();

        //get schedule article btn element by xpath
        WebElement scheduleArticleBtn = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-order-form/mcw-step-store-and-items/div/nb-card/nb-card-body/div[2]/div[2]/button"));
        scheduleArticleBtn.click();

        //get schedule product in schedule page btn element by xpath
        WebElement schedule1ArticleBtn = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-order-form/mcw-step-store-and-items/div/nb-card/nb-card-body/div[2]/div[2]/button"));
        schedule1ArticleBtn.click();

        // Find the withdrawal date field element
        WebElement withdrawalField = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-delivery-pick-up/div/div[2]/nb-card[1]/nb-card-body/div/div[1]/input"));
        Calendar calendar = Calendar.getInstance();
        withdrawalField.sendKeys(calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH));

        // Show the list of quart time
        WebElement quartTimeSelect = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-order-form/mcw-step-store-and-items/div/nb-card/nb-card-body/div[2]/ul/li[2]/div[2]/nb-select"));
        quartTimeSelect.click();

        WebElement quartTimeSelectOption =  WebDriverFactory.getDriver().findElement(By.id("nb-option-18"));
        quartTimeSelectOption.click();

        // get the quantity field element in tone
        WebElement quantityInTone = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-delivery-pick-up/div/div[2]/nb-card[1]/nb-card-body/div/div[5]/div/div[1]/input"));
        quantityInTone.sendKeys("0.05");

        // get the quantity field element in tone
        WebElement quantityOfTruck = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-delivery-pick-up/div/div[2]/nb-card[1]/nb-card-body/div/div[5]/div/div[2]/input"));
        quantityInBagField.sendKeys("1");

        // Save schedule
        WebElement saveScheduleBtn = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-delivery-pick-up/div/div[2]/nb-card[1]/nb-card-footer/button[2]"));
        saveScheduleBtn.click();

        // Show the delivery mode
        WebElement deliveryModeSelect = WebDriverFactory.getDriver().findElement(By.id("companyAccountSelect"));
        deliveryModeSelect.click();

        // Select pickup mode
        WebElement deliveryModeSelectOption =  WebDriverFactory.getDriver().findElement(By.id("nb-option-20"));
        deliveryModeSelectOption.click();

        // Show the payment mode
        WebElement paymentModeSelect = WebDriverFactory.getDriver().findElement(By.id("paymentModeSelect"));
        paymentModeSelect.click();

        // Select mtn payment
        WebElement paymentModeSelectOption = WebDriverFactory.getDriver().findElement(By.id("nb-option-25"));
        paymentModeSelectOption.click();

        //Pass number for mtn payment
        WebElement phoneNumberInput = WebDriverFactory.getDriver().findElement(By.id("phoneNumber"));
        phoneNumberInput.sendKeys("680670670");

        //Pass customerReference for mtn payment
        WebElement customerReferenceInput = WebDriverFactory.getDriver().findElement(By.id("customerReference"));
        customerReferenceInput.sendKeys("1");

        //Get btn to valid order
        WebElement validOrderBtn = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div[1]/div/div/div/div/nb-layout-column/mcw-order-form/mcw-step-purchase-type-and-payment/div/div[2]/nb-card[1]/nb-card-body/div/mcw-orange/div[2]/button[2]"));
        validOrderBtn.click();

        //Get btn to submit request for payment
        WebElement submitPaymentRequestBtn = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/mcw-root/nb-layout/div[2]/div[3]/div/nb-dialog-container/mcw-dialog-confirm-payment/nb-card/nb-card-footer/button[2]"));
        submitPaymentRequestBtn.click();
    }

    @After
    public void afterTest() {
        WebDriverFactory.takeScreenShot();
//        WebDriverFactory.finishBrowser();
    }

}
