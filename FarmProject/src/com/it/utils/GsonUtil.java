package com.it.utils;

import com.google.gson.Gson;

public class GsonUtil {
	
	private static Gson gson = new Gson();
	
	public static Object toJson(Object data){
		
		return gson.toJson(data);
	}
	
	public static Object fromJson(String data,Class clazz){
		return gson.fromJson(data,clazz);
	}
}
