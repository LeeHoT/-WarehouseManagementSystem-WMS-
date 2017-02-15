package com.demo.actions;

import java.util.List;

import com.demo.serviceImpl.BillhtServiceImpl;
import com.dhee.dto.BillhtDto;
import com.opensymphony.xwork2.ActionSupport;

public class GetAllOrderAction extends ActionSupport {

	private static final long serialVersionUID = -1920846468608606838L;
	private List<BillhtDto> list;

	public List<BillhtDto> getList() {
		return list;
	}

	public void setList(List<BillhtDto> list) {
		this.list = list;
	}

	
	@Override
	public String execute() throws Exception {
		BillhtServiceImpl billhtServiceImpl = new BillhtServiceImpl();
		list = billhtServiceImpl.getAllOrder();
		System.out.println(list.size());
		return "success";
	}

}
