Ext.define('JS.main', {
	extend : 'Ext.panel.Panel',
	id : 'JS.main',
	title : 'Results',
	width : 600,
	height : 400,
	layout : 'border',
	constructor : function(cfg) {
		cfg = cfg || {};
		Ext.apply(this, cfg);
		this.callParent(arguments);
	},
	initComponent : function() {
		var me = this;
		var tbar = [{
					xtype : 'button',
					text : '弹出',
					handler : function() {
						me.out();

					}
				}, {
					xtype : 'button',
					text : '图片加载',
					handler : function() {
						me.textSelectImg();
					}
				},{
					xtype : 'button',
					text : '调色板',
					handler : function(){
						me.colorPicker();
					}
				},{
                    xtype : 'button',
                    text : '时间测试',
                    handler : function(){
                        var time=Ext.Date.format(new Date(), 'H:m');
                        Ext.Msg.alert('提示', time);
                    }
                },{
                    xtype : 'button',
                    text : '测试',
                    handler : function(){
                        var s = '{"distinct":"F","columns":[{"columnCode":"ID","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"PARENT_ID","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"COMPANY_ID","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"CODE","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"NAME","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"GRADE","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"SORT_NUM","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"SEQ","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"LEAF","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"STATUS","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"DEL_STATUS","tableCode":"DEL_SYS_DEPT","type":"C"}],"tables":{"tableCode":"DEL_SYS_DEPT"},"sort":[{"tableCode":"DEL_SYS_DEPT","tableAlias":"DEL_SYS_DEPT","colCode":"SORT_NUM","type":"ASC"}]}';
                        var sortType = '';
                        var ss = Ext.decode(s);
                        for(var i = 0; i < ss.length; i ++){
                        	var temp = ssp[i];
                        	var colCode = ss.sort[0]['colCode'];
                        	var tableCode = ss.sort[0]['tableCode'];
                        	if(colCode && tableCode && colCode == sortNum && tableCode == tableCode){
                        		sortType = ss.sort[0]['type']
                        	}
                        }
                        var sss = 1;
                    }
                },{
                    xtype : 'button',
                    text : '测试1',
                    handler : function(){
                    	var textArea = new Ext.form.field.TextArea({
                    	});
                        new Ext.Window({
                        	title : '标题',
                        	width : 500,
                        	height : 500,
                        	items : textArea,
                        	layout : 'fit'
                        }).show();
                    }
                },{
                    xtype : 'button',
                    text : '运行态改变属性',
                    handler : function(){
                        Ext.create("JS.PropertyTest.PropertyWin").show();
                    }
                }];
  //      var btree = Ext.create("JS.ImgUpload.ImageUpload");
		var btree = Ext.create("JS.TreePanelText.BackGround");
		var ttree = Ext.create("JS.GridPanelText.GridPanelText");
		var items = [btree, ttree];
		Ext.apply(this, {
					tbar : tbar,
					items : items
				});
		this.callParent(arguments);
	},
	out : function() {
		var win = Ext.create("JS.TabPanelText.CommonUseCompWin").show();
	},
	find : function(temp, temp2) {
		if (temp2 == null || temp2 == '') {
			alert(temp2);
		} else {
			alert('cancle');
		}

	},
	textSelectImg : function() {
		Ext.create('JS.ImgUpload.ImageUpload').show();
	},
	colorPicker : function(){
		Ext.create('JS.ColorPicker.colorPickerWin').show();
	}

});