package com.example.baza.repository;


import com.example.baza.model.Chovek2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChovekRepository extends JpaRepository<Chovek2, Integer> {

    Optional<Chovek2> findById(Integer id);

    List<Chovek2> findByImeAndPrezime(String ime, String prezime);

    Optional<Chovek2> findByUsernameAndPassword(String username, String password);

    List<Chovek2> findByEmail(String email);

    List<Chovek2> findByTelBroj(String telBroj);

}