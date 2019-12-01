package com.jdc.clinic.model.service;

import java.time.LocalDate;
import java.util.List;

import com.jdc.clinic.model.entity.QueueInfo;
import com.jdc.clinic.model.entity.TokenNumber.Type;
import com.jdc.clinic.model.repo.QueueInfoRepo;

public class QueueService {

    public QueueService() {
    }

    private QueueInfoRepo repo;

    private TokenService tokens;

    public List<QueueInfo> search(LocalDate date, String name, String phone) {
        // TODO implement here
        return null;
    }

    public void save(QueueInfo q) {
        // TODO implement here
    }

    public void delete(int id) {
        // TODO implement here
    }

    public int generateToken(LocalDate date, Type type) {
        // TODO implement here
        return 0;
    }

}