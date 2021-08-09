package org.wvs.vtiger.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.wvs.vtiger.common.BasePage;
import org.wvs.vtiger.utilty.WebUtil;

public class LoginPage extends BasePage  {
	     
	@FindBy(xpath= "//input[@name='user_name']")          // @cache Lookup by default=false
	private  WebElement weUser;
	
	@FindBy(xpath= "//input[@name='user_password']")
	private  WebElement wePassword;
	
	@FindBy(xpath=  "//input[@name='Login']")
	private  WebElement weLogin;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement weLogOut;
	

     public WebElement getUserNameWE() {
    	 return weUser;
     }
     
     public WebElement getPasswordWE() {
    	 return wePassword;
     }
     
     public WebElement getLoginBtnWE() {
    	 return weLogin;
     }
     
     public WebElement getLogOutWe() {
    	 return weLogOut;
     }
	 

     private WebUtil wu;
        
        public LoginPage(WebUtil wu) {
        	super(wu);
        	this.wu=wu;
           PageFactory.initElements(wu.getDriver(), this);
    		wu.loadConfig();
    	}
     
        
        
        public void verifyUserName() {
        	wu.verifyEnabled(getUserNameWE(), "Username TextBox");
        	wu.verifyVisibilty(getUserNameWE(), "Userename TextBox");
        }
        
     public void verifyPassword() {
	 wu.verifyEnabled(getPasswordWE(), "Password TextBox");
 	 wu.verifyVisibilty(getPasswordWE(), "Password TextBox");
        }
 
      public void verifyLoginButton() {
	 wu.verifyEnabled(weLogin, "Login button");
 	 wu.verifyVisibilty(weLogin, "Login button");
 }
	
	public void validLogin() {
	   wu.sendKeys(weUser, wu.getPropValue("username"), "UserName");
	   wu.sendKeys(wePassword, wu.getPropValue("password"), "userpwd");
	   wu.click(weLogin, "loginBtn");
     }
	
	public  void invalidLogin() {
		
		wu .sendKeys(weUser, "admin", "UserName");
		
		wu .click(weLogin, "loginBtn");
		
	}
	
public  void loginWithInCorrectPassword() {
		
		wu.sendKeys(weUser, "admin", "UserName");
		
		wu.sendKeys(wePassword, "admn", "userpwd");
		
		wu.click(weLogin, "loginBtn");
		
	}
	
	
}
