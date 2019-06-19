
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.conf.F_Constants;
   /** 
 * @Title: SqlManager.java
 * @Package com.deppon.montal.module.notice.service 
 * @Description: (SQL语句管理类) 
 * @author 廖建雄 
 * @date 2013-2-21 下午3:51:46 
 * @version V1.0 
 */
public class SQLManager {
    

	
	//用于数据字典字段,匹配不上显示原始值
    private static String getDictNameSql(String dictType,String param){
    	
    	return " nvl((select dict.dictname "+
    	       " from EOS_DICT_ENTRY dict "+
    	       " where dict.dicttypeid = '"+dictType+"' "+
    	       " and dict.dictid = "+param+"),"+param+") ";
    }
	
    
    /**工作流代办分页查询
    public static final String QUERY_WORKFLOW_LIST_PAGEINTION = ""+
    		" select * from (select v1.*,rownum rd from (select *                           "+
    		"   from (select A.PROCESSINSTID PROCESSINSTID,                                 "+
    		"                A.APPDATE CREATETIME,                                          "+
    		"                A.DEPARTMENT DEPARTMENT,                                       "+
    		"                A.APPLER APPLER,                                               "+
    		"                B.PROCESSINSTNAME,                                             "+
    		"                B.WORKITEMID, "+
    		"                '' BUSINO, "+
    		"                B.processdefname FLOWTYPE,                                      "+
    		"                B.activitydefid,                                      "+
    		"               '"+F_Constants.DIPOA_WORKFLOW_SYSCODE+"' syscode                "+
    		"           from (select t.*, 0 witype                                          "+
    		"                   from WFWORKITEM t                                           "+
    		"                  where t.currentstate = 10                                    "+
    		"                    and t.participant = ?                                      "+
    		"                 union all                                                     "+
    		"                 select t.*, 0 witype                                          "+
    		"                   from WFWORKITEM t                                           "+
    		"                  where t.currentstate = 4                                     "+
    		"                    and ? in (select participantid                             "+
    		"                                from WFWIParticipant a                         "+
    		"                               where a.workitemid = t.workitemid)) b           "+
    		"          inner join OA_APPLYINFO a                                            "+
    		"             on a.processinstid = b.processinstid                              "+
    		"            and a.condition != 1                                               "+
    		"            and a.condition != 6                                               "+
    		"          order by A.APPDATE) s1                                                "+
    		"  where s1.PROCESSINSTID like ?  and  s1.FLOWTYPE in ("+F_Constants.ALL_WORKFLOW_TYPES+") "+
    		"  union all  "+
            "    select * "+                       
            "    from (select A.PROCESSINSTID PROCESSINSTID,  "+                                
            "            A.APPDATE CREATETIME,        "+                                      
            "            A.DEPARTMENT DEPARTMENT,   "+                                     
            "            A.APPLER APPLER,   "+                                         
            "            B.PROCESSINSTNAME,   "+  
            "            B.WORKITEMID, "+
            "            A.BUSINO, "+
            "            B.processdefname FLOWTYPE,  "+                                     
            "            B.activitydefid,                                      "+
            "            A.syscode                  "+
            "      from (select t.*, 0 witype           "+                               
            "              from WFWORKITEM@LINK_BPSDB t   "+                                        
            "             where t.currentstate = 10       "+                             
            "               and t.participant = ?   "+                            
            "            union all              "+                                       
            "            select t.*, 0 witype        "+                                  
            "              from WFWORKITEM@LINK_BPSDB t   "+                                        
            "             where t.currentstate = 4       "+                              
            "               and ? in (select participantid   "+                   
            "                           from WFWIParticipant a      "+                   
            "                          where a.workitemid = t.workitemid)) b  "+         
            "     inner join t_bpms_applyinfo@LINK_BPSDB a       "+                                     
            "        on a.processinstid = b.processinstid  "+                            
            "       and a.condition != 1   "+                                            
            "       and a.condition != 6   "+                                             
            "     ) s2  "+
            "  where s2.PROCESSINSTID like ?  and  s2.FLOWTYPE in ("+F_Constants.ALL_WORKFLOW_TYPES_LSP+","+F_Constants.ALL_WORKFLOW_TYPES_FSSC+") "+
    		"  )v1 where rownum <= ? order by v1.CREATETIME )v2 where rd>=? ";
    **/
    //工作流代办分页查询
    public static String getQueryWorkflowPageintion(boolean b){
//    	if(null == syscodes){
//			syscodes = "DIPOA,FSSC,DLSP,DWFS,ICRM,FINS,INHR";
//		}
    	String sql1 = "  where s2.BUSINO like ?";
    	String sql2 = "  where s2.PROCESSINSTID like ?";
    	String sqlBOP;
    	/**
    	 * 默认sql1 工作流系统再改为sql2
    	 * b==true 外部系统工作流，查询busino
    	 * b==false 二期工作流，查询processinstid
    	 * */
    	if (b == false) {
    		sqlBOP = sql2;
    	}else{
    		sqlBOP = sql1;
    	}
    	return  " select * from (select v1.*,rownum rd from (select * from (select *  "+
        		"   from (select A.PROCESSINSTID PROCESSINSTID,                                 "+
        		"                A.APPDATE CREATETIME,                                          "+
        		"                A.DEPARTMENT DEPARTMENT,                                       "+
        		"                A.APPLER APPLER,                                               "+
        		"                B.PROCESSINSTNAME,                                             "+
        		"                B.WORKITEMID, "+
        		"                '' BUSINO, "+
        		"                B.processdefname FLOWTYPE,                                      "+
        		"                B.activitydefid,                                      "+
        		"                B.activityinstid,                                      "+
        		"               '"+F_Constants.DIPOA_WORKFLOW_SYSCODE+"' syscode                "+
        		"           from (select t.*, 0 witype                                          "+
        		"                   from WFWORKITEM t                                           "+
        		"                  where t.currentstate = 10                                    "+
        		"                    and t.participant = ?                                      "+
        		"                 union all                                                     "+
        		"                 select t.*, 0 witype                                          "+
        		"                   from WFWORKITEM t                                           "+
        		"                  where t.currentstate = 4                                     "+
        		"                    and ? in (select participantid                             "+
        		"                                from WFWIParticipant a                         "+
        		"                               where a.workitemid = t.workitemid)) b           "+
        		"          inner join OA_APPLYINFO a                                            "+
        		"             on a.processinstid = b.processinstid                              "+
        		"            and a.condition != 1                                               "+
        		"            and a.condition != 6                                               "+
        		"          order by A.APPDATE) s1                                                "+
//        		"  where s1.PROCESSINSTID like ?  and  s1.FLOWTYPE in ("+(syscodes.indexOf(F_Constants.DIPOA_WORKFLOW_SYSCODE)==-1?"''":F_Constants.ALL_WORKFLOW_TYPES)+") "+
				"  where s1.PROCESSINSTID like ?  and  s1.FLOWTYPE in ("+ F_Constants.ALL_WORKFLOW_TYPES +") "+
        		"  union all  "+
                "    select * "+                       
                "    from (select A.PROCESSINSTID PROCESSINSTID,  "+                                
                "            A.APPDATE CREATETIME,        "+                                      
                "            A.DEPARTMENT DEPARTMENT,   "+                                     
                "            A.APPLER APPLER,   "+                                         
                "            decode(A.syscode,'"+F_Constants.FSSC_WORKFLOW_SYSCODE+"',(B.catalogname||'-'||B.PROCESSINSTNAME),B.PROCESSINSTNAME),   "+  
                "            B.WORKITEMID, "+
                "            A.BUSINO, "+
                "            B.processdefname FLOWTYPE,  "+                                     
                "            B.activitydefid,                                      "+
                "            B.activityinstid,                                      "+
                "            A.syscode                  "+
                "      from (select t.*, 0 witype           "+                               
                "              from WFWORKITEM@LINK_BPSDB t   "+                                        
                "             where t.currentstate = 10       "+                             
                "               and t.participant = ?   "+                            
                "            union all              "+                                       
                "            select t.*, 0 witype        "+                                  
                "              from WFWORKITEM@LINK_BPSDB t   "+                                        
                "             where t.currentstate = 4       "+                              
                "               and ? in (select participantid   "+                   
                "                           from WFWIParticipant@LINK_BPSDB a      "+                   
                "                          where a.workitemid = t.workitemid)) b  "+         
                "     inner join t_bpms_applyinfo@LINK_BPSDB a       "+                                     
                "        on a.processinstid = b.processinstid  "+                            
                "       and a.condition != 1   "+                                            
                "       and a.condition != 6   "+                                             
                "     ) s2  "+
                sqlBOP+
"  and  s2.FLOWTYPE in ("+ F_Constants.ALL_WORKFLOW_TYPES_FSSC +
","+ F_Constants.ALL_WORKFLOW_TYPES_LSP + ","+ F_Constants.ALL_WORKFLOW_TYPES_DWFS + ","+ F_Constants.ALL_WORKFLOW_TYPES_ICRM + "," + F_Constants.ALL_WORKFLOW_TYPES_FIN_SELF +
"," + F_Constants.ALL_WORKFLOW_TYPES_HR + "," + F_Constants.ALL_WORKFLOW_TYPES_WDGH + "," + F_Constants.ALL_WORKFLOW_TYPES_ACMS + " ) "+ " )v0 order by v0.CREATETIME )v1 where rownum <= ?  )v2 where rd>=? ";
    }
    
