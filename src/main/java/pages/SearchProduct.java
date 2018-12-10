package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct {

    private WebDriver driver;

    public SearchProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void openProduct(int index) {
        driver.findElement(By.xpath("(//article[@class='_8d855a8'])[" + index + "]")).click();
    }
}
