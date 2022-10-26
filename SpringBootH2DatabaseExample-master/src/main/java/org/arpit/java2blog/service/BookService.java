package org.arpit.java2blog.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.arpit.java2blog.model.Book;
import org.arpit.java2blog.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> Books = new ArrayList<Book>();
        bookRepository.findAll().forEach(book -> Books.add(book));
        return Books;
    }
    
    public List<Book> getLatestBooks() {
        List<Book> books = new ArrayList<Book>();
       books = (List<Book>) bookRepository.findAll();
       for(Book book : books) {
    	   if(book.getYear()>2020) {
    		   books.add(book);
    	   }
       }
        return books;
    }
    
    public List<Book> getAuthorBooks(String author) {
    	System.out.println("service");
    	List<Book> books = new ArrayList<Book>();
        books = (List<Book>) bookRepository.findAll();
        Iterator<Book> itr = books.iterator();
        while(itr.hasNext()) {
     	   Book book = itr.next();
     	   if(book.getAuthor().equals(author)) {
     		   books.add(book);
     	   }
        }
         return books;
     }
    

    public Book getBookById(int id) {
        return bookRepository.findById(id).get();
    }

    public void saveOrUpdate(Book book) {
    	bookRepository.save(book);
    }

    public void delete(int id) {
    	bookRepository.deleteById(id);
    }

}