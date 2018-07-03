package com.OneAssist.API_Automation.helperClasses;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonHelper {

	static Gson gsonObj;
	
	public JsonHelper() {
		super();
	}
	
	static {
		gsonObj = new GsonBuilder().setPrettyPrinting().create();
	}
	
	public static String getJsonStringFromJsonObject(Object src) {
		return gsonObj.toJson(src);
	}
	
	public static String getJsonStringFromMapData(Map<String,String> mapData) {
		modifyApiMapdataWithRelevantValues(mapData);
		String jsonStr = gsonObj.toJson(mapData);
		System.out.println(jsonStr);
		return jsonStr;
	}
	
	public static Map<String,String> modifyApiMapdataWithRelevantValues(Map<String,String> mapData){
		//Map<String,String> updtMapData = new HashMap<String,String>();
		LocalDate sysDate = java.time.LocalDate.now();
		for (Map.Entry<String,String> entry : mapData.entrySet()) {
            System.out.println("Key = " + entry.getKey() +
                             ", Value = " + entry.getValue());
            if("SKIP".equals(entry.getValue())) {
            	mapData.remove(entry.getKey(),entry.getValue());
            }
            else if("CURRENT_DATE".equals(entry.getValue())) {
            	mapData.replace(entry.getKey(),sysDate.toString());
            }
            else {
            	
            }
		}
		return mapData;
	}
	
	public static <T> T setResponsePojoClass(String json, Class<T> classOfT) {
		return gsonObj.fromJson(json, classOfT);
	}
}
