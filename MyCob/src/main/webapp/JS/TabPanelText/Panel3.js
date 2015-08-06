Ext.define('JS.TabPanelText.Panel3', {
	extend : 'Ext.panel.Panel',
	layout : 'anchor',
	constructor : function(cfg){
		cfg = cfg || {};
		Ext.apply(this, cfg);
		this.callParent(arguments);
	},
	initComponent : function() {
		var me = this;
//		var p4 = Ext.create("JS.TabPanelText.Panel4",{region : 'south', width : '50%'});
//		var p5 = Ext.create("JS.TabPanelText.Panel5",{region : 'north', width : '50%'});
		var p4 = Ext.create("JS.TabPanelText.Panel4",{ anchor: '100% 50%'});
		var p5 = Ext.create("JS.TabPanelText.Panel5",{ anchor: '100% 50%'});
		var items = [p4,p5];
		
		
		
		
		Ext.apply(me,{
			items : items
		});
		this.callParent(arguments);
	}
});