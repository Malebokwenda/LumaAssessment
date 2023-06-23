package extentReport;

import application.BaseTests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class ExtentReport {
    WebDriver driver = BaseTests.driver;
    static ExtentReports extent = new ExtentReports();
    private ExtentReport() {}

    @BeforeSuite
    public static void initReports() {
        ExtentSparkReporter spark = new ExtentSparkReporter("C:/Users/digilink/Downloads/SeleniumRevision/SeleniumTestAutomation/src/test/java/Reporter/spark.html");
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Extent Reports");

    }


    public static ExtentTest createTest(String testcasename) {
        ExtentTest test = extent.createTest(testcasename);

        return test;
    }

    public static String getScreenshotAsBase64() throws IOException {
        File source = ((TakesScreenshot) BaseTests.driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "src/test/java/Reporter/Screenshots/image.png";
        FileUtils.copyFile(source, new File(path));
        byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(path));
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    public String getBase64() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

    @AfterSuite
    public static void flushReports() throws IOException {
        extent.flush();
        Desktop.getDesktop().browse(new File("C:/Users/digilink/Downloads/SeleniumRevision/SeleniumTestAutomation/src/test/java/Reporter/spark.html/spark.html").toURI());
    }
}
