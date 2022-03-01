package com.example.baza.service.impl;


import com.example.baza.model.Authentication;
import com.example.baza.repository.AuthenticationRepository;
import com.example.baza.service.AuthenticationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationRepository authenticationRepository;

    public AuthenticationServiceImpl(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    @Override
    public List<Authentication> listAll() {
        return this.authenticationRepository.findAll();
    }

    @Override
    public Optional<Authentication> findById(Integer id) {
        return this.authenticationRepository.findById(id);
    }
}
