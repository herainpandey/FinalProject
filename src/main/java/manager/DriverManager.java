package manager;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.function.Function;

public class DriverManager {

    private WebDriver driver;
    private static DriverManager instance = null;

    private DriverManager() {

    }


    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }



    /*public DriverManager setChromeDriver(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return this;

    }


    private static final Supplier<WebDriver> chromeSupplier = () -> {
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver();
    };

    private static final Supplier<WebDriver> remotechromeSupplier = () -> {
        System.out.println("I'm inside remote chrome supplier for chrome");

        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-dev-shm-usage");
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    };

    private static final Supplier<WebDriver> firefoxSupplier = () -> {
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver();
    };


    private static final Supplier<WebDriver> remotefirefoxSupplier = () -> {
        WebDriver driver;
        try {
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    };

    public DriverManager setFireFoxDriver(){
        FirefoxDriverManager.getInstance().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return this;
    }

   private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();


   static {
       MAP.put("chrome", chromeSupplier);
       MAP.put("firefox", firefoxSupplier);
       MAP.put("remotechrome", remotechromeSupplier);
       MAP.put("remotefirefox", remotefirefoxSupplier);
   }

    public  WebDriver getLocalDriver(String browser) {
        System.out.println("I'm trying to get browser for " + browser);
        return MAP.get(browser).get();
    }

    public  WebDriver getRemoteDriver(String browser) {
        System.out.println("I'm trying to get browser for " + browser);
        return MAP.get(browser).get();
    }
*/

    public  Function<String,WebDriver> getRemoteDriver = (browser) -> {
       WebDriver driver= null;
       if(browser.equals("chrome")){
           try {
               ChromeOptions options = new ChromeOptions();
               options.addArguments("--disable-dev-shm-usage");
               String remoteurl= "http://"+System.getProperty("selenium.grid.hubHost")+":4444/wd/hub";
               driver= new RemoteWebDriver(new URL(remoteurl), options);
           } catch (MalformedURLException e) {
               throw new RuntimeException(e);
           }
       }else if(browser.equals("firefox")){
           try {
               FirefoxOptions options = new FirefoxOptions();
               options.addArguments("--disable-dev-shm-usage");
               String remoteurl= "http://"+System.getProperty("selenium.grid.hubHost")+":4444/wd/hub";
               driver= new RemoteWebDriver(new URL(remoteurl), options);
           } catch (MalformedURLException e) {
               throw new RuntimeException(e);
           }
       }
       return driver;
    };


    public Function<String,WebDriver> getLocalDriver = (browser) -> {
        WebDriver driver= null;
        if(browser.equals("chrome")){
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }else if(browser.equals("firefox")){
            FirefoxDriverManager.getInstance().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        return driver;
    };
}
