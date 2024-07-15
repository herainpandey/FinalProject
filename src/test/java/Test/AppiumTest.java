package Test;

import Base.MobileBase;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AppiumTest extends MobileBase {

    @Test(groups = {"regression"})
    public void fillForm() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul");

        driver.hideKeyboard();

        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();

        //Click on Dropdown Menu
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();

        //Scroll
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"));"));

        //Select Egypt
        driver.findElement(By.xpath("//android.widget.TextView[@text='Egypt']")).click();

       //Tap on lets shop button
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        Thread.sleep(3000);

    }



    @Test(groups = {"regression"})
    public void verifyToastMessageWhenUserNameNotPass() throws InterruptedException {
        Thread.sleep(4000);

        //Select Gender
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();

        //Click on Dropdown Menu
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();

        //Scroll
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"));"));

        //Select Egypt
        driver.findElement(By.xpath("//android.widget.TextView[@text='Egypt']")).click();

        //Tap on lets shop button
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");

        Assert.assertEquals(toastMessage,"Please enter your name");

        Thread.sleep(3000);

    }


    @Test(groups = {"smoke"})
    public void verifyAddingItemToCart() throws InterruptedException {
        Thread.sleep(4000);

        // driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]\n")).sendKeys("hello");
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul");

        //Select Gender
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();

        //Click on Dropdown Menu
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();

        //Scroll
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"));"));

        //Select Egypt
        driver.findElement(By.xpath("//android.widget.TextView[@text='Egypt']")).click();

        //Tap on lets shop button
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();


        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));

        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        String productToClick = "Jordan 6 Rings";
        for(int i=0; i< productCount; i++){
            String product = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if(product.equals(productToClick)){
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                break;
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        Thread.sleep(3000);
        //driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.androidsample.generalstore:id/appbar_btn_cart']")).click();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }


}
