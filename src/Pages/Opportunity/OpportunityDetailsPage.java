package Pages.Opportunity;

import Pages.Common.CommonLocatorsOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by marcelo on 8/10/15.
 */
public class OpportunityDetailsPage extends CommonLocatorsOperations {
    @FindBy(id = "opp3_ileinner")
    @CacheLookup
    private WebElement oppNameContainer;

    @FindBy(id = "opp9_ileinner")
    @CacheLookup
    private WebElement closeDateContainer;

    @FindBy(id = "opp4_ileinner")
    @CacheLookup
    private WebElement accountNameContainer;

    @FindBy(id = "opp11_ileinner")
    @CacheLookup
    private WebElement stageContainer;

    public OpportunityDetailsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getOppName(){
        wait.until(ExpectedConditions.visibilityOf(oppNameContainer));
        return oppNameContainer.getText();
    }

    public String getCloseDate(){
        return closeDateContainer.getText();
    }

    public String getAccountName(){
        return accountNameContainer.getText();
    }

    public String getStage(){
        return stageContainer.getText();
    }

}
