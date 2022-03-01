package com.example.baza.service;



import com.example.baza.model.Dobavuvac;

import java.util.List;
import java.util.Optional;

public interface DobavuvacService {
    Optional<Dobavuvac> findById(Integer id);
    List<Dobavuvac> findByImeDobabuvac(String imeDobabuvac);
    Dobavuvac create(String imeDobabuvac);
    void delete(Integer id);
}
