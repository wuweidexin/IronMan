package com.chen.mapping;

import org.hibernate.cfg.*;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestMapping {
	
	public static void main(String[] args) {
//		Configuration：该首先是hibernate提供的一个类，它的作用是用来读取hibernate.cfg.xml文件
		//获得数据库的链接。
		Configuration  cfg=new Configuration().configure();
//		该类是一个工具类，是hibernate给我们提供的怎样将类描述文件转换成表
		SchemaExport  export=new SchemaExport(cfg);
		export.create(true, true);

	}

}
