package excelAutomation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadRowData {
	
	public ArrayList<String> readData(String filePath, String testcasename) throws IOException{
		
		ArrayList<String> al=new ArrayList<String>();
		XSSFWorkbook workbook=new XSSFWorkbook(filePath);
		
		
		int numberOfSheets = workbook.getNumberOfSheets();
		
		for(int i=0; i<numberOfSheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("Testcase")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row fRow = rows.next();
				Iterator<Cell> fColumns = fRow.cellIterator();
				int k=0;
				int column=0;
				while(fColumns.hasNext()) {
					if(fColumns.next().getStringCellValue().equalsIgnoreCase("Testcases")) {
						column=k;
					}
					k++;
				}
				System.out.println(column);
				Iterator<Row> rowsI = sheet.iterator();
				while(rowsI.hasNext()) {
					Row next = rowsI.next();
					if(next.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {
						Iterator<Cell> cellIterator = next.cellIterator();
						while(cellIterator.hasNext()) {
							Cell next2 = cellIterator.next();
							if(next2.getCellType()==CellType.STRING) {
								al.add(next2.getStringCellValue());
							}
							else {
								
								al.add(NumberToTextConverter.toText(next2.getNumericCellValue()));
							}
						}
						
					}
				}
				
			}
			
			
		}
		return al;
		
		

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ReadRowData rd=new ReadRowData();
		
		ArrayList<String> readData = rd.readData("C:\\Users\\krishnapradeep.k\\eclipse-workspace\\Automation\\TestData\\Data.xlsx", "retail");
		
		//System.out.println(readData.get(0));
		//System.out.println(readData.get(1));
		readData.stream().forEach(ll->System.out.println(ll));
		//readData.forEach((n)->System.out.println(n));
		
		
	}

}
