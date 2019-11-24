package com.jdc.pos.domain.listener;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.jdc.pos.domain.entity.SecurityInfo;

public class SecurityListener {
	
	@PrePersist
	public void prePersist(Object obj) {
		
		if(obj instanceof SecureEntity) {
			SecureEntity entity  = (SecureEntity) obj;
			
			SecurityInfo sec = entity.getSecurity();
			if(null == sec) {
				sec = new SecurityInfo();
				entity.setSecurity(sec);
			}
			
			sec.setCreateUser("Admin");
			sec.setCreation(LocalDateTime.now());
		}
		
	}
	
	@PreUpdate
	public void preUpdate(Object obj) {
		
		if(obj instanceof SecureEntity) {
			SecureEntity entity  = (SecureEntity) obj;
			
			SecurityInfo sec = entity.getSecurity();
			sec.setUpdateUser("Admin");
			sec.setModification(LocalDateTime.now());
		}
	}
}
