package eu.graduationproject.bookstore.controller.book.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto implements Serializable {
    @NotNull
    @Size(max = 50)
    private String bookGenre;

    @NotNull
    @Size(max = 100)
    private String bookName;

    @NotNull
    @Size(max = 50)
    private String author;

    @NotNull
    private BigDecimal price;
}

