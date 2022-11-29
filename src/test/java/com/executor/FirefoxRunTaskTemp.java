
package com.executor;

import java.io.File;
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

public class FirefoxRunTaskTemp extends RecursiveAction{
	List<String> testSuites = new ArrayList<String>();

	ArrayList<String> suiteNameArray = new ArrayList<String>();
	//	public static boolean reExecution = false;
	String reExecutedString="", suite="";
	public String testSuite;
	public String browserName;
	public String path= "";
	public static final String winchromePath = System.getProperty("user.dir")+"/src/test/resources/testrunner/winchrome/";
	public static final String firefoxPath = System.getProperty("user.dir")+"/src/test/resources/testrunner/firefox/";
	public static final String macchromePath = System.getProperty("user.dir")+"/src/test/resources/testrunner/macchrome/";
	public static final String edgePath = System.getProperty("user.dir")+"/src/test/resources/testrunner/edge/";
	public static final String safariPath = System.getProperty("user.dir")+"/src/test/resources/testrunner/safari/";
	public static final String localPath = System.getProperty("user.dir")+"/src/test/resources/testrunner/local/";
	public static final String androidChromePath = System.getProperty("user.dir")+"/src/test/resources/testrunner/androidchrome/";
	public static final String iosSafariPath = System.getProperty("user.dir")+"/src/test/resources/testrunner/iossafari/";

	public static List<String> browserList = new ArrayList<String>();


	static {
		UtilityClass.moveAllOldReports();
		System.setProperty("extent.reporter.spark.out", "reports/HtmlReport/"+UtilityClass.getDynamicReportName()+"_allSuites.html");
	}

	FirefoxRunTaskTemp(String browserName, String testSuite){
		this.browserName = browserName;
		this.testSuite = testSuite;
	}

	FirefoxRunTaskTemp(String path, String browserName, String testSuite){
		this.path = path;
		this.browserName = browserName;
		this.testSuite = testSuite;
	}

	FirefoxRunTaskTemp(){

	}

	@Override
	protected void compute() {
		// TODO Auto-generated method stub

		//		int noOfBrowsers = browserList.size();
		String fileName = null;
		if(path.equals(""))
			fileName = System.getProperty("user.dir")+"/src/test/resources/testrunner/"+testSuite+".xml";
		else
			fileName = path +testSuite+".xml";

		File testFile = new File(fileName);

		Thread.currentThread().setName(browserName);
		testSuites.add(testFile.getAbsolutePath());
		processTask();


	}

