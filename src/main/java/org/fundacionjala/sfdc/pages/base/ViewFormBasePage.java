package org.fundacionjala.sfdc.pages.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ViewFormBasePage extends NewElementFormBasePage {
	
	private static final int TIMEOUT_NORMAL = 15;

    @FindBy(xpath = "//form[@id='editPage']")
    @CacheLookup
    public WebElement viewTitle;

    @FindBy(xpath = "//input[@data-uidsfdc='3']")
    @CacheLookup
    public WebElement saveButton;

    @FindBy(id = "fname")
    @CacheLookup
    public WebElement viewName;

    @FindBy(id = "devname")
    @CacheLookup
    public WebElement viewUniqueName;

    public ViewFormBasePage setViewName(String name) {
        viewName.clear();
        viewName.sendKeys(name);
        return this;
    }

    public ViewFormBasePage setUniqueViewName(String name) {
        viewUniqueName.clear();
        viewUniqueName.sendKeys(name);
        return this;
    }

    public ViewDetailsPage clickSaveView() {
        saveButton.click();
        return new ViewDetailsPage();
    }

	@Override
	protected Object clickSaveBtn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object clickSaveNewBtn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object clickCancelBtn() {
		// TODO Auto-generated method stub
		return null;
	}
}