    /**查询待办事项List*/
    public static String getQueryWorkflowList(String syscodes){
//    	if(null == syscodes){
//			syscodes = "DIPOA,FSSC,DLSP,DWFS,ICRM,FINS,INHR";
//		}
    	return " select * from ( "+
    		" select * from ( "+
    		" select A.PROCESSINSTID PROCESSINSTID, "+
    		"      A.APPDATE CREATETIME, "+    
    		"      A.DEPARTMENT DEPARTMENT, "+   
    		"      A.APPLER APPLER, "+   
    		"      B.PROCESSINSTNAME, "+
    		"      B.WORKITEMID, "+
    		"      '' BUSINO, "+
    		"      B.processdefname FLOWTYPE, "+
    		"      B.activitydefid , "+
    		"       B.activityinstid,                                      "+
    		"      '"+F_Constants.DIPOA_WORKFLOW_SYSCODE+"' syscode "+
    		" from (select t.*, 0 witype "+
    		"         from WFWORKITEM t "+
    		"        where t.currentstate = 10 "+
    		"          and t.participant = ? "+
    		"       union all "+
    		"       select t.*, 0 witype "+
    		"         from WFWORKITEM t "+
    		"        where t.currentstate = 4 "+
    		"          and ? in (select participantid "+
    		"                             from WFWIParticipant a "+
    		"                            where a.workitemid = t.workitemid)) b "+
    		" inner join OA_APPLYINFO a "+
    		"   on a.processinstid = b.processinstid "+
    		"  and a.condition != 1 "+
//    		"  and a.condition != 6 )s where s.FLOWTYPE in ("+(syscodes.indexOf(F_Constants.DIPOA_WORKFLOW_SYSCODE)==-1?"''":F_Constants.ALL_WORKFLOW_TYPES)+") "+
			"  and a.condition != 6 )s where s.FLOWTYPE in ("+ F_Constants.ALL_WORKFLOW_TYPES +") "+
    		" union all "+
    		" select * from ( "+
    		" select A.PROCESSINSTID PROCESSINSTID, "+
    		"      A.APPDATE CREATETIME, "+    
    		"      A.DEPARTMENT DEPARTMENT, "+   
    		"      A.APPLER APPLER, "+   
    		"      decode(A.syscode,'"+F_Constants.FSSC_WORKFLOW_SYSCODE+"',(B.catalogname||'-'||B.PROCESSINSTNAME),B.PROCESSINSTNAME),   "+
    		"      B.WORKITEMID, "+
    		"      A.BUSINO, "+
    		"      B.processdefname FLOWTYPE, "+ 
    		"      B.activitydefid, "+
    		"       B.activityinstid,                                      "+
    		"      A.syscode "+
    		" from (select t.*, 0 witype "+
    		"         from WFWORKITEM@LINK_BPSDB t "+
    		"        where 	t.currentstate = 10 " +
    		"				and T.ACTIVITYDEFID != 'Drafter' " +
    		"				and t.participant = ? "+
    		"       union all "+
    		"       select t.*, 0 witype "+
    		"         from WFWORKITEM@LINK_BPSDB t "+
    		"        where t.currentstate = 4 "+
    		"				and T.ACTIVITYDEFID != 'Drafter' " +
    		"          and ? in (select participantid "+
    		"                             from WFWIParticipant@LINK_BPSDB a "+
    		"                            where a.workitemid = t.workitemid)) b "+
    		" inner join t_bpms_applyinfo@LINK_BPSDB a "+
    		"   on a.processinstid = b.processinstid "+
    		"  and a.condition != 1 "+
    		"  and a.condition != 6 )s where s.FLOWTYPE in ("+ F_Constants.ALL_WORKFLOW_TYPES_FSSC + ","+ F_Constants.ALL_WORKFLOW_TYPES_LSP +
    		","+ F_Constants.ALL_WORKFLOW_TYPES_DWFS +","+ F_Constants.ALL_WORKFLOW_TYPES_ICRM +"," + F_Constants.ALL_WORKFLOW_TYPES_FIN_SELF +
    		"," + F_Constants.ALL_WORKFLOW_TYPES_HR + "," + F_Constants.ALL_WORKFLOW_TYPES_WDGH +"," + F_Constants.ALL_WORKFLOW_TYPES_ACMS +")"+")v order by v.CREATETIME ";
    }
    /**
     * 
    * @MethodName: queryWFListSql 
    * @description : TODO
    * @author：caibingbing 
    * @date： 2014-8-25 下午3:34:37
    * @return String
     */
    public static String queryWFListSql(){
    	String processdefname = F_Constants.ALL_WORKFLOW_TYPES_FSSC + ","+ F_Constants.ALL_WORKFLOW_TYPES_LSP +
    		","+ F_Constants.ALL_WORKFLOW_TYPES_DWFS +","+ F_Constants.ALL_WORKFLOW_TYPES_ICRM +"," + F_Constants.ALL_WORKFLOW_TYPES_FIN_SELF +
    		"," + F_Constants.ALL_WORKFLOW_TYPES_HR + "," + F_Constants.ALL_WORKFLOW_TYPES_WDGH +"," + F_Constants.ALL_WORKFLOW_TYPES_ACMS;
    	String SQL =
    			"SELECT PROCESSINSTID,CREATETIME,DEPARTMENT,APPLER,processinstname,WORKITEMID,BUSINO,FLOWTYPE,activitydefid,activityinstid,syscode FROM (" +
    			"SELECT " +
    			" A.PROCESSINSTID PROCESSINSTID," +
    			" A.APPDATE CREATETIME," +
    			" A.DEPARTMENT DEPARTMENT," +
    			" A.APPLER APPLER," +
    			" decode(A.syscode,'"+F_Constants.FSSC_WORKFLOW_SYSCODE+"',(B.catalogname||'-'||B.PROCESSINSTNAME),B.PROCESSINSTNAME) processinstname , " +
    			" B.WORKITEMID," +
    			" A.BUSINO," +
    			" B.processdefname FLOWTYPE," +
    			" B.activitydefid," +
    			" B.activityinstid," +
    			" A.syscode " +
    			" FROM bpsdb.WFWORKITEM B " +
    			" INNER JOIN bpsdb.t_bpms_applyinfo  a " +
    			" ON A.processinstid = B.processinstid " +
    			" WHERE B.ACTIVITYDEFID != 'Drafter' " +
    			" and A.iseffective = 1 " +
    			" and A.condition in (2, 3) " +
    			" and A.processdefname in ("+processdefname+") " +
    			" AND B.PARTICIPANT = ? " +
    			" AND B.CURRENTSTATE = 10 " +
    			" UNION " +
    			" SELECT " +
    			" A.PROCESSINSTID PROCESSINSTID," +
    			" A.APPDATE CREATETIME," +
    			" A.DEPARTMENT DEPARTMENT," +
    			" A.APPLER APPLER," +
    			" decode(A.syscode,'"+F_Constants.FSSC_WORKFLOW_SYSCODE+"',(B.catalogname||'-'||B.PROCESSINSTNAME),B.PROCESSINSTNAME) processinstname,  " +
    			" B.WORKITEMID," +
    			" A.BUSINO," +
    			" B.processdefname FLOWTYPE," +
    			" B.activitydefid," +
    			" B.activityinstid," +
    			" A.syscode " +
    			" FROM bpsdb.WFWIPARTICIPANT wi, bpsdb.WFWORKITEM B " +
    			" inner join bpsdb.t_bpms_applyinfo A " +
    			" ON A.processinstid = B.processinstid " +
    			" WHERE wi.WORKITEMID = B.WORKITEMID " +
    			" AND B.ACTIVITYDEFID != 'Drafter' " +
    			" AND A.iseffective = 1 " +
    			" AND A.condition in (2, 3) " +
    			" AND A.processdefname in ("+processdefname+") " +
    			" AND B.CURRENTSTATE = 4 " +
    			" AND wi.PARTICIPANTID = ?)BB ORDER BY BB.CREATETIME ASC ";
    	System.out.println(SQL);
		return SQL;
    }
    /**维修工程申请 **/
   public static final String QUERY_DECOPROGRAM_APPLY_BY_ID =""+
		   " select processinstid, "+   
		   "        name, "+            
		   "        empid, "+           
		   "        newapplyno, "+      
		   "        deptname, "+        
		   "        deptmanager, "+     
		   "        area, "+            
		   "        (select dict.dictname from EOS_DICT_ENTRY dict where dict.dicttypeid='DIP_ENTERPRISE_AREA' and dict.dictid = enterprisedept) enterprisedept, "+  
		   "        enterprisedeptcode,"+
		   "        (select dict.dictname from EOS_DICT_ENTRY dict where dict.dicttypeid='DIP_ISSIGNEDPACT' and dict.dictid = issignedpact) issignedpact, "+    
		   "        (select dict.dictname from EOS_DICT_ENTRY dict where dict.dicttypeid='DIP_ISRIGHTDRAWING' and dict.dictid = isrightdrawing) isrightdrawing, "+  
		   "        admittancedate, "+  
		   "        budgetcost, "+      
		   "        reason, "+          
		   "        (select dict.dictname from EOS_DICT_ENTRY dict where dict.dicttypeid='MAINTENANCEtYPE' and dict.dictid = maintenancetype) maintenancetype "+
		   "   from oa_decoprogramapply "+
		   "   where processinstid = ? ";

   
   /**查询工作流的审批处理记录*/
   public static final String QUERY_FLOW_APPROVE_INFO =""+
           " select a.approver, to_char(a.approvedate,'yyyy-mm-dd hh24:mi') approvedate, a.approvever approverver, a.isagree "+
		   " from oa_approvalinfo a, oa_applyinfo b "+
           " where a.applyno = b.applyno and b.processinstid = ? "+
		   " order by a.approvedate ";
   
