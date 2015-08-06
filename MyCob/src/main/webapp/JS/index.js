Ext.Loader.setConfig({enabled: true});
Ext.require([
    'Ext.tip.QuickTipManager',
    'Ext.container.Viewport',
    'Ext.layout.*',
    'Ext.form.Panel',
    'Ext.form.Label',
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.tree.*',
    'Ext.selection.*',
    'Ext.tab.Panel'
]);

Ext.onReady(function(){
	var tabPanel = [];
	
	var compensationInfoPanel = Ext.create('JS.main');
	tabPanel.push(compensationInfoPanel);
	var contentPanel = {
	         id: 'content-panel',
	         region: 'center', // this is what makes this panel into a region within the containing layout
	         layout: 'card',
	         margins: '2 5 5 0',
	         border: false,
	         items: tabPanel
	    };
	
	var store = Ext.create('Ext.data.TreeStore', {
	    root: {
	        expanded: true
	    },
	    proxy : {
	    	type : 'ajax',
	    	url : 'Json/myTree-data.json'
	    }
	    
	});
	var treePanel = Ext.create('Ext.tree.Panel', {
        id: 'tree-panel',
        title: '菜单',
        region:'north',
        split: true,
        height: 360,
        minSize: 150,
        rootVisible: false,
        autoScroll: true,
        store: store
    });
	treePanel.getSelectionModel().on('select', function(selModel, record) {
        if (record.get('leaf')) {
            Ext.getCmp('content-panel').layout.setActiveItem(record.getId());
        }
    });
	
	 Ext.create('Ext.Viewport', {
	        layout: 'border',
	        title: '测试系统',
	        items: [{
	            xtype: 'box',
	            id: 'header',
	            region: 'north',
	            html: '<h3> 测试系统</h3>',
	            height: 40
	        },{
	            layout: 'border',
	            id: 'layout-browser',
	            region:'west',
	            border: false,
	            split:true,
	            margins: '2 0 5 5',
	            width: 290,
	            minSize: 100,
	            maxSize: 500,
	            items: [treePanel]
	        }, 
	            contentPanel
	        ],
	        renderTo: Ext.getBody()
	    });
});