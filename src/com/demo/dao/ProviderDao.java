package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.dhee.dto.ProviderDto;

public class ProviderDao {

	public int insert(Connection conn, ProviderDto providerDto) throws SQLException {
		PreparedStatement ps = null;
		String sql = "INSERT INTO PROVIDER VALUES(PRODUCT_ID_SEQ.NEXTVAL,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, providerDto.getName());
		ps.setString(2, providerDto.getAddress());
		ps.setString(3, providerDto.getPhone());
		ps.setString(4, providerDto.getPostal());
		int rows = ps.executeUpdate();
		if (rows > 0) {
			return rows;
		}
		return 0;

	}

	public List<ProviderDto> getAllProvider(Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		ProviderDto providerDto = null;
		List<ProviderDto> list = null;
		String sql = "SELECT ID,NAME,ADDRESS,PHONE,POSTAL FROM PROVIDER";
		try {
			ps = conn.prepareStatement(sql);
			ret = ps.executeQuery();
			list = new ArrayList<ProviderDto>();
			while (ret.next()) {
				providerDto = new ProviderDto();
				providerDto.setId(ret.getInt("ID"));
				providerDto.setName(ret.getString("NAME"));
				providerDto.setAddress(ret.getString("ADDRESS"));
				providerDto.setPhone(ret.getString("PHONE"));
				providerDto.setPostal(ret.getString("POSTAl"));
				System.out.println("ProviderDao." + ret.getString("PHONE"));
				list.add(providerDto);
			}
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (ret != null) {
				ret.close();
			}
		}
		return list;

	}

