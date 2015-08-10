package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Marcelo Ferrufino on 8/10/2015.
 */
public class WebDriverManager {
    private static WebDriverManager instance;
    private WebDriver driver;
    private final String baseUrl = "https://login.salesforce.com";
    private WebDriverWait wait;
    private String browser = "Firefox";

    private WebDriverManager(){
        initializeWebDriver();
    }

    public static WebDriverManager getInstance(){
        if ( instance == null ){
            instance = new WebDriverManager();
        }
        return instance;
    }

    private void initializeWebDriver(){
        if ( browser.equalsIgnoreCase("Firefox") ){
            driver = new FirefoxDriver();
        }else if ( browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);
        driver.get(baseUrl);
    }

    public WebDriver getDriver() {
        return driver;
    }

}
