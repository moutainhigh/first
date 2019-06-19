package com.deppon.dpm.module.fssc.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.deppon.dpm.module.fssc.server.dao.IThingBeforeApplyDao;
import com.deppon.dpm.module.fssc.server.service.IThingBeforeApplyService;
import com.deppon.dpm.module.fssc.shared.domain.DetailInfoEntity;
import com.deppon.dpm.module.fssc.shared.domain.FlightOrderInfoEntity;
import com.deppon.dpm.module.fssc.shared.domain.HotelOrderInfoEntity;
import com.deppon.dpm.module.fssc.shared.domain.PriorApplicationEntity;
import com.deppon.dpm.module.fssc.shared.domain.TheoneObjEntity;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 查询事前申请的Services层
 * 
 * @author JFeng
 * 
 */
public class ThingBeforeApplyServiceImpl implements IThingBeforeApplyService {

	private IThingBeforeApplyDao iThingBeforeApplyDao;

	private TheoneObjEntity theoneobjentity;

	public TheoneObjEntity getTheoneobjentity() {
		return theoneobjentity;
	}

	public void setTheoneobjentity(TheoneObjEntity theoneobjentity) {
		this.theoneobjentity = theoneobjentity;
	}

	public IThingBeforeApplyDao getiThingBeforeApplyDao() {
		return iThingBeforeApplyDao;
	}

	public void setiThingBeforeApplyDao(
			IThingBeforeApplyDao iThingBeforeApplyDao) {
		this.iThingBeforeApplyDao = iThingBeforeApplyDao;
	}

	/**
	 * 查询事前申请单列表信息
	 * 
	 * @throws Exception
	 */
	@Override
	public List<TheoneObjEntity> queryAllInfo(String applyEmpNo)
			throws BusinessException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		// 创建订单信息列表
		List<TheoneObjEntity> orderlist = iThingBeforeApplyDao
				.queryAllInfo(applyEmpNo);
		List<TheoneObjEntity> theoneList = new ArrayList<TheoneObjEntity>();
		String newC = "";
		String oldC = "";
		TheoneObjEntity theone = new TheoneObjEntity();
		// int size = orderlist.size();
		if (orderlist != null && orderlist.size() > 0) {
			for (int i = 0; i < orderlist.size(); i++) {

				theone = orderlist.get(i);
				String startDate = sdf.format(orderlist.get(i)
						.getBizOccurStartDate());
				String endDate = sdf.format(orderlist.get(i)
						.getBizOccurEndDate());
                theone.setStartDate(startDate);
                theone.setEndDate(endDate);
				if (i == 0) {
					newC = orderlist.get(i).getClaimNo();
					oldC = orderlist.get(i).getClaimNo();
				} else {
					newC = orderlist.get(i).getClaimNo();
				}
				if (newC.equals(oldC)) {
					// theone = orderlist.get(i);
					/*
					 * theone.setStartDate(sdf.format(orderlist.get(i)
					 * .getBizOccurStartDate()));//
					 * theone.setEndDate(sdf.format(orderlist.get(i)
					 * .getBizOccurEndDate()));//
					 */
					//theone.setStartDate(startDate);
					//theone.setEndDate(endDate);
					theoneList.add(theone);// 保存事前申请单到集合
				} else {
					// 操作
					oldC = orderlist.get(i - 1).getClaimNo();
					// theone = orderlist.get(i);
					/*
					 * theone.setStartDate(sdf.format(orderlist.get(i)
					 * .getBizOccurStartDate()));//
					 * theone.setEndDate(sdf.format(orderlist.get(i)
					 * .getBizOccurEndDate()));//
					 */
					//theone.setStartDate(startDate);
					//theone.setEndDate(endDate);
					theoneList.add(theone);// 保存事前申请单到集合
				}
				if ( i == orderlist.size() - 1) {
					theoneList.add(theone);
					
					/*	if (newC.equals(oldC)) {// 如果相等，则保存最后一个到集合
							// 操作
							// theone = orderlist.get(i);
							
							 * theone.setStartDate(sdf.format(orderlist.get(i)
							 * .getBizOccurStartDate()));//
							 * theone.setEndDate(sdf.format(orderlist.get(i)
							 * .getBizOccurEndDate()));//
							 
							//theone.setStartDate(startDate);
							//theone.setEndDate(endDate);
							theoneList.add(theone);
						} else {// 如果不属于同一事前申请单，则说明最后一个事前申请单只有一个订单，那么直接保存到集合
							// 操作
							// theone = orderlist.get(i);
							
							 * theone.setStartDate(sdf.format(orderlist.get(i)
							 * .getBizOccurStartDate()));
							 * theone.setEndDate(sdf.format(orderlist.get(i)
							 * .getBizOccurEndDate()));
							 
							//theone.setStartDate(startDate);
							//theone.setEndDate(endDate);
							theoneList.add(theone);
						}*/
					}
				
			}

		}

