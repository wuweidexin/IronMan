Ext.define('JS.TabPanelText.Panel4', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '输入参数',
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
				
				if(undefined == a){
					Ext.Msg.alert('Tip','a is undefined');
				}
			}

		}];
		
		var store = Ext.create('Ext.data.Store', {
		    storeId:'simpsonsStore',
		    fields:['name', 'email', 'phone'],
//		    data:{'items':[
//		        { 'name': 'Lisa',  "email":"lisa@simpsons.com",  "phone":"555-111-1224"  },
//		        { 'name': 'Bart',  "email":"bart@simpsons.com",  "phone":"555-222-1234" },
//		        { 'name': 'Homer', "email":"home@simpsons.com",  "phone":"555-222-1244"  },
//		        { 'name': 'Marge', "email":"marge@simpsons.com", "phone":"555-222-1254"  }
//		    ]},
//		    proxy: {
//		        type: 'memory',
//		        reader: {
//		            type: 'json',
//		            root: 'items'
//		        }
//		    }
		});
		
		var columns = [
		           { text: 'Name',  dataIndex: 'name' },
		           { text: 'Email', dataIndex: 'email', flex: 1 },
		           { text: 'Phone', dataIndex: 'phone' }
		       ];
		
		Ext.apply(me,{
			tbar : tbar,
			store: store,
			columns : columns
		});
		this.callParent(arguments);
	}
});