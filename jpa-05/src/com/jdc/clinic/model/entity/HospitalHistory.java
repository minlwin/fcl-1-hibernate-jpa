package com.jdc.clinic.model.entity;

import java.io.Serializable;

public class HospitalHistory implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String hospital;

	private String reason;

	private int estimateYear;

	private double weeks;

	private String remark;

	private Patient patient;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getEstimateYear() {
		return estimateYear;
	}

	public void setEstimateYear(int estimateYear) {
		this.estimateYear = estimateYear;
	}

	public double getWeeks() {
		return weeks;
	}

	public void setWeeks(double weeks) {
		this.weeks = weeks;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}