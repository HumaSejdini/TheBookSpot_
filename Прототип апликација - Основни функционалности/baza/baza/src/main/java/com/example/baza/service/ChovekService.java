package com.example.baza.service;


import com.example.baza.model.Chovek2;

import java.util.List;

public interface ChovekService {
    List<Chovek2> listAll();
    Chovek2 findById(Integer id);
    Chovek2 login(String username, String password);
    Chovek2 create(String ime, String prezime, String email, String telBroj, String adresa, String embg, String username, String password);
    Chovek2 delete(Integer id);
}
