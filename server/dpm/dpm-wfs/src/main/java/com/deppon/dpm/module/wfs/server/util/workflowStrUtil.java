package com.deppon.dpm.module.wfs.server.util;

public class workflowStrUtil {
    public static String replaceJsonSpecialCharacter(String str){
        if(str == null || str.length() == 0){
            return str;
        }
        
        //制表符 table
        str = str.replaceAll("\t", "");
        
        //
        return str;
    }
}
