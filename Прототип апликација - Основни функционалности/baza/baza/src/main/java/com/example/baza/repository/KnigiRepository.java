package com.example.baza.repository;


import com.example.baza.model.Knigi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KnigiRepository extends JpaRepository<Knigi, Integer> {
    long countById(Integer id);

    Optional<Knigi> findById(Integer integer);

    List<Knigi> findByNaslov(String naslov);

    boolean existsById(Integer integer);

    void deleteById(Integer integer);

    List<Knigi> findByOpisLike(String opis);

    //List<Knigi> findByAvtorLike(String ime);
    @Query(value = "select naslov from knigi where (upper(naslov) like '%text%');\n", nativeQuery = true)
    List<Knigi> findByNaslovLike(String text);

}