	private void processTask() {

		TestNG testng = new TestNG();
		if (testSuites != null && !testSuites.isEmpty()) {
			System.out.println(testSuites);
			//			testng.setGroups(browserName);
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
		FirefoxRunTaskTemp task =new FirefoxRunTaskTemp();

/*
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
*/
		try {
			task.executeAapTestsPool(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}

		closeAllWorkingDrivers();
/*
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
			task.executeDeskTopCIFTestsPool3(numberOfProcessors);
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
			task.executeDesktopRegistrationLegacyFormTestsPool2(numberOfProcessors);
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

		Thread.sleep(5000);
		try {
			task.executeMobileRegistrationLegacy(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		closeAllWorkingDrivers();

		Thread.sleep(5000);
		try {
			task.executeMobileCif(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		closeAllWorkingDrivers();

		Thread.sleep(5000);
		try {
			task.executeMobileImap(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		closeAllWorkingDrivers();

		Thread.sleep(5000);
		try {
			task.executeIosSafariMobileRegistrationLegacy(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		closeAllWorkingDrivers();


		Thread.sleep(5000);
		try {
			task.executeIosSafariMobileCif(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		closeAllWorkingDrivers();

		Thread.sleep(5000);
		try {
			task.executeIosSafariMobileImap(numberOfProcessors);
		}
		catch(Exception e) {
			System.err.println("exception is "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		closeAllWorkingDrivers();
*/
	}

	public void executeAapTestsPool(int number) {
		System.out.println();
		ForkJoinPool aapPool = new ForkJoinPool(number);
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(localPath,"localchrome", "aapSuite1");
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(winchromePath,"winchrome", "aapSuite1");
		FirefoxRunTaskTemp task2 = new FirefoxRunTaskTemp(firefoxPath, "firefox", "aapSuite1");
//		FirefoxRunTaskTemp task3 = new FirefoxRunTaskTemp(edgePath, "edge", "aapSuite1");
//		FirefoxRunTaskTemp task4 = new FirefoxRunTaskTemp(macchromePath, "macchrome", "aapSuite1");
//		FirefoxRunTaskTemp task5 = new FirefoxRunTaskTemp(safariPath, "safari", "aapSuite1");
//		aapPool.execute(task1);
		aapPool.execute(task2);
//		aapPool.execute(task3);
//		aapPool.execute(task4);
//		aapPool.execute(task5);
//		task1.join();
		task2.join();
//		task3.join();
//		task4.join();
//		task5.join();
	}
	public void executeAapTestsPool2(int number) {
		System.out.println();
		ForkJoinPool aapPool = new ForkJoinPool(number);
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(localPath,"localchrome", "aapSuite2");
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(winchromePath,"winchrome", "aapSuite2");
		FirefoxRunTaskTemp task2 = new FirefoxRunTaskTemp(firefoxPath, "firefox", "aapSuite2");
//		FirefoxRunTaskTemp task3 = new FirefoxRunTaskTemp(edgePath, "edge", "aapSuite2");
//		FirefoxRunTaskTemp task4 = new FirefoxRunTaskTemp(macchromePath, "macchrome", "aapSuite2");
//		FirefoxRunTaskTemp task5 = new FirefoxRunTaskTemp(safariPath, "safari", "aapSuite2");
//		aapPool.execute(task1);
		aapPool.execute(task2);
//		aapPool.execute(task3);
//		aapPool.execute(task4);
//		aapPool.execute(task5);
//		task1.join();
		task2.join();
//		task3.join();
//		task4.join();
//		task5.join();
	}

	public void executeEmbedTestsPool(int number) {
		ForkJoinPool embedPool = new ForkJoinPool(number);
//		FirefoxRunTaskTemp embedTask1 = new FirefoxRunTaskTemp(localPath,"localchrome", "embedSuite");
//		FirefoxRunTaskTemp embedTask1 = new FirefoxRunTaskTemp(winchromePath,"winchrome", "embedSuite");
		FirefoxRunTaskTemp embedTask2 = new FirefoxRunTaskTemp(firefoxPath, "firefox", "embedSuite");
//		FirefoxRunTaskTemp embedTask3 = new FirefoxRunTaskTemp(edgePath, "edge", "embedSuite");
//		FirefoxRunTaskTemp embedTask4 = new FirefoxRunTaskTemp(macchromePath, "macchrome", "embedSuite");
//		FirefoxRunTaskTemp embedTask5 = new FirefoxRunTaskTemp(safariPath, "safari", "embedSuite");
//		embedPool.execute(embedTask1);
		embedPool.execute(embedTask2);
//		embedPool.execute(embedTask3);
//		embedPool.execute(embedTask4);
//		embedPool.execute(embedTask5);
//		embedTask1.join();
		embedTask2.join();
//		embedTask3.join();
//		embedTask4.join();
//		embedTask5.join();
	}

	public void executeExperience360TestsPool(int number) {
		System.out.println();
		ForkJoinPool exp360Pool = new ForkJoinPool(number);
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(localPath,"localchrome", "exp360Suite");
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(winchromePath,"winchrome", "exp360Suite");
		FirefoxRunTaskTemp task2 = new FirefoxRunTaskTemp(firefoxPath, "firefox", "exp360Suite");
//		FirefoxRunTaskTemp task3 = new FirefoxRunTaskTemp(edgePath, "edge", "exp360Suite");
//		FirefoxRunTaskTemp task4 = new FirefoxRunTaskTemp(macchromePath, "macchrome", "exp360Suite");
//		FirefoxRunTaskTemp task5 = new FirefoxRunTaskTemp(safariPath, "safari", "exp360Suite");
//		exp360Pool.execute(task1);
		exp360Pool.execute(task2);
//		exp360Pool.execute(task3);
//		exp360Pool.execute(task4);
//		exp360Pool.execute(task5);
//		task1.join();
		task2.join();
//		task3.join();
//		task4.join();
//		task5.join();
	}

	public void executeIWCCFormerSuperContentTestsPool(int number) {
		System.out.println();
		ForkJoinPool iwcFSCPool = new ForkJoinPool(number);
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(localPath,"localchrome", "iwcFormerSuperContentSuite");
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(winchromePath,"winchrome", "iwcFormerSuperContentSuite");
		FirefoxRunTaskTemp task2 = new FirefoxRunTaskTemp(firefoxPath, "firefox", "iwcFormerSuperContentSuite");
//		FirefoxRunTaskTemp task3 = new FirefoxRunTaskTemp(edgePath, "edge", "iwcFormerSuperContentSuite");
//		FirefoxRunTaskTemp task4 = new FirefoxRunTaskTemp(macchromePath, "macchrome", "iwcFormerSuperContentSuite");
//		FirefoxRunTaskTemp task5 = new FirefoxRunTaskTemp(safariPath, "safari", "iwcFormerSuperContentSuite");
//		iwcFSCPool.execute(task1);
		iwcFSCPool.execute(task2);
//		iwcFSCPool.execute(task3);
//		iwcFSCPool.execute(task4);
//		iwcFSCPool.execute(task5);
//		task1.join();
		task2.join();
//		task3.join();
//		task4.join();
//		task5.join();
	}

	public void executeSuperContentTestsPool(int number) {
		ForkJoinPool superContentPool = new ForkJoinPool(number);
//		FirefoxRunTaskTemp superContentTask1 = new FirefoxRunTaskTemp(localPath,"localchrome", "supercontentSuite");
//		FirefoxRunTaskTemp superContentTask1 = new FirefoxRunTaskTemp(winchromePath,"winchrome", "supercontentSuite");
		FirefoxRunTaskTemp superContentTask2 = new FirefoxRunTaskTemp(firefoxPath, "firefox", "supercontentSuite");
//		FirefoxRunTaskTemp superContentTask3 = new FirefoxRunTaskTemp(edgePath, "edge", "supercontentSuite");
//		FirefoxRunTaskTemp superContentTask4 = new FirefoxRunTaskTemp(macchromePath, "macchrome", "supercontentSuite");
//		FirefoxRunTaskTemp superContentTask5 = new FirefoxRunTaskTemp(safariPath, "safari", "supercontentSuite");
//		superContentPool.execute(superContentTask1);
		superContentPool.execute(superContentTask2);
//		superContentPool.execute(superContentTask3);
//		superContentPool.execute(superContentTask4);
//		superContentPool.execute(superContentTask5);
//		superContentTask1.join();
		superContentTask2.join();
//		superContentTask3.join();
//		superContentTask4.join();
//		superContentTask5.join();
	}


	public void executeDeskTopCIFTestsPool1(int number) {
		System.out.println();
		ForkJoinPool desktopCIFPool1 = new ForkJoinPool(number);
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(localPath,"localchrome", "a1DesktopCIFSuite");
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(winchromePath,"winchrome", "a1DesktopCIFSuite");
		FirefoxRunTaskTemp task2 = new FirefoxRunTaskTemp(firefoxPath, "firefox", "a1DesktopCIFSuite");
//		FirefoxRunTaskTemp task3 = new FirefoxRunTaskTemp(edgePath, "edge", "a1DesktopCIFSuite");
//		FirefoxRunTaskTemp task4 = new FirefoxRunTaskTemp(macchromePath, "macchrome", "a1DesktopCIFSuite");
//		FirefoxRunTaskTemp task5 = new FirefoxRunTaskTemp(safariPath, "safari", "a1DesktopCIFSuite");
//		desktopCIFPool1.execute(task1);
		desktopCIFPool1.execute(task2);
//		desktopCIFPool1.execute(task3);
//		desktopCIFPool1.execute(task4);
//		desktopCIFPool1.execute(task5);
//		task1.join();
		task2.join();
//		task3.join();
//		task4.join();
//		task5.join();
	}


	public void executeDeskTopCIFTestsPool2(int number) {
		System.out.println();
		ForkJoinPool desktopCIFPool2 = new ForkJoinPool(number);
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(localPath,"localchrome", "b2DesktopCIFSuite");
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(winchromePath,"winchrome", "b2DesktopCIFSuite");
		FirefoxRunTaskTemp task2 = new FirefoxRunTaskTemp(firefoxPath, "firefox", "b2DesktopCIFSuite");
//		FirefoxRunTaskTemp task3 = new FirefoxRunTaskTemp(edgePath, "edge", "b2DesktopCIFSuite");
//		FirefoxRunTaskTemp task4 = new FirefoxRunTaskTemp(macchromePath, "macchrome", "b2DesktopCIFSuite");
//		FirefoxRunTaskTemp task5 = new FirefoxRunTaskTemp(safariPath, "safari", "b2DesktopCIFSuite");
//		desktopCIFPool2.execute(task1);
		desktopCIFPool2.execute(task2);
//		desktopCIFPool2.execute(task3);
//		desktopCIFPool2.execute(task4);
//		desktopCIFPool2.execute(task5);
//		task1.join();
		task2.join();
//		task3.join();
//		task4.join();
//		task5.join();
	}

	public void executeDeskTopCIFTestsPool3(int number) {
		System.out.println();
		ForkJoinPool desktopCIFPool3 = new ForkJoinPool(number);
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(localPath,"localchrome", "c3DesktopCIFSuite");
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(winchromePath,"winchrome", "c3DesktopCIFSuite");
		FirefoxRunTaskTemp task2 = new FirefoxRunTaskTemp(firefoxPath, "firefox", "c3DesktopCIFSuite");
//		FirefoxRunTaskTemp task3 = new FirefoxRunTaskTemp(edgePath, "edge", "c3DesktopCIFSuite");
//		FirefoxRunTaskTemp task4 = new FirefoxRunTaskTemp(macchromePath, "macchrome", "c3DesktopCIFSuite");
//		FirefoxRunTaskTemp task5 = new FirefoxRunTaskTemp(safariPath, "safari", "c3DesktopCIFSuite");
//		desktopCIFPool3.execute(task1);
		desktopCIFPool3.execute(task2);
//		desktopCIFPool3.execute(task3);
//		desktopCIFPool3.execute(task4);
//		desktopCIFPool3.execute(task5);
//		task1.join();
		task2.join();
//		task3.join();
//		task4.join();
//		task5.join();
	}

	public void executeDesktopRegistrationLegacyFormTestsPool1(int number) {
		System.out.println();
		ForkJoinPool drlfPool1 = new ForkJoinPool(number);
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(localPath,"localchrome", "a1DrlfSuite");
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(winchromePath,"winchrome", "a1DrlfSuite");
		FirefoxRunTaskTemp task2 = new FirefoxRunTaskTemp(firefoxPath, "firefox", "a1DrlfSuite");
//		FirefoxRunTaskTemp task3 = new FirefoxRunTaskTemp(edgePath, "edge", "a1DrlfSuite");
//		FirefoxRunTaskTemp task4 = new FirefoxRunTaskTemp(macchromePath, "macchrome", "a1DrlfSuite");
//		FirefoxRunTaskTemp task5 = new FirefoxRunTaskTemp(safariPath, "safari", "a1DrlfSuite");
//		drlfPool1.execute(task1);
		drlfPool1.execute(task2);
//		drlfPool1.execute(task3);
//		drlfPool1.execute(task4);
//		drlfPool1.execute(task5);
//		task1.join();
		task2.join();
//		task3.join();
//		task4.join();
//		task5.join();
	}

	public void executeDesktopRegistrationLegacyFormTestsPool2(int number) {
		System.out.println();
		ForkJoinPool drlfPool2 = new ForkJoinPool(number);
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(localPath,"localchrome", "b2DrlfSuite");
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(winchromePath,"winchrome", "b2DrlfSuite");
		FirefoxRunTaskTemp task2 = new FirefoxRunTaskTemp(firefoxPath, "firefox", "b2DrlfSuite");
//		FirefoxRunTaskTemp task3 = new FirefoxRunTaskTemp(edgePath, "edge", "b2DrlfSuite");
//		FirefoxRunTaskTemp task4 = new FirefoxRunTaskTemp(macchromePath, "macchrome", "b2DrlfSuite");
//		FirefoxRunTaskTemp task5 = new FirefoxRunTaskTemp(safariPath, "safari", "b2DrlfSuite");
//		drlfPool2.execute(task1);
		drlfPool2.execute(task2);
//		drlfPool2.execute(task3);
//		drlfPool2.execute(task4);
//		drlfPool2.execute(task5);
//		task1.join();
		task2.join();
//		task3.join();
//		task4.join();
//		task5.join();
	}

	public void executeDesktopIMAPTestsPool(int number) {
		System.out.println();
		ForkJoinPool drlfPool = new ForkJoinPool(number);
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(localPath,"localchrome", "imapSuite");
//		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(winchromePath,"winchrome", "imapSuite");
		FirefoxRunTaskTemp task2 = new FirefoxRunTaskTemp(firefoxPath, "firefox", "imapSuite");
//		FirefoxRunTaskTemp task3 = new FirefoxRunTaskTemp(edgePath, "edge", "imapSuite");
//		FirefoxRunTaskTemp task4 = new FirefoxRunTaskTemp(macchromePath, "macchrome", "imapSuite");
//		FirefoxRunTaskTemp task5 = new FirefoxRunTaskTemp(safariPath, "safari", "imapSuite");
//		drlfPool.execute(task1);
		drlfPool.execute(task2);
//		drlfPool.execute(task3);
//		drlfPool.execute(task4);
//		drlfPool.execute(task5);
//		task1.join();
		task2.join();
//		task3.join();
//		task4.join();
//		task5.join();
	}

	public void executeMobileRegistrationLegacy(int number) {
		System.out.println();
		ForkJoinPool mobileRegistratiionLegacy = new ForkJoinPool(number);
		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(androidChromePath,"androidchrome", "mobileRegistrationLegacyFormSuite");
		mobileRegistratiionLegacy.execute(task1);
		task1.join();
	}

	public void executeMobileCif(int number) {
		System.out.println();
		ForkJoinPool mobileCif = new ForkJoinPool(number);
		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(androidChromePath,"androidchrome", "mobileCifSuite");
		mobileCif.execute(task1);
		task1.join();
	}

	public void executeMobileImap(int number) {
		System.out.println();
		ForkJoinPool mobileImap = new ForkJoinPool(number);
		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(androidChromePath,"androidchrome", "mobileImapSuite");
		mobileImap.execute(task1);
		task1.join();
	}

	public void executeIosSafariMobileRegistrationLegacy(int number) {
		System.out.println();
		ForkJoinPool mobileRegistratiionLegacy = new ForkJoinPool(number);
		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(iosSafariPath,"iossafari", "mobileRegistrationLegacyFormSuite");
		mobileRegistratiionLegacy.execute(task1);
		task1.join();
	}

	public void executeIosSafariMobileCif(int number) {
		System.out.println();
		ForkJoinPool mobileCif = new ForkJoinPool(number);
		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(iosSafariPath,"iossafari", "mobileCifSuite");
		mobileCif.execute(task1);
		task1.join();
	}

	public void executeIosSafariMobileImap(int number) {
		System.out.println();
		ForkJoinPool mobileImap = new ForkJoinPool(number);
		FirefoxRunTaskTemp task1 = new FirefoxRunTaskTemp(iosSafariPath,"iossafari", "mobileImapSuite");
		mobileImap.execute(task1);
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

