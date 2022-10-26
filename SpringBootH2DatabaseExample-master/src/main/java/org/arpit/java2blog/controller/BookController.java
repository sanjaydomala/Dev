package org.arpit.java2blog.controller;

import java.util.List;

import org.arpit.java2blog.model.Book;
import org.arpit.java2blog.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/books")
	private List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/latestbooks")
	private List<Book> getLatestBooks() {
		return bookService.getLatestBooks();
	}

	@GetMapping("/books/{id}")
	private Book getBook(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	
	@GetMapping("/authorbooks/{author}")
	private List<Book> getAuthorBooks(@RequestParam(value = "author") String author) {
		System.out.println("controller");
		return bookService.getAuthorBooks(author);
	}

	@DeleteMapping("/books/{id}")
	private void deleteBook(@PathVariable("id") int id) {
		try {
			bookService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

	@PostMapping("/books")
	private int saveBook(@RequestBody Book book) {
		bookService.saveOrUpdate(book);
		return book.getId();
	}

}