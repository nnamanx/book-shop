package com.company.firstspringproject.controller;


import com.company.firstspringproject.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.company.firstspringproject.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    //      FIND ALL
    @GetMapping()
    public ResponseEntity<List<Book>> book() {
        return bookService.findAll();
    }

    //        FIND BY ID
    @GetMapping("{id}")
    public ResponseEntity<Book> booksFindById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    //      UPDATE
    @PutMapping("/update")
    public ResponseEntity<String> bookUpdate(Book book) {
        return bookService.update(book);
    }


    //      DELETE
    @DeleteMapping("/delete")
    public ResponseEntity<String> bookDelete(Long id) {
        return bookService.delete(id);
    }


    //      REGISTER
    @PostMapping("/{id}/register")
    public ResponseEntity<Book> bookRegister(Book book) {
        return bookService.register(book);
    }

}
