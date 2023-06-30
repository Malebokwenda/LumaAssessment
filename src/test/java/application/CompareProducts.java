package application;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import extentReport.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.time.Duration;

import static extentReport.ExtentReport.extent;
import static extentReport.ExtentReport.getScreenshot;


public class CompareProducts {
    WebDriver driver = BaseTests.driver;
    static WebDriverWait wait = new WebDriverWait(BaseTests.driver, Duration.ofSeconds(10));
    @BeforeSuite
    public static void beforeSuite() {
        ExtentReport.initReports();
    }

    @AfterSuite
    public static void afterSuite() throws IOException {
        ExtentReport.flushReports();
    }

    public static void hotSellersScroll(){

        JavascriptExecutor js = (JavascriptExecutor)BaseTests.driver;
        WebElement RadiantTee = BaseTests.driver.findElement(By.xpath("(//img[@alt='Radiant Tee'])[1]"));
        js.executeScript("arguments[0].scrollIntoView();", RadiantTee);

    }
    public static  void CompareIcon() throws IOException {
        ExtentTest test = extent.createTest("Hover on item to add to product compare");
        test.info("User clicks an img to add item to compare");
//          selected colour so that the hover won't disappear
        BaseTests.driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-57\"]")).click();
        test.pass("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("CompareIcon")).build());
//        click add to compare button
        BaseTests.driver.findElement(By.xpath("(//a[@title='Add to Compare'])[1]")).click();



    }
    public static  void compareOnImgClicked() throws IOException {
        ExtentTest test = extent.createTest("Product Compare on Img");
        test.info("User clicks an img to add item to compare");
//        find product to compare
      WebElement BreatheTank = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@alt='Breathe-Easy Tank'])[1]")));
        BreatheTank.click();
//        click add to compare button

         WebElement CompareButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'Add to Compare')])[1]")));
        CompareButton.click();
        test.pass("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("compareOnImgClicked")).build());



    }
     public static void weatherTankProduct(){
//                find product to compare
         BaseTests.driver.findElement(By.xpath("(//img[@alt='Argus All-Weather Tank'])[1]")).click();
//        click add to compare button
         BaseTests.driver.findElement(By.xpath("(//span[contains(text(),'Add to Compare')])[1]")).click();

     }
     public static void removeComparedItem() throws IOException {
         ExtentTest test = extent.createTest("Product Compare on Img");
         test.info("User is removing item on product compare page");
        WebElement removeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='Remove Product'])[1]")));
         removeElement.click();
         test.pass("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("removeComparedItem")).build());

         WebElement okAlertButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside[2]/div[2]/footer/button[2]")));
         okAlertButton.click();
     }

    public static void compareListLink(){
        //        click compare list link on the confirmation message
        JavascriptExecutor js = (JavascriptExecutor)BaseTests.driver;
        WebElement LinkOnConfirmMessage =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='comparison list'])[1]")));
        js.executeScript("arguments[0].scrollIntoView();",LinkOnConfirmMessage);
        BaseTests.driver.findElement(By.linkText("comparison list")).click();
    }


}

