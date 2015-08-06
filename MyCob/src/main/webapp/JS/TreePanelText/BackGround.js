Ext.define("JS.TreePanelText.BackGround", {
	extend : "Ext.tree.Panel",
	layout : 'fit',
	title : '后台',
	region : 'west',
	width : '50%',
//	frame : true,
	constructor : function(cfg) {
		cfg = cfg || {};
		Ext.apply(this, cfg);
		this.callParent(arguments);
	},
	initComponent : function() {
		var me = this;
		var store = Ext.create('Ext.data.TreeStore', {
			root: {
				expanded: true,
				children: [{ 
					text: "权限管理", expanded: true, children: [{ 
						text: "组织权限管理", leaf: true },{ 
							text: "角色权限管理", leaf: true}
						] },{ 
							text: "UI工具", expanded: true, children : [{ 
								text: "UI组件", leaf: true },{ 
									text: "UI事件", leaf: true }
								] }]}
		});


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
						
						var reg = new RegExp(text+"{1}", "i");
				
						store.filterBy(function(va){
//							if(va)
//							Ext.Msg.alert("Tip","show");
							return false;
//							if(va.data.name == text){
//								Ext.Msg.alert("Tip", "Equal");
//							}
						});
						
					}
				}
			} 
		},{
			xtype : 'button',
			text : '查询',
			handler : function(){
				
				var re = new RegExp("E");
				var s = 'MNU';
				var sh = re.test(s);
				Ext.Msg.alert('TIP',sh);
//				var text = me.win.query("textfield[name='queryName']")[0].getValue();
//				me.query(text);
			},
			scope : me

		}];

		var buttons = [{
			text : '确定',
			handler : function(){
				me.commit();
			}
		},{
			text : '关闭',
			handler : function(){
				me.win.close();
			}
		}];

		Ext.apply(me, {
			tbar : tbar,
			store: store,
			rootVisible: false,
			buttons : buttons,
			buttonAlign : 'center'
		});
		this.callParent(arguments);
	},
	query : function(text){
		var me = this;
		Ext.Msg.alert('Tip', text);

	},
	commit :function(){
		Ext.Msg.alert('提示','commit处理');
	},


	filterByText  : function(text) {
		var me = this;
		me.filterBy(text, 'text');
	},
	/**
	 * 根据字符串过滤所有的节点，将不符合条件的节点进行隐藏.
	 * @param 查询字符串.
	 * @param 要查询的列.
	 */
	filterBy : function(text, by) {
		this.clearFilter();

		var view = this.getView(),
		me = this,
		nodesAndParents = [];

		var re = new RegExp(Ext.escapeRe(text), 'i');  
		// 找到匹配的节点并展开.
		// 添加匹配的节点和他们的父节点到nodesAndParents数组.
		this.getRootNode().cascadeBy(function(tree, view) {
			var currNode = this;
			var currNodeText = currNode.data[by].toString().toLowerCase();
			if (currNode && currNode.data[by] && re.test(currNodeText) == true) {
				me.expandPath(currNode.getPath());

				while (currNode.parentNode) {
					nodesAndParents.push(currNode.id);
					currNode = currNode.parentNode;
				}
			}
		}, null, [me, view]);



		// 将不在nodesAndParents数组中的节点隐藏
		this.getRootNode().cascadeBy(function(tree, view) {
			var uiNode = view.getNodeByRecord(this);

			if (uiNode && !Ext.Array.contains(nodesAndParents, this.id)) {
				Ext.get(uiNode).setDisplayed('none');
			}
		}, null, [me, view]);
	},
	clearFilter : function() {
		var view = this.getView();

		this.getRootNode().cascadeBy(function(tree, view) {
			var uiNode = view.getNodeByRecord(this);

			if (uiNode) {
				Ext.get(uiNode).setDisplayed('table-row');
			}
		}, null, [this, view]);
	}


})
