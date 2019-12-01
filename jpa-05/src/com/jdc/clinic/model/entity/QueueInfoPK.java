package com.jdc.clinic.model.entity;

import java.time.LocalDate;

import com.jdc.clinic.model.entity.TokenNumber.Type;

public class QueueInfoPK {

    public QueueInfoPK() {
    }

    private LocalDate refDate;

    private int token;


    private Type type;

}