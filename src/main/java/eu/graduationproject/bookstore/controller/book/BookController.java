package eu.graduationproject.bookstore.controller.book;


import eu.graduationproject.bookstore.infrastructure.rest.error.ApiError;
import eu.graduationproject.bookstore.persistence.book.BookDto;
import eu.graduationproject.bookstore.service.book.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/book/{bookId}")
    @Operation(summary = "Finds a book by its ID", description = "Finds a book by its ID, if no match is found then error is thrown")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Book does not exist",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
    })
    public BookDto findBook(@PathVariable Integer bookId) {
        return bookService.findBook(bookId);

    }
}
