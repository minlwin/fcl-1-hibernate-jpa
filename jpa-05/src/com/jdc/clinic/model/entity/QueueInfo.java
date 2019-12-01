package com.jdc.clinic.model.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class QueueInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

    private String phone;

    @EmbeddedId
    private QueueInfoPK id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public QueueInfoPK getId() {
		return id;
	}

	public void setId(QueueInfoPK id) {
		this.id = id;
	}

    
}