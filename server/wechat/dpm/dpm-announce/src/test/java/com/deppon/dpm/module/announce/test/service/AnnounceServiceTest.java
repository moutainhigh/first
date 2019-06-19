package com.deppon.dpm.module.announce.test.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.announce.server.dao.IAnnounceDao;
import com.deppon.dpm.module.announce.server.service.IAnnounceService;
import com.deppon.dpm.module.announce.server.service.IAnnounceUserService;
import com.deppon.dpm.module.announce.shared.define.ConstansUtil;
import com.deppon.dpm.module.announce.shared.domain.AnnounceEntity;
import com.deppon.dpm.module.announce.shared.dto.AnnounceDto;
import com.deppon.dpm.module.announce.shared.util.UUIDUtils;
import com.deppon.dpm.module.announce.shared.vo.AnnounceVo;
import com.deppon.dpm.module.announce.test.BaseTestCase;

public class AnnounceServiceTest extends BaseTestCase{
	@Autowired
	private IAnnounceService announceService;
	
	/**
	 * 测试公告信息插入
	 */
	@Test
	public void insert(){
		annouceInsert();
		leaderNoteInsert();
		newsInsert();
	}
	
	/**
	 * 公告信息插入
	 */
	private void annouceInsert(){
		for(int i = 0; i < 10; i++){
			AnnounceEntity entity = new AnnounceEntity();
			entity.setType(ConstansUtil.ANNOUNCE);
			String oaId = UUIDUtils.getUUID();
			entity.setOaId(oaId);
			//标题
			entity.setTitle("10-1059职能部门组织结构调整及相关人事任命通知"+(i+1));
		    //发布时间
			entity.setPublishTime(new Date());
			StringBuffer stff = new StringBuffer();
			stff.append("各营业区、部门：");
			stff.append("因公司发展需要，经公司研究决定：");
			stff.append("一、成立成都新都区工业大道营业部，隶属于成都新都营业区。");
			stff.append("二、任命孙琦（050978）同志为成都新都区工业大道营业部经理（Band6-M），考察期两个月，对成都新都营业区区域经理负责。");
			stff.append("以上通知自发文之日起执行，望各部门周知并做好相关协调与配合工作。");
			stff.append("附件：《任命人员简历表》及《组织结构图》");
			//stff.append("");
//			stff.append("<p>各营业区、部门：<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 因公司发展需要，经公司研究决定：<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 一、将运作场地规划组和运作场地设计小组合并为运作场地设计小组， 隶属于工程部。<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 二、成立工装器具研究组，隶属于线路与外场管理部。<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 三、任命蔡壮辉同志为工装器具研究组高级经理，对线路与外场管理部总监负责，同时免去其原运作场地规划组高级经理职务。<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 以上通知自发文之日起执行，望各部门周知并做好相关协调与配合工作。<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 附件：《组织结构图》<br /><br /><br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 德邦物流股份有限公司<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 二〇一〇年十一月五日<br />&nbsp;</p>");
		    //正文内容
			entity.setContent(stff.toString());
		    //创建人工号
			entity.setCreateUserCode("235210");
		    //创建人
			entity.setCreateUserName("申粤湘1 ");
			int row = announceService.insert(entity);
			System.out.println(row);
		}
	}
	
	
	/**
	 * 高层笔记插入
	 */
	private void leaderNoteInsert(){
		for(int i = 0; i < 10; i++){
			AnnounceEntity entity = new AnnounceEntity();
			String oaId = UUIDUtils.getUUID();
			entity.setOaId(oaId);
			entity.setType(ConstansUtil.LEADER_NOTES);
			//标题
			entity.setTitle("【高管晨会随笔】德邦“高管团队自律宣言”誓词（二） "+(i+1));
		    //发布时间
			entity.setPublishTime(new Date());
			StringBuffer stff = new StringBuffer();
			
			stff.append("关于咨询合作的一些想法");
			stff.append("过去几年，我们跟咨询公司进行了很多合作，也慢慢有了一些体会和想法。");
			stff.append("首先，咨询项目要取得好的效果，需要我们从上至下地投入，高层要多参与，把准方向。这几天，我见了埃森哲的一位全球高管，他讲埃森哲和华为已经合作八年了，总体效果还不是非常明显。他分析说华为以前做的有些咨询项目是自下而上的模式，项目负责人大多是中基层管理人员，他们本身很努力，又有数据监控，华为文化又要求让一线呼唤炮火，所以他们不怎么对上面做汇报；高层领导可能是管不过来的缘故，对项目的参与也不是很多。高层关注的是项目的效益和价值，但项目负责人想的可能是流程和交付这些具体的事，想尽量多得表扬，少挨批评。想法不一样，再加上沟通不是很顺畅，项目目标就容易跑偏，效果也就打折了。");
			stff.append("我们应该汲取这个经验，咨询项目要从上至下做。高层要多参与，搞明白这个项目能产生什么价值、能给企业带来什么好处，然后项目负责人再按流程去做，这样方向不至于走偏。同时，高层还要和咨询公司之间保持好的沟通，埃森哲现在建议跟我们每月开1小时的沟通会，每季度开3小时的研讨会，这样的沟通就比较顺畅，我们共同寻找资源，项目效果可能也会更好。");
			stff.append("其次，不要盲目崇拜，也不要小瞧了自己。以前我们崇拜咨询公司，觉得他们很神奇，跟咨询公司合作了几年之后，现在我们自己的水平已经有所提高，可以更加主动一些了。专业领域的问题，顾问可以多发言；专业之外的发言，我们要慎重听取。顾问有特长，也有不足，他们懂方法论，但不怎么了解德邦，如果全听咨询公司的，完全跟着它走，靠它落地，是不可能做到很好的。我们要把他们的优点利用好，把他们的国际经验、逻辑思维、方法论、数据库、软件之类的用好，然后我们自己再跟上，慢慢地引导着他们跟着我们走，原来靠它只能做到六七成的事，这样就可以做到八九成了。");
			stff.append("最后，要复盘。我们有些咨询项目的目标是没有达成的，还有些项目做来做去，没什么大的突破。我们要多跟咨询顾问一起去对项目进行复盘，反思和检讨里面的问题，提醒他们，双方一起进步提高，不断拿出更好的成果。再不行的，就要做出一些变化，再去整合全球资源，找到更好的公司和更好的人来做。");
			stff.append("咨询公司的方法论都是不错的，我们在他们的基础上提高水平还是很有希望的。但怎么最大限度地用好咨询公司，我们还需要多思考，多探索。");
			stff.append("<div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 楷体_GB2312; font-size: 12pt'>2015</span><span style='line-height: 166%; font-family: 楷体_GB2312; font-size: 12pt'>年1月28日，公司举行的2014年度总结大会上，总裁崔维星及其直管人员进行了自律宣言。一直以来，我司都十分重视人品问题，此次高管团队举行自律宣言，表明高层领导从自身做起，严格自律，同心同德、众志成城、聚焦发展的决心。</span></div><div style='text-align: center; line-height: 166%; text-indent: 24.1pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char' align='center'><b><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>德邦&ldquo;高管团队自律宣言&rdquo;誓词（二）</span></b></div><div style='line-height: 166%; text-indent: 24.1pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><b><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>人力资源本部总裁助理林志彬</span></b></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>作为公司人力资源的负责人，唯有在工作上排除私人利益，坚持原则，才能引导人才管理工作公平公正、持续健康地开展；在此，我做出如下郑重承诺，并接受全体员工监督和公司审计：</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>坚持引导人力资源工作紧紧围绕业务开展；<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>坚持选人用人正直无私，五湖四海，任人唯贤；</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>绝不以权谋私，贪污腐败，侵占公司财产；</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>坚持以身作则，杜绝系统内部腐化；</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>坚持自我学习，不断反思；</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>我将与大家同心同德，团结一致，为公司的基业长青廉洁奉公、持续奋斗。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>宣誓完毕！宣誓人：林志彬</span></div><div style='line-height: 166%; text-indent: 24.1pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><b><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>资产与供应链管理本部副总裁单剑林</span></b></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>作为资产与供应链管理本部的负责人，公司赋予了我很多职权，分管了采购、工程、资产和后勤等业务，每年采购额超过二十亿，是滋生腐败及关联交易的易发区域。职责与权利是公司的信任与托付，也是考验，而要想履行好如此重要的职责和权利，必须做到廉洁自律，公正无私。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>在此，我郑重承诺：</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>一、廉洁自律，杜绝腐败。严格遵守集体决策、分层决策等采购内控原则，增加透明度，绝不利用公司赋予我的职责去影响和干扰公司各项业务，绝不在公司的重大决策中掺杂自私的动机，绝不侵占公司资产，绝不贪污腐败，同时对采购业务中的贪腐行为坚决打击；</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>二、以身作则，坚持原则。目前为止没有在外开设公司、参股以及兼职，没有亲属和利益相关者开设的公司与德邦进行任何形式的关联交易，今后也不会有；</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>三、正直无私，不拉帮结派，公正对待所有员工；</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>四、保持激情，提高修养，坚持自我反思，不断促进自我完善。我会全身心投入工作中，保持持续的工作热情和奋斗精神。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>宣誓完毕！宣誓人：单剑林</span></div><div style='line-height: 166%; text-indent: 24.1pt; margin: 0cm 0cm 6pt; layout-grid-mode: char'><b><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>董事会秘书汤先保</span></b></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm 0cm 6pt; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>作为公司管理人员，我深知自己的一言一行都对公司和员工有着重要影响。要想履行好公司赋予的职责，必须首先管理好自己。在此，我庄严宣誓、郑重承诺：</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm 0cm 6pt; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>以身作则，严格遵守公司规章制度，认真践行公司价值理念，绝不以权谋私，绝不贪污腐败。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm 0cm 6pt; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>对公司重要决策、核心信息严格保密、守口如瓶，决不搞内幕交易。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm 0cm 6pt; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>正直无私，不拉帮结派，树立正气，做好表率。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm 0cm 6pt; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>为适应公司发展，我将持之以恒地进行自我修炼、自我提升，并愿意接受公司审计和全体同事的监督和检查。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm 0cm 6pt; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>宣誓完毕！宣誓人：汤先保</span></div><div style='line-height: 166%; text-indent: 24.1pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><b><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>总裁办公室高级总监田民芽</span></b></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>作为总裁办公室负责人，我的主要职责是&ldquo;沟通上下，协调左右，联系内外&rdquo;，要履行好这一职责，必须具备公司立场，必须秉持公心做事，必须时刻警醒自己，必须坚持廉洁自律。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>在此，我郑重承诺：</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>积极践行公司价值理念，率先垂范。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>严格遵守公司规章制度，以身作则。 </span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>决不以权谋私，索贿受贿；决不欺上瞒下，弄虚作假。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>以公司标准公正评价和使用人，决不拉帮结派，决不掺杂个人意志。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>沟通务必做到客观，协调务必做到公正，联系务必做到及时。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>我将坚决履行上述承诺，并会不断地自查自纠，自我完善。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>特此宣誓，自愿接受公司审计和全员监督。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>宣誓完毕！宣誓人：田民芽</span></div><div style='line-height: 166%; text-indent: 24.1pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><b><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>华东经营本部副总裁姚晓舟</span></b></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>作为公司的管理人员，我深深地体会到，自己的一言一行都会对公司的发展产生影响，都会被员工自觉模仿，要履行好自己的管理职责，要想带好队伍，必须先管理好自己，必须做到严格自律。我在此庄严宣誓，郑重承诺：</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>廉洁自律，以身作则，决不利用公司赋予的职权，谋取个人私利，损害公司利益。 </span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>光明磊落、坚持原则，公正对待所有员工，唯才是举，不拉帮结派。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>坚持自我反思、自我改进，&ldquo;勿以恶小而为之&rdquo;。通过自查、自纠、自我反思，养成严格自律的习惯和品格。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>我将严格自律、艰苦奋斗，把自己的所有力量都聚焦于公司的业务发展上，以正能量的自己带出正能量的员工，决不允许&ldquo;上梁不正下梁歪&rdquo;情况的出现。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>我将坚决履行上述承诺，自愿接受公司审计和全员监督。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>宣誓完毕！宣誓人：姚晓舟</span></div><div style='line-height: 166%; text-indent: 24.1pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><b><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>华中经营本部副总裁薛大鹏</span></b></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>公司的长青发展离不开严格的纪律，只有自上而下的清廉自律氛围，才能够打造健康奋进的优秀团队。作为公司高层，我有责任和义务规范自己，树立优秀形象，传递正能量，带领员工共同打造长青德邦！</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>在此，我郑重承诺：</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>以公司价值理念作为思想基石，以公司规章制度作为言行标尺。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>时刻保持以公司立场行使职权，绝不以权谋私，绝不侵占公司财产、吃回扣、行贿受贿；不搞特殊化，不为私利摆布；</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>增强自我反思，自我改进的能力；通过自查、自纠、自我批评，不断促进自我完善，养成严格自律的习惯和品格；</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>坚持以客户为中心，以团队建设为己任，毫无保留、奉献自己全部智慧与精力。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>特为此誓，请大家监督。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>宣誓完毕！宣誓人：薛大鹏</span></div><div style='line-height: 166%; text-indent: 24.1pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><b><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>公共事务本部副总裁郑荣国</span></b></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>作为公司高级管理人员，我深知自己肩上责任重大，深知自己的言行对下属有着重要影响，要履行好艰巨的责任，要管理好员工，必须做到廉洁自律。在此，我郑重做出以下承诺，并愿意接受全体员工的监督和公司的审计。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>工作恪尽职守，不遗余力；</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>遵守公司理念和制度，以身作则，不搞特殊；</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>廉洁自律，以公司立场行使职权，绝不以权谋私；</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>正直无私，按公司标准用人，不拉帮结派；</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>持续奋斗，持续学习反思，努力修炼自我，完善自我。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>宣誓完毕！宣誓人：郑荣国</span></div><div style='line-height: 166%; text-indent: 24.1pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><b><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>市场营销本部副总裁钟智龙</span></b></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>在此我承诺工作期间：</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>以身作则、廉洁自律，不以任何形式损害公司利益，并勇于指出和批判组织中不健康行为；</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>正直无私，不拉帮结派，热爱公司，为了公司的兴旺发展，毫无保留、奉献全部智慧与精力；</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>坚持自省、自检、自我改进，为员工做好表率；</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>请大家监督。</span></div><div style='line-height: 166%; text-indent: 24pt; margin: 0cm -5.25pt 6pt 0cm; layout-grid-mode: char'><span style='line-height: 166%; font-family: 宋体; font-size: 12pt'>宣誓完毕！宣誓人：钟智龙</span></div>");
			//正文内容
			entity.setContent(stff.toString());
		    //创建人工号
			entity.setCreateUserCode("235210");
		    //创建人
			entity.setCreateUserName("申粤湘 ");
			int row = announceService.insert(entity);
			//System.out.println(row);
		}
	}
	
