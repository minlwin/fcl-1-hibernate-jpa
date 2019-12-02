package com.jdc.clinic.model.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.jdc.clinic.model.entity.QueueInfoPK;
import com.jdc.clinic.model.entity.Registration;
import com.jdc.clinic.model.entity.TokenNumber.Type;
import com.jdc.clinic.model.repo.RegistrationRepo;

public class RegistrationService {

	private RegistrationService() {
	}

	private static RegistrationService service;

	public static RegistrationService getService() {
		if (null == service) {
			service = new RegistrationService();
		}
		return service;
	}

	private EntityManager em;
	private RegistrationRepo repo;

	public List<Registration> search(LocalDate date, Type type, String name, String phone) {
		StringBuffer sb = new StringBuffer("select q from Registration q where 1 = 1");
		Map<String, Object> params = new HashMap<>();

		if (null != date) {
			sb.append(" and q.id.refDate = :date");
			params.put("date", date);
		}

		if (null != type) {
			sb.append(" and q.id.type = :type");
			params.put("type", type);
		}

		if (null != name && !name.isEmpty()) {
			sb.append(" and lower(p.name) like lower(:name)");
			params.put("name", name.concat("%"));
		}

		if (null != phone && !phone.isEmpty()) {
			sb.append(" and p.phone like :phone");
			params.put("phone", phone.concat("%"));
		}

		return repo.search(sb.toString(), params);
	}

	public void save(Registration r) {
		em.getTransaction().begin();
		repo.update(r);
		em.getTransaction().commit();
	}

	public Registration findById(QueueInfoPK id) {
		return repo.findById(id);
	}

}