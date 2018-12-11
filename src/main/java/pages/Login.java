package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private WebDriver driver;

    //4. Nie brakuje tu czegoś?
    @FindBy(id = "username")
    private WebElement loginInput;
    //5. I tu też?
    @FindBy(id = "username")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void loginAs(String username, String password) {
        //2. Jak wpisać do inputów wartości?
        loginInput.sendKeys(username);
        passwordInput.sendKeys(password);
        //3. A jak zatwierdzic logowanie inaczej niż click()?
        loginButton.submit();
    }
}