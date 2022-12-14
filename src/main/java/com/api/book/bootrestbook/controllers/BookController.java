package com.api.book.bootrestbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> getBook() {
//		Book book = new Book();
//		book.setId(1);
//		book.setTitle("The Story of Mine");
//		book.setAuthor("Aman Chandra");
		return bookService.getAllBooks();
	} 
	
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book b) {
		return bookService.addBook(b);
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		bookService.deleteById(id);
	}
	
	@PutMapping("/books/{id}")
	public Book updateBookById(@RequestBody Book book, @PathVariable("id") int id) {
		bookService.updateBookById(book,id);
		return book;
	}
}
