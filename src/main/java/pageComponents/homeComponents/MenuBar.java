package pageComponents.homeComponents;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.ITestResult;
import page.GridPage;

import java.util.List;

public class MenuBar extends BasePage {

    @FindBy(css="[id='ast-desktop-header']  li")
    List<WebElement> menubar;

    public MenuBar(WebDriver driver) {
        super(driver);
    }


    public GridPage navigateToMen(){
        for(WebElement element: menubar){
            element.findElement(By.xpath("//a[text()='Men']")).click();
            break;
        }
        addLog("Navigating to Men Section", ITestResult.SUCCESS);

        return new GridPage(driver);

    }
}
