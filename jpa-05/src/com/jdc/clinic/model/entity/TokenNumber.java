package com.jdc.clinic.model.entity;

public class TokenNumber {

    public TokenNumber() {
    }

    private int token;

    private TokenNumberPK id;

    public enum Type {
        AM,
        PM
    }

}