package application;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.Utilities;

import java.io.IOException;

public class BaseTests {
    public static WebDriver driver;
    private Utilities excelData;
    private String username;
    private String password;
    private String Email;
    private String LastName;
    private String FirstName;
    private String productName;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) throws IOException {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);

        }
        else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);

        }
        else{
            throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com ");

        excelData = new Utilities();
        Utilities.setupExcel();
    }
//    @Test(priority = 1)
//    public void signUp(){
//        FirstName = Utilities.getCellData(1,1);
//        LastName = Utilities.getCellData(1,2);
//        Email = Utilities.getCellData(1,4);
//        password = Utilities.getCellData(1,3);
//        Login.signUp(FirstName,LastName,Email,password);
//
//    }
    @Test(priority = 1)
    public void signIn(){
        Email = Utilities.getCellData(1,3);
        password = Utilities.getCellData(1,4);
        Login.signIn(Email,password);
        Login.goTo();

    }
//    @Test(priority = 2)
//    public static void tees() throws InterruptedException {
//        Tees.tees();
//        Tees.threeStarsTee();
//
//
//    }
//    @Test(priority = 3)
//    public static void addToCart(){
//        Cart.threeStarsAddToCart();
//        Validation.EmptyFields();
//
//    }


    @Test(priority = 4)
    public void pullOverAddToCart() throws InterruptedException {
        Login.goTo();
        productName = Utilities.getCellData(1,5);
        Tees.searchForItem(productName);
        Tees.pullOverItem();
        Cart.PulloverAddToCart();
        Validation.itemAddedToCart();
    }
    @Test(priority = 5)
    public void checkOut(){
        Cart.cartIcon();

    }

}
