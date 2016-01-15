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

    private WebDriver driver;
    private WebDriverWait wait;

    public NewContactForm()
    {
        driver = BrowserManager.getInstance().getDriver();
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
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
/*
    public LookUpWindow clickReportTo() {
        CommonActions.click(reportToField);
        return new LookUpWindow(Driver);
    }*/

    public NewContactForm selectLeadSource(String item) {
        CommonActions.selectItem(leadSourceField, item);
        return this;
    }

    public ContactsProfile clickSaveButton() {
        CommonActions.click(saveBtn);
        return new ContactsProfile();
    }

//    public NewContactForm checkActiveCheckbox() {
//        CommonActions.check(ActiveCheckbox);
//        return this;
//    }

}
