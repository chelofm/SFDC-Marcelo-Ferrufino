package Pages.Account;

import Pages.Common.CommonLocatorsOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by marcelo on 8/11/15.
 */
public class AccountPage extends CommonLocatorsOperations {
//    private WebDriver driver;
//    private WebDriverWait wait;

    public AccountPage(WebDriver driver){
//        this.driver = driver;
//        wait = new WebDriverWait(driver, 15);
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AddAccount clickNewBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(newBtn));
        newBtn.click();
        return new AddAccount(driver);
    }

    public AccountDetailsPage selectAccount(String accountName){
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(accountName)));
        WebElement accountLink = driver.findElement(By.linkText(accountName));
        accountLink.click();
        return new AccountDetailsPage(driver);
    }

}
