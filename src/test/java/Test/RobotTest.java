package Test;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.GridPage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import static Log.LogManager.Log;
import static manager.ExtentTestManager.startTest;

public class RobotTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void launchBrowser(){
        Log.info("Going to Launch Site AskOMdch.com");
        getDriver().get("https://askomdch.com/product-category/men/");
    }

    public void robotPressEnter(Method method) throws IOException, AWTException {
        startTest(method.getName() , "This test case will Pass");

                GridPage
                        .getGridPageInstance(getDriver())
                        .getGridSearchInstance()
                .searchFor(properties.getDataFromUserProperty("product"));

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


    }


    @Test(enabled = false)
    public void robotTakeScreenShot(Method method) throws IOException, AWTException {
        startTest(method.getName() , "This test case will Pass");

        GridPage
                .getGridPageInstance(getDriver())
                .getGridSearchInstance()
                .searchFor(properties.getDataFromUserProperty("product"));

        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(new Rectangle(0,0,1000,300));
        ImageIO.write(image,"PNG",new File("./Screenshots/robotScreen.png"));
    }

    @Test
    public void robotScroll(Method method) throws IOException, AWTException {
        startTest(method.getName() , "This test case will Pass");

        GridPage
                .getGridPageInstance(getDriver())
                .getGridSearchInstance()
                .searchFor(properties.getDataFromUserProperty("product"));

        Robot robot = new Robot();
        robot.mouseWheel(1000);
        }


    @Test
    public void robotUploadFileTest(Method method) throws IOException, AWTException {
        startTest(method.getName() , "This test case will Pass");

        GridPage
                .getGridPageInstance(getDriver())
                .getGridSearchInstance()
                .searchFor(properties.getDataFromUserProperty("product"));

        Robot robot = new Robot();
        String path = "Path to image/Any file";
        StringSelection stringSelection = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);


        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);


    }

    @Test
    public void robotrightClickTest(Method method) throws IOException, AWTException {
        startTest(method.getName() , "This test case will Pass");

        GridPage
                .getGridPageInstance(getDriver())
                .getGridSearchInstance()
                .searchFor(properties.getDataFromUserProperty("product"));

        Robot robot = new Robot();
        robot.mouseMove(250,300); // move to specific location
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);  // press right click
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK); // release right click
        //Mouse vale m InputEvent hote h
        //Key vale m KeyEvent hote h
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_DOWN); // press down
        robot.keyRelease(KeyEvent.VK_DOWN); // release down
        robot.keyPress(KeyEvent.VK_ENTER); // hit enter

    }
}
