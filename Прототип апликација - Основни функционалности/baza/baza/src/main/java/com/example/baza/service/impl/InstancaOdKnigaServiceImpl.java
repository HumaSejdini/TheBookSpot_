package com.example.baza.service.impl;

import com.example.baza.model.Dobavuvac;
import com.example.baza.model.InstancaOdKniga;
import com.example.baza.model.Knigi;
import com.example.baza.model.exception.InvalidKnigaIdException;
import com.example.baza.model.exception.InvalidUniqueIdException;
import com.example.baza.repository.InstancaOdKnigaRepository;
import com.example.baza.repository.KnigiRepository;
import com.example.baza.service.InstancaOdKnigaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstancaOdKnigaServiceImpl implements InstancaOdKnigaService {
    private final InstancaOdKnigaRepository instancaOdKnigaRepository;
    private final KnigiRepository knigiRepository;

    public InstancaOdKnigaServiceImpl(InstancaOdKnigaRepository instancaOdKnigaRepository, KnigiRepository knigiRepository) {
        this.instancaOdKnigaRepository = instancaOdKnigaRepository;
        this.knigiRepository = knigiRepository;
    }

    @Override
    public InstancaOdKniga findByUniqueId(Integer uid) {
        return this.instancaOdKnigaRepository.findById(uid).orElseThrow(InvalidUniqueIdException::new);
    }

    @Override
    public Knigi findById(Integer id) {
        return this.knigiRepository.findById(id).orElseThrow(InvalidKnigaIdException::new);
    }

    @Override
    public List<InstancaOdKniga> listAll() {
        return this.instancaOdKnigaRepository.findAll();
    }

    @Override
    public InstancaOdKniga create(Knigi idNaKniga, Boolean daliEOstetena, Boolean status, Dobavuvac idNaDobavuvac) {
        return this.instancaOdKnigaRepository.save(new InstancaOdKniga(idNaKniga,daliEOstetena,status,idNaDobavuvac));
    }

    @Override
    public InstancaOdKniga update(Integer id, Knigi idNaKniga, Boolean daliEOstetena, Boolean status, Dobavuvac idNaDobavuvac) {
        InstancaOdKniga i=this.findByUniqueId(id);
        i.setIdNaKniga(idNaKniga);
        i.setDaliEOstetena(daliEOstetena);
        i.setStatus(status);
        i.setIdNaDobavuvac(idNaDobavuvac);
        return this.instancaOdKnigaRepository.save(i);
    }

    @Override
    public InstancaOdKniga delete(Integer id) {
        InstancaOdKniga i=this.findByUniqueId(id);
        this.instancaOdKnigaRepository.deleteById(id);
        return i;
    }
}
