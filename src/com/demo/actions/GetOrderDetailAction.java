package com.demo.actions;

import java.util.List;

import com.demo.serviceImpl.BillhtServiceImpl;
import com.dhee.dto.DetailDto;
import com.opensymphony.xwork2.ActionSupport;

public class GetOrderDetailAction extends ActionSupport {

	private static final long serialVersionUID = -235181774583218950L;
	private List<DetailDto> list;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<DetailDto> getList() {
		return list;
	}

	public void setList(List<DetailDto> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		BillhtServiceImpl billhtServiceImpl = new BillhtServiceImpl();
		try {
			list = billhtServiceImpl.getOrderDetail(id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("获取订单信息失败");
			return "input";
		}
		return "success";
	}

}
