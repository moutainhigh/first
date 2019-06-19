package com.deppon.dpm.tongxunlu.server.service.impl;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.server.util.ThreadLocalUtil;
import com.deppon.dpm.module.common.shared.vo.LoginResult;
import com.deppon.dpm.tongxunlu.server.dao.IEmployeeDao;
import com.deppon.dpm.tongxunlu.server.dao.IOrganizationDao;
import com.deppon.dpm.tongxunlu.server.dao.ISystemConfigDao;
import com.deppon.dpm.tongxunlu.server.service.IPersonlyImageService;
import com.deppon.dpm.tongxunlu.server.service.ITongxunLuService;
import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.domain.HotLine;
import com.deppon.dpm.tongxunlu.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;
import com.deppon.dpm.tongxunlu.shared.vo.VPInfoVO;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 通讯录
 * 
 * @author 130126
 */
public class TongxunLuService implements ITongxunLuService {
	/**
	 * log
	 */
	private static final Logger logger = Logger.getLogger(TongxunLuService.class);
	// set injection
	private IPersonlyImageService personlyImageService;
	// set injection
	private String webUrl;
	// set injection
	private IEmployeeDao empDao;
	// set injection
	private ISystemConfigDao systemConfigDao;
	// set injection
	private IOrganizationDao orgDao;
	private JdbcTemplate template;
	
	/**
	 * RedisService
	 */
	private RedisService loginRedisService;
	private static final List<Integer> list = new ArrayList<Integer>();
	static {
		list.add(MagicNumber.NUM0);
		list.add(MagicNumber.NUM3);
		list.add(MagicNumber.NUM4);
		list.add(MagicNumber.NUM5);
		list.add(MagicNumber.NUM6);
		list.add(MagicNumber.NUM7);
		list.add(MagicNumber.NUM14);
		list.add(MagicNumber.NUM15);
		list.add(MagicNumber.NUM16);
		list.add(MagicNumber.NUM17);
		list.add(MagicNumber.NUM18);
		list.add(MagicNumber.NUM19);
		list.add(MagicNumber.NUM20);
		list.add(MagicNumber.NUM21);
		list.add(MagicNumber.NUM22);
		list.add(MagicNumber.NUM23);
		list.add(MagicNumber.NUM24);
		list.add(MagicNumber.NUM25);
		list.add(MagicNumber.NUM26);
		list.add(MagicNumber.NUM30);
		list.add(MagicNumber.NUM31);
		list.add(MagicNumber.NUM37);
		list.add(MagicNumber.NUM38);
		list.add(MagicNumber.NUM43);
		list.add(MagicNumber.NUM44);
		list.add(MagicNumber.NUM45);
		list.add(MagicNumber.NUM46);
		list.add(MagicNumber.NUM47);
		list.add(MagicNumber.NUM48);
	}
	/**
	 * 登陆.
	 * <p>
	 * TODO(方法详细描述说明、方法参数的具体涵义)
	 * </p>
	 * 
	 * @author 130126
	 * @date 2014-4-10 下午3:51:16
	 * @param userid
	 * @param password
	 * @return
	 * @see
	 */
	@Override
	public String login(String userid, String password) {
		return null;
	}

	@Override
	public List<OrganizationVO> searchOrg(OrganizationVO vo, int start,
			int pageSize) {
		// 返回查询结果
		return orgDao.query(vo, start, pageSize);
	}
	
	/**
	 * 查询合伙人权限的组织列表
	 */
	@Override
	public List<OrganizationVO> searchOrgForPartner(OrganizationVO vo,
			int start, int pageSize) {
		return orgDao.queryForPartner(vo, start, pageSize);
	}
	
	/**
	 * 查询父部门
	 * @param orgid
	 * @return
	 */
	public List<OrganizationVO> getParentOrg(String orgid){
		
		List<String> orgids = orgDao.getDeptseqById(orgid);
		List<OrganizationVO> parentOrgs = new ArrayList<OrganizationVO>();
		if(orgids != null && orgids.size() > 0){
			parentOrgs = orgDao.getParentOrg(orgids);
		}
		return parentOrgs;
	}
	
	

