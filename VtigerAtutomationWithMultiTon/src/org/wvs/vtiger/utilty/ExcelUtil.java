package org.wvs.vtiger.utilty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
   public static Map<String,String> DataMap;
	public Map<String,String> getTestCaseData(String testCaseName) throws IOException {
		Map<String, String> mapObj=new HashMap<String, String>();
		String testDataPath="AccountTestData.xlsx";
		Workbook wbook=getWorkbook(testDataPath);
		Sheet sheetObj=wbook.getSheet("Sheet1");
		int rowNum=getRowNumByUniqueTestCaseName(testCaseName, sheetObj, "TestCase_ID");
		int start=getColumnNumByColumnName("TD_Name1", sheetObj);
	     Row rowObj=sheetObj.getRow(rowNum);
	     int cellCount=rowObj.getLastCellNum();
	     for (int i = start; i <= cellCount-1; i=i+2) {
	    	 String testDataName=getCellData(rowObj, i);
	    	 String testDataValue=getCellData(rowObj, i+1);
	    	 mapObj.put(testDataName, testDataValue);
		}
		DataMap=mapObj;
		return mapObj;
	}
	public  String getCellData(Row rowObj,int cellNum) {
		String celldata=rowObj.getCell(cellNum,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
   	  return celldata;
	}
	
	public  Workbook getWorkbook(String testDataPath) throws IOException {
		
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(testDataPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Workbook wbook=null;
		
		String str[]=testDataPath.split("\\.");
		if(str[1].equalsIgnoreCase("xlsx")) {
				 wbook = new XSSFWorkbook(fis);
	         }else {
				wbook=new HSSFWorkbook(fis);
			
		}
		
		return wbook;
	}

	public  int getColumnNumByColumnName(String colName,Sheet sheetObj) {
		
       Row rowObj=sheetObj.getRow(0);	
       int colmCount=rowObj.getLastCellNum();
       int colNum=-1;
		for(int i=0;i<colmCount;i++) {
			String cellVal=rowObj.getCell(i).getStringCellValue();
			if(cellVal.equalsIgnoreCase(colName)) {
				colNum=i;
				break;
			}
		}
		return colNum;
	}
	
	public  int getRowNumByUniqueTestCaseName(String testCaseID,Sheet sheetObj,String colName) {
		int colNum=getColumnNumByColumnName(colName,sheetObj);
		  
			int rowCount=sheetObj.getLastRowNum();
			int rowNum=-1;
			for (int i = 0; i <= rowCount; i++) {
				Row row=sheetObj.getRow(i);
				String cellData=row.getCell(colNum).getStringCellValue();
				if(cellData.equalsIgnoreCase(testCaseID)) {
					rowNum=i;
					break;
				}
			}
			return rowNum;
	}
	
	public  Map<String, String> getPageData(String testCaseName) throws IOException {
		Workbook wbook=getWorkbook("AccountTestData.xlsx");
		Sheet sheetObj=wbook.getSheet("Sheet2");
		int rowNum=getRowNumByUniqueTestCaseName(testCaseName, sheetObj, "TestCase_ID");
		  int startDataColNum=getColumnNumByColumnName("TestCase_ID", sheetObj)+1;
		  Row firstRow=sheetObj.getRow(0);
		  Row dataRow=sheetObj.getRow(rowNum);
		 Map<String,String> mapObj=new HashMap<String,String>();
		  int cellCOunt=firstRow.getLastCellNum();
		  for(int i=startDataColNum;i<cellCOunt;i++) {
			 String keyVal= getCellData(firstRow, i);
			 String dataVal= getCellData(dataRow, i);
			  mapObj.put(keyVal, dataVal);
		  }
		  System.out.println(mapObj);
		  return mapObj;
	}
	
	public  void main(String[] args) throws IOException {
		getPageData("enterAccountBasicInfo_Acc_001");
	}
}
