package com.example.baza.service.impl;


import com.example.baza.model.Kategorija;
import com.example.baza.repository.KategorijaRepository;
import com.example.baza.service.KategorijaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KategorijaServiceImpl implements KategorijaService {
    private final KategorijaRepository kategorijaRepository;

    public KategorijaServiceImpl(KategorijaRepository kategorijaRepository) {
        this.kategorijaRepository = kategorijaRepository;
    }


    @Override
    public Optional<Kategorija> findById(Integer id) {
        return this.kategorijaRepository.findById(id);
    }

    @Override
    public List<Kategorija> findAll() {
        return this.kategorijaRepository.findAll();
    }

    @Override
    public List<Kategorija> findByImeKategorija(String imeKategorija) {
        return this.kategorijaRepository.findByImeKategorija(imeKategorija);
    }

    @Override
    public Kategorija create(String imeKategorija) {
        return this.kategorijaRepository.save(new Kategorija(imeKategorija));
    }

    @Override
    public void delete(Integer id) {
        this.kategorijaRepository.deleteById(id);
    }
}
