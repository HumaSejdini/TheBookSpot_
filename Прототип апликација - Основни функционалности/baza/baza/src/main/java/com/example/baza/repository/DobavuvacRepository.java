package com.example.baza.repository;


import com.example.baza.model.Dobavuvac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DobavuvacRepository extends JpaRepository<Dobavuvac, Integer> {

    Optional<Dobavuvac> findById(Integer id);


    void deleteById(Integer id);

    List<Dobavuvac> findByImeNaDobavuvac(String imeNaDobavuvac);


}