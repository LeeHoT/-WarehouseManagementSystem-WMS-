package com.demo.actions;

import com.demo.serviceImpl.BillhtServiceImpl;
import com.dhee.dto.BillhtDto;
import com.opensymphony.xwork2.ActionSupport;

public class AddOrderAction extends ActionSupport {

	private static final long serialVersionUID = -6841151163803400181L;
	private BillhtDto billhtDto;
	private String providerName;
	private String creator;
	private String payment;
	private String[] check;
	private String[] quantity;
	private String[] price;
	private String[] id;

	public String[] getId() {
		return id;
	}

	public void setId(String[] id) {
		this.id = id;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String[] getCheck() {
		return check;
	}

	public void setCheck(String[] check) {
		this.check = check;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String[] getQuantity() {
		return quantity;
	}

	public void setQuantity(String[] quantity) {
		this.quantity = quantity;
	}

	public String[] getPrice() {
		return price;
	}

	public void setPrice(String[] price) {
		this.price = price;
	}

	public BillhtDto getBillhtDto() {
		return billhtDto;
	}

	public void setBillhtDto(BillhtDto billhtDto) {
		this.billhtDto = billhtDto;
	}

	@Override
	public String execute() throws Exception {
		// 接收返回的新订单ID
		for(int i =0;i<check.length;i++){
			System.out.println(check[i]+".."+quantity[i]+",,"+price[i]);
		}
		boolean result = false;
		System.out.println(providerName + creator + payment);
		// 添加订单信息进Order表，，返回生成的订单id
		BillhtServiceImpl billhtServiceImpl = new BillhtServiceImpl();
		result = billhtServiceImpl.addOrders(billhtDto, providerName, creator, payment, check, price, quantity,id);
		// 添加新订单的详细信息
		System.out.println("addOrder." + result);
		if (result) {
			System.out.println("插入新订单及详细信息成功");
			return "success";
		} else {
			System.out.println("插入新订单及详细信息失败");
			return "input";
		}
	}
}
