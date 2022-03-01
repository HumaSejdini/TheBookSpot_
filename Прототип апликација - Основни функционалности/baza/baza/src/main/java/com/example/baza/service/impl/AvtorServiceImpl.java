package com.example.baza.service.impl;


import com.example.baza.model.Avtor;
import com.example.baza.repository.AvtorRepository;
import com.example.baza.service.AvtorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvtorServiceImpl implements AvtorService {
    private final AvtorRepository avtorRepository;

    public AvtorServiceImpl(AvtorRepository avtorRepository) {
        this.avtorRepository = avtorRepository;
    }

    @Override
    public List<Avtor> findAll() {
        return this.avtorRepository.findAll();
    }

    @Override
    public List<Avtor> findByImeLike(String ime) {
        return this.avtorRepository.findByImeLike(ime);
    }

    @Override
    public Optional<Avtor> findById(Integer id) {
        return this.avtorRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
    this.avtorRepository.deleteById(id);
    }
}
