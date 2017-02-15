package com.demo.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.demo.dao.ProviderDao;
import com.demo.util.DBUtil;
import com.dhee.dto.ProviderDto;

public class ProviderServiceImpl {
	ProviderDao providerDao = null;

	public ProviderServiceImpl() {
		this.providerDao = new ProviderDao();
	}

	/**
	 * 添加供应商信息
	 * 
	 * @param providerDto
	 * @return
	 * @throws SQLException
	 */
	public boolean addProvider(ProviderDto providerDto) throws SQLException {
		Connection conn = null;
		int flag = 0;
		try {
			conn = DBUtil.getConnection();
			// 只有INSERT、DELETE、UPDATE时需要
			conn.setAutoCommit(false);
			flag = providerDao.insert(conn, providerDto);
			if (flag > 0) {
				conn.commit();
				return true;
			}
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return false;

	}

	/**
	 * 获取所有供应商信息
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<ProviderDto> getAllProvider() throws SQLException {
		Connection conn = null;
		List<ProviderDto> list = null;
		try {
			conn = DBUtil.getConnection();
			list = providerDao.getAllProvider(conn);
			System.out.println("service" + list);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}

	/**
	 * 根据面子查询供应商
	 * 
	 * @param currPage
	 * @param rowCount
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public List<ProviderDto> getProviderByName(Integer currPage, Integer rowCount, String name) throws SQLException {
		Connection conn = null;
		List<ProviderDto> list = null;
		System.out.println(currPage + rowCount);
		int start = (currPage - 1) * rowCount + 1;
		int end = currPage * rowCount;
		try {
			conn = DBUtil.getConnection();
			list = providerDao.selectPage(conn, start, end, name);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}

	public Integer getMaxPage(String message, Integer rowCount) throws SQLException {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			return this.providerDao.getMaxPage(conn, rowCount, message);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public List<ProviderDto> getProviderByAll(Integer currPage, Integer rowCount, ProviderDto providerDto)
			throws SQLException, ParseException {
		Connection conn = null;
		List<ProviderDto> list = null;
		System.out.println(currPage + rowCount);
		int start = (currPage - 1) * rowCount + 1;
		int end = currPage * rowCount;
		try {
			conn = DBUtil.getConnection();
			list = providerDao.getProviderByAll(conn, start, end, providerDto);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}

	public boolean modifyProvider(ProviderDto providerDto) throws SQLException {
		Connection conn = null;
		int flag = 0;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			flag = providerDao.modifyProvider(conn, providerDto);
			if (flag > 0) {
				return true;
			}
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return false;
	}
	
	public boolean deleteProviderById(int id) throws SQLException{
		Connection conn = null;
		boolean flag = false;
		try {
			conn = DBUtil.getConnection();
			flag = providerDao.deleteProviderbyId(conn, id);
		} finally {
			if(conn!=null){
				conn.close();
			}
		}
		return flag;
	}
	
	//根据供应商Id获取供应商姓名
	public String getProviderNameById(int id) throws SQLException{
		Connection conn = null;
		String providerName = null;
		try {
			conn = DBUtil.getConnection();
			providerName = providerDao.getProviderNameById(conn, id);
		} finally {
			if(conn!=null){
				conn.close();
			}
		}
		return providerName;
	}
}
