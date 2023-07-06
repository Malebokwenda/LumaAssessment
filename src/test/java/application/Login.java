package application;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import extentReport.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import static extentReport.ExtentReport.*;

public class Login extends BaseTests{
    WebDriver driver = BaseTests.driver;
    public static void LogIn(String Email, String password) throws IOException {

        test.info("User entered correct credentials");
        BaseTests.driver.findElement(By.xpath("(//a[contains(text(),'Sign In')])[1]")).click();

        WebElement emailInput = BaseTests.driver.findElement(By.id("email"));
        emailInput.sendKeys(Email);

        WebElement passwordInput = BaseTests.driver.findElement(By.xpath("(//input[@id='pass'])[1]"));
        passwordInput.sendKeys(password);
        test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("Sign In")).build());

        BaseTests.driver.findElement(By.xpath("(//span[contains(text(),'Sign In')])[1]")).click();


    }

    public static void goTo(){
        BaseTests.driver.findElement(By.xpath("(//img)[1]")).click();
    }


}
