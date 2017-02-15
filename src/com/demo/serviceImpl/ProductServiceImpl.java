package com.demo.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.demo.dao.ProductDao;
import com.demo.service.ProductService;
import com.demo.util.DBUtil;
import com.dhee.dto.ProductDto;
import com.dhee.dto.ProductSearchDto;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao = null;

	public ProductServiceImpl() {
		productDao = new ProductDao();
	}

	@Override
	public boolean addProduct(ProductDto productDto) throws SQLException, ParseException {
		Connection conn = null;
		int flag = 0;
		try {
			conn = DBUtil.getConnection();
			// 只有INSERT、DELETE、UPDATE时需要
			conn.setAutoCommit(false);
			flag = productDao.insert(conn, productDto);
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

	@Override
	public List<ProductDto> getProductByPage(Integer currPage, Integer rowCount, String message) throws SQLException {
		Connection conn = null;
		List<ProductDto> list = null;
		System.out.println(currPage + rowCount);
		int start = (currPage - 1) * rowCount + 1;
		int end = currPage * rowCount;
		try {
			conn = DBUtil.getConnection();
			list = productDao.selectPage(conn, start, end, message);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}

	@Override
	public List<ProductDto> getProductByAll(Integer currPage, Integer rowCount, ProductSearchDto productSearchDto)
			throws SQLException, ParseException {
		Connection conn = null;
		List<ProductDto> list = null;
		System.out.println(currPage + rowCount);
		int start = (currPage - 1) * rowCount + 1;
		int end = currPage * rowCount;
		try {
			conn = DBUtil.getConnection();
			list = productDao.getProductByAll(conn, start, end, productSearchDto);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}

	@Override
	public Integer getMaxPage(String message, Integer rowCount) throws SQLException {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			return this.productDao.getMaxPage(conn, rowCount, message);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public boolean modifyProduct(ProductDto productDto) throws SQLException, ParseException {
		Connection conn = null;
		int flag = 0;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			flag = productDao.modifyProduct(conn, productDto);
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
	
	public boolean deleteProductById(int id) throws SQLException{
		Connection conn =null;
		int flag = 0;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			flag = productDao.deleteProductbyId(conn, id);
			if(flag>0){
				return true;
			}
			conn.rollback();
		} finally {
			if(conn!=null){
				conn.close();
			}
		}
		return false;
	}
	
	/**
	 * 获取所有产品信息
	 * @return  返回存放查询结果的List<ProductDto>
	 * @throws SQLException
	 */
	public List<ProductDto> getAllProduct() throws SQLException{
		Connection conn =null;
		List<ProductDto> list = null;
		try {
			conn = DBUtil.getConnection();
			list = productDao.getAllProduct(conn);
		} finally {
			if(conn!=null){
				conn.close();
			}
		}
		return list;
	}
}
