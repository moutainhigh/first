
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OARemoval;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: RemovalDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(新点开设/旧点搬迁) 
 * @author 何玲菠 
 * @date 2013-7-16 上午11:47:08 
 * @version V1.0 
 */
public class RemovalDao implements IRemovalDao {
	private static Logger logger = Logger.getLogger(RemovalDao.class);
	private static String QUERY_INFO = "select   " +
			"PROCESSINSTID  ,  " +
			"NAME           ,  " +
			"EMPID          ,  " +
			"ORGNAME        ,  " +
			"MANAGERNAME    ,  " +
			"LEASE          ,  " +
			"DEPOSIT        ,  " +
			"RENT           ,  " +
			"AREA           ,  " +
			"(select e.dictname from eos_dict_entry e where e.dicttypeid = 'DIP_IFVALID' and e.dictid = a.CANCARD)  CANCARD ,  " +
			"DIST           ,  " +
			"ISACCORD       ,  " +
			"REASON         ,  " +
			"MANAGERAREA    ,  " +
			"COMPANY        ,  " +
			"(select e.dictname from eos_dict_entry e where e.dicttypeid = 'DIP_DIVISION_NEW' and e.dictid=a.DIVISION)   DIVISION,  " +
			"BIGREGIONAL    ,  " +
			"(select e.dictname from T_EOS_DICT_ENTRY e where e.dictid = a.city and e.dicttypeid = 'DIP_PROVINCE')  CITY           ,  " +
			"(select e.dictname from T_EOS_DICT_ENTRY e where e.dictid = a.regional and e.dicttypeid = 'DIP_PROVINCE') REGIONAL       ,  " +
			"STARTTIME      ,  " +
			"FLAG           ,  " +
			"PNAME          ,  " +
			"(select e.dictname from eos_dict_entry e where e.dicttypeid = 'DIP_SELLOFFICE_NEW' and e.dictid=a.OFFICENAME)  OFFICENAME,  " +
			"PURPOSENAME    ,  " +
			"SUBMITTIMES    ,  " +
			"(select e.dictname  from eos_dict_entry e where e.dicttypeid = 'DIP_NATURE' and e.dictid = a.applytype)  applytype ,  " +
			"ORGCODE        ,  " +
			"OLDORGNAME     ,  " +
			"NEWORGNAME     ,  " +
			"MANAGERCODE    ,  " +
			"ORGPHONE       ,  " +
			"LAYERS         ,  " +
			"SENDORGADDRESS ,  " +
			"CONTRACTAREA   ,  " +
			"(select e.dictname from T_EOS_DICT_ENTRY e where e.dictid = a.PROVINCE and e.dicttypeid = 'DIP_PROVINCE') PROVINCE       ,  " +
			"(select e.dictname from eos_dict_entry e where e.dicttypeid = 'WFS_GORL' and e.dictid = a.ISSECTOR )   ISSECTOR ,  " +
			"POINTNUMBER    ,  " +
			"TRANSFER       ,  " +
			"AREARENT       ,  " +
			"(select e.dictname from eos_dict_entry e where e.dicttypeid = 'DIP_PAY_PERIOD' and e.dictid = a.PAYMENTPERIOD) PAYMENTPERIOD,  " +
			"(select e.dictname from eos_dict_entry e where e.dicttypeid='DIP_PAY_MEHTOD' and e.dictid=a.PAYMENTMETHOD)  PAYMENTMETHOD,  " +
			"(select e.dictname from eos_dict_entry e where e.dicttypeid = 'DIP_NETNATURE' and e.dictid = a.BRANCHNATURE)  BRANCHNATURE ," +
			"SUBCOMPANY     , " +
			"SUBCOMPANYCODE , " +
			"OTHERPERIOD    , " +
			"MANAGEREMPID   , " +
			"OLDORGCODE     " +
			"from  oa_removal a " +
			"where 1=1 " +
			"and " +
			"a.processinstid = ?";
	@Override
	public OARemoval getOARemoval(String pid) {
		Object[] param = {pid};
		Connection conn = null;
		ResultSet rs = null;
		OARemoval removal = new OARemoval();
		try {
			conn = ConnectionManager.getConnection();
			rs = ConnectionManager.query(conn, QUERY_INFO, param);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				removal = (OARemoval)ConvertPojoUtil.mapToBean(new OARemoval(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
			logger.error("RemovalDao SQL错误"+e.getMessage());
		} catch (IOException e) {
			logger.error("RemovalDao rs转换为List错误!"+e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		return removal;
	}

}

