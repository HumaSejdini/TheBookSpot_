package com.example.baza.service.impl;

import com.example.baza.model.*;
import com.example.baza.model.exception.InvalidPozajmicaIdException;
import com.example.baza.repository.PozajmicaRepository;
import com.example.baza.service.PozajmicaService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class PozajmicaServiceImpl implements PozajmicaService {
    private final PozajmicaRepository pozajmicaRepository;

    public PozajmicaServiceImpl(PozajmicaRepository pozajmicaRepository) {
        this.pozajmicaRepository = pozajmicaRepository;
    }
    //todo find pozajmica so ime na korisnikot ili brojot na chlenot ili dvete LOL :,)
    @Override
    public Pozajmica findById(Integer id) {
        return this.pozajmicaRepository.findById(id).orElseThrow(InvalidPozajmicaIdException::new);
    }

    @Override
    public List<Pozajmica> listAll() {
        return this.pozajmicaRepository.findAll();
    }

    @Override
    public Pozajmica create(LocalDate datumNaZemanje, LocalDate datumNaVrakjanje, Boolean status, Bibliotekar2 bibliotekar, Chlen2 chlen, InstancaOdKniga instancaOdKniga) {
        return pozajmicaRepository.save(new Pozajmica(datumNaZemanje,datumNaVrakjanje,status,bibliotekar,chlen,instancaOdKniga));
    }


    @Override
    public Pozajmica update(Integer id, LocalDate datumNaZemanje, LocalDate datumNaVrakjanje, Boolean status, Bibliotekar2 bibliotekar, Chlen2 chlen, InstancaOdKniga instancaOdKniga) {
       Pozajmica pozajmica=this.findById(id);
       pozajmica.setDatumNaZemanje(datumNaZemanje);
       pozajmica.setDatumNaVrakjanje(datumNaVrakjanje);
       pozajmica.setStatus(status);
       pozajmica.setBibliotekar(bibliotekar);
       pozajmica.setChlen(chlen);
       pozajmica.setInstancaOdKniga(instancaOdKniga);
       return this.pozajmicaRepository.save(pozajmica);
    }

    @Override
    @Transactional
    public Pozajmica save(LocalDate datumNaZemanje, LocalDate datumNaVrakjanje, Boolean status, Bibliotekar2 bibliotekar, Chlen2 chlen, InstancaOdKniga instanca) {
        return this.pozajmicaRepository.save(new Pozajmica(datumNaZemanje,datumNaVrakjanje,status,bibliotekar,chlen,instanca));
        //todo more nema proverki nema nisto
    }
    //ne mi lici okay haahaha
}
