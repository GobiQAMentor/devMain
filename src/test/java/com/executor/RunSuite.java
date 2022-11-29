/**
Script Name:		RunSuite
Author Name:		QASource
Test Case ID:		 -
Script Scenario:	This class is used to execute whole framework step by step from start to create report.
 **/
//Declaration of executor package.
package com.executor;

//Required imports
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.TestNG;

//RunSuite (in box.com)  class 
public class RunSuite implements Runnable{

	List<String> testSuites = new ArrayList<String>();
//	String testsuites[] = new String[5];
	private final static Class<?>[] TEST_CLASSES = new Class[]{};
	ArrayList<String> suiteNameArray = new ArrayList<String>();
	public static boolean reExecution = false;
	String reExecutedString="", suite="";
	//start time for framework to start executing 
//	public static final long frameworkStartTime = System.currentTimeMillis();
	 // We will store the threads so that we can check if they are done
    static List<Thread> threads = new ArrayList<Thread>();

	/**
	 * Main Function to run framework.
	 * First, it deletes screenshot folder if present by calling execShellCmd function.
	 * Then, it deletes testng-failed.xml if present by calling execShellCmd function.
	 * Then, it verifies whether config directory is present or not.
	 * Then, it load config properties file by calling loadProperties function.
	 * Then, it loads testsuite list by calling returnSuites function. 
	 * Then, each suite is run one by one with its failed cases re-executed.
	 * Then at last, HTML report is generated.
	 **/
	public static void main(String args[]) throws IOException{ 
		

		RunSuite run = new RunSuite();

		File configDir = new File("src/test/resources/testrunner");
		run.returnSuites();
			
			File[] testSuiteFiles = configDir.listFiles();
			
			for(String name:run.suiteNameArray){
				String fileName = System.getProperty("user.dir")+"/src/test/resources/testrunner/"+name+".xml";
				File testFile = new File(fileName);
				
				Runnable task = new RunSuite();
				((RunSuite) task).getTestSuites().add(testFile.getAbsolutePath());
	            Thread worker = new Thread(task);
//	            // We can set the name of the thread
	            worker.setName(testFile.getAbsolutePath());
//	            // Start the thread, never call method run() direct
	            worker.start();
//	            // Remember the thread for later usage
	            threads.add(worker);
			}
//			run.runTestngSuite(testSuites);
			
			


	}
	/**
	 * Function to load the test-suites list.
	 * It gets the property "suite" from config.properties.
	 * If suite-name contains "," then it splits into separate names.
	 * After adding names in the list, the list is returned. 
	 **/
	public void returnSuites(){
		suite = "testng,testng2";
//		System.out.println(suite.lastIndexOf("g"));
		// {testng1 testng2}
		if(suite.indexOf(",")>0){
			String[] allValues = suite.split(",");
			List<String> strList = Arrays.asList(allValues);
			suiteNameArray.addAll(strList);
//			suiteNameArray.addAll(Arrays.asList(suite.split(",")));
		}
		else{
			suiteNameArray.add(suite);
		}
	}
	
	/**
	 * Function to run testng test-suites.
	 * suites added in test suites list are executed one  by one.
	 * Results are saved in "TestResults" folder. 
	 **/
	public void runTestngSuite(List<String> suites){
		TestNG testng = new TestNG();
		testng.setVerbose(0);
		if (suites != null && !suites.isEmpty()) {
			System.out.println(suites);

			testng.setTestSuites(testSuites);
//			TEST_CLASSES[0] = BoxLoginLogoutParameterised.class;
//			testng.setTestClasses(TEST_CLASSES);
//			XmlClass c1 = new XmlClass();
//			c1.setClass(BoxLoginLogoutParameterised.class);
			

		} else {
			testng.setDefaultSuiteName("Suite");          
			testng.setTestClasses(TEST_CLASSES);
		}
//		TestListenerAdapter tla = new TestListenerAdapter();
//
//		testng.addListener(tla);

//		testng.setParallel("classes");
//		testng.setOutputDirectory("TestResults" + File.separatorChar +"test-reports");
		System.out.println("------------------------------------");
		testng.run();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		TestNG testng = new TestNG();
		testng.setVerbose(0);
		if (testSuites != null && !testSuites.isEmpty()) {
			System.out.println(testSuites);

			testng.setTestSuites(testSuites);
		} else {
			testng.setDefaultSuiteName("Suite");          
			testng.setTestClasses(TEST_CLASSES);
		}
		System.out.println("------------------------------------");
		testng.run();
		
	}
	
	public List<String> getTestSuites() {
		return testSuites;
	}


}
