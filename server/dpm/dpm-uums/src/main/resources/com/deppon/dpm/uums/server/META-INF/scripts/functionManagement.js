// model
Ext.define('Dpm.uums.functionManagement.store.DtoModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		/** 功能编码 */
		name : 'code',
		type : 'string'
	}, {
		/** 功能名称 */
		name : 'name',
		type : 'string'
	}, {
		/** 功能入口URI */
		name : 'entryUri',
		type : 'string'
	}, {
		/** 功能层次 */
		name : 'resLevel',
		type : 'string'
	}, {
		/** 数据版本号 */
		name : 'versionNo',
		type : 'string'
	}, {
		/** 是否有效 */
		name : 'active',
		type : 'string'
	}, {
		/** 显示顺序 */
		name : 'displayOrder',
		type : 'string'
	}, {
		/** 是否权限检查 */
		name : 'checked',
		type : 'string'
	}, {
		/** 功能类型 */
		name : 'resType',
		type : 'string'
	}, {
		/** 是否叶子节点 */
		name : 'leafFlag',
		type : 'string'
	}, {
		/** 图标的CSS样式 */
		name : 'iconCls',
		type : 'string'
	}, {
		/**  节点的CSS样式 */
		name : 'cls', 
		type : 'string'
	}, {
		/**  功能描述 */
		name : 'notes',
		type : 'string'
	}]
});



Ext.define('Dpm.uums.functionManagement.store', {
	extend : 'Ext.data.Store',
	model : 'Dpm.uums.functionManagement.store.DtoModel',
	proxy : {
		// 以JSON的方式加载数据
		type : 'ajax',
		actionMethods : 'POST',
		url : uums.realPath('selectlimit.action'),
		reader : {
			type : 'json',
			root : 'vo.resourceList',
			totalProperty : 'vo.totalCount',
			successProperty : 'success'
		}
	},
	listeners : {
		beforeload : function(store, operation, eOpts) {

		},
		load : function( store, records, successful, eOpts){
		}
	}
});

// grid
Ext.define('Dpm.uums.functionManagement.grid', {
	extend : 'Ext.grid.Panel',
	frame : true,
	bodyCls : 'autoHeight',
	cls : 'autoHeight',
	title : "功能列表",
	dockedItems:[{
		   xtype:'toolbar',
		   dock:'top',
		   layout:'column',
		   defaultType:'button',
		   items:[{
			   text:"新增",   //新增
			   columnWidth:.08,
			   name:'btnSubmit',
			   handler:function(){
				   if(!Dpm.uums.functionManagement.newWindow) {
					   Dpm.uums.functionManagement.newWindow = Ext.create('Dpm.uums.functionManagement.new.window');
				   }
				   
				   Dpm.uums.functionManagement.newWindow.rowId=null;
				   
				   var functionManagementRecord = Ext.ModelManager.create({'name':''},'Dpm.uums.functionManagement.store.DtoModel');
				   
				   Dpm.uums.functionManagement.newWindow.operateForm.getForm().loadRecord(functionManagementRecord);
				   Dpm.uums.functionManagement.newWindow.show();
			   }
		   }]
		}], 
	columns : [{
    	xtype:'actioncolumn',
		header: "操作",   //操作
        flex : 0.3,
        items: [{
        	iconCls: 'deppon_icons_edit',
        	text:"修改", 
        	tooltip: "修改",   //修改
        	 handler: function(grid, rowIndex, colIndex) {
             	var record = grid.getStore().getAt(rowIndex);
             	
             	if(!Dpm.uums.functionManagement.newWindow) {
					   Dpm.uums.functionManagement.newWindow = Ext.create('Dpm.uums.functionManagement.new.window');
				}
             	
             	Dpm.uums.functionManagement.newWindow.rowId=record.data.id;
             	
             	Dpm.uums.functionManagement.newWindow.operateForm.getForm().loadRecord(record);
				Dpm.uums.functionManagement.newWindow.show();
				
             }
        },{
        	iconCls: 'deppon_icons_delete',
        	text:"删除", 
        	tooltip: "删除",   //删除
        	 handler: function(grid, rowIndex, colIndex) {
        		 Ext.Msg.show({
             		title:"删除",   //删除
 					msg:"确认删除?",   //确认删除?
 					buttons:Ext.Msg.YESNO,
 					icon: Ext.Msg.QUESTION, 
 					fn : function(btn){
 						if(btn == 'yes'){
 							var id = grid.getStore().getAt(rowIndex).data.id;
 							var array = {vo: {resourceEntity :{id:id}}};
 							Ext.Ajax.request({
 								url:uums.realPath('delete.action'),
 			        			jsonData:array,
 			        			success : function(response) {
 			        				var json = Ext.decode(response.responseText);
 			        				grid.store.load();
 			        				Ext.ux.Toast.msg("提示","操作成功",'ok',1000);
 			        			},
 			        			exception : function(response) {
 			        				var json = Ext.decode(response.responseText);
 			        				Ext.Msg.alert("错误提示",json.message);
 			        			}
 			        		});
 						}
 					}
             	});
             }
        }]
    },{
		xtype : 'ellipsiscolumn',
		header : "功能名称", // 功能名称
		dataIndex : 'name',
		flex : 0.8
	},{
		xtype : 'ellipsiscolumn',
		header : "功能编码", // 功能编码
		dataIndex : 'code',
		flex : 0.8
	},{
		xtype : 'ellipsiscolumn',
		header : "备注", // 备注
		dataIndex : 'notes',
		flex : 0.8
	}],
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);
		me.store = Ext.create('Dpm.uums.functionManagement.store');
		me.bbar = Ext.create('Deppon.StandardPaging', {
			store: me.store,
			plugins: 'pagesizeplugin',
			displayInfo: true
		});
		uums.functionManagement.pagingBar = me.bbar;
		me.callParent([cfg]);
	},
	viewConfig : {
		enableTextSelection : true
	}
});

