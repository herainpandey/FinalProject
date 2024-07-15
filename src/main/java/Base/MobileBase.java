package Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MobileBase {

    protected AndroidDriver driver;
    protected AppiumDriverLocalService service;
    @BeforeTest(alwaysRun = true)
    public void startAppiumServer() throws MalformedURLException {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\herai\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 6 API 26");
        options.setCapability("avd","Pixel_6_API_26");
        options.setCapability("avdLaunchTimeout",180000);
        options.setApp("D:\\IT\\Rahul aroraSerenityBDD\\SerenityBDDFramework-Complete\\FinalProject\\src\\main\\resources\\General-Store.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        //xpath, id, accessibilityId, classname, androidUIAutomator
    }



    @AfterTest(alwaysRun = true)
    public void quitDriver(){
        driver.quit();
        service.stop();
    }
}
