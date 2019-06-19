package com.deppon.montal.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import oracle.sql.CLOB;


   /** 
   * @ClassName: ConvertPojoUtil 
   * @Description:(ResultSet转化为POJO) 
   * @author 廖建雄 
   * @date 2013-2-20 下午6:01:29 
   * 
   */
public class ConvertPojoUtil {
	
	/**
	 * 将结果集遍历添加到List对象中
	 * @param rs 结果集
	 * @return List
	 * @throws java.sql.SQLException
	 * @throws IOException 
	 */
	public static List resultSetToList(ResultSet rs) throws java.sql.SQLException, IOException{  
	       if(rs==null){  
	           return null;  
	       }  
	       ResultSetMetaData md = rs.getMetaData();  
	       int columnCount = md.getColumnCount();  
	       List list = new ArrayList();  
	       Map rowData;  
	       Object obj = null ;
	       while (rs.next()){  
	           rowData = new HashMap(columnCount);  
	           for (int i=1; i<=columnCount; i++){  
	        	   if(rs.getObject(i) == null)
	        		   continue;
	        	   
	        	   if(rs.getObject(i).getClass().getName().equals("oracle.sql.TIMESTAMP")){
	        		   Timestamp times = rs.getTimestamp(i);
	        		   obj = times;
	        	   }else if(rs.getObject(i).getClass().getName().equals("oracle.sql.CLOB")){
	        	       CLOB clob= (CLOB) rs.getClob(i);
	        	       Reader r = clob.getCharacterStream(); //得到流
	        	       BufferedReader br = new BufferedReader(r);
	        	       String s =  br.readLine();
	        	       StringBuffer sb = new  StringBuffer();
	        	       while(s !=null){
	        		   sb.append(s);
	        		   s = br.readLine();
	        	       }
	        	       obj = sb.toString();
	        	   }else{
	        		   obj = rs.getObject(i);
	        	   }
	                   rowData.put(md.getColumnName(i),obj);  
	           }  
	           list.add(rowData);  
	       }  
	       return list;  
	   }  
	
	 /** 
     *  封装实体对象
     * @param bean 需要封装的实体类 
     * @param map 需要转换的map 
     * @return 已经封装好数据的实体类（object） 
     */  
    public static  Object mapToBean(Object bean, Map map) {  
        Map methods = new HashMap();  
        Method m[] = bean.getClass().getMethods();  
        for (int i = 0; i < m.length; i++) {  
            Method method = m[i];  
            String methodName = method.getName().toUpperCase();  
            methods.put(methodName, method);  
        }  
        Iterator it = null;  
        String key = "";  
        it = map.keySet().iterator();  
        int index = 0;
        while (it.hasNext()) {  
            key = (String) it.next();  
            String name = "GET" + key.toUpperCase();  
            if (methods.containsKey(name)) {  
                Method setMethod = (Method) methods.get("SET" + key.toUpperCase());  
                try {  
                    if(setMethod!=null){  
                        Object[] obj=null;  
                        obj=new Object[1];  
                        obj[0]=map.get(key);  
                    setMethod.invoke(bean,obj);  
                    index++;
                    }  
                    else{  
                        continue;  
                    }  
                } catch (IllegalAccessException e) {  
                    e.printStackTrace();  
                } catch (InvocationTargetException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return bean;  
    }  

}
