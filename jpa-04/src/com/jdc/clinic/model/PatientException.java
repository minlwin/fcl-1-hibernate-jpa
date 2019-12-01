package com.jdc.clinic.model;

public class PatientException extends IllegalArgumentException{

	private static final long serialVersionUID = 1L;

	public PatientException(String s) {
		super(s);
	}
	
}
