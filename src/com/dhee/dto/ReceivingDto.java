package com.dhee.dto;

public class ReceivingDto {
	private Integer id;
	private Integer product_id;
	private Integer receiving_quantity;
	private String receiving_date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getReceiving_quantity() {
		return receiving_quantity;
	}

	public void setReceiving_quantity(Integer receiving_quantity) {
		this.receiving_quantity = receiving_quantity;
	}

	public String getReceiving_date() {
		return receiving_date;
	}

	public void setReceiving_date(String receiving_date) {
		this.receiving_date = receiving_date;
	}

}
