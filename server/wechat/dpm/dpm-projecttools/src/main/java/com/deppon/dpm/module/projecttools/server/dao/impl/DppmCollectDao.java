package com.deppon.dpm.module.projecttools.server.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.deppon.dpm.module.projecttools.server.dao.IDppmCollectDao;
import com.deppon.dpm.module.projecttools.shared.vo.CollectVo;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 
 * 项目管理 我的关注 dao
 * 
 * @author 195406 高春玲
 * @date 2015-7-27 下午1:45:08
 * @since
 **/
public class DppmCollectDao extends iBatis3DaoImpl implements IDppmCollectDao {
	static Logger logger = LoggerFactory.getLogger(DppmCollectDao.class);
    //
	private JdbcTemplate template;

    /**
     * 收藏
     */
	@Override
    public int dppmCollect(CollectVo vo) {
        // 判断是否收藏 0取消收藏 1 收藏
        String sql = "";
        int collect = 1;
        if (vo != null) {
        	// 取消收藏
            if (vo.getIsCollect() == 0) {
            	// 直接删除表中 关注信息
                sql = "delete from t_dppm_collect where dppm_code='"
                        + vo.getDppmCode() + "' and user_code='" + vo.getUserCode() + "' ";
            } else {
            	// 添加为收藏
            	// 时间格式化到毫秒
                SimpleDateFormat sdf = new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss:SSS");
                // 查询该用户是否已经收藏该项目
                sql = "select dppm_code from t_dppm_collect where dppm_code='"
                        + vo.getDppmCode() + "' and user_code='" + vo.getUserCode() + "' ";
                // 根据sql 获得收藏list
                List<String> dppmList = this.template
                        .queryForList(sql, String.class);
                // 判断是否收藏  
                if (dppmList == null || dppmList.size() <= 0) {
                	// 无收藏 插入收藏表进行收藏保存
                    sql = "insert into t_dppm_collect(user_code,dppm_code,iscollect,add_time) values "
                            + "('" + vo.getUserCode() + "','" + vo.getDppmCode() + "'," + vo.getIsCollect() + ",'" + sdf.format(new Date()) + "')";
                } else {
                	// 已有收藏 直接提示收藏成功
                    logger.info("当前项目编号" + vo.getDppmCode() + " 已经是:"
                            + vo.getUserCode() + " 我的收藏");
                    return 1;
                }
            }
            logger.info("更新我的收藏 sql :" + sql);
            collect = this.template.update(sql);
            logger.info("更新我的收藏 是否成功 :" + collect);
        }
        return collect;

    }

	/**
	 * @param template
	 */
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
}
