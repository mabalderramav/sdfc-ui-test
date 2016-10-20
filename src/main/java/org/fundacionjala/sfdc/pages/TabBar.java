package org.fundacionjala.sfdc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.accounts.AccountAbstractPage;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.fundacionjala.sfdc.pages.chatter.ChatterAbstractPage;
import org.fundacionjala.sfdc.pages.contacts.ContactsAbstractPage;
import org.fundacionjala.sfdc.pages.leads.LeadAbstractPage;
import org.fundacionjala.sfdc.pages.opportunities.OpportunitiesAbstractPage;
import org.fundacionjala.sfdc.pages.products.ProductsAbstractPage;

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


    public CampaignsHome clickCampaigns() {
        CommonActions.clickElement(CampaignsTab);
        return new CampaignsHome();
    }

    public ContactsAbstractPage clickOnContactsHome() {
        CommonActions.clickElement(contactsTab);
        return new ContactsAbstractPage();
    }
    public ProductsAbstractPage clickOnProductsHome() {
        CommonActions.clickElement(productsTab);
        return new ProductsAbstractPage();
    }
    public OpportunitiesAbstractPage clickOnOpportunitiesHome() {
        CommonActions.clickElement(opportunitiesTab);
        return new OpportunitiesAbstractPage();
    }
    public AccountAbstractPage clickOnAccountsHome() {
        CommonActions.clickElement(accountTab);
        return new AccountAbstractPage();
    }
	
	public LeadAbstractPage clickLead() {
        CommonActions.clickElement(LeadTab);

        return new LeadAbstractPage();
    }

	public ChatterAbstractPage clickOnChatterTab() {
		CommonActions.clickElement(chatterTab);
		return new ChatterAbstractPage();
	}
}
