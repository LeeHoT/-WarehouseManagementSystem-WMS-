package com.demo.actions;

import java.text.ParseException;
import java.util.Date;
import java.util.regex.Pattern;

import com.demo.serviceImpl.ProductServiceImpl;
import com.demo.util.DateFormatUtil;
import com.dhee.dto.ProductDto;
import com.opensymphony.xwork2.ActionSupport;

public class AddProductAction extends ActionSupport {

	private static final long serialVersionUID = -8276488392796713134L;
	private ProductDto productDto;

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

	@Override
	public String execute() throws Exception {
		boolean result = false;
		try {
			ProductServiceImpl productServiceImpl = new ProductServiceImpl();
			result = productServiceImpl.addProduct(productDto);
			if (result) {
				System.out.println("插入成功");
				this.addActionMessage("商品添加成功");
				return "success";
			}
			this.addActionMessage("商品添加失败");
			return "input";
		} catch (Exception e) {
			System.out.println("插入失败");
			this.addActionMessage("商品添加失败");
			return "input";
		}
	}

	@Override
	public void validate() {
		// 验证单价是否正确5000.00 +表示1或者多次
		if (this.productDto.getPrice() == null
				|| !Pattern.matches("\\d+\\.?[0-9]+", productDto.getPrice().toString())) {
			this.addFieldError("PriceError", this.getText("productAdd.price.error"));
			return;
		}
		// 输入的生产日期不能晚于当前日期
		try {
			Date proDate = DateFormatUtil.dateFormat(productDto.getProDate());
			if (new Date().before(proDate)) {
				this.addFieldError("ProDateError", this.getText("productAdd.proDate.error"));
				return;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
