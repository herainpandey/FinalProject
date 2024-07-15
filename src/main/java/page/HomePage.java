package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageComponents.homeComponents.MenuBar;

public class HomePage{

    private HomePage instance = null;
    private WebDriver driver;
    public HomePage(WebDriver driver){
       this.driver = driver;
    }

    public HomePage getHomePageInstance(WebDriver driver){
        if(instance==null){
            instance =  new HomePage(driver);
        }
        return instance;
    }
    public MenuBar getMenuBarInstance(){
        return  PageFactory.initElements(driver, MenuBar.class);
    }
}
