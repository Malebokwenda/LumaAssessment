package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Checkout {
    WebDriver driver = BaseTests.driver;
    static WebDriverWait wait = new WebDriverWait(BaseTests.driver, Duration.ofSeconds(10));

    public static void shippingInfo(String FirstName, String LastName, String SCompany, String SCountry, String SAddress, String SCity, String SProvince, String SCode, String SPhone){
//        Fill in personal info
        WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
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

        WebDriverWait wait = new WebDriverWait(BaseTests.driver, Duration.ofSeconds(10));
        WebElement shippingMethod= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[1]/table/tbody/tr/td[1]/input")));
        Actions actions = new Actions(BaseTests.driver);
        actions.moveToElement(shippingMethod).click().perform();

        BaseTests.driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button/span")).click();

//        place order
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button"))).click();
//        BaseTests.driver.findElement(By.className("(//span[normalize-space()='Next'])[1]")).click();


    }
}
