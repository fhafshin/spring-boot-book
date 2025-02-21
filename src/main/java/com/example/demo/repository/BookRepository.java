package com.example.demo.repository;

import com.example.demo.dto.response.BookResponse;
import com.example.demo.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findByName(String name);
    @Query(value = "select B from Book B where B.name LIKE %:name%")
    List<Book> findByNameV2(@Param("name") String name);

    List<Book> findBookByNameContaining(String name);


}
