package Pages;

import Framework.ReadCredentials;
import Framework.WebDriverManager;
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
public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String userName;
    private String password;

    @FindBy(css = "input#username")
    @CacheLookup
    private WebElement userNameTxt;

    @FindBy(css = "input#password")
    @CacheLookup
    private WebElement passwordTxt;

    @FindBy(css = "button#Login")
    @CacheLookup
    private WebElement loginBtn;

    public LoginPage(){
        driver = WebDriverManager.getInstance().getDriver();
        wait = new WebDriverWait(driver, 15);

        ReadCredentials credentials = new ReadCredentials();
        userName = credentials.getUserName();
        password = credentials.getPassword();

        PageFactory.initElements(driver, this);
    }

    public LoginPage setUserName(){
        wait.until(ExpectedConditions.visibilityOf(userNameTxt));
        userNameTxt.clear();
        userNameTxt.sendKeys(userName);
        return this;
    }

    public LoginPage setPassword(){
        wait.until(ExpectedConditions.visibilityOf(passwordTxt));
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public MainPage clickLoginBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
        return new MainPage(driver);
    }
}