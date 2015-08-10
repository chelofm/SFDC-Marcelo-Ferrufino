package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Marcelo Ferrufino on 8/10/2015.
 */
public class TestAddOportunity {

    private MainPage mainPage;

    @BeforeClass
    public void setUp(){
        LoginPage loginPage = new LoginPage()
                .setUserName()
                .setPassword();

        mainPage = loginPage.clickLoginBtn();
    }

    @Test
    public void addOpportunity(){
        OpportunitiesPage opportunityPage = mainPage.goToOpportuniesPage();
        AddOpportunity newOpportunity = opportunityPage.clickNewBtn()
                                        .setOppName("Exam 1")
                                        .setCloseDate()
                                        .selectStage("Qualification")
                                        .clickSave();

    }
}
