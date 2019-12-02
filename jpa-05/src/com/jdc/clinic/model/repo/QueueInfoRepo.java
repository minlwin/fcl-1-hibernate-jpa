package com.jdc.clinic.model.repo;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jdc.clinic.model.entity.QueueInfo;
import com.jdc.clinic.model.entity.QueueInfoPK;

public class QueueInfoRepo {

	private EntityManager em;

	public QueueInfoRepo(EntityManager em) {
		super();
		this.em = em;
	}

	public void create(QueueInfo q) {
		em.persist(q);
	}

	public void update(QueueInfo q) {
		em.merge(q);
	}

	public void delelete(QueueInfoPK id) {
		QueueInfo data = em.find(QueueInfo.class, id);
		if (null != data) {
			em.remove(data);
		}
	}

	public List<QueueInfo> search(String sql, Map<String, Object> params) {
		TypedQuery<QueueInfo> query = em.createQuery(sql, QueueInfo.class);

		for (String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}

		return query.getResultList();
	}

}