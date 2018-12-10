package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentAndShipping {

    private WebDriver driver;

    @FindBy(id = "m-radio-0-0-0")
    private WebElement shippingMethod;

    @FindBy(id = "buy-and-pay-btn")
    private WebElement buyAndPay;

    @FindBy(xpath = "//button[@class='m-button m-button--primary m-button--wide m-button--spinner']")
    private WebElement chooseItemsToBuy;

    @FindBy(xpath = "//button[@class='m-button m-button--primary m-button--wide m-button--spinner']")
    private WebElement goToSummary;

    @FindBy(xpath = "//buy-button[@id='confirm-summary-btn']")
    private WebElement confirmSummary;

    public PaymentAndShipping(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public PaymentAndShipping confirmPurchase(){
        buyAndPay.click();
        return this;
    }

    public PaymentAndShipping setShippingMethod(){
        shippingMethod.click();
        return this;
    }

    public PaymentAndShipping goToSummary(){
        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(goToSummary));
        goToSummary.click();
        return this;
    }

    public void payForProduct(){
        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(buyAndPay));
        buyAndPay.click();
    }

    public PaymentAndShipping chooseItemsToBuy(){
        chooseItemsToBuy.click();
        return this;
    }
}
