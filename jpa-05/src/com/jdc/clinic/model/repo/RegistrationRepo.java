package com.jdc.clinic.model.repo;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jdc.clinic.model.entity.QueueInfoPK;
import com.jdc.clinic.model.entity.Registration;

public class RegistrationRepo {

	private EntityManager em;

	public RegistrationRepo(EntityManager em) {
		super();
		this.em = em;
	}

	public List<Registration> search(String sql, Map<String, Object> params) {
		TypedQuery<Registration> query = em.createQuery(sql, Registration.class);

		for (String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}

		return query.getResultList();
	}

	public void create(Registration r) {
		em.persist(r);
	}

	public void update(Registration r) {
		em.merge(r);
	}

	public Registration findById(QueueInfoPK id) {
		return em.find(Registration.class, id);
	}

}