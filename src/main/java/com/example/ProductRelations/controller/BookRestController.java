package com.example.ProductRelations.controller;

import com.example.ProductRelations.entity.Book;
import com.example.ProductRelations.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {
    private BookServiceImpl bookService;

    @Autowired
    public BookRestController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }


    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        bookService.save(book);
        return book;
    }

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        return bookService.getAll();
    }

}
