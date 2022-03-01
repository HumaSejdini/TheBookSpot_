package com.example.baza.service.impl;


import com.example.baza.model.Bibliotekar2;
import com.example.baza.repository.BibliotekarRepository;
import com.example.baza.service.BibliotekarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotekarServiceImpl implements BibliotekarService {
    private final BibliotekarRepository bibliotekarRepository;

    public BibliotekarServiceImpl(BibliotekarRepository bibliotekarRepository) {
        this.bibliotekarRepository = bibliotekarRepository;
    }

    @Override
    public List<Bibliotekar2> findAll() {
        return this.bibliotekarRepository.findAll();
    }

    @Override
    public List<Bibliotekar2> findByIdNaBibliotekar(Integer idNaBibliotekar) {
        return this.bibliotekarRepository.findByIdNaBibliotekar(idNaBibliotekar);
    }

    @Override
    public void delete(Integer idNaBibliotekar) {
        this.bibliotekarRepository.deleteByIdNaBibliotekar(idNaBibliotekar);
    }
}
