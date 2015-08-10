package Tests;

import Pages.LoginPage;
import Pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by marcelo on 8/5/15.
 */
public class TestLogin {

    @Test
    public void testLoginSalesforce(){
        LoginPage loginPage = new LoginPage()
                                    .setUserName()
                                    .setPassword();

        MainPage mainPage = loginPage.clickLoginBtn();

        Assert.assertEquals(mainPage.getHomeLinkText(), "Home");
    }
}
