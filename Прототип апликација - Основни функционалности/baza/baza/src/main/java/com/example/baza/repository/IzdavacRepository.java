package com.example.baza.repository;


import com.example.baza.model.Izdavac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IzdavacRepository extends JpaRepository<Izdavac, Integer> {
    Optional<Izdavac> findById(Integer integer);

    void deleteById(Integer integer);

    List<Izdavac> findByEmail(String email);

    List<Izdavac> findByLokacija(String lokacija);

    List<Izdavac> findByImeNaIzdavac(String imeNaIzdavac);

}