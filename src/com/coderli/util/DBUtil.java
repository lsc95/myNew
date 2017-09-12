package com.coderli.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private DBUtil(){}
	/**
	 * 获取数据库连接对象
	 * @return 返回数据库连接对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException 
	 */
	public static Connection getConnection() throws ClassNotFoundException,SQLException, IOException {
		Properties properties=new Properties();
		properties.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
		Class.forName(properties.getProperty("jdbc.driver"));
		return DriverManager.getConnection(properties.getProperty("jdbc.url"), properties.getProperty("jdbc.user"),properties.getProperty("jdbc.password"));
	}
	/**
	 * 关闭数据库资源
	 * @param conn 
	 * @param ps
	 * @param rs
	 */
	public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs){
		if(rs!=null){
			try {
				if(!rs.isClosed()){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				if(!ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				if(!conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
