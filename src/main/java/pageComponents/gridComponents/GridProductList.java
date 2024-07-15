package pageComponents.gridComponents;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestResult;
import page.CartPage;
import java.util.List;

import static Log.LogManager.Log;

public class GridProductList extends BasePage {
    int productIndex=0;
    @FindBy(css = ".woocommerce-products-header__title")
    WebElement searchTitle;

    @FindBy(xpath = "//div[@class='ast-woocommerce-container']")
    List<WebElement> productList;


    @FindBy(xpath="//div[@class='ast-woocommerce-container']/ul/li/div[@class='astra-shop-summary-wrap']/a[2]/following-sibling::a")
    WebElement viewCart;

    public GridProductList(WebDriver driver) {
        super(driver);
    }


    public void verifySearchedFor(String searchText){
        addLog("Going to check if product search contains text",ITestResult.SUCCESS);
        Assert.assertTrue(searchTitle.getText().contains(searchText),"Search not match");
    }

    public GridProductList addProductToCart(String product){
        if(productList.size()==0){
            Assert.fail("Product list is empty");
        }

        try{
        for(WebElement element : productList){
            String text = element.findElement(By.xpath("//div[@class='astra-shop-summary-wrap']/a/h2")).getText();
            if(text.equals(product)){
                element.findElement(By.xpath("//div[@class='astra-shop-summary-wrap']/a[2]")).click();
                break;
            }
        }

       addLog("Product list found", ITestResult.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
        }
        return this;
    }

    public CartPage clickOnViewCartBelowProduct() {

        wait.until(ExpectedConditions.visibilityOf(viewCart)).click();
        addLog("View Cart button clicked", ITestResult.SUCCESS);
        /*Actions actions = new Actions(driver);
        actions.moveToElement(viewCart).click().perform();*/
        return PageFactory.initElements(driver, CartPage.class);
    }
}
