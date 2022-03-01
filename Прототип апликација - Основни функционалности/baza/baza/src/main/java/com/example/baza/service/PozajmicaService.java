package com.example.baza.service;


import com.example.baza.model.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PozajmicaService {
    Pozajmica findById(Integer id);
    List<Pozajmica> listAll();
    Pozajmica create(LocalDate datumNaZemanje, LocalDate datumNaVrakjanje, Boolean status, Bibliotekar2 bibliotekar, Chlen2 chlen, InstancaOdKniga instancaOdKniga);
    Pozajmica update(Integer id,LocalDate datumNaZemanje, LocalDate datumNaVrakjanje, Boolean status, Bibliotekar2 bibliotekar, Chlen2 chlen, InstancaOdKniga instancaOdKniga);

    @Transactional
    Pozajmica save(LocalDate datumNaZemanje, LocalDate datumNaVrakjanje, Boolean status, Bibliotekar2 bibliotekar, Chlen2 chlen, InstancaOdKniga instanca);
    //Pozajmica save(LocalDate datumNaZemanje, LocalDate datumNaVrakjanje, Boolean status, Bibliotekar2 bibliotekar, Chlen2 chlen, InstancaOdKniga instanca);

}
