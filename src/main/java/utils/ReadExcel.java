package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	
	
	public static Object[][] readFromExcel(String ExcelFileName) throws IOException {
		XSSFWorkbook workbook=new XSSFWorkbook("./TestData/"+ExcelFileName+".xlsx");
		XSSFSheet sheetAt = workbook.getSheetAt(0);
		int lastRowNum = sheetAt.getLastRowNum();
		int lastColumn = sheetAt.getRow(0).getLastCellNum();
		Object[][]data=new Object[lastRowNum][lastColumn];
		
		for(int i=1;i<=lastRowNum;i++) {
			XSSFRow row = sheetAt.getRow(i);
			for(int j=0;j<lastColumn;j++) {
				XSSFCell cell = row.getCell(j);
				data[i-1][j] = cell.getStringCellValue();
			}
		}
		return data;
	}
	
	
	

}
