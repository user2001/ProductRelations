package com.example.ProductRelations.dao;

import com.example.ProductRelations.entity.Book;
import org.springframework.data.repository.CrudRepository;

public  interface BookRepository extends CrudRepository<Book,Long> {
}
