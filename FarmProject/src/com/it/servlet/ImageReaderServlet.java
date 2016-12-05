package com.it.servlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class ImageReaderServlet extends HttpServlet {

	private static final long serialVersionUID = 1005898751148162667L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileUrl = (String) req.getAttribute("fileURL");

		if (StringUtils.isNotBlank(fileUrl)) {
			resp.addHeader("Content-Type" , "image/*");
			try {
				FileInputStream in = new FileInputStream(fileUrl);
				ServletOutputStream out = resp.getOutputStream();
				byte[] b = new byte[4096];
				int flag = -1;
				while ((flag = in.read(b)) != -1) {
					out.write(b , 0 , flag);
				}
				in.close();
				out.flush();
				out.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req , resp);

	}
}
