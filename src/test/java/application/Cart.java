package application;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import extentReport.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import static extentReport.ExtentReport.extent;
import static extentReport.ExtentReport.getScreenshotAsBase64;

public class Cart extends BaseTests{
    WebDriver driver = BaseTests.driver;
    @BeforeSuite
    public static void beforeSuite() {
        ExtentReport.initReports();
    }

    @AfterSuite
    public static void afterSuite() throws IOException {
        ExtentReport.flushReports();
    }

    public static void threeStarsAddToCart() throws IOException {
        ExtentTest test = extent.createTest("Add 3 stars Item to cart");
        test.info("User adds a 3 stars product to cart");

        BaseTests.driver.findElement(By.xpath("(//button[@id='product-addtocart-button'])[1]")).click();
        test.pass("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotAsBase64("AddToCart")).build());
    }
    public static void PulloverAddToCart(){
        BaseTests.driver.findElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]")).click();

    }
    public static void cartIcon(){
        BaseTests.driver.findElement(By.xpath("(//a[@class='action showcart'])[1]")).click();
        Actions actions = new Actions(BaseTests.driver);

        WebElement proceedToCheckout = BaseTests.driver.findElement(By.cssSelector("#top-cart-btn-checkout"));
        actions.moveToElement(proceedToCheckout).click().perform();

    }
    public static  void heroHoodieCart(){
        BaseTests.driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[4]/div/div/div[3]/div/div[1]/form/button")).click();

    }


}
