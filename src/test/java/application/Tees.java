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
    static WebDriverWait wait = new WebDriverWait(BaseTests.driver, Duration.ofSeconds(10));

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
        BaseTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[3]" +
                "/ol[1]/li[3]/div[1]/a[1]/span[1]/span[1]/img[1]")).click();

    }

    public static void searchForItem(String productName) throws InterruptedException {
//        input on search box
        WebElement searchInput = BaseTests.driver.findElement(By.id("search"));
        searchInput.sendKeys(productName);
//        click search button
        BaseTests.driver.findElement(By.xpath("(//button[@title='Search'])[1]")).click();

        Thread.sleep(2000);



    }
    public static void pullOverItem(){

//                Find orange Miko Pullover Hoodie
        BaseTests.driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]" +
                "/ol/li[1]/div/a/span/span/img")).click();
//        Size

        WebElement  size = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("(//div[@id='option-label-size-143-item-168'])[1]")));
        Actions actions = new Actions(BaseTests.driver);
        actions.moveToElement(size).click().perform();

//                    Color
        WebElement color= wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("(//div[@id='option-label-color-93-item-56'])[1]")));
         actions = new Actions(BaseTests.driver);
        actions.moveToElement(color).click().perform();
    }

    public static void  heroHoodie(){
//        size
         WebElement hoodieSize = wait.until(ExpectedConditions.visibilityOfElementLocated
                 (By.xpath("(//div[@id='option-label-size-143-item-168'])[4]")));
                 hoodieSize.click();
//        color
        WebElement hoodieColor = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("(//div[@id='option-label-color-93-item-53'])[1]")));
        hoodieColor.click();

    }



}
