package org.wvs.vtiger.tests;

import org.testng.annotations.Test;
import org.wvs.vtiger.common.BaseTest;
import org.wvs.vtiger.pages.AccountPage;
import org.wvs.vtiger.pages.CreateAccountPage;
import org.wvs.vtiger.pages.HomePage;
import org.wvs.vtiger.pages.LoginPage;
import org.wvs.vtiger.utilty.WebUtil;

public class TestAccountPage extends BaseTest {
//	WebUtil wu=new WebUtil();
	@Test
	public  void test001verifyAccountpage() {
//		wu.launchBrowser("ch");
//		
		LoginPage loginPage=new LoginPage(wu);
	    loginPage.validLogin();
	    
		HomePage hmPage=new HomePage(wu);
		hmPage.accountLandingPage();
		
		AccountPage accontPage=new AccountPage(wu);
		accontPage.validateAccountPage();
		accontPage.searchIndividualAccountInfo();
		accontPage.deleteAccount();
		accontPage.createAccountLandingPage();
		
}
}