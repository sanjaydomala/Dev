package org.arpit.java2blog.repository;

import org.arpit.java2blog.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {}