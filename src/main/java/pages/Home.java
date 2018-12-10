package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    private WebDriver driver;

    @FindBy(xpath = "//button[text()='przejdź dalej']")
    private WebElement goNextButton;

    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public Home goToHomePage() {
        this.driver.get("https://allegro.pl.allegrosandbox.pl/");
        return this;
    }

    public void acceptTerms() {
        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        //1. Co trzeba zrobić żeby zamknąć okno przyciskiem?
        //goNextButton
    }
}
