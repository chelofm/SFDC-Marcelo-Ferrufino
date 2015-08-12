package Pages.Account;

import Pages.Common.CommonLocatorsOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by marcelo on 8/11/15.
 */
public class AddAccount extends CommonLocatorsOperations {

    @FindBy(id = "acc2")
    @CacheLookup
    private WebElement accountNameTxt;

    public AddAccount(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public AddAccount setAccountName(String accountName){
        wait.until(ExpectedConditions.visibilityOf(accountNameTxt));
        accountNameTxt.clear();
        accountNameTxt.sendKeys(accountName);
        return this;
    }

    public void clickSave(){
        wait.until(ExpectedConditions.visibilityOf(saveBtn));
        saveBtn.click();
    }
}
