/*package extentReport;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestNGListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = ExtentReport.createTest(result.getMethod().getMethodName());
        test.log(Status.PASS, "Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = ExtentReport.createTest(result.getMethod().getMethodName());
        test.log(Status.FAIL, "Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = ExtentReport.createTest(result.getMethod().getMethodName());

        test.log(Status.SKIP, "Test Skipped");
    }
}

 */
