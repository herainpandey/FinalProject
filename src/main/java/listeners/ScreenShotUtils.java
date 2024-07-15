package listeners;

import Base.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtils extends BaseTest {

    private static ScreenShotUtils instance = null;

    private ScreenShotUtils(){

    }

    public static ScreenShotUtils getInstance(){
        if(instance ==null){
            instance = new ScreenShotUtils();
        }
        return instance;
    }
    public String getscreenShot(WebDriver driver){
        //return "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);

    }
}
