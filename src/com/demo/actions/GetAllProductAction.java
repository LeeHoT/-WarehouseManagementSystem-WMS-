package com.demo.actions;

import java.util.List;

import com.demo.serviceImpl.ProductServiceImpl;
import com.dhee.dto.ProductDto;
import com.opensymphony.xwork2.ActionSupport;

public class GetAllProductAction extends ActionSupport {

	private static final long serialVersionUID = 5290020708993614462L;
	private List<ProductDto> list;

	public List<ProductDto> getList() {
		return list;
	}

	public void setList(List<ProductDto> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {

		ProductServiceImpl productServiceImpl = new ProductServiceImpl();
		list = productServiceImpl.getAllProduct();
		return "success";

	}

}
