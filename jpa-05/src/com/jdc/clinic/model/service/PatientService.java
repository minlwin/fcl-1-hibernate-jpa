package com.jdc.clinic.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.jdc.clinic.model.ModelContext;
import com.jdc.clinic.model.entity.Patient;
import com.jdc.clinic.model.entity.Patient.Gender;
import com.jdc.clinic.model.repo.PatientRepo;

public class PatientService {

	private static PatientService service;
	private PatientRepo repo;
	private EntityManager em;

	public static PatientService getService() {

		if (null == service) {
			service = new PatientService();
		}

		return service;
	}

	private PatientService() {
		em = ModelContext.getContext().getEntityManager();
	}

	public List<Patient> search(Gender gender, String name, String phone) {
		
		StringBuffer sb = new StringBuffer("select p from Patient p where 1 = 1");
		Map<String, Object> params = new HashMap<>();
		
		if(null != gender) {
			sb.append(" and p.gender = :gender");
			params.put("gender", gender);
		}
		
		if(null != name && !name.isEmpty()) {
			sb.append(" and lower(p.name) like lower(:name)");
			params.put("name", name.concat("%"));
		}
		
		if(null != phone && !phone.isEmpty()) {
			sb.append(" and p.phone like :phone");
			params.put("phone", phone.concat("%"));
		}

		return repo.search(sb.toString(), params);
	}

	public void save(Patient p) {
		
		em.getTransaction().begin();
		
		if(p.getId() == 0) {
			repo.create(p);
		} else {
			repo.update(p);
		}

		em.getTransaction().commit();
	}

}