package org.fundacionjala.sfdc.framework.utils;

import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.accounts.AccountHome;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.fundacionjala.sfdc.pages.cases.CasesHome;
import org.fundacionjala.sfdc.pages.chatter.ChatterAbstractPage;
import org.fundacionjala.sfdc.pages.contacts.ContactHome;
import org.fundacionjala.sfdc.pages.contracts.ContractHome;
import org.fundacionjala.sfdc.pages.leads.LeadHome;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityHome;
import org.fundacionjala.sfdc.pages.products.ProductHome;

/**
 * This class is in charge to take us to oyr respective page.
 */
public final class Navigator {
    /**
     * Constructor.
     */
    private Navigator() {
    }

    /**
     * Take us to chatter page.
     *
     * @return ChatterAbstractPage.
     */
    public static ChatterAbstractPage goToChatter() {
        goToNavigator().clickOnChatterTab();
        return new ChatterAbstractPage();
    }

    /**
     * Take us to Campaign page.
     *
     * @return CampaignsHome.
     */
    public static CampaignsHome goToCampaign() {
        goToNavigator().clickCampaigns();
        return new CampaignsHome();
    }

    /**
     * Take us to Account page.
     *
     * @return AccountHome.
     */
    public static AccountHome goToAccount() {
        goToNavigator().clickOnAccountsHome();
        return new AccountHome();
    }

    /**
     * Take us to Cases page.
     *
     * @return CasesHome.
     */
    public static CasesHome goToCases() {
        goToNavigator().clickOnCasesHome();
        return new CasesHome();
    }

    /**
     * Take us to Contact page.
     *
     * @return ContactHome.
     */
    public static ContactHome goToContact() {
        goToNavigator().clickOnContactsHome();
        return new ContactHome();
    }

    /**
     * Take us to Contract page.
     *
     * @return ContractHome.
     */
    public static ContractHome goToContract() {
        goToNavigator().clickOnContractHome();
        return new ContractHome();
    }

    /**
     * Take us to Lead page.
     *
     * @return LeadHome.
     */
    public static LeadHome goToLead() {
        goToNavigator().clickLead();
        return new LeadHome();
    }

    /**
     * Take us to Opportunity page.
     *
     * @return OpportunityHome.
     */
    public static OpportunityHome goToOportunity() {
        goToNavigator().clickOnOpportunitiesHome();
        return new OpportunityHome();
    }

    /**
     * Take us to Product page.
     *
     * @return ProductHome.
     */
    public static ProductHome goToProduct() {
        goToNavigator().clickOnProductsHome();
        return new ProductHome();
    }

    /**
     * Take us to main page.
     *
     * @return Mainapp class.
     */
    private static TabBar goToNavigator() {
        MainApp mainApp = new MainApp();
        return mainApp.goToTabBar();
    }
}
