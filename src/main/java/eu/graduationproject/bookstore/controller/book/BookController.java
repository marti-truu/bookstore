package eu.graduationproject.bookstore.controller.book;


import eu.graduationproject.bookstore.controller.book.dto.BookDto;
import eu.graduationproject.bookstore.controller.book.dto.BookInfo;
import eu.graduationproject.bookstore.infrastructure.rest.error.ApiError;
import eu.graduationproject.bookstore.service.book.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/book")
    @Operation(summary = "Adds a book", description = "Adds a book. Throws error 'BookGenre not fund' if book genre is not found from the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Invalid request body: payload validation failed",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "BookGenre not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
    })
    public void addBook(@RequestBody @Valid BookDto bookDto) {
        bookService.addBook(bookDto);

    }

    @GetMapping("/book/{bookId}")
    @Operation(summary = "Finds a book by its ID", description = "Finds a book by its ID, if no match is found then error is thrown")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Book does not exist",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
    })
    public BookDto findBook(@PathVariable Integer bookId) {
        return bookService.findBook(bookId);}

    @GetMapping("/books")
    @Operation(summary = "Finds all books", description = "Finds all books")
    public List<BookInfo> findAllBooks() {
        return bookService.findAllBooks();
    }

    @PutMapping("/book/{bookId}")
    @Operation(summary = "Updates a book", description = "Updates a book. If there are any null value fields then won't get updated")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Invalid request body: payload validation failed",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "Book does bot exist / BookGenre not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
    })

    public void updateBook(@PathVariable Integer bookId, @RequestBody @Valid BookDto bookDto) {
        bookService.updateBook(bookId, bookDto);

    }

    @DeleteMapping("/book/{bookId}")
    @Operation(summary = "Deletes a book by its ID",
            description = "Also checks if any sales record exists with this book. If yes then sale record is also deleted")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Book dose not exist",
                content = @Content(schema = @Schema(implementation = ApiError.class)))
    })

    public void deleteBook(@PathVariable Integer bookId) {
        bookService.deleteBook(bookId);
    }
}
