package org.wvs.vtiger.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.wvs.vtiger.common.BasePage;
import org.wvs.vtiger.utilty.WebUtil;


public class HomePage extends BasePage    {
	
	
	@FindBy(xpath="//a[text()='Sign Out']")
	public WebElement signOut;
	
	@FindBy(xpath="//a[text()='Marketing']")
	public WebElement marketing;
	
	@FindBy(xpath="//div[@class='drop_mnu'][2]//a[text()='Accounts']")
	public WebElement account;
	
	@FindBy(xpath="//a[text()='Home']")
	public WebElement home_LK;
	 
	@FindBy(xpath="//input[@value='Search...']")
	public WebElement searchBox_ED;
	
	@FindBy(xpath="//input[@value='Find']")
	public WebElement search_BT;
	
	
	  public WebElement getSignOutWE() {
	    	 return signOut;
	     }
	     
	     public WebElement getMarketingWE() {
	    	 return marketing;
	     }
	     
	     public WebElement getAccountLinkWE() {
	    	 return account;
	     }
	     
	    private WebUtil wu; 
	   public HomePage(WebUtil wu) {
		   super(wu);
		   this.wu=wu;
	    PageFactory.initElements(wu.getDriver(), this);
	    
	    	}
	   
	   public void  validateHomePage() {
		wu.verifyText(signOut, "Sign Out", "Sign Out");	
		wu.verifyText(home_LK, "Home", "Home");	
		wu.verifyEnabled(searchBox_ED, "Search Edit BOx");
		wu.verifyEnabled(search_BT, "Find button");
	} 
	
	public void accountLandingPage() {
	    wu.mouseOver(marketing);
		wu.click(account, "Account subLink");
	}
   
	
	
	
}
