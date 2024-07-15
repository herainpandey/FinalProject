package pageComponents.cartComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartProdcutList {

    @FindBy(xpath = "//tr[contains(@class,'woocommerce-cart-form__cart-item')]")
    List<WebElement> productList;



    public void verifyProductAddedToCart(String product){
        boolean flag= false;
        for(WebElement element: productList){
            String text = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            if(text.equals(product)){
                flag = true;
            }
        }

        //Assert.assertTrue(flag,"Product not added to cart");
    }

}
