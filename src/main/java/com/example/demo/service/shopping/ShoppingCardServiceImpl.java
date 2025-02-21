package com.example.demo.service.shopping;

import com.example.demo.common.enums.Payed;
import com.example.demo.dto.request.ShoppingRequest;
import com.example.demo.dto.response.BookResponse;
import com.example.demo.dto.response.ShoppingResponse;
import com.example.demo.entities.Book;
import com.example.demo.entities.Factor;
import com.example.demo.entities.ShoppingCard;
import com.example.demo.entities.User;
import com.example.demo.exception.RuleException;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.FactorRepository;
import com.example.demo.repository.ShoppingCardRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCardServiceImpl implements ShoppingCardService {

    private final ShoppingCardRepository shoppingCardRepository;

    private final FactorRepository factorRepository;

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public ShoppingCardServiceImpl(ShoppingCardRepository shoppingCardRepository, FactorRepository factorRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.shoppingCardRepository = shoppingCardRepository;
        this.factorRepository = factorRepository;
        this.userRepository = userRepository;

        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public ShoppingResponse addBook(ShoppingRequest shoppingRequest) {
        var user = userRepository.findById(shoppingRequest.userId()).orElseThrow(() -> new RuleException("User.Not.Found"));

        var book = bookRepository.findById(shoppingRequest.bookId()).orElseThrow(() -> new RuleException("Book.Not.Found"));

        Optional<Factor> byId = factorRepository.findByUserAndPayed(user, Payed.UNPAYED);

        Factor factor = byId.orElseGet(() -> createFactor(user));
        ShoppingCard shoppingCard = createShoppingCard(shoppingRequest, book, factor);
       ShoppingCard save= shoppingCardRepository.save(shoppingCard);

       return shoppingCardToShoppingCardResponse(save);
    }

    private ShoppingResponse shoppingCardToShoppingCardResponse(ShoppingCard save) {

        return new ShoppingResponse(save.getId(),save.getFactor().getId());
    }

    private Factor createFactor(User user) {

        return Factor.builder()
                .user(user)
                .payed(Payed.UNPAYED)
                .build();
    }

    private ShoppingCard createShoppingCard(ShoppingRequest shoppingRequest, Book book, Factor factor) {

        return ShoppingCard.builder().book(book)
                .factor(factor)
                .count(shoppingRequest.count())
                .build();
    }
}
