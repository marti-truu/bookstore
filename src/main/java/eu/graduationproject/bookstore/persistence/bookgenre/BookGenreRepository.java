package eu.graduationproject.bookstore.persistence.bookgenre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface BookGenreRepository extends JpaRepository<BookGenre, Integer> {

    @Query("select b from BookGenre b where upper(b.genreName) = upper(:genreName)")
    Optional<BookGenre> findBookGenreBy(String genreName);
}