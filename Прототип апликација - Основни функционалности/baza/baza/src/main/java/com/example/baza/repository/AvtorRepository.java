package com.example.baza.repository;


import com.example.baza.model.Avtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AvtorRepository extends JpaRepository<Avtor, Integer> {
    Optional<Avtor> findById(Integer integer);
    List<Avtor> findByImeLike(String ime);
}