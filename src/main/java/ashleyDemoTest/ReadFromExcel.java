package ashleyDemoTest;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadFromExcel {
	
	
	
	
	public static Object[][] readExcel(String excelFileName) throws IOException {
		XSSFWorkbook workbook=new XSSFWorkbook("./TestData/AshleyRegisterDetails.xlsx");
		XSSFSheet sheetAt = workbook.getSheetAt(0);
		int lastRowNum = sheetAt.getLastRowNum();
		int lastCellNum = sheetAt.getRow(0).getLastCellNum();
		
		Object[][]data=new Object [lastRowNum][lastCellNum];
		
		for(int i=1;i<=lastRowNum;i++) {
			XSSFRow row = sheetAt.getRow(i);
			
			for(int j=0;j<lastCellNum;j++) {
				XSSFCell cell = row.getCell(j);
				data[i-1][j]= cell.getStringCellValue();
				System.out.print(data[i-1][j]+ "\n");
			}
			
		}
		return data;
		
		
	}

}
