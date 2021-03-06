﻿﻿/**********************************************************************/
/* Author: Yu Luo*/
/* 德邦物流FOSS系统框架*/
/**/
/*所有ID以及class名请勿随意更换，需更换请同事更换CSS文件内响应代码*/
/*对应CSS文件：*/
/*			rsc/css/frame-all-4_1-customized.css (所有自定义ID及class的相关定义)*/
/*			rsc/css/frame-all-4_1.css	(所有extjs原有class(x-开头)的相关定义)*、
/*自定义CSS class请勿使用x-开头*/
/*暂定页面转跳与tabID绑定，即：
/*			主菜单(mainNav)内 href为'#!'开头,URL内容可包括字母数字下划线以及'/',不可用'-'。如果需要使用全屏请在结尾附加'_fullScreen字段' */
/*			打开该页时handler会剔除'#!'*,用'-'复写'/',并在开头加'T_'字段生成 Tab ID, 如末尾字段为'_fullScreen'则改动isFullScreen变量。 */
/*			Loader会在根目录下寻找[$href(剔除#!)].html*/
/**********************************************************************/

/*-----------------------------全局属性与方法定义--------------------------------*/
//当前页面是否使用全屏（菜单上收）
var isFullScreen=false;
var prevIsFullScreen=false;
//root专用 CSS class,在展开状态下height=0，请谨慎使用。
var lvl0Style="ye1-node-lvl0";
//生成当前日期
function constructDateTime(today){
	var dd = today.getDate(),
		mm = today.getMonth()+1, //January is 0!
		yyyy = today.getFullYear(),
		hh = today.getHours(),
		minutes = today.getMinutes(),
		ss=today.getSeconds();
	if(dd<10){dd='0'+dd;} 
	if(mm<10){mm='0'+mm;} 
	if(hh<10){hh='0'+hh;}
	if(minutes<10){minutes='0'+minutes;}
	if(ss<10){ss='0'+ss;}
	today = yyyy+'-'+mm+'-'+dd+' '+hh+':'+minutes+':'+ss;
	return today;
}

//页面滚轮事件handler
function onScroll(){
	//确认主菜单是否算在宽度内
	var hasNav=1;
	if(isFullScreen===true){
		hasNav=0;
	}
	//当前标签页
	var curTab=Ext.getCmp('mainAreaPanel').getActiveTab();
	//header高度
	var frameTopHeight=Ext.getCmp('FrameTop').getHeight();
	//标签页的悬浮工具条
	var curToolbarID=curTab.id;
	var curToolbar=Ext.getCmp(curToolbarID+'_toolbar');
	var sTop=window.pageYOffset|document.documentElement.scrollTop;
	if(curToolbar){
		hasToolbar=1;
	}
	//标签页悬浮工具条位置控制：
	if(sTop>(frameTopHeight+113)){
		if(curToolbar){
			curToolbar.el.dom.style.position='fixed';
			curToolbar.el.dom.style.top='0px';
			curToolbar.el.dom.style.left=((186*(hasNav))+6)+'px';
			curToolbar.el.dom.style.zIndex=30;
		}
	}else{	
		if(curToolbar){
			curToolbar.el.dom.style.position='absolute';
			curToolbar.el.dom.style.top='18px';
			curToolbar.el.dom.style.left='0px';
			curToolbar.el.dom.style.zIndex=5;
		}
	}
	if(!login.dev){
		if(Ext.isEmpty(login.messageBox)){
			return;
		}
		var msgStyle = login.messageBox.el.dom.style;
		msgStyle.setProperty("position", "fixed", "important");
		msgStyle.bottom='0px';
	}
}
//弹出新窗口
function openMsgMenu(id,title,url,winFormType){
	login.msg.msgRemindWindow.hide();
	addTab(id,title,url);
}
//更新弹出框数据
function updateMsgData(){
	Ext.Ajax.request({
		url : '../common/queryMsgTotal.action', 
		async: false,
		success : function(response) {
			var result = Ext.decode(response.responseText);
			
			var normalMsgList = result.msgVo.normalMsgList;
			var msgVo=result.msgVo;
			var netMsgList = msgVo.netMsgList;
			var toDoMsgList = msgVo.toDoMsgList;
			
			var noDealTotal=msgVo.noDealtotal;
			var collectionMsgList=msgVo.collectionMsgList
			var showMessagePanel = login.msg.msgRemindWindow.getShowMessagesPanel();
			
			showMessagePanel.getToDoMsgGrid().store.loadData(toDoMsgList);
			showMessagePanel.getNormalMsgGrid().store.loadData(normalMsgList);
			showMessagePanel.getNetMsgGrid().store.loadData(netMsgList);
			showMessagePanel.getCollectionMsgGrid().store.loadData(collectionMsgList);
			
			var text = '<span style="font-size: 22px; font-weight: bold;">'+noDealTotal+'</span><b>'+login.i18n('foss.login.app.noReadNotice')+'</b>';
			var announce=Ext.getCmp('M_announce');
			if(announce){
				announce.setText(text);
			}else{
				setTimeout(function(){
					var announce=Ext.getCmp('M_announce');
					if(announce){
						announce.setText(text);
					}
		   	 	}, 1000 )
			}
		},
		exception : function(response) {
			var result = Ext.decode(response.responseText);
			Ext.MessageBox.alert(login.i18n('foss.login.app.prompt'), result.message);
		}
	});
}
//弹出框口时间间隔设置页面
Ext.define('Foss.main.opAlertSettingForm',{
	extend:'Ext.form.Panel',
	defaults:{
		margin :'5 5 5 0', 
		colspan :1 
	},
	defaultType:'textfield',
	layout:{
		type :'table',
		columns : 2
	},
	items:[{	
		name:'id',
		hidden:true
	},{	
		xtype: 'numberfield',
		name:'intervalTime',
		fieldLabel:login.i18n('foss.login.app.popupInterval'), 
		value:10,
		allowBlank: false,
		allowDecimals:false, 
        minValue: 8 ,
        maxValue: 90
	},{
		xtype: 'displayfield',
		fieldLabel: '&nbsp;'+login.i18n('foss.login.app.min'),
		labelSeparator:'',
		allowBlank: true
	},{
 		xtype:'radiogroup',
 		fieldLabel:login.i18n('foss.login.app.whetherAutoAlert'),
 		name:'autoAlertFlag',  
 		allowBlank:true,
 		colspan:2,
 		defaultType:'radio',
 		layout:'table',
 		isFormField: true,
 		items:[{
 			boxLabel:login.i18n('foss.login.app.yes'),
 			name:'autoAlertFlag',
 			inputValue:'Y' 
 		},{
 			boxLabel:login.i18n('foss.login.app.no'),
 			name:'autoAlertFlag',
 			inputValue:'N' 
 		}]
  	 }],
  	  bbar: [{
		  text:login.i18n('foss.login.app.cancel'),
		  handler: function(){
			  login.msg.winFormSetting.close();
		  }
	  	},'->',{
			text:login.i18n('foss.login.app.okButton'),
			handler:function(){
				var form = this.up('form').getForm();   
				if(form.isValid()){
					var id=form.findField("id").getValue();  
					var autoAlertFlag=form.getValues().autoAlertFlag; 
					var intervalTime=form.findField("intervalTime").getValue();  
					var userCode=login.currentUser.employee.empCode;
					 //保存弹出框设置项 
					var params={
							'msgVo.winEntity.id' : id,
							'msgVo.winEntity.userCode' : userCode,
							'msgVo.winEntity.intervalTime' : intervalTime,
							'msgVo.winEntity.autoAlertFlag' : autoAlertFlag
					};
//					var url = ContextPath.BSE_BASEINFO + '/common/updateSetting.action';
//					if(login.dev){
						url = '../common/updateSetting.action';
//					}
			        Ext.Ajax.request({
			            url : url,
			            params:params,
			            success : function(response) { 
			              var json = Ext.decode(response.responseText); 
			              Ext.MessageBox.alert(login.i18n('foss.login.app.prompt'), json.message);
			              login.msg.msgRemindWindow.getShowMessagesPanel().changeBottomAreaCheckBox(autoAlertFlag,intervalTime);
			              login.msg.winFormSetting.close();
			            },
			            exception : function(response) {
			              var json = Ext.decode(response.responseText);
			              Ext.MessageBox.alert(login.i18n('foss.login.app.prompt'), json.message);
			              login.msg.winFormSetting.close();
			            }
			        }); 
				}else{
					 Ext.MessageBox.alert(login.i18n('foss.login.app.prompt'),login.i18n('foss.login.app.inputParamerIllegal'));
				}
			}
	  	}]
});


