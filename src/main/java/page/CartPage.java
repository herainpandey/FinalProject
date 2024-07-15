package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageComponents.cartComponents.CartProdcutList;
import pageComponents.cartComponents.CartTotalSection;

public class CartPage {

    WebDriver driver;
    CartProdcutList cartProdcutList;
    CartTotalSection cartTotalSection;

    public CartPage(WebDriver driver){
     this.driver = driver;
     cartProdcutList  = PageFactory.initElements(driver,CartProdcutList.class);
     cartTotalSection  = PageFactory.initElements(driver,CartTotalSection.class);
    }


    public CartProdcutList getCartProdcutList() {
        return cartProdcutList;
    }

    public CartTotalSection getCartTotalSection() {
        return cartTotalSection;
    }
}
