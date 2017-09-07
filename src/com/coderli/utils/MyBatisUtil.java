package com.coderli.utils;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis的工具类用于获取SqlSessionFactory对象
 * @author lishichun
 *
 */
public class MyBatisUtil {
	private static SqlSessionFactory factory;

	public static SqlSessionFactory getSqlSessionFactory() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		factory = new SqlSessionFactoryBuilder().build(is);
		return factory;
	}
}