	/**
	 * 获取部门人数
	 * @param orglist
	 * @return
	 */
	public List<OrganizationVO> getEmpNum(List<OrganizationVO> orglist){
		for(OrganizationVO org : orglist){
               
				String orgNum = loginRedisService.get(RedisService.DPM_SMS_ORG_NUM_KEY+org.getOrgId());
				    if(null!=orgNum){
					int orgNums = Integer.parseInt(orgNum);
					org.setStaffCount(orgNums);
					}else{
						int num = orgDao.getEmpNum(org.getDeptSeq() +"");
						loginRedisService.set(RedisService.DPM_SMS_ORG_NUM_KEY
								+ org.getOrgId(), String.valueOf(num), MagicNumber.NUM3600);
						org.setStaffCount(num);
					}
                
			
			
		}
		return orglist;
	}

	@Override
	public EmployeeVO getEmpDetail(String id,String empCode) {
		// 定义查询条件
		EmployeeVO vo = new EmployeeVO();
		if (StringUtils.isNotEmpty(empCode)){
			// 定义查询条件
			vo.setEmpCode(empCode);
		}
		if(StringUtils.isEmpty(empCode)&&StringUtils.isNotEmpty(id)&&id.matches("^[0-9]*$")){
			// 定义查询条件
			vo.setEmpId(Integer.parseInt(id));
		}
		// 返回查询结果
		List<EmployeeVO> vos = searchEmp(vo, 0, -1);
		if (vos == null || vos.size() == 0) {
			return null;
		} else {
			try {
				// 查询到的添加头像
				vos.get(0).setHeadPhoto(
						personlyImageService.downloadImage(vos.get(0)
								.getEmpCode()));
			} catch (FileNotFoundException e) {
				// 打印错误
				e.printStackTrace();
			}
			// 返回查询结果,默认返回一个
			return vos.get(0);
		}
	}

	@Override
	public OrganizationVO getOrgDetail(String id) {
		// 定义查询条件
		OrganizationVO vo = new OrganizationVO();
		// 定义查询条件
		vo.setOrgId(Integer.parseInt(id));
		// 返回查询结果
		List<OrganizationVO> vos = searchOrg(vo, 0, -1);
		if (vos == null || vos.size() == 0) {
			return null;
		} else {
			// 返回一个
			return vos.get(0);
		}
	}

	@Override
	public List<EmployeeVO> getEmpByOrgId(String pid, int start, int pageSize) {
		// 定义查询条件
		EmployeeVO vo = new EmployeeVO();
		// 定义查询条件
		vo.setOrgId(Integer.parseInt(pid));
		// 返回结果
		return searchEmp(vo, start, pageSize);
	}
	@Override
	public List<OrganizationEntity> getAllOrgs() {
		// 定义查询条件
		// 定义查询条件
		// 返回结果
		return orgDao.getAllOrgs();
	}

	@Override
	public List<EmployeeVO> searchEmp(EmployeeVO condition, int start,
			int pageSize) {
		// 查询返回
		List<EmployeeVO> list = empDao.query(condition, start, pageSize);
		this.setHeadPhotoAndLeaderMobile(list);
		return list;
	}
	
	
	private void setHeadPhotoAndLeaderMobile(List<EmployeeVO> list){
		if (null != list && list.size() > 0) {
			// 通讯录领导列表
			List<String> leaderList = getEmpleaderConfig();
			for (EmployeeVO emps : list) {
				// 设置头像
				if(StringUtils.isEmpty(emps.getHeadPhoto())) {
					emps.setHeadPhoto("");
				} else {
					emps.setHeadPhoto(webUrl + "/" + "headPhoto/" + emps.getHeadPhoto());
				}
				
				// 根据管理族群来判定权限
				if (!"".equals(emps.getJobGroups())
						&& "管理族群".equals(emps.getJobGroups())) {
					// 参数转换
					emps.setJobGroups("1");
				} else {
					emps.setJobGroups("0");
				}
				// 判断是否是领导
				if (leaderList.contains(emps.getEmpCode())) {
					// 号码置null
					emps.setMobileNo(null);
				}
			}
		}
	}
	
	/**
	 * 查询B10及以上
	 * @return
	 */
	public List<VPInfoVO> getAllVP(){
		List<VPInfoVO> vplist = orgDao.getAllVP();
		for(VPInfoVO vp : vplist){
			// 设置头像
			if(StringUtils.isEmpty(vp.getPictPath())) {
				vp.setHeadPhoto("");
			} else {
				vp.setHeadPhoto(webUrl + "/" + "headPhoto/" + vp.getPictPath());
			}
		}	
		return vplist;
	}
	
