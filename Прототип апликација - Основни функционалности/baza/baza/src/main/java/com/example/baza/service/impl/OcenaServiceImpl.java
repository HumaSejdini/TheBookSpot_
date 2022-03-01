package com.example.baza.service.impl;

import com.example.baza.model.Avtor;
import com.example.baza.model.Chlen2;
import com.example.baza.model.Knigi;
import com.example.baza.model.Ocena;
import com.example.baza.repository.OcenaRepository;
import com.example.baza.service.OcenaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcenaServiceImpl implements OcenaService {
    private final OcenaRepository ocenaRepository;

    public OcenaServiceImpl(OcenaRepository ocenaRepository) {
        this.ocenaRepository = ocenaRepository;
    }

    @Override
    public Optional<Ocena> findById(Integer id) {
        return this.ocenaRepository.findById(id);
    }

    @Override
    public List<Ocena> findByKomentar(String komentar) {
        return this.ocenaRepository.findByKomentar(komentar);
    }

    @Override
    public Ocena create(Integer ocena, String komentar, Chlen2 chlen, Knigi knigi, Avtor avtor) {
        return this.ocenaRepository.save(new Ocena(ocena,komentar,chlen,knigi,avtor));
    }

    @Override
    public void delete(Integer id) {
    this.ocenaRepository.deleteById(id);
    }
}
