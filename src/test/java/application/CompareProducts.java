package application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CompareProducts {
    WebDriver driver = BaseTests.driver;
    static WebDriverWait wait = new WebDriverWait(BaseTests.driver, Duration.ofSeconds(10));

    public static void hotSellersScroll(){

        JavascriptExecutor js = (JavascriptExecutor)BaseTests.driver;
        WebElement RadiantTee = BaseTests.driver.findElement(By.xpath("(//img[@alt='Radiant Tee'])[1]"));
        js.executeScript("arguments[0].scrollIntoView();", RadiantTee);

    }
    public static  void CompareIcon(){
//          selected colour so that the hover won't disappear
        BaseTests.driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-57\"]")).click();
//        click add to compare button
        BaseTests.driver.findElement(By.xpath("(//a[@title='Add to Compare'])[1]")).click();



    }
    public static  void compareOnImgClicked(){
//        find product to compare
      WebElement BreatheTank = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@alt='Breathe-Easy Tank'])[1]")));
        BreatheTank.click();
//        click add to compare button
         WebElement CompareButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'Add to Compare')])[1]")));
        CompareButton.click();



    }
     public static void weatherTankProduct(){
//                find product to compare
         BaseTests.driver.findElement(By.xpath("(//img[@alt='Argus All-Weather Tank'])[1]")).click();
//        click add to compare button
         BaseTests.driver.findElement(By.xpath("(//span[contains(text(),'Add to Compare')])[1]")).click();

     }
     public static void removeComparedItem(){
        WebElement removeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='Remove Product'])[1]")));
         removeElement.click();

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