   /**增补员申请**/
   public static final String QUERY_PERSONADD_APPLY_BY_ID =""+
		   " select"+         
		   " processinstid,"+
		   " name,"+
		   " empid,"+
		   " reason,"+
		   " addnum,"+
		   " position,"+
		   " sexrequire,"+
		   " otherrequire,"+
		   " (select dict.dictname from EOS_DICT_ENTRY dict where dict.dicttypeid='DIP_PERSONADDDEPTTYPENEW' and dict.dictid = depttype) depttype,"+
		   " (select dict.dictname from EOS_DICT_ENTRY dict where dict.dicttypeid='DIP_AREAPERSONNEL' and dict.dictid = localpersonnel) localpersonnel,"+
		   " servent,"+
		   " positionproperty,"+
		   " userid,"+
		   " (select dict.dictname from EOS_DICT_ENTRY dict where dict.dicttypeid='DIP_ADDPERSONREASON' and dict.dictid = addreason) addreason,"+
		   " psdata,"+
		   " serventfinacode,"+
		   " jareaselect,"+
		   " yareaselect"+
		   " from oa_personadd where processinstid = ?";
   
   /**增补员详细列表**/
   public static final String QUERY_PERSONADD_ENTRY_BY_ID =""+
		   " select "+
		   " processinstid,"+
		   getDictNameSql("ABF_POSITIONNAME","addposition")+" addposition, "+
		   " addnumber,"+
		   " id,"+
		   " personinfos,"+
		   " sexrequire,"+
		   " mennumber,"+
		   " womennumber"+
		   " from oa_personaddentry "+
		   " where processinstid = ?"; 
    
