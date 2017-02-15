package com.dhee.dto;

public class BillhtDto {
	private Integer id;
	private Integer provider_id;
	private String buyer;
	private Integer payment;
	private String reviewer;// 审核人
	private Integer creator;
	private String proDate;
	private Integer status;
	private UsersDto usersDto;
	private ProviderDto provider;

	private PaymentDto paymentDto;
	private StatusDto statusDto;
	private Double price;

	public UsersDto getUsersDto() {
		return usersDto;
	}

	public void setUsersDto(UsersDto usersDto) {
		this.usersDto = usersDto;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public ProviderDto getProvider() {
		return provider;
	}

	public void setProvider(ProviderDto provider) {
		this.provider = provider;
	}

	public PaymentDto getPaymentDto() {
		return paymentDto;
	}

	public void setPaymentDto(PaymentDto paymentDto) {
		this.paymentDto = paymentDto;
	}

	public StatusDto getStatusDto() {
		return statusDto;
	}

	public void setStatusDto(StatusDto statusDto) {
		this.statusDto = statusDto;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProvider_id() {
		return provider_id;
	}

	public void setProvider_id(Integer provider_id) {
		this.provider_id = provider_id;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public Integer getPayment() {
		return payment;
	}

	public void setPayment(Integer payment) {
		this.payment = payment;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	public String getProDate() {
		return proDate;
	}

	public void setProDate(String proDate) {
		this.proDate = proDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	// public Integer getPrice() {
	// return price;
	// }
	//
	// public void setPrice(Integer price) {
	// this.price = price;
	// }

}
