package Base;

import com.google.common.util.concurrent.Uninterruptibles;
import manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.PropertyUtils;

import java.time.Duration;

public class BaseTest {

    protected static PropertyUtils properties;

    @BeforeSuite(alwaysRun = true)
    public void initialize(){
        properties = PropertyUtils.getInstance();
    }

/*
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
*/

    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    @Parameters("browser")
    public  void initializeDriver(@Optional("chrome") String browser/*, ITestContext ctx*/) throws InterruptedException {

        System.out.println("Going to initiate browser");

            if (Boolean.getBoolean("grid")) {
                driver = DriverManager.getInstance().getRemoteDriver.apply(browser);
                //ctx.setAttribute("driver",this.driver);
            } else {
                driver = DriverManager.getInstance().getLocalDriver.apply(browser);
                //ctx.setAttribute("driver",this.driver);
            }
        Thread.sleep(5000);
        System.out.println("browser Initiated");

    }

      public WebDriver getDriver(){
          return driver;
    }

    @AfterTest(alwaysRun = true)
    public void quitDriver() throws InterruptedException {
        driver.quit();
    }


    @AfterMethod
    public void sleep(){
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
    }
}
