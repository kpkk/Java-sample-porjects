package excelAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.plaf.synth.SynthSliderUI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class selectiveRowReadFromxl {
	
	
	public ArrayList<String> getData(String testname) throws IOException {
		
		ArrayList<String> a =new ArrayList<String>();
FileInputStream fis=new FileInputStream("C:\\Users\\krishnapradeep.k\\eclipse-workspace\\Automation\\TestData\\Data.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		int numberOfSheets = workbook.getNumberOfSheets();
		System.out.println("number of sheets in excel workbook were :"+numberOfSheets);
		for(int i=0;i<numberOfSheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("Testcase"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				Iterator<Row> row = sheet.iterator();//collection of rows
				Row Frow = row.next(); //gets one row
				Iterator<Cell> cellIterator = Frow.cellIterator(); //gets all cells
				int k=0;
				int column=0;
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next(); //gets a particular cell
					if(cell.getStringCellValue().equalsIgnoreCase("Testcases")) {
						column=k;
					}
					k++;
					
				}
				System.out.println(column);
				while(row.hasNext()) {
					Row next = row.next(); //gets a particular row
					if(next.getCell(column).getStringCellValue().equalsIgnoreCase("retail")) {
						Iterator<Cell> ce = next.cellIterator();
						while(ce.hasNext()) {
							Cell cl = ce.next();
							if(cl.getCellType()==CellType.STRING) {
								a.add(cl.getStringCellValue());
							}else {
								a.add(NumberToTextConverter.toText(cl.getNumericCellValue()));
							}
							
						}
					}
				}
				
			}
		}
		return a;
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		selectiveRowReadFromxl ssr=new selectiveRowReadFromxl();
		
		ArrayList<String> data = ssr.getData("retail");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		

	}

}
