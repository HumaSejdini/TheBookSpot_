package com.example.baza.service;



import com.example.baza.model.Authentication;

import java.util.List;
import java.util.Optional;

public interface AuthenticationService {
    List<Authentication> listAll();
    Optional<Authentication> findById(Integer id);
}
