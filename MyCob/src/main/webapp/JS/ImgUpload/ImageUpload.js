Ext.define('JS.ImgUpload.ImageUpload', {
	extend : 'Ext.window.Window',
	width : 1000,
	height : 580,
	xtype: 'dataview-multisort',
	autoScroll : true,
	constructor : function(cfg) {
		cfg = cfg || {};
		Ext.apply(this, cfg);
		this.callParent(arguments);
	},
	initComponent : function() {
		var me = this;

		var dataView = {
			xtype : 'dataview',
			tpl : [
					'<tpl for=".">',
					'<div class="dataview-multisort-item">',
					(!Ext.isIE6
							? '<img src="{thumb}" />'
							: '<div style="position:relative;'
									+ 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src=\'{thumb}\')"></div>'),
					'<h3>{name}</h3>', '</div>', '</tpl>'],

			itemSelector : 'div.dataview-multisort-item',
			store : Ext.create('Ext.data.Store', {
						autoLoad : true,
						sortOnLoad : true,
						fields : ['name', 'thumb', 'url', 'type'],
						proxy : {
							type : 'ajax',
							url : 'Json/users.json',
							reader : {
								type : 'json',
								root : 'images'
							}
						}
					})
		};

		me.items = [dataView];
		//dataView.on("itemclick", me.setUrl);
		this.callParent(arguments);
		//this.updateStoreSorters();
	},
	setUrl : function(pic, record, item, index) {
		Ext.Msg.alert('路径', record.raw.src);
	},
	getSorters : function() {
		var buttons = this.query('toolbar dataview-multisort-sortbutton'), sorters = [];
		Ext.Array.each(buttons, function(button) {
					sorters.push({
								property : button.getDataIndex(),
								direction : button.getDirection()
							});
				});

		return sorters;
	},

	/**
	 * @private
	 * Updates the DataView's Store's sorters based on the current Toolbar button configuration
	 */
	updateStoreSorters : function() {
		var sorters = this.getSorters(), view = this.down('dataview');

		view.store.sort(sorters);
	}
});
