package com.jdc.clinic.model.service;

import java.time.LocalDate;
import java.util.List;

import com.jdc.clinic.model.entity.Registration;
import com.jdc.clinic.model.repo.RegistrationRepo;

public class RegistrationService {

    public RegistrationService() {
    }

    private TokenService tokens;

    private RegistrationRepo repo;

    public List<Registration> search(LocalDate date, String name, String phone) {
        // TODO implement here
        return null;
    }

    public void save(Registration r) {
        // TODO implement here
    }

    public Registration findById(long id) {
        // TODO implement here
        return null;
    }

}