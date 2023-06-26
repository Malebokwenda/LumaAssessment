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

    public static void EmptyFields(){
//         Wait for the error message to be displayed
        WebDriverWait wait = new WebDriverWait(BaseTests.driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='super_attribute[143]-error'])[1]")));

//         Verify the error message
        String expectedErrorMessage = "This is a required field.";
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }
    public static void itemAddedToCart(){
        //         Wait for the error message to be displayed
        WebDriverWait wait = new WebDriverWait(BaseTests.driver, Duration.ofSeconds(10));
        WebElement AddedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")));

//         Verify the error message
        String expectedAddedItemMessage = "You added Miko Pullover Hoodie to your shopping cart  ";
        String actualAddedItemMessage = AddedMessage.getText();
        Assert.assertEquals(expectedAddedItemMessage,expectedAddedItemMessage);

    }
}
