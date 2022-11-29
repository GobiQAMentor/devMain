package com.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.apache.commons.io.FileUtils;

import com.driver.DriverInstance;
import com.google.common.io.Files;

public class UtilityClass {

	public static byte[] takeByteScreenshot(WebDriver driver) {
		TakesScreenshot scDriver = (TakesScreenshot) driver;
		byte[] scBytes = scDriver.getScreenshotAs(OutputType.BYTES);
		return scBytes;
	}


	public static String getFileScreenshot() {
		String screenshot;
		WebDriver driver = DriverInstance.getInstance().getDriver();
		screenshot = System.getProperty("user.dir")+"/screenshots/screenshots"+System.currentTimeMillis() + ".png";
		File srcFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		System.out.println("Screen capture saved at location "
				+ screenshot);
		try {
			FileHandler.copy(srcFile, new File(screenshot));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshot;
    }
    
	public static void deleteCsvFile(String browserName) throws Exception {
		File folder = new File(System.getProperty("user.dir") + File.separator + "downloads"+ File.separator + "chromedownloads");

		File[] listOfFiles = folder.listFiles();
		String fileName = null;
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".csv")) {
				System.out.println("File = " + listOfFiles[i].getName());
				fileName = listOfFiles[i].getName();
			}
		}
		FileUtils.cleanDirectory(folder);
		System.out.println("Files deleted");
		
	}
	
	public static String dynamicString() {
		//java.util.Date date=new java.util.Date();
		String currenttime = new SimpleDateFormat("MMddHHmmssa").format(Calendar.getInstance().getTime());
		return currenttime;
	}

	public static String getDynamicReportName(){
		String currenttime = new SimpleDateFormat("HH_mm_ss").format(Calendar.getInstance().getTime());
	    Date dat=new Date();
		LocalDate currentDate = LocalDate.now(); // 2016-06-17
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		long num=Long.parseLong((currentDate+"").replace("-", "")+currenttime.replace("_", ""));
		System.out.println("Before num="+num);
		num=99999999999999L-num;
		String report=num+"";
		report=report.replace("-", "").replace(":", "")+" "+dat;
		String fileName=report.replace(":", "_").replace(" ", "_");
		System.out.println("report Name : "+fileName);
		return fileName;
	}
	
	public static void moveAllOldReports() {
		File src = new File(System.getProperty("user.dir") + File.separator + "reports"+ File.separator + "HtmlReport");
		File[] allFiles = src.listFiles();
 		
		for(File ff:allFiles) {
			File destFile = new File(System.getProperty("user.dir") + File.separator + "reports"+ File.separator+ff.getName());
			try {
	            Files.move(ff, destFile);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}

		File[] htmlReportFiles = src.listFiles();
		if(htmlReportFiles.length>0) {
				try {
					FileUtils.cleanDirectory(src);
					System.out.println("Files deleted");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public static void copyAllReports() {
		File src = new File(System.getProperty("user.dir") + File.separator + "reports"+ File.separator + "HtmlReport");
		File[] allFiles = src.listFiles();
		
		File rootDir = new File(System.getProperty("user.dir"));
		String parentDir = rootDir.getParent();
		System.out.println(rootDir.getParent());
 		
		for(File ff:allFiles) {
			File destFile = new File(parentDir + File.separator + "ReportingJob"+File.separator+"AllReports"+ File.separator +ff.getName());
			try {
	            Files.copy(ff, destFile);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	}
}