package com.it.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class QRCodeUtil {

	
	public static void main(String args[]){
		String data = "www.google.com.tw";
		BufferedImage image =makeQRCode(140,data);
//		printQRCode(image);
//		System.out.println("done");
	}
	
	public static BufferedImage makeQRCode(int width,String data){
		Qrcode qrcode = new Qrcode();
		
		qrcode.setQrcodeEncodeMode('M');
		qrcode.setQrcodeErrorCorrect('B');
		qrcode.setQrcodeVersion(7);
		
		BufferedImage image = new BufferedImage(width,width, BufferedImage.TYPE_INT_RGB);
		
		try {
			byte[] d = data.getBytes("Utf-8");
			
			 // createGraphics
	        Graphics2D g = (Graphics2D) image.getGraphics();

	        // set background
	        g.setBackground(Color.WHITE);
	        g.clearRect(0, 0, width, width);

	        // 設定字型顏色 => BLACK
	        g.setColor(Color.BLACK);

	        // 轉出 Bytes	        
	        if (d.length > 0 && d.length < 120) {
	            boolean[][] s = qrcode.calQrcode(d);
	            for (int i = 0; i < s.length; i++) {
	                for (int j = 0; j < s.length; j++) {
	                    if (s[j][i]) {
	                        g.fillRect(j * 3 + 2, i * 3 + 2, 3, 3);
	                    }
	                }
	            }
	        }

	        g.dispose();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		 
       return image;
	}
	
	
	public static void printQRCode(BufferedImage image,String rootPath,String fileName,String mimeType){
//		String rootPath="D:\\image";
//		String fileName="qrCode";
//		String mimeType="png";
		fileName = fileName+"."+mimeType;
		
		String filePath = rootPath+File.separator+fileName;
		
		File file = new File(filePath);
		
		try {
			ImageIO.write(image, mimeType, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
