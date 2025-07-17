package eu.graduationproject.bookstore.infrastructure.rest.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Error {
    NO_BOOK_EXISTS("Book does not exist"),
    NO_BOOK_GENRE_EXISTS("BookGenre not found");

    private final String message;
}
