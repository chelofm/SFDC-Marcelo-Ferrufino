package Pages.Common;

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
 * Created by marcelo on 8/11/15.
 */
public abstract class CommonLocatorsOperations {
    protected WebDriver driver;
    protected WebDriverWait wait;

    //html components common in Salesforce pages
    @FindBy( name = "new")
    @CacheLookup
    protected WebElement newBtn;

    @FindBy(css = "input[name='save']")
    @CacheLookup
    protected WebElement saveBtn;

    @FindBy(css = "input[title='Delete']")
    @CacheLookup
    protected WebElement deleteBtn;

    public CommonLocatorsOperations(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void clickDeleteBtn(){
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
    }
}
