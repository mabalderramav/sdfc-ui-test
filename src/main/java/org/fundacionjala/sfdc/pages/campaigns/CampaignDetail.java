package org.fundacionjala.sfdc.pages.campaigns;


import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Miguel.Pari on 6/24/2015.
 */

public class CampaignDetail extends DetailBase{


    //region Locators

    @FindBy(className = "pageDescription")
    @CacheLookup
    WebElement campaingNameLabel;

    @FindBy(name = "del")
    @CacheLookup
    WebElement deleteButton;

    @FindBy(id = "cpn1_ileinner")
    @CacheLookup
    WebElement campaignName;


    @FindBy(id = "cpn16_chkbox")
    @CacheLookup
    WebElement checkStatus;


    @FindBy(name = "edit")
    @CacheLookup
    WebElement editButton;
    //endregion


    public String getCampaingNameLabel() {
        return CommonActions.getText(campaingNameLabel);
    }

    public CampaignsHome clickDeleteButton() {
        CommonActions.clickElement(deleteButton);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
        return new CampaignsHome();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public CampaignForm clickEditButton() {
        CommonActions.clickElement(editButton);
        return new CampaignForm();
    }

    public TabBar toTabBar() {
        return new TabBar();
    }

    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap();
        strategyMap.put("campaignName", this::getCampaignName);
        strategyMap.put("active", this::getCheckStatus);
    //    strategyMap.put("typeDropDown", this::getSelectedValue);
    //    strategyMap.put("statusDropDown", this::getSelectedStatus);
    //    strategyMap.put("startDate", this::getStartDate);
     //   strategyMap.put("endDate", this::getEndDate);
     //   strategyMap.put("revenue", this::getRevenauValue);
        return strategyMap;
    }

    private String getCheckStatus() {
        return checkStatus.getAttribute("title");
    }

    public String getCampaignName() {
        String value=campaignName.getText();
          String cosa=value.substring(0,value.indexOf(" "));
        String alternativa=value.replace(value.substring(value.indexOf("[")+1,value.indexOf("]"))," ");
        return  cosa;
    }
}