   /***文件发布申请**/
   public static final String QUERY_FILEPUBLISH_BY_ID = ""+
		   " select "+
		   " processinstid ,"+
		   " empid ,"+
		   " name ,"+
		   " applytype ,"+
		   " (select dict.dictname from EOS_DICT_ENTRY dict where dict.dicttypeid='DIP_FILETYPE' and dict.dictid = filetype) filetype ,"+
		   " filecode ,"+
		   " filetittle ,"+
		   " fileabstract ,"+
		   " effectdate ,"+
		   " expireddate ,"+
		   " appointedtype ,"+
		   " (select dict.dictname from EOS_DICT_ENTRY dict where dict.dicttypeid='DIP_DIVISION_NEW' and dict.dictid = division) division ,"+
		   " whyapply ,"+
		   " nextapproal ,"+
		   " effectstate ,"+
		   " countpage ,"+
		   " respondepart ,"+
		   " responpeople ,"+
		   " scope ,"+
		   " agreedate "+
		   " from oa_filepublish "+
		   " where processinstid = ?";
   
   /**签订合同申请**/
   public static final String QUERY_CONTRACTSIGN_APPLY_BY_ID =""+
		   " select "+
		   " PROCESSINSTID           ,"+
		   " PROPOSER                ,"+
		   " USERID                  ,"+
		   " CHARGEINDEPARTMENT      ,"+
		   " SIGNTYPE                ,"+
		   " ORIGINALCONTRACTNUMBERS ,"+
		   " (select dict.dictname from EOS_DICT_ENTRY dict where dict.dicttypeid='WFS_HT_SIGNCONTRACTTYPE' and dict.dictid = CONTRACTTYPE) CONTRACTTYPE  ,"+
		   " (select dict.dictname from EOS_DICT_ENTRY dict where dict.dicttypeid='DIP_DIVISION_NEW' and dict.dictid = SUBORDINATEDEPARTMENT) SUBORDINATEDEPARTMENT  ,"+
		   " (select dict.dictname from EOS_DICT_ENTRY dict where dict.dicttypeid='DIP_FINANCEDEPT' and dict.dictid = FINANCEDEPT)  FINANCEDEPT ,"+
		   " ITEMNAME                ,"+
		   " QUANTITY                ,"+
		   " UNITPRICE               ,"+
		   " ISMAIN                  ,"+
		   " ISFRAMECONTRACT         ,"+
		   " CONTRACTNAME            ,"+
		   " CONTRACTAMOUNT          ,"+
		   " SIGNINGEACHOTHERUNIT    ,"+
		   " SIGNINGOURUNIT          ,"+
		   " CONTRACTSTARTTIME       ,"+
		   " CONTRACTENDTIME         ,"+
		   " REASON                  ,"+
		   " PROCESSINSTNAME         ,"+
		   " SEAL                     "+
		   " from OA_CONTRACTAPPLY where PROCESSINSTID = ? ";
   
   
   
   
   
   
   
   
   
   
   
