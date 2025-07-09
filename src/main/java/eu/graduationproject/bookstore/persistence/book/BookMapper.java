package eu.graduationproject.bookstore.persistence.book;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {

    @Mapping(source = "bookGenre.genreName", target = "bookGenre")
    @Mapping(source = "name", target = "bookName")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "price", target = "price")
    BookDto toBookDto(Book book);

}