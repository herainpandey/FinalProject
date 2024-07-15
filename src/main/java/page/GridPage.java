package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageComponents.gridComponents.GridProductList;
import pageComponents.gridComponents.GridSearch;

public class GridPage {

    private static GridPage instance = null;
    private WebDriver driver;
    private GridSearch gridSearch;

    private GridProductList gridProductList;

    public GridPage(WebDriver driver){
        this.driver = driver;
        gridSearch = PageFactory.initElements(driver, GridSearch.class);
        gridProductList = PageFactory.initElements(driver, GridProductList.class);
    }

    public static GridPage getGridPageInstance(WebDriver driver){
        if(instance==null){
            instance =  new GridPage(driver);
        }
        return instance;
    }

    public GridSearch getGridSearchInstance(){
        return gridSearch;
    }


    public GridProductList gridProductList(){
        return gridProductList;
    }

}
