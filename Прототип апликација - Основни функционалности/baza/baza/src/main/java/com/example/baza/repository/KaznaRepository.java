package com.example.baza.repository;


import com.example.baza.model.Kazna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface KaznaRepository extends JpaRepository<Kazna, Integer> {
    Optional<Kazna> findById(Integer integer);

    void deleteById(Integer integer);

    List<Kazna> findByDatum(LocalDate datum);

    List<Kazna> findByCenaVoDenari(Double cenaVoDenari);
}