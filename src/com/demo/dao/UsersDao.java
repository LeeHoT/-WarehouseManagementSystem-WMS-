package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dhee.dto.UsersDto;

public class UsersDao {

	/**
	 * 对Users表进行增、删、改、查等操作
	 * @param conn
	 *            数据库连接对象
	 * @param userId
	 *            用户编号
	 * @param userPassword
	 *            用户密码
	 * @return 登录成功后返回com.demo.dto.UsersDto,否则返回null;
	 * @throws SQLException
	 */
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet ret = null;

	public UsersDto login(Connection conn, Integer userId, String userPassword) throws SQLException {
		UsersDto usersDto = null;
		try {
			String sql = "SELECT USER_NAME FROM USERS WHERE USER_ID = ? AND USER_PASSWORD = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setString(2, userPassword);
			ret = ps.executeQuery();
			//System.out.println("..............."+ret);
			if (ret.next()) {
				usersDto = new UsersDto();
				usersDto.setUSER_ID(userId);
				usersDto.setUSER_NAME(ret.getString("USER_NAME"));
				usersDto.setUSER_PASSWORD(userPassword);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (ret != null) {
				ret.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
		//System.out.println("??????"+usersDto);
		return usersDto;
	}
	
}


