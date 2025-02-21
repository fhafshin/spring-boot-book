package com.example.demo.controller;

import com.example.demo.dto.request.BookRequest;
import com.example.demo.dto.response.BookResponse;
import com.example.demo.service.book.BookService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public ResponseEntity<BookResponse> save(@RequestBody @Valid BookRequest book) {

        return ResponseEntity.ok(bookService.save(book));
    }

    @GetMapping("/find-all")
    public ResponseEntity<Page<BookResponse>> getAll(Pageable pageable){

       return ResponseEntity.ok(bookService.finAll(pageable));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<BookResponse>> search(@PathVariable String name){

        return ResponseEntity.ok(bookService.search(name));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<BookResponse> getById(@PathVariable Long id){

       return ResponseEntity.ok(bookService.getById(id));

    }

    @DeleteMapping("/delete/{id}")

    public ResponseEntity<?> delete(@PathVariable Long id){
        bookService.deleted(id);
        return ResponseEntity.ok("book is deleted");
    }
}
