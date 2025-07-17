package eu.graduationproject.bookstore.controller.book.dto;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


import java.io.Serializable;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto implements Serializable {
    @NonNull
    @Size(max = 50)
    private String bookGenre;

    @NonNull
    @Size(max = 100)
    private String bookName;

    @NonNull
    @Size(max = 50)
    private String author;

    @NonNull
    private BigDecimal price;
}

