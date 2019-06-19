package com.deppon.dpm.store.server.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.store.server.vo.LabelVo;

/**
 * 
 * @author XiaoTian
 *
 */
public class ArrayToString {
	/**
     * 将数组转换成以逗号分隔的字符串
     * 
     * @param needChange
     *            需要转换的数组
     * @return String 以逗号分割的字符串
     */
    public static String arrayToStrWithComma(String[] needChange) {
    	/**
    	 * 创建对象 StringBuffer
    	 */
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < needChange.length; i++) {
        	//进行追加字符串
            sb.append(needChange[i]);
            //进行判断当前是否
            if ((i + 1) != needChange.length) {
                sb.append(",");
            }
        }
        //输出String字符串
        return sb.toString();
    }
    
    /**
     * 
     * @param arraylabel
     * @return
     */
	public static String arrayToStrWithComma(List<LabelVo> arraylabel) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		// 循环判断List
        for (int i = 0; i < arraylabel.size(); i++) {
        	if (arraylabel.get(i).isIssel()) {
        		//追加字符串
        		sb.append(arraylabel.get(i).getTagename());
        		//i+1
                if ((i + 1) != arraylabel.size()) {
                    sb.append(",");
                }
			}
        }
        //输出String字符串
		return sb.toString();
	}
}
