package Pages.Contacts;

import Framework.BrowserManager;
import Framework.CommonActions;
import Pages.Contacts.ContactsProfile;
import Pages.LookUp.LookUpWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Gisela on 6/28/2015.
 */
public class NewContactForm {

    WebDriver Driver;
    WebDriverWait wait;

    //region Locators

//    @FindBy(id = "cpn1")
//    @CacheLookup
//    WebElement CampaingNameField;
//
//    @FindBy(id = "cpn16")
//    @CacheLookup
//    WebElement ActiveCheckbox;
//
//    @FindBy(id = "cpn2")
//    @CacheLookup
//    WebElement TypeDropdown;
//
//    @FindBy(id = "cpn5")
//    @CacheLookup
//    WebElement StartDateField;
//
//    @FindBy(id = "Parent")
//    @CacheLookup
//    WebElement ParentCampaing;
//
//    @FindBy(id = "Parent_lkwgt")
//    @CacheLookup
//    WebElement LookUpIcon;
//
//    @FindBy(id = "//*[@name='save']")
//    @CacheLookup
//    WebElement SaveButton;
//    //endregion

    //select[@id='name_salutationcon2']
    //@FindBy(xpath = "//select[@id='name_salutationcon2']")

    @FindBy(id = "name_salutationcon2")
    @CacheLookup
    WebElement firstNameCategoryField;

    //@FindBy(xpath = "//input[@id='name_firstcon2']")
    @FindBy(id = "name_firstcon2")
    @CacheLookup
    WebElement firstNameField;

   // @FindBy(xpath = "//input[@id='name_lastcon2']")
    @FindBy(id = "name_lastcon2")
    @CacheLookup
    WebElement lastNameField;

    //@FindBy(xpath = "//input[@id='con4']")
    @FindBy(id = "con4")
    @CacheLookup
    WebElement accountNameField;

    //@FindBy(xpath = "//input[@id='con5']")
    @FindBy(id = "con5")
    @CacheLookup
    WebElement titleField;

    //@FindBy(xpath = "//input[@id='con6']")
    @FindBy(id = "con6")
    @CacheLookup
    WebElement departmentField;

    //@FindBy(xpath = "//input[@data-uidsfdc='39']")
    @FindBy(id = "con7")
    @CacheLookup
    WebElement birthDateField;

    //@FindBy(xpath = "//input[@id='con8']")
    @FindBy(id = "con8")
    @CacheLookup
    WebElement reportToField;

    //@FindBy(xpath = "//select[@id='con9']")
    @FindBy(id = "con9")
    @CacheLookup
    WebElement leadSourceField;

    //@FindBy(xpath = "//input[@id='con10']")
    @FindBy(id = "con10")
    @CacheLookup
    WebElement phoneField;

//    //@FindBy(xpath = "//input[@id='con13']")
//    @FindBy(id = "con13")
//    @CacheLookup
//    WebElement homePhoneField;
//
//    @FindBy(xpath = "//input[@id='con12']")
//    @CacheLookup
//    WebElement mobileField;
//
//    @FindBy(xpath = "//input[@id='con14']")
//    @CacheLookup
//    WebElement otherPhoneField;
//
//    @FindBy(xpath = "//input[@id='con11']")
//    @CacheLookup
//    WebElement faxField;
//
//    @FindBy(xpath = "//input[@id='con15']")
//    @CacheLookup
//    WebElement emailField;
//
//    @FindBy(xpath = "//input[@id='con16']")
//    @CacheLookup
//    WebElement assistantField;
//
//    @FindBy(xpath = "//input[@id='con17']")
//    @CacheLookup
//    WebElement assistantPhoneField;
//
//    //Address Information
//    @FindBy(xpath = "//textarea[@id='con19street']")
//    @CacheLookup
//    WebElement mailingStreetField;
//
//    @FindBy(xpath = "//input[@id='con19city']")
//    @CacheLookup
//    WebElement mailingCityField;
//
//
//    @FindBy(xpath = "//input[@id='con19state']")
//    @CacheLookup
//    WebElement mailingStateProvinceField;
//
//    @FindBy(xpath = "//input[@id='con19zip']")
//    @CacheLookup
//    WebElement mailingZipPostalCodeField;
//
//    @FindBy(xpath = "//input[@id='con19country']")
//    @CacheLookup
//    WebElement mailingCountryField;
//
//    @FindBy(xpath = "//textarea[@id='con18street']")
//    @CacheLookup
//    WebElement otherStreetField;
//
//    @FindBy(xpath = "//input[@id='con18city']")
//    @CacheLookup
//    WebElement otherCityField;
//
//    @FindBy(xpath = "//input[@id='con18state']")
//    @CacheLookup
//    WebElement otherStateProvinceField;
//
//    @FindBy(xpath = "//input[@id='con18zip']")
//    @CacheLookup
//    WebElement otherZipPostalField;
//
//    @FindBy(xpath = "//input[@id='con18country']")
//    @CacheLookup
//    WebElement otherCountryField;
//
//    //Additional Information
//    @FindBy(xpath = "//input[@id='00N1a0000059AO4']")
//    @CacheLookup
//    WebElement languagesField;
//
//    @FindBy(xpath = "//select[@id='00N1a0000059AO5']")
//    @CacheLookup
//    WebElement levelField;
//
//    //Description Information
//    @FindBy(xpath = "//textarea[@cols='75']")
//    @CacheLookup
//    WebElement descriptionField;

    //Button
    @FindBy(xpath = "//input[@tabindex='31']")
   // @FindBy(id = "//*[@name='save']")
    @CacheLookup
    WebElement saveBtn;

    @FindBy(xpath = "//input[@tabindex='32']")
    @CacheLookup
    WebElement saveNewBtn;

    @FindBy(xpath = "//input[@tabindex='33']")
    @CacheLookup
    WebElement cancelBtn;

    public NewContactForm(WebDriver driver)
    {
        Driver = driver;
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
//
//    public void selectFirstNameCategory(String categoryFirstName) {
//        select = new Select(firstNameCategoryField);
//        select.selectByVisibleText(categoryFirstName);
//        // addButton.click();
//    }
    public NewContactForm selectFirstNameCategory(String item) {
        CommonActions.selectItem(firstNameCategoryField, item);
        return this;
    }

    public NewContactForm setContactNameField(String text) {
        CommonActions.setValue(firstNameField, text);
        return this;
    }

    public NewContactForm setLastName(String text) {
        CommonActions.setValue(lastNameField, text);
        return this;
    }

    public NewContactForm setAccountName(String text) {
        CommonActions.setValue(accountNameField, text);
        return this;
    }

    public NewContactForm setTitle(String text) {
        CommonActions.setValue(titleField, text);
        return this;
    }

    public NewContactForm setDepartment(String text) {
        CommonActions.setValue(departmentField, text);
        return this;
    }

    public NewContactForm setBirthDate(String date) {
        CommonActions.setValue(birthDateField, date);
        return this;
    }

    public LookUpWindow clickReportTo() {
        CommonActions.click(reportToField);
        return new LookUpWindow(Driver);
    }

    public NewContactForm selectLeadSource(String item) {
        CommonActions.selectItem(leadSourceField, item);
        return this;
    }

    public ContactsProfile clickSaveButton() {
        CommonActions.click(saveBtn);
        return new ContactsProfile(Driver);
    }

//    public NewContactForm checkActiveCheckbox() {
//        CommonActions.check(ActiveCheckbox);
//        return this;
//    }

}
