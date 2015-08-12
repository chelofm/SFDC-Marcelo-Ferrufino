package Tests;

import Pages.*;
import Pages.Account.AccountDetailsPage;
import Pages.Account.AccountPage;
import Pages.Account.AddAccount;
import Pages.Opportunity.AddOpportunity;
import Pages.Opportunity.OpportunitiesPage;
import Pages.Opportunity.OpportunityDetailsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Marcelo Ferrufino on 8/10/2015.
 */
public class TestAddOpportunity {

    private MainPage mainPage;
    private OpportunityDetailsPage oppDetails;
    private AccountPage accountPage;
    private final String accountName = "SeleniumExam1";

    @BeforeClass
    public void setUp(){
        //Precondition 1 - Login
        LoginPage loginPage = new LoginPage()
                .setUserName()
                .setPassword();

        mainPage = loginPage.clickLoginBtn();

        //Precondition 2 - Add Account
        accountPage = mainPage.goToAccountPage();
        AddAccount addAccount = accountPage.clickNewBtn()
                                            .setAccountName(accountName);
        addAccount.clickSave();
    }

    @Test
    public void addOpportunity(){
        final String oppName = "Exam 3";
        final String stageOption = "Qualification";
        final String closeDate = "8/11/2015";

        OpportunitiesPage opportunityPage = mainPage.goToOpportuniesPage();
        AddOpportunity newOpportunity = opportunityPage.clickNewBtn()
                                        .setOppName(oppName)
                                        .setCloseDate(closeDate)
                                        .selectStage(stageOption)
                                        .selectAccount(accountName);
        oppDetails = newOpportunity.clickSave();

        Assert.assertEquals(oppDetails.getOppName(), oppName);
        Assert.assertEquals(oppDetails.getCloseDate(), closeDate);
        Assert.assertEquals(oppDetails.getStage(), stageOption);
        Assert.assertEquals(oppDetails.getAccountName(), accountName);
    }

    @AfterClass
    public void tearDown(){
        oppDetails.clickDeleteBtn();
        AccountDetailsPage accountDetailsPage = accountPage.selectAccount(accountName);
        accountDetailsPage.clickDeleteBtn();

        oppDetails.getDriver().quit();
    }
}
