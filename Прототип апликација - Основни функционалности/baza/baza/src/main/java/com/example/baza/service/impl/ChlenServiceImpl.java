package com.example.baza.service.impl;


import com.example.baza.model.Chlen2;
import com.example.baza.repository.ChlenRepository;
import com.example.baza.service.ChlenService;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class ChlenServiceImpl implements ChlenService {
    private final ChlenRepository chlenRepository;

    public ChlenServiceImpl(ChlenRepository chlenRepository ) {
        this.chlenRepository = chlenRepository;

    }

    @Override
    public List<Chlen2> findAll() {
        return this.chlenRepository.findAll();
    }

    @Override
    public Chlen2 findByBroj(Integer broj) {
        return this.chlenRepository.findByBroj(broj);
    }

    @Override
    public Chlen2 delete(Integer broj) {
    Chlen2 chlen=this.findByBroj(broj);
    this.chlenRepository.delete(chlen);
    return chlen;
    }
}