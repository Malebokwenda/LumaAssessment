package application;

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
import utilities.ExcelReader;
/*import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

 */

import java.io.IOException;

import static extentReport.ExtentReport.extent;
//@Listeners(extentReport.ExtentTestNGListener.class)

public class BaseTests {
    public static WebDriver driver;
    private ExcelReader excelData;
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
    @AfterMethod
    public  void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentReport.test.log(Status.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentReport.test.log(Status.PASS, result.getTestName());
            System.out.println("Test Passed");
        } else {
            ExtentReport.test.log(Status.SKIP, result.getTestName());
        }
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

        excelData = new ExcelReader();
        ExcelReader.setupExcel();
    }



    @Test(priority = 1)
    public void LogIn() throws IOException {
        ExtentReport.test= extent.createTest("Sign In");
        Email = ExcelReader.getCellData(1,3);
        password = ExcelReader.getCellData(1,4);
        Login.LogIn(Email,password);
        Login.goTo();

    }
      @Test(priority = 2)
    public static void tees() throws InterruptedException, IOException {
    ExtentReport.test = extent.createTest("Three Stars Tee");
        Tees.tees();
        Tees.threeStarsTee();
        Cart.threeStarsAddToCart();
        Validation.EmptyFields();
        Thread.sleep(2500);
    }

   @Test(priority = 3)
    public void hotSellersCompare() throws IOException, InterruptedException {
    ExtentReport.test = extent.createTest("Compare Product hovering over Image");
        Login.goTo();
        CompareProducts.scrollToHotSellers();
        CompareProducts.HoverToClickCompareIcon();
        CompareProducts.compareListLink();
    }

    @Test(priority = 4)
    public void compareItemOnImgClicked() throws IOException, InterruptedException {
    ExtentReport.test = extent.createTest("Compare product on image clicked");
        Login.goTo();
        CompareProducts.scrollToHotSellers();
        CompareProducts.compareOnImgClicked();
        Validation.compareSuccessText();
        CompareProducts.compareListLink();

    }

    @Test(priority = 5)
    public static void weatherTankProduct() throws IOException, InterruptedException {
    ExtentReport.test = extent.createTest("Remove item from Compare Products");
        Login.goTo();
        CompareProducts.scrollToHotSellers();
        CompareProducts.weatherTankProduct();
        CompareProducts.compareListLink();
        CompareProducts.removeComparedItem();
        Validation.removedItemText();
    }
    @Test(priority = 6)
    public static void heroHoodie() throws IOException {
    ExtentReport.test = extent.createTest("Add item to cart hovering over image");
        Login.goTo();
        CompareProducts.scrollToHotSellers();
        Tees.heroHoodie();
        Cart.heroHoodieCartButton();

    }
    @Test(priority = 7)
    public void pullOverAddToCart() throws InterruptedException, IOException {
        ExtentReport.test = extent.createTest("Search for item");
        Login.goTo();
        productName = ExcelReader.getCellData(1,5);
        Tees.searchForItem(productName);
        Tees.scrollToMikoPullover();
        Tees.pullOverItem();
        Cart.PulloverAddToCart();
        Validation.itemAddedToCart();
    }
    @Test(priority = 8)
    public void checkOut() throws IOException {
        ExtentReport.test = extent.createTest("Checkout");
        Cart.clickCartIcon();
        FirstName = ExcelReader.getCellData(1,1);
        LastName = ExcelReader.getCellData(1,2);
        SCompany = ExcelReader.getCellData(1,8);
        SCountry = ExcelReader.getCellData(1,9);
        SAddress =  ExcelReader.getCellData(1,10);
        SCity =  ExcelReader.getCellData(1,11);
        SProvince = ExcelReader.getCellData(1,12);
        SCode= String.valueOf(ExcelReader.getCellInt(1,13));
        SPhone =String.valueOf(ExcelReader.getCellInt(1,14));
        Checkout.captureShippingInfo( FirstName,LastName,  SCompany,  SCountry,  SAddress, SCity,  SProvince,  SCode,SPhone);

    }



   /* @AfterClass
    public void tearDown(){
        driver.quit();
    }

    */
}
