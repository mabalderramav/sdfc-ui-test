package Pages.Base;

import org.openqa.selenium.WebElement;

public class DetailsPage extends AbstractBasePage {

    // Method to find Elements by name or ID
    public String getFieldValue(WebElement field) {
        return field.getText();
    }
}