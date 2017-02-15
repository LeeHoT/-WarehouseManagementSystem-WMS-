package com.demo.actions;

import com.demo.serviceImpl.ProductServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteProductAction extends ActionSupport {

	private static final long serialVersionUID = 9119818484166654745L;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		try {
			ProductServiceImpl productServiceImpl = new ProductServiceImpl();
			boolean result = productServiceImpl.deleteProductById(id);
			if (result) {
				System.out.println("删除产品成功");
				//this.addActionMessage("删除成功");
				return "success";
			}
			return "input";
		} catch (Exception e) {
			//this.addActionMessage("删除失败");
			System.out.println("删除产品失败");
			return "input";
		}
	}
}
