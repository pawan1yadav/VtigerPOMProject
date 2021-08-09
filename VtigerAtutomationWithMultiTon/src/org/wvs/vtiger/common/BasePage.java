package org.wvs.vtiger.common;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.wvs.vtiger.pages.LoginPage;
import org.wvs.vtiger.utilty.WebUtil;

public class BasePage{
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement weLogOut;

	@FindBy(xpath="//input[@name='selectall']")
	private WebElement selectTopCheckBox;
	
	@FindBys(@FindBy(xpath="//input[@name='selected_id']"))
	private List<WebElement> selectListCheckBox;
	
	@FindBy(xpath="//select[@id='qccombo']")
	private WebElement selectDropdown;
	
	@FindBys(@FindBy(xpath="//table[@class='lvt small']//td[2]"))
	public List<WebElement> weRowColl;
	
	@FindBy(xpath ="(//input[@value='Delete'])")
	public WebElement deleteAcc ;
	
	@FindBy(xpath ="//input[@name='search_text']")
	public WebElement search_Acc_ED ;

	@FindBy(xpath ="//select[@id='bas_searchfield']")
	public WebElement select_Drpdown ;

	@FindBy(xpath ="//input[@value=' Search Now ']")
	public WebElement search_BT;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBT;

	@FindBy(xpath="(//input[@title='Cancel [Alt+X]'])")
	private WebElement cancelBT;
	
	@FindBy(xpath="//img[contains(@title,'Create')]")
	private WebElement createButton;
	
	
 private WebUtil wu;
    
    public BasePage(WebUtil wu) {
    	this.wu=wu;
    PageFactory.initElements(wu.getDriver(), this);
	}

//    @BeforeMethod
//	public void beforeMethod(ITestResult result,Method method) {
//    	    
//		     LoginPage loginPage=new LoginPage(wu);
//		    loginPage.validLogin();
//		   String methName= method.getName();
//		    boolean b=result.isSuccess();
//		    if(b==true) {
//		    	wu.takeScreenShot(methName);
//		    }
//	}
    
    
    
//////// =================================///////////////////////
    
   
    
    public void clickOnCreateBtn() {
     wu.click(createButton, "Create Button"); 	
    }
   
	
	public void clickTopCheckBoxToCkeckAllCheckBox() {
		selectTopCheckBox.click();
		
		for(int i=0;i<selectListCheckBox.size();i++) {
			WebElement we=selectListCheckBox.get(i);
		
			if(we.isSelected()==true) {
				System.out.println("Check "+i);
			}
			else {
				System.out.println("Uncheck"+i);
			}
		}
		}

	public void clickAllCheckBoxToCheckTopCheckBox() {
		
		for(int i=0;i<selectListCheckBox.size();i++) {
			WebElement we=selectListCheckBox.get(i);
			we.click();
		}
	     if(selectTopCheckBox.isSelected()==true) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		} 
	}

	public void selectQuickCreateDropDown(String text) {
     wu.selectByVisibleText(selectDropdown, text, "Quick Create DropDown");
	}
	
	public void clickOnAnyCheckbox() {
		int rowNum=wu.getRowNumByRowId(weRowColl, "ACC6");

		WebElement weObj=wu.getElement("//table[@class='lvt small']//tr["+rowNum+"]//td");
		wu.click(weObj, "checkbox");
		
      }
	
	public void clicOnDeleteButton() {
		wu.click(deleteAcc, "Delete Button");
		wu.alertPopupAccept();
	}
	
	public void logOut() {
		wu.click(weLogOut, "Sign Out");
	}
	
	 public void searchIndividualInfoFromTable() {
			wu.selectByVisibleText(select_Drpdown, "Account No", "ListBox");
			wu.sendKeys(search_Acc_ED, "ACC2", "Search box");
			wu.click(search_BT, "Search Now");
			
	     }
	 public void clickOnSaveBtn() {
			wu.click(saveBT, "Save Button ");
}

		public void clickOnCancelBtn() {
			wu.click(cancelBT, "Cancel Button");
			}
		
	
}
