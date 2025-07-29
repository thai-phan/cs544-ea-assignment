package lab.service;


import lab.dao.BookRepository;
import lab.domain.Book;
import lab.service.adapter.BookAdapter;
import lab.service.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IBookServiceImpl implements IBookService {

  @Autowired
  private BookRepository bookRepository;

  @Override
  public BookDTO addBook(BookDTO bookDTO) {
    if (bookRepository.existsById(bookDTO.getIsbn())) {
      throw new BookAlreadyExistsException(bookDTO.getIsbn());
    }
    Book book = BookAdapter.convertDTOToBook(bookDTO);
    bookRepository.save(book);
    return bookDTO;
  }

  @Override
  public BookDTO updateBook(BookDTO bookDTO) {
    Book book = BookAdapter.convertDTOToBook(bookDTO);
    bookRepository.save(book);
    return bookDTO;
  }

  @Override
  public void deleteBook(String isbn) {
    bookRepository.deleteById(isbn);
  }

  @Override
  public BookDTO getBook(String isbn) {
    Book book = bookRepository.findById(isbn).orElseThrow();
    return BookAdapter.convertBookToDTO(book);
  }

  @Override
  public List<BookDTO> getAllBooks() {
    List<Book> books = bookRepository.findAll();
    return BookAdapter.convertBooksToDTOs(books);
  }

  @Override
  public List<BookDTO> searchBooksByAuthor(String author) {
    List<Book> books = bookRepository.findByAuthorContainingIgnoreCase(author);
    return BookAdapter.convertBooksToDTOs(books);
  }
}
