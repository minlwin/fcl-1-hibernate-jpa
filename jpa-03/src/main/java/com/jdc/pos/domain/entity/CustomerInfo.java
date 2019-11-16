package com.jdc.pos.domain.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CustomerInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public CustomerInfo() {
	}

	private Gender gender;

	private Ages ages;

	private Type type;

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Ages getAges() {
		return ages;
	}

	public void setAges(Ages ages) {
		this.ages = ages;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public enum Gender {
	}

	public enum Ages {
	}

	public enum Type {
	}

}