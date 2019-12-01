package com.jdc.clinic.model;

public class ClinicException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private boolean showPopUp;
	
	private ClinicException(String message) {
		super(message);
	}

	public boolean isShowPopUp() {
		return showPopUp;
	}
	
	public static void throwAsAllert(String message) {
		ClinicException ex = new ClinicException(message);
		ex.showPopUp = true;
		throw ex;
	}

	public static void throwAsMessage(String message) {
		throw new ClinicException(message);
	}
}
