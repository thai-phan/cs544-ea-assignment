package lab.dao;


import lab.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
  List<Book> findByAuthorContainingIgnoreCase(String author);

  boolean existsBookByIsbn(String isbn);
}

