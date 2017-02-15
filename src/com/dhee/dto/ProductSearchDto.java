package com.dhee.dto;

public class ProductSearchDto {
	
	private Integer id;
	private String name;
	private String material;
	private Integer fprice;
	private Integer lprice;
	private String proDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Integer getFprice() {
		return fprice;
	}

	public void setFprice(Integer fprice) {
		this.fprice = fprice;
	}

	public Integer getLprice() {
		return lprice;
	}

	public void setLprice(Integer lprice) {
		this.lprice = lprice;
	}

	public String getProDate() {
		return proDate;
	}

	public void setProDate(String proDate) {
		this.proDate = proDate;
	}

}
