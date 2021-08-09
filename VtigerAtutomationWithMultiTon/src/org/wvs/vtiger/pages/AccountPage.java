package org.wvs.vtiger.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.wvs.vtiger.common.BasePage;
import org.wvs.vtiger.utilty.WebUtil;


public class AccountPage extends BasePage {

	@FindBys(@FindBy(xpath="//table[@class='lvt small']//td[2]"))
	public List<WebElement> weRowColl;

	@FindBy(xpath ="//img[@alt='Create Account...']")
	public WebElement createAccount ;

	@FindBy(xpath ="(//input[@value='Delete'] )[2]")
	public WebElement deleteAcc ;

	@FindBy(xpath ="//input[@name='search_text']")
	public WebElement search_Acc_ED ;

	@FindBy(xpath ="//select[@id='bas_searchfield']")
	public WebElement select_Drpdown ;

	@FindBy(xpath ="//input[@value=' Search Now ']")
	public WebElement search_BT;
	
	 public WebElement getCreateAccBtnWE() {
    	 return createAccount;
     }
     
     public List<WebElement> getRowListWE() {
    	 return weRowColl;
     }
     
     public WebElement getDeleteBtnWE() {
    	 return deleteAcc;
     }
     public WebElement getSearchAccWE() {
    	 return search_Acc_ED;
     }
     
     public WebElement getDropdownWE() {
    	 return select_Drpdown;
     }
     
     public WebElement getSearchBtnWE() {
    	 return search_BT;
     }

     private WebUtil wu;
     
     public AccountPage(WebUtil wu) {
    	 super(wu);
     	this.wu=wu;
 		PageFactory.initElements(wu.getDriver(), this);
 	}

	public void createAccountLandingPage() {
		wu.click(createAccount, "Create Account btn ");
		
	}

	public void deleteAccount() {
		int rowNum=wu.getRowNumByRowId(weRowColl, "ACC6");

		WebElement weObj=wu.getElement("//table[@class='lvt small']//tr["+rowNum+"]//td");
		wu.click(weObj, "checkbox");
		wu.click(deleteAcc, "Delete Button");
		wu.alertPopupAccept();
	
      }
	
      public void searchIndividualAccountInfo() {
		wu.selectByVisibleText(select_Drpdown, "Account No", "ListBox");
		wu.sendKeys(search_Acc_ED, "ACC2", "Search box");
		wu.click(search_BT, "Search Now");
		
     }
      
      public void validateAccountPage() {
    	  wu.verifyEnabled(select_Drpdown, "Dropdown_ListBox");
    	  wu.verifyEnabled(search_Acc_ED, "Search box");
    	  wu.verifyEnabled(search_BT, "Search Now button");
      }

	public void editAccountLandingPage() {

	}
	
		
}
