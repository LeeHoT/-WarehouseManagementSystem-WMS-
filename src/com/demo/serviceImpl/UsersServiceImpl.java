package com.demo.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;

import com.demo.dao.UsersDao;
import com.demo.service.UsersService;
import com.demo.util.DBUtil;
import com.dhee.dto.UsersDto;

public class UsersServiceImpl implements UsersService {

	private UsersDao usersDao = null;

	public UsersServiceImpl() {
		this.usersDao = new UsersDao();
	}

	/**
	 * 验证登录信息是否正确
	 * 
	 * @param userId
	 *            用户编码
	 * 
	 * @param userPassword
	 *            用户密码
	 * 
	 * @return 成功返回com.demo.dto.UsersDto实例，否则返回null
	 * @throws SQLException
	 */
	@Override
	public UsersDto login(Integer userId, String userPassword) throws SQLException {
		Connection conn = null;
		UsersDto usersDto = null;
		try {
			conn = DBUtil.getConnection();
			usersDto = usersDao.login(conn, userId, userPassword);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return usersDto;
	}

}
