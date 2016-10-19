package org.fundacionjala.sfdc.pages.base;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ObjectFormPage extends NewElementFormBasePage {

    public ObjectFormPage clickSaveNewBtn() {
        wait.until(ExpectedConditions
                .visibilityOf(saveNewBtn));
        saveNewBtn.click();
        return new ObjectFormPage();
    }

    public ObjectDetailsPage clickSaveBtn() {
        wait.until(ExpectedConditions
                .visibilityOf(saveBtn));
        saveBtn.click();
        return new ObjectDetailsPage();
    }

	@Override
	protected Object clickCancelBtn() {
		// TODO Auto-generated method stub
		return null;
	}
}
