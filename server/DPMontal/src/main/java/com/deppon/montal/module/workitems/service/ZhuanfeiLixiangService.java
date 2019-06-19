
    package com.deppon.montal.module.workitems.service; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.CCZhuanfeiLixiang;
import com.deppon.montal.module.workitems.dao.IZhuanfeiLixiangDao;
import com.deppon.montal.module.workitems.dao.ZhuanfeiLixiangDao;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: ZhuanfeiLixiangDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (专项费用立项申请工作流数据操作) 
 * @author 廖建雄 
 * @date 2013-6-20 上午10:43:50 
 * @version V1.0 
 */
public class ZhuanfeiLixiangService implements IZhuanfeiLixiangService {
    private static IZhuanfeiLixiangDao dao = new ZhuanfeiLixiangDao();

    @Override
    public CCZhuanfeiLixiang getLixiangInfo(String processinstid) {
	
	  return dao.getLixiangInfo(processinstid);
    }
}