Ext.define('Foss.main.winFormSetting', {
	extend: 'Ext.window.Window', 
	title: login.i18n('foss.login.app.toDoAndSystemMsgConfig'),
	width: 350,
	modal:true,
	closeAction: 'hide',
	settingForm:null,
	getSettingForm: function () {
		if(this.settingForm == null){
			this.settingForm = Ext.create("Foss.main.opAlertSettingForm");
		}
		return this.settingForm;
	},
	bindData: function(autoAlertFlag,id,intervalTime){
		var form = this.getSettingForm().getForm(),
      		groupRadio=form.findField('autoAlertFlag').items;
      	for(var i=0;i<groupRadio.items.length;i++){
      		if(groupRadio.items[i].inputValue==autoAlertFlag){
      			groupRadio.items[i].setValue(true);
      		}else if(groupRadio.items[i].inputValue==autoAlertFlag){
      			groupRadio.items[i].setValue(true);
      		}
      	}
      	form.findField('id').setValue(id);
      	form.findField("intervalTime").setValue(intervalTime);  
	},
	listeners:{
    	beforeshow:function(me){
    		me.getSettingForm().getForm().reset(); 
    	}
    },
	constructor: function(config){
		var me = this,
			cfg = Ext.apply({}, config);
		me.items = [
		    me.getSettingForm()    
		];
		me.callParent([cfg]);
	}
});
login.msg.winFormSetting=Ext.create('Foss.main.winFormSetting');
//设置弹出时间间隔
login.msg.openAlertSetting=function openAlertSettings(){
	var userCode=login.currentUser.employee.empCode;
	 //保存弹出框设置项
	var params={'msgVo':{'winEntity':{'userCode':userCode}}};
    Ext.Ajax.request({
      url : '../common/queryWinFormSettingInfo.action',
      jsonData:params,
      success : function(response) { 
      	var json = Ext.decode(response.responseText); 
      	var form=login.msg.winFormSetting.getSettingForm().getForm();//得到form对象
      	
      	//从后台获取值
       	var winEntity=json.msgVo.winEntity;
      	var id=winEntity.id;
      	var autoAlertFlag=winEntity.autoAlertFlag;
      	var intervalTime=winEntity.intervalTime,
      		win = login.msg.winFormSetting;
      	login.msg.intervalTime=intervalTime;
      	login.msg.remindInterval(autoAlertFlag,login.msg.intervalTime);
      	//窗口弹出
      	win.show();
      	win.bindData(autoAlertFlag,id,intervalTime);
      	
      },
      exception : function(response) {
        var json = Ext.decode(response.responseText);
        Ext.MessageBox.alert(login.i18n('foss.login.app.prompt'), json.message);
      } 
  }); 
}
/**
 * resource的Model
 */
Ext.define('Foss.main.ResourceModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'id'
	}, {
		name : 'code'
	}, {
		name : 'name'
	}, {
		name : 'entryUri'
	}, {
		name : 'resLevel'
	}, {
		name : 'parentRes'
	}, {
		name : 'active'
	}, {
		name : 'displayOrder'
	}, {
		name : 'checked'
	}, {
		name : 'resType'
	}, {
		name : 'leafFlag'
	}, {
		name : 'iconCls'
	}, {
		name : 'cls'
	}, {
		name : 'notes'
	}, {
		name : 'createUser'
	}, {
		name : 'createDate',
		defaultValue : new Date(),
		convert : dateConvert,
		type : 'number'
	}, {
		name : 'modifyUser'
	}, {
		name : 'modifyDate',
		defaultValue : new Date(),
		convert : dateConvert,
		type : 'number'
	} ]
});

//常用功能设置窗口
Ext.define('Foss.main.NavConfigWindow', {
	extend: 'Ext.window.Window',
	title: login.i18n('foss.login.NavConfigWindowTitle'),
	height: 600,
	width: 700,
	modal:true,
	closeAction: 'hide',
	layout: {
		type:'column'
	},
	//菜单树
	resourceTreePanel : null,
	getResourceTreePanel : function(){
		if(this.resourceTreePanel==null){
		    this.resourceTreePanel = Ext.create('Ext.tree.Panel', {
		    	frame: true,
		    	title: login.i18n('foss.login.app.treeMenu'),
		    	width: 250,
		    	height: 470,
		    	animate: true,
		    	useArrows: true,
		    	autoScroll: true,
		        store: Ext.create('Ext.data.TreeStore', {
					root: {
						id: '0',
						text: login.i18n('foss.login.system')
					},
					proxy : {
						type : 'ajax',
						actionMethods : 'POST',
						url : '../login/loadMenuTree.action',
						reader : {
							type : 'json',
							root : 'menuNodes'
						}
					}
			    }),
		        viewConfig: {
		            plugins: {
		            	ddGroup: 'userMenuGrid',
		                ptype: 'treeviewdragdrop',
		                dragText: login.i18n('foss.login.app.userMenuGrid'),
		                containerScroll: true
		            }
		        }
		    });
		}
		return this.resourceTreePanel;
	},
	//用户常用菜单列表
	userMenuGridPanel : null,
	getUserMenuGridPanel : function(){
		if(this.userMenuGridPanel==null){
			Ext.create('Ext.data.Store', {
				model: 'Foss.main.ResourceModel',
			    storeId:'currentDeptStore',
			  	proxy: {
			         type: 'ajax',
			         actionMethods : 'POST',
			         url: '../login/currentUserMeun.action',
			         reader: {
			             type: 'json',
			             root: 'resources'
			         }
			     }
			});
			this.userMenuGridPanel = Ext.create('Ext.grid.Panel', {
				frame: true,
		    	title: login.i18n('foss.login.app.favoriteMenu'),
		    	columnWidth : 1,
		    	height: 470,
		    	autoScroll: true,
		    	viewConfig: {
		            plugins: {
		            	ddGroup: 'resourceTree',
		                ptype: 'gridviewdragdrop',
		                dragText: login.i18n('foss.login.app.resourceTree'),
		                containerScroll: true
		            }
		        },
			    store: Ext.data.StoreManager.lookup('currentDeptStore'),
			    columns: [
			        { header: login.i18n('foss.login.resCode'), dataIndex: 'code' },
			        { header: login.i18n('foss.login.resName'),  dataIndex: 'name', flex: 1 }
			    ]
			});
		}
		return this.userMenuGridPanel;
	},
	constructor: function(config){
		var me = this,
			cfg = Ext.apply({}, config);
		me.items = [me.getResourceTreePanel(),me.getUserMenuGridPanel()];
		me.buttons = [{
	    	text: login.i18n('foss.login.save'),
	    	handler : function(){
	    		var submitData = new Array(); 
	    		me.getUserMenuGridPanel().getStore().each(function(record,index,length){
	    			submitData.push(record.get('code'));
	    		});
//	    		var url = ContextPath.BSE_BASEINFO + '/login/saveUserMenus.action';
//				if(login.dev){
					url = '../login/saveUserMenus.action';
//				}
	    		//Ajax请求保存用户常用菜单设置
	    		Ext.Ajax.request({
	    			url : url,
	    			jsonData: {'userRes': submitData},
	    			//保存成功
	    			success : function(response, opts) {
	    				var result = Ext.decode(response.responseText),
	    					mainNav = Ext.getCmp('mainNav'),
	    					treeStore = mainNav.getStore(),
	    					userMenuNode = mainNav.getRootNode().getChildAt(0);
	    				Ext.ux.Toast.msg(login.i18n('foss.login.messageTitle'), result.message, 'ok', 1000);
	    				//得到菜单树中的常用菜单节点，并进行数据的重新加载
	    				treeStore.load({ 
	    				    node: userMenuNode
	    				});
	    				me.close();
	    			},
	    			//保存失败
	    			exception : function(response, opts) {
	    				var result = Ext.decode(response.responseText);
	    				Ext.MessageBox.show({
	    	                title: login.i18n('foss.login.messageTitle'),
	    	                msg: result.message,
	    	                buttons: Ext.MessageBox.OK,
	    	                icon: Ext.MessageBox.ERROR
	    	            });
	    			}
	    		});
			}
	    }],
		me.listeners = {
			//恢复overflow:auto
			/*beforeclose:function(){
				document.documentElement.style.overflow='auto';
				document.body.style.overflow='auto';
			},*/
			boxready: function(){
				var userMenuGridPanel = me.getUserMenuGridPanel(),
					resourceTreePanel = me.getResourceTreePanel(),
		    		userMenuGridPanelDropTargetEl = userMenuGridPanel.body.dom,
		    		resourceTreePanelDropTargetEl = resourceTreePanel.body.dom,
		    		expend = function(parentNode,selectedRecord,parentCode,userMenuGridPanel){
						parentNode.expand(false,function(){
			            	var length = parentNode.childNodes.length,
			            	displayOrder = selectedRecord.get('displayOrder')==0?0:selectedRecord.get('displayOrder')-1,
			            	index = length;
			            	if(parentNode.data.leaf){
			            		parentNode.data.leaf = false;
			            	}
			            	var node = {
			            			'id': selectedRecord.get('code'),
			            			'text': selectedRecord.get('name'),
			            			'leaf': true,
			            			'parentId': parentCode,
			            			'entity': selectedRecord.data
			            	};
			            	if(length>displayOrder){
			            		index = displayOrder;
			            	}
			            	parentNode.insertChild(index, node );
			            	parentNode.getChildAt(index).raw = node;
			            	userMenuGridPanel.getStore().remove(selectedRecord);			            	
			            });
					};
			    Ext.create('Ext.dd.DropTarget', userMenuGridPanelDropTargetEl, {
			        ddGroup: 'userMenuGrid',
			        notifyEnter: function(ddSource, e, data) {
			        	userMenuGridPanel.body.stopAnimation();
			        	userMenuGridPanel.body.highlight();
			        },
			        notifyDrop  : function(ddSource, e, data){
			            var node = ddSource.dragData.records[0],
			            	parentNode = node.parentNode,
			            	record;
			            if(!node.isLeaf()){
			            	Ext.ux.Toast.msg(login.i18n('foss.login.messageTitle'),login.i18n('foss.login.nonLeafNodesOfTheNode'), 'error', 1000);
			            	return false;
			            }
			            record = Ext.ModelManager.create(node.raw.entity, 'Foss.main.ResourceModel');
			            userMenuGridPanel.getStore().insert(0,record);
			            parentNode.removeChild(node);
			            return true;
			        }
			    });
			    Ext.create('Ext.dd.DropTarget', resourceTreePanelDropTargetEl, {
			        ddGroup: 'resourceTree',
			        notifyEnter: function(ddSource, e, data) {
			        	userMenuGridPanel.body.stopAnimation();
			        	userMenuGridPanel.body.highlight();
			        },
			        notifyDrop  : function(ddSource, e, data){
			            var selectedRecord = ddSource.dragData.records[0],
			            	treeStore = resourceTreePanel.getStore(),
			            	parentCode = selectedRecord.get('parentRes').code;
			            var parentNode = treeStore.getNodeById(parentCode);
			            //如果异步树节点未加载完成，那么就要请求后台，把树展开到这个节点下
			            if(typeof(parentNode) == "undefined" || parentNode == null){
			            	//Ajax请求树的展开路径
			        		Ext.Ajax.request({
			        			url: '../login/expendTreePath.action',
			        			async: false,
			        			params : {
			        				'node' : parentCode
			        			},
			        			//得到路径成功
			        			success : function(response, opts) {
			        				var result = Ext.decode(response.responseText);
			        					resourceTreePanel.expandPath(result.path,'id','/',function(){
			        						parentNode = treeStore.getNodeById(parentCode);
			        						expend(parentNode,selectedRecord,parentCode,userMenuGridPanel);
			        					});
			        			},
			        			//得到路径失败
			        			exception : function(response, opts) {
			        				var result = Ext.decode(response.responseText);
			        				Ext.MessageBox.show({
			        	                title: login.i18n('foss.login.messageTitle'),
			        	                msg: result.message,
			        	                buttons: Ext.MessageBox.OK,
			        	                icon: Ext.MessageBox.ERROR
			        	            });
			        			}
			        		});
			            }else{
			            	expend(parentNode,selectedRecord,parentCode,userMenuGridPanel);
			            }
			            return true;
			        }
			    });
			}
		},
		me.callParent([cfg]);
	}
});

