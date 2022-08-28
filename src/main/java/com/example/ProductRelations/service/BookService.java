package com.example.ProductRelations.service;

import com.example.ProductRelations.entity.Book;
import com.example.ProductRelations.entity.BookDescription;
import com.example.ProductRelations.entity.BookParameter;
import com.example.ProductRelations.entity.Category;

public interface BookService {
    public Iterable<Book> getAll();
    public void save (Book book, Category categoryName, BookDescription annotation, BookParameter author);
//    public void deleteBook(Long bookId);
//    public Book getBook(Long bookId);
}
