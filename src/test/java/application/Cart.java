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

import static extentReport.ExtentReport.*;

public class Cart extends BaseTests{
    WebDriver driver = BaseTests.driver;

    public static void threeStarsAddToCart() throws IOException {
        BaseTests.driver.findElement(By.xpath("(//button[@id='product-addtocart-button'])[1]")).click();
    }
    public static void addPulloverToCart(){
        BaseTests.driver.findElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]")).click();

    }
    public static void clickCartIcon(){
        BaseTests.driver.findElement(By.xpath("(//a[@class='action showcart'])[1]")).click();
        Actions actions = new Actions(BaseTests.driver);

        WebElement proceedToCheckout = BaseTests.driver.findElement(By.cssSelector("#top-cart-btn-checkout"));
        actions.moveToElement(proceedToCheckout).click().perform();

    }
    public static  void heroHoodieCartButton() throws IOException {
        ExtentReport.test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("Hero Hoodie")).build());
        BaseTests.driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[4]/div/div/div[3]/div/div[1]/form/button")).click();

    }


}