   /**根据待办ID获取待办事项详细信息*/
    public static final String QUERY_WORKITEMS_BY_ID = "" +
		"SELECT ROWNUM AS ROWBS," +
    		"A.APPLYNO APPLYNO," +
    		"A.PROCESSINSTID PROCESSINSTID," +
    		"A.APPLER APPLER," +
    		"A.APPDATE," +
    		"A.APPPOST APPPOST," +
    		"A.DEPARTMENT DEPARTMENT," +
    		"A.SUBCOMID SUBCOM," +
    		"A.FILLMAN," +
    		"A.APPCATE," +
    		"A.CONDITION," +
    		"A.APPLERID APPLERID," +
    		"A.FILLMANID FILLMANID," +
    		"B.WORKITEMID," +
    		"B.WORKITEMNAME," +
    		"B.WORKITEMTYPE," +
    		"B.WORKITEMDESC," +
    		"B.CURRENTSTATE," +
    		"B.PARTICIPANT," +
    		"B.PARTINAME," +
    		"B.PRIORITY," +
    		"B.ISTIMEOUT," +
    		"B.LIMITNUM," +
    		"B.LIMITNUMDESC," +
    		"B.CREATETIME," +
    		"B.STARTTIME," +
    		"B.ENDTIME," +
    		"B.FINALTIME," +
    		"B.REMINDTIME," +
    		"B.ACTIONURL," +
    		"B.STATESLIST," +
    		"B.TIMEOUTNUMDESC," +
    		"B.PROCESSINSTNAME," +
    		"B.ACTIVITYINSTNAME," +
    		"B.PROCESSDEFID," +
    		"B.PROCESSDEFNAME," +
    		"B.PROCESSCHNAME," +
    		"B.ACTIVITYDEFID," +
    		"B.ASSISTANT," +
    		"B.ASSISTANTNAME," +
    		"B.BIZSTATE," +
    		"B.ALLOWAGENT," +
    		"B.ROOTPROCINSTID," +
    		"B.ACTIONMASK," +
    		"(select dict.dictname from EOS_DICT_ENTRY dict where dict.dicttypeid='DIP_CONDITION' and dict.dictid = A.Condition) DIP_CONDITION," +
    		"(select dict.dictname from EOS_DICT_ENTRY dict where dict.dicttypeid='OA_FLOWTYPE' and dict.dictid = A.Appcate) OA_FLOWTYPE" +
    		" FROM OA_APPLYINFO A" +
    		" LEFT JOIN WFWORKITEM B ON A.PROCESSINSTID = B.PROCESSINSTID" +
    		" where a.PROCESSINSTID = ?" +
    		" and b.workitemid in (" +
    		" select max(b.workitemid) " +
    		" from WFWORKITEM b " +
    		" where b.processinstid = a.processinstid " +
    		" group by b.processinstid )";
    
    
       /**根据工作流ID查询请假/调休 详细信息*/
    public static String QUERY_LEAVE_WORKFLOW_BY_ID = "SELECT" +
    		" LE.PROCESSINSTID," +
    		"LE.EMPID," +
    		"LE.APPLYNAME," +
    		"LE.WORKTO," +
    		"(SELECT EDE.DICTNAME FROM EOS_DICT_ENTRY EDE WHERE EDE.DICTTYPEID = 'DIP_ENTERPRISEPERSONNEL' AND EDE.DICTID = LE.AREA)" +
    		"AREA," +
    		"LE.APPLYCATEGORY," +
    		"LE.DATESTART," +
    		"LE.DATEFINSH," +
    		"LE.DAYS," +
    		"LE.REASON," +
    		"LE.EMPLOYEETIME," +
    		"LE.APPLYCATEGORY," +
    		"LE.WORKFLOWNO," +
    		"LE.OVERTIMEDAYS," +
    		"LE.XIAOJIA," +
    		"LE.DETAILCATEGORY," +
    		"LE.XIAOJIAEMPLOYEETIME," +
    		"LE.ORGNAME," +
    		"LE.USERID," +
    		"LE.XIAOJIAPROCESSINSTID," +
    		"LE.DATESTARTXIAOJIA," +
    		"LE.DATEFINSHXIAOJIA," +
    		"LE.POSITIONLEVEL," +
    		"LE.LEAVECATEGORY" +
    		" FROM LEAVEAPPLY LE" +
    		" WHERE LE.PROCESSINSTID = ?";
    
