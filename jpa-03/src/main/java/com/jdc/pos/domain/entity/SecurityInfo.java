package com.jdc.pos.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;

@Embeddable
public class SecurityInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public SecurityInfo() {
	}

	private LocalDateTime creation;

	private LocalDateTime modification;

	private String createUser;

	private String updateUser;

	private boolean delFlag;

	public LocalDateTime getCreation() {
		return creation;
	}

	public void setCreation(LocalDateTime creation) {
		this.creation = creation;
	}

	public LocalDateTime getModification() {
		return modification;
	}

	public void setModification(LocalDateTime modification) {
		this.modification = modification;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}

}