package com.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class DBUtil {
	// 连接数据库的URL路径
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	// 驱动名称
	//private static final String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	// 连接数据库的用户名
	private static final String USER = "demo";
	// 用户名的密码
	private static final String PASSWORD = "demo";

	private static Connection conn = null;

	/**
	 * 获得数据库的连接对象
	 * 
	 * @return 成功返回java.sql.Connection的实例，否则返回null;
	 * @throws SQLException
	 */
	// 获取数据库连接
	public static Connection getConnection() throws SQLException {
		/**
		 * try { Class.forName(DRIVER_CLASS); conn =
		 * DriverManager.getConnection(URL, USER, PASSWORD);
		 * System.out.println("登录成功"); } catch (ClassNotFoundException e) {
		 * System.out.println("驱动异常导致登录失败"); // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (SQLException e) {
		 * System.out.println("连接数据库失败导致登录失败"); // TODO Auto-generated catch
		 * block e.printStackTrace(); } return conn;
		 */
		//注册驱动类
		DriverManager.registerDriver(new OracleDriver());
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
	}

	
	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}
	/**
	 * 关闭ResultSet,PreparedStatement,Connection
	 * @param ps
	 * @param conn
	 * @param ret
	
	public static void closeConn(PreparedStatement ps, Connection conn, ResultSet ret) {
		if (ret != null) {
			try {
				ret.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	 */

}
