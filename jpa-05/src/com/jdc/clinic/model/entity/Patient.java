package com.jdc.clinic.model.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class Patient {

    public Patient() {
    }

    private int id;

    private String name;

    private LocalDate dob;

    private String phone;

    private String email;

    private String address;

    private String remark;

    private Gender gender;

    private BloodType blood;

    private List<HospitalHistory> hospitalHistories;

    private List<DrugAllergic> alergics;

    private List<ChronicDiseasesHistory> diseaseHistories;

    public enum Gender {
        Male,
        Female
    }

    public enum BloodType {
    }

}