Ext.define('Foss.main.CurrentUserInfoForm',{
	extend: 'Ext.form.Panel',
	frame: true,
	defaultType : 'textfield',
	layout:'column',
	defaults: {
		readOnly : true,
		margin:'5 5 5 5',
		columnWidth:.5,
		labelWidth: 80
	},
	initComponent: function(config){
		var me = this,
				cfg = Ext.apply({}, config);
		me.items = [{
			name: 'empCode',
		    fieldLabel: login.i18n('foss.baseinfo.jobNumber')
		},{
			name: 'empName',
		    fieldLabel: login.i18n('foss.baseinfo.employeeName')
		},{
			name: 'unifieldCode',
		    fieldLabel: login.i18n('foss.baseinfo.orgName')
		},{
			name: 'title',
		    fieldLabel: login.i18n('foss.baseinfo.position')
		},{
			name: 'phone',
		    fieldLabel: login.i18n('foss.baseinfo.phoneCode')
		},{
			xtype: 'datefield',
			format: 'Y-m-d',
			name: 'entryDate',
		    fieldLabel: login.i18n('foss.baseinfo.entryDate')
		},{
			name: 'mobilePhone',
		    fieldLabel: login.i18n('foss.baseinfo.customer.phoneNo')
		},{
			name: 'email',
		    fieldLabel: login.i18n('foss.baseinfo.electronicMailBox')
		},{
			name: 'password',
			inputType: 'password',
			readOnly: false,
			allowBlank: false,
		    fieldLabel: login.i18n('foss.login.loginPassword')
		},{},{
			name: 'newPassword',
			allowBlank: false,
			inputType: 'password',
			readOnly : false,
		    fieldLabel: login.i18n('foss.login.newPassword')
		},{
			name: 'checkPassword',
			allowBlank: false,
			inputType: 'password',
			readOnly : false,
		    fieldLabel: login.i18n('foss.login.checkPassword')
		}];
	  	me.callParent([cfg]);
	}
});

//当前用户信息的窗口
Ext.define('Foss.main.CurrentUserInfoWindow', {
	extend: 'Ext.window.Window',
	title: login.i18n('foss.login.CurrentUserInfoWindowTitle'),
	height: 350,
	width: 600,
	modal:true,
	closeAction: 'hide',
	currentUserInfoForm: null,
	getCurrentUserInfoForm: function(){
		var me = this;
		if(me.currentUserInfoForm==null){
			me.currentUserInfoForm = Ext.create('Foss.main.CurrentUserInfoForm');
		}
		return me.currentUserInfoForm;
	},
	updatePasswordButton : null,
	getUpdatePasswordButton:function(){
		var me = this;
		if(me.updatePasswordButton==null){
			me.updatePasswordButton = Ext.create('Ext.button.Button',{
				cls:'yellow_button',
				text: login.i18n('foss.login.updatePassword'),
				handler: function(){
					var form = me.getCurrentUserInfoForm().getForm(),
						password = form.findField('password').getValue(),
						checkPassword = form.findField('checkPassword').getValue(),
						newPassword = form.findField('newPassword').getValue(),
						currentUser = FossUserContext.getCurrentUser();
					//验证密码是否为空
					if(me.getCurrentUserInfoForm().getForm().isValid()){
						//两次输入的密码不一样
						if(newPassword!=checkPassword){
							Ext.ux.Toast.msg(login.i18n('foss.login.messageTitle'),login.i18n('foss.login.twoPasswordNotSame'), 'error', 1000);
							return;
						}
						//Ajax验证登录密码是否正确
						Ext.Ajax.request({
							url: '../login/validatePassword.action',
							method: 'POST',
							params : {
								'newPassword' : password
							},
							success : function(response, opts) {
//								var url = ContextPath.BSE_BASEINFO +'/login/updateCurrentUserPassword.action';
//								if(login.dev){
									url = '../login/updateCurrentUserPassword.action';
//								}
								//Ajax请求修改当前用户密码
								Ext.Ajax.request({
									url: url,
									method: 'POST',
									params : {
										'newPassword' : newPassword
									},
									success : function(response, opts) {
										var result = Ext.decode(response.responseText);
										//设置当前登录用户的密码信息
										login.currentUser.password = result.newPassword;
										Ext.ux.Toast.msg(login.i18n('foss.login.messageTitle'),login.i18n('foss.login.updatePasswordSuc'), 1000);
										me.hide();
									},
									exception: function(response, opts){
										Ext.ux.Toast.msg(login.i18n('foss.login.messageTitle'),login.i18n('foss.login.passwordError'), 'error', 1000);
									}
								});	
							},
							exception: function(response, opts){
								var result = Ext.decode(response.responseText);
								Ext.ux.Toast.msg(login.i18n('foss.login.messageTitle'),result.message, 'error', 1000);
							}
						});	
					}else{
						Ext.ux.Toast.msg(login.i18n('foss.login.messageTitle'),login.i18n('foss.login.mustInput'), 'error', 1000);
						return;
					}
				}
			});
		}
		return me.updatePasswordButton;
	},
	closeButton : null,
	getCloseButton:function(){
		var me = this;
		if(me.cancelButton==null){
			me.cancelButton = Ext.create('Ext.button.Button',{
				text: login.i18n('foss.login.closeTabText'),
				handler: function(){
					me.hide();
				}
			});
		}
		return me.cancelButton;
	},
	constructor: function(config){
		var me = this,
			cfg = Ext.apply({}, config);
		me.items = [me.getCurrentUserInfoForm()];
		me.buttons = [me.getCloseButton(me),'->',me.getUpdatePasswordButton()];
		me.callParent([cfg]);
	}
});

