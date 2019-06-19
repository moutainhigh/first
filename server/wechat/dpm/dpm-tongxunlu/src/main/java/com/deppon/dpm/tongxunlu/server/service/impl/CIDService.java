package com.deppon.dpm.tongxunlu.server.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.server.util.AES;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.server.util.ZipUtil;
import com.deppon.dpm.tongxunlu.server.dao.ICIDDao;
import com.deppon.dpm.tongxunlu.server.dao.IEmployeeDao;
import com.deppon.dpm.tongxunlu.server.service.ICIDService;
import com.deppon.dpm.tongxunlu.shared.domain.CIDEntity;
import com.deppon.dpm.tongxunlu.shared.vo.CIDBook;
import com.deppon.dpm.tongxunlu.shared.vo.CIDEMP;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

public class CIDService implements ICIDService {

	private static final Logger LOG = LoggerFactory.getLogger(CIDService.class);

	private ICIDDao cIDDao;

	private IEmployeeDao employeeDao;

	private String serverHostPort;

	private String encryptKey;

	private String cidBaseDir;

	/**
	 * 查询来电显示通讯录版本信息
	 */
	public List<CIDEntity> queryCIDByOsType(String osType) {
		List<CIDEntity> list = cIDDao.queryCIDByOsType(osType);
		for (CIDEntity cidEntity : list) {
			cidEntity.setDownloadUrl(serverHostPort + cidEntity.getDownloadUrl());
		}
		return list;
	}

	/**
	 * 处理android结果集
	 * 
	 * @param mobileNo
	 * @param map
	 */
	private void dealAndroidMap(CIDEMP emp, HashMap<String, TreeSet<CIDEMP>> map) {
		// 手机号前3位
		String sub = String.valueOf(emp.getMobileNo()).substring(0, 5);
		// 是否包括key
		if (!map.containsKey(sub)) {
			TreeSet<CIDEMP> set = new TreeSet<CIDEMP>();
			set.add(emp);
			map.put(sub, set);
		} else {
			// 取value值
			TreeSet<CIDEMP> set = map.get(sub);
			set.add(emp);
		}
	}

