package com.it.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.MapUtils;

public class ClassReflectionUtil {

	/**
	 * change Map to Object
	 * @param map
	 * @return
	 */
	public static List<Object> changeMapToObject(Map<String, Object> map) {
		List<Object> result = new ArrayList<Object>();

		if (MapUtils.isNotEmpty(map)) {
			for (Entry<String, Object> entry : map.entrySet()) {
				Object localObject = null;
				Class<?> clazz = entry.getValue().getClass();
				try {
					localObject = clazz.newInstance();
					Method methods[] = clazz.getDeclaredMethods();
					for (Method method : methods) {
						if (method.getName().startsWith("set")) {
							try {
								method.setAccessible(true);
								method.invoke(localObject , entry.getValue());
								method.setAccessible(false);
							}
							catch (IllegalArgumentException | InvocationTargetException e) {

								e.printStackTrace();
							}
						}
					}
					result.add(localObject);
				}
				catch (InstantiationException | IllegalAccessException e) {

					e.printStackTrace();
				}
			}
		}
		return result;
	}

	/**
	 * 設定多租戶
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unused")
	public static Object setManageColumnValue(Class<?> clazz) {
		Object localObject = null;
		if (clazz != null) {
			String className = clazz.getName();
			Method methods[] = clazz.getDeclaredMethods();
			try {
				localObject = clazz.newInstance();

				Map<String, Object> manageMap = MultitenancyUtil.getManageColumnMap();

				if (MapUtils.isNotEmpty(manageMap)) {
					for (Entry<String, Object> entry : manageMap.entrySet()) {
						for (Method method : methods) {
							String methodName = method.getName();
							if (methodName.startsWith("set")) {
								methodName = methodName.substring(3 , methodName.length());
								if (entry.getKey().toUpperCase().equals(methodName.toUpperCase())) {
									try {
										method.setAccessible(true);
										method.invoke(localObject , entry.getValue());
										method.setAccessible(false);
									}
									catch (IllegalArgumentException | InvocationTargetException e) {

										e.printStackTrace();
									}
								}
							}
						}
					}
				}
			}
			catch (InstantiationException | IllegalAccessException e) {

				e.printStackTrace();
			}
		}

		return localObject;
	}

	/**
	 * 
	 * @param map
	 * @param clazz
	 * @return
	 */
	public static List<Object> setColumnValue(Map<String, Object> map, Class clazz) {
		List<Object> result = new ArrayList<Object>();
		if (MapUtils.isEmpty(map)) {
			for (Entry<String, Object> entry : map.entrySet()) {
				Object localObject = null;
				try {
					localObject = clazz.newInstance();
					Method methods[] = clazz.getDeclaredMethods();
					for (Method method : methods) {
						if (method.getName().startsWith("set")) {

							try {
								method.setAccessible(true);
								method.invoke(localObject , entry.getValue());
								method.setAccessible(false);
							}
							catch (IllegalArgumentException | InvocationTargetException e) {

								e.printStackTrace();
							}

						}
					}

					result.add(localObject);
				}
				catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
