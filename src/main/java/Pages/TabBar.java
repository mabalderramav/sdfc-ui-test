ckage Pages;

import Pages.Accounts.AccountsHome;
import Pages.Chatter.ChatterHome;
import Framework.BrowserManager;
import Framework.CommonActions;
import Pages.Campaigns.CampaignsHome;
import Pages.Contacts.ContactsHome;
import Pages.Leads.LeadHomePage;
import Pages.Opportunities.OpportunitiesHome;
import Pages.Products.ProductsHome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Miguel.Pari on 6/17/2015.
 */
public class TabBar {
    private WebDriver driver;
    private WebDriverWait wait;

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

    public TabBar()
    {
        driver = BrowserManager.getInstance().getDriver();
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public CampaignsHome clickCampaigns() {
        CommonActions.click(CampaignsTab);
        return new CampaignsHome(driver);
    }

    public ContactsHome clickOnContactsHome() {
        CommonActions.click(contactsTab);
        return new ContactsHome();
    }
    public ProductsHome clickOnProductsHome() {
        CommonActions.click(productsTab);
        return new ProductsHome();
    }
    public OpportunitiesHome clickOnOpportunitiesHome() {
        CommonActions.click(opportunitiesTab);
        return new OpportunitiesHome();
    }
    public AccountsHome clickOnAccountsHome() {
        CommonActions.click(accountsTab);
        return new AccountsHome();
    }
	
	public LeadHomePage clickLead() {
        CommonActions.click(LeadTab);

        return new LeadHomePage();
    }

	public ChatterHome clickOnChatterTab() {
		CommonActions.click(chatterTab);
		return new ChatterHome();
	}
}
