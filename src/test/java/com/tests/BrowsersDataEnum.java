package com.tests;

import java.util.HashMap;

public enum BrowsersDataEnum {
		WINCHROME,
		FIREFOX,
		EDGE,
		SAFARI,
		MACCHROME,
		LOCAL;
	
	public static HashMap<BrowsersDataEnum, String> map = new HashMap<BrowsersDataEnum, String>();
	
	public static void dataInMap() {
			map.put(BrowsersDataEnum.WINCHROME, "winchrome");
			map.put(BrowsersDataEnum.FIREFOX, "firefox");
			map.put(BrowsersDataEnum.EDGE, "edge");
			map.put(BrowsersDataEnum.SAFARI, "safari");
			map.put(BrowsersDataEnum.MACCHROME, "macchrome");
			map.put(BrowsersDataEnum.LOCAL, "localchrome");
		}
	
}
