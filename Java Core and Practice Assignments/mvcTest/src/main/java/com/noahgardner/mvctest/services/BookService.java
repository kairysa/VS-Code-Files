package com.noahgardner.mvctest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.noahgardner.mvctest.models.Book;
import com.noahgardner.mvctest.repositories.BookRepository;

@Service
public class BookService {
	
	// Adding the book repository as a dependency
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
    public Book updateBook(Long id, String title, String desc,String lang, Integer numOfPages) {
    	Optional<Book> updatedBook = bookRepository.findById(id);
    	updatedBook.get().setTitle(title);
    	updatedBook.get().setDescription(desc);
    	updatedBook.get().setLanguage(lang);
    	updatedBook.get().setNumberOfPages(numOfPages);
    	Book book = updatedBook.get();
    	return bookRepository.save(book);
    }
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}
