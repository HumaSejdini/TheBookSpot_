package com.example.baza.repository;


import com.example.baza.model.Kategorija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KategorijaRepository extends JpaRepository<Kategorija, Integer> {

    Optional<Kategorija> findById(Integer id);

    void deleteById(Integer integer);

    List<Kategorija> findByImeKategorija(String imeKategorija);


}