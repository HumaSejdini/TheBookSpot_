package com.example.baza.repository;

import com.example.baza.model.Ocena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OcenaRepository extends JpaRepository<Ocena, Integer> {
    Optional<Ocena> findById(Integer id);

    List<Ocena> findByOcena(Integer ocena);

    List<Ocena> findByKomentar(String komentar);

}