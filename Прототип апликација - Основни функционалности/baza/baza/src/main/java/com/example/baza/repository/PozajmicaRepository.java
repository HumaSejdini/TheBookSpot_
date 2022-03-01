package com.example.baza.repository;


import com.example.baza.model.Pozajmica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PozajmicaRepository extends JpaRepository<Pozajmica, Integer> {
    Optional<Pozajmica> findById(Integer integer);

    List<Pozajmica> findByDatumNaZemanje(LocalDate datumNaZemanje);

    List<Pozajmica> findByDatumNaVrakjanje(LocalDate datumNaVrakjanje);

    List<Pozajmica> findByStatus(Boolean status);
}