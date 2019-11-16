package com.jdc.pos.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.ManyToOne;

@Entity
public class Purchase implements Serializable {

	private static final long serialVersionUID = 1L;

	public Purchase() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	private LocalDate purchaseDate;

	private LocalDate paidDate;

	private int netAmount;

	private int tax;

	private int transport;

	private int amount;

	private int prepaidAmount;

	@ManyToOne
	private Shop shop;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public LocalDate getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(LocalDate paidDate) {
		this.paidDate = paidDate;
	}

	public int getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(int netAmount) {
		this.netAmount = netAmount;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getTransport() {
		return transport;
	}

	public void setTransport(int transport) {
		this.transport = transport;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrepaidAmount() {
		return prepaidAmount;
	}

	public void setPrepaidAmount(int prepaidAmount) {
		this.prepaidAmount = prepaidAmount;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

}