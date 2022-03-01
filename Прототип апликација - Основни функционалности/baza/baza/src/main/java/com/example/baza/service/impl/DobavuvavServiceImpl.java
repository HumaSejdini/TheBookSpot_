package com.example.baza.service.impl;

import com.example.baza.model.Dobavuvac;
import com.example.baza.repository.DobavuvacRepository;
import com.example.baza.service.DobavuvacService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DobavuvavServiceImpl implements DobavuvacService {
    private final DobavuvacRepository dobavuvacRepository;

    public DobavuvavServiceImpl(DobavuvacRepository dobavuvacRepository) {
        this.dobavuvacRepository = dobavuvacRepository;
    }

    @Override
    public Optional<Dobavuvac> findById(Integer id) {
        return this.dobavuvacRepository.findById(id);
    }

    @Override
    public List<Dobavuvac> findByImeDobabuvac(String imeDobabuvac) {
        return this.dobavuvacRepository.findByImeNaDobavuvac(imeDobabuvac);
    }

    @Override
    public Dobavuvac create(String imeDobabuvac) {
        return this.dobavuvacRepository.save(new Dobavuvac(imeDobabuvac));
    }

    @Override
    public void delete(Integer id) {
    this.dobavuvacRepository.deleteById(id);
    }
}
