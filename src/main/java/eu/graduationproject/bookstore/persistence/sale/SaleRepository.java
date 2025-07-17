package eu.graduationproject.bookstore.persistence.sale;

import eu.graduationproject.bookstore.persistence.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

    @Query("select s from Sale s where s.book = :book")
    Optional<Sale> findSaleBy(Book book);
}