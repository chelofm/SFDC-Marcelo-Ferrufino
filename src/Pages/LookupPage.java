package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created by marcelo on 8/10/15.
 */
public class LookupPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "lksrch")
    @CacheLookup
    private WebElement searchTxt;

    @FindBy(name = "go")
    @CacheLookup
    private WebElement goBtn;

    public LookupPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }


    public void searchAccount(String accountName){
        Set<String> windows = driver.getWindowHandles();

        LinkedList<String> windowsArray = new LinkedList(windows);
        try {
            driver.switchTo().window(windowsArray.getLast());
            driver.switchTo().frame(driver.findElement(By.name("searchFrame")));

            searchTxt.sendKeys(accountName);

            goBtn.click();
            driver.switchTo().window(windowsArray.getLast());
            driver.switchTo().frame(driver.findElement(By.name("resultsFrame")));

            driver.findElement(By.linkText(accountName)).click();
            driver.switchTo().window(windowsArray.getFirst());
        }
        catch (WebDriverException e){
            System.out.println(e.fillInStackTrace());
        }
    }
}
