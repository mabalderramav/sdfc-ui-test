package org.fundacionjala.sfdc.pages;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.accounts.AccountAbstractPage;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.campaigns.Campaigns;
import org.fundacionjala.sfdc.pages.cases.Cases;
import org.fundacionjala.sfdc.pages.chatter.ChatterAbstractPage;
import org.fundacionjala.sfdc.pages.contacts.ContactHome;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityHome;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.fundacionjala.sfdc.pages.leads.Lead;
import org.fundacionjala.sfdc.pages.products.ProductHome;

/**
 * Created by Miguel.Pari on 6/17/2015.
 */
public class TabBar extends AbstractBasePage{
    //region Locators

    @FindBy(xpath = "//*[@id='Campaign_Tab']/*[contains(.,'Campaigns')]")
    @CacheLookup
    WebElement CampaignsTab;

    @FindBy(xpath = "//a[@title='Leads Tab']")
    @CacheLookup
    WebElement LeadTab;


    //endregion

    @FindBy(linkText = "Chatter")
    @CacheLookup
    private WebElement chatterTab;

    @FindBy(linkText = "Contacts")
    @CacheLookup
    private WebElement contactsTab;


    @FindBy(linkText = "Products")
    @CacheLookup
    private WebElement productsTab;

    @FindBy(linkText = "Accounts")
    @CacheLookup
    private WebElement accountTab;

    @FindBy(linkText = "Opportunities")
    @CacheLookup
    private WebElement opportunitiesTab;

    @FindBy(id = "Case_Tab")
    @CacheLookup
    private WebElement casesTab;

    public Campaigns clickCampaigns() {
        CommonActions.clickElement(CampaignsTab);
        return new Campaigns();
    }

    public ContactHome clickOnContactsHome() {
        CommonActions.clickElement(contactsTab);
        return new ContactHome();
    }
    public ProductHome clickOnProductsHome() {
        CommonActions.clickElement(productsTab);
        return new ProductHome();
    }
    public OpportunityHome clickOnOpportunitiesHome() {
        CommonActions.clickElement(opportunitiesTab);
        return new OpportunityHome();
    }
    public AccountAbstractPage clickOnAccountsHome() {
        CommonActions.clickElement(accountTab);
        return new AccountAbstractPage();
    }
	
	public Lead clickLead() {
        CommonActions.clickElement(LeadTab);

        return new Lead();
    }

	public ChatterAbstractPage clickOnChatterTab() {
		CommonActions.clickElement(chatterTab);
		return new ChatterAbstractPage();
	}

    public Cases clickOnCasesTab(){
        CommonActions.clickElement(casesTab);
        return new Cases();
    }
}
