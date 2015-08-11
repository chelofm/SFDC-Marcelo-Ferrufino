package Tests;

import Pages.*;
import Pages.Account.AccountPage;
import Pages.Account.AddAccount;
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
    private final String accountName = "SeleniumExam1";

    @BeforeClass
    public void setUp(){
        //Precondition 1 - Login
        LoginPage loginPage = new LoginPage()
                .setUserName()
                .setPassword();

        mainPage = loginPage.clickLoginBtn();

        //Precondition 2 - Add Account
        AccountPage accountPage = mainPage.goToAccountPage();
        AddAccount addAccount = accountPage.clickNewBtn()
                                            .setAccountName(accountName);
        addAccount.clickSave();
    }

    @Test
    public void addOpportunity(){
        final String oppName = "Exam 3";
        final String stageOption = "Qualification";

        OpportunitiesPage opportunityPage = mainPage.goToOpportuniesPage();
        AddOpportunity newOpportunity = opportunityPage.clickNewBtn()
                                        .setOppName(oppName)
                                        .setCloseDate()
                                        .selectStage(stageOption)
                                        .selectAccount(accountName);
        oppDetails = newOpportunity.clickSave();

        Assert.assertEquals(oppDetails.getOppName(), oppName);
        Assert.assertEquals(oppDetails.getCloseDate(), "8/10/2015");
        Assert.assertEquals(oppDetails.getStage(), stageOption);
        Assert.assertEquals(oppDetails.getAccountName(), accountName);
    }

    @AfterMethod
    public void tearDown(){
        OpportunitiesPage oppHomePage = oppDetails.clickDeleteBtn();
    }
}
