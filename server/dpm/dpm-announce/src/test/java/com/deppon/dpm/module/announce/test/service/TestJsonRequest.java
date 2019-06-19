package com.deppon.dpm.module.announce.test.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class TestJsonRequest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jsonStr = getJosnStr();
		//List<String> list = getMyCollIds(jsonStr);
		//System.out.println(list.size());
	}
	
	public static String getJosnStr(){
		String id1 = "1827132b-50c4-46e8-b5ad-a51e77615904";
		String id2 = "1d4fdf21-d1a6-4f74-b46b-dce74545aae9";
		String id3 = "43d79382-91b4-47f6-8d75-a6d0816feb7d";
		List<String> list = new ArrayList<String>();
		list.add(id1);
		list.add(id2);
		list.add(id3);
		String jsonStr = JSON.toJSONString(list);
		System.out.println(jsonStr);
		return jsonStr;
	}
	
	public static List<String> getMyCollIds(String jsonStr){
		List<String> list = new ArrayList<String>();
		JSONArray array = JSON.parseArray(jsonStr);
		int length = array.size();
		if(length > 0){
			for(int i=0;i<length;i++){
				String id = array.getString(i);
				if(StringUtils.isNotEmpty(id)){
					list.add(id);
				}
			}
		}
		if(list.size() > 0){
			return list;
		}
		return null;
	}
	

}
