package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.entities.Book;

@Service
public class BookService {
	
	private static List<Book> books=new ArrayList<>();
	
	static {
		books.add(new Book(1,"The Blocked Man","Aman Chandra"));
		books.add(new Book(2,"The Story of Struggle","Vivek Kumar Prajapati"));
		books.add(new Book(3,"Rani of the World","Aditya Kumar Keshri"));
		books.add(new Book(4,"The man of who nevers drinks","Deepak Kumar"));
		books.add(new Book(5,"Cheap Labour","Vishnu Kant Singh"));
		books.add(new Book(6,"Average man","Vikram Singh"));
		books.add(new Book(7,"Love Guru","Ayush Kumar"));
		books.add(new Book(8,"Depression King Vol. 1","Gajendra Mahawar"));
		books.add(new Book(9,"Depression King Vol. 2","Sujeet"));
		books.add(new Book(10,"The Bournvita Milk Man","David Dahiya"));
		books.add(new Book(11,"Failed in Love","Mithilesh Kumar"));
	}
	
	//get all books
	public List<Book> getAllBooks(){
		return books;
	}
	
	//get book by id
	public Book getBookById(int id) {
		return books.stream().filter(book->book.getId()==id).findFirst().get();
	}
	
	// post the book
	public Book addBook(Book b) {
		books.add(b);
		return b;
	}

	// delete the book by id
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		books=books.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
	}

	public void updateBookById(Book b,int id) {
		// TODO Auto-generated method stub
		books=books.stream().map(book->{
			if(book.getId()==id) {
				book.setTitle(b.getTitle());
				book.setAuthor(b.getAuthor());
			}
			return book;
		}).collect(Collectors.toList());
		
	}
	
	
}