package com.demo.actions;

import com.demo.serviceImpl.ProductServiceImpl;
import com.dhee.dto.ProductDto;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyProductAction extends ActionSupport {

	private static final long serialVersionUID = -678499213361391289L;
	private ProductDto productDto;

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

	@Override
	public String execute() throws Exception {
		try {
			ProductServiceImpl productServiceImpl = new ProductServiceImpl();
			boolean flag = productServiceImpl.modifyProduct(productDto);
			if (flag) {
				System.out.println("修改产品成功");
				return "success";
			}
			return "input";
		} catch (Exception e) {
			System.out.println("修改产品失败");
			return "input";
		}
	}

}