     /**根据工作流ID查询辞职申请详细信息*/
     public static String QUERY_RESIGN_WORKFLOW_BY_ID = "SELECT" +
     		" RA.PROCESSINSTID," +
     		" RA.EMPNAME," +
     		" RA.EMPID," +
     		" RA.EMPUSERID," +
     		" RA.RESIGNTYPE," +
     		" RA.ERRORNO," +
     		" RA.JOINDATE," +
     		" RA.ABC," +
     		" (SELECT PT.DICTNAME FROM EOS_DICT_ENTRY PT WHERE PT.DICTTYPEID = 'DIP_POST_TYPE' AND PT.DICTID = RA.POSTSORT)" +
     		" POSTSORT," +
     		" (SELECT EDE.DICTNAME FROM EOS_DICT_ENTRY EDE WHERE EDE.DICTTYPEID = 'DIP_IFVALID' AND EDE.DICTID = RA.ISRESERVE)" +
     		" ISRESERVE," +
     		" RA.RESERVEDATE," +
     		" RA.RESERVENO," +
     		" (SELECT EDE.DICTNAME FROM EOS_DICT_ENTRY EDE WHERE EDE.DICTTYPEID = 'DIP_ISGOODWORKER' AND EDE.DICTID = RA.ISGOOD)" +
     		" ISGOOD," +
     		" RA.WORKYEARS," +
     		" (SELECT EDE.DICTNAME FROM EOS_DICT_ENTRY EDE WHERE EDE.DICTTYPEID = 'DIP_RESIGNREASON' AND EDE.DICTID = RA.RESIGNREASON)" +
     		" RESIGNREASON," +
     		" (SELECT EDE.DICTNAME FROM EOS_DICT_ENTRY EDE WHERE EDE.DICTTYPEID = 'DIP_AREAPERSONNEL' AND EDE.DICTID = RA.PERSONNELDEPT)" +
     		" PERSONNELDEPT," +
     		" RA.APPLYREASON," +
     		" RA.WAGESETTLEMENT," +
     		" RA.BUSINESSPROCE," +
     		" RA.LEAVEBUSINESSPROCE," +
     		" RA.LEAVEDATE," +
     		" RA.CANO," +
     		" RA.CABANKNAME," +
     		" RA.CAHOLDER," +
     		" RA.CAPROVINCE," +
     		" RA.CACITY," +
     		" RA.TEL," +
     		" RA.POSITION," +
     		" RA.APPDEPT" +
     		" FROM OA_RESIGNAPPLY RA" +
     		" WHERE RA.PROCESSINSTID = ?";
     
