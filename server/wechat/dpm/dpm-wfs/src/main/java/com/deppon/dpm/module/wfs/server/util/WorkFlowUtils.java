package com.deppon.dpm.module.wfs.server.util;

import java.util.ArrayList;
import java.util.List;

import com.deppon.dpm.module.news.server.service.ITpushNewsService;
import com.deppon.dpm.module.wfs.server.service.IApprovePeopleQueryService;
import com.deppon.dpm.module.wfs.server.util.monitor.InfoSend;
import com.deppon.dpm.module.wfs.shared.domain.ApprovePeopleInfo;
import com.deppon.dpm.module.wfs.shared.domain.TaxInfoEntity;
import com.deppon.dpm.module.wfs.shared.domain.dlsp.TaxDlspEntity;
import com.deppon.dpm.module.wfs.shared.domain.dwfs.TaxDwfsEntity;
import com.deppon.dpm.module.wfs.shared.domain.wdgh.TaxWdghEntity;

public class WorkFlowUtils {
    private static List<String> pushWorkFlowList = new ArrayList<String>();
    public static String siteRentFlowtype = "com.deppon.bpms.module.wdgh.bpsdesign.operate.siteRent";
    public static String storeRentFlowtype = "com.deppon.bpms.module.wfs.bpsdesign.contract.storeRent";
    public static String purchaseContractFlowtype = "com.deppon.bpms.module.lsp.bpsdesign.purchase.purchaseContract";
    public static String contractApplyFlowtype = "com.deppon.bpms.module.wfs.bpsdesign.administrationLegal.contractApply";
    static {
        // 场地租赁/转租合同
        pushWorkFlowList.add(siteRentFlowtype);
        // 商铺租赁合同申请
        pushWorkFlowList.add(storeRentFlowtype);
        // 采购合同
        pushWorkFlowList.add(purchaseContractFlowtype);
        // 合同签订申请
        pushWorkFlowList.add(contractApplyFlowtype);
    }

    /**
     * 取出所有的用户ID，每个用户ID之间用逗号隔开
     * 
     * @param users
     * @return
     */
    public static String getApproveUsers(List<ApprovePeopleInfo> users) {
        if (users == null || users.isEmpty()) {
            return "";
        } else {
            StringBuffer userStrs = new StringBuffer();
            int size = users.size();
            for (int i = 0; i < size; i++) {

                if (i == 0) {
                    userStrs.append(users.get(i).getParticipantId());
                } else {
                    userStrs.append(",");
                    userStrs.append(users.get(i).getParticipantId());
                }
            }
            return userStrs.toString();
        }
    }

    /**
     * 判断工作流是否是和税务有关的工作流 目前只有 4条工作流和税务有关
     * 
     * @param flowtype
     * @return
     */
    public static boolean checkIsTaxes(String flowtype) {
        return pushWorkFlowList.contains(flowtype);
    }

    /**
     * 
     * @param approveService
     * @param tpushNewsService
     * @param processinstid
     */
    public static void workflowNextAppovePush(
            IApprovePeopleQueryService approveService,
            ITpushNewsService tpushNewsService, String processinstid) {
        InfoSend sendInfo = new InfoSend();
        sendInfo.approveService = approveService;
        sendInfo.tpushNewsService = tpushNewsService;
        sendInfo.processinstid = processinstid;
        new Thread(sendInfo).start();
    }

    /**
     * LSP本地保存税务信息对象Copy
     */
    public static void copyDlspTaxEntity(TaxDlspEntity from, TaxInfoEntity to) {
        to.setStampDuty(from.getIsPayTax());
        to.setContractAmount(from.getContactAmount());
        to.setTaxItemName(from.getTaxItem());
        to.setTaxRate(from.getRate());
        to.setPaymentAmount(from.getPayAmount());
        to.setDeclareDepartmentName(from.getApplyDept());
        to.setPaymentMethod(from.getTaxType());
    }

    /**
     * wdgh本地保存税务信息对象Copy
     */
    public static void copyWdghTaxEntity(TaxWdghEntity from, TaxInfoEntity to) {
        to.setStampDuty(from.getStampDuty());
        to.setContractAmount(from.getContractAmount());
        to.setTaxItemName(from.getTaxItemName());
        to.setTaxRate(from.getTaxRate());
        to.setPaymentAmount(from.getPaymentAmount());
        to.setDeclareDepartmentName(from.getDeclareDepartmentName());
        to.setPaymentMethod(from.getPaymentMethod());
    }

    /**
     * Dwfs本地保存税务信息对象Copy
     */
    public static void copyDwfsTaxEntity(TaxDwfsEntity from, TaxInfoEntity to) {
        to.setStampDuty(from.getIsStampDuty());
        to.setContractAmount(from.getAccountContractAmount());
        to.setTaxItemName(from.getTaxItem());
        to.setTaxRate(from.getTaxRate());
        to.setPaymentAmount(from.getPaymentAmount());
        to.setDeclareDepartmentName(from.getSignDepartment());
        to.setPaymentMethod(from.getTaxMethod());
        to.setBusino(from.getBusino());
    }
}