//切换部门的窗口
Ext.define('Foss.main.CurrentDeptChangeWindow', {
	extend: 'Ext.window.Window',
	title: login.i18n('foss.login.CurrentDeptChangeWindowTitle'),
	height: 400,
	width: 600,
	modal:true,
	closeAction: 'hide',
	layout: {
		type:'vbox',
		padding:'5',
		align:'stretch'
	},
	//部门搜索框
	searchDept : null,
	getSearchDept : function(){
		var me = this;
		if(this.searchDept==null){
			this.searchDept=Ext.create('Ext.form.Panel', {
								labelWidth: 75,
								frame: false,
								height:30,
								layout:'column',
								margin : '0 0 5 0',
								items: [{
									xtype: 'textfield',
									name: 'deptName',
									columnWidth : .5,
									margin : '2 0 0 0',
									allowBlank: true,
									emptyText: login.i18n('foss.login.deptName'),
									anchor: '-250 100%'
    							},{
    								border: false,
    								xtype: 'container',
    								columnWidth: .2,
    								defaults: {
    									margin : '0 0 0 10'
    								},
    								items : [{
    									xtype : 'button',
    									width: 80,
    									cls : 'yellow_button',
    									text : login.i18n('foss.login.query'),//'查询',foss.login.query
    									handler : function(){
    										me.getDeptGridPanel().getStore().load();
    									}
    								} ]
    							}]
							});
		}
		return this.searchDept;
	},
	doChangeCurrentDept: function(deptCode){
		//Ajax请求logout
		Ext.Ajax.request({
			url : '../login/changeCurrentDept.action',
			params : {
				'currenUserDeptCode' : deptCode
			},
			//切换部门成功
			success : function(response, opts) {
				window.location = '../login/index.action';
			},
			//切换部门失败
			exception : function(response, opts) {
				var result = Ext.decode(response.responseText);
				Ext.MessageBox.show({
	                title: login.i18n('foss.login.messageTitle'),
	                msg: result.message,
	                buttons: Ext.MessageBox.OK,
	                icon: Ext.MessageBox.ERROR
	            });
			}
		});
	},
	//部门列表
	deptGridPanel : null,
	getDeptGridPanel : function(){
		var me = this;
		if(this.deptGridPanel==null){
			Ext.create('Ext.data.Store', {
				autoLoad: true,
			    storeId:'currentDeptStore',
			    pageSize: 10,
			    fields: ['code', 'name'],
			  	proxy: {
			         type: 'ajax',
			         actionMethods : 'POST',
			         url: '../login/currentUserChangeDepts.action',
			         reader: {
			             type: 'json',
			             root: 'userManagerDepts',
			             totalProperty: 'totalCount'
			         }
			     },
			     listeners: {
			    	 'beforeload': function(store, operation, eOpts){ 
			        	var queryParams = me.getSearchDept().getForm().getValues();
						Ext.apply(operation, {
							params : {
								'deptName' : queryParams.deptName
							}
						});
			         }
			     }
			});
			this.deptGridPanel = Ext.create('Ext.grid.Panel', {
				height: 270,
				autoScroll: true,
			    store: Ext.data.StoreManager.lookup('currentDeptStore'),
			    selModel: Ext.create('Ext.selection.RadioModel'),
			    columns: [
			        { header: login.i18n('foss.login.deptCode'), dataIndex: 'code' },
			        { header: login.i18n('foss.login.deptName'),  dataIndex: 'name', flex: 1 }
			    ],
			    listeners: {
			    	'itemdblclick': function(view, record, item, index, e, eOpts){
			    		me.doChangeCurrentDept(record.get('code'));
			    	}
			    },
			    bbar: Ext.create('Deppon.StandardPaging',{
					store: Ext.data.StoreManager.lookup('currentDeptStore')
				})
			});
		}
		return this.deptGridPanel;
	},
	//listeners:{
		//恢复overflow:auto
		/*beforeclose:function(){
			document.documentElement.style.overflow='auto';
			document.body.style.overflow='auto';
		}*/			
	//},
	constructor: function(config){
		var me = this,
			cfg = Ext.apply({}, config);
		me.items = [me.getSearchDept(),me.getDeptGridPanel()];
		me.buttons = [{ 
	    	text: login.i18n('foss.login.changeDept'),
	    	margin: '-3 0 0 0',
	    	handler : function(){
	    		var selects = me.getDeptGridPanel().getSelectionModel().getSelection();
	    		if(selects&&selects.length>0){
	    			var record = selects[0];
	    			me.doChangeCurrentDept(record.get('code'));
	    		}
			}
	    }];
		me.callParent([cfg]);
	}
});

/*-----------------------------页面的头部中的工具栏--------------------------------*/
Ext.define('Foss.main.Toptoolbar', {
	extend: 'Ext.container.Container',
	height:36,
	id:"FrameToolbar",
	bodyBorder:false,
	layout:'hbox',
	
	//左右德邦标识预留空间
	logoSpace: null,
	getLogoSpace : function(){
		if(this.logoSpace==null){
			this.logoSpace = Ext.create('Ext.panel.Panel',{
								width:1020,
								height:36,
								id:'tabPageLogo',
								autoDestroy:false
							});
		}
		return this.logoSpace;
	},
	//通知按钮
	announceLink: null,
	getAnnounceLink : function(){
		//var me = this;
		if(this.announceLink==null){
			this.announceLink = Ext.create('Ext.Button', {
									width:130,
									height:36,
									text: '<span style="font-size: 22px; font-weight: bold;">0 </span><b>'+login.i18n('foss.login.app.noReadNotice')+'</b>', 
									id:'M_announce',
									cls:'announceLinkButton',
									handler: this.toggleAnnounce,
									autoScroll: false	
								});
		}
		return this.announceLink;
	},
	//展开\关闭通知面板
	toggleAnnounce : function(){
		scroll(0,0);
		login.msg.msgRemindWindow.show();
	},
	//返回主页按钮
	homeLink : null,
	getHomeLink : function(){
		var me = this;
		if(this.homeLink==null){
			this.homeLink = Ext.create('Ext.Button', {
								width:70,
								height:36,
								text: login.i18n('foss.login.homeLink'), 
								id:'M_home',
								cls:'homeButton',
								handler: me.onHomeLinkClick,
								autoScroll: false						
							});
		}
		return this.homeLink;
	},
	//主页按钮Handler
	onHomeLinkClick : function(arg){
		var tabPanel = Ext.getCmp('mainAreaPanel');
		scroll(0,0);
		var TabID='#T_';
		for (var j=2; j<arg['id'].length; j++){
			TabID=TabID+arg['id'][j];
		}
		var newActiveTab=tabPanel.child(TabID);
		tabPanel.setActiveTab(newActiveTab);
	},
	//设置常用功能按钮
	navConfigLink : null,
	getNavConfigLink : function(){
		var me = this;
		if(this.navConfigLink==null){
			this.navConfigLink = Ext.create('Ext.Button', {
									width:115,
									height:36,
									text: login.i18n('foss.login.NavConfigWindowTitle'), 
									id:'M_navConfig',
									cls:'navLinkButton',
									handler: me.openNavConfig,
									autoScroll: false	
								});
		
		}
		return this.navConfigLink;
	},
	//常用功能设置窗口
	navConfigWindow : null,
	//常用功能设置Handler
	openNavConfig : function(){
		scroll(0,0);
		var me = this;
		if(me.navConfigWindow == null){
			me.navConfigWindow = Ext.create('Foss.main.NavConfigWindow');
		}
		var tree = me.navConfigWindow.getResourceTreePanel(),
			treeStore = tree.getStore();
		treeStore.load({ 
		    node: treeStore.getRootNode()
		});
		me.navConfigWindow.getUserMenuGridPanel().getStore().load(function(records, operation, success) {
			if(success==true){
				me.navConfigWindow.show();				
			}
		});
		//console.log(window);
		//console.log(document.getElementsByTagName('HTML'));
		//console.log(Ext.getBody());
		//锁定背景overflow(跨浏览器：FF IE Chrome)
		//document.body.style.overflow='hidden';
		//document.documentElement.style.overflow='hidden';
		//document.getElementsByTagName('HTML').style.overflow='hidden';
	},
	//搜索框
	searchSpace : null,
	getSearchSpace : function(){
		var me = this;
		if(me.searchSpace == null){
			me.searchSpance = Ext.create('Ext.form.Panel', {
								width: 200,
								id: 'searchSpace',
								frame: false,
								height:36,
								layout:'column',
								items: [{
									xtype: 'textfield',
									name: 'comp_search',
									id: 'comp_search',
									allowBlank: true,
									vtype: 'waybill',
									emptyText: login.i18n('foss.login.searchSpace'),
									width: 140,
									listeners: {
							        	specialkey: function(field, e){
							        		var button = Ext.getCmp('comp_search_button');
						                    if (e.getKey() == e.ENTER) {
						                    	button.handler();
						                    }
						                }
							        }
    							},{
									xtype: 'button',
									id: 'comp_search_button',
									width: 35,
									height:36,
									handler: function(){
										if(login.dev){
											return;
										}
										var	searchSpaceForm = this.up('form').getForm(),
											compSearch = searchSpaceForm.findField('comp_search');
										removeTab('T_querying-integrativeQueryIndex');
										addTab('T_querying-integrativeQueryIndex', '综合信息查询', 
												ContextPath.BSE_QUERYING+'/querying/integrativeQueryIndex.action?fullScreen=true', {
												'waybillNumber': compSearch.getValue()
											});
									}
    							}]
							});
		}
		return me.searchSpance;
	},
	//用户名空间
	userInfoSpace : null,
	getUserInfoSpace : function(){
		var me = this;
		if(me.userInfoSpace==null){
			me.userInfoSpace = Ext.create('Ext.Button', {
							 		id: 'userInfoSpace',
						 			width:95,
									height:36,
									text: '',
									textAlign:'left',
									//cls:'frametoolbar_content',
									handler: function(){
										//me.onGetUserInfo(true);
										me.onGetUserInfo();
									}
						 		});
		}
		return me.userInfoSpace;
	},
	onGetUserInfo: function(){
		scroll(0,0);
		var me = this;
		if(me.currentUserInfoWindow == null){
			me.currentUserInfoWindow = Ext.create('Foss.main.CurrentUserInfoWindow');
		}
		//me.currentUserInfoWindow.closable = closable;
		//me.currentUserInfoWindow.getCloseButton().setVisible(closable);
		var	form = me.currentUserInfoWindow.getCurrentUserInfoForm().getForm(),
			emp = FossUserContext.getCurrentUserEmp(),
			dept = FossUserContext.getCurrentUserDept();
		form.reset();
		form.setValues(emp);
		form.findField('title').setValue(FossDataDictionary.rendererSubmitToDisplay(emp.title,'UUMS_POSITION'));;
		form.findField('unifieldCode').setValue(dept.name);
		if(emp.entryDate!=null){
			form.findField('entryDate').setValue(new Date(emp.entryDate));			
		}
		me.currentUserInfoWindow.show();		    	
		//锁定背景overflow(跨浏览器：FF IE Chrome)
		/*document.body.style.overflow='hidden';
		document.documentElement.style.overflow='hidden';*/
	},
	//用户所属部门空间
	userDepartSpace : null,
	getUserDepartSpace : function(){
		var me = this;
		if(this.userDepartSpace==null){
			this.userDepartSpace = Ext.create('Ext.Button', {
									flex: 1,
									id: 'userDepartSpace',
									text: '',
									textAlign:'left',
									height: 36,
									padding: '0 20 0 0',
									handler: me.onChangeUserDeptSpace
								});
		}
		return this.userDepartSpace;
	},
	//切换当前部门
	currentDeptChangeWindow : null,
	//常用功能设置Handler
	onChangeUserDeptSpace : function(){
		scroll(0,0);
		var me = this;
		if(me.currentDeptChangeWindow == null){
			me.currentDeptChangeWindow = Ext.create('Foss.main.CurrentDeptChangeWindow');
		}
		me.currentDeptChangeWindow.show();		    	
		//锁定背景overflow(跨浏览器：FF IE Chrome)
		/*document.body.style.overflow='hidden';
		document.documentElement.style.overflow='hidden';*/
	},
	//当前时间
	dateTimeSpace: null,
	getDateTimeSpace: function(){
		if(this.dateTimeSpace==null){
			var htmlText = "";
			if(!Ext.isEmpty(login.currentServerTime)){
				htmlText = constructDateTime(login.currentServerTime)
			}
			this.dateTimeSpace =Ext.create('Ext.panel.Panel',{
							 		id: 'dateTimeSpace',
						 			width: 120,
									height: 36,
									html: htmlText,
									cls: 'frametoolbar_content'
						 		});
		}
		return this.dateTimeSpace;
	},
	//问题上报
	questionReport : null,
	getQuestionReport : function(){
		var me = this;
		if(this.questionReport==null){
			this.questionReport = Ext.create('Ext.Button',{
							width:60,
							height:36,
							text:'',
							id:'Q_Report',
							autoScroll: false,
							handler: me.questionReportHandler,
							scope: me
						});
		}
		return this.questionReport;
	},
	openWindowWithPost: function(url, name, params) {
        var form = document.createElement("form");
        form.setAttribute("method", "post");
        form.setAttribute("action", url);
        form.setAttribute("target", name);
        for ( var i in params) {
	        if (params.hasOwnProperty(i)) {
                var input = document.createElement('input');
                input.type = 'hidden';
                input.name = i;
                input.value = params[i];
                form.appendChild(input);
	        }
        }
        document.body.appendChild(form);
        window.open('about:blank', name);
        form.submit();
        document.body.removeChild(form);
	},
	questionReportHandler: function() {
		// 问题上报 最新传参：工号 功能模块 所属子系统 系统标签(FOSS)
		var me = this;
		try {
			var currentEmp = FossUserContext.getCurrentUserEmp(),
				reporterCode = currentEmp.empCode,
				webProject = location.pathname.split("/")[1],
				curTab = Ext.getCmp('mainAreaPanel').getActiveTab(),
				tabLoader = curTab.getLoader(),
				functionModule = curTab.title,
				subSystem, sysHeader, tabLoaderUrl, url;
			if(tabLoader == null) {
				sysHeader = webProject.split('-')[0];
			} else {
				tabLoaderUrl = tabLoader.url;
				sysHeader = tabLoaderUrl.split('/')[1].split('-')[0];
			}

		} catch (e) {
			throw("Parameters are not correct.")
		}
		if(sysHeader != null && sysHeader != "") {
			switch(sysHeader) {
				case "bse":
					subSystem = "综合管理";
					break;
				case "pkp":
					subSystem = "接送货";
					break;
				case "stl":
					subSystem = "结算";
					break;
				case "tfr":
					subSystem = "中转";
					break;
				default:
					subSystem = "主页";
					break;
			};
			me.openWindowWithPost(Deppon.config.Foss.QUESTION_REPORT_URL, "questionReport", {
				system: 'FOSS',
				psnCode: reporterCode,
				subsystem: subSystem,
				moduleName: functionModule
			});
		}
	},
	//登出按钮
	logout : null,
	getLogOut : function(){
		var me = this;
		if(this.logout==null){
			this.logout = Ext.create('Ext.Button',{
							width:55,
							height:36,
							text:'',
							id:'M_logout',
							autoScroll: false,
							handler: me.logoutHandler
						});
		}
		return this.logout;
	},
	logoutHandler : function(){
		Ext.MessageBox.confirm(login.i18n('foss.login.logout'), login.i18n('foss.login.sureLogout'),function(btn){
			if(btn=='yes'){
				Ext.Ajax.request({
					url : '../login/logout.action',
					success : function(response, opts) {
						window.location = '../login/index.action';
					},
					exception : function(response, opts) {
						var result = Ext.decode(response.responseText);
						Ext.MessageBox.show({
							buttons: Ext.MessageBox.OK,
			                msg: result.message,
			                title: login.i18n('foss.login.messageTitle'),
			                icon: Ext.MessageBox.ERROR
			            });
					}
				});
			}
		});
	},
	constructor: function(config){
		var me = this,
			cfg = Ext.apply({}, config);
		me.items = [me.getLogoSpace(),me.getHomeLink(),me.getUserInfoSpace(),me.getLogOut()];
		me.callParent([cfg]);
		me.getUserInfoSpace().setText(FossUserContext.getCurrentUserEmp().empName);
//		me.getUserDepartSpace().setText(FossUserContext.getCurrentDept().name);
	}
});

