package com.dhee.dto;

import java.io.Serializable;

/**
 * 用于封装产品表中的一行产品信息
 * 
 * @author leehot
 *
 */
public class ProductDto implements Serializable {

	private static final long serialVersionUID = -3723203865892061188L;
	private Integer id; // 产品id
	private String name; // 产品名称
	private Double price; // 产品价格
	private String proDate; // 生产日期
	private String type; // 产品类型
	private String spec; // 产品单位
	private String material; // 产品材料

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getProDate() {
		return proDate;
	}

	public void setProDate(String proDate) {
		this.proDate = proDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}
