Ext.define('system.ui.ab669fe638414735a114c7b0b24c8fb1.TextField', {
    extend : 'Ext.form.field.Text',
    id : 'ab669fe638414735a114c7b0b24c8fb1',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.f6ba0b529fdd43cdac8397fa277552dd.Label', {
    extend : 'Ext.form.Label',
    id : 'f6ba0b529fdd43cdac8397fa277552dd',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    text : '索引',
    x : 110,
    y : 10,
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.fb67c58d38c54155ab61edc97e686e27.Column', {
    extend : 'Ext.grid.column.Column',
    id : 'fb67c58d38c54155ab61edc97e686e27',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    dataIndex : 'DEL_SYS_DEPT.PARENT_ID',
    dataType : 'String',
    hidden : true,
    length : '32',
    resizable : 'true',
    header : '上级部门ID',
    typeFlag : '0',
    width : 100,
    style : 'text-align:center',
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.ca3e19c640044d9a8031160ff979c618.Button', {
    extend : 'Ext.button.Button',
    id : 'ca3e19c640044d9a8031160ff979c618',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    text : '我的按钮',
    type : 'Button',
    width : 60,
    x : 320,
    y : 10,
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.2c92944246a7594a0146a890b4b00016.Panel', {
    extend : 'Ext.panel.Panel',
    id : '2c92944246a7594a0146a890b4b00016',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    layout : 'absolute',
    initComponent : function() {
        var me = this;
        var items = [];
        Ext.apply(this, {items : items});
        items.push(Ext.create('system.ui.3f77c456b2c244d3bbdfe60b1dc4330f.GridPanel'));
        items.push(Ext.create('system.ui.f6ba0b529fdd43cdac8397fa277552dd.Label'));
        items.push(Ext.create('system.ui.eb87f0d491d74eda8ec5e0325f597e30.TextField'));
        items.push(Ext.create('system.ui.94353039bf364f0fae0b4e8bf5d111ed.TreePanel'));
        items.push(Ext.create('system.ui.ca3e19c640044d9a8031160ff979c618.Button'));
        items.push(Ext.create('system.ui.f9a5fdb7a49b46aaae1a39ea79df1929.DateField'));
        items.push(Ext.create('system.ui.2bba462b682c430a884520e5b32c133e.TimeField'));
        items.push(Ext.create('system.ui.92868d939d9b4b9d8b1e27b9c3339fd9.TextField'));
        items.push(Ext.create('system.ui.e8085cb1af234631af1ae5ccebc408f5.TextField'));
        __UIPageUtil.configPageParams(me);
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);Ext.apply(this, {_table2ElemMap : {'DEL_SYS_DEPT' : [{elem : '3f77c456b2c244d3bbdfe60b1dc4330f', elemType : 'GridPanel', dataFlag : 'DATA'}],'DEL_SYS_COMPANY' : [{elem : '94353039bf364f0fae0b4e8bf5d111ed', elemType : 'TreePanel', dataFlag : 'DATA'}]}, _field2ElemMap : {}});
        this.callParent(arguments);
    }
});
Ext.define('system.ui.8baad7a1a46a44c8947ad40f2038a6c5.Button', {
    extend : 'Ext.button.Button',
    id : '8baad7a1a46a44c8947ad40f2038a6c5',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    text : '修改',
    type : 'Button',
    width : 60,
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.ed50759125254616944cfb51d96e2159.Column', {
    extend : 'Ext.grid.column.Column',
    id : 'ed50759125254616944cfb51d96e2159',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    dataIndex : 'DEL_SYS_DEPT.DEL_STATUS',
    dataType : 'String',
    dictCode : 'DEL_STATUS',
    length : '1',
    resizable : 'true',
    header : '删除标记',
    typeFlag : '0',
    width : 100,
    style : 'text-align:center',
    renderer : function(value) {
        return __STORE_CACHE.getNameByCode('DEL_STATUS', value);
    },
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.2ca2c8c909154f63ba976e7bb703159e.Toolbar', {
    extend : 'Ext.toolbar.Toolbar',
    id : '2ca2c8c909154f63ba976e7bb703159e',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    dock : 'tbar',
    initComponent : function() {
        var me = this;
        var items = [];
        Ext.apply(this, {items : items});
        items.push(Ext.create('system.ui.4d4a16bf4cb04152a928fb6c4ca51196.Button'));
        items.push(Ext.create('system.ui.43c6f8bd5dbb4ae2850c4f5743767df2.Button'));
        items.push(Ext.create('system.ui.8baad7a1a46a44c8947ad40f2038a6c5.Button'));
        items.push(Ext.create('system.ui.50bbb703322149479b4e74e6d5b24c52.Button'));
        items.push(Ext.create('system.ui.67527fba24ad4e55b927047d201f6831.Button'));
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.3f77c456b2c244d3bbdfe60b1dc4330f.GridPanel', {
    extend : 'Ext.grid.Panel',
    id : '3f77c456b2c244d3bbdfe60b1dc4330f',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    anchor : '100%',
    height : 400,
    selType : 'rowmodel',
    title : '部门',
    width : 400,
    x : 250,
    y : 40,
    initComponent : function() {
        var me = this;
        var mystore = Ext.create('system.ui.3f77c456b2c244d3bbdfe60b1dc4330f.GridPanel.Store');
        me.store = mystore;
        var columns = [];
        Ext.apply(this, {columns : columns});
        columns.push(Ext.create('system.ui.106da1a005fc47ef8cfe262640a8e60a.Column'));
        columns.push(Ext.create('system.ui.fb67c58d38c54155ab61edc97e686e27.Column'));
        columns.push(Ext.create('system.ui.40887b218946468497e3d9e20dfe87d0.Column'));
        columns.push(Ext.create('system.ui.504f7cb46c8345f6a3511e5d0e997c44.Column'));
        columns.push(Ext.create('system.ui.bc24e5461d004515a18229e2aa63076a.Column'));
        columns.push(Ext.create('system.ui.cccfa6f1386a41129ec931284a126c44.NumberColumn'));
        columns.push(Ext.create('system.ui.2ab08b36f89242d09b17ad7c2665d52a.NumberColumn'));
        columns.push(Ext.create('system.ui.b90ccb611539498391e58a9bc666fb54.Column'));
        columns.push(Ext.create('system.ui.a0bcab8f51ce410b9d4a13a2edf8e50f.Column'));
        columns.push(Ext.create('system.ui.b1cefa20fa844c6fad19fadaa94e3cc9.Column'));
        columns.push(Ext.create('system.ui.ed50759125254616944cfb51d96e2159.Column'));
        me.tbar = Ext.create('system.ui.2ca2c8c909154f63ba976e7bb703159e.Toolbar');
        me.on('beforerender', function(){
            __UIPageUtil.initActionQueue(me);
            var actionCall_0 = function(){
                var conParams = {
                };
                var curPage = __UIPageUtil.getCurrentPage(me);
                Ext.apply(conParams, {_menuId : curPage._menuId, _subSystemId : curPage._subSystemId});
                ScriptMgr.load({scripts : eval('[]'), callback : function(){
                    var comp = Ext.create('system.commquery.Query', conParams);
                    Ext.apply(comp, {_compId : '100100112101'});
                    var inParams = {
                    'tableCode' : __UIPageUtil.getParamValue(me, 'const', 'String', 'DEL_SYS_DEPT')
                    ,'queryDef' : __UIPageUtil.getParamValue(me, 'const', 'String', '{"distinct":"F","columns":[{"columnCode":"ID","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"PARENT_ID","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"COMPANY_ID","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"CODE","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"NAME","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"GRADE","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"SORT_NUM","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"SEQ","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"LEAF","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"STATUS","tableCode":"DEL_SYS_DEPT","type":"C"},{"columnCode":"DEL_STATUS","tableCode":"DEL_SYS_DEPT","type":"C"}],"tables":{"tableCode":"DEL_SYS_DEPT"}}')
                };
                    var outParams = {};
                    comp.handle(me, inParams, outParams, function(compCallResult){__UIPageUtil.actionCallback(me, outParams, compCallResult);});
                }});
            };
            __UIPageUtil.add2ActionQueue(me, actionCall_0, 'true');
            __UIPageUtil.executeAction(me);
        });
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.2bba462b682c430a884520e5b32c133e.TimeField', {
    extend : 'Ext.form.field.Time',
    id : '2bba462b682c430a884520e5b32c133e',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    format : 'H:i',
    showNowTime : 'true',
    width : 120,
    x : 40,
    y : 460,
    initComponent : function() {
        var me = this;
        me.value = Ext.Date.format(new Date(), 'H:m');
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.b1cefa20fa844c6fad19fadaa94e3cc9.Column', {
    extend : 'Ext.grid.column.Column',
    id : 'b1cefa20fa844c6fad19fadaa94e3cc9',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    dataIndex : 'DEL_SYS_DEPT.STATUS',
    dataType : 'String',
    dictCode : 'AVAILABLE_STATUS',
    length : '1',
    resizable : 'true',
    header : '启用状态',
    typeFlag : '0',
    width : 100,
    style : 'text-align:center',
    renderer : function(value) {
        return __STORE_CACHE.getNameByCode('AVAILABLE_STATUS', value);
    },
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.01f0251a10434836821cc6d721fc5100.Button', {
    extend : 'Ext.button.Button',
    id : '01f0251a10434836821cc6d721fc5100',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    text : '修改',
    type : 'Button',
    width : 60,
    initComponent : function() {
        var me = this;
        me.on('click', function(){
            __UIPageUtil.initActionQueue(me);
            var actionCall_0 = function(){
                var conParams = {
                };
                var curPage = __UIPageUtil.getCurrentPage(me);
                Ext.apply(conParams, {_menuId : curPage._menuId, _subSystemId : curPage._subSystemId});
                ScriptMgr.load({scripts : eval('[]'), callback : function(){
                    var comp = Ext.create('system.uiengine.Engine', conParams);
                    Ext.apply(comp, {_compId : '100100111101'});
                    var inParams = {
                    'pageCode' : __UIPageUtil.getParamValue(me, 'const', 'String', 'shubiaoceshi')
                    ,'pageMode' : __UIPageUtil.getParamValue(me, 'const', 'String', 'WIN')
                    ,'caller' : __UIPageUtil.getParamValue(me, 'const', 'String', 'ENGINE')
                    ,'operationType' : __UIPageUtil.getParamValue(me, 'const', 'String', 'EDIT')
                    ,'pageElem@2c929e3f4572527e014572ce04e80006#63b358e126ed48dfb1a17a616b67a626' : __UIPageUtil.getParamValue(me, 'pageElem', 'String', '2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&e8ba8969e8c34f6ca462b483a54f24ba$DEL_SYS_COMPANY.ID')
                };
                    var outParams = {};
                    outParams['targetElem'] = {
                        valueType : 'pageElem',
                        value : '2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed',
                        dataType : 'Object'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&e8ba8969e8c34f6ca462b483a54f24ba$DEL_SYS_COMPANY.ID'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#63b358e126ed48dfb1a17a616b67a626',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&f5947c94e93e45c3b9bcf0e59d21f8e4$DEL_SYS_COMPANY.PARENT_ID'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#edc6c5ae1647439b93edc7aa7411ad4a',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&5f201a57f16b4fe79a7d457ac14f12f6$DEL_SYS_COMPANY.CODE'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#ea9b7edddc124f14831e37db0d013ac6',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&47991ebc0e204949b069107722197b8b$DEL_SYS_COMPANY.NAME'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#b2136f70dc524f43b337c1d20c937567',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&5218dcd549214ee493a19ad714320b3d$DEL_SYS_COMPANY.SIMPLE_NAME'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#77e886fe55c3403b99e3da117472378b',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&c264c154105a46b88ea91b50ccb6837a$DEL_SYS_COMPANY.COMPANY_GRADE'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#580140544d234b3aa93048ac603c0d28',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&7a21593fa28a4716ae450e07ca8d4f28$DEL_SYS_COMPANY.GRADE'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#e31ea140435d4853b4eb841fd15a2afd',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&6ab8eabd90984a48a04da0bd5676920c$DEL_SYS_COMPANY.SEQ'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#9e7e20ca9633404cbaea12186243a955',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&9df16eb2bc4f4c419d2a4a91884ae080$DEL_SYS_COMPANY.SORT_NUM'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#740bcbd8e6e5449085adf37b4ce658c2',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&570013bc50b44265bdd1a9c2c3718433$DEL_SYS_COMPANY.LEAF'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#1146696103754084b0964329e499952d',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&b4d3b985952843ae8c5db331c9c75180$DEL_SYS_COMPANY.STATUS'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#bcb98f5444bd40e5a37adb9ceeebe085',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&048838743e0a497f88ed90f583a13f4a$DEL_SYS_COMPANY.DEL_STATUS'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#8267c5128507415da64a63c53fb19352',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&07b6778abd7c481bbe5563987df36f11$DEL_SYS_COMPANY.CREATETIME'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#efffce7667c64e769e57e129e73399c6',
                        dataType : 'String'
                    };
                    comp.showPage(me, inParams, outParams, function(compCallResult){__UIPageUtil.actionCallback(me, outParams, compCallResult);});
                }});
            };
            __UIPageUtil.add2ActionQueue(me, actionCall_0, 'true');
            __UIPageUtil.executeAction(me);
        });
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.a0bcab8f51ce410b9d4a13a2edf8e50f.Column', {
    extend : 'Ext.grid.column.Column',
    id : 'a0bcab8f51ce410b9d4a13a2edf8e50f',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    dataIndex : 'DEL_SYS_DEPT.LEAF',
    dataType : 'String',
    length : '1',
    resizable : 'true',
    header : '是否叶子节点',
    typeFlag : '0',
    width : 100,
    style : 'text-align:center',
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.50bbb703322149479b4e74e6d5b24c52.Button', {
    extend : 'Ext.button.Button',
    id : '50bbb703322149479b4e74e6d5b24c52',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    text : '删除',
    type : 'Button',
    width : 60,
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.67527fba24ad4e55b927047d201f6831.Button', {
    extend : 'Ext.button.Button',
    id : '67527fba24ad4e55b927047d201f6831',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    text : '表格行添加',
    type : 'Button',
    width : 60,
    initComponent : function() {
        var me = this;
        me.on('click', function(){
            __UIPageUtil.initActionQueue(me);
            var actionCall_0 = function(){
                var conParams = {
                };
                var curPage = __UIPageUtil.getCurrentPage(me);
                Ext.apply(conParams, {_menuId : curPage._menuId, _subSystemId : curPage._subSystemId});
                ScriptMgr.load({scripts : eval('["system/uicomp/GridRowGenerator.js"]'), callback : function(){
                    var comp = Ext.create('system.uicomp.GridRowGenerator', conParams);
                    Ext.apply(comp, {_compId : '100100150105'});
                    var inParams = {
                    ' tableCode' : __UIPageUtil.getParamValue(me, 'const', 'String', 'DEL_SYS_DEPT')
                    ,' copyMode ' : __UIPageUtil.getParamValue(me, 'const', 'String', 'SELECTED')
                    ,' rowCount' : __UIPageUtil.getParamValue(me, 'const', 'Integer', '1')
                };
                    var outParams = {};
                    comp.handle(me, inParams, outParams, function(compCallResult){__UIPageUtil.actionCallback(me, outParams, compCallResult);});
                }});
            };
            __UIPageUtil.add2ActionQueue(me, actionCall_0, 'true');
            __UIPageUtil.executeAction(me);
        });
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.bc24e5461d004515a18229e2aa63076a.Column', {
    extend : 'Ext.grid.column.Column',
    id : 'bc24e5461d004515a18229e2aa63076a',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    dataIndex : 'DEL_SYS_DEPT.NAME',
    dataType : 'String',
    length : '200',
    resizable : 'true',
    header : '名称',
    typeFlag : '0',
    width : 100,
    style : 'text-align:center',
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.3cddb38f05124921abd2c66c5d0c08ec.Button', {
    extend : 'Ext.button.Button',
    id : '3cddb38f05124921abd2c66c5d0c08ec',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    text : '删除',
    type : 'Button',
    width : 60,
    initComponent : function() {
        var me = this;
        me.on('click', function(){
            __UIPageUtil.initActionQueue(me);
            var actionCall_0 = function(){
                var conParams = {
                };
                var curPage = __UIPageUtil.getCurrentPage(me);
                Ext.apply(conParams, {_menuId : curPage._menuId, _subSystemId : curPage._subSystemId});
                ScriptMgr.load({scripts : eval('[]'), callback : function(){
                    var comp = Ext.create('system.commremove.Remove', conParams);
                    Ext.apply(comp, {_compId : '100100115101'});
                    var inParams = {
                    'tableCode' : __UIPageUtil.getParamValue(me, 'const', 'String', 'DEL_SYS_COMPANY')
                    ,'confirmMsgTpl' : __UIPageUtil.getParamValue(me, 'const', 'String', '')
                    ,'okMsg' : __UIPageUtil.getParamValue(me, 'const', 'String', '')
                    ,'ngMsg' : __UIPageUtil.getParamValue(me, 'const', 'String', '')
                };
                    var outParams = {};
                    comp.handle(me, inParams, outParams, function(compCallResult){__UIPageUtil.actionCallback(me, outParams, compCallResult);});
                }});
            };
            __UIPageUtil.add2ActionQueue(me, actionCall_0, 'true');
            __UIPageUtil.executeAction(me);
        });
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.40887b218946468497e3d9e20dfe87d0.Column', {
    extend : 'Ext.grid.column.Column',
    id : '40887b218946468497e3d9e20dfe87d0',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    dataIndex : 'DEL_SYS_DEPT.COMPANY_ID',
    dataType : 'String',
    hidden : true,
    length : '32',
    refCol : 'ID',
    refTable : 'DEL_SYS_COMPANY',
    resizable : 'true',
    header : '上级单位ID',
    typeFlag : '2',
    width : 100,
    style : 'text-align:center',
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.3f77c456b2c244d3bbdfe60b1dc4330f.GridPanel.Store', {
    extend: 'Ext.data.Store',
    autoLoad : false,
    proxy: {
        type: 'ajax',
        url: '',
        actionMethods: {read: 'post'},
        reader: {root: 'list', totalProperty: 'totalCounts', useSimpleAccessors: true},
        writer: {type: 'json'}
    },
    fields : ['DEL_SYS_DEPT.LEAF', 'DEL_SYS_DEPT.SEQ', 'DEL_SYS_DEPT.DEL_STATUS', 'DEL_SYS_DEPT.STATUS', 'DEL_SYS_DEPT.CODE', 'DEL_SYS_DEPT.NAME', 'DEL_SYS_DEPT.COMPANY_ID', 'DEL_SYS_DEPT.GRADE', 'DEL_SYS_DEPT.PARENT_ID', 'DEL_SYS_DEPT.SORT_NUM', 'DEL_SYS_DEPT.ID']
});Ext.define('system.ui.43c6f8bd5dbb4ae2850c4f5743767df2.Button', {
    extend : 'Ext.button.Button',
    id : '43c6f8bd5dbb4ae2850c4f5743767df2',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    text : '添加',
    type : 'Button',
    width : 60,
    initComponent : function() {
        var me = this;
        me.on('click', function(){
            __UIPageUtil.initActionQueue(me);
            var actionCall_0 = function(){
                var conParams = {
                };
                var curPage = __UIPageUtil.getCurrentPage(me);
                Ext.apply(conParams, {_menuId : curPage._menuId, _subSystemId : curPage._subSystemId});
                ScriptMgr.load({scripts : eval('[]'), callback : function(){
                    var comp = Ext.create('system.uiengine.Engine', conParams);
                    Ext.apply(comp, {_compId : '100100111101'});
                    var inParams = {
                    'pageCode' : __UIPageUtil.getParamValue(me, 'const', 'String', 'shubiaoceshi')
                    ,'pageMode' : __UIPageUtil.getParamValue(me, 'const', 'String', 'WIN')
                    ,'caller' : __UIPageUtil.getParamValue(me, 'const', 'String', 'ENGINE')
                    ,'operationType' : __UIPageUtil.getParamValue(me, 'const', 'String', 'ADD')
                };
                    var outParams = {};
                    comp.showPage(me, inParams, outParams, function(compCallResult){__UIPageUtil.actionCallback(me, outParams, compCallResult);});
                }});
            };
            __UIPageUtil.add2ActionQueue(me, actionCall_0, 'true');
            __UIPageUtil.executeAction(me);
        });
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.419f99eea36d43d6a69fff3f3facac5b.TextField', {
    extend : 'Ext.form.field.Text',
    id : '419f99eea36d43d6a69fff3f3facac5b',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    height : 30,
    width : 50,
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.eb87f0d491d74eda8ec5e0325f597e30.TextField', {
    extend : 'Ext.form.field.Text',
    id : 'eb87f0d491d74eda8ec5e0325f597e30',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    width : 120,
    x : 170,
    y : 10,
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.94353039bf364f0fae0b4e8bf5d111ed.TreePanel.Store', {
    extend : 'Ext.data.TreeStore',
    nodeParam : 'parentId',
    autoLoad : false,
    root : {
        text : '根',
        cls : 'folder',
        id : 'NA',
        expanded : false,
        visible : false
    },
    proxy : {
        type : 'ajax',
        url : '',
        actionMethods: {read: 'post'},
        reader : {type : 'json', root : 'children', useSimpleAccessors : true}
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    },
    initComponent : function() {
        this.callParent(arguments);
    }
});Ext.define('system.ui.b90ccb611539498391e58a9bc666fb54.Column', {
    extend : 'Ext.grid.column.Column',
    id : 'b90ccb611539498391e58a9bc666fb54',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    dataIndex : 'DEL_SYS_DEPT.SEQ',
    dataType : 'String',
    length : '200',
    resizable : 'true',
    header : '层级编码',
    typeFlag : '0',
    width : 100,
    style : 'text-align:center',
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.2ab08b36f89242d09b17ad7c2665d52a.NumberColumn', {
    extend : 'Ext.grid.column.Number',
    id : '2ab08b36f89242d09b17ad7c2665d52a',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    dataIndex : 'DEL_SYS_DEPT.SORT_NUM',
    dataType : 'Number',
    format : '0,000.00',
    length : '3',
    resizable : 'true',
    header : '同级排序码',
    typeFlag : '0',
    width : 100,
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.92868d939d9b4b9d8b1e27b9c3339fd9.TextField', {
    extend : 'Ext.form.field.Text',
    id : '92868d939d9b4b9d8b1e27b9c3339fd9',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    name : 'init',
    width : 120,
    x : 360,
    y : 460,
    initComponent : function() {
        var me = this;
        var items = [];
        Ext.apply(this, {items : items});
        me.on('beforerender', function(){
            __UIPageUtil.initActionQueue(me);
            var actionCall_0 = function(){
                var conParams = {
                };
                var curPage = __UIPageUtil.getCurrentPage(me);
                Ext.apply(conParams, {_menuId : curPage._menuId, _subSystemId : curPage._subSystemId});
                ScriptMgr.load({scripts : eval('["system/uicomp/ValueSetter.js"]'), callback : function(){
                    var comp = Ext.create('system.uicomp.ValueSetter', conParams);
                    Ext.apply(comp, {_compId : '100100150201'});
                    var inParams = {
                };
                    var outParams = {};
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#92868d939d9b4b9d8b1e27b9c3339fd9'] = {
                        valueType : 'globalVar',
                        value : '__userCode',
                        dataType : 'String'
                    };
                    comp.handle(me, inParams, outParams, function(compCallResult){__UIPageUtil.actionCallback(me, outParams, compCallResult);});
                }});
            };
            __UIPageUtil.add2ActionQueue(me, actionCall_0, 'true');
            __UIPageUtil.executeAction(me);
        });
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.4d4a16bf4cb04152a928fb6c4ca51196.Button', {
    extend : 'Ext.button.Button',
    id : '4d4a16bf4cb04152a928fb6c4ca51196',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    text : '查询',
    type : 'Button',
    width : 60,
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.f9a5fdb7a49b46aaae1a39ea79df1929.DateField', {
    extend : 'Ext.form.field.Date',
    id : 'f9a5fdb7a49b46aaae1a39ea79df1929',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    format : 'Y-m-d H:i:s',
    width : 120,
    x : 200,
    y : 460,
    initComponent : function() {
        var me = this;
        me.value = new Date();
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.504f7cb46c8345f6a3511e5d0e997c44.Column', {
    extend : 'Ext.grid.column.Column',
    id : '504f7cb46c8345f6a3511e5d0e997c44',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    dataIndex : 'DEL_SYS_DEPT.CODE',
    dataType : 'String',
    length : '64',
    resizable : 'true',
    header : '编码',
    typeFlag : '0',
    width : 100,
    style : 'text-align:left',
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.c7148260de0941008c3d4d05bebf299f.Button', {
    extend : 'Ext.button.Button',
    id : 'c7148260de0941008c3d4d05bebf299f',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    text : '通用选择',
    type : 'Button',
    width : 60,
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.fb56ec06f572421b83bf2ba046b28e6a.Button', {
    extend : 'Ext.button.Button',
    id : 'fb56ec06f572421b83bf2ba046b28e6a',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    text : '添加',
    type : 'Button',
    width : 60,
    initComponent : function() {
        var me = this;
        me.on('click', function(){
            __UIPageUtil.initActionQueue(me);
            var actionCall_0 = function(){
                var conParams = {
                };
                var curPage = __UIPageUtil.getCurrentPage(me);
                Ext.apply(conParams, {_menuId : curPage._menuId, _subSystemId : curPage._subSystemId});
                ScriptMgr.load({scripts : eval('[]'), callback : function(){
                    var comp = Ext.create('system.uiengine.Engine', conParams);
                    Ext.apply(comp, {_compId : '100100111101'});
                    var inParams = {
                    'pageCode' : __UIPageUtil.getParamValue(me, 'const', 'String', 'shubiaoceshi')
                    ,'pageMode' : __UIPageUtil.getParamValue(me, 'const', 'String', 'WIN')
                    ,'caller' : __UIPageUtil.getParamValue(me, 'const', 'String', 'ENGINE')
                    ,'operationType' : __UIPageUtil.getParamValue(me, 'const', 'String', 'ADD')
                    ,'pageElem@2c929e3f4572527e014572ce04e80006#edc6c5ae1647439b93edc7aa7411ad4a' : __UIPageUtil.getParamValue(me, 'pageElem', 'String', '2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&e8ba8969e8c34f6ca462b483a54f24ba$DEL_SYS_COMPANY.ID')
                };
                    var outParams = {};
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&e8ba8969e8c34f6ca462b483a54f24ba$DEL_SYS_COMPANY.ID'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#63b358e126ed48dfb1a17a616b67a626',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&f5947c94e93e45c3b9bcf0e59d21f8e4$DEL_SYS_COMPANY.PARENT_ID'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#edc6c5ae1647439b93edc7aa7411ad4a',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&5f201a57f16b4fe79a7d457ac14f12f6$DEL_SYS_COMPANY.CODE'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#ea9b7edddc124f14831e37db0d013ac6',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&47991ebc0e204949b069107722197b8b$DEL_SYS_COMPANY.NAME'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#b2136f70dc524f43b337c1d20c937567',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&5218dcd549214ee493a19ad714320b3d$DEL_SYS_COMPANY.SIMPLE_NAME'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#77e886fe55c3403b99e3da117472378b',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&c264c154105a46b88ea91b50ccb6837a$DEL_SYS_COMPANY.COMPANY_GRADE'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#580140544d234b3aa93048ac603c0d28',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&7a21593fa28a4716ae450e07ca8d4f28$DEL_SYS_COMPANY.GRADE'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#e31ea140435d4853b4eb841fd15a2afd',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&6ab8eabd90984a48a04da0bd5676920c$DEL_SYS_COMPANY.SEQ'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#9e7e20ca9633404cbaea12186243a955',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&9df16eb2bc4f4c419d2a4a91884ae080$DEL_SYS_COMPANY.SORT_NUM'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#740bcbd8e6e5449085adf37b4ce658c2',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&570013bc50b44265bdd1a9c2c3718433$DEL_SYS_COMPANY.LEAF'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#1146696103754084b0964329e499952d',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&b4d3b985952843ae8c5db331c9c75180$DEL_SYS_COMPANY.STATUS'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#bcb98f5444bd40e5a37adb9ceeebe085',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&048838743e0a497f88ed90f583a13f4a$DEL_SYS_COMPANY.DEL_STATUS'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#8267c5128507415da64a63c53fb19352',
                        dataType : 'String'
                    };
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#94353039bf364f0fae0b4e8bf5d111ed&07b6778abd7c481bbe5563987df36f11$DEL_SYS_COMPANY.CREATETIME'] = {
                        valueType : 'pageElem',
                        value : '2c929e3f4572527e014572ce04e80006#efffce7667c64e769e57e129e73399c6',
                        dataType : 'String'
                    };
                    comp.showPage(me, inParams, outParams, function(compCallResult){__UIPageUtil.actionCallback(me, outParams, compCallResult);});
                }});
            };
            __UIPageUtil.add2ActionQueue(me, actionCall_0, 'true');
            __UIPageUtil.executeAction(me);
        });
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.106da1a005fc47ef8cfe262640a8e60a.Column', {
    extend : 'Ext.grid.column.Column',
    id : '106da1a005fc47ef8cfe262640a8e60a',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    dataIndex : 'DEL_SYS_DEPT.ID',
    dataType : 'String',
    hidden : true,
    length : '32',
    resizable : 'true',
    header : 'ID',
    typeFlag : '1',
    width : 100,
    style : 'text-align:center',
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.94353039bf364f0fae0b4e8bf5d111ed.TreePanel', {
    extend : 'Ext.tree.Panel',
    id : '94353039bf364f0fae0b4e8bf5d111ed',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    height : 400,
    title : '公司',
    width : 250,
    x : 0,
    y : 40,
    initComponent : function() {
        var me = this;
        me.store = Ext.create('system.ui.94353039bf364f0fae0b4e8bf5d111ed.TreePanel.Store', {fields : ['id', 'text', 'leaf', 'DEL_SYS_COMPANY.ID','DEL_SYS_COMPANY.PARENT_ID','DEL_SYS_COMPANY.CODE','DEL_SYS_COMPANY.NAME','DEL_SYS_COMPANY.SIMPLE_NAME','DEL_SYS_COMPANY.COMPANY_GRADE','DEL_SYS_COMPANY.GRADE','DEL_SYS_COMPANY.SEQ','DEL_SYS_COMPANY.SORT_NUM','DEL_SYS_COMPANY.LEAF','DEL_SYS_COMPANY.STATUS','DEL_SYS_COMPANY.DEL_STATUS','DEL_SYS_COMPANY.CREATETIME']});
        me.tbar = Ext.create('system.ui.a785c96195e9489e9db0a3402c030c3d.Toolbar');
        me.on('beforerender', function(){
        });
        me.on('itemclick', function(){
        });
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(config, {rootVisible : false});
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.cccfa6f1386a41129ec931284a126c44.NumberColumn', {
    extend : 'Ext.grid.column.Number',
    id : 'cccfa6f1386a41129ec931284a126c44',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    dataIndex : 'DEL_SYS_DEPT.GRADE',
    dataType : 'Number',
    format : '0,000.00',
    length : '3',
    resizable : 'true',
    header : '级别',
    typeFlag : '0',
    width : 100,
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.e8085cb1af234631af1ae5ccebc408f5.TextField', {
    extend : 'Ext.form.field.Text',
    id : 'e8085cb1af234631af1ae5ccebc408f5',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    name : '常量初始化',
    width : 120,
    x : 510,
    y : 460,
    initComponent : function() {
        var me = this;
        var items = [];
        Ext.apply(this, {items : items});
        me.on('beforerender', function(){
            __UIPageUtil.initActionQueue(me);
            var actionCall_0 = function(){
                var conParams = {
                };
                var curPage = __UIPageUtil.getCurrentPage(me);
                Ext.apply(conParams, {_menuId : curPage._menuId, _subSystemId : curPage._subSystemId});
                ScriptMgr.load({scripts : eval('["system/uicomp/ValueSetter.js"]'), callback : function(){
                    var comp = Ext.create('system.uicomp.ValueSetter', conParams);
                    Ext.apply(comp, {_compId : '100100150201'});
                    var inParams = {
                };
                    var outParams = {};
                    outParams['pageElem@2c92944246a7594a0146a890b4b00016#e8085cb1af234631af1ae5ccebc408f5'] = {
                        valueType : 'const',
                        value : '我们的歌',
                        dataType : 'String'
                    };
                    comp.handle(me, inParams, outParams, function(compCallResult){__UIPageUtil.actionCallback(me, outParams, compCallResult);});
                }});
            };
            __UIPageUtil.add2ActionQueue(me, actionCall_0, 'true');
            __UIPageUtil.executeAction(me);
        });
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.104f618c11894289b9cf3f3da944a83b.TextField', {
    extend : 'Ext.form.field.Text',
    id : '104f618c11894289b9cf3f3da944a83b',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    height : 10,
    width : 50,
    initComponent : function() {
        var me = this;
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
Ext.define('system.ui.a785c96195e9489e9db0a3402c030c3d.Toolbar', {
    extend : 'Ext.toolbar.Toolbar',
    id : 'a785c96195e9489e9db0a3402c030c3d',
    _pageId : '2c92944246a7594a0146a890b4b00016',
    dock : 'tbar',
    initComponent : function() {
        var me = this;
        var items = [];
        Ext.apply(this, {items : items});
        items.push(Ext.create('system.ui.fb56ec06f572421b83bf2ba046b28e6a.Button'));
        items.push(Ext.create('system.ui.01f0251a10434836821cc6d721fc5100.Button'));
        items.push(Ext.create('system.ui.3cddb38f05124921abd2c66c5d0c08ec.Button'));
        items.push(Ext.create('system.ui.c7148260de0941008c3d4d05bebf299f.Button'));
        this.callParent(arguments);
    },
    constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent(arguments);
    }
});
