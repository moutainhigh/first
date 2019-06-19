// model
Ext.define('Dpm.uums.versionManagement.store.DtoModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		
		name : 'vid',
		type : 'int'
	}, {
		
		name : 'version',
		type : 'string'
	}, {
		
		name : 'url',
		type : 'string'
	}, {
		
		name : 'appName',
		type : 'string'
	}, {
		
		name : 'content',
		type : 'string'
	}, {
		
		name : 'rforce',
		type : 'string'
	}, {
		
		name : 'osType',
		type : 'string'
	}, {
		
		name : 'updateTime',
		type : 'string'
	}]
});



Ext.define('Dpm.uums.versionManagement.store', {
	extend : 'Ext.data.Store',
	model : 'Dpm.uums.versionManagement.store.DtoModel',
	proxy : {
		// 以JSON的方式加载数据
		type : 'ajax',
		actionMethods : 'POST',
		url : uums.realPath('selectVersion.action'),
		reader : {
			type : 'json',
			root : 'vo.versionList',
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
Ext.define('Dpm.uums.versionManagement.grid', {
	extend : 'Ext.grid.Panel',
	frame : true,
	bodyCls : 'autoHeight',
	cls : 'autoHeight',
	title : "版本列表",
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
             	
             	if(!Dpm.uums.versionManagement.newWindow) {
					   Dpm.uums.versionManagement.newWindow = Ext.create('Dpm.uums.versionManagement.new.window');
				}
             	
             	Dpm.uums.versionManagement.newWindow.rowId=record.data.id;
             	Dpm.uums.versionManagement.newWindow.operateForm.getForm().loadRecord(record);
             	
				Dpm.uums.versionManagement.newWindow.show();
				
             }
	        }]
		},{
		/*	xtype : 'ellipsiscolumn',
			header : "编号", // 编号
			dataIndex : 'vid'
		},{*/
				xtype : 'ellipsiscolumn',
				header : "系统类型", // 系统类型
				dataIndex : 'osType',
				flex : 0.8
			},{
				xtype : 'ellipsiscolumn',
				header : "版本号", // 版本号
				dataIndex : 'version',
				flex : 0.8
			},{
				xtype : 'ellipsiscolumn',
				header : "更新内容", // 更新内容
				dataIndex : 'content',
				flex : 0.8
			},{
				xtype : 'ellipsiscolumn',
				header : "更新类型", // 更新类型
				dataIndex : 'rforce',
				flex : 0.8
			}],
		constructor : function(config) {
			var me = this, cfg = Ext.apply({}, config);
			me.store = Ext.create('Dpm.uums.versionManagement.store');
			me.bbar = Ext.create('Deppon.StandardPaging', {
				store: me.store,
				plugins: 'pagesizeplugin',
				displayInfo: true
			});
			uums.versionManagement.pagingBar = me.bbar;
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
Ext.define('Dpm.uums.versionManagement.new.window',{
	extend:'Ext.window.Window',
	title:"版本更新",    
	width:400,
	height:370,
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
			    		fieldLabel : "系统类型",    //功能名称
						name:'osType',
						allowBlank:false,
						columnWidth: 1
					},{
						name:'version',
						allowBlank:false,
						fieldLabel: "版本号",    //功能编码
						columnWidth: 1
					},{
						name:'rforce',
						allowBlank:false,
						fieldLabel: "更新类型",    //功能编码
						columnWidth: 1
					},{
						name:'url',
						allowBlank:false,
						fieldLabel: "安装地址",    //功能编码
						columnWidth: 1
					},{
						xtype:'textareafield',
						grow      : true,
						name:'content',
						fieldLabel: "更新内容",    //备注
						columnWidth: 1
					},{
						hidden: true,
						name:'vid'
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
					var operateForm = Dpm.uums.versionManagement.newWindow.operateForm.getForm();
					
					if(!operateForm.isValid()){
						Ext.MessageBox.alert("提示", "输入框不能为空!");    //输入框不能为空
						return;
					}
					vo.versionEntity = operateForm.getValues();
					//vo.versionEntity.id=Dpm.uums.versionManagement.newWindow.rowId;
					//提交记录
		           	Ext.Ajax.request({
	   				url : uums.realPath("updateVersion.action"),
	   				jsonData: {'vo':vo},
	   				success:function(response){
	   					Ext.ux.Toast.msg("提示", "版本修改成功");    //操作成功
	   					Dpm.uums.versionManagement.newWindow.close();
	   					uums.versionManagement.pagingBar.moveFirst();
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
					Dpm.uums.versionManagement.newWindow.close();
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
	var queryGrid = Ext.create('Dpm.uums.versionManagement.grid');
	uums.versionManagement.queryGrid = queryGrid;
	Ext.create('Ext.panel.Panel', {
				id : 'T_uums-versionManagementIndex_content',
				cls : "panelContentNToolbar",
				bodyCls : 'panelContentNToolbar-body',
				layout : 'auto',
				items : [queryGrid],
				renderTo : 'T_uums-versionManagementIndex-body'
			});
	
	uums.versionManagement.pagingBar.moveFirst();
});