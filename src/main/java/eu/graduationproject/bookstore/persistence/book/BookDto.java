package eu.graduationproject.bookstore.persistence.book;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto implements Serializable {
    private String bookGenre;
    private String bookName;
    private String author;
    private BigDecimal price;
}

