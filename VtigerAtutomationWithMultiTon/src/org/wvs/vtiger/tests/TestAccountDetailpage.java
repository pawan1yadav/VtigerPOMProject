package org.wvs.vtiger.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.wvs.vtiger.common.BaseTest;
import org.wvs.vtiger.pages.AccountDetailPage;
import org.wvs.vtiger.pages.AccountPage;
import org.wvs.vtiger.pages.CreateAccountPage;
import org.wvs.vtiger.pages.HomePage;
import org.wvs.vtiger.pages.LoginPage;
import org.wvs.vtiger.utilty.WebUtil;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
public class TestAccountDetailpage extends BaseTest {            //@BeforeSuite,@BeforeTest,@BeforeClass,@BeforeMethod,@Test,@BeforeMethod,@BeforeClass,@BeforeTest,@BeforeSuite
	//WebUtil wu= new WebUtil();   
	
//	@BeforeClass
//	public void beforeClass() {
//		wu.launchBrowser("ch");	
//	}
//	
//	@BeforeMethod
//	public void beforeMethod(ITestResult result,Method method) {
//		 LoginPage loginPage=new LoginPage(wu);
//		    loginPage.validLogin();
//		   String methName= method.getName();
//		    boolean b=result.isSuccess();
//		    if(b==true) {
//		    	wu.takeScreenShot(methName);
//		    }
//	}
//	
//	@AfterClass
//	public void AfterClass() {
//		 wu.closeCurrentBrowser();
//	}
//	
//	@AfterMethod
//	public void AfterMethod() {
//		
//	}
	
	@Test   
  public void test_001_AccountDetailPage() throws IOException {
		
		LoginPage loginPage=new LoginPage(wu);
		loginPage.validLogin();
	   
		HomePage hmPage=new HomePage(wu);
	    hmPage.accountLandingPage();
		
		AccountPage accontPage=new AccountPage(wu);
        accontPage.searchIndividualAccountInfo();
		accontPage.createAccountLandingPage();
		
		CreateAccountPage crtAccPg=new CreateAccountPage(wu);
		crtAccPg.enterAccountBasicInfo();
		//crtAccPg.enterAccountMoreInfo();
		crtAccPg.saveAccount();
		
		AccountDetailPage accDetail=new AccountDetailPage(wu);
		accDetail.validateAccountDetailPage();
  }
}
