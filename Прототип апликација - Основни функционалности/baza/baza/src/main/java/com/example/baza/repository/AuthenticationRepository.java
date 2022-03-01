package com.example.baza.repository;


import com.example.baza.model.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, Integer> {
    Optional<Authentication> findById(Integer id);

    List<Authentication> findByTimestampLog(Instant timestampLog);

}