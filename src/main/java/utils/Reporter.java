package utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporter {
	ExtentHtmlReporter html;
	public static ExtentReports extent;
	public static ExtentTest test;
	public  String excelFilename, testCaseName,description,author,category;
	
	 
	public void beginreport() {
		ExtentHtmlReporter html=new ExtentHtmlReporter("./Reports/report.html");
		
		 extent=new ExtentReports();
		extent.attachReporter(html);
	}
	
	
	public void startTestcase() {
	  test = extent.createTest(testCaseName, description);
		test.assignAuthor(author);
		test.assignCategory(category);
	}
	
	public void reportStep(String desc,String status) throws IOException {
		if(status.equalsIgnoreCase("pass")){
			for(int i=0;i<=1000;i++) {
			
				test.pass(desc, MediaEntityBuilder.createScreenCaptureFromPath("./../Snaps/Img_"+i+".png").build());
			
			}
		}
		else if(status.equalsIgnoreCase("fail")) {
			for(int i=0;i<=1000;i++) {
	
	       
			test.fail(desc, MediaEntityBuilder.createScreenCaptureFromPath("./../Snaps/Img_"+i+".png").build());
		
			}
		}
		
		else if(status.equalsIgnoreCase("warning")) {
			for(int i=0;i<=1000;i++) {
			
				test.warning(desc, MediaEntityBuilder.createScreenCaptureFromPath("./../Snaps/Img_"+i+".png").build());
			
			}
		}
	}
	
	
		
		public void endReport() {
		extent.flush();
		}
		
	}
	
	


