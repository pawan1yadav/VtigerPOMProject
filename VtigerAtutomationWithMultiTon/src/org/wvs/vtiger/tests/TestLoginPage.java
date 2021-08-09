package org.wvs.vtiger.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.wvs.vtiger.common.BaseTest;
import org.wvs.vtiger.pages.LoginPage;
import org.wvs.vtiger.utilty.WebUtil;



public class TestLoginPage extends BaseTest {
	
//	private WebUtil wu;
//    
//    public TestLoginPage(WebUtil wu) {
//    	this.wu=wu;
//	}
//	
	
	@Test
	public  void test001Loginpage() {
		
		LoginPage loginPage=new LoginPage(wu);
		loginPage.verifyUserName();
		loginPage.verifyPassword();
		loginPage.verifyLoginButton();
	    loginPage.validLogin();
	    loginPage.logOut();
}
	
//	@Test
//	public  void test002Loginpage() {
//	
//		LoginPage loginPage=new LoginPage(wu);
//		loginPage.invalidLogin();
//		wu.takeScreenShot("myscreenshot");
//	    
//	
//}
//	@Test
//	public  void test003Loginpage() {
//		LoginPage loginPage=new LoginPage(wu);
//		loginPage.loginWithInCorrectPassword();
//}
	
}