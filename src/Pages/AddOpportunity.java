package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Marcelo Ferrufino on 8/10/2015.
 */
public class AddOpportunity {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy (css = "input#opp3")
    @CacheLookup
    private WebElement oppNameTxt;

    @FindBy( css = "a[href*='insertDate']")
    @CacheLookup
    private WebElement dateLink;

   @FindBy( css = "select#opp11")
   @CacheLookup
   private WebElement stagePicklist;

   @FindBy( css = "img[title*='Account Name Lookup']")
   @CacheLookup
   private WebElement accountLookup;

    @FindBy(css = "input[name='save']")
    @CacheLookup
    private WebElement saveBtn;

    public AddOpportunity(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public AddOpportunity setOppName(String oppName){
        wait.until(ExpectedConditions.visibilityOf(oppNameTxt));
        oppNameTxt.sendKeys(oppName);
        return this;
    }

    public AddOpportunity setCloseDate(){
        wait.until(ExpectedConditions.elementToBeClickable(dateLink));
        dateLink.click();
        return this;
    }

    public AddOpportunity selectStage(String option){
        wait.until(ExpectedConditions.visibilityOf(stagePicklist));
        Select stageSelect = new Select(stagePicklist);
        stageSelect.selectByValue(option);
        return this;
    }

    public AddOpportunity selectAccount(String accountName){
        wait.until(ExpectedConditions.elementToBeClickable(accountLookup));
        accountLookup.click();
        return this;
    }

    public AddOpportunity clickSave(){
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        saveBtn.click();
        return this;
    }
}
