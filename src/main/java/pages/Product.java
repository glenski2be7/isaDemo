package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product {
    private WebDriver driver;

    @FindBy(xpath = "//button[text()='KUP TERAZ']")
    private WebElement buyNow;

    public Product(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void buyNow(){
        buyNow.click();
    }
}
