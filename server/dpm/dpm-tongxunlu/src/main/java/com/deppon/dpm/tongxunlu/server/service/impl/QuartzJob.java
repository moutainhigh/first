//package com.deppon.dpm.tongxunlu.server.service.impl;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.ConnectionCallback;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import com.alibaba.druid.pool.DruidPooledConnection;
//import com.deppon.dpm.tongxunlu.server.service.IOmConfigService;
//import com.deppon.dpm.tongxunlu.server.service.ISyncBaseDataService;
//import com.deppon.dpm.tongxunlu.server.service.ISystemConfigService;
//import com.deppon.dpm.tongxunlu.server.util.Constants;
////import com.deppon.dpm.tongxunlu.server.util.DbPoolConnection;
//import com.deppon.dpm.tongxunlu.shared.domain.OmConfigEntity;
//import com.deppon.dpm.tongxunlu.shared.dto.OmConfigQueryDto;
//import com.deppon.dpm.tongxunlu.shared.vo.BaseSyncInfo;
//import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
//import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;
//import com.deppon.dpm.tongxunlu.shared.vo.SystemConfig;
//
///**
// * 每天晚上一点1时开始同步人员数据.
// * 
// * @author 130126
// * 
// */
//public class QuartzJob {
//	private final static Logger LOG = LoggerFactory.getLogger(QuartzJob.class);
//	public final static String ADD = "1";
//	public final static String MODIFY = "2";
//	public final static String DEL = "3";
//	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	
//	@Autowired
//	private ISystemConfigService systemConfigService;
//	@Autowired
//	private ISyncBaseDataService syncBaseDataService;
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	@Autowired
//	private JdbcTemplate oaJdbcTemplate;
//	@Autowired
//	private IOmConfigService omConfigService;
//
//	private class GetSynchronized implements Runnable {
//		// 开始的倒数锁.
//		CountDownLatch begin = new CountDownLatch(1);
//		// 结束的倒数锁
//		CountDownLatch end = new CountDownLatch(2);
//		ExecutorService exec = Executors.newFixedThreadPool(2);
//		Date start = new Date(System.currentTimeMillis());
//		String startTime, endTime;
//		String startSynTime, endSynTime;
//		Date endSynDate;
//
//		public GetSynchronized() {
//			new Thread(this).start();
//		}
//
//		@Override
//		public void run() {
//			long now = System.currentTimeMillis();
//			//zxy 20140805 DPM-299 start 新增:线程优化
//			StringBuilder sb = new StringBuilder();
//			BaseSyncInfo baseSyncInfo = null;
//			try {
//				SystemConfig systemConfig = systemConfigService.querySingleSystemConfig(new SystemConfig());
//				
//				if (systemConfig.getLastsyndate() != null) {
//					Date d = df.parse(systemConfig.getLastsyndate() + "");
//					System.out.println((now - d.getTime()) + "时间间隔...");
//					// 如果时间间隔在5小时以内有同步过，就不进行后面的同步
//					if ((now - d.getTime()) < 1000 * 60 * 60 * 12) {
//						System.out.println("在12小时内有同步过.");
////						return;
//					} else {
//						int updInt = systemConfigService.updateSyncDateByLastSyncDate(d, new Date());
//						if(updInt <= 0){
//							LOG.error("线程执行冲突,停止本次操作");
//							return;
//						}
//					}
//				}
//				//zxy 20140805 DPM-299 end 新增:线程优化
//				
//				// 如果没有进行过同步，就初始化插入一下同步数据.
//				else {
//					// 否则马上插入当前的时间
//					jdbcTemplate.execute(new ConnectionCallback() {
//						@Override
//						public Object doInConnection(Connection con)
//								throws SQLException, DataAccessException {
//							PreparedStatement ps = con
//									.prepareStatement("insert into system_config( lastsyndate) values (?)");
//							ps.setTimestamp(
//									1,
//									new java.sql.Timestamp(System
//											.currentTimeMillis()));
//							ps.executeUpdate();
//							return null;
//						}
//
//					});
//				}
//				//查询最近的一条同步成功记录
//				OmConfigQueryDto queryEntity = new OmConfigQueryDto();
//				queryEntity.setSynSuccess(true);
//				List<OmConfigEntity> omConfigEntityLst = omConfigService.queryOmConfigEntityByEntity(queryEntity, 0, 1);
//				OmConfigEntity omConfigEntity = null;
//				if(omConfigEntityLst != null && omConfigEntityLst.size() > 0)
//					omConfigEntity = omConfigEntityLst.get(0);
//				if(omConfigEntity == null){
//					LOG.warn("未查询到最近一次成功处理记录");
//					return ;
//				}
//				startTime = df.format(omConfigEntity.getSynStartDate());
//				endTime = "";
//				try {
//					Date start = df.parse(startTime);
//					// 得到开始同步的时间.
//					startSynTime = df.format(start);
////					endSynDate = afterOneDay(start);
//					endSynDate =new Date();
//
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
//				// 如果同步结束时间在当前时间之前，就不进行同步.
//				if (endSynDate != null) {
//					endTime = df.format(endSynDate);
//					System.out.println("查找变化区间：同步开始时间：" + startTime
//							+ ",同步结束时间：" + endTime);
//					// 开始同步操作
//					baseSyncInfo = syncBaseDataService.executeDataSync(startTime, endTime);
//				} else {
//					System.out.println("endSynDate为空...");
//				}
//			} catch (Exception e) {
//				if(baseSyncInfo == null){
//					baseSyncInfo = new BaseSyncInfo();
//					baseSyncInfo.setSyncStatus(Constants.SYNC_STATUS_FAIL);
//					baseSyncInfo.addMessage("通讯录同步异常:" + e.getMessage());
//				}
//				LOG.error("通讯录同步异常",e);
//			} finally {
//				if(baseSyncInfo == null){
//					baseSyncInfo = new BaseSyncInfo();
//					baseSyncInfo.setSyncStatus(Constants.SYNC_STATUS_FAIL);
//				}
//				if (endSynDate != null) {
//					exec.shutdown();
//					final Date synEndTime = new Date(System.currentTimeMillis());
//					final int orgCount = getChangedOrgCount(startTime, endTime);
//					final int empCount = getChangedEmpCount(startTime, endTime);
//					final String syncStatus = baseSyncInfo.getSyncStatus();
//					final String exceptionMsg = baseSyncInfo.getMessage();
//					jdbcTemplate.execute(new ConnectionCallback() {
//						@Override
//						public Object doInConnection(Connection con)
//								throws SQLException, DataAccessException {
//							
//							PreparedStatement ps = con
//									.prepareStatement("insert into om_config( syn_starttime,syn_endtime,emp_num,org_num,syn_startdate,syn_successed,syn_message) values (?,?,? ,?,?,?,?)");
//							ps.setTimestamp(1,
//									new java.sql.Timestamp(start.getTime()));
//							ps.setTimestamp(2, new java.sql.Timestamp(
//									synEndTime.getTime()));
//							ps.setInt(3, empCount);
//							ps.setInt(4, orgCount);
//							ps.setTimestamp(5, new java.sql.Timestamp(
//									endSynDate.getTime()));
//							ps.setString(6, syncStatus);
//							ps.setString(7, exceptionMsg);
//							ps.executeUpdate();
//							return null;
//						}
//
//					});
//				}
//			}
//		}
//
//	}
//
//	public void work() {
//		new GetSynchronized();
//
//		System.out.println("Quartz的任务调度！！！" + new Date());
//	}
//
//	/**
//	 * 得到时间段内变化的人员数据量.
//	 * 
//	 * @param startTime
//	 * @param endTime
//	 * @return
//	 */
//	private int getChangedEmpCount(final String startTime,final String endTime) {
//		int changedEmpCount = 0;
//		changedEmpCount = oaJdbcTemplate.execute(new ConnectionCallback<Integer>() {
//			@Override
//			public Integer doInConnection(Connection con)
//					throws SQLException, DataAccessException {
//				int _result = 0;
//				PreparedStatement ps = con
//						.prepareStatement("select count(1) from dip_user_changeddata  where changeddate >= to_date(?, 'yyyy-MM-dd hh24:mi:ss') "
//								+ "  and changeddate < to_date(?, 'yyyy-MM-dd  hh24:mi:ss') ");
//				ps.setString(1, startTime);
//				ps.setString(2, endTime);
//				// 逐行循环进行插入到mysql数据库
//				ResultSet rs = ps.executeQuery();
//				while (rs.next()) {
//					_result = rs.getInt(1);
//				}
//				return _result;
//			}
//		});
//		return changedEmpCount;
//		
////		DbPoolConnection dbp;
////		DruidPooledConnection con;
////		EmployeeVO vo = new EmployeeVO();
////		List<EmployeeVO> result = new ArrayList<EmployeeVO>();
////		int _result = 0;
////		try {
////			dbp = DbPoolConnection.getInstance();
////			con = dbp.getConnection();
////			PreparedStatement ps = con
////					.prepareStatement("select count(1) from dip_user_changeddata  where changeddate >= to_date(?, 'yyyy-MM-dd hh24:mi:ss') "
////							+ "  and changeddate < to_date(?, 'yyyy-MM-dd  hh24:mi:ss') ");
////			ps.setString(1, startTime);
////			ps.setString(2, endTime);
////			// 逐行循环进行插入到mysql数据库
////			ResultSet rs = ps.executeQuery();
////			while (rs.next()) {
////				_result = rs.getInt(1);
////			}
////			rs.close();
////			ps.close();
////			con.close();
////			dbp = null;
////		} catch (Exception e) {
////			e.printStackTrace();
////		} finally {
////			return _result;
////		}
//	}
//
//	/**
//	 * 得到时间段内变化的组织机构的数据量.
//	 * 
//	 * @param startTime
//	 * @param endTime
//	 * @return
//	 */
//	private int getChangedOrgCount(final String startTime, final String endTime) {
//		int changedOrgCount = 0;
//		changedOrgCount = oaJdbcTemplate.execute(new ConnectionCallback<Integer>() {
//			@Override
//			public Integer doInConnection(Connection con)
//					throws SQLException, DataAccessException {
//				int _result = 0;
//				PreparedStatement ps = con
//						.prepareStatement("select count(1) from dip_org_changeddata"
//								+ " org where changeddate >= to_date(?, 'yyyy-MM-dd hh24:mi:ss') "
//								+ "and changeddate < to_date(?, 'yyyy-MM-dd hh24:mi:ss')  ");
//				ps.setString(1, startTime);
//				ps.setString(2, endTime);
//				// 逐行循环进行插入到mysql数据库
//				ResultSet rs = ps.executeQuery();
//				while (rs.next()) {
//					_result = rs.getInt(1);
//				}
//				return _result;
//			}
//		});
//		return changedOrgCount;
//		
////		DbPoolConnection dbp;
////		DruidPooledConnection con;
////		List<OrganizationVO> result = new ArrayList<OrganizationVO>();
////		OrganizationVO org = new OrganizationVO();
////		int _result = 0;
////		try {
////			dbp = DbPoolConnection.getInstance();
////			con = dbp.getConnection();
////			PreparedStatement ps = con
////					.prepareStatement("select count(1) from dip_org_changeddata"
////							+ " org where changeddate >= to_date(?, 'yyyy-MM-dd hh24:mi:ss') "
////							+ "and changeddate < to_date(?, 'yyyy-MM-dd hh24:mi:ss')  ");
////			ps.setString(1, startTime);
////			ps.setString(2, endTime);
////			// 逐行循环进行插入到mysql数据库
////			ResultSet rs = ps.executeQuery();
////			while (rs.next()) {
////				_result = rs.getInt(1);
////			}
////			rs.close();
////			ps.close();
////			con.close();
////			dbp = null;
////		} catch (Exception e) {
////			e.printStackTrace();
////		} finally {
////			return _result;
////		}
//	}
//
//
//	public static final long ONEDAYMILLISECONDS = 86400000;
//
//	/**
//	 * 返回一天以后的日期. 如果一天以后的日期大于当前日期，就直接返回当前日期.
//	 * 
//	 * @param date
//	 * @param days
//	 * @return
//	 */
//	public static Date afterOneDay(Date date) {
//		if (date == null)
//			return null;
//		Date now = new Date();
//		Date newDate = new Date();
//		long tp = date.getTime();
//		tp = tp +  ONEDAYMILLISECONDS ;
//		newDate.setTime(tp);
//		if (newDate.getTime() > now.getTime())
//			return null;
//		return newDate;
//	}
//
//
//	public JdbcTemplate getJdbcTemplate() {
//		return jdbcTemplate;
//	}
//
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//
//	public ISyncBaseDataService getSyncBaseDataService() {
//		return syncBaseDataService;
//	}
//
//	public void setSyncBaseDataService(ISyncBaseDataService syncBaseDataService) {
//		this.syncBaseDataService = syncBaseDataService;
//	}
//}
