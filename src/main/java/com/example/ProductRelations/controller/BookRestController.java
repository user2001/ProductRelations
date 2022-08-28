package com.example.ProductRelations.controller;

import com.example.ProductRelations.entity.Book;
import com.example.ProductRelations.entity.BookDescription;
import com.example.ProductRelations.entity.BookParameter;
import com.example.ProductRelations.entity.Category;
import com.example.ProductRelations.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRestController {
    private BookServiceImpl bookService;

    @Autowired
    public BookRestController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }


    @PostMapping("/books")
    public void createProducts(@RequestBody Book book,Category categoryName, BookDescription annotation, BookParameter author) {
        bookService.save(book,categoryName,annotation,author);
        System.out.println(book);
    }

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        return bookService.getAll();
    }

}
