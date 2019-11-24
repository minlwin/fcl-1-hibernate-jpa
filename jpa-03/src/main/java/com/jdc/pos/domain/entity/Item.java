package com.jdc.pos.domain.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.jdc.pos.domain.listener.SecureEntity;
import static javax.persistence.CascadeType.PERSIST;

@Entity
public class Item implements SecureEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	private String name;

	private String barcode;

	private String remark;

	private int price;

	private SecurityInfo security;

	@ManyToOne(optional = false, cascade = PERSIST)
	private Category category;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public SecurityInfo getSecurity() {
		return security;
	}

	public void setSecurity(SecurityInfo security) {
		this.security = security;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}