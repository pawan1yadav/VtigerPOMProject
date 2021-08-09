package org.wvs.vtiger.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.wvs.vtiger.pages.AccountDetailPage;
import org.wvs.vtiger.pages.AccountPage;
import org.wvs.vtiger.pages.CreateAccountPage;
import org.wvs.vtiger.pages.HomePage;
import org.wvs.vtiger.pages.LoginPage;
import org.wvs.vtiger.utilty.WebUtil;

public class TestScripts {

	WebUtil wu= new WebUtil();
	
    
	 @BeforeMethod
	    public void beforeClass() {
			wu.launchBrowser("ch");	
		}
	    
	    @AfterMethod
	    public void AfterClass() {
			wu.closeCurrentBrowser();
		}
	   
		
	
	@Test(priority=1,groups= {"smoke"})
	public  void test001Loginpage() {
		
		LoginPage loginPage=new LoginPage(wu);
		loginPage.verifyUserName();
		loginPage.verifyPassword();
		loginPage.verifyLoginButton();
	    loginPage.validLogin();	
}
	
	@Test(priority=2,groups= {"regression"})
	public  void test001verifyHomepage() {

		
		LoginPage loginPage=new LoginPage(wu);
		loginPage.validLogin();

		HomePage hmPage=new HomePage(wu);
		hmPage.validateHomePage();
		hmPage.accountLandingPage();

	}
	
	@Test(priority=3,groups= {"smoke"})
	public  void test001verifyAccountpage() {
		
		
		LoginPage loginPage=new LoginPage(wu);
	    loginPage.validLogin();
	    
		HomePage hmPage=new HomePage(wu);
		hmPage.validateHomePage();
		hmPage.accountLandingPage();
		
		AccountPage accontPage=new AccountPage(wu);
		accontPage.searchIndividualAccountInfo();
		accontPage.deleteAccount();
		accontPage.createAccountLandingPage();
		
}
	@Test(priority=4,groups= {"regression"})   
	  public void test_001_AccountCreation() throws IOException {
		 
		    LoginPage loginPage=new LoginPage(wu);
		    loginPage.validLogin();
		    
			HomePage hmPage=new HomePage(wu);
			hmPage.validateHomePage();
			hmPage.accountLandingPage();
			
			AccountPage accontPage=new AccountPage(wu);
			accontPage.validateAccountPage();
			accontPage.searchIndividualAccountInfo();
			accontPage.deleteAccount();
			accontPage.createAccountLandingPage();
			
			CreateAccountPage crtAccPg=new CreateAccountPage(wu);
			crtAccPg.validateCreateAccountPage();
			crtAccPg.enterAccountBasicInfo();
			crtAccPg.enterAccountMoreInfo();
			crtAccPg.saveAccount();
	  }
	
	@Test(priority=5, enabled=false ,groups= {"snaity"})  
	  public void test_001_AccountDetailPage() throws IOException {
		  HomePage hmPage=new HomePage(wu);
			hmPage.validateHomePage();
			hmPage.accountLandingPage();
			
			AccountPage accontPage=new AccountPage(wu);
			accontPage.validateAccountPage();
			accontPage.deleteAccount();
			accontPage.searchIndividualAccountInfo();
			
			accontPage.createAccountLandingPage();
			
			CreateAccountPage crtAccPg=new CreateAccountPage(wu);
			crtAccPg.validateCreateAccountPage();
			crtAccPg.enterAccountBasicInfo();
			//crtAccPg.enterAccountMoreInfo();
			crtAccPg.saveAccount();
			
			AccountDetailPage accDetail=new AccountDetailPage(wu);
			accDetail.validateAccountDetailPage();
	  }
}
