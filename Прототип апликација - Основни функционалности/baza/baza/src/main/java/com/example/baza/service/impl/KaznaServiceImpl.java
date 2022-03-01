package com.example.baza.service.impl;


import com.example.baza.model.Chlen2;
import com.example.baza.model.Kazna;
import com.example.baza.model.Pozajmica;
import com.example.baza.model.exception.InvalidKaznaIdException;
import com.example.baza.repository.KaznaRepository;
import com.example.baza.service.KaznaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class KaznaServiceImpl implements KaznaService {
    private final KaznaRepository kaznaRepository;

    public KaznaServiceImpl(KaznaRepository kaznaRepository) {
        this.kaznaRepository = kaznaRepository;
    }

    @Override
    public Kazna findById(Integer id) {
        return this.kaznaRepository.findById(id).orElseThrow(InvalidKaznaIdException::new);
    }

    @Override
    public List<Kazna> listAll() {
        return this.kaznaRepository.findAll();
    }

    @Override
    public Kazna create(LocalDate datum, Double cenaVoDenari, Pozajmica pozajmica, Chlen2 chlen) {
        return this.kaznaRepository.save(new Kazna(datum,cenaVoDenari,pozajmica,chlen));
    }

    @Override
    public Kazna deleteId(Integer id) {
        Kazna kazna=this.findById(id);
        this.kaznaRepository.deleteById(id);
        return kazna;
    }
}
