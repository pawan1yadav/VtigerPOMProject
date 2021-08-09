package org.wvs.vtiger.tests;

import org.testng.annotations.Test;
import org.wvs.vtiger.common.BaseTest;
import org.wvs.vtiger.pages.HomePage;
import org.wvs.vtiger.pages.LoginPage;
import org.wvs.vtiger.utilty.WebUtil;

public class TestHomePage extends BaseTest {
//	WebUtil wu=new WebUtil();
	@Test
	public  void test001verifyHomepage() {
		
        LoginPage loginPage=new LoginPage(wu);
		loginPage.validLogin();

		HomePage hmPage=new HomePage(wu);
		hmPage.validateHomePage();
		hmPage.accountLandingPage();
		hmPage.logOut();

	}
}
