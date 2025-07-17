package eu.graduationproject.bookstore.service.book;

import eu.graduationproject.bookstore.controller.book.dto.BookInfo;
import eu.graduationproject.bookstore.infrastructure.rest.error.Error;
import eu.graduationproject.bookstore.infrastructure.rest.exception.DataNotFoundException;
import eu.graduationproject.bookstore.persistence.book.Book;
import eu.graduationproject.bookstore.controller.book.dto.BookDto;
import eu.graduationproject.bookstore.persistence.book.BookMapper;
import eu.graduationproject.bookstore.persistence.book.BookRepository;
import eu.graduationproject.bookstore.persistence.bookgenre.BookGenre;
import eu.graduationproject.bookstore.persistence.bookgenre.BookGenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {


    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookGenreRepository bookGenreRepository;

    public void addBook(BookDto bookDto) {
        BookGenre bookGenre = bookGenreRepository.findBookGenreBy(bookDto.getBookGenre()).
                orElseThrow(() -> new DataNotFoundException(Error.NO_BOOK_GENRE_EXISTS.getMessage()));
        Book book = bookMapper.toBook(bookDto);
        book.setBookGenre(bookGenre);
        bookRepository.save(book);
    }

    public BookDto findBook(Integer bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new DataNotFoundException(Error.NO_BOOK_EXISTS.getMessage()));
        return bookMapper.toBookDto(book);
    }

    public List<BookInfo> findAllBooks() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.toBookInfos(books);
    }


}

