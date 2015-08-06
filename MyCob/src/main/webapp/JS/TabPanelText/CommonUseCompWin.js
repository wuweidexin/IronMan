Ext.define("JS.TabPanelText.CommonUseCompWin", {
	extend : "Ext.window.Window",
	title : '通用选取组建',
	width : 800,
	height : 400,
	layout : 'border',
	closable : true,
	autoDestroy : true,
	modal : true,
	closeAction : "destroy",
	constructor : function(cfg) {
		cfg = cfg || {};
		Ext.apply(this, cfg);
		this.callParent(arguments);
	},
	initComponent : function() {
		var me = this;
//		region : 'east',width : '50%'

		var p1 = Ext.create("JS.TreePanelText.BackGround",{win : me, region : 'west', width : '40%'});
//		var p1 = Ext.create("JS.TabPanelText.Panel1",{win : me, region : 'west', width : '40%'});
		var p2 = Ext.create("JS.TabPanelText.Panel2",{win : me, region : 'center', width : '30%'});
		var p3 = Ext.create("JS.TabPanelText.Panel3",{win : me, region : 'east', width : '30%'});
		
		Ext.apply(me, {
			items : [p1,p2,p3]
		});
		this.callParent(arguments);
	}
})