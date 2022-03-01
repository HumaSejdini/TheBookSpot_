package com.example.baza.repository;

import com.example.baza.model.Bibliotekar2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BibliotekarRepository extends JpaRepository<Bibliotekar2, Integer> {
    List<Bibliotekar2> findByIdNaBibliotekar(Integer idNaBibliotekar);

    void deleteByIdNaBibliotekar(Integer idNaBibliotekar);
}