package com.deppon.dpm.module.announce.shared.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import com.deppon.dpm.module.common.server.util.MagicNumber;

@SuppressWarnings("restriction")
public class ImagePressPic {
	//log
	private static final Logger logger = Logger.getLogger(ImagePressPic.class);
	// 文件对象
	private File file = null;
	// 输入图路径
	private String inputDir;
	// 输出图路径
	private String outputDir;
	// 输入图文件名
	private String inputFileName;
	// 输出图文件名
	private String outputFileName;
	// 默认输出图片宽
	private int outputWidth = MagicNumber.NUM100;
	// 默认输出图片高
	private int outputHeight = MagicNumber.NUM100;
	// 是否等比缩放标记(默认为等比缩放)
	private boolean proportion = true;

	/**
	 * 设置宽和高
	 * @param width
	 * @param height
	 */
	public void setWidthAndHeight(int width, int height) {
		this.outputWidth = width;
		this.outputHeight = height;
	}
	
	/*
	 * 获得图片大小 传入参数 String path ：图片路径
	 */
	public long getPicSize(String path) {
		// 根据路径获取图片
		file = new File(path);
		// 获取图片的大小
		return file.length();
	}

	// 图片处理
	public String compressPic() {
		FileOutputStream out = null;
		try {
			// 获得源文件
			file = new File(inputDir + inputFileName);
			// 如果文件不存在
			if (!file.exists()) {
				// 返回空
				return "";
			}
			// 读取文件
			Image img = ImageIO.read(file);
			// 判断图片格式是否正确
			if (img.getWidth(null) == -1) {
				// log
				logger.error("can't read,retry!<BR>");
				// 返回
				return "no";
			} else {
				// 定义宽度
				int newWidth;
				// 定义高度
				int newHeight;
				// 判断是否是等比缩放
				if (this.proportion) {
					// 为等比缩放计算输出的图片宽度及高度
					double rate1 = ((double) img.getWidth(null))
							/ (double) outputWidth + MagicNumber.DOUBLENUM1;
					// 为等比缩放计算输出的图片宽度及高度
					double rate2 = ((double) img.getHeight(null))
							/ (double) outputHeight + MagicNumber.DOUBLENUM1;
					// 根据缩放比率大的进行缩放控制
					double rate = rate1 > rate2 ? rate1 : rate2;
					// 新宽度
					newWidth = (int) (((double) img.getWidth(null)) / rate);
					// 新宽度
					newHeight = (int) (((double) img.getHeight(null)) / rate);
				} else {
					// 输出的图片宽度
					newWidth = outputWidth;
					// 输出的图片高度
					newHeight = outputHeight;
				}
				// 生成新图片
				BufferedImage tag = new BufferedImage((int) newWidth,
						(int) newHeight, BufferedImage.TYPE_INT_RGB);
				/*
				 * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
				 */
				/*// 画图
				tag.getGraphics().drawImage(
						img.getScaledInstance(newWidth, newHeight,
								Image.SCALE_SMOOTH), 0, 0, null);
				// 图片输出
				out = new FileOutputStream(outputDir
						+ outputFileName);
				// JPEGImageEncoder可适用于其他图片类型的转换
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
				// 编码
				encoder.encode(tag);*/
				
				// 画图
			    tag.getGraphics().drawImage(
			      img.getScaledInstance(newWidth, newHeight,
			        Image.SCALE_SMOOTH), 0, 0, null);
			    String dstName=outputDir+outputFileName;
			    String formatName = dstName.substring(dstName.lastIndexOf(".") + 1);  
			    ImageIO.write(tag, /*"GIF"*/ formatName /* format desired */ , new File(dstName) /* target */ ); 
			}
		} catch (Exception ex) {
			logger.error("压缩图片的时候出现错误:", ex);
		} finally {
			// 释放资源
			if(null != out){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ok";
	}

	public String compressPic(String inputDir, String outputDir,
			String inputFileName, String outputFileName) {
		// 输入图路径
		this.inputDir = inputDir;
		// 输出图路径
		this.outputDir = outputDir;
		// 输入图文件名
		this.inputFileName = inputFileName;
		// 输出图文件名
		this.outputFileName = outputFileName;
		// 压缩
		return compressPic();
	}

	public String compressPic(String inputDir, String outputDir,
			String inputFileName, String outputFileName, int width, int height,
			boolean gp) {
		// 输入图路径
		this.inputDir = inputDir;
		// 输出图路径
		this.outputDir = outputDir;
		// 输入图文件名
		this.inputFileName = inputFileName;
		// 输出图文件名
		this.outputFileName = outputFileName;
		// 设置图片长宽
		setWidthAndHeight(width, height);
		// 是否是等比缩放 标记
		this.proportion = gp;
		// 压缩
		return compressPic();
	}
	
	/**
	 * Constructor
	 */
	public ImagePressPic(){
		// 输入文件夹
		inputDir = "";
		// 输出文件夹
		outputDir = "";
		// 输入文件名称
		inputFileName = "";
		// 输出文件名称
		outputFileName = "";
		// 输出文件宽度
		outputWidth = MagicNumber.NUM100;
		// 输出文件高度
		outputHeight = MagicNumber.NUM100;
	}
	
	/**
	 * set
	 * @param inputDir
	 */
	public void setInputDir(String inputDir) {
		this.inputDir = inputDir;
	}

	/**
	 * set
	 * @param outputDir
	 */
	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}

	/**
	 * set
	 * @param inputFileName
	 */
	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	/**
	 * set
	 * @param outputFileName
	 */
	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	/**
	 * set
	 * @param outputWidth
	 */
	public void setOutputWidth(int outputWidth) {
		this.outputWidth = outputWidth;
	}

	/**
	 * set
	 * @param outputHeight
	 */
	public void setOutputHeight(int outputHeight) {
		this.outputHeight = outputHeight;
	}
}