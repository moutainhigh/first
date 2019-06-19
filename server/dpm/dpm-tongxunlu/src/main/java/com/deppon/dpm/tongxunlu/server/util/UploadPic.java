package com.deppon.dpm.tongxunlu.server.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cn.jpush.api.utils.StringUtils;

import com.deppon.foss.framework.server.sso.util.BASE64Decoder;
/**
 * 智能门店上传图片通用接口
 * @author RY
 *
 */
public class UploadPic {
	// 文件路径
	private static final String filePath = "/dpmfile/storerecord/";
	
	
	/** 
     * base64字符串转换成图片 
     * @param imgStr        base64字符串 
     * @param imgName       图片存放名称 
     * @return 
     * 
     * @author XiaoTian 
     * @dateTime 2018-06-11 17:02:17 
     */  
    public static String Base64ToImage(String imgStr) { // 对字节数组字符串进行Base64解码并生成图片  
  
        if (StringUtils.isEmpty(imgStr)) // 图像数据为空  
            return null;  
        // 得到文件格式
		String spcode = imgStr.substring(imgStr.lastIndexOf("."));
		//去掉后缀,在去掉了头部,用imagecode进行文件上传
		String imgUrl = imgStr.substring(0,imgStr.lastIndexOf(".")).replace("data:image/*;base64,","");
		
        StringBuilder sb = new StringBuilder();
		// 文件名用UUID防止重复
		sb.append(UUID.randomUUID().toString().replaceAll("-", ""));
        // 文件名fileName
		String imgName = sb.toString() + spcode;
		
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {  
            // Base64解码  
            byte[] b = decoder.decodeBuffer(imgUrl);  
            for (int i = 0; i < b.length; ++i) {  
                if (b[i] < 0) {// 调整异常数据  
                    b[i] += 256;  
                }  
            }  
            out = new FileOutputStream(filePath+imgName);  
            out.write(b);  
            out.flush();  
            out.close();  
            return imgName;  
        } catch (Exception e) {  
            return null;  
        }finally{
        	if(out!=null){
        		try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }  
    }
    
    /** 
     * base64字符串转换成图片 
     * @param imgStr        base64字符串 
     * @param imgName       图片存放名称 
     * @return 
     * 
     * @author XiaoTian 
     * @dateTime 2018-06-11 17:02:17 
     */  
    public static String Base64ToImage(String imgStr,String imgName) { // 对字节数组字符串进行Base64解码并生成图片  
  
        if (StringUtils.isEmpty(imgStr)) // 图像数据为空  
            return null;  
        // 得到文件格式
		String spcode = imgStr.substring(imgStr.lastIndexOf("."));
		//去掉后缀,在去掉了头部,用imagecode进行文件上传
		String imgUrl = imgStr.substring(0,imgStr.lastIndexOf(".")).replace("data:image/*;base64,","");
		
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out= null;
        try {  
            // Base64解码  
            byte[] b = decoder.decodeBuffer(imgUrl);
            for (int i = 0; i < b.length; ++i) {  
                if (b[i] < 0) {// 调整异常数据  
                    b[i] += 256;  
                }  
            }  
			out = new FileOutputStream(filePath+imgName);  
            out.write(b);  
            out.flush();  
            out.close();  
            return imgName;  
        } catch (Exception e) {  
            return null;  
        }finally{
        	if(out!=null){
        		try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
    }
    
    /**
     * 获取图片后缀,添加名称
     */
    public String stringImgSuffix(String imgStr){
    	// 得到文件格式
    	String spcode = imgStr.substring(imgStr.lastIndexOf("."));
    	// 生成任务子表id
		IdWorker idWorkerstoreTaskVo = new IdWorker();
		// 生成id为 long类型转为String
		String taskidstoreTaskVo = Long
				.toString(idWorkerstoreTaskVo.nextId());
        // 文件名fileName
		String imgName = taskidstoreTaskVo + spcode;
		//返回名字
		return imgName;
    }
}
class IdWorker {
    // 时间起始标记点，作为基准，一般取系统的最近时间（一旦确定不能变动）
    private final static long twepoch = 1288834974657L;
    // 机器标识位数
    private final static long workerIdBits = 5L;
    // 数据中心标识位数
    private final static long datacenterIdBits = 5L;
    // 机器ID最大值
    private final static long maxWorkerId = -1L ^ (-1L << workerIdBits);
    // 数据中心ID最大值
    private final static long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    // 毫秒内自增位
    private final static long sequenceBits = 12L;
    // 机器ID偏左移12位
    private final static long workerIdShift = sequenceBits;
    // 数据中心ID左移17位
    private final static long datacenterIdShift = sequenceBits + workerIdBits;
    // 时间毫秒左移22位
    private final static long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    private final static long sequenceMask = -1L ^ (-1L << sequenceBits);
    /* 上次生产id时间戳 */
    private static long lastTimestamp = -1L;
    // 0，并发控制
    private long sequence = 10L;

    private final long workerId;
    // 数据标识id部分
    private final long datacenterId;
    /**
     * 构造方法
     */
    public IdWorker(){
        this.datacenterId = getDatacenterId(maxDatacenterId);
        this.workerId = getMaxWorkerId(datacenterId, maxWorkerId);
    }
    /**
     * @param workerId
     *            工作机器ID
     * @param datacenterId
     *            序列号
     */
    public IdWorker(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }
    /**
     * 获取下一个ID
     *
     * @return
     */
    public synchronized long nextId() {
        long timestamp = timeGen();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            // 当前毫秒内，则+1
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                // 当前毫秒内计数满了，则等待下一秒
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }
        lastTimestamp = timestamp;
        // ID偏移组合生成最终的ID，并返回ID
        long nextId = ((timestamp - twepoch) << timestampLeftShift)
                | (datacenterId << datacenterIdShift)
                | (workerId << workerIdShift) | sequence;

        return nextId;
    }
    /**
     * 
     * @param lastTimestamp
     * @return
     */
    private long tilNextMillis(final long lastTimestamp) {
        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }
    /**
     *  
     * @return System.currentTimeMillis()
     */
    private long timeGen() {
        return System.currentTimeMillis();
    }

    /**
     * <p>
     * 获取 maxWorkerId
     * </p>
     */
    protected static long getMaxWorkerId(long datacenterId, long maxWorkerId) {
        StringBuffer mpid = new StringBuffer();
        mpid.append(datacenterId);
        String name = ManagementFactory.getRuntimeMXBean().getName();
        if (!name.isEmpty()) {
         /*
          * GET jvmPid
          */
            mpid.append(name.split("@")[0]);
        }
      /*
       * MAC + PID 的 hashcode 获取16个低位
       */
        return (mpid.toString().hashCode() & 0xffff) % (maxWorkerId + 1);
    }

    /*
     * <p>
     * 数据标识id部分
     * </p>
     */
    protected static long getDatacenterId(long maxDatacenterId) {
        long id = 0L;
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            //生成id
            if (network == null) {
                id = 1L;
            } else {
                byte[] mac = network.getHardwareAddress();
                id = ((0x000000FF & (long) mac[mac.length - 1])
                        | (0x0000FF00 & (((long) mac[mac.length - 2]) << 8))) >> 6;
                id = id % (maxDatacenterId + 1);
            }
        } catch (Exception e) {
            System.out.println(" getDatacenterId: " + e.getMessage());
        }
        //返回id
        return id;
    }
    public static void main(String[] args) {
    	
    	IdWorker idWorker = new IdWorker(1,1);
    	List<Long> longlist = new ArrayList<Long>();
    	for (int i = 0; i < 100; i++) {
    		long longs = idWorker.nextId();
    		longlist.add(longs);
		}
    	for (int i = 0; i < 100; i++) {
    		System.out.println(longlist.get(i));
			
		}
    	System.out.println(longlist.get(0)+" : 1014032149596213248");

	}
}