//新增

/**
* window
*/
Ext.define('Dpm.uums.functionManagement.new.window',{
	extend:'Ext.window.Window',
	title:"功能新增",    //借车申请
	width:400,
	height:270,
	resizable:false,
	applyInfo: null,
	buttonArea: null,
	operateForm:null,
	modal:true,
	rowId:null,
	closable: true,
	closeAction: 'hide',
	//功能明细
	createApplyInfo:function() {
		if(this.applyInfo) {
			return this.applyInfo;
		}
		this.applyInfo = Ext.create('Ext.form.Panel',{
			defaultType: 'textfield',
			items:[{
				xtype: 'container',
				layout:'column',
				defaultType:'textfield',
				defaults:{
					labelWidth: 85,
					margin: '5 10 5 10'
				},
			    items: [{
			    		fieldLabel : "功能名称",    //功能名称
						name:'name',
						allowBlank:false,
						columnWidth: 1
					},{
						name:'code',
						allowBlank:false,
						fieldLabel: "功能编码",    //功能编码
						columnWidth: 1
					},{
						xtype:'textareafield',
						grow      : true,
						name:'notes',
						fieldLabel: "备注",    //备注
						columnWidth: 1
					}]
			}]
		})
		return this.applyInfo;
	},
	//按钮区域
	createButtonArea: function() {
		if(this.buttonArea) {
			return this.buttonArea;
		}
		this.buttonArea = Ext.create('Ext.container.Container',{
			defaultType:'button',
			name:'buttonArea',
			defaults:{
				margin: '15 10 15 10'
			},
			layout:'column',
			items:[{
				xtype:'container',
				html:'&nbsp;',
				columnWidth:.3
			},{
				text:"提交",    //提交
				columnWidth:.2,
				handler:function() {
					var vo={};
					var operateForm = Dpm.uums.functionManagement.newWindow.operateForm.getForm();
					
					if(!operateForm.isValid()){
						Ext.MessageBox.alert("提示", "输入框不能为空!");    //输入框不能为空
						return;
					}
					vo.resourceEntity = operateForm.getValues();
					vo.resourceEntity.id=Dpm.uums.functionManagement.newWindow.rowId;
					//提交记录
		           	Ext.Ajax.request({
	   				url : uums.realPath("insertOrUpdate.action"),
	   				jsonData: {'vo':vo},
	   				success:function(response){
	   					Ext.ux.Toast.msg("提示", "功能录入成功");    //操作成功
	   					Dpm.uums.functionManagement.newWindow.close();
	   					uums.functionManagement.pagingBar.moveFirst();
	   				},
	   				exception: function(response) {
	 					   var result = Ext.decode(response.responseText);
	 					   Ext.MessageBox.alert("错误提示", result.message);
	 				    }
	   			});	

				}
			},{
				name:'doTemporarySaveBtn',
				text:"取消",    //取消
				columnWidth:.2,
				handler:function() {
					Dpm.uums.functionManagement.newWindow.close();
				}
			},{
				xtype:'container',
				html:'&nbsp;',
				columnWidth:.3
			}]
		});
		return this.buttonArea;
	},
	//初始化全局form
	createOperateForm: function() {
		if(this.operateForm) {
			return this.operateForm;
		}
		this.operateForm  = Ext.create('Ext.form.Panel', {
		    frame: false
		});
		return this.operateForm;
	},
	//初始化所有组件
	initAllComponent: function() {
		this.createButtonArea();
		this.createApplyInfo();
	},
	// 编辑操作  初始化数据.
	initData: function(){
		
	},
	constructor: function(config){
		var me = this,
		cfg = Ext.apply({}, config);
		me.callParent([cfg]);
		//初始化所有组件
		me.initAllComponent();
		//初始化全局form
		var form = me.createOperateForm();
		form.add([me.applyInfo, me.buttonArea]);
		//保存form到全局变量中
		//uums.borrowVehicleApplyForm = form;
		me.add([form]);
	}
});




Ext.onReady(function() {
	Ext.QuickTips.init();
	var queryGrid = Ext.create('Dpm.uums.functionManagement.grid');
	uums.functionManagement.queryGrid = queryGrid;
	Ext.create('Ext.panel.Panel', {
				id : 'T_uums-functionManagementIndex_content',
				cls : "panelContentNToolbar",
				bodyCls : 'panelContentNToolbar-body',
				layout : 'auto',
				items : [queryGrid],
				renderTo : 'T_uums-functionManagementIndex-body'
			});
	
	uums.functionManagement.pagingBar.moveFirst();
});