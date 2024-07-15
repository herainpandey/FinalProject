package Base;

import com.aventstack.extentreports.Status;
import manager.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
    }

    public void addLog(String message, int result){

        switch (result){
            case 1:
                ExtentTestManager.getTest().log(Status.PASS,message);
                break;
            case 3:
                ExtentTestManager.getTest().log(Status.SKIP,message);
                break;
        }
    }

}
