package eu.graduationproject.bookstore.persistence.book;

import eu.graduationproject.bookstore.controller.book.dto.BookDto;
import eu.graduationproject.bookstore.controller.book.dto.BookInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {

    @Mapping(source = "bookGenre.genreName", target = "bookGenre")
    @Mapping(source = "name", target = "bookName")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "price", target = "price")
    BookDto toBookDto(Book book);

    @InheritConfiguration(name = "toBookDto")
    @Mapping(source = "id", target = "bookId")
    BookInfo toBookInfo(Book book);

    List<BookInfo> toBookInfos(List<Book> books);


    @Mapping(source = "bookName", target = "name" )
    @Mapping(source = "author", target = "author" )
    @Mapping(source = "price", target = "price" )
    @Mapping(ignore = true, target = "bookGenre" )
    Book toBook(BookDto bookDto);
}