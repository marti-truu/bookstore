package eu.graduationproject.bookstore.persistence.sale;

import eu.graduationproject.bookstore.persistence.book.Book;
import eu.graduationproject.bookstore.persistence.customer.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "SALE")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BOOK_ID", nullable = false)
    private Book book;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @NotNull
    @Column(name = "SALE_DATE", nullable = false)
    private LocalDate saleDate;

    @NotNull
    @Column(name = "SALE_PRICE", nullable = false, precision = 10, scale = 2)
    private BigDecimal salePrice;

}