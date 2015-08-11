package Pages.Account;

import Pages.Common.CommonLocatorsOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by marcelo on 8/11/15.
 */
public class AccountDetailsPage extends CommonLocatorsOperations {
    private WebDriver driver;
    private WebDriverWait wait;

    public AccountDetailsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
