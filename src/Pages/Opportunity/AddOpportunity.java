package Pages.Opportunity;

import Pages.Common.CommonLocatorsOperations;
import Pages.LookupPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Marcelo Ferrufino on 8/10/2015.
 */
public class AddOpportunity extends CommonLocatorsOperations {

    @FindBy (css = "input#opp3")
    @CacheLookup
    private WebElement oppNameTxt;

    @FindBy( css = "input#opp9")
    @CacheLookup
    private WebElement closeDateTxt;

   @FindBy( css = "select#opp11")
   @CacheLookup
   private WebElement stagePicklist;

   @FindBy( css = "img[title*='Account Name Lookup']")
   @CacheLookup
   private WebElement accountLookup;

    public AddOpportunity(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AddOpportunity setOppName(String oppName){
        wait.until(ExpectedConditions.visibilityOf(oppNameTxt));
        oppNameTxt.clear();
        oppNameTxt.sendKeys(oppName);
        return this;
    }

    public AddOpportunity setCloseDate(String closeDate){
        wait.until(ExpectedConditions.visibilityOf(closeDateTxt));
        closeDateTxt.clear();
        closeDateTxt.sendKeys(closeDate);
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
        LookupPage accountLookup = new LookupPage(driver);
        accountLookup.searchAccount(accountName);
        return this;
    }

    public OpportunityDetailsPage clickSave(){
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        saveBtn.click();
        return new OpportunityDetailsPage(driver);
    }
}
