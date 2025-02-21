package com.example.demo.service.book;

import com.example.demo.dto.request.BookRequest;
import com.example.demo.dto.response.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {

    BookResponse save(BookRequest bookRequest);

    Page<BookResponse> finAll(Pageable pageable);

    List<BookResponse> search(String name);

    void deleted(Long id);

    BookResponse getById(Long id);
}
