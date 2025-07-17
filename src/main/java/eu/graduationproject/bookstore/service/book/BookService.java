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
import eu.graduationproject.bookstore.persistence.sale.Sale;
import eu.graduationproject.bookstore.persistence.sale.SaleRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {


    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookGenreRepository bookGenreRepository;
    private final SaleRepository saleRepository;

    public void addBook(BookDto bookDto) {
        BookGenre bookGenre = getValidBookGenre(bookDto.getBookGenre());
        Book book = bookMapper.toBook(bookDto);
        book.setBookGenre(bookGenre);
        bookRepository.save(book);
    }



    public BookDto findBook(Integer bookId) {
        Book book = getValidBook(bookId);
        return bookMapper.toBookDto(book);
    }



    public List<BookInfo> findAllBooks() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.toBookInfos(books);
    }


    public void updateBook(Integer bookId, BookDto bookDto) {
        Book book = getValidBook(bookId);
        BookGenre bookGenre = getValidBookGenre(bookDto.getBookGenre());
        bookMapper.updateBook(bookDto, book);
        book.setBookGenre(bookGenre);
        bookRepository.save(book);
    }

    /*public void deleteBook(Integer bookId) {
        Book book = getValidBook(bookId);

        Optional<Sale> optionalSale = saleRepository.findSaleBy(book);
        optionalSale.ifPresent( Sale sale -> saleRepository.);


    }*/
    private Book getValidBook(Integer bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new DataNotFoundException(Error.NO_BOOK_EXISTS.getMessage()));
    }
    private BookGenre getValidBookGenre(String BookGenreName) {
        return bookGenreRepository.findBookGenreBy(BookGenreName).
                orElseThrow(() -> new DataNotFoundException(Error.NO_BOOK_GENRE_EXISTS.getMessage()));
    }


}