	/**
	 * 新闻插入
	 */
	private void newsInsert(){
		for(int i = 0; i < 10; i++){
			AnnounceEntity entity = new AnnounceEntity();
			String oaId = UUIDUtils.getUUID();
			entity.setOaId(oaId);
			entity.setType(ConstansUtil.NEWS);
			//标题
			entity.setTitle("【行业】今年前10月我国社会物流总额逾100万亿"+(i+1)+"(图)");
		    //发布时间
			entity.setPublishTime(new Date());
			StringBuffer stff = new StringBuffer();
			/*stff.append("最后一公里”中蕴藏的机会，你重视了吗?");
			stff.append("编辑部讯 记者 黄敏华）随着经济发展带动社会物流量的迅猛增长，使得企业和用户对配送的质量提出了更高的要求。为满足客户在配送“最后一公里”上的需求，提升其满意度，经过四个月的试点，我司于2015年1月1日面向全国到达客户推出了新产品——大件上楼服务。而各区域也积极向客户推广该项服务，由此带来了收入的增加。数据显示，3月截至15日，全国大件上楼日均开单504票，日均收入较试点期间提升526%。");
			stff.append("宁德福安市城南营业部1月收入71万，其中一半以上的收入来源于部门客户钟先生。据了解，钟先生为福安当地某电商的发货负责人。该公司以销售按摩椅为主，觉察到客户的潜力巨大，福安市城南营业部经理张杰一直与客户保持密切联系，每月至少上门拜访一次，向客户介绍我司的最新政策或者营销活动。");
			stff.append("客户对时效及安全的要求性高，因此也比较认可我司，但由于我司不提供上楼服务，故其货物基本通过某同行运输。自我司开展大件上楼的试点工作后，张杰去客户那儿更勤快了。但当时可到达城市仅有十个，满足不了客户的需求，客户仍持观望态度。12月底，当大件上楼要全国推广的消息一出，张杰第一时间告知了客户。很快，客户就将其货物转发了我司。");
			stff.append("谈及经验，张杰表示：“除了公司的政策好，主要还是要做好营销工作，让客户及时知晓。”");
			stff.append("除了宁德福安市城南营业部外，合肥经济开发区会展中心营业部也从大件上楼服务中获益颇多。该部门客户某电器科技有限公司，虽是部门收入的保障，但其要求每一件冰箱要送货上楼的要求，一直是部门头疼的问题。此前部门只能联系外请人员安排送货上楼，过程繁琐，由此也导致客户部分上楼货量流失。");
			stff.append("而在大件上楼全国推广后，会展中心营业部经理操明英亦是当即拜访客户。客户肯定了我们的服务，也付诸了行动。最终该客户1月累计发大件上楼货物392票，贡献了部门当月收入的68%。");
			stff.append("市场规划部高级总监赖弘毅表示：“大件货市场潜力巨大，希望大家对潜力客户以及VIP客户予以重点关注，及时回访了解客户需求。另外，我部正研究上楼费折扣标准，对于高潜力客户未来将给予相应折扣，以吸引客户增加发货量，从而提升收入。”");*/
			stff.append("<div style='text-align: center; line-height: 150%; text-indent: 21pt; layout-grid-mode: char'><span style='line-height: 150%; font-size: 10.5pt'><font face='宋体'><img width='692' height='390' alt='' src='/dipApp/mail/mail/outimgflash.jsp?filepath=/oaupload/fckeditor/image/laoban33.JPG' /></font></span></div><div style='line-height: 150%; text-indent: 21pt; layout-grid-mode: char'>&nbsp;</div><div style='text-align: center; line-height: 150%; text-indent: 21pt; layout-grid-mode: char'><span style='line-height: 150%; font-size: 10.5pt'><font face='宋体'>图片说明：众多知名企业家在倾听总裁崔维星对80后、90后的看法。（右</font></span>三为总裁崔维星先生）</div><div style='line-height: 150%; text-indent: 21pt; layout-grid-mode: char'>&nbsp;</div><div style='line-height: 150%; text-indent: 21pt; layout-grid-mode: char'><span style='line-height: 150%; font-size: 10.5pt'><font face='宋体'>（新闻来源：新浪财经）12月5日，总裁崔维星先生参加了北京&ldquo;2010（第九届）中国企业领袖年会&rdquo;，一同出席的还有壹基金创始人李连杰、新东方董事长兼总裁俞敏洪、阿里巴巴集团董事局主席马云、华谊兄弟董事长兼总裁王中军、腾讯公司董事会主席兼CEO马化腾、百度公司董事长兼CEO李彦宏、美的集团董事局主席方洪波等众多知名企业企业家。在&ldquo;直面90后&rdquo;分论坛上，崔维星表示，80后、90后是中国未来的希望，更有创新精神。</font></span></div><div style='text-align: left; line-height: 150%; layout-grid-mode: char' align='left'><b><span style='line-height: 150%; font-family: 宋体'>德邦物流眼中：沿海与内陆的区别</span></b></div><div style='line-height: 150%; text-indent: 21pt; layout-grid-mode: char'><span style='line-height: 150%; font-size: 10.5pt'><font face='宋体'>在德邦物流看来，环境在人的成长过程中发挥着重要的作用，什么样的环境造就什么样的人。在招聘过程中，德邦物流发现，沿海、大城市的毕业生与内陆、中小城市毕业生的截然不同的。德邦做的是物流，需要人具有吃苦耐劳的精神。所以德邦倾向于在中西部比较好的大学里招优秀的学生，而且招班干部，这样他们进公司后发展会比较好。</font></span></div><div style='line-height: 150%; text-indent: 21pt; layout-grid-mode: char'><span style='line-height: 150%; font-size: 10.5pt'><font face='宋体'>相反，德邦物流去厦门大学这样的沿海城市招聘，就很少人愿意应聘。这些地方的学生，他们的创新思维更强一些，所以他们更倾向于到阿里巴巴这样的公司去做软件、网游。</font></span></div><div style='text-align: left; line-height: 150%; layout-grid-mode: char' align='left'><b><span style='line-height: 150%; font-family: 宋体'>德邦物流眼中：提拔80后的特点</span></b></div><div style='line-height: 150%; text-indent: 21pt; layout-grid-mode: char'><span style='line-height: 150%; font-size: 10.5pt'><font face='宋体'>德邦物流提拔的80后员工，有一些共同的特点：能吃苦、做事效率高、创新多。对80后、90后不应该管得太多、说得太多，要给他们较大的空间，多听听他们的发言。通过对80后、90后的了解，其实他们做出来的东西不得不服，有时他们不听话但却做得很好，而听话的那部分人或许做的很差，这就是80后、90后这一批人很明显的特点。</font></span></div><div style='line-height: 150%; text-indent: 20.25pt; layout-grid-mode: char'>&nbsp;</div><div style='line-height: 150%; text-indent: 20.25pt; layout-grid-mode: char'><span style='line-height: 150%; font-size: 10.5pt'><font face='宋体'>有删节，详细新闻请链接：http://finance.sina.com.cn/focus/zgqylxnh2010/index.shtml</font></span></div>");
			
			//正文内容
			entity.setContent(stff.toString());
		    //创建人工号
			entity.setCreateUserCode("235210");
		    //创建人
			entity.setCreateUserName("申粤湘 ");
			int row = announceService.insert(entity);
			System.out.println(row);
		}
	}
	
