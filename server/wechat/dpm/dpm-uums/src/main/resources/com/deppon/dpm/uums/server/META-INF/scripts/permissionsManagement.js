// model
Ext.define('Dpm.uums.permissionsManagement.store.DtoModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		/** 角色编码 */
		name : 'code',
		type : 'string'
	}, {
		/** 角色名称 */
		name : 'name',
		type : 'string'
	}, {
		/** 角色入口URI */
		name : 'notes',
		type : 'string'
	}, {
		/** 角色层次 */
		name : 'UUID',
		type : 'string'
	}, {
		/** 数据版本号 */
		name : 'versionNo',
		type : 'string'
	}]
});



Ext.define('Dpm.uums.permissionsManagement.store', {
	extend : 'Ext.data.Store',
	model : 'Dpm.uums.permissionsManagement.store.DtoModel',
	proxy : {
		// 以JSON的方式加载数据
		type : 'ajax',
		actionMethods : 'POST',
		url : uums.realPath('selectlimitRole.action'),
		reader : {
			type : 'json',
			root : 'vo.roleList',
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
Ext.define('Dpm.uums.permissionsManagement.grid', {
	extend : 'Ext.grid.Panel',
	frame : true,
	bodyCls : 'autoHeight',
	cls : 'autoHeight',
	title : "角色列表",
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
				   if(!Dpm.uums.permissionsManagement.newWindow) {
					   Dpm.uums.permissionsManagement.newWindow = Ext.create('Dpm.uums.permissionsManagement.new.window');
				   }
				   
				   Dpm.uums.permissionsManagement.newWindow.rowId=null;
				   
				   var permissionsManagementRecord = Ext.ModelManager.create({'name':''},'Dpm.uums.permissionsManagement.store.DtoModel');
				   Dpm.uums.permissionsManagement.newWindow.operateForm.getForm().loadRecord(permissionsManagementRecord);
				   
				   
	             	Dpm.uums.permissionsManagement.newWindow.getSerialContainer().getNewSerialNumberGrid().getStore().load();
	             	Dpm.uums.permissionsManagement.newWindow.getSerialContainer().getOldSerialNumberGrid().getStore().load();
	             	
				   
				   Dpm.uums.permissionsManagement.newWindow.show();
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
             	
             	if(!Dpm.uums.permissionsManagement.newWindow) {
					   Dpm.uums.permissionsManagement.newWindow = Ext.create('Dpm.uums.permissionsManagement.new.window');
				}
             	
             	Dpm.uums.permissionsManagement.newWindow.rowId=record.data.id;
             	Dpm.uums.permissionsManagement.newWindow.operateForm.getForm().loadRecord(record);
             	
             	
             	Dpm.uums.permissionsManagement.newWindow.getSerialContainer().getNewSerialNumberGrid().getStore().load();
             	Dpm.uums.permissionsManagement.newWindow.getSerialContainer().getOldSerialNumberGrid().getStore().load();
             	
             	
             	
				Dpm.uums.permissionsManagement.newWindow.show();
				
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
 							var array = {vo: {roleEntity :{id:id}}};
 							Ext.Ajax.request({
 								url:uums.realPath('deleteRole.action'),
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
		header : "角色名称", // 角色名称
		dataIndex : 'name',
		flex : 0.8
	},{
		xtype : 'ellipsiscolumn',
		header : "角色编码", // 角色编码
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
		me.store = Ext.create('Dpm.uums.permissionsManagement.store');
		me.bbar = Ext.create('Deppon.StandardPaging', {
			store: me.store,
			plugins: 'pagesizeplugin',
			displayInfo: true
		});
		uums.permissionsManagement.pagingBar = me.bbar;
		me.callParent([cfg]);
	},
	viewConfig : {
		enableTextSelection : true
	}
});

//新增

/**
* 借车申请window
*/
Ext.define('Dpm.uums.permissionsManagement.new.window',{
	extend:'Ext.window.Window',
	title:"角色新增",    //借车申请
	width:700,
	height:500,
	resizable:false,
	applyInfo: null,
	buttonArea: null,
	operateForm:null,
	modal:true,
	rowId:null,
	closable: true,
	closeAction: 'hide',
	//角色明细
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
					labelWidth: 60,
					margin:'5 10 5 10',
				},
			    items: [{
			    		fieldLabel : "角色名称",    //角色名称
						name:'name',
						columnWidth: .2,
						allowBlank:false
					},{
						name:'code',
						fieldLabel: "角色编码",    //角色编码
						allowBlank:false,
						columnWidth: .2
					},{
						name:'notes',
						fieldLabel: "备注",    //备注
						columnWidth: .2
					},{
						border : false,
						xtype : 'container',
						columnWidth:0.2,
						layout:'column',
						defaults: {
							margin:'5 10 5 10',
						},
						items : [{
							xtype : 'button',
							text:"保存",    //保存
							columnWidth:1,
							handler:function() {
								var vo={};
								var operateForm = Dpm.uums.permissionsManagement.newWindow.operateForm.getForm();
								
								if(!operateForm.isValid()){
									Ext.MessageBox.alert("提示", "输入框不能为空!");    //输入框不能为空
									return ;
								}
								vo.roleEntity = operateForm.getValues();
								vo.roleEntity.id=Dpm.uums.permissionsManagement.newWindow.rowId;
								//提交记录
					           	Ext.Ajax.request({
				   				url : uums.realPath("insertOrUpdateRole.action"),
				   				jsonData: {'vo':vo},
				   				success:function(response){
				   					result = Ext.decode(response.responseText);
				   					Dpm.uums.permissionsManagement.newWindow.rowId=result.vo.roleEntity.id;
				   					uums.permissionsManagement.pagingBar.moveFirst();
				   					
				   					Ext.MessageBox.alert("提示", "角色保存成功");    //操作成功
				   				},
				   				exception: function(response) {
				 					   var result = Ext.decode(response.responseText);
				 					   Ext.MessageBox.alert("错误提示", result.message);
				 				    }
				   			});	

							}
						}]
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
					var operateForm = Dpm.uums.permissionsManagement.newWindow.operateForm.getForm();
					
					if(!operateForm.isValid()){
						Ext.MessageBox.alert("提示", "输入框不能为空!");    //输入框不能为空
						return;
					}
					
					vo.roleEntity = operateForm.getValues();
					vo.roleEntity.id=Dpm.uums.permissionsManagement.newWindow.rowId;
					
					
					//Dpm.uums.permissionsManagement.newWindow.getSerialContainer().getNewSerialNumberGrid().getStore()
					var store =Dpm.uums.permissionsManagement.newWindow.getSerialContainer().getNewSerialNumberGrid().getStore();
					vo.resourceList = new Array();
					store.each(function(record){
							var resource = {};
							resource.name=record.get('name');
							resource.code=record.get('code');
							resource.id=record.get('id');
							vo.resourceList.push(resource);	
						});
					
					
					//提交记录
		           	Ext.Ajax.request({
	   				url : uums.realPath("insertOrUpdateRR.action"),
	   				jsonData: {'vo':vo},
	   				success:function(response){
	   					Ext.ux.Toast.msg("提示", "角色录入成功");    //操作成功
	   					Dpm.uums.permissionsManagement.newWindow.close();
	   					uums.permissionsManagement.pagingBar.moveFirst();
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
					Dpm.uums.permissionsManagement.newWindow.close();
				}
			},{
				xtype:'container',
				html:'&nbsp;',
				columnWidth:.3
			}]
		});
		return this.buttonArea;
	},
	serialContainer : null,
	getSerialContainer : function(){
		if(this.serialContainer==null){
			this.serialContainer = Ext.create('Dpm.uums.permissionsManagement.SerialContainer',{
				flex: 1,
				height:300
			});
		}
		return this.serialContainer;
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
		this.getSerialContainer();
		
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
		form.add([me.applyInfo,me.serialContainer,me.buttonArea]);
		//保存form到全局变量中
		//uums.borrowVehicleApplyForm = form;
		me.add([form]);
	}
});


//左右可移动列表




/**
 * 未分配的功能
 */
Ext.define('Dpm.uums.permissionsManagement.old.model',{
	extend: 'Ext.data.Model',
	//定义字段
	fields: [
		{name: 'name',type:'string'},
		{name: 'code',type:'string'},
		{name: 'notes',type:'string'},
		{name: 'id',type:'string'},
		{name: 'UIID',type:'string'}
	]
});

/**
 * 原流水号store
 */
Ext.define('Dpm.uums.permissionsManagement.old.store',{
	extend: 'Ext.data.Store',
	//绑定一个模型
	model: 'Dpm.uums.permissionsManagement.old.model',
	//定义一个代理对象
	proxy: {
		// 以JSON的方式加载数据
		type : 'ajax',
		actionMethods : 'POST',
		url : uums.realPath('selectlimitRR.action'),
		reader : {
			type : 'json',
			root : 'vo.resourceList',
			totalProperty : 'vo.totalCount',
			successProperty : 'success'
		}
	},
	autoLoad: true,
	listeners:{
		beforeload : function(store, operation, eOpts) {
			Ext.apply(operation, {
				params : {'vo.resourceEntity.id':Dpm.uums.permissionsManagement.newWindow.rowId}
			});	
		},
		load: function( store, records, successful, eOpts ){
			
		}
	},
	constructor: function(config){
		var me = this,
			cfg = Ext.apply({}, config);
		me.callParent([cfg]);
	}
});

/**
 * 获取已分配的功能
 */
Ext.define('Dpm.uums.permissionsManagement.new.model',{
	extend: 'Ext.data.Model',
	//定义字段
	fields: [
		{name: 'name',type:'string'},
		{name: 'code',type:'string'},
		{name: 'notes',type:'string'},
		{name: 'id',type:'string'},
		{name: 'UIID',type:'string'}
	]
});

/**
 *  获取已分配的功能 store
 */
Ext.define('Dpm.uums.permissionsManagement.new.store',{
	extend: 'Ext.data.Store',
	//绑定一个模型
	model: 'Dpm.uums.permissionsManagement.new.model',
	//定义一个代理对象
	proxy: {
		// 以JSON的方式加载数据
		type : 'ajax',
		actionMethods : 'POST',
		url : uums.realPath('selectRoleLimitRR.action'),
		reader : {
			type : 'json',
			root : 'vo.resourceedSelectedList',
			totalProperty : 'vo.totalCount',
			successProperty : 'success'
		}
	},
	autoLoad: true,
	listeners:{
		beforeload : function(store, operation, eOpts) {
			Ext.apply(operation, {
				params : {'vo.resourceEntity.id':Dpm.uums.permissionsManagement.newWindow.rowId}
			});	
		},
		load: function( store, records, successful, eOpts ){
			
		}
	},
	constructor: function(config){
		var me = this,
			cfg = Ext.apply({}, config);
		me.callParent([cfg]);
	}
});


/**
 * 处理权限分配页面
 */
Ext.define('Dpm.uums.permissionsManagement.SerialContainer', {
	extend: 'Ext.container.Container',
	layout: {
        type: 'hbox',
        align: 'stretch'
    },
	autoScroll:false,
	frame : true,
	border : false,
	items : null,
	oldSerialNumberGrid : null,
	/**
	 * 未分配的功能grid
	 */
	getOldSerialNumberGrid : function(){
		var me = this;
		if(this.oldSerialNumberGrid==null){
			this.oldSerialNumberGrid = Ext.create('Ext.grid.Panel', {
				title: "未分配的功能",//未分配的功能
				store: Ext.create('Dpm.uums.permissionsManagement.old.store'),
				flex: 1,
				autoScroll: true,
				selModel:Ext.create('Ext.selection.CheckboxModel',{
					showHeaderCheckbox : true,
					mode : 'SIMPLE',
					checkOnly : false//,//限制只有点击checkBox后才能选中行
//					listeners : {
//						'beforeselect' : function(rowModel, record, index, eOpts){
//							//如果不可选，则返回false
//							if(me.viewConfig.getRowClass(record) === 'disabledrow'){
//								return false;
//							}
//						}
//					}
				}),
				columns: [{
					width : 100,
					text:"功能名称", 
					dataIndex: 'name' 
				},{
					width : 100,
					text:"功能编码", 
					dataIndex: 'code' 
				},{
					width : 100,
					hidden: true,
					dataIndex: 'id' 
				},{
					width : 100,
					hidden: true,
					dataIndex: 'UUID' 
				},{
					width : 100,
					hidden: true,
					dataIndex: 'notes' 
				}]
			});
		}
		return this.oldSerialNumberGrid;		
	},
	/**
	 * 分左移和右移
	 */
	operationSerialContainer : null,
	getOperationSerialContainer : function(){
		var me = this;
		if(this.operationSerialContainer==null){
			this.operationSerialContainer = Ext.create('Ext.container.Container',{
				flex: 0.2,
				buttonAlign : 'center',
				autoScroll: false,
				layout : 'column',
				items : [{
						columnWidth : 1,
						height : 0,
						xtype : 'container',
						style : 'padding-top:60px;border:none',
						hide:true
					},{
						xtype : 'button',
						 iconCls : 'deppon_icons_turnrightall',
						 columnWidth : 1,
					     handler : function() {
					    	 var store = me.getOldSerialNumberGrid().getStore();
					    	 store.each(function(record){
					    		 me.getNewSerialNumberGrid().getStore().add(record);
								});

							me.getOldSerialNumberGrid().getStore().removeAll();
					     }
					},{
						/**
						 * 右移按钮，是未分陪功能变成已分配功能的过程
						 */
						columnWidth : 1,
						xtype : 'button',
						iconCls : 'deppon_icons_turnright',
						handler : function(){
							var oldSm = me.getOldSerialNumberGrid().getSelectionModel();
							var oldSmlength = oldSm.getSelection().length
							
							if(oldSm.getSelection().length >=1) {
								
								for(var i=(oldSmlength-1);i>=0;i--){
									  oldRecord = oldSm.getSelection()[i];
									//  me.getNewSerialNumberGrid().getStore().insert(me.getNewSerialNumberGrid().getStore().count(),oldRecord);
									  me.getNewSerialNumberGrid().getStore().add(oldRecord);
									  me.getOldSerialNumberGrid().getStore().remove(oldRecord);
								}
								
							}else {
								//提示，请选择要分配的功能!
								Ext.Msg.alert("提示","请选择要分配的功能!");
							}
						}
					},{
						columnWidth : 1,
						height : 0,
						xtype : 'container',
						style : 'padding-top:10px;border:none',
						hide:true
					},{
						/**
						 * 把功能从已分配变成未分配
						 */
						columnWidth : 1,
						xtype : 'button',
						iconCls : 'deppon_icons_turnleft',
						handler : function(){
							var newSm = me.getNewSerialNumberGrid().getSelectionModel();
							var newSmlength = newSm.getSelection().length
								if (newSm.getSelection().length >=1) {
								
									for(var i=(newSmlength-1);i>=0;i--){
										  newRecord = newSm.getSelection()[i];
										  //me.getOldSerialNumberGrid().getStore().insert(me.getOldSerialNumberGrid().getStore().count(),newRecord);
										  me.getOldSerialNumberGrid().getStore().add(newRecord);
										  me.getNewSerialNumberGrid().getStore().remove(newRecord);
									}
							}else {
								//提示，请选择要分配的功能!
								Ext.Msg.alert("提示","请选择要删除的功能!");
							}
                        }
					},{
						iconCls : 'deppon_icons_turnleftall',
						columnWidth : 1,
						xtype : 'button',
					    handler: function() {
					    	var store = me.getNewSerialNumberGrid().getStore();
							
					    	 store.each(function(record){
					    		 me.getOldSerialNumberGrid().getStore().add(record);
								});
							 me.getNewSerialNumberGrid().getStore().removeAll();
					    }
					}]
			});
		}
		return this.operationSerialContainer;		
	},
	/**
	 * 已分配功能grid
	 */
	newSerialNumberGrid : null,
	getNewSerialNumberGrid : function(){
		if(this.newSerialNumberGrid==null){
			this.newSerialNumberGrid = Ext.create('Ext.grid.Panel', {
				title: "已分配功能",
				store: Ext.create('Dpm.uums.permissionsManagement.new.store'),
				flex: 1,
				autoScroll: true,
				selModel:Ext.create('Ext.selection.CheckboxModel',{mode:"SIMPLE"}),
				columns: [{
					width : 100,
					text:"功能名称", 
					dataIndex: 'name' 
				},{
					width : 100,
					text:"功能编码", 
					dataIndex: 'code' 
				},{
					width : 100,
					hidden: true,
					dataIndex: 'id' 
				},{
					width : 100,
					hidden: true,
					dataIndex: 'UUID' 
				},{
					width : 100,
					hidden: true,
					dataIndex: 'notes' 
				}]
			});
		}
		return this.newSerialNumberGrid;		
	},
	constructor: function(config){
		var me = this,
			cfg = Ext.apply({}, config),
			newGrid = this.getNewSerialNumberGrid(),
			oldGrid = this.getOldSerialNumberGrid();
		this.items = [ 
			oldGrid, 
			this.getOperationSerialContainer(), 
			newGrid
		];
		me.callParent([cfg]);
	}
});


Ext.onReady(function() {
	Ext.QuickTips.init();
	var queryGrid = Ext.create('Dpm.uums.permissionsManagement.grid');
	uums.permissionsManagement.queryGrid = queryGrid;
	Ext.create('Ext.panel.Panel', {
				id : 'T_uums-permissionsManagementIndex_content',
				cls : "panelContentNToolbar",
				bodyCls : 'panelContentNToolbar-body',
				layout : 'auto',
				items : [queryGrid],
				renderTo : 'T_uums-permissionsManagementIndex-body'
			});
	
	uums.permissionsManagement.pagingBar.moveFirst();
});