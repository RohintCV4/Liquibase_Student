package com.example.LiquiStd.repository;



import java.util.Optional;

import com.example.LiquiStd.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

    Optional<School> findByEmail(String email);

    boolean existsByEmail(String email);


}

