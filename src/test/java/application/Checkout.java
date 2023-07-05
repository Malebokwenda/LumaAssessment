package application;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import extentReport.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import static extentReport.ExtentReport.extent;
import static extentReport.ExtentReport.getScreenshot;

public class Checkout extends   BaseTests{
    WebDriver driver = BaseTests.driver;
    static WebDriverWait wait = new WebDriverWait(BaseTests.driver, Duration.ofSeconds(10));


    public static void captureShippingInfo(String FirstName, String LastName, String SCompany, String SCountry, String SAddress, String SCity, String SProvince, String SCode, String SPhone) throws IOException {
        ExtentReport.test.info("User is filling shipping information");
//        Fill in personal info
        WebElement firstNameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@name, \"firstname\")]")));
        firstNameInput.clear();
        firstNameInput.sendKeys(FirstName);

        WebElement lastNameInput = BaseTests.driver.findElement(By.name("lastname"));
        lastNameInput.clear();
        lastNameInput.sendKeys(LastName);


        WebElement companyInput = BaseTests.driver.findElement(By.name("company"));
        companyInput.clear();
        companyInput.sendKeys(SCompany);

//        address
        WebElement addressInput = BaseTests.driver.findElement(By.name("street[0]"));
        addressInput.clear();
        addressInput.sendKeys(SAddress);

        WebElement cityInput = BaseTests.driver.findElement(By.name("city"));
        cityInput.clear();
        cityInput.sendKeys(SCity);

//        Select country
        WebElement  countryDropdown = BaseTests.driver.findElement
                (By.xpath("/html/body/div[1]/main/div[2]/div/div[2]" +
                        "/div[4]/ol/li[1]/div[2]/form/div/div[8]/div/select"));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText(SCountry);


//        province
        WebElement  provinceInput = BaseTests.driver.findElement(By.name("region"));
        provinceInput.sendKeys(SProvince);

//      postal code
        WebElement zipInput = BaseTests.driver.findElement(By.name("postcode"));
        zipInput.clear();
        zipInput.sendKeys(SCode);


//      cellphone
        WebElement cellNumberInput = BaseTests.driver.findElement(By.name("telephone"));
        cellNumberInput.clear();
        cellNumberInput.sendKeys(SPhone);

//        shipping method
        WebElement shippingMethod= wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("(//input[@name='ko_unique_2'])[1]")));
        Actions actions = new Actions(BaseTests.driver);
        actions.moveToElement(shippingMethod).click().perform();

        BaseTests.driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button/span")).click();
        ExtentReport.test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("Shipping Info")).build());
//        place order
         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button"))).click();
//        BaseTests.driver.findElement(By.className("(//span[normalize-space()='Next'])[1]")).click();


    }
}
