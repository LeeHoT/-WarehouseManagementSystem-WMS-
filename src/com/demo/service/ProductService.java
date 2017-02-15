package com.demo.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.dhee.dto.ProductDto;
import com.dhee.dto.ProductSearchDto;

public interface ProductService {
	public boolean addProduct(ProductDto productDto) throws SQLException, ParseException;

	/**
	 * 获得指定页的产品信息
	 * 
	 * @param currPage 显示的页数
	 * @param rowCount 每页显示的行数
	 * @param message 查询产品
	 * @return  成功返回java.util.List实例，否则返回null
	 * @throws SQLException
	 */
	public List<ProductDto> getProductByPage(Integer currPage, Integer rowCount, String message) throws SQLException;
	
	public Integer getMaxPage(String message,Integer rowCount) throws SQLException;
	
	public List<ProductDto> getProductByAll(Integer currPage, Integer rowCount, ProductSearchDto productSearchDto) throws SQLException, ParseException;
}
