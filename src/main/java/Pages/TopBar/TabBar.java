package Pages.TopBar;

import Framework.BrowserManager;
import Framework.CommonActions;
import Pages.Campaigns.CampaignsHome;
import Pages.Contacts.ContactsHome;
import Pages.Opportunities.OpportunitiesHome;
import Pages.Products.ProductsHome;
import org.openqa.selenium.By;
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
    WebDriver Driver;
    WebDriverWait wait;

    //region Locators

    @FindBy(xpath = "//*[@id='Campaign_Tab']/*[contains(.,'Campaigns')]")
    @CacheLookup
    WebElement CampaignsTab;

    @FindBy(xpath = "//*[@id='Opportunity_Tab']/*[contains(.,'Opportunities')]")
    @CacheLookup
    WebElement opportunitiesTab;

    @FindBy(xpath = "//*[@id='Product2_Tab']/*[contains(.,'Products')]")
    @CacheLookup
    WebElement productsTab;

    //Contacts Locator
//    @FindBy(xpath = "//a[@href='/003/o']")
//    private WebElement contactsBtn;
    @FindBy(xpath = "//a[@href='/003/o']")
    @CacheLookup
    WebElement contactsTab;
    //endregion

    public TabBar(WebDriver driver)
    {
        Driver = driver;
        wait = BrowserManager.getInstance().Waiter;
        PageFactory.initElements(driver, this);
    }

    public CampaignsHome clickCampaigns() {
        CommonActions.click(CampaignsTab);
        return new CampaignsHome(Driver);
    }

    public ContactsHome clickContacts() {
        CommonActions.click(contactsTab);
        return new ContactsHome(Driver);
    }

    public OpportunitiesHome clickOpportunityTab() {
        CommonActions.click(opportunitiesTab);

        return new OpportunitiesHome(Driver);
    }

    public ProductsHome clickProductsTab() {
        CommonActions.click(productsTab);

        return new ProductsHome(Driver);
    }
}
