package com.company.firstspringproject.service;

import com.company.firstspringproject.entity.Book;
import org.apache.catalina.LifecycleState;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    ResponseEntity<List<Book>> findAll();

    ResponseEntity<Book> findById(Long id);

    ResponseEntity<String> update(Book book);

    ResponseEntity<String> delete(long id);

    ResponseEntity<Book> register(Book book);

}
