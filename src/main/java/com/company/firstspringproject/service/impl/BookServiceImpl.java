package com.company.firstspringproject.service.impl;

import com.company.firstspringproject.entity.Book;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.company.firstspringproject.repository.BookRepository;
import com.company.firstspringproject.service.BookService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @Override
    public ResponseEntity<Book> findById(Long id) {
        return ResponseEntity.ok(bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found!")));
    }

    @Override
    public ResponseEntity<String> update(Book book) {
        bookRepository.save(book);
        return ResponseEntity.ok("Book updated successfully!");
    }

    @Override
    public ResponseEntity<String> delete(long id) {
        bookRepository.deleteById(id);
        return ResponseEntity.ok("Book deleted successfully!");
    }

    @Override
    public ResponseEntity<Book> register(Book book) {
        bookRepository.save(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
}