	/**
	 * 处理android通讯录文件
	 * 
	 * @param map
	 */
	private void dealAndroidFile(HashMap<String, TreeSet<CIDEMP>> map) {
		BufferedWriter bwAndroid = null;
		try {
			// 数据不为空
			if (!map.isEmpty()) {
				// 存放临时目录
				File file = new File(cidBaseDir + "/target-an");
				if (!file.exists()) {
					file.mkdirs();
				}
				// 循环处理
				for (Map.Entry<String, TreeSet<CIDEMP>> entry : map.entrySet()) {
					File targetFile = new File(file, "cid-an-" + entry.getKey()
							+ ".txt");
					// 写文件
					bwAndroid = new BufferedWriter(new FileWriter(targetFile));
					bwAndroid
							.write(JSON.toJSONString(entry.getValue() != null ? entry
									.getValue() : ""));
					bwAndroid.flush();
					bwAndroid.close();
				}
				// 压缩文件
				boolean flag = ZipUtil.fileToZip(cidBaseDir + "/target-an",
						cidBaseDir, "tmp-an");
				if (flag) {
					// 对zip加密
					AES.encryptFile(cidBaseDir + "/tmp-an.zip", cidBaseDir
							+ "/cid-an.zip", encryptKey);
					// 删除target文件夹
					this.deleteDir(file);
					// 删除tmp.zip
					new File(cidBaseDir + "/tmp-an.zip").delete();
					// 插入或修改来电显示通讯录版本信息
					List<CIDEntity> list = cIDDao.queryCIDByOsType("android");
					if (list.size() > 0) {
						CIDEntity cidEntity = list.get(0);
						cidEntity.setPrevUpdateTime(cidEntity.getUpdateTime());
						cidEntity.setUpdateTime(new Date());
						// 修改
						cIDDao.updateCID(cidEntity);
					} else {
						// 新增
						CIDEntity entity = new CIDEntity();
						entity.setOsType("android");
						entity.setDownloadUrl(cidBaseDir + "/cid-an.zip");
						entity.setCreateTime(new Date());
						entity.setUpdateTime(entity.getCreateTime());
						entity.setPrevUpdateTime(entity.getCreateTime());
						cIDDao.insertCID(entity);
					}
				}
			}
		} catch (Exception e) {
			LOG.error("同步android来电显示通讯录出错!!!", e);
		} finally {
			// 释放资源
			if (null != bwAndroid) {
				try {
					bwAndroid.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 处理android通讯录文件
	 * 
	 * @param set
	 */
	private void dealIosFile(TreeSet<CIDEMP> set) {
		BufferedWriter bw = null;
		try {
			ArrayList<Long> number = new ArrayList<Long>();
			ArrayList<String> labels = new ArrayList<String>();
			for (CIDEMP cidEmp : set) {
				number.add(cidEmp.getMobileNo());
				labels.add(cidEmp.getEmpname() + "（" + cidEmp.getOrgname() + "）");
			}

			if (number.size() != 0) {
				File file = new File(cidBaseDir + "/target");
				if (!file.exists()) {
					file.mkdirs();
				}

				// 分割的文件个数，每个文件1W条数据
				int count = number.size() % MagicNumber.NUM10000 == 0 ? number
						.size() / MagicNumber.NUM10000 : number.size()
						/ MagicNumber.NUM10000 + 1;

				for (int i = 0; i < count; i++) {
					File targetFile = new File(file, "cid-" + (i + 1) + ".txt");

					int start = i * MagicNumber.NUM10000;
					int end = start;
					if (i != count - 1) {
						end = start + MagicNumber.NUM10000;
					} else {
						end = number.size();
					}

					// 1W条数据
					List<Long> subNumber = number.subList(start, end);
					List<String> sublabels = labels.subList(start, end);

					// 将处理的数据写入到文件
					bw = new BufferedWriter(new FileWriter(targetFile));
					bw.write(JSON
							.toJSONString(new CIDBook(subNumber, sublabels)));
					bw.flush();
					bw.close();
				}

				// 压缩文件
				boolean flag = ZipUtil.fileToZip(cidBaseDir + "/target",cidBaseDir, "tmp");

				if (flag) {
					// 对zip加密
					AES.encryptFile(cidBaseDir + "/tmp.zip", cidBaseDir + "/cid.zip", encryptKey);

					// 删除target文件夹
					this.deleteDir(file);

					// 删除tmp.zip
					new File(cidBaseDir + "/tmp.zip").delete();

					// 插入或修改来电显示通讯录版本信息
					List<CIDEntity> list = cIDDao.queryCIDByOsType("iphone");
					if (list.size() > 0) {
						CIDEntity cidEntity = list.get(0);
						cidEntity.setPrevUpdateTime(cidEntity.getUpdateTime());
						cidEntity.setUpdateTime(new Date());
						// 修改
						cIDDao.updateCID(cidEntity);
					} else {
						// 新增
						CIDEntity entity = new CIDEntity();
						entity.setOsType("iphone");
						entity.setDownloadUrl(cidBaseDir + "/cid.zip");
						entity.setCreateTime(new Date());
						entity.setUpdateTime(entity.getCreateTime());
						entity.setPrevUpdateTime(entity.getCreateTime());
						cIDDao.insertCID(entity);
					}
				}
			}
		} catch (Exception e) {
			LOG.error("同步android来电显示通讯录出错!!!", e);
		} finally {
			// 释放资源
			if (null != bw) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 同步来电显示通讯录
	 */
	public boolean syncCIDBook() {
		try {
			// 查询所有人员信息
			List<EmployeeVO> emps = employeeDao.queryAllForCID();
			TreeSet<CIDEMP> set = new TreeSet<CIDEMP>();
			// android结果集
			HashMap<String, TreeSet<CIDEMP>> map = new HashMap<String, TreeSet<CIDEMP>>();
			// 手机号正则表达式
			String regex = "^1[3|4|5|7|8]\\d{9}$";
			Pattern pattern = Pattern.compile(regex);
			for (EmployeeVO employeeVO : emps) {
				String mobileNo = employeeVO.getMobileNo();
				String empName = employeeVO.getEmpName();
				String orgName = employeeVO.getOrgName();

				Matcher m = pattern.matcher(mobileNo == null ? "" : mobileNo);
				// 如果手机不合法或者姓名为空或者部门为空则跳过
				if (!m.find() || StringUtils.isBlank(empName)
						|| StringUtils.isBlank(orgName)) {
					continue;
				}
				// 封装实体，添加到set中进行排序和去重
				CIDEMP emp = new CIDEMP(Long.parseLong("86" + mobileNo),
						empName, orgName);
				set.add(emp);

				// android数据处理
				dealAndroidMap(emp, map);
			}

			// 处理android通讯录文件
			dealAndroidFile(map);

			// 处理ios通讯录文件
			dealIosFile(set);
			
			return true;
		} catch (Exception e) {
			LOG.error("同步来电显示通讯录出错!!!", e);
		}
		return false;
	}

	// 删除目录及下所有文件及文件夹
	private boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// 目录此时为空，可以删除
		return dir.delete();
	}

	/**
	 * 根据手机号查询用户信息
	 * 
	 * @param iphoneNo
	 * @return
	 */
	@Override
	public CIDEMP queryUserInfoByNo(String iphoneNo) {
		// 返回对象
		CIDEMP emp = null;
		// 查询数据
		List<CIDEMP> list = cIDDao.queryUserInfoByNo(iphoneNo);
		// 获取数据
		if (list != null && list.size() > 0) {
			emp = list.get(0);
		}
		// 返回
		return emp;
	}
	
	/**
	 * 根据工号获取上级部门信息,用户是否是职能研发中心，1：是，0：否
	 */
	@Override
	public int judgeOrgIdByUserId(String userId) {
		// 空判断
		if(StringUtils.isNotEmpty(userId)){
			// 获取数据
			String orgId = cIDDao.queryOrgIdByUserId(userId);
			// 是否是职能研发中心
			if(orgId != null && "473958".equals(orgId)){
				// 返回
				return 1;
			}
		}
		// 返回
		return 0;
	}

	public void setCIDDao(ICIDDao cIDDao) {
		this.cIDDao = cIDDao;
	}

	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public void setServerHostPort(String serverHostPort) {
		this.serverHostPort = serverHostPort;
	}

	public void setEncryptKey(String encryptKey) {
		this.encryptKey = encryptKey;
	}

	public void setCidBaseDir(String cidBaseDir) {
		this.cidBaseDir = cidBaseDir;
	}

}
