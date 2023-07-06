package application;
import com.aventstack.extentreports.MediaEntityBuilder;
import extentReport.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.IOException;
import java.time.Duration;
import static extentReport.ExtentReport.getScreenshot;

public class Tees extends  BaseTests{

    WebDriver driver = BaseTests.driver;
    static Actions actions = new Actions(BaseTests.driver);
    static WebDriverWait wait = new WebDriverWait(BaseTests.driver, Duration.ofSeconds(10));
    public static void navigateToTopsTees() throws InterruptedException, IOException {
        ExtentReport.test.info("User  hovers from men to tees to find an item ");
//        hover on men
        WebElement element =
                BaseTests.driver.findElement(By.xpath("(//span[normalize-space()='Men'])[1]"));
        actions.moveToElement(element).perform();
        Thread.sleep(2500);
//        hover on tops
        WebElement tops = BaseTests.driver.findElement(By.xpath("(//span[contains(text(),'Tops')])[2]"));
        actions.moveToElement(tops).build().perform();
        Thread.sleep(2500);
        ExtentReport.test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("tees")).build());
//       click tees
        BaseTests.driver.findElement(By.xpath("(//span[contains(text(),'Tees')])[2]")).click();

    }

    public static void selectThreeStarsTee() throws IOException {
        ExtentReport.test.info("user looks for a 3 starts item to add to cart");
        ExtentReport.test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("three StarTee")).build());
//       find 3 stars product item  to adds to cart
        BaseTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[3]" +
                "/ol[1]/li[3]/div[1]/a[1]/span[1]/span[1]/img[1]")).click();

    }

    public static void searchForItem(String productName) throws InterruptedException, IOException {
        ExtentReport.test.info("User is searching for an item on the search field");
//        input on search box
        WebElement searchInput = BaseTests.driver.findElement(By.id("search"));
        searchInput.sendKeys(productName);
        ExtentReport.test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("Search for Item")).build());

//        click search button
        BaseTests.driver.findElement(By.xpath("(//button[@title='Search'])[1]")).click();

        Thread.sleep(2000);
    }

    public static void scrollToMikoPullover(){
//       Find orange Miko Pullover Hoodie
        JavascriptExecutor js = (JavascriptExecutor)BaseTests.driver;
        WebElement mikoPullover = BaseTests.driver.findElement(By.xpath("(//img[@alt='Miko Pullover Hoodie'])[1]"));
        js.executeScript("arguments[0].scrollIntoView();", mikoPullover);
        mikoPullover.click();

    }
    public static void pullOverItem(){
   /*             Find orange Miko Pullover Hoodie
        BaseTests.driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]" +
                "/ol/li[1]/div/a/span/span/img")).click();
        Size
    */
        WebElement  size = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("(//div[@id='option-label-size-143-item-168'])[1]")));
        actions.moveToElement(size).click().perform();

//                    Color
        WebElement color= wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("(//div[@id='option-label-color-93-item-56'])[1]")));
        actions.moveToElement(color).click().perform();
    }

    public static void  heroHoodie(){
        ExtentReport.test.info("User adds item to add ");
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
