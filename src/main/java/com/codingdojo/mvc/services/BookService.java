package com.codingdojo.mvc.services;
import java.util.List;
import java.util.Optional;

//...
import org.springframework.stereotype.Service;
import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;
@Service
public class BookService {
 // adding the book repository as a dependency
	private final BookRepository bookRepository;
 
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	// returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	// creates a book
	
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
//	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
//		Book bookToUpdate = bookRepository.findById(id).get();
//		bookToUpdate.setTitle(title);
//		bookToUpdate.setDescription(desc);
//		bookToUpdate.setLanguage(lang);
//		bookToUpdate.setNumberOfPages(numOfPages);
//		return bookRepository.save(bookToUpdate);
		
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		
		
	}
	public Book updateBook(Book book) {
		
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}
}


