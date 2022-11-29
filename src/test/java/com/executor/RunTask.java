package com.executor;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.TestNG;

import com.driver.DriverInstance;
import com.tests.BrowsersDataEnum;
import com.utils.UtilityClass;

public class RunTask extends RecursiveAction{
	List<String> testSuites = new ArrayList<String>();

	private final static Class<?>[] TEST_CLASSES = new Class[]{};
	ArrayList<String> suiteNameArray = new ArrayList<String>();
	//	public static boolean reExecution = false;
	String reExecutedString="", suite="";
	public String testSuite;
	public String browserName;
	public static List<String> browserList = new ArrayList<String>();
	public String path = System.getProperty("user.dir")+"/src/test/resources/testrunner/";


	static {
		System.setProperty("extent.reporter.spark.out", "reports/HtmlReport/"+UtilityClass.getDynamicReportName()+"_allSuites.html");
		BrowsersDataEnum.dataInMap();
	}

	RunTask(String browserName, String testSuite){
		this.browserName = browserName;
		this.testSuite = testSuite;
	}

	RunTask(){

	}

	@Override
	protected void compute() {
		// TODO Auto-generated method stub

		//		int noOfBrowsers = browserList.size();

		String fileName = path + testSuite+".xml";
		File testFile = new File(fileName);

		Thread.currentThread().setName(browserName);
		testSuites.add(testFile.getAbsolutePath());
		processTask();

	}

	private void processTask() {

		TestNG testng = new TestNG();
		if (testSuites != null && !testSuites.isEmpty()) {
			System.out.println(testSuites);

			testng.setTestSuites(testSuites);
		}
		System.out.println("------------------------------------");
		//		testSuites.clear();
		testng.run();
	}

