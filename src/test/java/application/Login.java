package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends BaseTests{
    WebDriver driver = BaseTests.driver;


    /* public static void signUp(String FirstName, String LastName, String password, String Email){

        BaseTests.driver.findElement(By.xpath("(//a[normalize-space()='Create an Account'])[1]")).click();
        WebElement firstNameInput =BaseTests.driver.findElement(By.name("firstname"));
        firstNameInput.sendKeys(FirstName);

        WebElement lastNameInput =BaseTests.driver.findElement(By.name("lastname"));
        lastNameInput.sendKeys(LastName);

        WebElement emailInput =BaseTests.driver.findElement(By.id("email_address"));
        emailInput.sendKeys(Email);

        BaseTests.driver.findElement(By.id("password")).sendKeys(password);

        BaseTests.driver.findElement(By.id("password-confirmation")).sendKeys(password);
        BaseTests.driver.findElement(By.xpath("(//button[@title='Create an Account'])[1]")).click();
    }

     */

    public static void signIn(String Email, String password){
        BaseTests.driver.findElement(By.xpath("(//a[contains(text(),'Sign In')])[1]")).click();

        WebElement emailInput = BaseTests.driver.findElement(By.id("email"));
        emailInput.sendKeys(Email);

        WebElement passwordInput = BaseTests.driver.findElement(By.xpath("(//input[@id='pass'])[1]"));
        passwordInput.sendKeys(password);

        BaseTests.driver.findElement(By.xpath("(//span[contains(text(),'Sign In')])[1]")).click();


    }

    public static void goTo(){
        BaseTests.driver.findElement(By.xpath("(//img)[1]")).click();
    }

}
