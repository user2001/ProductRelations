package com.example.ProductRelations.entity;

import javax.persistence.*;

@Entity
public class BookDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String annotation;

    @OneToOne(cascade = CascadeType.ALL)
    private Book book;

    public BookDescription(String annotation) {
        this.annotation = annotation;
    }

    public BookDescription() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
