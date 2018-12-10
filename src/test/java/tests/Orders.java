package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class Orders {

    private WebDriver driver;
    private Home home;
    private MenuHeader menu;
    private Login login;
    private SearchProduct searchProduct;
    private Product product;
    private PaymentAndShipping payAndShip;
    private Summary summary;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.home = new Home(this.driver);
        this.menu = new MenuHeader(this.driver);
        this.login = new Login(this.driver);
        this.searchProduct = new SearchProduct(this.driver);
        this.product = new Product(this.driver);
        this.payAndShip =  new PaymentAndShipping(this.driver);
        this.summary = new Summary(this.driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void makeOrder() {
        home.goToHomePage().acceptTerms();
        menu.navigateToLoginPage();
        login.loginAs("mariusz.g.bogdanski@gmail.com", "Haslo123");
        assertTrue(menu.getMyAllegroAccount().getText().equalsIgnoreCase("client:44090950"));
        menu.searchFor("suszarka");
        searchProduct.openProduct(1);
        product.buyNow();
        payAndShip.confirmPurchase().chooseItemsToBuy().setShippingMethod().goToSummary().payForProduct();
        assertTrue(summary.getSummaryInfo().getText().equalsIgnoreCase("Kupiłeś 1 przedmiot od 1 sprzedającego"));
    }

    @After
    public void tearDown(){
        this.driver.close();
    }
}
