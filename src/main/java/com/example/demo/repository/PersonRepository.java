package com.example.demo.repository;
import com.example.demo.entities.Person1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person1,Long> {
}
