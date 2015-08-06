Ext.define('JS.TabPanelText.Panel1', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	constructor : function(cfg){
		cfg = cfg || {};
		Ext.apply(this, cfg);
		this.callParent(arguments);
	},
	initComponent : function() {
		var me = this;
		
		var tbar = [{
			xtype : 'textfield',
			name : 'queryName',
			fieldLabel : '名称',
			width : '20',
			enableKeyEvents : true,
			listeners : {
				specialkey: function(field, e){
					if (e.getKey() == e.ENTER) {
						var text = field.getValue();
						
					}
				}
			} 
		},{
			xtype : 'button',
			text : '查询',
			handler : function(){
				
				
			}

		}];
		
		var store = Ext.create('Ext.data.Store', {
		    storeId:'simpsonsStore',
		    fields:['name', 'email', 'phone', 'inParams', 'outParams'],
		    data:{'items':[
		        { 'name': 'Lisa',  "email":"lisa@simpsons.com",  "phone":"555-111-1224",
		        	"inParams" : "{'name': 'Lisa_in',  'email':'lisa@simpsons.com',  'phone':'555-111-1224'}", "outParams" : "{'name': 'Lisa_out',  'email':'lisa@simpsons.com',  'phone':'555-111-1224'}" },
		        { 'name': 'Bart',  "email":"bart@simpsons.com",  "phone":"555-222-1234",
		        		"inParams" : "{'name': 'Bart_in',  'email':'Bart@simpsons.com',  'phone':'555-111-1224'}", "outParams" : "{'name': 'Bart_out',  'email':'Bart@simpsons.com',  'phone':'555-111-1224'}" },
		        { 'name': 'Homer', "email":"home@simpsons.com",  "phone":"555-222-1244",
		        			"inParams" : "{'name': 'Homer_in',  'email':'Homer@simpsons.com',  'phone':'555-111-1224'}", "outParams" : "{'name': 'Homer_out',  'email':'Homer@simpsons.com',  'phone':'555-111-1224'}" },
		        { 'name': 'Marge', "email":"marge@simpsons.com", "phone":"555-222-1254",
		        				"inParams" : "{'name': 'Marge_in',  'email':'Marge@simpsons.com',  'phone':'555-111-1224'}", "outParams" : "{'name': 'Marge_out',  'email':'Marge@simpsons.com',  'phone':'555-111-1224'}" }
		    ]},
		    proxy: {
		        type: 'memory',
		        reader: {
		            type: 'json',
		            root: 'items'
		        }
		    }
		});
		 
		var columns = [
		           { text: 'Name',  dataIndex: 'name' },
		           { text: 'Email', dataIndex: 'email', flex: 1 },
		           { text: 'Phone', dataIndex: 'phone' },
		           { text: 'inParams', dataIndex: 'inParams', hidden : true },
		           { text: 'outParams', dataIndex: 'outParams', hidden : true }
		           
		       ];
		
		
		me.on("itemclick", me.itemClick, me);
		
		Ext.apply(me,{
			tbar : tbar,
			store: store,
			columns : columns
		});
		this.callParent(arguments);
	},
	itemClick : function(record, item){
		var data = [];
		data.push(item.data);
	
		this.win.query('panel')[1].getStore().loadData(data);
//		this.win.query('panel')[1].store.reload();
	}
});