/*--------------------------------页面的头部---------------------------------------*/
Ext.define('Foss.main.topPanel', {
	extend: 'Ext.container.Container',
//	cls:'autoHeight',
//	bodyCls:'autoHeight',
	id:'dtopPanel',
	//页首德邦标识部分。
	topLogo: null,
	height:95,
	getTopLogo : function(){
		if(this.topLogo==null){
			this.topLogo = Ext.create('Ext.panel.Panel' ,{
				id:"FrameTop",
				bodyBorder:false,
//				height:102,
				height:59
				
			});
		}
		return this.topLogo;
	},
	//整合页首黄色工具栏
	toptoolbar: null,
	getToptoolbar: function(){
		if(this.toptoolbar==null){
			this.toptoolbar = Ext.create('Foss.main.Toptoolbar');
		}
		return this.toptoolbar;
	},
	//header与body之间白条部分。
	whiteStripe: null,
	getWhiteStripe : function(){
		if(this.whiteStripe==null){
			this.whiteStripe = Ext.create('Ext.panel.Panel' ,{
								id: 'w_stripe',
//								height:12,
								height:0,
								html: '<div class="foss_icon_wstripeNavTop"></div>'
									
							});
		}
		return this.whiteStripe;
	},
	constructor: function(config){
		var me = this,
			cfg = Ext.apply({}, config);
		me.items = [me.getTopLogo(),me.getToptoolbar(),me.getWhiteStripe()];
		me.callParent([cfg]);
	}
});

/*----------------------------------主导航-----------------------------------------*/
//定义一个功能菜单store
Ext.define('Foss.main.NavStore', {
	extend: 'Ext.data.TreeStore',
	root: {
		id: '0',
		text: login.i18n('foss.login.system'),
		cls:lvl0Style,
		expanded: true,
		iconCls:'foss_icons_emp'
	},
	proxy : {
		type : 'ajax',
		actionMethods : 'POST',
		url : '../login/loadTree.action',
		reader : {
			type : 'json',
			root : 'nodes'
		}
	},
	listeners: {
	   	'beforeload': function(store, operation, eOpts){
	   		var userMenuNode = store.getRootNode().firstChild;
	   		if(!userMenuNode){
	   			return;
	   		}
	   		if(operation.params.node==userMenuNode.data.id){
	   			Ext.apply(operation.params, {
	   				'checkUserMenu' : true
	   			});	   			
	   		}
	    },
	    'load': function( store, node, records, successful, eOpts ){
	    	if(records){
	    		var domId = 'nodeSpan'+'_'+node.data.id,
	    			dom = Ext.get('nodeSpan'+'_'+node.data.id);
	    		if(records.length==0){
	    			if(!Ext.isEmpty(dom)){
	    				dom.setStyle('display','inline-block');
	    				return;
	    			}
	    			node.data.text = "<span id='nodeSpan"+'_'+node.data.id+"' style='display: inline-block;width:40px;height:0px'>&nbsp;</span>"+node.data.text;
	    			//只有set loaded为ture才可以更新页面
	    			node.set('loaded', true);	    		
	    		}else{
	    			if(!Ext.isEmpty(dom)){
	    				dom.setStyle('display','none');
	    				return;
	    			}
	    		}		
	    	}
	    }
	},
	constructor: function(config){
		var me = this,
			cfg = Ext.apply({}, config);
		me.callParent([cfg]);
	}
});