	public static void main(String[] args) throws Exception {
		browserList.add(BrowsersDataEnum.map.get(BrowsersDataEnum.WINCHROME));
		browserList.add(BrowsersDataEnum.map.get(BrowsersDataEnum.FIREFOX));


		int numberOfProcessors = Runtime.getRuntime().availableProcessors();
		//		ForkJoinPool pool = ForkJoinPool.commonPool();
		RunTask task =new RunTask();


		try {
			task.executeAapTestsPool(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}

		closeAllWorkingDrivers();

		Thread.sleep(5000);
		try {
			task.executeAapTestsPool2(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}


		closeAllWorkingDrivers();

		Thread.sleep(5000);
		try {
			task.executeEmbedTestsPool(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}

		closeAllWorkingDrivers();;


		Thread.sleep(5000);
		try {
			task.executeSuperContentTestsPool(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}

		closeAllWorkingDrivers();

		Thread.sleep(5000);
		try {
			task.executeExperience360TestsPool(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}

		closeAllWorkingDrivers();

		Thread.sleep(5000);
		try {
			task.executeIWCCFormerSuperContentTestsPool(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}

		closeAllWorkingDrivers();
		
		Thread.sleep(5000);
		try {
			task.executeDeskTopCIFTestsPool(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}

		closeAllWorkingDrivers();

		
		Thread.sleep(5000);
		try {
			task.executeDeskTopCIFTestsPool1(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}

		closeAllWorkingDrivers();
		
		Thread.sleep(5000);
		try {
			task.executeDeskTopCIFTestsPool2(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}

		closeAllWorkingDrivers();


		Thread.sleep(5000);
		try {
			task.executeDesktopRegistrationLegacyFormTestsPool(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}

		closeAllWorkingDrivers();
		Thread.sleep(5000);
		try {
			task.executeDesktopRegistrationLegacyFormTestsPool1(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}

		closeAllWorkingDrivers();

		
		Thread.sleep(5000);
		try {
			task.executeDesktopIMAPTestsPool(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}

		closeAllWorkingDrivers();

/*
		Thread.sleep(5000);
		try {
			task.executeMobileCIFTestsPool(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}

		closeAllWorkingDrivers();

		Thread.sleep(5000);
		try {
			task.executeMobileRegistrationLegacyFormestsPool(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}

		closeAllWorkingDrivers();
*/		
		
		try {
			task.executeFailedTests(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		
	}

	public void executeAapTestsPool(int number) {
		System.out.println();
		ForkJoinPool aapPool1 = new ForkJoinPool(number);

		RunTask task1 = new RunTask("winchrome", "aapSuite1");
//		RunTask task2 = new RunTask("firefox", "aapSuite1");
		RunTask task3 = new RunTask("edge", "aapSuite1");
		RunTask task4 = new RunTask("macchrome", "aapSuite1");
//		RunTask task5 = new RunTask("safari", "aapSuite1");
		aapPool1.execute(task1);
//		aapPool1.execute(task2);
		aapPool1.execute(task3);
		aapPool1.execute(task4);
//		aapPool1.execute(task5);
		task1.join();
//		task2.join();
		task3.join();
		task4.join();
//		task5.join();
	}
	public void executeAapTestsPool2(int number) {
		System.out.println();
		ForkJoinPool aapPool2 = new ForkJoinPool(number);
		RunTask task1 = new RunTask("winchrome", "aapSuite2");
//		RunTask task2 = new RunTask("firefox", "aapSuite2");
		RunTask task3 = new RunTask("edge", "aapSuite2");
		RunTask task4 = new RunTask("macchrome", "aapSuite2");
//		RunTask task5 = new RunTask("safari", "aapSuite2");
		aapPool2.execute(task1);
//		aapPool2.execute(task2);
		aapPool2.execute(task3);
		aapPool2.execute(task4);
//		aapPool2.execute(task5);
		task1.join();
//		task2.join();
		task3.join();
		task4.join();
//		task5.join();
	}

	public void executeEmbedTestsPool(int number) {
		ForkJoinPool embedPool = new ForkJoinPool(number);
		RunTask embedTask1 = new RunTask("winchrome", "embedSuite");
//		RunTask embedTask2 = new RunTask("firefox", "embedSuite");
		RunTask embedTask3 = new RunTask("edge", "embedSuite");
		RunTask embedTask4 = new RunTask("macchrome", "embedSuite");
//		RunTask embedTask5 = new RunTask("safari", "embedSuite");
		embedPool.execute(embedTask1);
//		embedPool.execute(embedTask2);
		embedPool.execute(embedTask3);
		embedPool.execute(embedTask4);
//		embedPool.execute(embedTask5);
		embedTask1.join();
//		embedTask2.join();
		embedTask3.join();
		embedTask4.join();
//		embedTask5.join();
	}

	public void executeExperience360TestsPool(int number) {
		System.out.println();
		ForkJoinPool exp360Pool = new ForkJoinPool(number);

		RunTask task1 = new RunTask("winchrome", "exp360Suite");
//		RunTask task2 = new RunTask("firefox", "exp360Suite");
		RunTask task3 = new RunTask("edge", "exp360Suite");
		RunTask task4 = new RunTask("macchrome", "exp360Suite");
//		RunTask task5 = new RunTask("safari", "exp360Suite");
		exp360Pool.execute(task1);
//		exp360Pool.execute(task2);
		exp360Pool.execute(task3);
		exp360Pool.execute(task4);
//		exp360Pool.execute(task5);
		task1.join();
//		task2.join();
		task3.join();
		task4.join();
//		task5.join();
	}

	public void executeIWCCFormerSuperContentTestsPool(int number) {
		System.out.println();
		ForkJoinPool iwcFSCPool = new ForkJoinPool(number);

		RunTask task1 = new RunTask("winchrome", "iwcFormerSuperContentSuite");
//		RunTask task2 = new RunTask("firefox", "iwcFormerSuperContentSuite");
		RunTask task3 = new RunTask("edge", "iwcFormerSuperContentSuite");
		RunTask task4 = new RunTask("macchrome", "iwcFormerSuperContentSuite");
//		RunTask task5 = new RunTask("safari", "iwcFormerSuperContentSuite");
		iwcFSCPool.execute(task1);
//		iwcFSCPool.execute(task2);
//		iwcFSCPool.execute(task3);
		iwcFSCPool.execute(task4);
//		iwcFSCPool.execute(task5);
		task1.join();
//		task2.join();
		task3.join();
		task4.join();
//		task5.join();
	}
	
	public void executeSuperContentTestsPool(int number) {
		ForkJoinPool superContentPool = new ForkJoinPool(number);
		RunTask superContentTask1 = new RunTask("winchrome", "supercontentSuite");
//		RunTask superContentTask2 = new RunTask("firefox", "supercontentSuite");
		RunTask superContentTask3 = new RunTask("edge", "supercontentSuite");
		RunTask superContentTask4 = new RunTask("macchrome", "supercontentSuite");
//		RunTask superContentTask5 = new RunTask("safari", "supercontentSuite");
		superContentPool.execute(superContentTask1);
//		superContentPool.execute(superContentTask2);
		superContentPool.execute(superContentTask3);
		superContentPool.execute(superContentTask4);
//		superContentPool.execute(superContentTask5);
		superContentTask1.join();
//		superContentTask2.join();
		superContentTask3.join();
		superContentTask4.join();
//		superContentTask5.join();
	}
	
	public void executeDeskTopCIFTestsPool(int number) {
		System.out.println();
		ForkJoinPool desktopCIFPool = new ForkJoinPool(number);

		RunTask task1 = new RunTask("winchrome", "a1DesktopCIFSuite");
//		RunTask task2 = new RunTask("firefox", "a1DesktopCIFSuite");
		RunTask task3 = new RunTask("edge", "a1DesktopCIFSuite");
		RunTask task4 = new RunTask("macchrome", "a1DesktopCIFSuite");
//		RunTask task5 = new RunTask("safari", "a1DesktopCIFSuite");
		desktopCIFPool.execute(task1);
//		desktopCIFPool.execute(task2);
		desktopCIFPool.execute(task3);
		desktopCIFPool.execute(task4);
//		desktopCIFPool.execute(task5);
		task1.join();
//		task2.join();
		task3.join();
		task4.join();
//		task5.join();
	}

	public void executeDeskTopCIFTestsPool1(int number) {
		System.out.println();
		ForkJoinPool desktopCIFPool1 = new ForkJoinPool(number);

		RunTask task1 = new RunTask("winchrome", "b2DesktopCIFSuite");
//		RunTask task2 = new RunTask("firefox", "b2DesktopCIFSuite");
		RunTask task3 = new RunTask("edge", "b2DesktopCIFSuite");
		RunTask task4 = new RunTask("macchrome", "b2DesktopCIFSuite");
//		RunTask task5 = new RunTask("safari", "b2DesktopCIFSuite");
		desktopCIFPool1.execute(task1);
//		desktopCIFPool1.execute(task2);
		desktopCIFPool1.execute(task3);
		desktopCIFPool1.execute(task4);
//		desktopCIFPool1.execute(task5);
		task1.join();
//		task2.join();
		task3.join();
		task4.join();
//		task5.join();
	}
	
	public void executeDeskTopCIFTestsPool2(int number) {
		System.out.println();
		ForkJoinPool desktopCIFPool2 = new ForkJoinPool(number);

		RunTask task1 = new RunTask("winchrome", "c3DesktopCIFSuite");
//		RunTask task2 = new RunTask("firefox", "c3DesktopCIFSuite");
		RunTask task3 = new RunTask("edge", "c3DesktopCIFSuite");
		RunTask task4 = new RunTask("macchrome", "c3DesktopCIFSuite");
//		RunTask task5 = new RunTask("safari", "c3DesktopCIFSuite");
		desktopCIFPool2.execute(task1);
//		desktopCIFPool2.execute(task2);
		desktopCIFPool2.execute(task3);
		desktopCIFPool2.execute(task4);
//		desktopCIFPool2.execute(task5);
		task1.join();
//		task2.join();
		task3.join();
		task4.join();
//		task5.join();
	}
	
	public void executeDesktopRegistrationLegacyFormTestsPool(int number) {
		System.out.println();
		ForkJoinPool drlfPool = new ForkJoinPool(number);

		RunTask task1 = new RunTask("winchrome", "a1DrlfSuite");
//		RunTask task2 = new RunTask("firefox", "a1DrlfSuite");
		RunTask task3 = new RunTask("edge", "a1DrlfSuite");
		RunTask task4 = new RunTask("macchrome", "a1DrlfSuite");
//		RunTask task5 = new RunTask("safari", "a1DrlfSuite");
		drlfPool.execute(task1);
//		drlfPool.execute(task2);
		drlfPool.execute(task3);
		drlfPool.execute(task4);
//		drlfPool.execute(task5);
		task1.join();
//		task2.join();
		task3.join();
		task4.join();
//		task5.join();
	}

	public void executeDesktopRegistrationLegacyFormTestsPool1(int number) {
		System.out.println();
		ForkJoinPool drlfPool1 = new ForkJoinPool(number);

		RunTask task1 = new RunTask("winchrome", "b2DrlfSuite");
//		RunTask task2 = new RunTask("firefox", "b2DrlfSuite");
		RunTask task3 = new RunTask("edge", "b2DrlfSuite");
		RunTask task4 = new RunTask("macchrome", "b2DrlfSuite");
//		RunTask task5 = new RunTask("safari", "b2DrlfSuite");
		drlfPool1.execute(task1);
//		drlfPool1.execute(task2);
		drlfPool1.execute(task3);
		drlfPool1.execute(task4);
//		drlfPool1.execute(task5);
		task1.join();
//		task2.join();
		task3.join();
		task4.join();
//		task5.join();
	}
	
	public void executeDesktopIMAPTestsPool(int number) {
		System.out.println();
		ForkJoinPool drlfPool = new ForkJoinPool(number);

		RunTask task1 = new RunTask("winchrome", "imapSuite");
//		RunTask task2 = new RunTask("firefox", "imapSuite");
		RunTask task3 = new RunTask("edge", "imapSuite");
		RunTask task4 = new RunTask("macchrome", "imapSuite");
//		RunTask task5 = new RunTask("safari", "imapSuite");
		drlfPool.execute(task1);
//		drlfPool.execute(task2);
		drlfPool.execute(task3);
		drlfPool.execute(task4);
//		drlfPool.execute(task5);
		task1.join();
//		task2.join();
		task3.join();
		task4.join();
//		task5.join();
	}
	
	public void executeMobileCIFTestsPool(int number) {
		System.out.println();

		ForkJoinPool mobileCIfPool = new ForkJoinPool(number);

		RunTask task1 = new RunTask("androidchrome", "mobileCifSuite");
		RunTask task2 = new RunTask("mobileSafari", "mobileCifSuite");
		mobileCIfPool.execute(task1);
		mobileCIfPool.execute(task2);
		task1.join();
		task2.join();
	}
	
	public void executeMobileRegistrationLegacyFormestsPool(int number) {
		System.out.println();

		ForkJoinPool mobileCIfPool = new ForkJoinPool(number);

		RunTask task1 = new RunTask("androidchrome", "mobileRegistrationLegacyFormSuite");
		RunTask task2 = new RunTask("mobileSafari", "mobileRegistrationLegacyFormSuite");
		mobileCIfPool.execute(task1);
		mobileCIfPool.execute(task2);
		task1.join();
		task2.join();
	}
	
	
	public void executeFailedTests(int number) {
		System.out.println();
		
		ForkJoinPool drlfPool = new ForkJoinPool(number);

		path = System.getProperty("user.dir")+"/test-output/";
		
		RunTaskTemp task1 = new RunTaskTemp("localchrome", "testng-failed");

		drlfPool.execute(task1);

		task1.join();

	}
	
	public List<String> getTestSuites() {
		return testSuites;
	}

	public static void closeAllWorkingDrivers() {
		try {
			for(WebDriver driver: DriverInstance.getWorkingDriversList()) {
				SessionId s = ((RemoteWebDriver) driver).getSessionId();
				execDOSCurlCmd(s.toString());
				System.out.println("closing drivers one by one");
			}
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is exception while closing "+e.getMessage());
		}
		DriverInstance.getWorkingDriversList().clear();
	}

	public static void execDOSCurlCmd(String sessionid) {  
		try {
			// Execute command

			String command = "curl --user \"alex.zaltsman@youvisit.com:u08023faeb57c4dc\" --location --request DELETE \"https://@crossbrowsertesting.com/api/v3/selenium/"+sessionid+"\" --header \"Cookie: SERVERID=s2\"";
			System.out.println(command);
			Process child = Runtime.getRuntime().exec(command);
//			child.waitFor();
			Thread.sleep(2000);

			// Get output stream to write from it
			OutputStream out = child.getOutputStream();

			out.write("cd C:/ /r/n".getBytes());
			out.flush();
			out.write("dir /r/n".getBytes());
			out.close();
		} catch (Exception e) {
			System.err.println("exception while closing browser");
		} 
	}

}
