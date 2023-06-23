package application;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;

public class Tees extends  BaseTests{

    WebDriver driver = BaseTests.driver;

    public static void tees() throws InterruptedException {
        Actions actions = new Actions(BaseTests.driver);
        WebElement element =
                BaseTests.driver.findElement(By.xpath("(//span[normalize-space()='Men'])[1]"));
        actions.moveToElement(element).perform();
        Thread.sleep(2500);

        WebElement tops = BaseTests.driver.findElement(By.xpath("(//span[contains(text(),'Tops')])[2]"));
        actions.moveToElement(tops).build().perform();
        Thread.sleep(2500);

        BaseTests.driver.findElement(By.xpath("(//span[contains(text(),'Tees')])[2]")).click();

    }

    public static void threeStarsTee(){
//       find 3 stars product item  to adds to cart
        BaseTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[3]/div[1]/a[1]/span[1]/span[1]/img[1]")).click();

    }

    public static void searchForItem(String productName) throws InterruptedException {
//        input on search box
        WebElement searchInput = BaseTests.driver.findElement(By.id("search"));
        searchInput.sendKeys(productName);
//        click search button
        BaseTests.driver.findElement(By.xpath("(//button[@title='Search'])[1]")).click();

        Thread.sleep(2000);

//        Find orange Miko Pullover Hoodie
        Actions actions = new Actions(BaseTests.driver);

        WebElement orangePullover = BaseTests.driver.findElement(By.xpath("(//img[@alt='Mars HeatTech™ Pullover'])[1]"));
        actions.scrollToElement(orangePullover).click();
    }
    public static void pullOverItem(){
//        Color
        BaseTests.driver.findElement(By.id("option-label-color-93-item-56")).click();
//        Size
        BaseTests.driver.findElement(By.id("option-label-size-143-item-168")).click();
    }



}
