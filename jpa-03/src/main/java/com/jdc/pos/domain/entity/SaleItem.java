package com.jdc.pos.domain.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class SaleItem extends StockAction {

	private static final long serialVersionUID = 1L;

	public SaleItem() {
	}

	private int quentity;

	private int price;

	@ManyToOne
	private Sale sale;

	public int getQuentity() {
		return quentity;
	}

	public void setQuentity(int quentity) {
		this.quentity = quentity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

}