package com.example.baza.service;


import com.example.baza.model.Chlen2;
import java.util.*;
public interface ChlenService {
    List<Chlen2> findAll();
    Chlen2 findByBroj(Integer broj);
    Chlen2 delete(Integer broj);
}
