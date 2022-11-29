package verifyTestPages;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONreading {
	static JsonParser parser = new JsonParser();

	public String jsonResultString = "{\"success\":false,\"message\":\"Missing entry count in one of the required for (modules:2!=1, stops:3!=1).\","
			+ "\"payload\":{\"userkey\":\"92043631635777716\",\"query-period\":\"last 15 minutes. \","
			+ "\"session\":[{\"id\":\"74796\",\"start_time\":\"2022-09-21 10:01:24\",\"end_time\":\"2022-09-21 10:03:24\",\"session_length\":\"200\"}],"
			+ "\"actions\":[{\"id\":\"3660\",\"create_date\":\"2022-09-21 10:02:41\"}],"
			+ "\"modules\":[{\"id\":\"82110\",\"start_time\":\"2022-09-21 10:01:29\",\"end_time\":\"2022-09-21 10:01:34\"},"
			+ "{\"id\":\"82111\",\"start_time\":\"2022-09-21 10:01:37\",\"end_time\":\"2022-09-21 10:03:24\"}],"
			+ "\"stops\":[{\"id\":\"57864\",\"stopid\":\"233\",\"start_time\":\"2022-09-21 10:01:35\",\"end_time\":\"2022-09-21 10:03:01\"},"
			+ "{\"id\":\"57862\",\"stopid\":\"270746\",\"start_time\":\"2022-09-21 10:01:26\",\"end_time\":\"2022-09-21 10:01:34\"},"
			+ "{\"id\":\"57865\",\"stopid\":\"270746\",\"start_time\":\"2022-09-21 10:03:01\",\"end_time\":\"2022-09-21 10:03:24\"}],"
			+ "\"registration\":[]},\"clean-status\":\"n\\/a\"}";

	public static void main(String[] args) throws ParseException, MalformedURLException {
		JSONreading jsr = new JSONreading();
		String inline = jsr.jsonResultString;
		
		jsr.parseJsonString(inline, "stops", "start_time");
		
		//getExpectedGMTTime();
		
		jsr.getURL();
		
//		HashMap<String, Object> map = createHashMapFromJsonString(inline);
//		for (String key : map.keySet()) {
//			   System.out.println(key + " : " + map.get(key).toString());
//		}
	}
	
	public void getURL() throws MalformedURLException {
		String address = "https://staging.youvisit.com/tour/stonybrook";
		URL url = new URL(address);
		String validationURL = url.getHost();
		System.out.println(validationURL);
	}
	
	public static void getExpectedGMTTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		System.out.println("GMT time: " + sdf.format(currentTime));
		Date addedHours = new Date(currentTime.getTime() + TimeUnit.HOURS.toMillis(4));
		Date ExpectedTimeInGMT = new Date(addedHours.getTime() + TimeUnit.SECONDS.toMillis(0));
		System.out.println("GMT time: " + sdf.format(ExpectedTimeInGMT));
	}
	
	public void parseJsonString(String response, String apiTables, String key) {
		String[] value = null;
		try {
			JSONParser parse = new JSONParser();
			JSONObject data_obj = (JSONObject) parse.parse(response);

			//Get the required object from the above created object
			JSONObject obj = (JSONObject) data_obj.get("payload");

			//Get the required data using its key
			System.out.println(obj.get(apiTables));
    		 JSONArray arr = (JSONArray) obj.get(apiTables);
    		 value = new String[arr.size()];
    		 System.out.println("Size = : "+ arr.size());
			 for (int i = 0; i < arr.size(); i++) {
                 JSONObject new_obj = (JSONObject) arr.get(i);
                 if(new_obj.get(key)!=null) {
                	 value[i] = (String) new_obj.get(key);
                	 System.out.println(new_obj.get(key));
                 }
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < value.length; i++)
			System.out.println(value[i]);

	}
	public static HashMap<String, Object> createHashMapFromJsonString(String json) {

	    JsonObject object = (JsonObject) parser.parse(json);
	    Set<Map.Entry<String, JsonElement>> set = object.entrySet();
	    Iterator<Map.Entry<String, JsonElement>> iterator = set.iterator();
	    HashMap<String, Object> map = new HashMap<String, Object>();

	    while (iterator.hasNext()) {

	        Map.Entry<String, JsonElement> entry = iterator.next();
	        String key = entry.getKey();
	        JsonElement value = entry.getValue();

	        if (null != value) {
	            if (!value.isJsonPrimitive()) {
	                if (value.isJsonObject()) {

	                    map.put(key, createHashMapFromJsonString(value.toString()));
	                } else if (value.isJsonArray() && value.toString().contains(":")) {

	                    List<HashMap<String, Object>> list = new ArrayList<>();
	                    JsonArray array = value.getAsJsonArray();
	                    if (null != array) {
	                        for (JsonElement element : array) {
	                            list.add(createHashMapFromJsonString(element.toString()));
	                        }
	                        map.put(key, list);
	                    }
	                } else if (value.isJsonArray() && !value.toString().contains(":")) {
	                    map.put(key, value.getAsJsonArray());
	                }
	            } else {
	                map.put(key, value.getAsString());
	            }
	        }
	    }
	    return map;
	}
}
