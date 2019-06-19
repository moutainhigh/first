package com.deppon.montal.module.news.service;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.log4j.Logger;

import com.deppon.montal.module.news.action.ReplaceNewsList;
import com.deppon.montal.util.InitDataServlet;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 
 * 从HTTP获得图片并进行压缩
 * <p style="display:none">
 * yingjie
 * </p>
 * <p style="display:none">
 * version:V1.0,author:219390,date:2015-1-6 上午10:27:12,content:TODO
 * </p>
 * 
 * @author 219390
 * @date 2015-1-6 上午10:27:12
 * @since
 * @version
 */
public class ImageService  {

	  private static Logger logger = Logger.getLogger(ImageService.class);
	public void imageHandler(String absolutePath,String imageName){
		logger.info("进行压缩图片："+imageName);
		//图片请求地址
		String oaImageInterface = InitDataServlet.getValue("oaImage_interface");
		//原图片存放位置
		String oaImageOriginalFile = InitDataServlet.getValue("oaImage_originalFile");
		oaImageOriginalFile = absolutePath+oaImageOriginalFile;
		//压缩后图片存放位置
		String oaImageResizedFile = InitDataServlet.getValue("oaImage_resizedFile");
		oaImageResizedFile = absolutePath+oaImageResizedFile;
		logger.info("生成图片存放路径，压缩前："+oaImageOriginalFile+",压缩后："+oaImageResizedFile);
//		图片请求地址
//		String oaImageInterface = "http://oa.deppon.com/dipApp/mail/mail/outimgflash.jsp?filepath=/oaupload/oaGg/";
//		//原图片存放位置
//		String oaImageOriginalFile = absolutePath+"/oaupload/oaGg/appsrc";
//		//压缩后图片存放位置
//		String oaImageResizedFile = absolutePath+"/oaupload/oaGg/app";

		//1.判断图片是否存在图片
		if(isCompress(oaImageResizedFile+"/"+imageName)){
			logger.info("生成图片存放路径，压缩前："+oaImageOriginalFile+",压缩后："+oaImageResizedFile);
			return ;
		}else{
			//原图片
			File originalFile =null;
			//压缩后图片
			File resizedFile =null;
			//压缩图片大小
			int newWidth=0;
			//压缩图片格式
			String quality=null;
			//2.如果图片没有存在图片，去OA请求图片
				logger.info("开始从OA获取图片！");
				//获取图片
				try {
					imageRequestFromOa(oaImageInterface,
							oaImageOriginalFile, 
							imageName);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				File oaImageOriginalFileFile = new File(oaImageOriginalFile);
				if(!oaImageOriginalFileFile.exists()){
					logger.info("原文件不存在");
					oaImageOriginalFileFile.mkdirs();
				}
				File oaImageResizedFileFile = new File(oaImageResizedFile);
				if(!oaImageResizedFileFile.exists()){
					logger.info("压缩文件不存在");
					oaImageResizedFileFile.mkdirs();
				}
				//原图片
				originalFile = new File(oaImageOriginalFile+"/"+imageName);
				//压缩后图片
				resizedFile = new File(oaImageResizedFile+"/"+imageName);
				//压缩图片大小
				newWidth =500 ;
				//压缩图片格式
				quality = imageName.substring(imageName.lastIndexOf(".")+1);
				logger.info("压缩图片大小："+newWidth+" "+"压缩图片格式："+quality);
            	 //调用图片压缩方法进行压缩
   				try {
   					logger.info("压缩图片大小："+newWidth+" "+"压缩图片格式："+quality);
					resize(originalFile, resizedFile, newWidth, quality);
				} catch (Exception e) {
					if(originalFile.exists()&&!originalFile.isDirectory()){
						logger.error("压缩图片失败，直接存储网络获得未压缩图片"+originalFile.getName());
						copy(originalFile, resizedFile);
					}
				}
		}
	}
	
	/**
	 * 
	 *
	 * <p>判断是否有压缩图片的方法</p> 
	 * @author 219390
	 * @date 2015-1-6 下午7:43:57
	 * @param imageName
	 * @return
	 * @see
	 *
	 */
	private  boolean isCompress(String imageName){
		boolean rtn = true;
		File file = new File(imageName);
			if(!file.exists()){
				logger.info("压缩图片不存在！");
				rtn = false;
			}
		return rtn;
	}
	

	/**
	 * 
	 *
	 * <p>从OA获得图片</p> 
	 * @author 219390
	 * @date 2015-1-10 上午10:32:15
	 * @param httpUrl
	 * @param imagePath
	 * @param imageName
	 * @see
	 *
	 */
	
	
	private void imageRequestFromOa(String httpUrl,String imagePath,String imageName)throws Exception{
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
			URL url = new URL(httpUrl+"/"+imageName);
			
			// 打开链接
			HttpURLConnection conn = (HttpURLConnection) url
					.openConnection();
			// 设置请求方式为"GET"
			conn.setRequestMethod("GET");
			// 超时响应时间为5秒
			conn.setConnectTimeout(10 * 1000);
			// 通过输入流获取图片数据
			InputStream inStream = conn.getInputStream();
			File filepath = new File(imagePath+"/"+imageName);
			bis = new BufferedInputStream(inStream);
			bos = new BufferedOutputStream(new FileOutputStream(
					filepath));// 为以防万一，以后写文件的路径尽量写成正双斜杠的
			// 从源文件中取数据，写到目标文件中
			byte[] buff = new byte[1024];
			for (int len = -1; (len = bis.read(buff)) != -1;) {
				bos.write(buff, 0, len);
			}
			bos.flush();
			logger.info("从OA获取图片成功！");
			try {
				if(bis!=null){
				    bis.close();
				}
				if(bos!=null){
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
	 public static final MediaTracker tracker = new MediaTracker(new Component() {
	        private static final long serialVersionUID = 1234162663955668507L;} 
	    );

	/**
	 * @param originalFile
	 *            原图像
	 * @param resizedFile
	 *            压缩后的图像
	 * @param width
	 *            图像宽
	 * @param format
	 *            图片格式 jpg, png, gif(非动画)
	 * @throws IOException
	 */
	public static void resize(File originalFile, File resizedFile, int width,
			String format) throws IOException {
		logger.info("开始压缩图片！图片名为："+originalFile.getName());
		if (format != null && "gif".equals(format.toLowerCase())) {
			resize(originalFile, resizedFile, width, 1);
			return;
		}
		FileInputStream fis = new FileInputStream(originalFile);
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		int readLength = -1;
		int bufferSize = 1024;
		byte bytes[] = new byte[bufferSize];
		while ((readLength = fis.read(bytes, 0, bufferSize)) != -1) {
			byteStream.write(bytes, 0, readLength);
		}
		byte[] in = byteStream.toByteArray();
		fis.close();
		byteStream.close();

		Image inputImage = Toolkit.getDefaultToolkit().createImage(in);
		waitForImage(inputImage);
		int imageWidth = inputImage.getWidth(null);
		if (imageWidth < 1){
			System.out.println(("image width " + imageWidth
					+ " is out of range"));
			logger.info("压缩"+originalFile.getName()+"图片失败！");
		return ;	
		}
		int imageHeight = inputImage.getHeight(null);
		if (imageHeight < 1){
			System.out.println(("image height " + imageWidth
					+ " is out of range"));
			logger.info("压缩"+originalFile.getName()+"图片失败！");
		return ;	
		}

		// Create output image.
		int height = -1;
		double scaleW = (double) imageWidth / (double) width;
		double scaleY = (double) imageHeight / (double) height;
		if (scaleW >= 0 && scaleY >= 0) {
			if (scaleW > scaleY) {
				height = -1;
			} else {
				width = -1;
			}
		}
		Image outputImage = inputImage.getScaledInstance(width, height,
				java.awt.Image.SCALE_DEFAULT);
		checkImage(outputImage);
		encode(new FileOutputStream(resizedFile), outputImage, format);
	}

	/** Checks the given image for valid width and height. */
	private static void checkImage(Image image) {
		waitForImage(image);
		int imageWidth = image.getWidth(null);
		if (imageWidth < 1)
			throw new IllegalArgumentException("image width " + imageWidth
					+ " is out of range");
		int imageHeight = image.getHeight(null);
		if (imageHeight < 1)
			throw new IllegalArgumentException("image height " + imageHeight
					+ " is out of range");
	}

	/**
	 * Waits for given image to load. Use before querying image
	 * height/width/colors.
	 */
	private static void waitForImage(Image image) {
		try {
			tracker.addImage(image, 0);
			tracker.waitForID(0);
			tracker.removeImage(image, 0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** Encodes the given image at the given quality to the output stream. */
	private static void encode(OutputStream outputStream, Image outputImage,
			String format) throws java.io.IOException {
		int outputWidth = outputImage.getWidth(null);
		if (outputWidth < 1)
			throw new IllegalArgumentException("output image width "
					+ outputWidth + " is out of range");
		int outputHeight = outputImage.getHeight(null);
		if (outputHeight < 1)
			throw new IllegalArgumentException("output image height "
					+ outputHeight + " is out of range");
		// Get a buffered image from the image.
		BufferedImage bi = new BufferedImage(outputWidth, outputHeight,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D biContext = bi.createGraphics();
		biContext.drawImage(outputImage, 0, 0, null);
		ImageIO.write(bi, format, outputStream);
		outputStream.flush();
		outputStream.close();
	}

	/**
	 * 缩放gif图片
	 * 
	 * @param originalFile
	 *            原图片
	 * @param resizedFile
	 *            缩放后的图片
	 * @param newWidth
	 *            宽度
	 * @param quality
	 *            缩放比例 (等比例)
	 * @throws IOException
	 */
	private static void resize(File originalFile, File resizedFile,
			int newWidth, float quality) throws IOException {
		if (quality < 0 || quality > 1) {
			throw new IllegalArgumentException(
					"Quality has to be between 0 and 1");
		}
		ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());
		Image i = ii.getImage();
		Image resizedImage = null;
		int iWidth = i.getWidth(null);
		int iHeight = i.getHeight(null);
		if (iWidth > iHeight) {
			resizedImage = i.getScaledInstance(newWidth, (newWidth * iHeight)
					/ iWidth, Image.SCALE_SMOOTH);
		} else {
			resizedImage = i.getScaledInstance((newWidth * iWidth) / iHeight,
					newWidth, Image.SCALE_SMOOTH);
		}
		// This code ensures that all the pixels in the image are loaded.
		Image temp = new ImageIcon(resizedImage).getImage();
		// Create the buffered image.
		BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null),
				temp.getHeight(null), BufferedImage.TYPE_INT_RGB);
		// Copy image to buffered image.
		Graphics g = bufferedImage.createGraphics();
		// Clear background and paint the image.
		g.setColor(Color.white);
		g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
		g.drawImage(temp, 0, 0, null);
		g.dispose();
		// Soften.
		float softenFactor = 0.05f;
		float[] softenArray = { 0, softenFactor, 0, softenFactor,
				1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0 };
		Kernel kernel = new Kernel(3, 3, softenArray);
		ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		bufferedImage = cOp.filter(bufferedImage, null);
		// Write the jpeg to a file.
		FileOutputStream out = new FileOutputStream(resizedFile);
		// Encodes image as a JPEG data stream
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		JPEGEncodeParam param = encoder
				.getDefaultJPEGEncodeParam(bufferedImage);
		param.setQuality(quality, true);
		encoder.setJPEGEncodeParam(param);
		encoder.encode(bufferedImage);
		out.flush();
		out.close();
	}
	/**
	 * 
	 *
	 * <p>复制的方法</p> 
	 * @author 219390
	 * @date 2015-1-9 下午6:37:45
	 * @param source
	 * @param target
	 * @see
	 *
	 */
	private static void copy(File source, File target) {  
	    InputStream fis = null;  
	    OutputStream fos = null;  
	    try {  
	        fis = new BufferedInputStream(new FileInputStream(source));  
	        fos = new BufferedOutputStream(new FileOutputStream(target));  
	        byte[] buf = new byte[4096];  
	        int i;  
	        while ((i = fis.read(buf)) != -1) {  
	            fos.write(buf, 0, i);  
	        }  
	    }  
	    catch (Exception e) {
	    	logger.info("复制图片失败！");
	        e.printStackTrace();  
	    } finally {  
				try {
					if(fis!=null)fis.close();
					if(fos!=null) fos.close(); 
				} catch (IOException e) {
					e.printStackTrace();
				}  
	    	 
	    }  
	} 
	public static void main(String[] args) {
//		ImageService imageService = new ImageService();
//		List<File> files =new ArrayList<File>();
//		List<File> files2 =new ArrayList<File>();
//		File oldFile = new File("D:\\219390\\Desktop\\1.jpg");
//		File oldFile2 = new File("D:\\219390\\Desktop\\2.jpg");
//		File newFile = new File("D:\\219390\\Desktop\\3.jpg");
//		File newFile2 = new File("D:\\219390\\Desktop\\4.jpg");
//		files.add(oldFile);
//		files.add(oldFile2);
//		files2.add(newFile);
//		files2.add(newFile2);
//		try {
//			for (int i = 0; i < files.size(); i++) {
//				imageService.resize(files.get(i),files2.get(i) , 600, "jpg");
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		
//		String string = ImageService.class.getResource("").getPath();
//		System.out.println(string);
//		File file = new File(string+"../service/ImageCompressJob.class");
//		System.out.println(file.exists());
		
		

		File file = new File("F:/aa");
		if(!(file.exists())){
			file.mkdirs();
		}
		if(!file.isDirectory()){
			file.delete();
			file.mkdirs();
		}
 	}
}