     /**工作流活动节点*/
     public static String QUERY_WFACTIVITYINST="" +
     		"SELECT ACTIVITY.ACTIVITYINSTID FROM WFACTIVITYINST ACTIVITY" +
     		" WHERE ACTIVITY.CURRENTSTATE = 2" +
     		" AND ACTIVITY.PROCESSINSTID = ?";
     		
     
     /**获取回退节点*/
     public static String QUERY_WFACTIVITYINST_BY_WOKRID="" +
	     " SELECT B.ACTIVITYDEFID," +
	     " (SELECT WF.ACTIVITYINSTID FROM WFACTIVITYINST WF WHERE WF.CURRENTSTATE = 2 AND WF.PROCESSINSTID = ?)currentActId" +
	     " FROM WFACTIVITYINST B " +
	     "	WHERE B.ACTIVITYINSTID = (" +
	     "SELECT ACTIVITY.ACTIVITYINSTID FROM WFACTIVITYINST ACTIVITY " +
	     "WHERE INSTR(ACTIVITY.ACTIVITYDEFID,'startActivity')>0 " +
	     "AND ACTIVITY.PROCESSINSTID = ?)+1";
     
     /**常规理赔申请详细信息*/
     public static String QUERY_CLAIMS_WORKFLOW_BY_ID="" +
     		"SELECT * FROM OA_NOMALCLAIM N" +
     		" WHERE N.PROCESSINSTID = ?";
     /**常规理赔申请详细信息-出险情况说明*/
     public static String QUERY_CLAIMS_ACCIDENTDESCRIPTIONINFO_BY_ID="" +
	     "SELECT * FROM OA_ACCIDENTDESCRIPTIONINFO N" +
	     " WHERE N.PROCESSINSTID = ?";
     /**常规理赔申请详细信息-入部门费用*/
     public static String QUERY_CLAIMS_DEPTEXPENSES_BY_ID="" +
	     "SELECT * FROM OA_DEPTEXPENSES N" +
	     " WHERE N.PROCESSINSTID = ?";
     /**常规理赔申请详细信息-奖罚明细*/
     public static String QUERY_CLAIMS_REWARDPUNISHMENTINFO_BY_ID="" +
	     "SELECT * FROM OA_REWARDPUNISHMENTINFO N" +
	     " WHERE N.PROCESSINSTID = ?";
     
