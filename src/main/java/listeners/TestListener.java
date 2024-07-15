package listeners;


import Base.BaseTest;
import com.aventstack.extentreports.Status;
import manager.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static manager.ExtentTestManager.getTest;
import static Log.LogManager.Log;


public class TestListener extends BaseTest implements ITestListener {



    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }


    @Override
    public void onStart(ITestContext iTestContext) {
        Log.info("I am in onStart method " + iTestContext.getName() );
       // iTestContext.setAttribute("Webdriver", this.driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.info("I am in onFinish method " + iTestContext.getName() );
        ExtentManager.createExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is starting." );

    }


    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is succeed." );
        getTest().log(Status.PASS,"Test case passed ");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is failed." );
       /* TakesScreenshot takesScreenshot = (TakesScreenshot)iTestResult.getTestContext().getAttribute("driver");
        String screenshot = takesScreenshot.getScreenshotAs(OutputType.BASE64);
        String htmlImageFormat = "<img width=700px src='data:image/png;base64,%s' />";
        String htmlImage = String.format(htmlImageFormat,screenshot);*/

        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
       WebDriver driver = ((BaseTest) testClass).getDriver();

       // Take base64Screenshot screenshot for extent reports
        String base64Screenshot = ScreenShotUtils.getInstance().getscreenShot(driver);
        //ExtentReports log and screenshot operations for failed tests.
        getTest().log(Status.FAIL, "Test Failed" + "\n\n" + iTestResult.getThrowable().getCause() + "\n\n"+ iTestResult.getThrowable().getMessage()+"\n" , getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is skipped.");
        getTest().log(Status.SKIP, "Test Skipped");
    }


}
