package com.deppon.dpm.module.management.server.service;
/**
 * 包裹领取通知接口.
 * @author 曹嵩
 * <p>时间：2015年9月10日</p>
 * 1.根据包裹唯一标示找到状态parcelState，如果为0通知用户领取包裹.<br>
 * 2.如果状态为1，提示领取成功<br>
 * 3.如果状态为2，提示已拒收.<br>
 * 4.如果状态为3，提示已注销.<br>
 * 5.如果状态为4，提示为催领.<br>
 */
public interface ISendReceiveRoomMessNotificationService {
   /**
    * 判断推送消息方法.
    * @param packageId 包裹唯一标示.
    */
    public void judgmentMessage(Long packageId);
    
    /**
     * 给代领人发送信息.
     * @param userNo 代领人工号
     * @param userName 代领人姓名
     * @param packageId 包裹唯一标示
     */
    public void generationLeaderMessage(String userNo,String userName,Long packageId);
    /**
     * @param userNo 代领人工号
     * @param content 消息通知内容
     * @param parcelState 包裹状态
     * @param statusTime 状态更新时间
     */
    public void saveMesssageToDB(String userNo,String content,int parcelState,String statusTime);
    /**
     * 催领消息单独入库
     * @param packageId
     */
    public void  saveMesssageToDBCorporal(Long packageId);
}
