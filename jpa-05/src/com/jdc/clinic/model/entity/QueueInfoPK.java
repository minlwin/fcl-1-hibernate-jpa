package com.jdc.clinic.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.jdc.clinic.model.entity.TokenNumber.Type;

public class QueueInfoPK implements Serializable {

 	private static final long serialVersionUID = 1L;

	private LocalDate refDate;

    private int token;

    private Type type;

	public LocalDate getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDate refDate) {
		this.refDate = refDate;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((refDate == null) ? 0 : refDate.hashCode());
		result = prime * result + token;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QueueInfoPK other = (QueueInfoPK) obj;
		if (refDate == null) {
			if (other.refDate != null)
				return false;
		} else if (!refDate.equals(other.refDate))
			return false;
		if (token != other.token)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}