package com.demo.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.dhee.dto.ProductDto;
import com.dhee.dto.ProductSearchDto;

import com.demo.util.DateFormatUtil;

/**
 * 对表RPODUCT表进行增、删、改、查等操作
 * 
 * @author leehot
 *
 */
public class ProductDao {
	/**
	 * 添加产品信息
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @param productDto
	 *            新的产品信息
	 * @return 添加成功返回大于0的整数，否则返回小于等于0的整数
	 * @throws SQLException
	 * @throws ParseException
	 */
	public int insert(Connection conn, ProductDto productDto) throws SQLException, ParseException {
		PreparedStatement ps = null;
		int rows = 0;
		try {
			// String sql = "INSERT INTO PRODUCT
			// VALUES(PRODUCT_ID_SEQ.NEXTVAL,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?,?)";
			String sql = "INSERT INTO PRODUCT VALUES(PRODUCT_ID_SEQ.NEXTVAL,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, productDto.getName());
			ps.setDouble(2, productDto.getPrice());
			// ps.setString(3, productDto.getProDate());
			ps.setDate(3, DateFormatUtil.dateFormat(productDto.getProDate()));
			ps.setString(4, productDto.getType());
			ps.setString(5, productDto.getSpec());
			ps.setString(6, productDto.getMaterial());
			rows = ps.executeUpdate();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
		return rows;
	}

	// public static void main(String[] args) throws SQLException,
	// ParseException {
	// Connection conn = DBUtil.getConnection();
	// conn.setAutoCommit(false);
	// ProductDao productDao = new ProductDao();
	// ProductDto productDto = new ProductDto();
	// productDto.setName("笔记本电脑");
	// productDto.setPrice(new Double(5999));
	// productDto.setProDate("2016-1-1");
	// productDto.setType("电脑");
	// productDto.setMaterial("金属");
	// productDto.setSpec("台");
	// int row = productDao.insert(conn, productDto);
	// if(row>0){
	// conn.commit();
	// System.out.println("成功");
	// }else{
	// conn.rollback();
	// System.out.println("失败");
	// }
	// System.out.println(row);
	// }

	/**
	 * 选择每一页中的数据
	 * 
	 * @param conn
	 *            数据集连接对象
	 * @param start
	 *            页面开始位置
	 * @param end
	 *            页面结束位置
	 * @param message
	 *            查询信息
	 * @return 返回List<ProductDto>集合
	 * @throws SQLException
	 */
	public List<ProductDto> selectPage(Connection conn, int start, int end, String message) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		List<ProductDto> list = null;
		try {
			String sql = "SELECT R,ID,NAME,PRICE,TYPE,SPEC,MATERIAL,PRODATE "
					+ "FROM (SELECT ROW_NUMBER() OVER(ORDER BY PRICE DESC) AS R,ID,NAME,PRICE,TYPE,SPEC,MATERIAL,PRODATE "
					+ "FROM PRODUCT WHERE NAME LIKE ?)WHERE R BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + message + "%");
			ps.setInt(2, start);
			ps.setInt(3, end);
			ret = ps.executeQuery();
			// 将结果集中的数据封装到List集合中
			// 创建一个集合，用于保存结果集中所有的数据
			list = new ArrayList<ProductDto>();
			// 声明一个Dto，用于保存结果集中的一行数据
			ProductDto productDto = null;// 不能new
			// 使用循环将结果集中的数据封装到List集合中
			while (ret.next()) {
				productDto = new ProductDto();
				// 将结果集当前行指定列的值赋值给Dto对应的属性中
				productDto.setId(ret.getInt("ID"));
				productDto.setName(ret.getString("NAME"));
				productDto.setPrice(ret.getDouble("PRICE"));
				productDto.setSpec(ret.getString("SPEC"));
				productDto.setType(ret.getString("TYPE"));
				productDto.setMaterial(ret.getString("MATERIAL"));
				productDto.setProDate(ret.getString("PRODATE"));
				// 将DTO添加到List集合中
				list.add(productDto);
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

	public Integer getMaxPage(Connection conn, Integer rowCount, String message) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		try {
			String sql = "SELECT CEIL(COUNT(*)/?) AS C FROM PRODUCT WHERE NAME LIKE ?";
			ps = conn.prepareStatement(sql);
			ps.setString(2, "%" + message + "%");
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

	@SuppressWarnings("resource")
	public List<ProductDto> getProductByAll(Connection conn, int start, int end, ProductSearchDto productSearchDto)
			throws SQLException, ParseException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		List<ProductDto> list = null;
		try {
			String sql = "SELECT R,ID,NAME,PRICE,TYPE,SPEC,MATERIAL,PRODATE "
					+ "FROM (SELECT ROW_NUMBER() OVER(ORDER BY PRICE DESC) AS R,ID,NAME,PRICE,TYPE,SPEC,MATERIAL,PRODATE "
					+ "FROM PRODUCT WHERE ID LIKE ? AND NAME LIKE ? AND MATERIAL LIKE ? AND PRICE BETWEEN ? AND ? AND PRODATE BETWEEN ? AND SYSDATE)WHERE R BETWEEN ? AND ?";
			String ssql = "SELECT MAX(PRICE) AS MAX FROM PRODUCT";
			ps = conn.prepareStatement(ssql);
			ret = ps.executeQuery();
			int max = 0;
			while (ret.next()) {
				max = ret.getInt("MAX");
			}
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			if (productSearchDto.getId() != null) {
				ps.setString(1, "%" + productSearchDto.getId() + "%");
			} else {
				ps.setString(1, "%");
			}
			if (productSearchDto.getName() != null) {
				ps.setString(3, "%" + productSearchDto.getMaterial() + "%");
			} else {
				ps.setString(3, "%");
			}
			
			if (productSearchDto.getMaterial() != null) {
				ps.setString(2, "%" + productSearchDto.getName() + "%");
			} else {
				ps.setString(2, "%");
			}
			
			if (productSearchDto.getFprice() != null) {
				ps.setInt(4, productSearchDto.getFprice());
				//ps.setInt(4, 0);
				// ps.setInt(4, productSearchDto.getFprice());
				// ps.setInt(5, productSearchDto.getLprice());
			} else {
				ps.setInt(4, 0);
			}
			if (productSearchDto.getLprice() != null) {
				// ps.setInt(4, 0);
				ps.setInt(5, productSearchDto.getLprice());
			} else {
				//ps.setInt(4, productSearchDto.getFprice());
				//ps.setInt(5, productSearchDto.getLprice());
				ps.setInt(5, max);
			}

			if (productSearchDto.getProDate() != null && !productSearchDto.getProDate().equals("")) {
				ps.setDate(6, DateFormatUtil.dateFormat(productSearchDto.getProDate()));
			} else {
				ps.setDate(6, DateFormatUtil.dateFormat("1900-01-01"));
			}
			ps.setInt(7, start);
			ps.setInt(8, end);
			ret = ps.executeQuery();
			// 将结果集中的数据封装到List集合中
			// 创建一个集合，用于保存结果集中所有的数据
			list = new ArrayList<ProductDto>();
			// 声明一个Dto，用于保存结果集中的一行数据
			ProductDto productDto = null;// 不能new
			// 使用循环将结果集中的数据封装到List集合中
			while (ret.next()) {
				productDto = new ProductDto();
				// 将结果集当前行指定列的值赋值给Dto对应的属性中
				productDto.setId(ret.getInt("ID"));
				productDto.setName(ret.getString("NAME"));
				productDto.setPrice(ret.getDouble("PRICE"));
				productDto.setSpec(ret.getString("SPEC"));
				productDto.setType(ret.getString("TYPE"));
				productDto.setMaterial(ret.getString("MATERIAL"));
				productDto.setProDate(ret.getString("PRODATE"));
				// 将DTO添加到List集合中
				list.add(productDto);
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
	public int modifyProduct(Connection conn, ProductDto productDto) throws SQLException, ParseException {
		PreparedStatement ps = null;
		int row = 0;
		// 删除数据库表中已有的需要更改的产品信息
		try {
			String dsql = "DELETE FROM PRODUCT WHERE ID = ?";
			ps = conn.prepareStatement(dsql);
			ps.setInt(1, productDto.getId());
			ps.executeUpdate();
			// 向数据库表中添加修改之后的产品信息
			String sql = "INSERT INTO PRODUCT VALUES(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, productDto.getId());
			ps.setString(2, productDto.getName());
			ps.setDouble(3, productDto.getPrice());
			ps.setDate(4, DateFormatUtil.dateFormat(productDto.getProDate()));
			ps.setString(5, productDto.getType());
			ps.setString(6, productDto.getSpec());
			ps.setString(7, productDto.getMaterial());
			row = ps.executeUpdate();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
		return row;
	}

	@SuppressWarnings("resource")
	public int deleteProductbyId(Connection conn, int id) throws SQLException {
		PreparedStatement ps = null;
		ResultSet ret = null;
		int flag = 0;
		try {
			String ssql = "SELECT * FROM DETAIL WHERE PRODUCT_ID = ?";
			ps = conn.prepareStatement(ssql);
			ps.setInt(1, id);
			ret = ps.executeQuery();
			if (ret.next()) {
				return flag;
			}
			String sql = "DELETE FROM PRODUCT WHERE ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			flag = ps.executeUpdate();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (ret != null) {
				ret.close();
			}
		}
		return flag;
	}

	public List<ProductDto> getAllProduct(Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ProductDto productDto = null;
		ResultSet ret = null;
		List<ProductDto> list = null;
		String sql = "SELECT * FROM PRODUCT";
		try {
			ps = conn.prepareStatement(sql);
			ret = ps.executeQuery();
			list = new ArrayList<ProductDto>();
			while (ret.next()) {
				productDto = new ProductDto();
				productDto.setId(ret.getInt("ID"));
				productDto.setName(ret.getString("NAME"));
				productDto.setPrice(ret.getDouble("PRICE"));
				productDto.setSpec(ret.getString("SPEC"));
				productDto.setType(ret.getString("TYPE"));
				productDto.setProDate(ret.getString("PRODATE"));
				productDto.setMaterial(ret.getString("MATERIAL"));
				list.add(productDto);
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
}