	/**
	 * 合伙人搜索人员
	 */
	@Override
	public List<EmployeeVO> searchEmpForPartner(EmployeeVO condition, int start,
			int pageSize) {
		List<EmployeeVO> list = empDao.queryForPartner(condition, start, pageSize);
		this.setHeadPhotoAndLeaderMobile(list);
		return list;
	}

	@Override
	public int queryOrgSize(OrganizationVO org) {
		// 查询返回
		return orgDao.querySize(org);
	}

	@Override
	public int queryEmpSize(EmployeeVO emp) {
		// 查询返回
		return empDao.querySize(emp);
	}

	/**
	 * @author 付众 新增员工数量查询
	 * @date 2015-08-13
	 */
	@Override
	public int uumsQuerySize(EmployeeVO vo) {
		// 查询返回
		return empDao.uumsQuerySize(vo);
	}

	@Override
	public int getEmpByOrgIdCount(String pid) {
		// 查询返回
		return empDao.getEmpByOrgIdCount(pid);
	}

	/**
	 * 更新来电次数
	 * 
	 * @author 045925
	 * @param list
	 * @return
	 */
//	@Transactional("transactionManager")
	@Override
	public int updateCallQuntity(List<EmployeeVO> list) {
		// 如果传入的集合不为空，则进行更新
		if (null != list && list.size() > 0) {
			// 设置返回更新数，初始化为0
			int updateRow = 0;
			for (EmployeeVO vo : list) {
				int empId = vo.getEmpId();
				// 根据人员id更新记录
				updateRow += empDao.updateCallQuntityByEmpId(empId);
			}
			return updateRow;
		}
		return 0;
	}

	@Override
	public void dataMonitor(int monitorType, String empCode, String osType) {
		// 数据监控
		systemConfigDao.dataMonitor(monitorType, empCode, osType);
		Date date = new Date();
		String monthTime = new SimpleDateFormat("yyyyMM").format(date).toString();
		String dayTime = new SimpleDateFormat("yyyyMMdd").format(date).toString();
		// 每月数据监控
		String sql1 = "INSERT INTO month_data_monitor (emp_code, month_access_time, count,update_time,create_time) VALUES (?,?,1,?,?) " +
				"ON DUPLICATE KEY UPDATE count = count + 1, update_time = NOW()";
		template.update(sql1, empCode,Integer.parseInt(monthTime),date,date);
		
		// 如果是模块入口监控
		if(list.contains(monitorType)) {
			// 每个模块数据监控
			String sql2 = "INSERT INTO data_monitor_type"+ monitorType +" (emp_code, day_access_time, count) VALUES (?,?,1) " +
					"ON DUPLICATE KEY UPDATE count = count + 1";
			template.update(sql2,empCode,Integer.parseInt(dayTime));
		}
	}

	@Override
	public List<Map<String, Object>> queryPushUser(String json) {
		// 变换参数
		JSONObject object = JSON.parseObject(json);
		// 获取姓名
		String empname = object.getString("empname");
		// 获取工号
		String empcode = object.getString("empcode");
		// 获取组织名
		String orgname = object.getString("orgname");
		// 获取等级
		String joblevel = object.getString("joblevel");
		// 获取组织名称
		String jobname = object.getString("jobname");
		// 参数拼接
		Map<String, String> map = new HashMap<String, String>();
		// 参数拼接
		map.put("empname", empname);
		// 参数拼接
		map.put("empcode", empcode);
		// 参数拼接
		map.put("orgname", orgname);
		// 参数拼接
		map.put("joblevel", joblevel);
		// 参数拼接
		map.put("jobname", jobname);
		// 返回结果
		return empDao.queryPushUser(map);
	}
	
	/**
	 * 查询工号/名称map
	 * 
	 * @param empCode
	 * @return
	 */
	public Map<String,String> queryUserMap(String empCode,Map<String,String> usersMap){
		// 参数拼接
		Map<String, String> queryMap = new HashMap<String, String>();
		// 条件
		if(StringUtils.isNotEmpty(empCode)){
			queryMap.put("empcode", empCode);
		}
		// 查询数据
		List<Map<String, Object>> list = empDao.queryPushUser(queryMap);
		String empcode = null;
		String empname = null;
		// 数据处理
		for (Map<String, Object> map : list) {
			empcode = (String)map.get("empcode");
			empname = (String)map.get("empname");
			if(StringUtils.isNotEmpty(empcode)&&StringUtils.isNotEmpty(empname)){
				// 设值
				usersMap.put(empcode, empname);
			}
		}
		// 返回
		return usersMap;
	}

