package pageComponents.gridComponents;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import page.GridPage;

public class GridSearch extends BasePage {

    @FindBy(css="#woocommerce-product-search-field-0")
    private WebElement searchbox;

    @FindBy(xpath = "//button[@value='Search']")
    private WebElement searchButton;

    public GridSearch(WebDriver driver) {
        super(driver);
    }


    public GridPage searchFor(String searchText){
        searchbox.sendKeys(searchText);
        addLog("Searched Text Entered", ITestResult.SUCCESS);
        searchit();
        return PageFactory.initElements(driver,GridPage.class);
    }

    public void enterSearchFor(String searchText){
        searchbox.sendKeys(searchText);
        addLog("Search is succssful", ITestResult.SUCCESS);
    }

    private void searchit(){
        searchButton.click();
        addLog("Searched Button", ITestResult.SUCCESS);
    }
}
