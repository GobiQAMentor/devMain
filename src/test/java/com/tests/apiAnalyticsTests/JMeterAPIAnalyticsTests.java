package com.tests.apiAnalyticsTests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.tests.BaseTest;

public class JMeterAPIAnalyticsTests extends BaseTest {

	StandardJMeterEngine jmeter = new StandardJMeterEngine();;
	String jMeterPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "API_Testing";
	
	public void runJMeterTest() throws Exception {
		System.out.println(jMeterPath);
        // JMeterUtils.loadJMeterProperties("/path/to/your/jmeter/bin/jmeter.properties");
        JMeterUtils.loadJMeterProperties(jMeterPath + File.separator + "apache-jmeter-5.4.1" + File.separator + "bin" + File.separator + "jmeter.properties");
        
        // JMeterUtils.setJMeterHome("/path/to/your/jmeter");
        JMeterUtils.setJMeterHome(jMeterPath + File.separator + "apache-jmeter-5.4.1");
        JMeterUtils.initLogging();// you can comment this line out to see extra log messages of i.e. DEBUG level
        JMeterUtils.initLocale();

        // Initialize JMeter SaveService
        SaveService.loadProperties();

        // Load existing .jmx Test Plan
        FileInputStream in = new FileInputStream(jMeterPath + File.separator + "API_Testing.jmx");
		HashTree testPlanTree = SaveService.loadTree(in);
        in.close();

        // Run JMeter Test
        jmeter.configure(testPlanTree);
        jmeter.run();
        ExtentTestManager.getTest().pass("Test executed on JMeter Tool");
    }

	public void readJmeterResultCSVFile() throws IOException {
		String path = jMeterPath + File.separator + "JmeterResults.csv";

		File file  = null;
		BufferedReader br = null;
		try {
			file = new File(path);
			br = new BufferedReader(new FileReader(file));
		}catch(Exception ex) {
			throw new RuntimeException("Exception caused by "+ex.getClass().getName()+" and message is "+ex.getMessage());
		}

		String line,line1 = br.readLine();
		String[] header = line1.split(",");
		System.out.println(line1);
		System.out.println(" I No. of Column ======= "+header.length);
		Map<Object, Object> datamap = new HashMap<Object, Object>();
		int numOfInq=0;
		for(int j=0;j<(getRowCount(file)-1);j++) {
			line = br.readLine();
			String[] inquiry = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			
			for(int i=0;i<(header.length-1);i++) {
				try {
					datamap.put(header[i], inquiry[i]);
				}catch (ArrayIndexOutOfBoundsException e) {
					datamap.put(header[i], "");
				}
			}
			String columnName = "success";
			if(datamap.get(columnName)!=null) {
				if((datamap.get(columnName).toString()).equalsIgnoreCase("true")) {
					ExtentTestManager.getTest().pass("Passed : The API Test Case '"+datamap.get("label")+"' Passed with Response = '"+
							datamap.get("responseCode")+" "+datamap.get("responseMessage"));
					System.out.println("Passed : The API Test Case '"+datamap.get("label")+"' Passed with Response = '"+
							datamap.get("responseCode")+" "+datamap.get("responseMessage"));
				}
				else {
					ExtentTestManager.getTest().fail("Failed : The API Test Case '"+datamap.get("label")+"'Failed with Response Assertion Error Message = '"
							+datamap.get("failureMessage"));
					System.out.println("Failed : The API Test Case '"+datamap.get("label")+"'Failed with Response Assertion Error Message = '"
							+datamap.get("failureMessage"));
				}
			}
		}
		
		System.out.println(datamap.size());
		System.out.println(datamap.get("dataType"));


	}

	public int getRowCount(File file) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		//String input;
		int count = 0;
		while((bufferedReader.readLine()) != null)
		{
			count++;
		}
		//System.out.println("Count : "+count);
		bufferedReader.close();
		return count;
	}
}
