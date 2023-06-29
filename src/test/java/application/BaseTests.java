package application;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import extentReport.ExtentReport;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Utilities;

import java.io.IOException;

import static extentReport.ExtentReport.extent;
import static extentReport.ExtentReport.getScreenshotAsBase64;

public class BaseTests {
    public static WebDriver driver;
    private Utilities excelData;
    private String username;
    private String password;
    private String Email;
    private String LastName;
    private String FirstName;
    private String productName;

    private String SCompany;
    private String SCountry;
    private String SAddress;
    private String SCity;
    private String SProvince;
    private String SCode;
    private String SPhone;
    private ITestResult result;

    @BeforeSuite
    public static void beforeSuite() {
        ExtentReport.initReports();
    }

    @AfterSuite
    public static void afterSuite() throws IOException {
        ExtentReport.flushReports();
    }
    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) throws IOException {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);

        } else {
            throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com ");

        excelData = new Utilities();
        Utilities.setupExcel();
    }

    @Test(priority = 1)
    public void signIn() throws IOException {
        Email = Utilities.getCellData(1,3);
        password = Utilities.getCellData(1,4);
        Login.signIn(Email,password);
        Login.goTo();
    }
    @Test(priority = 2)
    public static void tees() throws InterruptedException, IOException {
        Tees.tees();
        Tees.threeStarsTee();
        Cart.threeStarsAddToCart();
        Validation.EmptyFields();
        Thread.sleep(2500);


    }




      /*  @Test(priority = 3)
        public void pullOverAddToCart() throws InterruptedException {
            Login.goTo();
            productName = Utilities.getCellData(1,5);
            Tees.searchForItem(productName);
            Tees.pullOverItem();
            Cart.PulloverAddToCart();
            Validation.itemAddedToCart();
        }
       @Test(priority = 4)
        public void checkOut(){
            Cart.cartIcon();

            FirstName = Utilities.getCellData(1,1);
            LastName = Utilities.getCellData(1,2);
            SCompany = Utilities.getCellData(1,8);
            SCountry = Utilities.getCellData(1,9);
            SAddress =  Utilities.getCellData(1,10);
            SCity =  Utilities.getCellData(1,11);
            SProvince = Utilities.getCellData(1,12);
            SCode= String.valueOf(Utilities.getCellInt(1,13));
            SPhone =String.valueOf(Utilities.getCellInt(1,14));
            Checkout.shippingInfo( FirstName,LastName,  SCompany,  SCountry,  SAddress, SCity,  SProvince,  SCode,SPhone);

        }


    @Test(priority = 5)
    public void hotSellersCompare() {
        Login.goTo();
        CompareProducts.hotSellersScroll();
        CompareProducts.CompareIcon();
        CompareProducts.compareListLink();
    }

    @Test(priority = 6)
    public void compareOnImgClicked() {
        Login.goTo();
        CompareProducts.hotSellersScroll();
        CompareProducts.compareOnImgClicked();
        Validation.compareSuccessText();
        CompareProducts.compareListLink();

    }

    @Test(priority = 7)
    public static void weatherTankProduct() {
        Login.goTo();
        CompareProducts.hotSellersScroll();
        CompareProducts.weatherTankProduct();
        CompareProducts.compareListLink();
        CompareProducts.removeComparedItem();
    }
    @Test(priority = 8)
    public static void heroHoodie(){
        Login.goTo();
        CompareProducts.hotSellersScroll();
        Tees.heroHoodie();
        Cart.heroHoodieCart();

    }

    */
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