		/*
		 * List<Long> startList=new ArrayList<Long>(); List<Long> endList=new
		 * ArrayList<Long>(); //List<Long> orderStates=new ArrayList<Long>();
		 * StringBuffer destination=new StringBuffer(); int
		 * size=orderlist.size(); for(int i=0; i < size;i++) { if (i == 0) {
		 * newC = orderlist.get(i).getClaimNo(); oldC =
		 * orderlist.get(i).getClaimNo(); } else { newC =
		 * orderlist.get(i).getClaimNo(); }
		 * 
		 * if(newC.equals(oldC)) {//如果上一个和下一个相等(属于同一个事前申请单)，则保存开始时间和结束时间及目的地 //
		 * 操作 //startList.add(orderlist.get(i).getBizOccurStartDate());
		 * //endList.add(orderlist.get(i).getBizOccurEndDate());
		 * startList.add(orderlist.get(i).getBizOccurStartDate().getTime());
		 * endList.add(orderlist.get(i).getBizOccurEndDate().getTime());
		 * //orderStates.add(Long.parseLong(orderlist.get(i).getOrderState()));
		 * destination.append(orderlist.get(i).getDestination()+"、");
		 * 
		 * } else {//如果上一个和下一个不属于同一个事前申请单，则保存上一个事前申请单到list TheoneObjEntity
		 * theone=new TheoneObjEntity(); // 操作
		 * oldC=orderlist.get(i-1).getClaimNo(); theone=orderlist.get(i-1);
		 * theone
		 * .setStartDate(sdf.format(orderlist.get(i).getBizOccurStartDate()));//
		 * theone
		 * .setEndDate(sdf.format(orderlist.get(i).getBizOccurEndDate()));//
		 * //theone.setOrderState(compareState(endList,orderStates));
		 * 
		 * 
		 * theone.setDestination(destination.substring(0,
		 * destination.length()-1));//目的地 theoneList.add(theone);//保存事前申请单到集合 }
		 * if (i==size-1) {//如果是最后一个订单信息，则判断最后一个和上一个是否相等 if(newC.equals(oldC))
		 * {//如果相等，则保存最后一个到集合 // 操作
		 * //startList.add(orderlist.get(i).getBizOccurStartDate());
		 * //endList.add(orderlist.get(i).getBizOccurEndDate());
		 * startList.add(orderlist.get(i).getBizOccurStartDate().getTime());
		 * endList.add(orderlist.get(i).getBizOccurEndDate().getTime());
		 * destination.append(orderlist.get(i).getDestination()+"、");
		 * TheoneObjEntity theone=new TheoneObjEntity(); // 操作
		 * theone=orderlist.get(i);
		 * theone.setStartDate(sdf.format(orderlist.get(
		 * i).getBizOccurStartDate()));//
		 * theone.setEndDate(sdf.format(orderlist.
		 * get(i).getBizOccurEndDate()));//
		 * //theone.setOrderState(compareState(endList,orderStates));
		 * theone.setDestination(destination.substring(0,
		 * destination.length()-1)); theoneList.add(theone); } else
		 * {//如果不属于同一事前申请单，则说明最后一个事前申请单只有一个订单，那么直接保存到集合 TheoneObjEntity
		 * theone=new TheoneObjEntity(); // 操作 theone=orderlist.get(i);
		 * //theone.setBizOccurStartDate(CompareDate(1, startList));
		 * theone.setStartDate
		 * (sdf.format(orderlist.get(i).getBizOccurStartDate()));
		 * theone.setEndDate(sdf.format(orderlist.get(i).getBizOccurEndDate()));
		 * //theone.setOrderState(compareState(endList,orderStates));
		 * //theone.setBizOccurEndDate(CompareDate(2, endList));
		 * //theone.setDestination(destination.substring(0,
		 * destination.length()-1)); theoneList.add(theone); } }
		 * 
		 * }
		 */
		return theoneList;
	}

	@SuppressWarnings("unused")
	private String compareState(List<Long> endList, List<Long> orderList) {
		int flag = 1;
		if (endList.size() > 0) {
			long times = System.currentTimeMillis();
			for (Long endTime : endList) {
				if (endTime < times) {
					flag = 0;
					continue;
				}
			}
		} else if (orderList.size() > 0) {
			for (Long order : orderList) {
				if (order > 0) {
					flag = 0;
					continue;
				}
			}
		}
		return String.valueOf(flag);
	}

	/**
	 * 比较时间的大小
	 * 
	 * @param type
	 * @param dateList
	 * @return
	 * @throws ParseException
	 */
	/*
	 * private static String CompareDate(int type,List<Long> dateList) throws
	 * ParseException{ Date date; Object[] objs = dateList.toArray();
	 * Arrays.sort(objs); SimpleDateFormat sdf; if (type==1) {//取最小时间 date= new
	 * Date(Long.parseLong(objs[0].toString())); sdf = new
	 * SimpleDateFormat("yyyy.MM.dd"); } else{ // if(objs.length>1){ // date=
	 * new Date(Long.parseLong(objs[objs.length-1].toString())); // }
	 * System.out.println(objs.length); sdf = new SimpleDateFormat("MM.dd");
	 * date= new Date(Long.parseLong(objs[objs.length-1].toString())); } return
	 * sdf.format(date); }
	 */

	/**
	 * 根据单据编号查询出所属的详细信息
	 */
	@Override
	public PriorApplicationEntity queryXiangxiInfo(String claimNo) {
		// this.selectxiangxiInfo(claimNo);
		// 根据单据编号查询出事前申请单的列表
		List<PriorApplicationEntity> paeList = iThingBeforeApplyDao
				.queryTravelAdvanceApply(claimNo);
		// 定义一个要返回的实体对象
		PriorApplicationEntity pae = paeList.get(0);
		SimpleDateFormat sdfApplyDate = new SimpleDateFormat("yyyy.MM.dd");
		pae.setApplyDateStr(sdfApplyDate.format(pae.getApplyDate()));
		// 根据单据编号查询出明细的List
		List<DetailInfoEntity> detaiOnelList = iThingBeforeApplyDao
				.queryTravelApplyDetail(pae.getClaimNo());

		// NEW一个明细的List,用来保存到实体对象中
		List<DetailInfoEntity> detaiTwolList = new ArrayList<DetailInfoEntity>();
		String claimLineId = null;
		List<FlightOrderInfoEntity> flightList = null;
		List<HotelOrderInfoEntity> hotelList = null;
		for (DetailInfoEntity detail : detaiOnelList) {
			String scNo = detail.getScNo();
			claimLineId = detail.getClaimLineId();
			// if (scName.equals("飞机")) {
			// flightList=thingbeforeapplydao.queryTravelFlightOrder(claimLineId);
			// }
			// else{
			// hotelList=thingbeforeapplydao.queryTravelHotelOrder(claimLineId);
			// }
			// //将航班和酒店的信息给明细表
			// detail.setFlightOrderInfoEntity(flightList);
			// detail.setHotelOrderInfoList(hotelList);
			// detaiTwolList.add(detail);
			if (scNo.equals("104002003")) {

				flightList = iThingBeforeApplyDao
						.queryTravelFlightOrder(claimLineId);
				DetailInfoEntity cloneDetail = null;
				for (FlightOrderInfoEntity flight : flightList) {
					// 将航班和酒店的信息给明细表
					cloneDetail = new DetailInfoEntity();// JsonUtil.jsonToEntity(JsonUtil.beanToJsonString(detail),
															// DetailInfoEntity.class);
					// cloneDetail = detail;
					BeanUtils.copyProperties(detail, cloneDetail);
					cloneDetail.setFlightOrderInfo(flight);
					/*
					 * DetailInfoEntity de=new DetailInfoEntity(); de=detail;
					 */
					// 将开始时间get转换时间格式后，再set进去
					Date date = flight.getBizOccurStartDate();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
					flight.setBizStartTime(sdf.format(date));
					// 将结束时间get转换时间格式后，再set进去
					Date datetwo = flight.getBizOccurEndDate();
					SimpleDateFormat sdftwo = new SimpleDateFormat("yyyy.MM.dd");
					flight.setBizEndTime(sdftwo.format(datetwo));
					detaiTwolList.add(cloneDetail);
					cloneDetail = null;
				}

			} else {
				hotelList = iThingBeforeApplyDao
						.queryTravelHotelOrder(claimLineId);
				DetailInfoEntity cloneDetail1 = null;
				for (HotelOrderInfoEntity hotel : hotelList) {
					// 将酒店的信息给明细表
					cloneDetail1 = new DetailInfoEntity();
					BeanUtils.copyProperties(detail, cloneDetail1);
					cloneDetail1.setHotelOrderInfo(hotel);
					// 将开始时间get后转换格式，然后set进去
					Date date = hotel.getBizOccurStartDate();
					SimpleDateFormat smf = new SimpleDateFormat("yyyy.MM.dd");
					hotel.setBizStartTime(smf.format(date));
					// 将结束时间get后转换格式，然后set进去
					Date datetwo = hotel.getBizOccurEndDate();
					SimpleDateFormat smftwo = new SimpleDateFormat("yyyy.MM.dd");
					hotel.setBizEndTime(smftwo.format(datetwo));
					detaiTwolList.add(cloneDetail1);
					cloneDetail1 = null;
				}
			}

		}

		pae.setDetailInfoList(detaiTwolList);
		return pae;
	}
}
