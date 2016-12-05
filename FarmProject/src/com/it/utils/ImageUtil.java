package com.it.utils;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class ImageUtil {
	
	/**
	 * 縮圖
	 * @param image
	 * @param width
	 * @param height
	 * @return
	 */
	 public static BufferedImage resize(BufferedImage image, double width, double height) {
		double mWidth = image.getWidth(null);
		double mHeight = image.getHeight(null);

		double xScale = width / mWidth;
		double yScale = height / mHeight;
		double theScale = xScale > yScale ? xScale : yScale;

		AffineTransform transform = new AffineTransform();
		transform.setToScale(theScale , theScale);

		BufferedImage bdest = new BufferedImage((int) (mWidth * xScale), (int) (mHeight * yScale), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = bdest.createGraphics();
		g.drawRenderedImage(image , transform);
		return bdest;
	}
	
	 /**
	  * 存圖檔
	  * @param media
	  * @param savePath
	  * @param fileCode
	  * @param mimeType
	  */
//	public static void saveFile(Media media, String savePath, String fileCode,String mimeType) {
//		try {
//			BufferedImage icon = ImageIO.read(media.getStreamData());
////			BufferedImage icon = resize(ImageIO.read(media.getStreamData()) , 16 , 16);
//			File baseDir = new File(savePath);
//			if (!baseDir.exists()) {
//				baseDir.mkdirs();
//			}
//			File file = new File(savePath + File.separator + fileCode + "."+mimeType);
//			ImageIO.write(icon , "png" , file);
//		}
//		catch (IOException e1) {
//			e1.printStackTrace();
//		}
//	}
}
