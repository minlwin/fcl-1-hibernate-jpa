package com.jdc.clinic.model.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.jdc.clinic.model.ClinicException;
import com.jdc.clinic.model.ModelContext;
import com.jdc.clinic.model.entity.QueueInfo;
import com.jdc.clinic.model.entity.QueueInfoPK;
import com.jdc.clinic.model.entity.TokenNumber.Type;
import com.jdc.clinic.model.repo.QueueInfoRepo;

public class QueueService {

    private QueueService() {
    	tokens = TokenService.getService();
    	em = ModelContext.getContext().getEntityManager();
    	repo = new QueueInfoRepo(em);
    }

    private static QueueService service;
    private QueueInfoRepo repo;
    private EntityManager em;
    private TokenService tokens;
    
    public static QueueService getService() {
    	
    	if(null == service) {
    		service = new QueueService();
    	}
    	
		return service;
	}

    public List<QueueInfo> search(LocalDate date, Type type, String name, String phone) {
    	
    	StringBuffer sb = new StringBuffer("select q from QueueInfo q where 1 = 1");
    	Map<String, Object> params = new HashMap<>();
    	
    	if(null != date) {
    		sb.append(" and q.id.refDate >= :date");
    		params.put("date", date);
    	}
    	
    	if(null != type) {
    		sb.append(" and q.id.type = :type");
    		params.put("type", type);
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

    public void save(QueueInfo q) {
    	
    	if(null == q.getId().getRefDate()) {
    		ClinicException.throwAsMessage("Please enter Date.");
    	}
    	
    	if(null == q.getId().getType()) {
    		ClinicException.throwAsMessage("Please select Section.");
    	}
    	
    	if(null == q.getName() || q.getName().isEmpty()) {
    		ClinicException.throwAsMessage("Please enter Patient Name.");
    	}
    	
    	if(q.getId().getToken() == 0) {
    		int token = TokenService.getService().generateToken(q.getId().getRefDate(), q.getId().getType());
    		q.getId().setToken(token);
    	}
    	
    	em.getTransaction().begin();    	
    	repo.update(q);    	
    	em.getTransaction().commit();
    }

    public void delete(QueueInfoPK id) {
    	em.getTransaction().begin();
    	repo.delelete(id);
    	em.getTransaction().commit();
    }

    public int generateToken(LocalDate date, Type type) {
        return tokens.generateToken(date, type);
    }

}