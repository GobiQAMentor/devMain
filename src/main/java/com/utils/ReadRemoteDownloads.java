package com.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.controls.ObjectsControl;
import com.driver.DriverInstance;


public class ReadRemoteDownloads{
	RemoteWebDriver remoteDriver;
	 
	public ReadRemoteDownloads(RemoteWebDriver driver) {
		this.remoteDriver = driver;
	} 


	public String get_file_content(String path, String browserName) {
			String file_content = null;
				try {
					WebElement elem = (WebElement) remoteDriver.executeScript(
						    "var input = window.document.createElement('INPUT'); "+
						    "input.setAttribute('type', 'file'); "+
						    "input.hidden = true; "+
						    "input.onchange = function (e) { e.stopPropagation() }; "+
						    "return window.document.documentElement.appendChild(input); "
						    ,"" );
					
					 elem.sendKeys(path);
				
				 file_content = (String) remoteDriver.executeAsyncScript(
							    "var input = arguments[0], callback = arguments[1]; "+
							    "var reader = new FileReader(); "+
							    "reader.onload = function (ev) { callback(reader.result) }; "+
							    "reader.onerror = function (ex) { callback(ex.message) }; "+
							    "reader.readAsDataURL(input.files[0]); "+
							    "input.remove(); "
							    , elem);
					
					if (!file_content.startsWith("data:")){
						System.out.println("Failed to get file content");
					}
				
				} catch (Exception e) {
					System.err.println(e);
				}
				
				try {
					FileOutputStream fos = null;
					if(browserName.equals("winchrome"))
						fos = new FileOutputStream(System.getProperty("user.dir") + File.separator + "downloads"+ File.separator + "chromedownloads" + File.separator + "EAB"+ObjectsControl.finalTime+".csv");
					if(browserName.equals("firefox"))
						fos = new FileOutputStream(System.getProperty("user.dir") + File.separator + "downloads"+ File.separator + "firefoxdownloads" + File.separator + "EAB.csv");
					if(browserName.equals("edge"))
						fos = new FileOutputStream(System.getProperty("user.dir") + File.separator + "downloads"+ File.separator + "edgedownloads" + File.separator + "EAB.csv");
					if(browserName.equals("safari"))
						fos = new FileOutputStream(System.getProperty("user.dir") + File.separator + "downloads"+ File.separator + "safaridownloads" + File.separator + "EAB.csv");
					if(browserName.equals("macchrome"))
						fos = new FileOutputStream(System.getProperty("user.dir") + File.separator + "downloads"+ File.separator + "macchromedownloads" + File.separator + "EAB.csv");		
					
					byte[] decoder = Base64.decodeBase64(file_content.substring(file_content.indexOf("base64,")+7));
					fos.write(decoder);
					System.out.println("File saved to local.");
    	      } catch (Exception e) {
    	    	  	e.printStackTrace();
    	      }
				return file_content;

			}
	 
		 public ArrayList get_downloaded_files(String browserName) throws Exception {
			 Thread.sleep(5000);
			 
				 remoteDriver.get("chrome://downloads");
		
				Thread.sleep(2000);
			 ArrayList filesFound = null;
				try {
//					if(!remoteDriver.getCurrentUrl().startsWith("chrome://downloads")) {
//						remoteDriver.get("chrome://downloads/");
//					}
//					if(!remoteDriver.getCurrentUrl().startsWith("firefox://downloads")) {
//						remoteDriver.get("firefox://downloads/");
//					}
//					if(!remoteDriver.getCurrentUrl().startsWith("edge://downloads")) {
//						remoteDriver.get("edge://downloads/");
//					}
					filesFound =  (ArrayList)  remoteDriver.executeScript(
					  "return  document.querySelector('downloads-manager')  "+
				      " .shadowRoot.querySelector('#downloadsList')         "+
				      " .items.filter(e => e.state === 'COMPLETE')          "+
				      " .map(e => e.filePath || e.file_path || e.fileUrl || e.file_url); ","");
				} catch (Exception e) {
					System.err.println(e);
				}
				return filesFound;
			}
		 
		 private String get_download_progress(RemoteWebDriver remoteDriver) {
			 String progress = null;
				try {
					
					progress=  (String) remoteDriver.executeScript(						
							"var tag = document.querySelector('downloads-manager').shadowRoot;"+
						    "var intag = tag.querySelector('downloads-item').shadowRoot;"+
						    "var progress_tag = intag.getElementById('progress');"+
						    "var progress = null;"+
						   " if(progress_tag) { "+
						    "    progress = progress_tag.value; "+
						  "  }" +
						    "return progress;"
							,"");
					
		
				} catch (Exception e) {
					System.err.println(e);
				}
				return progress;
			}
		 
		 private ArrayList get_download_progress_all(RemoteWebDriver remoteDriver) {
			 ArrayList progress = null;
				try {
			
					progress=  (ArrayList) remoteDriver.executeScript(						
							" var tag = document.querySelector('downloads-manager').shadowRoot;" + 
							"			    var item_tags = tag.querySelectorAll('downloads-item');" + 
							"			    var item_tags_length = item_tags.length;" + 
							"			    var progress_lst = [];" + 
							"			    for(var i=0; i<item_tags_length; i++) {" + 
							"			        var intag = item_tags[i].shadowRoot;" + 
							"			        var progress_tag = intag.getElementById('progress');" + 
							"			        var progress = null;" + 
							"			        if(progress_tag) {" + 
							"			            var progress = progress_tag.value;" + 
							"			        }" + 
							"			        progress_lst.push(progress);" + 
							"			    }" + 
							"			    return progress_lst",
							"");
					
		
				} catch (Exception e) {
					System.err.println(e);
				}
				return progress;
			}	
	
}