package com.it.utils;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;


public class JsonUtil {

	public static String getJson(Map<String, String> paramMap) throws JSONException {
		if (MapUtils.isNotEmpty(paramMap)) {
			JSONObject jsonObject = new JSONObject();		

			for (Entry<String, String> entry : paramMap.entrySet()) {
				if (StringUtils.isNotEmpty(entry.getValue())) {
					jsonObject.put(entry.getKey() , entry.getValue());
				}
			}

			if (jsonObject !=null) {
				return jsonObject.toString();
			}
		}

		return "{}";
	}
	
}
