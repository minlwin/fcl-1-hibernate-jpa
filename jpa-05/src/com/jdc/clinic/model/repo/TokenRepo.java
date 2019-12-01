package com.jdc.clinic.model.repo;

import javax.persistence.EntityManager;

import com.jdc.clinic.model.entity.TokenNumber;
import com.jdc.clinic.model.entity.TokenNumberPK;

public class TokenRepo {

	private EntityManager em;

	public TokenRepo(EntityManager em) {
		super();
		this.em = em;
	}

	public void create(TokenNumber t) {
		em.persist(t);
	}

	public void update(TokenNumber t) {
		em.merge(t);
	}

	public TokenNumber findById(TokenNumberPK id) {
		return em.find(TokenNumber.class, id);
	}

}