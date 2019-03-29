import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.interactions.Actions;

public class practice {

	public static void main(String[] args) throws IOException, AWTException {
		
		Robot r=new Robot();
		
		
		XSSFWorkbook workbook=new XSSFWorkbook("./TestData/AshleyRegisterDetails.xlsx");
		XSSFSheet sheetAt = workbook.getSheetAt(0);
		int lastRowNum = sheetAt.getLastRowNum();
		int lastCellNum = sheetAt.getRow(0).getLastCellNum();
		System.out.println(lastRowNum);
		System.out.println(lastCellNum);
		Object[][]data=new Object[lastRowNum][lastCellNum];
		
		for(int i=1; i<=lastRowNum;i++) {
			XSSFRow row = sheetAt.getRow(i);
			
			for(int j=0;j<=lastCellNum;j++) {
				XSSFCell cell = row.getCell(j);
				data[i-1][j]=cell.getStringCellValue();
				System.out.println(data[i-1][j]+"\n");
			}
		}
		}
	

	
	}


