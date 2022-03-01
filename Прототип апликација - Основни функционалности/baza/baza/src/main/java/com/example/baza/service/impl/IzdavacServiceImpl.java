package com.example.baza.service.impl;

import com.example.baza.model.Izdavac;
import com.example.baza.repository.IzdavacRepository;
import com.example.baza.service.IzdavacService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IzdavacServiceImpl implements IzdavacService {
    private final IzdavacRepository izdavacRepository;

    public IzdavacServiceImpl(IzdavacRepository izdavacRepository) {
        this.izdavacRepository = izdavacRepository;
    }

    @Override
    public Optional<Izdavac> findById(Integer id) {
        return this.izdavacRepository.findById(id);
    }

    @Override
    public List<Izdavac> findByimeNaIzdavac(String imeNaIzdavac) {
        return this.izdavacRepository.findByImeNaIzdavac(imeNaIzdavac);
    }

    @Override
    public Izdavac create(String email, String lokacija, String imeNaIzdavac) {
        return this.izdavacRepository.save(new Izdavac(email,lokacija,imeNaIzdavac));
    }

    @Override
    public void delete(Integer id) {
    this.izdavacRepository.deleteById(id);
    }
}
