package com.it.servlet;

import java.io.PrintWriter;

import javax.servlet.AsyncContext;

public class AsyncRequest implements Runnable {
    private AsyncContext ctx;

    public AsyncRequest(AsyncContext ctx) {
	this.ctx = ctx;
    }

    @Override
    public void run() {
	try {
	    // 模擬長時間的處理
	    Thread.sleep(3000);
	    PrintWriter out = ctx.getResponse().getWriter();
	    out.println("久等了...XD");
	    // 這邊才真正送出回應
	    ctx.complete();
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
