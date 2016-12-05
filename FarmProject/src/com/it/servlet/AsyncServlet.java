package com.it.servlet;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class AsyncServlet extends HttpServlet {

    private static final long serialVersionUID = 3483524567075708972L;
    
    private ExecutorService executorService = Executors.newFixedThreadPool(10);// 執行緒池

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html; charset=UTF8");
	AsyncContext ctx = request.startAsync();
	executorService.submit(new AsyncRequest(ctx));
    }
    
    @Override
    public void destroy() {
         executorService.shutdown();
    }  

}
