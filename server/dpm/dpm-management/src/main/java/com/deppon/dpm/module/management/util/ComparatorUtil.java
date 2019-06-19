package com.deppon.dpm.module.management.util;

import java.util.Comparator;

import com.deppon.dpm.module.management.shared.domain.ApplyStore;


public class ComparatorUtil implements Comparator<ApplyStore>{
	
	public int compare(ApplyStore one, ApplyStore two) {
		int i =  Integer.valueOf(one.getAssortId()).compareTo(Integer.valueOf(two.getAssortId())); //比较分类id  
        if (i == 0) { //如果分类一样，则继续比较应用状态  
            if(one.getAppType() == 2){
            	return 1;
            }else{
            	return -1;
            } 
        } else { //首先比较分类，名字不一样，则返回比较结果  
            return i;  
        }  
	}

}