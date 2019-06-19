/**  
 *  缩略图实现，将图片(jpg、bmp、png、gif等等)真实的变成想要的大小  
 */  
package com.deppon.montal.util;   
  
import java.awt.Image;   
import java.awt.image.BufferedImage;   
import java.io.File;   
import java.io.FileOutputStream;   
import java.io.IOException;   
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;   

import org.apache.log4j.Logger;

import com.deppon.montal.service.ImageCompressService;
import com.sun.image.codec.jpeg.JPEGCodec;   
import com.sun.image.codec.jpeg.JPEGImageEncoder;   
  
/*******************************************************************************  
 * 缩略图类（通用） 本java类能将jpg、bmp、png、gif图片文件，进行等比或非等比的大小转换。 具体使用方法  
 * compressPic(大图片路径,生成小图片路径,大图片文件名,生成小图片文名,生成小图片宽度,生成小图片高度,是否等比缩放(默认为true))  
 */  
 public final class ImgUtil {    
	 private static Logger logger  = Logger.getLogger(ImgUtil.class);
	 
     private File file = null; // 文件对象    
     private String inputDir; // 输入图路径   
     private String outputDir; // 输出图路径   
     private String inputFileName; // 输入图文件名   
     private String outputFileName; // 输出图文件名   
     private int outputWidth = 100; // 默认输出图片宽   
     private int outputHeight = 100; // 默认输出图片高   
     private boolean proportion = true; // 是否等比缩放标记(默认为等比缩放)   
     public ImgUtil() { // 初始化变量   
         inputDir = "";    
         outputDir = "";    
         inputFileName = "";    
         outputFileName = "";    
         outputWidth = 50;    
         outputHeight = 50;    
     }    
     public void setInputDir(String inputDir) {    
         this.inputDir = inputDir;    
     }    
     public void setOutputDir(String outputDir) {    
         this.outputDir = outputDir;    
     }    
     public void setInputFileName(String inputFileName) {    
         this.inputFileName = inputFileName;   
     }    
     public void setOutputFileName(String outputFileName) {    
         this.outputFileName = outputFileName;    
     }    
     public void setOutputWidth(int outputWidth) {   
         this.outputWidth = outputWidth;    
     }    
     public void setOutputHeight(int outputHeight) {    
         this.outputHeight = outputHeight;    
     }    
     public void setWidthAndHeight(int width, int height) {    
         this.outputWidth = width;   
         this.outputHeight = height;    
     }    
        
     /*   
      * 获得图片大小   
      * 传入参数 String path ：图片路径   
      */    
     private long getPicSize(String path) {    
         file = new File(path);    
         return file.length();    
     }   
        
     // 图片处理    
     private String compressPic() {    
         try {    
             //获得源文件    
        	 //logger.debug("compressPic start!");
             file = new File(inputDir);  
             System.out.println(inputDir+"=======imgutil"+file.exists());
             if (!file.exists()) {    
                 return "";    
             }    
             //logger.debug("read file");
             Image img = ImageIO.read(file);    
             //logger.debug("read file complete!");
             // 判断图片格式是否正确    
             if (img.getWidth(null) == -1) {   
                 System.out.println(" can't read,retry!" + "<BR>");    
                 return "no";    
             } else {    
                 int newWidth; int newHeight;    
                 // 判断是否是等比缩放    
                 if (this.proportion == true) {    
                     // 为等比缩放计算输出的图片宽度及高度    
                     double rate1 = ((double) img.getWidth(null)) / (double) outputWidth + 0.1;    
                     double rate2 = ((double) img.getHeight(null)) / (double) outputHeight + 0.1;    
                     // 根据缩放比率大的进行缩放控制    
                     double rate = rate1 > rate2 ? rate1 : rate2;    
                     newWidth = (int) (((double) img.getWidth(null)) / rate);    
                     newHeight = (int) (((double) img.getHeight(null)) / rate);    
                 } else {    
                     newWidth = outputWidth; // 输出的图片宽度    
                     newHeight = outputHeight; // 输出的图片高度    
                 }    
                 //logger.debug("newWidth: "+newWidth+" newHeight: "+newHeight);
                BufferedImage tag = new BufferedImage((int) newWidth, (int) newHeight, BufferedImage.TYPE_INT_RGB);    
                   
                /*  
                 * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的  
                 * 优先级比速度高 生成的图片质量比较好 但速度慢  
                 */    
                tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);   
                //logger.debug("after redrawed!");
                FileOutputStream out = new FileOutputStream(outputDir + outputFileName);   
                // JPEGImageEncoder可适用于其他图片类型的转换    
                //logger.debug("encode pic!");
                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);    
                encoder.encode(tag);    
                out.close();    
                //logger.debug("after encode!");
             }    
         } catch (IOException ex) {    
             logger.error("compressPic["+inputDir + inputFileName+"] error "+ex.getMessage()); 
         } catch (Exception ex) {   
        	 logger.error("compressPic["+inputDir + inputFileName+"] error "+ex.getMessage()); 
         }
         return "ok";    
    }    
     private String compressPic (String inputDir, String outputDir, String inputFileName, String outputFileName) {    
        // 输入图路径    
        this.inputDir = inputDir;    
        // 输出图路径    
        this.outputDir = outputDir;    
        // 输入图文件名    
        this.inputFileName = inputFileName;    
        // 输出图文件名   
        this.outputFileName = outputFileName;    
        return compressPic();    
    }    
    public String compressPic(String inputDir, String outputDir, String inputFileName, String outputFileName, int width, int height, boolean gp) {    
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
        return compressPic();    
    }    
    
    
    public void compressImgs(String srcDir, String distDir, String[] imgs){
    	for(String img : imgs){
    		compressPic(srcDir, distDir, img, img, 200, 200, true);
    	}
    }
    
    public void compressImg(String srcDir, String distDir, String img){
    	logger.info("Compress image " + srcDir + "/" + img);
    	compressPic(srcDir+"/", distDir+"/", img, img, 400, 400, true);
    	logger.info("Compress image " + distDir + "/" + img +" successfully! ");
    }
    
    // main测试    
    // compressPic(大图片路径,生成小图片路径,大图片文件名,生成小图片文名,生成小图片宽度,生成小图片高度,是否等比缩放(默认为true))   
    public static void main(String[] arg) {    
//    	ImgUtil mypic = new ImgUtil();    
////        String ss=mypic.compressPic("c:/jpg/","c:/jpg2/","562810ba56371903536ff21ac2bbcb19.jpg","562810ba56371903536ff21ac2bbcb19.jpg",120,80,true);  
//        String ss=mypic.img("http://oa.deppon.com/dipApp/mail/mail/outimgflash.jsp?filepath=/oaupload/fckeditor/image/3335555.jpg");
//        
    	File file = new File("http://www.baidu.com/img/baidu_jgylogo3.gif?v=14136864.gif");  
    	System.out.println(file.exists());
    } 
    /**
     * 
    * @Title: filterHtmlImg 
    * @Description: 去掉IMG标签
    * @author dpyuanjb@deppon.com/092039
    * 2014年10月10日上午9:58:43
    * @param @param str
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws
     */
    public static String filterHtmlImg(String str) {
        Pattern pattern = Pattern.compile("<\\s*img\\s+([^>]*)\\s*>");
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();   
        boolean result1 = matcher.find();   
        while (result1) {   
            matcher.appendReplacement(sb, "");   
            result1 = matcher.find();   
        }   
        matcher.appendTail(sb);   
        return sb.toString();   
    } 
    public static String getImgStr(String htmlStr){   
        String img="";   
        Pattern p_image;   
        Matcher m_image;   
        String pics = "";

        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>"; 
        p_image = Pattern.compile(regEx_img,Pattern.CASE_INSENSITIVE);   
        m_image = p_image.matcher(htmlStr); 
        while(m_image.find()){   
        	if(pics.length()>0){
        		break;
        	}
            img = img + "," + m_image.group();   
            Matcher m  = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);

            while(m.find()){
            	if(pics.length()>0){
            		break;
            	}
            	pics=m.group(1).replaceAll("\"", "").replaceAll("'", "");
            }
        }   
