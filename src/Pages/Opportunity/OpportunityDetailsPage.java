package Pages.Opportunity;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by marcelo on 8/10/15.
 */
public class OpportunityDetailsPage {
    private WebDriver driver;
    private WebDriverWait wait;


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

    @FindBy(css = "input[name='del']")
    @CacheLookup
    private WebElement deleteBtn;

    public OpportunityDetailsPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
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

    public OpportunitiesPage clickDeleteBtn(){
        boolean responseDeletion = true;

        wait.until(ExpectedConditions.visibilityOf(deleteBtn));
        deleteBtn.click();
        Alert alert;

        try{
            alert = driver.switchTo().alert();

            if (responseDeletion){
                alert.accept();
            }
            alert.dismiss();
        }
        catch(WebDriverException e){
            System.out.println(e.fillInStackTrace());
        }
        return new OpportunitiesPage(driver);
    }

}
