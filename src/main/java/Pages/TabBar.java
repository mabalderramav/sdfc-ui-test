package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Framework.CommonActions;
import Pages.Accounts.AccountAbstractPage;
import Pages.Base.AbstractBasePage;
import Pages.Campaigns.CampaignsHome;
import Pages.Chatter.ChatterAbstractPage;
import Pages.Contacts.ContactsAbstractPage;
import Pages.Leads.LeadAbstractPagePage;
import Pages.Opportunities.OpportunitiesAbstractPage;
import Pages.Products.ProductsAbstractPage;

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
        CommonActions.click(CampaignsTab);
        return new CampaignsHome();
    }

    public ContactsAbstractPage clickOnContactsHome() {
        CommonActions.click(contactsTab);
        return new ContactsAbstractPage();
    }
    public ProductsAbstractPage clickOnProductsHome() {
        CommonActions.click(productsTab);
        return new ProductsAbstractPage();
    }
    public OpportunitiesAbstractPage clickOnOpportunitiesHome() {
        CommonActions.click(opportunitiesTab);
        return new OpportunitiesAbstractPage();
    }
    public AccountAbstractPage clickOnAccountsHome() {
        CommonActions.click(accountTab);
        return new AccountAbstractPage();
    }
	
	public LeadAbstractPagePage clickLead() {
        CommonActions.click(LeadTab);

        return new LeadAbstractPagePage();
    }

	public ChatterAbstractPage clickOnChatterTab() {
		CommonActions.click(chatterTab);
		return new ChatterAbstractPage();
	}
}
