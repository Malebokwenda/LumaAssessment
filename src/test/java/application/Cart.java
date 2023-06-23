package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Cart extends BaseTests{
    WebDriver driver = BaseTests.driver;

    public static void threeStarsAddToCart(){
        BaseTests.driver.findElement(By.xpath("(//button[@id='product-addtocart-button'])[1]")).click();
    }
    public static void PulloverAddToCart(){
        BaseTests.driver.findElement(By.xpath("(//button[@id='product-addtocart-button'])[1]")).click();

    }
    public static void cartIcon(){
        BaseTests.driver.findElement(By.xpath("(//a[@class='action showcart'])[1]")).click();

        Actions actions = new Actions(BaseTests.driver);

        WebElement proceedToCheckout = BaseTests.driver.findElement(By.xpath("(//button[normalize-space()='Proceed to Checkout'])[1]"));
        actions.moveToElement(proceedToCheckout).click();

    }


}
