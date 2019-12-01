package com.jdc.clinic.model.service;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import com.jdc.clinic.model.ModelContext;
import com.jdc.clinic.model.entity.TokenNumber;
import com.jdc.clinic.model.entity.TokenNumber.Type;
import com.jdc.clinic.model.entity.TokenNumberPK;
import com.jdc.clinic.model.repo.TokenRepo;

class TokenService {

	private static TokenService service;
	private EntityManager em;
	private TokenRepo repo;

	public static TokenService getService() {

		if (null == service) {
			service = new TokenService(ModelContext.getContext().getEntityManager());
		}

		return service;
	}

	private TokenService(EntityManager em) {
		this.em = em;
		repo = new TokenRepo(em);
	}

	public int generateToken(LocalDate date, Type type) {

		em.getTransaction().begin();
		TokenNumberPK id = new TokenNumberPK(date, type);
		
		TokenNumber token = repo.findById(id);
		
		if(null == token) {
			token = new TokenNumber();
			token.setId(id);
		}
		
		token.setToken(token.getToken() + 1);

		em.getTransaction().commit();
		
		return token.getToken();
	}

}