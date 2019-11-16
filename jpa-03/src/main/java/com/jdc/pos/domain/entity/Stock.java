package com.jdc.pos.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.OneToOne;

@Entity
public class Stock implements Serializable {

	private static final long serialVersionUID = 1L;

	public Stock() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	private int currentAmount;

	@OneToOne
	private StockAction action;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}

	public StockAction getAction() {
		return action;
	}

	public void setAction(StockAction action) {
		this.action = action;
	}

}