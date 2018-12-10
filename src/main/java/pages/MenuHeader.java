package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuHeader {
    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='czego szukasz?']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@data-dropdown-id='account_dropdown']")
    private WebElement myAllegroAccount;

    @FindBy(xpath = "//a[@data-description='header login button']")
    private WebElement signIn;

    public MenuHeader(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public WebElement getMyAllegroAccount() {
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(myAllegroAccount, "client:44090950"));
        return myAllegroAccount;
    }

    public void searchFor(String phrase) {
        searchInput.sendKeys(phrase);
        searchInput.submit();
    }

    public void navigateToLoginPage() {
        myAllegroAccount.click();
        signIn.click();
    }
}