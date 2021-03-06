package com.jdc.clinic.model.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class TokenNumber implements Serializable {

	private static final long serialVersionUID = 1L;

	private int token;

	@EmbeddedId
	private TokenNumberPK id;

	public enum Type {
		AM, PM
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public TokenNumberPK getId() {
		return id;
	}

	public void setId(TokenNumberPK id) {
		this.id = id;
	}

}