//定义一个导航树
Ext.define('Foss.main.MainNav', {
	extend: 'Ext.tree.Panel',
	id:'mainNav',//菜单CSS Class以此id为准
	componentCls:'ye1',
	cls:'ye1',
	bodyCls:'ye1-body',
	width:186,
	store:Ext.create('Foss.main.NavStore'),
	rootVisible:false,
	titleCollapse:true,
	animate:true,
	useArrows:true,
	autoScroll:false,
	resTextfield: null,
	getResTextfield: function(){
		var me = this;
		if(this.resTextfield==null){
			this.resTextfield = Ext.create('Ext.form.field.Text',{
				height:25,
				columnWidth: 0.6,
		        emptyText: login.i18n('foss.login.writeFunName'),//'输入功能名',
		        margin:'0 0 0 19',
		        name: 'name',
		        regex:  /^(\w|[\u4E00-\u9FA5])*$/,
		        regexText: login.i18n('foss.login.illegalCharacter'),
		        listeners: {
		        	specialkey: function(field, e){
	                    if (e.getKey() == e.ENTER) {
	                        me.getQueryButton().handler();
	                    }
	                }
		        }
			});
		}
		return this.resTextfield;
	},
	expandNodes: [],
	queryButton: null,
	getQueryButton: function(){
		var me = this;
		if(this.queryButton==null){
			this.queryButton = Ext.create('Ext.button.Button',{ 
		    	height:25,
		    	margin:'0 0 0 3',
		    	columnWidth: 0.3,
		    	text: login.i18n('foss.login.queryMenu'),
		    	handler: function(){
		    		var field = me.getResTextfield(),
		    			queryValue = field.getValue();
		    		if(!field.validate()){
		    			Ext.ux.Toast.msg(login.i18n('foss.login.messageTitle'),login.i18n('foss.login.illegalCharacter'), 'error', 1000);
		    			return;
		    		}
		    		if(!Ext.isEmpty(queryValue)){
		    			//Ajax请求得到所有查询到的节点全路径
		    			Ext.Ajax.request({
		    				url: '../login/queryTreePathForName.action',
		    				async: false,
		    				params : {
		    					'node' : queryValue
		    				},
		    				//得到路径成功
		    				success : function(response, opts) {
		    					var result = Ext.decode(response.responseText),
		    						view = me.getView(),
									position = false,
		    						pathList = result.pathList;
		    					me.expandNodes = [];
		    					me.collapseAll();
		    					if(pathList.length==0){
		    						Ext.ux.Toast.msg(login.i18n('foss.login.messageTitle'),login.i18n('foss.login.notFindMenu'), 'error', 1000);
		    						return;
		    					}
		    					for(var i=0;i<pathList.length;i++){
		    						me.expandPath(pathList[i],'id','/',function(success, lastNode){
		    							if(success){
		    								var nodeHtmlEl = view.getNode(lastNode),
		    									nodeEl = Ext.get(nodeHtmlEl);
		    								if(Ext.isEmpty(nodeEl)){
		    									me.expandNodes.push(lastNode);
		    									return;
		    								}
		    								var divHtmlEl = nodeEl.query('div')[0],
		    								    divEl = Ext.get(divHtmlEl);
		    								divEl.highlight("ff0000", { attr: 'color', duration:10000 });
											if(!position){
												divHtmlEl.scrollIntoView();
												position = true;
											}
		    							}
		    						});	    						
		    					}
		    				},
		    				//得到路径失败
		    				exception : function(response, opts) {
		    					var result = Ext.decode(response.responseText);
		    					Ext.MessageBox.show({
		    						title: login.i18n('foss.login.messageTitle'),
		    						msg: result.message,
		    						buttons: Ext.MessageBox.OK,
		    						icon: Ext.MessageBox.ERROR
		    					});
		    				}
		    			});
		    		}
		    	}
		    });
		}
		return this.queryButton;
	},
	initListeners : function(){
		var mainNav = this;
		mainNav.listeners = {
			//点击主菜单节点：
			itemclick: function(view, node, c, o, e) {			
				view.toggleOnDblClick = false;
				var tabPanel = Ext.getCmp('mainAreaPanel');
				if(node.isLeaf()) {	
					//生成tab相关数据：
					var href=node.raw.uri,
						tID='T_',//tab ID
						//生成tID和tLoc
						str = href.split('#!'),
						tLoc = str[0] + str[1],
						localHref = str[1],
						hrefLength=str[1].length;
					for (var h=0; h<hrefLength; h++){
						if(localHref.charAt(h)!='/'){
							tID=tID+localHref.charAt(h);
						}else{
							tID=tID+'-';
						}
					}
					tID = tID.substring(0, tID.lastIndexOf('.'));
					//console.log(tID);
					//确认该tab是否已经打开：
					var fTab=tabPanel.child('#'+tID);
					//var tabContent=null;
					//如果未打开则添加：
					if(fTab==null){
						addTab(tID, node.data.text, tLoc);
					}else{
						tabPanel.show(fTab);
						tabPanel.setActiveTab(fTab);
					}
				}else{
					view.toggle(node);
				}
			},
			afteritemexpand: function(node, index, item, eOpts){
				var expandNodes = mainNav.expandNodes,
					flag = true,
					view = mainNav.getView();
				if(expandNodes.length==0){
					return;
				}
				for(var i=0;i<expandNodes.length;i++){
					if(expandNodes[i]==null){
						flag = false;
						continue;
					}
					var nodeHtmlEl = mainNav.getView().getNode(expandNodes[i]),
						nodeEl = Ext.get(nodeHtmlEl);
					if(Ext.isEmpty(nodeEl)){
						continue;
					}
					var divHtmlEl = nodeEl.query('div')[0],
					    divEl = Ext.get(divHtmlEl);
					divEl.highlight("ff0000", { attr: 'color', duration: 10000 });
				}
				if(flag){
					mainNav.expandNodes = [];
				}
			}
		};
	},
	constructor: function(config){
		var me = this,
			cfg = Ext.apply({}, config);
		me.dockedItems = [{
		    xtype: 'toolbar',
		    dock: 'top',
		    layout: 'column',
		    id: 'mainNavToolbar',
		    items: []
		}];
		me.initListeners();
		me.callParent([cfg]);
	}
});

/*---------------------------------工作区------------------------------------------*/	
//定义一个标签页
Ext.define('Foss.main.TabPanel', {
	extend: 'Ext.tab.Panel',
	id:"mainAreaPanel",
	columnWidth:1,
	plain:true,
	cls:'autoWidth',
	bodyCls:"tabFrame",
	componentCls:"mainArea",
	params: null,
	//右手overflow下拉插件
	plugins: [{
		ptype: 'tabscrollermenu',
		id:'OFB_menu',
		maxText  : 40,
		pageSize : 100
	},{
		ptype: 'tabclosemenu',
		closeTabText: login.i18n('foss.login.closeTabText'),
		closeOthersTabsText: login.i18n('foss.login.closeOthersTabsText'),
		closeAllTabsText: login.i18n('foss.login.closeAllTabsText')
	}],
	getHomeUrl: function(){
//		var url = ContextPath.BSE_BASEINFO +'/login/home.action';
//		if(login.dev){
			url = '../login/home.action';
//		}
		return url;
	},
	//全屏模式下主导航关闭控制：
	fullScreenNav : function(c){
		//记录点击点
		var mouseX=c.browserEvent.clientX;
		var mouseY=c.browserEvent.clientY;
		//记录页面srollTop
		var sTop=window.pageYOffset|document.documentElement.scrollTop;
		//横向186未固定导航区域
		var areaX=186;
		//计算纵向区域,32为root本身的高度,勿做改动。
		var areaY=Ext.getCmp('mainNav').el.getY()-sTop+Ext.getCmp('mainNav').getHeight()+32;
		//如果超出区域则上收菜单
		if(mouseX>areaX||mouseY>areaY){
			Ext.getCmp('mainNav').getRootNode().collapse();
		}else{
			Ext.getCmp('mainNav').getRootNode().expand();
		}
	},
	initListeners : function(){
		var me = this;
		me.listeners = {
			//关闭前清内存里相应项目
			beforeremove: function(panel, tab){
				//清理组件
				var tabId = tab.id,
					conId = tabId+'_content',
					toolbarId = tabId+'_toolbar';
				//判断是否存在tab的主页面，如果不存在就无需清理
				if(Ext.getCmp(conId)==null){
					return;
				}
				//清空ComponentManager内的注册项
				var cmpArray = Ext.getCmp(conId).removeAll();
				if(Ext.getCmp(toolbarId)!=null){
					var cmpArrayToolbar = Ext.EventManager.removeAll(toolbarId);
					cmpArray = Ext.Array.merge(cmpArray,cmpArrayToolbar);
				}
				//清空store
				for(var i=0;i<cmpArray.length;i++){
					if(cmpArray[i]){
						if(cmpArray[i].store){
							cmpArray[i].store.destroyStore();
							Ext.data.StoreManager.unregister(cmpArray[i].store);
						}						
					}
				}
				cmpArray = null;
				Ext.ComponentManager.unregister(Ext.getCmp(conId));
				if(Ext.getCmp(toolbarId)!=null){
					Ext.ComponentManager.unregister(Ext.getCmp(toolbarId));
				}
				
				//清理模块下变量和方法
				var lineIndex = tabId.lastIndexOf("-"),
					moduleName = tabId.substring(2, lineIndex),
					endIndex = tabId.length,
					pointIndex = tabId.lastIndexOf("."),
					module = eval(moduleName);
				if(pointIndex!=-1){
					endIndex = pointIndex;
				}
				var childmoduleName = conId.substring(lineIndex+1, endIndex);
				if(childmoduleName == "index") {
					if(module != null) {
						 for(var prop in module) {
							 if(!Ext.isObject(prop)) {
								 try{
									 if(module[prop].id){
										 cleanComponent(module[prop].id);
									 }
								 }
								 catch(err){
									 module[prop] = null;
								 }
							 }
						 }
						 module = null;
					}
				} else {
					var childmodule = module[childmoduleName.slice(0, -5)];
					 for(var prop in childmodule) {
						 if(!Ext.isObject(prop)) {
							 try{
								 if(childmodule[prop].id){
									 cleanComponent(childmodule[prop].id);
								 }
							 }
							 catch(err){
								 childmodule[prop] = null;
							 }
						 }
					 }
					 childmodule = null;
				}
			},
			//切换及激活标签页前进行的调整：
			beforetabchange: function(panel, tab){
				return;
				var logoSpace = Ext.getCmp('tabPageLogo');
				scroll(0,0);
				//console.log(tab.id);
				//确认是否使用全屏排版
				var fullScreen = false;
				if(!Ext.isEmpty(tab)&&!Ext.isEmpty(tab.loader)){
					var href=tab.loader.url;
					if(!Ext.isEmpty(href)&&href.indexOf('fullScreen=true')!=-1){
						fullScreen = true;
					}
				}
				//console.log(strFlag);
				if(isFullScreen==true){
					prevIsFullScreen=true;
				}else{
					prevIsFullScreen=false;
				}
				if(fullScreen){
					isFullScreen=true;
				}else{
					isFullScreen=false;
				}
				//找取header备用
				var tP=Ext.getCmp('FrameTop');
				//如果切换到主页
				if (tab.id == 'T_home'){
					tP.animate({
							   to:{
								   height:102
								   }
							   });
					//删除左上小logo;
					logoSpace.removeCls('tabPageLogo');
					//toptoolbar.doLayout();
				//一般页面：
				}else{
					//header隐藏：
					tP.animate({
							   to:{
								   height:0
								   }
							   });
					//添加左上小logo:
					logoSpace.addCls('tabPageLogo');
				}
				var mN=Ext.getCmp('mainNav');
				//全屏模式下：
				if(isFullScreen==true){
					//主导航宽度归0，使tabPanel左移动（主导航依然显示，因为底层element overflow=visible）
					mN.el.dom.style.width=0;
					//上收到root
					mN.getRootNode().collapse();
					if(prevIsFullScreen==false){
						me.setWidth(me.getWidth()+186);
					}
					me.doLayout();
					//tabBar向右移动
					me.tabBar.addClass('tabbarDisplace');
					//主工作区container float定义清空，用浏览器默认。
					Ext.getCmp('container').addClass('clearFloat');
					//添加fullScreenNav handler，在全屏模式下点击主导航外区域会自动关闭主导航。
					Ext.getBody().on('click', me.fullScreenNav);
					//修改查询工具条的上偏移
					Ext.getCmp('mainNavToolbar').el.dom.style.paddingTop='0px';
				//一般模式
				}else{
					//移除fullScreenNav handler以及相关listener
					Ext.getBody().removeListener('click', me.fullScreenNav);
					//重设主导航宽度
					mN.setWidth(186);
					//mN.doLayout;
					//主导航展开
					mN.getRootNode().expand();
					//重设tabPanel宽度（因ExtJS自身的宽度计算机制，这里不做减法。
					me.setWidth(me.getWidth());
					me.doLayout();
					//tabBar归位
					me.tabBar.removeCls('tabbarDisplace');
					//主工作区归位
					Ext.getCmp('container').removeCls('clearFloat');
					//修改查询工具条的上偏移
					Ext.getCmp('mainNavToolbar').el.dom.style.paddingTop='5px';
				}
			}
			//增加tab切换的时候，切入tab页面刷新的方法与切出tab页面清除的方法
			/*'tabchange': function(tabPanel, newCard, oldCard, eOpts){
				var newCardPanel = Ext.getCmp(newCard.id+'_content');
				if(!Ext.isEmpty(newCardPanel)){
					
					console.log(newCardPanel.query('button, menu, checkbox, combo, datefield, timefield, htmleditor, textfield, textarea, radio, numberfield'));
				}
			}*/
		};
	},
	constructor: function(config){
		var me = this,
			cfg = Ext.apply({}, config);
		me.items = [{
			title: login.i18n('foss.login.homeLink'), 
			tabConfig:{width:150}, 
			closable:false,
			id:'T_home', 
			layout:'fit',
			cls: 'autoHeight',
			bodyCls: 'autoHeight',
			loader: {
				scripts: true,
				autoLoad: true,
				url: me.getHomeUrl()
			}
		}];
		me.initListeners();
		me.callParent([cfg]);
	}
});




