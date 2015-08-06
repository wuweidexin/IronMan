Ext.define('JS.GridPanelText.GridPanelText', {
			extend : 'Ext.grid.Panel',
			layout : 'fit',
			title : '终端',
			region : 'east',
			width : '50%',
			frame : true,
			constructor : function(cfg) {
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
								specialkey : function(field, e) {
									if (e.getKey() == e.ENTER) {
										var text = field.getValue();

									}
								}
							}
						}, {
							xtype : 'button',
							text : '查询',
							handler : function() {

								if (undefined == a) {
									Ext.Msg.alert('Tip', 'a is undefined');
								}
							}

						}, {
							xtype : 'button',
							text : '新增行',
							handler : function() {
								me.addNewRow();
							}

						}, {
                            xtype : 'button',
                            text : '删除行',
                            handler : function() {
                                me.deleteRow();
                            }

                        }];

				var store = Ext.create('Ext.data.Store', {
							storeId : 'simpsonsStore',
							fields : ['name', 'email', 'phone'],
							data : {
								'items' : [{
											'name' : 'Lisa',
											"email" : "lisa@simpsons.com",
											"phone" : "555-111-1224"
										}, {
											'name' : 'Bart',
											"email" : "bart@simpsons.com",
											"phone" : "555-222-1234"
										}, {
											'name' : 'Homer',
											"email" : "home@simpsons.com",
											"phone" : "555-222-1244"
										}, {
											'name' : 'Marge',
											"email" : "marge@simpsons.com",
											"phone" : "555-222-1254"
										}]
							},
							proxy : {
								type : 'memory',
								reader : {
									type : 'json',
									root : 'items'
								}
							}
						});

				var columns = [{
							xtype : 'rownumberer',
							text : '序号'
						}, {
							text : 'Name',
							dataIndex : 'name',
							style : 'text-align:center',
							width : null,
							editor : 'textfield'
						}, {
							text : 'Email',
							dataIndex : 'email',
							style : 'text-align:center',
							width : null,
							editor : 'textfield'
						}, {
							text : 'Ph',
							dataIndex : 'phone',
							style : 'text-align:center',
							width : null,
							editor : 'textfield'
						}];

				Ext.apply(me, {
							tbar : tbar,
							store : store,
							columns : columns,
							plugins : [Ext.create(
									'Ext.grid.plugin.CellEditing', {
										clicksToEdit : 1
									})]
						});
				this.callParent(arguments);
			},
			addNewRow : function() {
				var me = this;

				me.getStore().insert(0, "");
				me.cellEditing.startEditByPosition({
							row : 0,
							column : 0
						});
			},
			deleteRow : function(){
				var me = this;
				var store = me.getStore();
				store.remove(store.getAt(0));
				me.getView().refresh();
			}
		});
