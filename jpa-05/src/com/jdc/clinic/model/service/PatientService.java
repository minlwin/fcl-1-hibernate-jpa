package com.jdc.clinic.model.service;

import java.util.List;

import com.jdc.clinic.model.entity.Patient;
import com.jdc.clinic.model.entity.Patient.Gender;
import com.jdc.clinic.model.repo.PatientRepo;

public class PatientService {

    public PatientService() {
    }

    private PatientRepo repo;

    public List<Patient> search(Gender gender, String name, String phone) {
        // TODO implement here
        return null;
    }

    public void save(Patient p) {
        // TODO implement here
    }

}