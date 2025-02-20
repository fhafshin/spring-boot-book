package com.example.demo.repository;

import com.example.demo.entities.Person1;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person1, Long> {

    Optional<Person1> findByNameAndLastname(String name, String lastname);

    Optional<Person1> findByNameOrLastname(String name, String lastname);

    List<Person1> findByIdIn(List<Long> ids);


    @Query(value = "select u from Person1 u  where u.name LIKE %:name%")
    Optional<Person1> findByNameStartStr(@Param("name") String name);

    Optional<Person1> findTopByCreationDateNotNull(Sort sort);
}