	@Test
	public void update(){
		AnnounceEntity entity = new AnnounceEntity();
		String id = "036fd813-a23e-4829-9ba1-a0ed3aab1db3";
		Date updateDate = new Date();
		entity.setId(id);
	    //收藏数
		entity.setCollectionNum(3);
	    //阅读数
		entity.setReadNum(6);
	    //点赞数
		entity.setPraiseNum(9);
	    //创建时间
		//entity.setCreateTime(createDate);
		entity.setModifyUserCode("111111");
		entity.setModifyUserName("测试123");
		entity.setModifyTime(updateDate);
		int row = announceService.update(entity);
		System.out.println(row);
	}
	
	@Test
	public void delete(){
		AnnounceEntity entity = new AnnounceEntity();
		String id = "88db12f1-e201-4b43-9709-7d8dce7acb9c";
		entity.setId(id);
		int row = announceService.delete(id);
		System.out.println(row);
	}
	
	@Test
	public void queryCommonAll(){
		int limit=20,start=0;
		AnnounceDto queryParam = new AnnounceDto();
		queryParam.setType(ConstansUtil.LEADER_NOTES);
		List<AnnounceEntity> list = announceService.queryCommonAll(limit,start,queryParam);
		System.out.println(list.get(0).getContent());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Calendar date = Calendar.getInstance();
		String beginDate = sdf.format(date.getTime());
		System.out.println(beginDate);
		date.add(Calendar.DATE, -1);  
		
		String dateStr = sdf.format(date.getTime());
		System.out.println(dateStr);
	}
	
