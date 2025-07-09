package eu.graduationproject.bookstore.service.book;

import eu.graduationproject.bookstore.infrastructure.rest.error.Error;
import eu.graduationproject.bookstore.infrastructure.rest.exception.DataNotFoundException;
import eu.graduationproject.bookstore.persistence.book.Book;
import eu.graduationproject.bookstore.persistence.book.BookDto;
import eu.graduationproject.bookstore.persistence.book.BookMapper;
import eu.graduationproject.bookstore.persistence.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {


    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    public BookDto findBook(Integer bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new DataNotFoundException(Error.NO_BOOK_EXISTS.getMessage()));
        return bookMapper.toBookDto(book);
    }
}

