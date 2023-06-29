package extentReport;

import application.BaseTests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public  class ExtentReport {

    public static ExtentReports extent;
    private static ExtentSparkReporter spark;
    private static WebDriver driver;
    private static ITestResult result;
    @BeforeSuite
    public static void initReports() {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("C:/Users/digilink/Downloads/SeleniumRevision/LumaAssessment/src/test/java/extentReport/spark.html");
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Extent Reports");
        driver = BaseTests.driver;
    }

    public static ExtentTest createTest(String testcasename) {
        ExtentTest test = extent.createTest(testcasename);
        return test;
    }

    @AfterMethod
    public static void testResults(ITestResult result) {
        ExtentTest test = createTest(result.getMethod().getMethodName());
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getName());
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, result.getThrowable());
        } else {
            test.log(Status.SKIP, result.getName());
        }
    }
    public static String getScreenshotAsBase64(String testCaseName) throws IOException {
        File source = ((TakesScreenshot) BaseTests.driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileName = "image_" + testCaseName + "_" + timestamp + ".png";
        String path = System.getProperty("user.dir") + "src/test/java/extentReport/Screenshots/" + fileName;
        FileUtils.copyFile(source, new File(path));
        return path;
    }


//    public static String getScreenshotAsBase64() throws IOException {
//        File source = ((TakesScreenshot) BaseTests.driver).getScreenshotAs(OutputType.FILE);
//        String path = System.getProperty("user.dir") + "src/test/java/extentReport/Screenshots/image.png";
//        FileUtils.copyFile(source, new File(path));
//        return path;
//
////        byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(path));
////        return Base64.getEncoder().encodeToString(imageBytes);
//    }

    @AfterSuite
    public static void flushReports() throws IOException {
        extent.flush();
        Desktop.getDesktop().browse(new File("C:/Users/digilink/Downloads/SeleniumRevision/LumaAssessment/src/test/java/extentReport/spark.html").toURI());
    }
}
