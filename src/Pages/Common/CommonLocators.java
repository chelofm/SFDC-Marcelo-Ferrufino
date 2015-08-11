package Pages.Common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by marcelo on 8/11/15.
 */
public abstract class CommonLocators {
    //html components common in Salesforce pages
    @FindBy( name = "new")
    @CacheLookup
    protected WebElement newBtn;

    @FindBy(css = "input[name='save']")
    @CacheLookup
    protected WebElement saveBtn;
}