	public List<ProviderDto> selectPage(Connection conn, int start, int end, String name) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		List<ProviderDto> list = null;
		try {
			String sql = "SELECT R,ID,NAME,ADDRESS,PHONE,POSTAL "
					+ "FROM (SELECT ROW_NUMBER() OVER(ORDER BY ID DESC) AS R,ID,NAME,ADDRESS,PHONE,POSTAL "
					+ "FROM PROVIDER WHERE NAME LIKE ?)WHERE R BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ps.setInt(2, start);
			ps.setInt(3, end);
			ret = ps.executeQuery();
			// 将结果集中的数据封装到List集合中
			// 创建一个集合，用于保存结果集中所有的数据
			list = new ArrayList<ProviderDto>();
			// 声明一个Dto，用于保存结果集中的一行数据
			ProviderDto providerDto = null;// 不能new
			// 使用循环将结果集中的数据封装到List集合中
			while (ret.next()) {
				providerDto = new ProviderDto();
				providerDto.setId(ret.getInt("ID"));
				providerDto.setName(ret.getString("NAME"));
				providerDto.setAddress(ret.getString("ADDRESS"));
				providerDto.setPhone(ret.getString("PHONE"));
				providerDto.setPostal(ret.getString("POSTAL"));
				// 将DTO添加到List集合中
				list.add(providerDto);
			}
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (ret != null) {
				ret.close();
			}
		}
		return list;
	}

	public Integer getMaxPage(Connection conn, Integer rowCount, String name) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		try {
			String sql = "SELECT CEIL(COUNT(*)/?) AS C FROM PROVIDER WHERE NAME LIKE ?";
			ps = conn.prepareStatement(sql);
			ps.setString(2, "%" + name + "%");
			ps.setInt(1, rowCount);
			ret = ps.executeQuery();
			ret.next();
			return ret.getInt("C");
		} finally {
			if (ret != null) {
				ret.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
	}

	public List<ProviderDto> getProviderByAll(Connection conn, int start, int end, ProviderDto providerDto)
			throws SQLException, ParseException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		List<ProviderDto> list = null;
		try {
			String sql = "SELECT R,ID,NAME,ADDRESS,PHONE,POSTAL "
					+ "FROM (SELECT ROW_NUMBER() OVER(ORDER BY ID DESC) AS R,ID,NAME,ADDRESS,PHONE,POSTAL "
					+ "FROM PROVIDER WHERE ID LIKE ? AND NAME LIKE ? AND ADDRESS LIKE ? AND PHONE LIKE ? AND POSTAL LIKE ?)WHERE R BETWEEN ? AND ?";
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			if (providerDto.getId() != null) {
				ps.setString(1, "%" + providerDto.getId() + "%");
			} else {
				ps.setString(1, "%");
			}
			if (providerDto.getName() != null) {
				ps.setString(2, "%" + providerDto.getName() + "%");
			} else {
				ps.setString(2, "%");
			}
			if (providerDto.getAddress() != null) {
				ps.setString(3, "%" + providerDto.getAddress() + "%");
			} else {
				ps.setString(3, "%");
			}
			if (providerDto.getPhone() != null) {
				ps.setString(4, "%" + providerDto.getPhone() + "%");

			} else {
				ps.setString(4, "%");
			}
			if (providerDto.getPostal() != null) {
				ps.setString(5, "%" + providerDto.getPostal() + "%");
			} else {
				ps.setString(5, "%");
			}
			ps.setInt(6, start);
			ps.setInt(7, end);
			ret = ps.executeQuery();
			// 将结果集中的数据封装到List集合中
			// 创建一个集合，用于保存结果集中所有的数据
			list = new ArrayList<ProviderDto>();
			// 声明一个Dto，用于保存结果集中的一行数据
			ProviderDto providerDto2 = null;// 不能new
			// 使用循环将结果集中的数据封装到List集合中
			while (ret.next()) {
				providerDto2 = new ProviderDto();
				// 将结果集当前行指定列的值赋值给Dto对应的属性中
				providerDto2.setId(ret.getInt("ID"));
				providerDto2.setName(ret.getString("NAME"));
				providerDto2.setAddress(ret.getString("ADDRESS"));
				providerDto2.setPhone(ret.getString("PHONE"));
				providerDto2.setPostal(ret.getString("POSTAL"));
				// 将DTO添加到List集合中
				list.add(providerDto2);
			}
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (ret != null) {
				ret.close();
			}
		}
		return list;

	}

	@SuppressWarnings("resource")
	public int modifyProvider(Connection conn, ProviderDto providerDto) throws SQLException {
		PreparedStatement ps = null;
		int flag = 0;
		try {
			// 删除已有的用户信息要更新的供应商信息
			String dsql = "DELETE FROM PROVIDER WHERE ID = ?";
			ps = conn.prepareStatement(dsql);
			ps.setInt(1, providerDto.getId());
			ps.executeUpdate();
			// 将更改后的信息插入到供应商表中
			String sql = "INSERT INTO PROVIDER VALUES(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, providerDto.getId());
			ps.setString(2, providerDto.getName());
			ps.setString(3, providerDto.getAddress());
			ps.setString(4, providerDto.getPhone());
			ps.setString(5, providerDto.getPostal());
			flag = ps.executeUpdate();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
		return flag;
	}

	/**
	 * 根据名称获取供应商ID
	 * 
	 * @param conn
	 * @param providerName
	 * @return
	 * @throws SQLException
	 */
	public int getProviderIdByName(Connection conn, String providerName) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		int providerId = 0;
		try {
			String sql = "SELECT ID FROM PROVIDER WHERE NAME = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, providerName);
			ret = ps.executeQuery();

			if (ret.next()) {
				providerId = ret.getInt("ID");
			}
			System.out.println(providerId);
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (ret != null) {
				ret.close();
			}
		}
		return providerId;

	}

	// 根据供应商Id获得供应商名
	public String getProviderNameById(Connection conn, int providerId) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		String providerName = null;
		try {
			String sql = "SELECT NAME FROM PROVIDER WHERE ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, providerId);
			ret = ps.executeQuery();

			if (ret.next()) {
				providerName = ret.getString("NAME");
			}
			System.out.println(providerName);
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (ret != null) {
				ret.close();
			}
		}
		return providerName;
	}

	@SuppressWarnings("resource")
	public boolean deleteProviderbyId(Connection conn, int id) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;

		try {
			String ssql = "SELECT * FROM ORDERS WHERE PROVIDER_ID = ?";
			ps = conn.prepareStatement(ssql);
			ps.setInt(1, id);
			ret = ps.executeQuery();
			if (ret.next()) {
				return false;
			}
			String sql = "DELETE FROM PROVIDER WHERE ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			if (rows <= 0) {
				return false;
			}
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (ret != null) {
				ret.close();
			}
		}
		return true;
	}
}
