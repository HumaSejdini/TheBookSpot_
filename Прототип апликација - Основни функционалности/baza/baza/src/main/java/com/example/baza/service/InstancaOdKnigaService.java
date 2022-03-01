package com.example.baza.service;



import com.example.baza.model.Dobavuvac;
import com.example.baza.model.InstancaOdKniga;
import com.example.baza.model.Knigi;

import java.util.List;

public interface InstancaOdKnigaService {
    InstancaOdKniga findByUniqueId(Integer uid);
    Knigi findById(Integer id);
    List<InstancaOdKniga> listAll();
    InstancaOdKniga create(Knigi idNaKniga, Boolean daliEOstetena, Boolean status, Dobavuvac idNaDobavuvac);
    InstancaOdKniga update(Integer id,Knigi idNaKniga, Boolean daliEOstetena, Boolean status, Dobavuvac idNaDobavuvac);
    InstancaOdKniga delete(Integer id);
}
