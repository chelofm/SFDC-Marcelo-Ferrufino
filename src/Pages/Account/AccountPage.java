package Pages.Account;

import Pages.Common.CommonLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by marcelo on 8/11/15.
 */
public class AccountPage extends CommonLocators {
    private WebDriver driver;
    private WebDriverWait wait;

    public AccountPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public AddAccount clickNewBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(newBtn));
        newBtn.click();
        return new AddAccount(driver);
    }

}
