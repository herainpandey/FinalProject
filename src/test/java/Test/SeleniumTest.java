package Test;

import Base.BaseTest;
import utils.DataProvider;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static manager.ExtentTestManager.startTest;
import static Log.LogManager.Log;

public class SeleniumTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void launchBrowser(){
        Log.info("Going to Launch Site AskOMdch.com");
        getDriver().get("https://askomdch.com/");
    }



    @Test(groups = {"regression"})
    public void openMensSectionAfterNavigatingToHome(Method method){
        startTest(method.getName() , "This test case will Pass");

        Log.info("Now Going to click on Mens link");
        new HomePage(getDriver()).getHomePageInstance(getDriver())
                .getMenuBarInstance()
                .navigateToMen();
    }


    @Test(groups = {"smoke"})
    public void searchForBlue(Method method) throws IOException {
        startTest(method.getName() , "This test case will Pass");

        Log.info("Now Going to search for blue");
        new HomePage(getDriver()).getHomePageInstance(getDriver())
                .getMenuBarInstance()
                .navigateToMen()
                .getGridSearchInstance()
                .searchFor(properties.getDataFromUserProperty("product"))
                .gridProductList()
                .verifySearchedFor(properties.getDataFromUserProperty("product"));
    }


    @Test(groups = {"smoke"})
    public void searchForBlueButVerifyRed(Method method){
        startTest(method.getName() , "This test case will Fail");

        Log.info("Now Going to search for blue");
        new HomePage(getDriver()).getHomePageInstance(getDriver())
                .getMenuBarInstance()
                .navigateToMen()
                .getGridSearchInstance()
                .searchFor("blue")
                .gridProductList()
                .verifySearchedFor("red");
    }

    @Test(groups = {"regression"})
    public void addItemToCart(Method method){
        startTest(method.getName() , "This test case will Pass");

        Log.info("Add Blue Shoes Item to Cart");
        new HomePage(getDriver()).getHomePageInstance(getDriver())
                .getMenuBarInstance()
                .navigateToMen()
                .getGridSearchInstance()
                .searchFor("blue")
                .gridProductList()
                .addProductToCart("Blue Shoes")
                .clickOnViewCartBelowProduct()
                .getCartProdcutList()
                .verifyProductAddedToCart("Blue Shoes");
    }


    @Test(groups = {"regression"})
    public void addItemToCartButItemNotFound(Method method){
        startTest(method.getName() , "This test case will Fail");

        Log.info("Add Blue Shoes Item to Cart");
        new HomePage(getDriver()).getHomePageInstance(getDriver())
                .getMenuBarInstance()
                .navigateToMen()
                .getGridSearchInstance()
                .searchFor("blue")
                .gridProductList()
                .addProductToCart("Blue Shoes")
                .clickOnViewCartBelowProduct()
                .getCartProdcutList()
                .verifyProductAddedToCart("Red Shoes");
    }


    //Data provider practice
    @Test(groups = {"regression"},dataProvider = "getExcelData" , dataProviderClass = DataProvider.class)
    public void dataDrivenTestingUsingExcel(String FirstName , String lastName, Double Salary){
        System.out.println("First Name is " +  FirstName);
        System.out.println("Last Name is " +  lastName);
        System.out.println("Salary is " +  Salary);

    }



    @Test(groups = {"regression"},dataProvider = "getJSONData" , dataProviderClass = DataProvider.class)
    public void dataDrivenTestingUsingJson(JSONObject data){
        System.out.println(data.get("firstname"));
        System.out.println(data.get("lastname"));
    }


    @Test
    public void consumerPractice(JSONObject data){

        List<String> list = new ArrayList<>();
        list.add("Herain");
        list.add("Pandey");
        Consumer<String> c1 = (s) -> System.out.println(s);
        c1.accept("udemy");
    }
}
