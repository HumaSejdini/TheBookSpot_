package com.example.baza.service;


import com.example.baza.model.*;

import java.util.List;
import java.util.Set;
import java.util.*;
public interface KnigiService {
    Knigi findById(Integer id);
    List<Knigi> findByOpisLike(String opis);
    List<Knigi> findByNaslovLike(String naslov);
    List<Knigi> listAll();
    List<Knigi> findByNaslov(String naslov);
    Knigi create(String naslov, String opis,  Izdavac izdavac, Set<Kategorija> kategorijas, Set<Avtor> avtors);
    Knigi update(Integer id,String naslov, String opis,  Izdavac izdavac, Set<Kategorija> kategorijas, Set<Avtor> avtors);
    Knigi deletebyId(Integer id);

    void delteById(Integer id);
}
