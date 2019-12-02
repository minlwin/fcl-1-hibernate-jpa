package com.jdc.clinic.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;

@Entity
public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private LocalDate dob;

	private String phone;

	private String email;

	private String address;

	private String remark;

	private Gender gender;

	private BloodType blood;

	@OneToMany(mappedBy = "patient", cascade = { PERSIST, MERGE }, orphanRemoval = true)
	private Set<HospitalHistory> hospitalHistories;

	@OneToMany(mappedBy = "patient", cascade = { PERSIST, MERGE }, orphanRemoval = true)
	private Set<DrugAllergic> alergics;

	@OneToMany(mappedBy = "patient", cascade = { PERSIST, MERGE }, orphanRemoval = true)
	private Set<ChronicDiseasesHistory> diseaseHistories;

	public enum Gender {
		Male, Female
	}

	public enum BloodType {
		A, B, AB, O
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public BloodType getBlood() {
		return blood;
	}

	public void setBlood(BloodType blood) {
		this.blood = blood;
	}

	public Set<HospitalHistory> getHospitalHistories() {
		return hospitalHistories;
	}

	public void setHospitalHistories(Set<HospitalHistory> hospitalHistories) {
		this.hospitalHistories = hospitalHistories;
	}

	public Set<DrugAllergic> getAlergics() {
		return alergics;
	}

	public void setAlergics(Set<DrugAllergic> alergics) {
		this.alergics = alergics;
	}

	public Set<ChronicDiseasesHistory> getDiseaseHistories() {
		return diseaseHistories;
	}

	public void setDiseaseHistories(Set<ChronicDiseasesHistory> diseaseHistories) {
		this.diseaseHistories = diseaseHistories;
	}

}