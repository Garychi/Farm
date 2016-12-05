package com.it.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;

import org.apache.catalina.core.ApplicationContextFacade;

public class RequestListener implements javax.servlet.ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent reqEvt) {
		// TODO Auto-generated method stub
		ServletContext context = reqEvt.getServletContext();
		ServletRequest request = reqEvt.getServletRequest();
		Object obj = reqEvt.getSource();
		ApplicationContextFacade objs = (ApplicationContextFacade)reqEvt.getSource();
		objs.getServerInfo();
		
		String s ="aaa";
	}

	@Override
	public void requestInitialized(ServletRequestEvent reqEvt) {
		// TODO Auto-generated method stub
		ServletContext context = reqEvt.getServletContext();
		ServletRequest request = reqEvt.getServletRequest();
		Object obj = reqEvt.getSource();
		String s ="aa";
	}

}
