package com.example.baza.repository;


import com.example.baza.model.Chlen2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface ChlenRepository extends JpaRepository<Chlen2, Integer> {
   // @Query(value = "SELECT ch.broj FROM Chlen ch WHERE ch.broj=1")//mislam deka vaka bi trebalo da e,
        // ama pravi problem posto na scriptata vo dbeaver imam staveno brishenje (cascade) i ne mi dava so /h2 da proveruvam
    Chlen2 findByBroj (Integer broj);

    List<Chlen2> findByDatumNaZachlenuvanje(Instant datumNaZachlenuvanje);

    List<Chlen2> findByChovek_Id(Integer id);

}