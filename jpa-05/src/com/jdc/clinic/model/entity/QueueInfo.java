package com.jdc.clinic.model.entity;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.jdc.clinic.model.entity.TokenNumber.Type;

@Entity
public class QueueInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	private String name;

    private String phone;
    
    private Status status;
    
    private String remark;

    @EmbeddedId
    private QueueInfoPK id;
    
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");
    
    public String getQueue() {
    	return String.format("%s-%s-%03d", id.getRefDate().format(FORMAT), id.getType().name(), id.getToken());
    }
    
    public enum Status {
    	Register, CheckIn, Finish, Cancel
    }
    
    public String getDate() {
    	return id.getRefDate().format(DATE_FORMAT);
    }
    
    public Type getType() {
    	return id.getType();
    }
    
    public int getToken() {
    	return id.getToken();
    }

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

    
}