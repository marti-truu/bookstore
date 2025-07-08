package eu.graduationproject.bookstore.persistence.book;

import eu.graduationproject.bookstore.persistence.bookgenre.BookGenre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BOOK_GENRE_ID", nullable = false)
    private BookGenre bookGenre;

    @Size(max = 100)
    @NotNull
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Size(max = 50)
    @NotNull
    @Column(name = "AUTHOR", nullable = false, length = 50)
    private String author;

    @Column(name = "PRICE", precision = 10, scale = 2)
    private BigDecimal price;

}