package com.demo.actions;

import com.demo.serviceImpl.BillhtServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteOrderAndDetailAction extends ActionSupport {

	private static final long serialVersionUID = -6079585897599140455L;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		BillhtServiceImpl billhtServiceImpl = new BillhtServiceImpl();
		boolean result = billhtServiceImpl.deleteOrderAndDetail(id);
		if(result){
			System.out.println("删除成功");
			this.addActionMessage("订单删除成功");
			return "success";
		}
		return "input";
	}

}
