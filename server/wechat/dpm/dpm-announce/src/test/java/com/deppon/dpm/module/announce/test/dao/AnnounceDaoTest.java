/*package com.deppon.dpm.module.announce.test.dao;

//import java.util.Date;
//import java.util.List;

//import junit.framework.TestCase;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.deppon.dpm.module.announce.server.dao.IAnnounceDao;
//import com.deppon.dpm.module.announce.shared.domain.AnnounceEntity;
//import com.deppon.dpm.module.announce.shared.util.UUIDUtils;
//import com.deppon.dpm.module.announce.shared.vo.AnnounceVo;
import com.deppon.dpm.module.announce.test.BaseTestCase;

public class AnnounceDaoTest extends BaseTestCase{
//	@Autowired
//	private IAnnounceDao announceDao;
	
	@Test
	public void insert(){
		AnnounceEntity entity = new AnnounceEntity();
		String id = UUIDUtils.getUUID();
		Date createDate = new Date();
		entity.setId(id);
		entity.setType("NEWS");
		//标题
		entity.setTitle("新增新闻标题");
	    //发布时间
		entity.setPublishTime(createDate);
	    //正文内容
		entity.setContent("哈哈哈哈哈");
	    //收藏数
		entity.setCollectionNum(1);
	    //阅读数
		entity.setReadNum(2);
	    //点赞数
		entity.setPraiseNum(3);
	    //附件路径
		entity.setAttachmentPath("/web/upload");
	    //创建人工号
		entity.setCreateUserCode("045925");
	    //创建人
		entity.setCreateUserName("杨彬");
	    //创建时间
		entity.setCreateTime(createDate);
		int row = announceDao.insert(entity);
		System.out.println(row);
	}
	
	@Test
	public void update(){
		AnnounceEntity entity = new AnnounceEntity();
		String id = "450f83ed-75e3-4eef-b042-cd4aa4d3634e";
		Date updateDate = new Date();
		entity.setId(id);
		//标题
		entity.setTitle("更改标题");
	    //发布时间
		//entity.setPublishTime(createDate);
	    //正文内容
		entity.setContent("哦哦哦哦哦哦哈哈哈哈哈");
	    //收藏数
		entity.setCollectionNum(4);
	    //阅读数
		entity.setReadNum(6);
	    //点赞数
		entity.setPraiseNum(8);
	    //附件路径
		entity.setAttachmentPath("/web/upload00");
	    //创建人工号
		entity.setCreateUserCode("045925");
	    //创建人
		entity.setCreateUserName("杨彬");
	    //创建时间
		//entity.setCreateTime(createDate);
		entity.setModifyUserCode("111111");
		entity.setModifyUserName("测试");
		entity.setModifyTime(updateDate);
		int row = announceDao.update(entity);
		System.out.println(row);
	}
	
	@Test
	public void delete(){
		AnnounceEntity entity = new AnnounceEntity();
		String id = "32ca6676-f04d-478e-af28-cbc3b626a7b3";
		entity.setId(id);
		int row = announceDao.delete(id);
		System.out.println(row);
	}
	
	@Test
	public void queryCommonAll(){
		int limit=10,start=0;
		AnnounceVo queryParam = new AnnounceVo();
		queryParam.setStartTime(new Date());
		queryParam.setEndTime(new Date());
		List<AnnounceEntity> list = announceDao.queryCommonAll(limit,start,queryParam);
		System.out.println(list.size());
	}
	
	@Test
	public void queryCommonCount(){
		AnnounceVo queryParam = new AnnounceVo();
		Long count = announceDao.queryCommonCount(queryParam);
		System.out.println(count);
	}

}
*/