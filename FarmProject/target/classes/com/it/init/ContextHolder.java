package com.it.init;

public class ContextHolder {
	private static final ThreadLocal<Object> contextHolder = new ThreadLocal();
	public ContextHolder(){}
}
