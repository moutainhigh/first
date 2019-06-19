
    package com.deppon.montal.module.workitems.service; 

import java.util.ArrayList;
import java.util.List;

import com.deppon.montal.model.OASealCarveApply;
import com.deppon.montal.module.workitems.dao.IOASealCarveApplyDao;
import com.deppon.montal.module.workitems.dao.OASealCarveApplyDao;
   /** 
 * @Title: OASealCarveApplyService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(刻章申请service层) 
 * @author 何玲菠 
 * @date 2013-8-20 下午3:54:56 
 * @version V1.0 
 */
public class OASealCarveApplyService implements IOASealCarveApplyService {

	@Override
	public OASealCarveApply getOASealCarveApplyByProcessinstid(
			String processinstid) {
		// TODO Auto-generated method stub return null;
		IOASealCarveApplyDao dao = new OASealCarveApplyDao();
		return splitSubList(dao.getOASealCarveApplyByprocessinstid(processinstid));
	}
	
	/**
	 * 
	   * @Title: splitSubList 
	   * @Description:TODO(分割实体中得属性值 ) 
	   * @param @param oaSealCarveApply
	   * @param @return 设定文件 
	   * @returnOASealCarveApply 返回类型 
	   * @throws 
	   * @date 2013-8-21 上午10:34:05
	 */
	@SuppressWarnings("unchecked")
	public OASealCarveApply splitSubList(OASealCarveApply oaSealCarveApply){
		OASealCarveApply temp = new OASealCarveApply();
		List list = new ArrayList();
		if(!oaSealCarveApply.getSealname().substring(0, oaSealCarveApply.getSealname().length()-1).contains("|")){
			temp.setSealname(oaSealCarveApply.getSealname().substring(0, oaSealCarveApply.getSealname().length()-1));
			temp.setIsfirstcarve(oaSealCarveApply.getIsfirstcarve().substring(0, oaSealCarveApply.getIsfirstcarve().length()-1));
			temp.setProvidecom(oaSealCarveApply.getProvidecom().substring(0, oaSealCarveApply.getProvidecom().length()-1));
			temp.setIsrecordinps(oaSealCarveApply.getIsrecordinps().substring(0, oaSealCarveApply.getIsrecordinps().length()-1));
			list.add(temp);
			oaSealCarveApply.setSublist(list);
			return oaSealCarveApply;
		}else{
			String[] sealname = oaSealCarveApply.getSealname().substring(0, oaSealCarveApply.getSealname().length()-1).split("\\|");
			String[] isfirstcarve = oaSealCarveApply.getIsfirstcarve().substring(0, oaSealCarveApply.getIsfirstcarve().length()-1).split("\\|");
			String[] providecom = oaSealCarveApply.getProvidecom().substring(0, oaSealCarveApply.getProvidecom().length()-1).split("\\|");
			String[] isrecordinps = oaSealCarveApply.getIsrecordinps().substring(0, oaSealCarveApply.getIsrecordinps().length()-1).split("\\|");
			for(int i=0;i<=sealname.length-1;i++){
				OASealCarveApply tempObject = new OASealCarveApply();
				tempObject.setSealname(sealname[i]);
				tempObject.setIsfirstcarve(isfirstcarve[i]);
				tempObject.setProvidecom(providecom[i]);
				tempObject.setIsrecordinps(isrecordinps[i]);
				list.add(tempObject);
			}
			oaSealCarveApply.setSublist(list);
			return oaSealCarveApply;
		}
	}
}

