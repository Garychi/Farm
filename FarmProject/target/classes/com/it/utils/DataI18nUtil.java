package com.it.utils;

import java.util.Arrays;

public class DataI18nUtil {

    private static String i18n;
    private static Arrays[] columns;
    private static Object i18nObject;

    public static void setI18nValue(Object obj) {
	Object localObject = getI18nValue(obj);

    }

    public static Object getI18nValue(Object obj) {
	Object localObject = obj;
	return localObject;
    }

    public static String getI18n() {
	return i18n;
    }

    public static void setI18n(String i18n) {
	DataI18nUtil.i18n = i18n;
    }

    public static Arrays[] getColumns() {
	return columns;
    }

    public static void setColumns(Arrays[] columns) {
	DataI18nUtil.columns = columns;
    }

    public static Object getI18nObject() {
	return i18nObject;
    }

    public static void setI18nObject(Object i18nObject) {
	DataI18nUtil.i18nObject = i18nObject;
    }

}
