package com.example.demo.repository;

import com.example.demo.entities.Factor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactorRepository extends JpaRepository<Factor,Long> {
}
