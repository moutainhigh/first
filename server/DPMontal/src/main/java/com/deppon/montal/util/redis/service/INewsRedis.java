package com.deppon.montal.util.redis.service;

import java.util.List;

import com.deppon.montal.model.OaRollNews;

public interface INewsRedis {

	//获取前N条最新新闻纪录
	public List<OaRollNews> getTopNews(String userId);
}