// /////////////////////////////////////////首次登录待办弹出框配置 START///////////////////////////////////
// 待办事项Model
Ext.define('Foss.main.ToDoMsgModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'id'
	}, {
		name : 'businessType', // 待办类型
		type : 'string'
	}, {
		name : 'noDealNum', // 未处理数量
		type : 'int'
	} ]
});
// 站内消息Model
Ext.define('Foss.main.InstationMsgModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'id'
	}, {
		name : 'msgType', // 待办类型
		type : 'string'
	}, {
		name : 'noDealNum', // 未处理数量
		type : 'int'
	} ]
});

//代收货款Model
Ext.define('Foss.main.CollectionMsgModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'id'
	}, {
		name : 'msgType', // 待办类型
		type : 'string'
	}, {
		name : 'noDealNum', // 未处理数量
		type : 'int'
	} ]
});


// 待办数据Store
Ext.define('Foss.main.ToDoMsgStore', {
	extend : 'Ext.data.Store',
	model : 'Foss.main.ToDoMsgModel'
});

// 站内消息Store
Ext.define('Foss.main.NormalInstationMsgStore', {
	extend : 'Ext.data.Store',
	model : 'Foss.main.InstationMsgModel'
});

// 全网消息Store
Ext.define('Foss.main.NetInstationMsgStore', {
	extend : 'Ext.data.Store',
	model : 'Foss.main.InstationMsgModel'
});



//代收货款Store
Ext.define('Foss.main.CollectionMsgStore', {
	extend : 'Ext.data.Store',
	model : 'Foss.main.CollectionMsgModel'
});

//代收货款在线提醒
Ext.define('Foss.main.CollectionMsgGrid', {
	extend : 'Ext.grid.Panel',
	title : login.i18n('foss.login.app.collectionMsg'),
	store : Ext.create('Foss.main.CollectionMsgStore'),
	columnWidth : 1,
	stripeRows : true,
	columnLines : true,
	collapsible : false,
	bodyCls : 'autoHeight',
	frame : true,
	// 增加表格列的分割线
	cls : 'autoHeight',
	autoScroll : true,
	height : 'autoHeight',
	listeners:{
		itemclick:function(_this, _record, _item, _index, _e, _eOpts ){
			login.msg.msgType = _record.get('msgType');
			openMsgMenu('T_common-instationMsgInit',login.i18n('foss.login.app.instationMsg'),'../common/instationMsgInit.action',null); 
		}
	},
	columns : [ {
		text : login.i18n('foss.login.app.msgType'),
		align : 'center',
		flex : 1,
		dataIndex : 'msgType',
		renderer:function(value){
			return login.i18n('foss.login.app.collectionMsg'); //代收货款（后续优化）
		}
	}, {
		text : login.i18n('foss.login.app.noReadNum'),
		align : 'center',
		flex : 1,
		dataIndex : 'noDealNum'
	} ],
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);
		me.callParent([ cfg ]);
	}
});

// 待办表格
Ext.define('Foss.main.ToDoMsgGrid', {
	extend : 'Ext.grid.Panel',
	title : login.i18n('foss.login.app.toDoItem'),
	store : Ext.create('Foss.main.ToDoMsgStore'),
	columnWidth : 1,
	stripeRows : true,
	columnLines : true,
	collapsible : false,
	bodyCls : 'autoHeight',
	frame : true,
	// 增加表格列的分割线
	cls : 'autoHeight',
	autoScroll : true,
	height : 'autoHeight',
	listeners:{
		itemclick:function(_this, _record, _item, _index, _e, _eOpts ){
			login.msg.bisType = _record.get('businessType');
			openMsgMenu('T_waybill-todoActionIndex',login.i18n('foss.login.app.toDoItem'),ContextPath.PKP_DELIVER+'/waybill/todoActionIndex.action',null); 
		}
	},
	columns : [ {
		text : login.i18n('foss.login.app.businessType'),
		align : 'center',
		flex : 1,
		dataIndex : 'businessType', 
		renderer:function(value){
			var displayField = FossDataDictionary.rendererSubmitToDisplay (value,'TODOMSG__BUSINESS_TYPE');
			return displayField;
		}
	}, {
		text : login.i18n('foss.login.app.noDealNum'),
		align : 'center',
		flex : 1,
		dataIndex : 'noDealNum'
	} ],
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);
		me.callParent([ cfg ]);
	}
});

// 普通消息
Ext.define('Foss.main.NormalInstationMsgGrid', {
	extend : 'Ext.grid.Panel',
	title : login.i18n('foss.login.app.instationMsg'),
	store : Ext.create('Foss.main.NormalInstationMsgStore'),
	columnWidth : 1,
	stripeRows : true,
	columnLines : true,
	collapsible : false,
	bodyCls : 'autoHeight',
	frame : true,
	// 增加表格列的分割线
	cls : 'autoHeight',
	autoScroll : true,
	height : 'autoHeight',
	listeners:{
		itemclick:function(_this, _record, _item, _index, _e, _eOpts ){
			login.msg.msgType = _record.get('msgType');
			openMsgMenu('T_common-instationMsgInit',login.i18n('foss.login.app.instationMsg'),'../common/instationMsgInit.action',null); 
		}
	},
	columns : [ {
		text : login.i18n('foss.login.app.msgType'),
		align : 'center',
		flex : 1,
		dataIndex : 'msgType',
		renderer:function(value){
			var displayField = FossDataDictionary.rendererSubmitToDisplay (value,'MSG_TYPE');
			return displayField;
		}
	}, {
		text : login.i18n('foss.login.app.noReadNum'),
		align : 'center',
		flex : 1,
		dataIndex : 'noDealNum'
	} ],
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);
		me.callParent([ cfg ]);
	}
});

