package org.wvs.vtiger.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.wvs.vtiger.common.BasePage;
import org.wvs.vtiger.utilty.WebUtil;

public class AccountDetailPage extends BasePage {
	
	
	@FindBy(xpath="//span[@id='dtlview_Account Name']")
	private WebElement accNameInfo;
	
	public WebElement getAccounNameWe() {
		return accNameInfo;
	}
	@FindBy(xpath="//span[@id='dtlview_Website']")
	private WebElement website_Info;
	
	public WebElement getWebSiteWe() {
		return website_Info;
	}
	
	@FindBy(xpath="//span[@id='dtlview_Phone']")
	private WebElement phone_Info;
	
	public WebElement getPhoneNumWe() {
		return phone_Info;
	}
	
	@FindBy(xpath="//span[@id='dtlview_Email']")
	private WebElement email_Info;
	
	public WebElement getEmailWe() {
		return email_Info;
	}
	
	@FindBy(xpath="//span[@id='dtlview_Ticker Symbol']")
	private WebElement tickerSymbol_info;
	
	public WebElement getTickerWe() {
		return tickerSymbol_info;
	}

	private WebUtil wu;
    
    public AccountDetailPage(WebUtil wu) {
    	super(wu);
    	this.wu=wu;
		PageFactory.initElements(wu.getDriver(), this);
	}
    
    
	
	public void validateAccountDetailPage() {
		wu.verifyText(getAccounNameWe(), "Yadav sunita", "Account Name");
		wu.verifyText(getWebSiteWe(), "gmail.com", "Account Name");
		wu.verifyText(getPhoneNumWe(), "2325567647", "Account Name");
		wu.verifyText(getEmailWe(), "abcd@gmail.com", "Account Name");
		wu.verifyText(getTickerWe(), "afff3344", "Account Name");
	}
	
}
