package com.example.demo.repository;

import com.example.demo.common.enums.Payed;
import com.example.demo.entities.Factor;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FactorRepository extends JpaRepository<Factor,Long> {


    Optional<Factor> findByUserAndPayed(User user, Payed payed);
}
