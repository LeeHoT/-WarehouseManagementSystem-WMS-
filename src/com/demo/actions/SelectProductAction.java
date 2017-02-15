package com.demo.actions;

import java.util.List;

import com.demo.serviceImpl.ProductServiceImpl;
import com.dhee.dto.ProductDto;
import com.opensymphony.xwork2.ActionSupport;

public class SelectProductAction extends ActionSupport {
	private static final long serialVersionUID = 3122647037885409921L;
	private List<ProductDto> list;
	private Integer currentPage;
	private String message;
	private Integer rowCount;
	private Integer maxPageNumber;

	public Integer getMaxPageNumber() {
		return maxPageNumber;
	}

	public void setMaxPageNumber(Integer maxPageNumber) {
		this.maxPageNumber = maxPageNumber;
	}

	public List<ProductDto> getList() {
		return list;
	}

	public void setList(List<ProductDto> list) {
		this.list = list;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String execute() throws Exception {
		rowCount = 5;
		ProductServiceImpl productServiceImpl = new ProductServiceImpl();
		this.list = productServiceImpl.getProductByPage(currentPage, rowCount, message);
		this.maxPageNumber = productServiceImpl.getMaxPage(message, rowCount);
		System.out.println(list.size());
		return "success";
	}

}
