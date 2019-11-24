package com.jdc.pos.domain.listener;

import java.io.Serializable;

import com.jdc.pos.domain.entity.SecurityInfo;

public interface SecureEntity extends Serializable{
	
	SecurityInfo getSecurity();
	void setSecurity(SecurityInfo security);
}
