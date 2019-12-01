package com.jdc.clinic.model.entity;

import java.io.Serializable;

public class DrugAllergic implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String drug;

	private String level;

	private Patient patient;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDrug() {
		return drug;
	}

	public void setDrug(String drug) {
		this.drug = drug;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}