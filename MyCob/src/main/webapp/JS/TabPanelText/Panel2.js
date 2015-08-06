Ext.define('JS.TabPanelText.Panel2', {
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
				
				if(undefined == a){
					Ext.Msg.alert('Tip','a is undefined');
				}
			}

		}];
		
		var store = Ext.create('Ext.data.Store', {
		    storeId:'simpsonsStore',
		    fields:['name', 'email', 'phone', 'inParams', 'outParams'],

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
		var inParams = Ext.decode(item.data.inParams);
		var outParams = Ext.decode(item.data.outParams);
		this.win.query('panel')[3].getStore().loadData([inParams]);
		this.win.query('panel')[4].getStore().loadData([outParams]);
	}
});