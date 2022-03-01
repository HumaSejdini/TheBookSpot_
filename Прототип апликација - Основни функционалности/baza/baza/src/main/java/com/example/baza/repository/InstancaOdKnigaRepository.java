package com.example.baza.repository;


import com.example.baza.model.InstancaOdKniga;
import com.example.baza.model.InstancaOdKnigaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstancaOdKnigaRepository extends JpaRepository<InstancaOdKniga, InstancaOdKnigaId> {
    List<InstancaOdKniga> findById_IdNaKniga(Integer idNaKniga);
    
    List<InstancaOdKniga> findByIdNaKniga_Naslov(String naslov);

    List<InstancaOdKniga> findByIdNaKniga_Avtors_Ime(String ime);

    Optional<InstancaOdKniga> findById(Integer uid);

    void deleteById(Integer id);
}