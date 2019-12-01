package com.jdc.clinic.model.repo;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jdc.clinic.model.entity.Patient;

public class PatientRepo {

	private EntityManager em;

	public PatientRepo(EntityManager em) {
		super();
		this.em = em;
	}

	public void create(Patient p) {
		em.persist(p);
	}

	public void update(Patient p) {
		em.merge(p);
	}

	public List<Patient> search(String sql, Map<String, Object> params) {

		TypedQuery<Patient> query = em.createQuery(sql, Patient.class);
		
		for(String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}
		
		return query.getResultList();
	}

}