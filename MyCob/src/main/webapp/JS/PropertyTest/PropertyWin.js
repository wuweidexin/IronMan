Ext.define("JS.PropertyTest.PropertyWin", {
			extend : "Ext.window.Window",
			title : '运行时属性设置',
			width : 500,
			height : 400,
			constructor : function(config) {
				config = config || {};
				Ext.apply(this, config);
				this.callParent([config]);
			},
			initComponent : function() {
				var me = this;
				var tbar = [{
							xtype : 'button',
							text : '设置值',
							handler : function() {
								
							}

						}];

				Ext.apply(me, {
							tbar : tbar
						});
				this.callParent(arguments);
			}
		})