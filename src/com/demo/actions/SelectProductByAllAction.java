package com.demo.actions;

import java.util.List;

import com.demo.serviceImpl.ProductServiceImpl;
import com.dhee.dto.ProductDto;
import com.dhee.dto.ProductSearchDto;
import com.opensymphony.xwork2.ActionSupport;

public class SelectProductByAllAction extends ActionSupport {

	private static final long serialVersionUID = -4215410226054166530L;
	private List<ProductDto> list;
	private ProductSearchDto productSearchDto;
	private Integer currentPage;
	
	private Integer rowCount;
	private Integer maxPageNumber;

	public ProductSearchDto getProductSearchDto() {
		return productSearchDto;
	}

	public void setProductSearchDto(ProductSearchDto productSearchDto) {
		this.productSearchDto = productSearchDto;
	}

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

	
	@Override
	public String execute() throws Exception {
		rowCount = 5;
		System.out.println(productSearchDto.getName());
		System.out.println(productSearchDto.getId());
		System.out.println(productSearchDto.getMaterial());
		ProductServiceImpl productServiceImpl = new ProductServiceImpl();
		this.list = productServiceImpl.getProductByAll(currentPage, rowCount, productSearchDto);
		//this.maxPageNumber = productServiceImpl.getMaxPage(message, rowCount);
		System.out.println(list.size());
		return "success";
	}
}
