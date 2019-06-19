
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.OAConverterApply;
import com.deppon.montal.module.workitems.dao.IOATurnForMalDao;
import com.deppon.montal.module.workitems.dao.OATurnFormalDao;
   /** 
 * @Title: OATurnFormalService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-24 下午5:16:06 
 * @version V1.0 
 */
public class OATurnFormalService implements IOATurnFormalService {

	@Override
	public OAConverterApply getOAConverterApply(String workId) {
		IOATurnForMalDao dao = new OATurnFormalDao();
		OAConverterApply oaconverterapply = dao.getOAConverterApply(workId);
		oaconverterapply = dicConvert(oaconverterapply);
		return oaconverterapply;
	}
	@Override
	public OAConverterApply getOAConverterFlowtype(OAConverterApply oaconverterapply) {
		IOATurnForMalDao dao = new OATurnFormalDao();
		OAConverterApply oaconverter_flowtype = dao.getOAConverterFlowtype(oaconverterapply);
		if(oaconverter_flowtype.getFlowtype()!=null){
			oaconverter_flowtype.setFlowtype(splitString(oaconverter_flowtype.getFlowtype()));
		}
		return oaconverter_flowtype;
		
	}
	
	public String splitString(String str){//切割存在于相关数据区的类型值
		int begin = str.indexOf("<flowtype __type=\"java:java.lang.String\">");
		int end = str.indexOf("</flowtype>");
		String tempStr = str.substring(begin, end);
		tempStr = tempStr.substring(tempStr.indexOf(">")+1, tempStr.length());
		String flowtype= null;
		if("-1".equals(tempStr)){
			flowtype = "请选择"; 
		}else if("0".equals(tempStr)){
			flowtype = "通过";
		}else if("1".equals(tempStr)){
			flowtype = "淘汰";
		}else if("2".equals(tempStr)){
			flowtype = "调岗";
		}
		System.out.println(tempStr);
		return flowtype;
	}
	public OAConverterApply dicConvert(OAConverterApply entity){//业务字典转换
		OAConverterApply oaconverterapply = entity;
		if("0".equals(oaconverterapply.getIsnewpx())){
			oaconverterapply.setIsnewpx("是");
		}else if("1".equals(oaconverterapply.getIsnewpx())){
			oaconverterapply.setIsnewpx("否");
		}
		
		if("1".equals(oaconverterapply.getGwflag())){
			oaconverterapply.setGwflag("营运部门人员");
		}else if("2".equals(oaconverterapply.getGwflag())){
			oaconverterapply.setGwflag("外场人员");
		}else if("3".equals(oaconverterapply.getGwflag())){
			oaconverterapply.setGwflag("司机");
		}else if("4".equals(oaconverterapply.getGwflag())){
			oaconverterapply.setGwflag("职能部门");
		}
		return oaconverterapply;
	}
	
}

