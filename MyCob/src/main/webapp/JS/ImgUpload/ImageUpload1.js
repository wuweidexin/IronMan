Ext.define('JS.ImgUpload.ImageUpload1', {
	extend : 'Ext.window.Window',
	layout : 'column',
	width : 500,
	closeAction : 'hide',
	height : 500,
	resizable : false,
	shadow : false,
	modal : true,
	closable : true,
	bodyStyle : 'padding: 5 5 5 5',
	animCollapse : true,
	imageIndexName : '',
	constructor : function(cfg) {
		cfg = cfg || {};
		Ext.apply(this, cfg);
		this.callParent(arguments);
	},
	initComponent : function() {
		var me = this;
		var imageF1 = {
			xtype : "image",
			src : 'Image/101.jpg',
			columnWidth: 0.3
		};
		var imageF2 = {
			xtype : "image",
			src : 'Image/102.jpg',
			columnWidth: 0.3
		};
		var imageF3 = {
			xtype : "image",
			src : 'Image/103.jpg',
			columnWidth: 0.3
		};
		me.items = [imageF1, imageF2, imageF3];
		var ss = me.items;
		this.callParent(arguments);
	}
});
