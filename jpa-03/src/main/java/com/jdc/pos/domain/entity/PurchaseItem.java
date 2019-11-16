package com.jdc.pos.domain.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PurchaseItem extends StockAction {

	private static final long serialVersionUID = 1L;

	public PurchaseItem() {
	}

	private int unitCount;

	private int unitPrice;

	private int unit;

	@ManyToOne
	private Purchase purchase;

	public int getUnitCount() {
		return unitCount;
	}

	public void setUnitCount(int unitCount) {
		this.unitCount = unitCount;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

}