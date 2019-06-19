package com.deppon.montal.util.redis.service.impl;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import com.deppon.montal.conf.domain.DictEntry;
import com.deppon.montal.util.StringUtil;
import com.deppon.montal.util.redis.util.JedisConstant;
import com.deppon.montal.util.redis.util.JedisUtil;

/**
 * <pre>
 * 描述： 1、初始化数据字典到redis中
 * 		 2、将数据库中的数据字典数据与redis保持同步
 * </pre>
 * 
 * @author xu.shang
 * 
 */
public class InitDictEntry {
	private static Logger logger = null;

	static {
		logger = Logger.getLogger(InitDictEntry.class);
	}

	/**
	 * 初始化所有的数据字典，放到redis缓存中
	 */
	public static void initAllDictEntry2Redis() {
		logger.info("InitDictEntry------------------------------->initAllDictEntry2Redis begin");
		Jedis jedis = JedisUtil.createJedis();
		int i = 1;
		try {
			List<DictEntry> dictEntryList = QueryUtil.queryAllDictEntry();
			if (dictEntryList != null && dictEntryList.size() > 0) {
				Pipeline p = jedis.pipelined();
				for (DictEntry dictEntry : dictEntryList) {
					Map<String, String> map = new HashMap<String, String>();
					String dicttypeid = dictEntry.getDicttypeid();
					String dictid = dictEntry.getDictid();
					map.put("dicttypeid", dicttypeid);
					map.put("dictid", dictid);
					map.put("dictname", dictEntry.getDictname());
					map.put("rank", String.valueOf(dictEntry.getRank()));
					map.put("seqno", dictEntry.getSeqno() == null ? "" : dictEntry.getSeqno());
					map.put("sortno",String.valueOf(dictEntry.getSortno()));
					p.hmset(JedisConstant.DPMONTAL_DPMON_DICYENTRY + dicttypeid
							+ ":" + dictid, map);
					i++;
				}
				p.sync();
			}
		} catch (Exception ex) {
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[InitDictEntry initAllDictEntry2Redis]"
					+ ex.getMessage());
		} finally {
			// return the Jedis instance to the pool
			logger.info("InitDictEntry------>initAllDictEntry2Redis()----->共同步数据字典：" + i + "条");
			JedisUtil.releaseJedis(jedis);
		}
		logger.info("------------------------------->initAllDictEntry2Redis over");
	}

	/**
	 * 同步数据字典信息
	 */
	public static void synDictEntry() {
		logger.info("开始同步redis缓存中的eos_dict_entry和数据库中的eos_dict_entry一一对应的关系");
		Jedis j = JedisUtil.createJedis();
		List<String> lst = new ArrayList<String>();
		try {
			List<DictEntry> dictEntryList = QueryUtil.queryAllDictEntry();
			if (dictEntryList != null && dictEntryList.size() > 0) {
				for (DictEntry dictEntry : dictEntryList) {
					lst.add(dictEntry.getDicttypeid() + ":"
							+ dictEntry.getDictid());
				}
			}
			Set<String> set = j.keys(JedisConstant.DPMONTAL_DPMON_DICYENTRY
					+ "*");
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				// dpmontal:dictentry:dicttypeid:dictid
				String dictKey = it.next();
				dictKey = dictKey
						.substring(JedisConstant.DPMONTAL_DPMON_DICYENTRY.length());
				if (!lst.contains(dictKey)) {
					logger.info("redis缓存中被删除的数据字典数据是：" + dictKey);
					j.del(JedisConstant.DPMONTAL_DPMON_DICYENTRY + dictKey);
				}
			}
		} catch (Exception ex) {
			JedisUtil.returnBrokenResource(j);
			logger.info("[InitDictEntry synDictEntry]" + ex.getMessage());
			ex.printStackTrace();
		} finally {
			JedisUtil.releaseJedis(j);
		}
	}

	/**
	 * @TODO 根据传入的业务字典类型id和业务字典id获取缓存中所有的数据字典信息
	 * @param dicttypeid
	 *            业务字典类型ID
	 * @param dictid
	 *            业务字典ID
	 */
	public static List<DictEntry> getDictEntryFromRedis(String dicttypeid,
			String dictid) {
		Jedis jedis = JedisUtil.createJedis();
		List<DictEntry> list = new ArrayList<DictEntry>();
		DictEntry tp = null;
		try {
			String redisKey = JedisConstant.DPMONTAL_DPMON_DICYENTRY;
			redisKey = redisKey
					+ (!StringUtil.isEmptyOrNull(dicttypeid) ? (!StringUtil
							.isEmptyOrNull(dictid) ? dicttypeid + ":" + dictid
							: dicttypeid + ":*") : "*");
			Set<String> set = jedis.keys(redisKey);
			for (String dictKey : set) {
				logger.info("【InitDictEntry---->getDictEntryFromRedis--->获取所有的数据字典数据】:"
						+ JedisConstant.DPMONTAL_DPMON_DICYENTRY + dictKey);
				tp = new DictEntry();
				tp.setDicttypeid(jedis.hget(dictKey, "dicttypeid"));
				tp.setDictid(jedis.hget(dictKey, "dictid"));
				tp.setDictname(jedis.hget(dictKey, "dictname"));
				tp.setRank(Integer.parseInt(jedis.hget(dictKey, "rank")));
				tp.setSeqno(jedis.hget(dictKey, "seqno"));
				tp.setSortno(Integer.parseInt(jedis.hget(dictKey, "sortno")));
				list.add(tp);
				 
			}
			 Collections.sort(list, new Comparator<DictEntry>() {
		            public int compare(DictEntry arg0, DictEntry arg1) {
		                return arg0.getDictid().compareTo(arg1.getDictid());
		            }
		        });
		} catch (Exception ex) {
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[InitDictEntry getDictEntryFromRedis]"
					+ ex.getMessage());
			ex.printStackTrace();
		} finally {
			JedisUtil.releaseJedis(jedis);
		}
		return list;
	}
}
