var logManagement={};
logManagement.util={};
//转换日期
logManagement.util.dateConvert = function(value) {
	if (value != null) {
		var date = new Date(value);
		return Ext.Date.format(date, 'Y-m-d H:i:s');
	} else {
		return null;
	}
};
// model
Ext.define('Dpm.uums.logManagement.store.DtoModel', {
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
		/** 内容 */
		name : 'content',
		type : 'string'
	}, {
		name : 'organizationName',
		type : 'string'
	}, {
		name : 'organizationCode',
		type : 'string'
	}, {
		name : 'userName',
		type : 'string'
	}, {
		name : 'userCode',
		type : 'string'
	}, {
		name : 'dateTime',
		type : 'string',
		convert: function(value){
			return logManagement.util.dateConvert(value);
		}
	}]
});



Ext.define('Dpm.uums.logManagement.store', {
	extend : 'Ext.data.Store',
	model : 'Dpm.uums.logManagement.store.DtoModel',
	proxy : {
		// 以JSON的方式加载数据
		type : 'ajax',
		actionMethods : 'POST',
		url : uums.realPath('selectLimitShow.action'),
		reader : {
			type : 'json',
			root : 'vo.logList',
			totalProperty : 'vo.totalCount',
			successProperty : 'success'
		}
	},
	listeners : {
		beforeload : function(store, operation, eOpts) {
			
			var queryForm = uums.logManagement.queryFrom.getForm();
			if (queryForm != null) {
				var queryParams = queryForm.getValues();
				Ext.apply(operation, {
					params : queryParams
				});	
			}
		},
		load : function( store, records, successful, eOpts){
		}
	}
});




//查询条件
Ext.define('Dpm.uums.logManagement.search', {
	extend : 'Ext.form.Panel',
	title : "查询条件", // 查询条件
	frame : true,
	collapsible : true,
	animCollapse : true,
	defaultType : 'textfield',
	layout : 'column',
	defaults : {
		labelWidth : 85,
		margin : '5 10 5 10'
	},
	items : [{
		name : 'vo.userCode',
		fieldLabel : "操作人编码", //操作人编码
		columnWidth : .25,
		allowBlank:false
	}, {
		name : 'vo.userName',
		fieldLabel : "操作人", // 操作人名称
		columnWidth : .25,
		allowBlank:false
	},  {
		xtype : 'rangeDateField',
		dateType : 'datetimefield_date97',
		fieldLabel : "时间范围", // 时间范围
		fromName : 'vo.startTime',
		toName : 'vo.endTime',
		fromValue: Ext.Date.format(new Date(new Date().getFullYear(),new Date().getMonth(),new Date().getDate()-1
				,'00','00','00'), 'Y-m-d H:i:s'),
		toValue: Ext.Date.format(new Date(new Date().getFullYear(),new Date().getMonth(),new Date().getDate()
		,'23','59','59'), 'Y-m-d H:i:s'),
		columnWidth : .5
	}, {
		border : 1,
		xtype : 'container',
		columnWidth : 1,
		defaultType : 'button',
		layout : 'column',
		items : [{
			text : "重置", // 重置
			columnWidth : .08,
			handler : function() {
				uums.logManagement.queryFrom.getForm().reset();
				
				uums.logManagement.queryFrom.getForm().findField('start').setValue(Ext.Date.format(new Date(new Date().getFullYear(),new Date().getMonth(),new Date().getDate()-1
						,'00','00','00'), 'Y-m-d H:i:s'));
				uums.logManagement.queryFrom.getForm().findField('end').setValue(Ext.Date.format(new Date(new Date().getFullYear(),new Date().getMonth(),new Date().getDate()
						,'23','59','59'), 'Y-m-d H:i:s'));
			}
		}, {
			xtype : 'container',
			columnWidth : .76,
			html : '&nbsp;'
		},{
		text : "查询", // 查询
		cls : 'yellow_button',
		columnWidth : .08,
		handler : function() {
			var form = uums.logManagement.queryFrom.getForm();
			uums.logManagement.pagingBar.moveFirst();
		}
	}]
	}]
});



// grid
Ext.define('Dpm.uums.logManagement.grid', {
	extend : 'Ext.grid.Panel',
	frame : true,
	bodyCls : 'autoHeight',
	cls : 'autoHeight',
	title : "功能列表", 
	columns : [
    {
		xtype : 'ellipsiscolumn',
		header : "操作类型", // 操作类型
		dataIndex : 'name',
		flex : 0.8
	},{
		xtype : 'ellipsiscolumn',
		header : "内容", // 内容
		dataIndex : 'content',
		flex : 0.8
	},{
		xtype : 'ellipsiscolumn',
		header : "操作人组织名称", // 组织名称
		dataIndex : 'organizationName',
		flex : 0.8
	},{
		xtype : 'ellipsiscolumn',
		header : "操作人", //操作人
		dataIndex : 'userName',
		flex : 0.8
	},{
		xtype : 'ellipsiscolumn',
		header : "操作人工号", // 操作人工号
		dataIndex : 'userCode',
		flex : 0.8
	},{
		xtype : 'ellipsiscolumn',
		header : "操作时间", // 操作时间
		dataIndex : 'dateTime',
		flex : 0.8
	}],
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);
		me.store = Ext.create('Dpm.uums.logManagement.store');
		me.bbar = Ext.create('Deppon.StandardPaging', {
			store: me.store,
			plugins: 'pagesizeplugin',
			displayInfo: true
		});
		uums.logManagement.pagingBar = me.bbar;
		me.callParent([cfg]);
	},
	viewConfig : {
		enableTextSelection : true
	}
});


Ext.onReady(function() {
	Ext.QuickTips.init();
	var queryGrid = Ext.create('Dpm.uums.logManagement.grid');
	var queryFrom = Ext.create('Dpm.uums.logManagement.search');
	uums.logManagement.queryGrid = queryGrid;
	uums.logManagement.queryFrom = queryFrom;
	Ext.create('Ext.panel.Panel', {
		id : 'T_uums-logManagementIndex_content',
		cls : "panelContentNToolbar",
		bodyCls : 'panelContentNToolbar-body',
		layout : 'auto',
		items : [queryFrom,queryGrid],
		renderTo : 'T_uums-logManagementIndex-body'
	});
	uums.logManagement.pagingBar.moveFirst();
});