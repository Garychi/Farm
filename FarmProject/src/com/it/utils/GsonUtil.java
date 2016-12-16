package com.it.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
	
	private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	
	public static Object toJson(Object data){		
		return gson.toJson(data);
	}
	
	public static Object fromJson(String data,Class clazz){
		return gson.fromJson(data,clazz);
	}
}
