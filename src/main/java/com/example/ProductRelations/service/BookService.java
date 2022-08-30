package com.example.ProductRelations.service;

import com.example.ProductRelations.entity.Book;

public interface BookService {
     Iterable<Book> getAll();
     Book save(Book book) throws NoSuchMethodException;

}