	@Test
	public void queryCommonCount(){
		AnnounceDto queryParam = new AnnounceDto();
		queryParam.setType("NEWS");
		Long count = announceService.queryCommonCount(queryParam);
		System.out.println(count);
	}

	
	@Test
	public void queryCommonOne(){
		String id = "020829bc-b261-4a9b-ad5d-050cd0f47b7b";
		AnnounceEntity entity = announceService.queryCommonOne(id);
		System.out.println(entity);
	}
	
	@Test
	public void updateAnnounceState(){
		AnnounceDto dto = new AnnounceDto();
		String id = "4a0c2f22-8535-48d9-a26a-8b169564d4de";
		String userId = "1578621";
		String optType = ConstansUtil.OPERATE_CANCEL;
		String type = ConstansUtil.READ;
		dto.setId(id);
		dto.setUserId(userId);
		dto.setOptType(optType);
		dto.setType(type);
		int row = announceService.updateAnnounceState(dto);
		System.out.println(row);
	}
	
	@Test
	public void queryDetialRead(){
		String id = "4a0c2f22-8535-48d9-a26a-8b169564d4de";
		String userId = "1578621";
		AnnounceEntity entity = announceService.queryDetialRead(id, userId);
		System.out.println(entity.toString());
	}
	
	@Test
	public void queryNormalNews(){
		int limit = 10,start = 0;
		List<AnnounceEntity> list = announceService.queryNormalNews(limit, start);
		for(AnnounceEntity entity : list){
			String oaId = entity.getOaId();
			System.out.println(oaId);
		}
	}
	
	@Test
	public void queryScrollNews(){
		List<AnnounceEntity> list = announceService.queryScrollNews();
		for(AnnounceEntity entity : list){
			String oaId = entity.getOaId();
			System.out.println(oaId);
		}
	}
	
	@Test
	public void getSearchResult(){
		int limit = 10;
		int start = 0;
		String searchString = "测试";
		List<AnnounceEntity> list = announceService.getSearchResult(searchString, limit, start);
		System.out.println(list.size());
	}
	
	@Test
	public void getDetailSearchResultByAnnounceId(){
		String searchString = "测试";
		String announceId = "d19ac6a5-8d33-42e5-9b77-25d20d434368";
		String userId = "1390057";
		AnnounceEntity entity = announceService.getDetailSearchResultByAnnounceId(searchString, announceId, userId);
		System.out.println(entity);
	}
}
