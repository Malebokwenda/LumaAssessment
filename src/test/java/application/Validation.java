package application;
import com.aventstack.extentreports.MediaEntityBuilder;
import extentReport.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.IOException;
import java.time.Duration;
import static extentReport.ExtentReport.getScreenshot;

public class Validation extends BaseTests{

    WebDriver driver = BaseTests.driver;
    static WebDriverWait wait = new WebDriverWait(BaseTests.driver, Duration.ofSeconds(10));
    public static void EmptyFields() throws IOException {
//         Wait for the error message to be displayed
        ExtentReport.test.info("User has not selected product size and color");
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='super_attribute[143]-error'])[1]")));

//         Verify the error message
        String expectedErrorMessage = "This is a required field.";
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        ExtentReport.test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("Empty Field")).build());

    }
    public static void itemAddedToCart(){

        //         Wait for the item added to cart  message to be displayed
        WebElement AddedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div")));
//         Verify the  message
        String expectedAddedItemMessage = "You added Miko Pullover Hoodie to your shopping cart.";
        String actualAddedItemMessage = AddedMessage.getText();
        Assert.assertEquals(actualAddedItemMessage,expectedAddedItemMessage );

    }
    public static  void compareSuccessText() throws IOException {
        ExtentReport.test.info("User has added an item to cart");
        WebElement AddedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")));
        String expectedAddedItemMessage = "You added product Breathe-Easy Tank to the comparison list.";
        String actualAddedItemMessage = AddedMessage.getText() ;
        Assert.assertEquals(actualAddedItemMessage,expectedAddedItemMessage );
        ExtentReport.test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("compareSuccessText")).build());
    }
    public static void removedItemText() throws IOException {
        ExtentReport.test.info("User has removed an item from compare products");
        WebElement AddedMessage = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("(//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)'])[1]")));
        String expectedAddedItemMessage = "You removed product Argus All-Weather Tank from the comparison list.";
        String actualAddedItemMessage = AddedMessage.getText() ;
        Assert.assertEquals(actualAddedItemMessage,expectedAddedItemMessage );
        ExtentReport.test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("removedItemText")).build());

    }
}
