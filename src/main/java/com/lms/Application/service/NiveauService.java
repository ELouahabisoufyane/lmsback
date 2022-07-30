package com.lms.Application.service;

import com.lms.Application.dao.NiveauRepository;

public class NiveauService {
    private final NiveauRepository nr;

    public NiveauService(NiveauRepository nr) {
        this.nr = nr;
    }
}