     /**请假明细*/
     public static String QUERY_LEAVEDETAIL_BY_ID="" +
     		"SELECT DETAIL.MONTH,DETAIL.DAYS FROM OA_LEAVEDETAIL DETAIL WHERE DETAIL.PROCESSINSTID =?";
     /**查询流程节点页面流及上下节点*/
     public static String QUERY_WFWORKITEM ="" +
     		"SELECT B.*, " +
     		"A.APPLYNO," +
     		"A.PROCESSINSTID," +
     		"A.APPLER," +
     		"A.APPPOST," +
     		"A.DEPARTMENT," +
     		"A.SUBCOMID SUBCOM," +
     		"A.FILLMAN," +
     		"A.APPCATE," +
     		"A.CONDITION," +
     		"A.APPLERID APPLERID," +
     		"A.FILLMANID" +
     		" FROM (SELECT T.*,0 WITYPE FROM WFWORKITEM T WHERE T.CURRENTSTATE = 10" +
     		" AND T.PARTICIPANT = ?" +
     		" UNION SELECT T.*,0 WITYPE  FROM WFWORKITEM T WHERE T.CURRENTSTATE = 4" +
     		" AND ?IN ( SELECT PARTICIPANTID FROM WFWIPARTICIPANT A" +
     		" WHERE A.WORKITEMID = T.WORKITEMID  )) B" +
     		" INNER JOIN OA_APPLYINFO A ON A.PROCESSINSTID = B.PROCESSINSTID" +
     		" AND A.CONDITION !=1 AND A.CONDITION !=6" +
     		" AND (A.PROCESSINSTID LIKE  CONCAT(CONCAT('%', ?), '%'))";
     public static String QUERY_OA_APPROVEINFO ="" +
	     "SELECT INFO.APPLYNO FROM OA_APPLYINFO INFO WHERE INFO.PROCESSINSTID = ?";
     
     /**系统变更申请明细*/
     public static String  QUERY_SYS_DATACHANGES= "" +
     		"SELECT S.PROCESSINSTID, " +
     		"S.APPLYNAME," +
     		"S.MESSAGE," +
     		"S.PROCESS," +
     		"S.REASON," +
     		"S.EMPID," +
     		"(SELECT DOE.DICTNAME FROM EOS_DICT_ENTRY DOE WHERE DOE.DICTTYPEID LIKE 'DIP_IFVALID' AND DOE.DICTID LIKE S.ISFINANCIAL)ISFINANCIAL," +
     		"(SELECT DOE.DICTNAME FROM EOS_DICT_ENTRY DOE WHERE DOE.DICTTYPEID LIKE'DIP_SYSTEM_TYPE' AND DOE.DICTID LIKE S.SYSTEMID)SYSTEMID," +
     		"(SELECT W.WORKITEMNAME FROM WFWORKITEM W WHERE (W.CURRENTSTATE = '10' OR  W.CURRENTSTATE = '4') AND W.PROCESSINSTID = S.PROCESSINSTID)CURRENTNODE" +
     		"FROM SYSDATACHANGE S WHERE S.PROCESSINSTID = ?";
}

