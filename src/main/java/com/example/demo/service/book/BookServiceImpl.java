package com.example.demo.service.book;

import com.example.demo.dto.request.BookRequest;
import com.example.demo.dto.response.BookResponse;
import com.example.demo.entities.Book;
import com.example.demo.exception.RuleException;
import com.example.demo.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse save(BookRequest bookRequest) {

        Optional<Book> bookExist=bookRepository.findByName(bookRequest.name());

        if(bookExist.isPresent())
            throw new RuleException("book.is.exist");

        Book book = bookRequestToBook(bookRequest);

            book=bookRepository.save(book);

            return bookToBookResponse(book);
    }

    @Override
    public Page<BookResponse> finAll(Pageable pageable) {
        return bookRepository.findAll(pageable).map(book->bookToBookResponse(book));
    }

    @Override
    public List<BookResponse> search(String name) {
        return bookRepository.findBookByNameContaining(name).stream().map(book->bookToBookResponse(book)).collect(Collectors.toCollection(LinkedList::new));

    }

    @Override
    @Transactional
    public void deleted(Long id) {
        Book byId=findById(id);



      bookRepository.deleteById(id);

    }

    @Override
    public BookResponse getById(Long id) {
        return bookToBookResponse(bookRepository.findById(id).orElseThrow(()->new RuleException("book.is.not.found")));
    }


    private Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(()->new RuleException("book.is.not.found"));
    }
    private Book bookRequestToBook(BookRequest bookRequest) {

        Book book = Book.builder().name(bookRequest.name())
                .price(bookRequest.price())
                .build();

        return book;
    }



    private BookResponse bookToBookResponse(Book book) {

        BookResponse bookResponse=new BookResponse(book.getId(),book.getName(),book.getPrice());

        return bookResponse;
    }
}
