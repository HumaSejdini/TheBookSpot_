package com.example.baza.service.impl;


import com.example.baza.model.*;
import com.example.baza.model.exception.InvalidArgumentsException;
import com.example.baza.model.exception.InvalidKnigaIdException;
import com.example.baza.model.exception.KnigaNotFoundException;
import com.example.baza.repository.KnigiRepository;
import com.example.baza.service.KnigiService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.*;
@Service
public class KnigiServiceImpl implements KnigiService {
    private final KnigiRepository knigiRepository;

    public KnigiServiceImpl(KnigiRepository knigiRepository) {
        this.knigiRepository = knigiRepository;
    }

    @Override
    public Knigi findById(Integer id) {
        return this.knigiRepository.findById(id).orElseThrow(InvalidKnigaIdException::new);
    }



    @Override
    public List<Knigi> findByOpisLike(String opis) {
        if(opis == null || opis.isEmpty()){
            throw new InvalidArgumentsException();
        }
        return this.knigiRepository.findByOpisLike(opis);
    }

    @Override
    public List<Knigi> findByNaslovLike(String naslov) {
        if(naslov == null || naslov.isEmpty())
        {
            throw new InvalidArgumentsException();
        }
        return this.knigiRepository.findByNaslovLike(naslov);
    }

    @Override
    public List<Knigi> listAll() {
        return this.knigiRepository.findAll();
    }

    @Override
    public List<Knigi> findByNaslov(String naslov) {
        if(naslov == null || naslov.isEmpty())
        {
            throw new InvalidArgumentsException();
        }
        return this.knigiRepository.findByNaslov(naslov);
    }

    @Override
    public Knigi create(String naslov, String opis,  Izdavac izdavac, Set<Kategorija> kategorijas, Set<Avtor> avtors) {
        return this.knigiRepository.save(new Knigi(naslov,opis,izdavac,kategorijas,avtors));
        //more things todo
    }

    @Override
    public Knigi update(Integer id, String naslov, String opis, Izdavac izdavac, Set<Kategorija> kategorijas, Set<Avtor> avtors) {
        Knigi knigi=this.findById(id);
        knigi.setOpis(opis);
        knigi.setNaslov(naslov);
        knigi.setIzdavac(izdavac);
        knigi.setKategorijas(kategorijas);
        knigi.setAvtors(avtors);
        return this.knigiRepository.save(knigi);
    }



    @Override
    public Knigi deletebyId(Integer id) {
    Knigi knigi=this.findById(id);
    this.knigiRepository.deleteById(id);
    return knigi;
    }

    @Override
    public void delteById(Integer id) {
        this.knigiRepository.deleteById(id);
    }
}
