package org.wvs.vtiger.utilty;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.Copies;
import javax.swing.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;

public class WebUtil {
	
	private WebDriver driver;
	private Properties propObj;
	private  Properties orProp;
 
	public  void launchBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("ch")) {
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase("ff")) {
			driver=new FirefoxDriver();
			System.setProperty("webdriver.gecho.driver", "Drivers\\gechodriver.exe");
		}else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "");
			driver=new InternetExplorerDriver();
		}else {
			System.out.println("Browser name is wrong");
		}
		openUrl("http://localhost:8888/");
	}
	
	public void logOut(WebElement we,String weName ) {
		click(we, weName);
	}
	
	public Properties loadProperties(String filePath) {
		 propObj=new Properties();
		 File propfile=new File(filePath);
		InputStream fis=null;
		try {
			fis = new FileInputStream(propfile);
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		}
		try {
			propObj.load(fis);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		setOR(propObj);
		return propObj;
	}
	
   public String getOrPropFileName(Class<?> object) {
	      String orFileName=object.getName();
	      orFileName.replaceAll("\\.", "/");
	      orFileName=orFileName.replaceAll("pages", "properties")+".properties";
	      return "src"+orFileName;
	      }
   
	private Properties mergePropertiesByUsingPutAll(Properties property1, Properties property2) {
		Properties mergedProperties=new Properties();
		mergedProperties.putAll(property1);
		mergedProperties.putAll(property2);
		return mergedProperties;
	}
	
	public void setOR(Properties propOR) {
		if(this.orProp==null) {
			this.orProp=propOR;
		}else {
			this.orProp=mergePropertiesByUsingPutAll(this.orProp, propOR);
		}
	}

////////////////////////================================================	////////////////////////////
	
	
	public String getPropValue(String keyName) {
		if(propObj==null) {
			loadConfig();
		}
		String propVal=propObj.getProperty(keyName);
		return propVal;
	}
	
	public void loadConfig() {
		 propObj=new Properties();
		 File propfile=new File("config.properties");
		InputStream fis=null;
		try {
			fis = new FileInputStream(propfile);
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		}
		try {
			propObj.load(fis);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
////////////////////////================================================	////////////////////////////

//	private  static WebUtil wuObj;
//	
//	public static WebUtil getObject() {
//		if(wuObj==null) {
//			wuObj=new WebUtil();
//		 }
//		return wuObj; 
//	}
//	
//	private WebUtil() {
//	}

	public WebDriver getDriver() {
		return driver;
	}
	
	

	public  void alertPopupAccept() {
		Alert alrtObj=driver.switchTo().alert();
		alrtObj.accept();
	}

	public  void alertPopupDismiss() {
		Alert alrtObj=driver.switchTo().alert();
		alrtObj.dismiss();
	}

	public  void openUrl(String url) {
		driver.get(url);
	}
	
	public void openLoginPage() {
		launchBrowser("ch");
		openUrl("http://localhost:8888/");
	}
	public  WebElement getElement(String locator) {
		WebElement we=driver.findElement(By.xpath(locator));
		return we;
	}

	public List<WebElement> getElements(String locator) {
		List<WebElement> weList=driver.findElements(By.xpath(locator));
		return weList;
	}

	public  void click(WebElement we, String elementName) {
		if(we.isDisplayed()) {
			if(we.isEnabled()) {
				we.click();
				System.out.println(elementName+"  clicked suceesfully");
			}
			else {
				System.out.println(elementName+"is displaying on webPage but not enabled");
			}
		}
		else {
			System.out.println(elementName+"is not displaying on webPage");
		}

	}

	public void quitAllInstance() {
		driver.quit();
	}

	public  void selectByIndex(WebElement we, int index, String weName) {
		if(we.isDisplayed()) {
			if(we.isEnabled()) {
				Select selObj=new Select(we);
				selObj.selectByIndex(index);
			}
			else {
				System.out.println(weName+"is displaying on webPage but not enabled");
			}
		}
		else {
			System.out.println(weName+"is not displaying on webPage");
		}

	}
	public  void selectByVisibleText(WebElement we, String text, String weName) {
		if(we.isDisplayed()) {
			if(we.isEnabled()) {
				Select selObj=new Select(we);
				selObj.selectByVisibleText(text);
			}
			else {
				System.out.println(weName+"is displaying on webPage but not enabled");
			}
		}
		else {
			System.out.println(weName+"is not displaying on webPage");
		}

	}
	public  void selectByValue(WebElement we, String weName) {
		if(we.isDisplayed()) {
			if(we.isEnabled()) {
				Select selObj=new Select(we);
				String attValue=we.getAttribute("value");
				selObj.selectByValue(attValue);
			}
			else {
				System.out.println(weName+"is displaying on webPage but not enabled");
			}
		}
		else {
			System.out.println(weName+"is not displaying on webPage");
		}

	}
	public WebElement getSelectedItemFromDropdown(WebElement we) {
		Select selObj=new Select(we);
		WebElement weSelected=selObj.getFirstSelectedOption();
		return weSelected;
	}

	public  void deSelectAll(WebElement we) {
		Select selObj=new Select(we);
		selObj.deselectAll();
	}

	public  void deSelectByIndex(WebElement we,int index) {
		Select selObj=new Select(we);
		selObj.deselectByIndex(index);
	}

	public  void deSelectByVisibleText(WebElement we,String Text) {
		Select selObj=new Select(we);
		selObj.deselectByVisibleText(Text);
	}

	public  void deSelectByValue(WebElement we ) {
		Select selObj=new Select(we);
		String attValue=we.getAttribute("value");
		selObj.deselectByValue(attValue);
	}

	public List<String> getAllOptionList(WebElement we) {
		Select selObj= new Select(we);
		List<WebElement> weList=selObj.getOptions();
		List<String> textList=new ArrayList<>();
		for(WebElement element:weList) {
			String weText=element.getText();
			textList.add(weText);
		}
		return textList;
	}

	public List<WebElement> getAllSelectedItem(WebElement we) {
		Select selObj=new Select(we);

		List<WebElement> allItem=selObj.getAllSelectedOptions();
		return allItem;
	}
	public  void switchToWindowByTitle(String expTtle) {

		Set<String> allWindow=driver.getWindowHandles();
		for(String hndlVal:allWindow) {
			driver.switchTo().window(hndlVal);
			String title=driver.getTitle();
			if(title.equalsIgnoreCase(expTtle)) {
				break;
			}
		}
	}

	public  void switchToWindowByUrl(String expUrl) {

		Set<String> allWindow=driver.getWindowHandles();
		for(String hndlVal:allWindow) {
			driver.switchTo().window(hndlVal);
			String title=driver.getTitle();
			if(title.equalsIgnoreCase(expUrl)) {
				break;
			}
		}
	}

	public  void sendKeys(WebElement we, String input, String weName) {
		if(we.isDisplayed()) {
			if(we.isEnabled()) {
				we.sendKeys(input); 
			}
			else {
				System.out.println(weName+" EditBox is displayed but not enabled");
			}
		}
		else {
			System.out.println(weName+" EditBox is not displayed on page");
		}

	}

	public  void mouseOver( WebElement we) {
		Actions actObj=new Actions(driver); 
		actObj.moveToElement(we).build().perform();
	}
	
	public  void actionClick( WebElement we) {
		Actions actObj=new Actions(driver); 
		actObj.click(we).build().perform();
	}


	public  void doubleClick( WebElement we) {
		Actions actObj=new Actions(driver); 
		actObj.doubleClick(we).build().perform();
	}

	public  void rightClick(WebElement we) {
		Actions actObj=new Actions(driver); 
		actObj.contextClick(we).build().perform();
	}


	public  void dragAndDrop( WebElement source,WebElement target) {
		Actions actObj=new Actions(driver); 
		actObj.dragAndDrop(source, target).build().perform();
	}

	public  void dragAndDropByLocation(WebElement source,int xLocation,int yLocation) {
		Actions actObj=new Actions(driver); 
		actObj.dragAndDropBy(source, xLocation,yLocation).build().perform();
	}

	public  String getText(WebElement we) {
		String text=we.getText();
		return text;
	}
	
	public  boolean equals(String actualText,String expText) {
		boolean b=actualText.equals(expText);
		return b;
	}

	public String getAttributeValue(WebElement we,String attbuteName) {
		String attValue=we.getAttribute(attbuteName);
		return attValue;
	}
	public int getHeight(WebElement we) {
		Dimension dim=we.getSize();
		int hght= dim.getHeight();
		return hght;
	}
	public int getWidth(WebElement we) {
		Dimension dim=we.getSize();
		int wdth= dim.getWidth();
		return wdth;
	}

	public  void closeCurrentBrowser() {
		driver.close();
	}

	public  void closeBrowserInstance() {
		driver.quit();;
	}

	public String getCurrentTitle() {
		String title=driver.getTitle();
		return title;
	}
	public String getCurrentUrl() {
		String url=driver.getCurrentUrl();
		return url;
	}
	public  void explicitlyWaitForVisibility(long timeOut,WebElement we) {
		WebDriverWait wait=new WebDriverWait(driver, timeOut); 
		wait.until(ExpectedConditions.visibilityOf(we));   
	}

	public  void explicitlyWaitForInVisibility(long timeOut,WebElement we) {
		WebDriverWait wait=new WebDriverWait(driver, timeOut); 
		wait.until(ExpectedConditions.invisibilityOf(we));   
	}
	public  void explicitlyWaitPresenceOfElement(long timeOut,String locator) {
		WebDriverWait wait=new WebDriverWait(driver, timeOut); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));   
	}

	public  void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public boolean isSelected(WebElement we) {
		boolean b= we.isSelected();
		return b;
	}
	public boolean isEnabled(WebElement we) {
		boolean b= we.isEnabled();
		return b;
	}
	public boolean isDisplayed(WebElement we) {
		boolean b= we.isDisplayed();
		return b;
	}
	public  void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
		alertPopupAccept();
	}
	public  void switchToFrameById(String id) {
		driver.switchTo().frame(id);
	}
	public  void switchToFrameByName(String name) {
		driver.switchTo().frame(name);
	}
	public  void switchToFrameByWebElement(WebElement we) {
		driver.switchTo().frame(we);
	} 
	public  void switchToParentFrame() {
		driver.switchTo().parentFrame();
	} 
	public  void switchToMainWindowFrame() {
		driver.switchTo().defaultContent();
	}
	
	public  int getRowNumByRowId(List<WebElement> weRows, String expRowName ) {
		int rowNumber = -1;
        for(int i=0;i<weRows.size();i++) {
        	WebElement weObj=weRows.get(i);
        	String RowText=weObj.getText();
        	rowNumber=i+1;
        	if(RowText.equalsIgnoreCase(expRowName)) {
        		
        		break;
        	}
  
        }
        return rowNumber;
	}
	
	public  int getColNumByColName(List<WebElement> wecolmList,String expColumnName,int rowNum ) {
		int columnNumber=-1;
	 
        for(int i=0;i<wecolmList.size();i++) {
        	WebElement weObj=wecolmList.get(i);
        	String colmText=weObj.getText();
        	 columnNumber=i;
        	if(colmText.equalsIgnoreCase(expColumnName)) {
        		weObj.click();
        		break;
        	}
         }
        return columnNumber;
	}
	
	 public void takeScreenShot(String imgName) {
		 TakesScreenshot scrShot=(TakesScreenshot)driver;
		 File srcFile =scrShot.getScreenshotAs(OutputType.FILE);
		 File destFile= new File("screenshot//"+imgName+".png");
		 try {
			Files.copy(srcFile, destFile);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	 }
  
		
		public void verifyText(WebElement we,String expText,String elmentName) {
			String actualText=we.getText().trim();
			if(actualText.equalsIgnoreCase(expText.trim())) {
				System.out.println("Text Verification is passed. Actual-"+actualText+" and Expected-"+expText);
			}else {
				System.out.println("Text Verification is Failed. Actual-"+actualText+" and Expected-"+expText);
			}
			
			Assert.assertEquals(actualText, expText);
		}
			public void verifyTextContains(WebElement we,String expText,String elementName) {
				String actualText=we.getText();
				if(actualText.contains(expText.trim())) {
					System.out.println(elementName+"--Verification of Text Contain is passed.");
				}else {
					System.out.println(elementName+"--Verification of Text Contain is failed");
				}
				Assert.assertEquals(actualText, expText.trim());
			}
				public void verifyDisabled(WebElement we,String elmentName) {
					boolean actualStatus=we.isEnabled();
					if(actualStatus==false) {
						System.out.println(elmentName+"--Element disabilty status verification is passed.");
					}else {
						System.out.println(elmentName+"--Element disabilty status verification is failed.");
					}
					
					Assert.assertEquals(actualStatus, false);
		}
				public void verifyEnabled(WebElement we,String elmentName) {
					boolean actualStatus=we.isEnabled();
					if(actualStatus==true) {
						System.out.println(elmentName+"--Element enable status verification is passed.");
					}else {
						System.out.println(elmentName+"--Element enable status verification is failed.");
					}
					Assert.assertEquals(actualStatus, true);
		}
				
				public void verifyVisibilty(WebElement we,String elmentName) {
					boolean actualStatus=we.isDisplayed();
				
					int height=getHeight(we);
					int width=getWidth(we);
					if(actualStatus==true && height>0 && width>0) {
						System.out.println(elmentName+"--Element visibilty status verification is passed.");
					}else {
						System.out.println(elmentName+"--Element visibilty status verification is failed.");
					}
					Assert.assertEquals(actualStatus, true);
				}
				
				public void verifyInVisibilty(WebElement we,String elmentName) {
					boolean actualStatus=we.isDisplayed();
					int height=getHeight(we);
					int width=getWidth(we);
					if(actualStatus==false && height<1 && width<1) {
						System.out.println(elmentName+"--Element Invisibilty status verification is passed.");
					}else {
						System.out.println(elmentName+"--Element Invisibilty status verification is failed.");
					}
					Assert.assertEquals(actualStatus, true);
	 }
				public void verifyAttributeValue(WebElement we,String attributeName,String expValue,String elmentName) {
					String attValue=we.getAttribute(attributeName).trim();
					if(attValue.equalsIgnoreCase(expValue.trim())) {
						System.out.println(elmentName+"-"+attributeName+"- verificatin is passed");
					}else {
						System.out.println(elmentName+"-"+attributeName+"- verificatin is failed");
				}
					Assert.assertEquals(attValue, expValue.trim());
	 }
				
				public void verifySelected(WebElement we,String elmentName) {
					boolean actualStatus=we.isSelected();
					if(actualStatus==true) {
						System.out.println(elmentName+"--Element selected status verification is passed.");
					}else {
						System.out.println(elmentName+"--Element selected status verification is failed.");
					}
					
					Assert.assertEquals(actualStatus, true);
		}
				
				public void verifyUnselected(WebElement we,String elmentName) {
					boolean actualStatus=we.isSelected();
					if(actualStatus==false) {
						System.out.println(elmentName+"--Element selected status verification is passed.");
					}else {
						System.out.println(elmentName+"--Element selected status verification is failed.");
					}
					Assert.assertEquals(actualStatus, false);
		}
				
	
}