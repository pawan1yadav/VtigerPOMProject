 package org.wvs.vtiger.tests;

import java.io.IOException;

import org.testng.annotations.Test;
import org.wvs.vtiger.common.BaseTest;
import org.wvs.vtiger.pages.AccountPage;
import org.wvs.vtiger.pages.CreateAccountPage;
import org.wvs.vtiger.pages.HomePage;
import org.wvs.vtiger.pages.LoginPage;
import org.wvs.vtiger.utilty.WebUtil;

public class TestCreateAccountPage extends BaseTest {
	
//	WebUtil wu= new WebUtil();
	@Test   
  public void test_001_AccountCreation() throws IOException {
//	    wu.launchBrowser("ch");
	    LoginPage loginPage=new LoginPage(wu);
	    loginPage.validLogin();
	    
		HomePage hmPage=new HomePage(wu);
	    hmPage.accountLandingPage();
		
		AccountPage accontPage = new AccountPage(wu);
		accontPage.searchIndividualAccountInfo();
	    accontPage.createAccountLandingPage();
		
		CreateAccountPage crtAccPg=new CreateAccountPage(wu);
		crtAccPg.validateCreateAccountPage();
		crtAccPg.enterAccountBasicInfo();
		crtAccPg.enterAccountMoreInfo();
		crtAccPg.saveAccount();
  }
}
