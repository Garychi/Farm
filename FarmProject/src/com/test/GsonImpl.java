package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.model.TestModel;

public class GsonImpl {

	public static void main(String args[]) {
		GsonImpl test = new GsonImpl();
		test.test();
	}

	public Object test() {
		Object result = null;
		List list = new ArrayList();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(new TypeToken<Map <String, Object>>(){}.getType(),  new GsonDeserializer());
		Gson gson = gsonBuilder.create();

		TestModel model = new TestModel();
		model.setName("AOA");
		model.setValue(3);
		model.setOath("Promise");
		list.add(model);
		
		model = new TestModel();
		model.setName("SNSD");
		model.setValue(10);
		model.setOath("SM");
		list.add(model);
		
	
		String json = gson.toJson(list);

		Object map = gson.fromJson(json, new TypeToken<List<Map<String, Object>>>(){}.getType());

		String s ="aaa";
		return result;
	}

}
