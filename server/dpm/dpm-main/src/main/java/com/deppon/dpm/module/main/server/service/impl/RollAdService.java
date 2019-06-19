package com.deppon.dpm.module.main.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.deppon.dpm.module.main.server.dao.IRollAdDao;
import com.deppon.dpm.module.main.server.service.IRollAdService;
import com.deppon.dpm.module.main.shared.domain.ImageUrl;
import com.deppon.dpm.module.main.shared.domain.RollAddDetailEntity;
import com.deppon.dpm.module.main.shared.domain.VideoUrl;

public class RollAdService implements IRollAdService {

	private IRollAdDao rollAdDao;

	// private String webUrl;

	/**
	 * 上传广告
	 */
	@Override
	public int upload(RollAddDetailEntity rollAdd) {
		return rollAdDao.upload(rollAdd);
	}

	/**
	 * 获取图片详情
	 */
	@Override
	public RollAddDetailEntity getRollAdDetail(int id) {
		RollAddDetailEntity rollAdDetail = rollAdDao.getRollAdDetail(id);
		RollAddDetailEntity rollAdDetails = deal(rollAdDetail);
		return rollAdDetails;

	}

	/**
	 * 判断时间是不是今天
	 * 
	 * @param date
	 * @return 是返回true，不是返回false
	 */
	private static boolean isNow(Date date) {
		// 当前时间
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		// 获取今天的日期
		String nowDay = sf.format(now);

		// 对比的时间
		String day = sf.format(date);

		return day.equals(nowDay);

	}

	// 处理图片视频地址
	public RollAddDetailEntity deal(RollAddDetailEntity rollAdDetail) {
		// 正文内容图片地址
		String contentImage = rollAdDetail.getContentImage();
		List<ImageUrl> contentImageList = JSONArray.parseArray(contentImage,
				ImageUrl.class);
		rollAdDetail.setContentImages(contentImageList);
		// 视频缩约图图片地址
		String videoImage = rollAdDetail.getVideoImage();
		List<ImageUrl> videoImageList = JSONArray.parseArray(videoImage,
				ImageUrl.class);
		rollAdDetail.setVideoImages(videoImageList);
		// 视频地址
		String videoUrl = rollAdDetail.getVideoUrl();
		List<VideoUrl> videoUrlList = JSONArray.parseArray(videoUrl,
				VideoUrl.class);
		rollAdDetail.setVideosUrls(videoUrlList);
		// 处理实体显示时间
		if (!isNow(rollAdDetail.getCreateTime())) {
			String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(rollAdDetail.getCreateTime());
			rollAdDetail.setStartTime(format);
		} else {
			rollAdDetail.setStartTime(new SimpleDateFormat("HH:mm")
					.format(rollAdDetail.getCreateTime()));
		}
		return rollAdDetail;
	}

	/**
	 * 获取滚动广告列表
	 */
	@Override
	public List<RollAddDetailEntity> getRollAdList(String appType) {
		List<RollAddDetailEntity> rollAdList = rollAdDao.getRollAdList(appType);
		List<RollAddDetailEntity> list = new ArrayList<RollAddDetailEntity>();
		// 获取滚动广告列表
		if (null != rollAdList && rollAdList.size() > 0) {
			for (RollAddDetailEntity rollAddDetailEntity : rollAdList) {
				RollAddDetailEntity rollAdDetails = deal(rollAddDetailEntity);
				list.add(rollAdDetails);
			}
		}

		return list;
	}

	public IRollAdDao getRollAdDao() {
		return rollAdDao;
	}

	public void setRollAdDao(IRollAdDao rollAdDao) {
		this.rollAdDao = rollAdDao;
	}

	@Override
	public int deleteRollAd(int id) {
		int count=rollAdDao.deleteRollAd(id);
		return count;
	}
    
	/**
     * 获取所有的广告图片
     * @param id
     * @return
     */
	@Override
	public List<RollAddDetailEntity> getAllRollAdList() {
		return rollAdDao.getAllRollAdList();
	}
    
	/**
     * 更新所有的广告图片
     * @param id
     * @return
     */
	@Override
	public int update(RollAddDetailEntity rollAdd) {
		// TODO Auto-generated method stub
		return rollAdDao.update(rollAdd);
	}

}
