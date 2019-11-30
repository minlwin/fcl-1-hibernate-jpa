package com.jdc.clinic.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jdc.clinic.model.entity.Patient;
import com.jdc.clinic.model.entity.Patient.Gender;

public class PatientRepo {

	private EntityManager em;

	public PatientRepo(EntityManager em) {
		super();
		this.em = em;
	}

	public List<Patient> search(Gender gender, String name, String phone) {
		
		StringBuilder sb = new StringBuilder("select p from Patient p where 1 = 1");
		Map<String, Object> params = new HashMap<>();
		
		if(null != gender) {
			sb.append(" and p.gender = :gender");
			params.put("gender", gender);
		}
		
		if(!name.isEmpty()) {
			sb.append(" and lower(p.name) like lower(:name)");
			params.put("name", name.concat("%"));
		}
		
		if(!phone.isEmpty()) {
			sb.append(" and p.phone like :phone");
			params.put("phone", phone.concat("%"));
		}
		
		TypedQuery<Patient> query = em.createQuery(sb.toString(), Patient.class);
		
		for(String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}
		
		return query.getResultList();
	}

	public void save(Patient patient) {
		
		if(null != patient) {
			em.getTransaction().begin();
			em.persist(patient);
			em.getTransaction().commit();
		}

	}

}
