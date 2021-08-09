package org.wvs.vtiger.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.wvs.vtiger.tests.TestLoginPage;
import org.wvs.vtiger.utilty.WebUtil;

import com.beust.jcommander.Parameter;

public class BaseTest {
	
	protected WebUtil wu;
	
  
	 @BeforeMethod
	 public void initialization() {
		 wu = new WebUtil();
		 wu.launchBrowser("ch");	
		}
	    
	  @AfterMethod
	    public void closeBrowser() {
			wu.quitAllInstance();
		}
	    
//	  @BeforeMethod
//		public void beforeMethod(ITestResult result,Method method) {
//	    	    
//			     LoginPage loginPage=new LoginPage(wu);
//			     loginPage.validLogin();
//			     String methName= method.getName();
//			     boolean b=result.isSuccess();
//			     if(b==true) {
//			     wu.takeScreenShot(methName);
//			    }
//		}
	    
		

}