	/**
	 * 查询员工详情，无头像，屏蔽领导号码
	 */
	@Override
	public EmployeeEntity queryEmployeeByCode(EmployeeVO params) {
		return empDao.queryEmployeeByCode(params);
	}
	
	/**
	 * 查询询员工详情
	 */
	public EmployeeEntity selectOne(EmployeeVO params){
		return empDao.selectOne(params);
	}

	@Override
	public List<Map<String, Object>> getAllUser() {
		// 获取全部人员
		return empDao.getAllUser();
	}

	public int addEmployee(EmployeeVO vo) {
		// 插入
		return empDao.insert(vo);
	}

	@Override
	public int updateEmployee(EmployeeVO vo) {
		// 更新
		return empDao.update(vo);
	}

	@Override
	public int delEmployee(String empCode) {
		// 删除
		return empDao.deleteByEmpcode(empCode);
	}

	public static final int NUMBER_OF_FIVE = 5;
	public static final int NUMBER_OF_395 = 395;
	@Override
	public List<HotLine> hotLine() {
		// 热线返回
		List<HotLine> list = orgDao.hotLine();
		String osType = ThreadLocalUtil.getThreadLocal().getOsType();
		String appVersion = ThreadLocalUtil.getThreadLocal().getAppVersion();
		int intVal = 0;
		try {
			intVal = Integer.valueOf(appVersion.replace(".", ""));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		if("android".equals(osType) || ("iphone".equals(osType) && intVal > NUMBER_OF_395)) {
			return list;
		}
		
		if(list.size() > NUMBER_OF_FIVE) {
			list = list.subList(0, NUMBER_OF_FIVE);
		}
		return list;
	}
	
	@Override
	public int addOrg(OrganizationEntity entity) {
		// 组织插入
		return orgDao.insert(entity);
	}

	@Override
	public int updateOrg(OrganizationEntity entity) {
		// 组织更新
		return orgDao.update(entity);
	}

	@Override
	public int delOrg(int orgId) {
		// 组织删除
		return orgDao.del(orgId);
	}

	@Override
	public List<OrganizationEntity> searchOrgArchitecture(String orgName) {
		// 组织名查询
		return orgDao.searchOrgArchitecture(orgName);
	}

	@Override
	public int operate(Map<String, String> map) {
		// 点赞
		return empDao.operate(map);
	}

	@Override
	public Map<String, Object> getCount(String userId, String objId) {
		// 根据工号获取数量
		Map<String, Object> count = empDao.getCount(objId);
		// 查询是否存在
		List<String> exists = empDao.checkExist(userId, objId);
		// 结果拼接
		StringBuilder path = new StringBuilder();
		// 头像地址拼接
		path = path.append(webUrl).append("/headPhoto/")
				.append(count.get("pictPath"));
		// 若存在点赞
		if (exists.contains("praise")) {
			// 设置点赞状态为Y，不能再点赞
			count.put("praiseStatus", "Y");
		} else {
			// 设置点赞状态为N，能点赞
			count.put("praiseStatus", "N");
		}
		// 若存在鸡蛋
		if (exists.contains("debase")) {
			// 设置鸡蛋状态为Y，不能再扔
			count.put("debaseStatus", "Y");
		} else {
			// 设置鸡蛋状态为N，能再扔
			count.put("debaseStatus", "N");
		}
		// 拼接头像地址
		count.put("headPhoto", path);
		// 返回
		return count;
	}

	/**
	 * 发现(早)
	 */
	@Override
	public List<Map<String, Object>> getPersonPics(Map<String, Object> map) {
		// 发现数据获取
		List<Map<String, Object>> personPics = empDao.getPersonPics(map);
		// 定义状态
		List<String> exists = null;
		// 路径拼接
		StringBuilder path = null;
		if (null != personPics && personPics.size() > 0) {
			// 发现返回值拼接
			for (Map<String, Object> personPic : personPics) {
				// 每次循环清空上一次数据
				path = new StringBuilder();
				// 地址拼接
				path.append(webUrl + "/");
				// 头像
				path.append("headPhoto/");
				// 头像名称
				path = path.append(personPic.get("pictPath"));
				// 添加属性
				personPic.put("pictPath", path);
				// 判断状态
				exists = empDao.checkExist((String) map.get("userId"),
						(String) personPic.get("empCode"));
				// 同上
				if (exists.contains("praise")) {
					personPic.put("praiseStatus", "Y");
				} else {
					personPic.put("praiseStatus", "N");
				}
				if (exists.contains("debase")) {
					personPic.put("debaseStatus", "Y");
				} else {
					personPic.put("debaseStatus", "N");
				}
			}
		}
		// 返回数据
		return personPics;
	}

	/**
	 * 发现(早)
	 */
	@Override
	public List<Map<String, Object>> getSort(Map<String, String> map) {
		// userid
		String userId = map.get("userId");
		// 排序数据获取
		List<Map<String, Object>> sorts = empDao.getSort(map);
		// 定义状态
		List<String> exists = null;
		// 路径拼接
		StringBuilder path = null;
		if (null != sorts && sorts.size() > 0) {
			for (Map<String, Object> sort : sorts) {
				// 每次循环清空上一次数据
				path = new StringBuilder();
				// 地址拼接
				path.append(webUrl);
				// 头像
				path.append("/headPhoto/");
				// 头像名称
				path = path.append(sort.get("pictPath"));
				// 拼接
				sort.put("pictPath", path);
				// 判断状态
				exists = empDao
						.checkExist(userId, (String) sort.get("empCode"));
				// 同上
				if (exists.contains("praise")) {
					sort.put("praiseStatus", "Y");
				} else {
					sort.put("praiseStatus", "N");
				}
				if (exists.contains("debase")) {
					sort.put("debaseStatus", "Y");
				} else {
					sort.put("debaseStatus", "N");
				}
			}
		}
		// 返回
		return sorts;
	}

	@Override
	public int delAndAdd(EmployeeVO vo) {
		// 先删除
		int del = empDao.deleteByEmpcode(vo.getEmpCode());
		// 后新增
		int ins = empDao.insert(vo);
		return del + ins;
	}

	@Override
	public int operateSmile(Map<String, String> map) {
		// 最美微笑操作
		return empDao.operateSmile(map);
	}

	@Override
	public List<Map<String, Object>> getSmileSort(String userId) {
		// 最美微笑排序
		List<Map<String, Object>> sorts = empDao.getSmileSort();
		// 定义状态
		List<String> exists = null;
		// 路径拼接
		StringBuilder path = null;
		if (null != sorts && sorts.size() > 0) {
			for (Map<String, Object> sort : sorts) {
				// 每次循环清空上一次数据
				path = new StringBuilder();
				// 地址拼接
				path.append(webUrl);
				// 头像
				path.append("/headPhoto/");
				// 头像名称
				path = path.append(sort.get("pictPath"));
				// 拼接
				sort.put("pictPath", path);
				// 判断状态
				exists = empDao.checkSmileExist(userId,
						(String) sort.get("empCode"));
				// 同上
				if (exists.contains("praise")) {
					sort.put("praiseStatus", "Y");
				} else {
					sort.put("praiseStatus", "N");
				}
				if (exists.contains("debase")) {
					sort.put("debaseStatus", "Y");
				} else {
					sort.put("debaseStatus", "N");
				}
			}
		}
		// 返回
		return sorts;
	}

	@Override
	public List<Map<String, Object>> getSmilePersonPics(Map<String, Object> map) {
		// 获取最美微笑数据
		List<Map<String, Object>> personPics = empDao.getSmilePersonPics(map);
		// 定义状态
		List<String> exists = null;
		// 路径拼接
		StringBuilder path = null;
		if (null != personPics && personPics.size() > 0) {
			for (Map<String, Object> personPic : personPics) {
				// 每次循环清空上一次数据
				path = new StringBuilder();
				// 地址拼接
				path.append(webUrl + "/");
				// 头像
				path.append("headPhoto/");
				// 头像名称
				path = path.append(personPic.get("pictPath"));
				// 拼接
				personPic.put("pictPath", path);
				// 判断状态
				exists = empDao.checkSmileExist((String) map.get("userId"),
						(String) personPic.get("empCode"));
				// 同上
				if (exists.contains("praise")) {
					personPic.put("praiseStatus", "Y");
				} else {
					personPic.put("praiseStatus", "N");
				}
				if (exists.contains("debase")) {
					personPic.put("debaseStatus", "Y");
				} else {
					personPic.put("debaseStatus", "N");
				}
			}
		}
		// 返回
		return personPics;
	}

	@Override
	public Map<String, Object> getSmileCount(String userId, String objId) {
		// 获取最美微笑数量
		Map<String, Object> count = empDao.getSmileCount(objId);
		// 判断是否存在
		List<String> exists = empDao.checkSmileExist(userId, objId);
		// 拼接
		StringBuilder path = new StringBuilder();
		// 拼接头像地址
		path = path.append(webUrl).append("/headPhoto/")
				.append(count.get("headPhoto"));
		// 同上
		if (exists.contains("praise")) {
			count.put("praiseStatus", "Y");
		} else {
			count.put("praiseStatus", "N");
		}
		if (exists.contains("debase")) {
			count.put("debaseStatus", "Y");
		} else {
			count.put("debaseStatus", "N");
		}
		count.put("pictPath", path);
		return count;
	}
	
	/**
	 * 根据ids查询人员信息
	 */
	public List<EmployeeVO> queryEmpByUserIds(String[] userIdArray) {
		List<EmployeeVO> list = empDao.queryEmpByUserIds(userIdArray);
		this.setHeadPhotoAndLeaderMobile(list);
		return list;
	}

	/**
	 * 插入通讯录leader信息
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public int insertEmpleaderConfig(Map<String, String> map) {
		// 插入通讯录leader信息
		return empDao.insertEmpleaderConfig(map);
	}

	/**
	 * 删除通讯录leader信息
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public int deleteEmpleaderConfig(String id) {
		// 删除通讯录leader信息
		return empDao.deleteEmpleaderConfig(id);
	}

	/**
	 * 更新通讯录leader信息
	 */
	@Override
	public int updateEmpleaderConfig(Map<String, String> map) {
		// 更新通讯录leader信息
		return empDao.updateEmpleaderConfig(map);
	}
	
	/**
	 * 通讯录领导列表
	 */
	@Override
	public List<String> getEmpleaderConfig() {
		return empDao.getEmpleaderConfig();
	}
	
	/**
	 * 通讯录监控记录：搜索vp用户
	 * 
	 * @param empCodeList
	 * @param empDetail
	 * @param remark
	 */
	public void monitorSearchVpInfo(List<String> empCodeList,EmployeeVO empDetail,String remark){
		// 获取当前登录人信息
		LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
		// 搜索人
		String searchUserId = loginResult.getEmpExtensionEntity().getEmpCode();
		// 被搜索人
		String vpUserId = empDetail.getEmpCode();

		logger.info("通讯录搜索：搜索人："+searchUserId+"---被搜索人--"+"vpUserId"+"--请求参数--"+remark);
		// 如果被搜索人是vp，则保存日志
		if(empCodeList.contains(vpUserId)){
			// 保存参数
			Map<String, String> map = new HashMap<String, String>();
			map.put("searchUserId", searchUserId);
			map.put("vpUserId", vpUserId);
			map.put("remark", remark);
			// 保存数据
			empDao.insertmonitorVpSearch(map);
		}
	}
	
	/**
	 * 获取通讯录被搜索的VP用户List
	 * @return
	 */
	@Override
	public List<String> queryMonitorEmpCodeList(){
		return empDao.queryMonitorEmpCodeList();
	}
	
	
	
	// set injection
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	// set injection
	public void setPersonlyImageService(
			IPersonlyImageService personlyImageService) {
		this.personlyImageService = personlyImageService;
	}

	// get
	public IEmployeeDao getEmpDao() {
		return empDao;
	}

	// set injection
	public void setEmpDao(IEmployeeDao empDao) {
		this.empDao = empDao;
	}

	// get
	public IOrganizationDao getOrgDao() {
		return orgDao;
	}

	// set injection
	public void setOrgDao(IOrganizationDao orgDao) {
		this.orgDao = orgDao;
	}

	// get
	public ISystemConfigDao getSystemConfigDao() {
		return systemConfigDao;
	}

	// set injection
	public void setSystemConfigDao(ISystemConfigDao systemConfigDao) {
		this.systemConfigDao = systemConfigDao;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public RedisService getLoginRedisService() {
		return loginRedisService;
	}

	public void setLoginRedisService(RedisService loginRedisService) {
		this.loginRedisService = loginRedisService;
	}
	
	

}