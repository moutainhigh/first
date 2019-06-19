package com.deppon.dpm.uums.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.tongxunlu.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.dpm.uums.server.domain.ResourceEntity;
import com.deppon.dpm.uums.server.service.IResourceService;
import com.deppon.dpm.uums.test.BaseTestCase;
import com.deppon.dpm.uums.test.cache.UserCache;
import com.deppon.foss.framework.cache.CacheManager;
import com.deppon.foss.framework.cache.storage.LocalCacheStorage;
import com.deppon.foss.framework.entity.IUser;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.context.UserContext;

public class ResourceServiceTest extends BaseTestCase{
	
	@Autowired
	private IResourceService resourceService;
	
	@Test
	public void testGetDirectChildResourceByCode(){
		String parentCode = "a1507052";
		List<ResourceEntity> list = resourceService.getDirectChildResourceByCode(parentCode);
		System.out.println(list.size());
	}
	
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
		
		ResourceEntity resourceEntity = new ResourceEntity();
		resourceEntity.setId("165c6c08-f616-4a94-9f0b-19df0a420ce9");
		resourceEntity.setName("测试移动项目管理工具");
		resourceEntity.setCode("DPMDPMMM");
		
		
		try {
			LocalCacheStorage<String,IUser> cacheStorage = new LocalCacheStorage<String,IUser>();
			UserCache cache = new UserCache();
			cache.setCacheStorage(cacheStorage);
			CacheManager.getInstance().registerCacheProvider(cache);
		
			int i = resourceService.insertOrUpdateOne(resourceEntity);
			System.out.println(i);
			
			cache.destroy();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testSelectlimit(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", 1);
		map.put("limit", 20);
		List<ResourceEntity> list = resourceService.selectlimit(map);
		System.out.println(list.size());
	}
	
	@Test
	public void testSelectlimitCount(){
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println(resourceService.selectlimitCount(map));
	}
	
	@Test
	public void testDeleteFuncrionResource(){
		OrganizationEntity orgEntity = new OrganizationEntity();
		orgEntity.setOrgCode("W0101");
		orgEntity.setOrgName("IT开发部");
		
		UserEntity user = new UserEntity();
		user.setOrganization(orgEntity);
		user.setEmpCode("027429");
		user.setEmpName("文志勇");
		UserContext.setCurrentUser(user);
		
		int i = resourceService.deleteFuncrionResource("165c6c08-f616-4a94-9f0b-19df0a420ce9");
		System.out.println(i);
	}

}
