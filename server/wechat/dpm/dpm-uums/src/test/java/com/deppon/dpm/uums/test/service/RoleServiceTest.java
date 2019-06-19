package com.deppon.dpm.uums.test.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.deppon.dpm.tongxunlu.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.dpm.uums.server.domain.RoleEntity;
import com.deppon.dpm.uums.server.service.IRoleService;
import com.deppon.dpm.uums.test.BaseTestCase;
import com.deppon.dpm.uums.test.cache.UserCache;
import com.deppon.foss.framework.cache.CacheManager;
import com.deppon.foss.framework.cache.storage.LocalCacheStorage;
import com.deppon.foss.framework.entity.IUser;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.context.UserContext;

public class RoleServiceTest extends BaseTestCase{
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void testInsertOrUpdateOne(){
		OrganizationEntity orgEntity = new OrganizationEntity();
		orgEntity.setOrgCode("W0101");
		orgEntity.setOrgName("IT开发部");
		
		UserEntity user = new UserEntity();
		user.setOrganization(orgEntity);
		user.setEmpCode("027429");
		user.setEmpName("文志勇");
		UserContext.setCurrentUser(user);
		
		RoleEntity entity = new RoleEntity();
		entity.setId("0342a52e-0fb9-4230-8655-4a558edd6957");
		entity.setName("总监1");
		entity.setCode("DPM005");
		entity.setNotes("总监");
		entity.setCreateDate(new Date());
		entity.setModifyDate(new Date());
		entity.setActive("N");
		entity.setVersionNo(1L);
		entity.setUUID("e68cd89f-a20f-4b87-ad8b-e0b11b55d059");
		
		try {
			LocalCacheStorage<String,IUser> cacheStorage = new LocalCacheStorage<String,IUser>();
			UserCache cache = new UserCache();
			cache.setCacheStorage(cacheStorage);
			CacheManager.getInstance().registerCacheProvider(cache);
		
			String str = roleService.insertOrUpdateOne(entity);
			System.out.println(str);
			
			cache.destroy();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//将Active改回Y，方便后面测试
		jdbcTemplate.execute("update app.t_app_role set ACTIVE = 'Y' where id = '0342a52e-0fb9-4230-8655-4a558edd6957'");
	}
	
	@Test
	public void testSelectlimit(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", 1);
		map.put("limit", 10);
		List<RoleEntity> list = roleService.selectlimit(map);
		System.out.println(list.size());
	}
	
	@Test
	public void testSelectlimitCount(){
		Map<String,Object> map = new HashMap<String,Object>();
		Long count = roleService.selectlimitCount(map);
		System.out.println(count);
	}
	
	@Test
	public void testDeleteRole(){
		OrganizationEntity orgEntity = new OrganizationEntity();
		orgEntity.setOrgCode("W0101");
		orgEntity.setOrgName("IT开发部");
		
		UserEntity user = new UserEntity();
		user.setOrganization(orgEntity);
		user.setEmpCode("027429");
		user.setEmpName("文志勇");
		UserContext.setCurrentUser(user);
		
		String id = "";
		int i = roleService.deleteRole(id);
		System.out.println(i);
	}

}
