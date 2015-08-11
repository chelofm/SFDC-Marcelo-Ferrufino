package Tests;

import Pages.*;
import Pages.Opportunity.AddOpportunity;
import Pages.Opportunity.OpportunitiesPage;
import Pages.Opportunity.OpportunityDetailsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Marcelo Ferrufino on 8/10/2015.
 */
public class TestAddOpportunity {

    private MainPage mainPage;
    private OpportunityDetailsPage oppDetails;

    @BeforeClass
    public void setUp(){
        LoginPage loginPage = new LoginPage()
                .setUserName()
                .setPassword();

        mainPage = loginPage.clickLoginBtn();
    }

    @Test
    public void addOpportunity(){
        final String oppName = "Exam 3";
        final String stageOption = "Qualification";
        final String accountName = "SeleniumExam";

        OpportunitiesPage opportunityPage = mainPage.goToOpportuniesPage();
        AddOpportunity newOpportunity = opportunityPage.clickNewBtn()
                                        .setOppName(oppName)
                                        .setCloseDate()
                                        .selectStage(stageOption)
                                        .selectAccount(accountName);
        oppDetails = newOpportunity.clickSave();

        Assert.assertEquals(oppDetails.getOppName(), oppName);
        Assert.assertEquals(oppDetails.getCloseDate(), "08/10/2015");
        Assert.assertEquals(oppDetails.getStage(), stageOption);
        Assert.assertEquals(oppDetails.getAccountName(), accountName);
    }

    @AfterMethod
    public void tearDown(){
        OpportunitiesPage oppHomePage = oppDetails.clickDeleteBtn();
    }
}
