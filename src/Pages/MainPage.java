package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by marcelo on 8/5/15.
 */
public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Home")
    @CacheLookup
    private WebElement homeLink;

    @FindBy(linkText = "Opportunities")
    @CacheLookup
    private WebElement opportunitiesLink;

    public MainPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public String getHomeLinkText(){
        wait.until(ExpectedConditions.visibilityOf(homeLink));
        return homeLink.getText();
    }

    public OpportunitiesPage goToOpportuniesPage(){
        wait.until(ExpectedConditions.visibilityOf(homeLink));
        opportunitiesLink.click();
        return new OpportunitiesPage(driver);
    }

}
