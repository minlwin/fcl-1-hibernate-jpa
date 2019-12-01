package com.jdc.clinic.model.service;

import java.time.LocalDate;

import com.jdc.clinic.model.entity.TokenNumber.Type;
import com.jdc.clinic.model.repo.TokenRepo;

class TokenService {

    TokenService() {
    }

    private TokenRepo repo;

    public int generateToken(LocalDate date, Type type) {
        // TODO implement here
        return 0;
    }

}