//        if(pics==null|| pics.equals("")){
//        	pics="a.jpg";
//        }
        return pics;   
    }  
    public static String getContentImgStr(String htmlStr){
    	Pattern p = Pattern.compile("<img[^>]+style\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");//<img[^<>]*src=[\'\"]([0-9A-Za-z.\\/]*)[\'\"].(.*?)>");
        Matcher m = p.matcher(htmlStr);
        while(m.find()){
        	htmlStr = htmlStr.replaceAll(m.group(1), "width:100%;float:left");
        }
        p = Pattern.compile("<img[^>]+width\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
        m = p.matcher(htmlStr);
        while(m.find()){
        	htmlStr = htmlStr.replaceAll(m.group(1)+"\"", "100%\" align='left'");
        }
        return htmlStr;   
    }
    public static String getTitleImgStr(String htmlStr){
    	Pattern p = Pattern.compile("<p[^>]+style\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");//<img[^<>]*src=[\'\"]([0-9A-Za-z.\\/]*)[\'\"].(.*?)>");
        Matcher m = p.matcher(htmlStr);
        while(m.find()){
        	htmlStr = htmlStr.replaceAll(m.group(1), "");
        }
        return htmlStr;   
    }
    public static String img(String filename){
    	File file=new File(filename);
		System.out.println(file.getPath()+"---------"+file.getName());
//		System.out.println(InitDataServlet.prop.getProperty("imgnews_srcPath")+"-0000000000000");
//		File fileL = new File(InitDataServlet.prop.getProperty("imgnews_srcPath")+"/periodical/");
//		if(!fileL.exists()){
//			  fileL.mkdirs();
//		}
		ImgUtil imgUtil = new ImgUtil();
		String rt = imgUtil.compressPic(filename, "d:/oaupload/oaGg/periodical"+"/", file.getName(), file.getName(), 50, 50, true);
		System.out.println(rt+"=========");
		return "";
	}
 }  