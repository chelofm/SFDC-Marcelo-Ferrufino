package Pages.Opportunity;

import Pages.Common.CommonLocatorsOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Marcelo Ferrufino on 8/10/2015.
 */
public class OpportunitiesPage extends CommonLocatorsOperations {
//    private WebDriver driver;
//    private WebDriverWait wait;

    public OpportunitiesPage(WebDriver driver){
        super(driver);
//        this.driver = driver;
//        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public AddOpportunity clickNewBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(newBtn));
        newBtn.click();
        return new AddOpportunity(driver);
    }
}
