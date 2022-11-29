
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

public class AndroidChromeRunTaskTemp extends RecursiveAction{
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

	AndroidChromeRunTaskTemp(String browserName, String testSuite){
		this.browserName = browserName;
		this.testSuite = testSuite;
	}

	AndroidChromeRunTaskTemp(String path, String browserName, String testSuite){
		this.path = path;
		this.browserName = browserName;
		this.testSuite = testSuite;
	}

	AndroidChromeRunTaskTemp(){

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
		AndroidChromeRunTaskTemp task =new AndroidChromeRunTaskTemp();


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

	}



	public void executeMobileRegistrationLegacy(int number) {
		System.out.println();
		ForkJoinPool mobileRegistratiionLegacy = new ForkJoinPool(number);
		AndroidChromeRunTaskTemp task1 = new AndroidChromeRunTaskTemp(androidChromePath,"androidchrome", "mobileRegistrationLegacyFormSuite");
		mobileRegistratiionLegacy.execute(task1);
		task1.join();
	}

	public void executeMobileCif(int number) {
		System.out.println();
		ForkJoinPool mobileCif = new ForkJoinPool(number);
		AndroidChromeRunTaskTemp task1 = new AndroidChromeRunTaskTemp(androidChromePath,"androidchrome", "mobileCifSuite");
		mobileCif.execute(task1);
		task1.join();
	}

	public void executeMobileImap(int number) {
		System.out.println();
		ForkJoinPool mobileImap = new ForkJoinPool(number);
		AndroidChromeRunTaskTemp task1 = new AndroidChromeRunTaskTemp(androidChromePath,"androidchrome", "mobileImapSuite");
		mobileImap.execute(task1);
		task1.join();
	}

	public void executeIosSafariMobileRegistrationLegacy(int number) {
		System.out.println();
		ForkJoinPool mobileRegistratiionLegacy = new ForkJoinPool(number);
		AndroidChromeRunTaskTemp task1 = new AndroidChromeRunTaskTemp(iosSafariPath,"iossafari", "mobileRegistrationLegacyFormSuite");
		mobileRegistratiionLegacy.execute(task1);
		task1.join();
	}

	public void executeIosSafariMobileCif(int number) {
		System.out.println();
		ForkJoinPool mobileCif = new ForkJoinPool(number);
		AndroidChromeRunTaskTemp task1 = new AndroidChromeRunTaskTemp(iosSafariPath,"iossafari", "mobileCifSuite");
		mobileCif.execute(task1);
		task1.join();
	}

	public void executeIosSafariMobileImap(int number) {
		System.out.println();
		ForkJoinPool mobileImap = new ForkJoinPool(number);
		AndroidChromeRunTaskTemp task1 = new AndroidChromeRunTaskTemp(iosSafariPath,"iossafari", "mobileImapSuite");
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

