package com.example.baza.service.impl;

import com.example.baza.model.Chovek2;
import com.example.baza.model.exception.InvalidArgumentsException;
import com.example.baza.model.exception.InvalidChovekIdException;
import com.example.baza.model.exception.InvalidUserCredentialsException;
import com.example.baza.repository.ChovekRepository;
import com.example.baza.service.ChovekService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChovekServiceImpl implements ChovekService {
    private final ChovekRepository chovekRepository;

    public ChovekServiceImpl(ChovekRepository chovekRepository) {
        this.chovekRepository = chovekRepository;
    }

    @Override
    public List<Chovek2> listAll() {
        return this.chovekRepository.findAll();
    }

    @Override
    public Chovek2 findById(Integer id) {
        return this.chovekRepository.findById(id).orElseThrow(InvalidChovekIdException::new);
    }

    @Override
    public Chovek2 login(String username, String password) {
        if(username == null || username.isEmpty() || password == null || password.isEmpty())
        {
            throw new InvalidArgumentsException();
        }
        return chovekRepository.findByUsernameAndPassword(username,password)
                .orElseThrow(InvalidUserCredentialsException::new);
    }


    @Override
    public Chovek2 create(String ime, String prezime, String email, String telBroj, String adresa, String embg, String username, String password) {
        return this.chovekRepository.save(new Chovek2(ime,prezime,email,telBroj,adresa,embg,username,password));
    }//todo : dali postoi dali ne , exception etc etc...

    @Override
    public Chovek2 delete(Integer id) {
        Chovek2 ch=this.findById(id);
        this.chovekRepository.delete(ch);
        return ch;
    }
}
