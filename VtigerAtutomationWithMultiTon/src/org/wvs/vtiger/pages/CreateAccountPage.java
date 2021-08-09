package org.wvs.vtiger.pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.wvs.vtiger.common.BasePage;
import org.wvs.vtiger.utilty.ExcelUtil;
import org.wvs.vtiger.utilty.WebUtil;

public class CreateAccountPage extends BasePage {
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement accName;

	@FindBy(xpath="//input[@name='phone']")
	private WebElement phNum;
	
	@FindBy(xpath="//input[@name='tickersymbol']")
	private WebElement tickerSymbol_ED;
	
	@FindBy(xpath="//input[@name='website']")
	private WebElement website_ED;
	
	@FindBy(xpath="//input[@name='email1']")
	private WebElement email_ED;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBT;

	@FindBy(xpath="(//input[@title='Cancel [Alt+X]'])")
	private WebElement cancelBT;

	@FindBy(xpath="//td[contains(@class,'SelectedCell')]//b[text()='More Information ']")
	private WebElement moreInfoSection;

	@FindBy(xpath="//input[@name='otherphone']")
	private WebElement otherPhNum;

	@FindBy(xpath="//input[@name='employees']")
	private WebElement employees_ED;
	
	@FindBy(xpath="//span[text()='Creating New Account']")
	private WebElement createAccountHeaderText;

	public WebElement getAccountNameWE() {
		return accName;
	}

	public WebElement getPhoneNumWE() {
		return phNum;
	}

	public WebElement getSaveBtnWE() {
		return saveBT;
	}
	public WebElement getCancelBtnWE() {
		return cancelBT;
	}

	public WebElement getOtherPhNumWE() {
		return otherPhNum;
	}

	public WebElement getEmployeesWE() {
		return employees_ED;
	}
     
	public WebElement getMoreInfoTabWE() {
		return moreInfoSection;
	}

	public WebElement getHeaderTextWE() {
		return createAccountHeaderText;
	}

	private WebUtil wu;
	 
	
    
    public CreateAccountPage(WebUtil wu) throws IOException {
    	super(wu);
    	this.wu=wu;
		PageFactory.initElements(wu.getDriver(), this);
	}
    
    public void validateCreateAccountPage() {
    	wu.verifyText(getHeaderTextWE(), "Creating New Account", "HeaderText");
//    	wu.verifyEnabled(accName, "Account name");
//    	wu.verifyEnabled(phNum, "PhoneNum");
//    	wu.verifyEnabled(website_ED, "WebSite");
//    	wu.verifyVisibilty(email_ED, "Email");
    }

	public void enterAccountBasicInfo() throws IOException {
		ExcelUtil xlData=new ExcelUtil();
		//Map<String,String> testData=xlData.getTestCaseData("enterAccountBasicInfo");	
		Map<String,String> testData=xlData.getPageData("enterAccountBasicInfo_Acc_001");
		String acName=testData.get("AccountName_ED");
		System.out.println(acName);
		wu.sendKeys(accName,acName,"AccountName");
		wu.sendKeys(phNum, testData.get("Phone_ED"), "Phone Number");
		wu.sendKeys(website_ED, testData.get("Website_ED"), "WebSite");
		wu.sendKeys(tickerSymbol_ED, testData.get("TickerSymbol_ED"), "Ticker Symbol");
		wu.sendKeys(email_ED, testData.get("Email_ID"), "Email");
		
	}

	public void enterAccountMoreInfo() {
		wu.click(moreInfoSection, "More Info Tab");
		wu.sendKeys(otherPhNum, "35646722343", "Other PhoneNum");
		wu.sendKeys(employees_ED, "", "Employees");
       
	}

	public void saveAccount() {
		wu.click(saveBT, "Save Button ");
		
	}

	public void cancelAccount() {
		wu.click(cancelBT, "Cancel Button");
		
	}
	
	

}
