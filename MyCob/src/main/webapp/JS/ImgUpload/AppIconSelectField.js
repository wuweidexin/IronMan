//Ext.ns('Adc.components');
Ext.define("JS.ImgUpload.AppIconSelectField",{
	extend : 'Ext.form.field.Text',
	imageFilePath : 'Images/',
    imageFilePreffix : 'icon',
    imageFileSuffix : '.jpg',
    maxImgCount : 120,
    constructor : function(config) {
    	config = config || {};
        Ext.apply(this, config);
        this.initImageData();      
        this.callParent(arguments);
    },
    initImageData : function() {
        var data = {};
        data.images = [];
        for (i = 1; i < this.maxImgCount; i++) {
            //i=i<10?'0'+i:i;
            var name = this.imageFilePreffix + i + this.imageFileSuffix;
            var url = this.imageFilePath + name;
            var o = {};
            o.name = name;
            o.url = url;
            data.images.push(o);
        };
        this.imageData = data;
    },
    initComponent : function() {
        this.callParent(arguments);
        //添加事件
        this.addEvents(
                //当输入框被赋值时触发
                'datachange');
        this.buidImageField();
    },
//    onRender : function(ct, position) {
//        Adc.components.AppIconSelectField.superclass.onRender.call(this, ct,
//                position);
//        //将输入表单隐藏
//        try {
//            this.el.dom.setAttribute('type', 'hidden');
//        } catch (e) {
//            this.el.dom.style.display = "none";
//        }
//        
//    },
    buidImageField : function() {
        this.wrap = this.el.wrap({
                    cls : 'x-form-field-wrap adc-form-field-img-wrap'
                });
        var imgEl = this.wrap.createChild({
                    tag : 'img',
                    src : 'Images/icon01.jpg',
                    width : 45,
                    height : 45
                });
        this.imgEl = imgEl;
        var trigger = this.wrap.createChild({
                    tag : 'img',
                    src : Ext.BLANK_IMAGE_URL,
                    alt : "",
                    cls : "x-form-trigger adc-form-appIcon-trigger "
                            + this.triggerClass
                });
        this.trigger = trigger;

        this.initTrigger();
        if (!this.width) {
            this.wrap.setWidth(this.imgEl.getWidth() + this.trigger.getWidth()
                    + 5);
        }
        this.resizeEl = this.positionEl = this.wrap;
    },
    initTrigger : function() {
        this.mon(this.trigger, 'click', this.onTriggerClick, this, {
                    preventDefault : true
                });
    },
    buildImageView : function() {
        var me = this;
        var imgEl = me.imgEl;
        var data = me.imageData;
        var store = new Ext.data.JsonStore({
                    data : data,
                    root : 'images',
                    fields : ['name', 'url']
                });
        var tpl = new Ext.XTemplate(
                '<tpl for=".">',
                '<div id="{url}" class="x-plain app-icon-view-wrap">',
                '<div class="app-icon-body"><img src="{url}" style="width: 45px; height: 45px;" title="{name}"></div>',
                '</div>', '</tpl>', '<div class="x-clear"></div>');

        var imageView = new Ext.DataView({
                    store : store,
                    tpl : tpl,
                    autoHeight : true,
                    singleSelect : true,
                    trackOver : true,
                    overClass : 'tpl-model-view-over',
                    itemSelector : 'div.app-icon-view-wrap',
                    selectedClass : 'tpl-model-view-selected',
                    emptyText : '没有可显示的图片'
                });
        var win = new Ext.Window({
                    width : 850,
                    height : 450,
                    modal : true,
                    title : '请选择',
                    layout : 'fit',
                    items : imageView
                });
        imageView.on('click', function(view, index, node, e) {
                    var rec = store.data.get(index);
                    var url = rec.data.url;
                    me.value = url;
                    me.el.dom.value = url;
                    imgEl.dom.setAttribute('src', url);
                    win.close();
                });
        win.show();
        win.body.setStyle('background-color', '#fff');
    },
    getValue : function() {
        return this.value;
    },
    setValue : function(v) {
        this.value = v;
//        this.el.dom.value = v;
//        if (this.imgEl) {
//            this.imgEl.dom.setAttribute('src', v);
//        }
        return this;
    },
    onTriggerClick : function(trigger) {
        this.buildImageView();
    }

});
