package com.test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.math.NumberUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;

public class GsonDeserializer implements JsonDeserializer<Map<String, Object>> {

	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Object> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return (Map<String, Object>) read(json);
	}

	private Object read(JsonElement in) {
		if (in.isJsonArray()) {
			List<Object> list = new ArrayList<Object>();
			JsonArray arr = in.getAsJsonArray();
			for (JsonElement anArr : arr) {
				list.add(read(anArr));
			}
			return list;
		} else if (in.isJsonObject()) {
			Map<String, Object> map = new LinkedTreeMap<String, Object>();
			JsonObject obj = in.getAsJsonObject();
			Set<Entry<String, JsonElement>> entitySet = obj.entrySet();
			for (Entry<String, JsonElement> entry : entitySet) {
				map.put(entry.getKey(), read(entry.getValue()));
			}
			return map;
		} else if (in.isJsonPrimitive()) {
			JsonPrimitive prim = in.getAsJsonPrimitive();
			if (prim.isBoolean()) {
				return prim.getAsBoolean();
			} else if (prim.isString()) {
				return prim.getAsString();
			} else if (prim.isNumber()) {
				
				Number num = prim.getAsNumber();
				
				if (NumberUtils.isDigits(num.toString())) {
					return num.intValue();
				} else if (Math.ceil(num.doubleValue()) == num.longValue())
					return num.longValue();
				else {
					return num.doubleValue();
				}
			}
		}
		return null;
	}
}
