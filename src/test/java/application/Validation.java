package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Validation extends BaseTests{

    WebDriver driver = BaseTests.driver;
    static WebDriverWait wait = new WebDriverWait(BaseTests.driver, Duration.ofSeconds(10));
    public static void EmptyFields(){
//         Wait for the error message to be displayed

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='super_attribute[143]-error'])[1]")));

//         Verify the error message
        String expectedErrorMessage = "This is a required field.";
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }
    public static void itemAddedToCart(){
        //         Wait for the error message to be displayed
        WebElement AddedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div")));

//         Verify the  message
        String expectedAddedItemMessage = "You added Miko Pullover Hoodie to your shopping cart.";
        String actualAddedItemMessage = AddedMessage.getText();
        Assert.assertEquals(actualAddedItemMessage,expectedAddedItemMessage );

    }
    public static  void compareSuccessText(){
        WebElement AddedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")));
        String expectedAddedItemMessage = "You added product Breathe-Easy Tank to the comparison list.";
        String actualAddedItemMessage = AddedMessage.getText() ;
        Assert.assertEquals(actualAddedItemMessage,expectedAddedItemMessage );


    }
}