// 全网通知
Ext.define('Foss.main.NetInstationMsgGrid', {
	extend : 'Ext.grid.Panel',
	title : login.i18n('foss.login.app.allNetMsg'),
	store : Ext.create('Foss.main.NetInstationMsgStore'),
	columnWidth : 1,
	stripeRows : true,
	columnLines : true,
	collapsible : false,
	bodyCls : 'autoHeight',
	frame : true,
	// 增加表格列的分割线
	cls : 'autoHeight',
	autoScroll : true,
	height : 'autoHeight',
	listeners:{
		itemclick:function(_this, _record, _item, _index, _e, _eOpts ){
			//login.msg.msgType = _record.get('msgType');
			openMsgMenu('T_querying-acceptNetMsgOnline',login.i18n('foss.login.app.allNetMsg'),ContextPath.BSE_QUERYING + '/querying/acceptNetMsgOnline.action',null); 
		}
	},
	columns : [ {
		text : login.i18n('foss.login.app.msgType'),
		align : 'center',
		flex : 1,
		dataIndex : 'msgType',
		renderer:function(value){
			return login.i18n('foss.login.app.onlineNotification'); //在线通知（后续优化）
		}
	}, {
		text : login.i18n('foss.login.app.noReadNum'),
		align : 'center',
		flex : 1,
		dataIndex : 'noDealNum'
	} ],

	constructor : function(config) {
		var me = this,
			cfg = Ext.apply({}, config); 
		me.callParent([cfg]);
	} 
});

Ext.define('Foss.main.ShowMessagesPanel',{
	extend : 'Ext.panel.Panel',
	title : '',
	columnWidth : 1,
	cls : 'autoHeight',
	bodyCls : 'autoHeight',
	frame : false,
	toDoMsgGrid : null,
	getToDoMsgGrid : function() {
		if (this.toDoMsgGrid == null) {
			this.toDoMsgGrid = Ext
					.create('Foss.main.ToDoMsgGrid');
		}
		return this.toDoMsgGrid;
	},
	normalMsgGrid : null,
	getNormalMsgGrid : function() {
		if (this.normalMsgGrid == null) {
			this.normalMsgGrid = Ext
					.create('Foss.main.NormalInstationMsgGrid');
		}
		return this.normalMsgGrid;
	},
	netMsgGrid : null,
	getNetMsgGrid : function() {
		if (this.netMsgGrid == null) {
			this.netMsgGrid = Ext
					.create('Foss.main.NetInstationMsgGrid');
		}
		return this.netMsgGrid;
	},
	
	collectionMsgMsgGrid : null,
	getCollectionMsgGrid : function() {
		if (this.collectionMsgMsgGrid == null) {
			this.collectionMsgMsgGrid = Ext
					.create('Foss.main.CollectionMsgGrid');
		}
		return this.collectionMsgMsgGrid;
	},
	
	
	changeBottomAreaCheckBox:function(value,intervalTime){
		var autoFlag=true;
		if(value=='Y'){
			autoFlag=false;
		} 
		login.msg.remindInterval(value,intervalTime);
		login.msg.intervalTime=intervalTime;
		this.getBottomArea().items.items[0].setValue(autoFlag);
	},
	changeCheckBox:function(value){
		var autoFlag=true;
		if(value=='Y'){
			autoFlag=false;
		} 
		this.getBottomArea().items.items[0].setValue(autoFlag);
	},
	bottomArea : null,
	getBottomArea : function() {
		if (this.bottomArea == null) {
			this.bottomArea = Ext.create('Ext.panel.Panel',{
				frame : false,
				columnWidth : 1,
				height : 38,
				layout : 'column',
				items: [{
							xtype : 'checkboxfield',
							width : 200,
							boxLabel : login.i18n('foss.login.app.noAutoAlertMsg'),
							name : 'notAutoMessage',
							inputValue : 'N',
							listeners:{
								change:function(_this, newValue, oldValue, eOpts){
									var autoAlertFlag='Y';
									if(newValue){
										autoAlertFlag='N';
									} 
									login.msg.remindInterval(autoAlertFlag,login.msg.intervalTime);
									 //保存弹出框设置项 
									var params={
											'msgVo.winEntity.autoAlertFlag' : autoAlertFlag
									};
//									var url = ContextPath.BSE_BASEINFO +'/common/uptAutoAlertFlag.action';
//									if(login.dev){
										url = '../common/uptAutoAlertFlag.action';
//									}
							        Ext.Ajax.request({
							            url : url,
							            params:params,
							            success : function(response) { 
							              var json = Ext.decode(response.responseText); 
							            },
							            exception : function(response) {
							              var json = Ext.decode(response.responseText);
							            }
							        });  
								}
							}
							
						},{
							xtype : 'container',
							width : 240,
							html: '&nbsp;'
						},{
							xtype : 'container',
							margin:'5 0 0 0',
							id : 'alert_settings',
							width : 80,
							html:'<a href="javascript:login.msg.openAlertSetting();">'+login.i18n('foss.login.app.advancedSettings')+'</a>'
						},{
							xtype : 'button',
							text : login.i18n('foss.login.app.okButton'),
							width : 100,
							cls : 'yellow_button',
							handler : function() {
								 login.msg.msgRemindWindow.hide();
							}
						}]
					});
		}
		return this.bottomArea;
	},
	bodyStyle : 'padding:0px 0px 0px 2px',
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);
		me.items = [ me.getToDoMsgGrid(),
				me.getNormalMsgGrid(), me.getNetMsgGrid(),me.getCollectionMsgGrid(),
				me.getBottomArea()];
		me.callParent([ cfg ]);
	}
});

// 当用户第一次登时弹出消息提醒窗口
Ext.define('Foss.main.MsgRemindWindow', {
	extend : 'Ext.Window',
	closeAction : 'hide',
	title : login.i18n('foss.login.app.msgRemind'),
	modal : true,
	height : 'autoHeight',
	width : 700,
	resizable : false,
	layout : 'column',
	showMessagesPanel : null,
	getShowMessagesPanel : function() {
		if (this.showMessagesPanel == null) {
			this.showMessagesPanel = Ext.create('Foss.main.ShowMessagesPanel');
		}
		return this.showMessagesPanel;
	},
	listeners:{
		beforeshow:function(){
			updateMsgData();
		}
	},
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);
		me.items = [ me.getShowMessagesPanel() ];
		me.callParent([ cfg ]);
	}
});

//创建弹出窗口
login.msg.msgRemindWindow = Ext.create('Foss.main.MsgRemindWindow');

//动态设置弹出间隔
login.msg.remindInterval=function(autoFlag,intervalTime){
	if(autoFlag=='Y'){
		if(!Ext.isEmpty(login.msg.intervalId)){
			window.clearInterval(login.msg.intervalId);
		}
		var showMessagePanel = login.msg.msgRemindWindow.getShowMessagesPanel();
		
		var toDoCount=showMessagePanel.getToDoMsgGrid().store.data.length;
		var normalMsgCount=showMessagePanel.getNormalMsgGrid().store.data.length;
		var netMsgCount=showMessagePanel.getNetMsgGrid().store.data.length;
		
		if(toDoCount > 0 || normalMsgCount > 0 || netMsgCount > 0 ){
			var minIntervalTime=1000*60*intervalTime;
			login.msg.intervalId = setInterval(function(){
				login.msg.msgRemindWindow.show(); 
	   	 	},minIntervalTime);
		}  
	}else{
		if(!Ext.isEmpty(login.msg.intervalId)){
			//动态清除弹出的设置
			window.clearInterval(login.msg.intervalId);
		}
	}
}

/*--------------------------------框架整合-----------------------------------------*/
Ext.application({
    name: 'DpFoss',
    appFolder: '..',
    launch: function() {
		Ext.QuickTips.init();
		
		//页面的头部
		var topPanel = Ext.create('Foss.main.topPanel'),
			//导航树
			mainNav = Ext.create('Foss.main.MainNav'),
			//工作区标签页
			tabPanel = Ext.create('Foss.main.TabPanel'),
			//页脚
			footer=Ext.create('Ext.panel.Panel',{
				id:'footer',
				columnWidth:1,
				html:'Copyright © '+login.currentServerTime.getFullYear()+' 德邦物流股份有限公司. All rights reserved. ',
				height:30
			 });
        Ext.create('Ext.container.Viewport', {
			id:'dpViewport',
			listeners:{
				//渲染结束后开始右上时间更新。每一秒更新一次。
				afterrender : function(){
					setInterval(
						function(){
							if(!Ext.isEmpty(login.currentServerTime) && !Ext.isEmpty(Ext.getCmp('dateTimeSpace'))){
								var htmlText = constructDateTime(login.currentServerTime)
								Ext.getCmp('dateTimeSpace').update(htmlText);
								login.currentServerTime = new Date((login.currentServerTime).getTime()+1000);
							}
						},1000
					);
				},
				boxready : function(_this,_width,_height,_eOpts){
				}
			},
			minWidth:1220,
			autoScroll: false,
			items: [topPanel,{	
				xtype:'panel',
				id:'col_cont',
				cls:'autoHeight',
				bodyCls:'autoHeight',
				layout: 'column',
				items:[
			   		mainNav,{	
		   			xtype:'panel',
					id:'container',
					cls:'autoHeight',
					bodyCls:'autoDim',
					columnWidth:1,
					items: [tabPanel,footer]
				}]
			
			}]
        });
		//添加滚动事件监控(因浏览器兼容缘故，window和document上都要添加)
		document.onscroll=onScroll;
		window.onscroll=onScroll;
		scroll(0,0);
    }
});