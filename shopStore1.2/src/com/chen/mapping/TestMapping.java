package com.chen.mapping;

import org.hibernate.cfg.*;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestMapping {
	
	public static void main(String[] args) {
//		Configuration����������hibernate�ṩ��һ���࣬����������������ȡhibernate.cfg.xml�ļ�
		//������ݿ�����ӡ�
		Configuration  cfg=new Configuration().configure();
//		������һ�������࣬��hibernate�������ṩ���������������ļ�ת���ɱ�
		SchemaExport  export=new SchemaExport(cfg);
		export.create(true, true);

	}

}
