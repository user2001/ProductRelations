package com.example.ProductRelations.service;

import com.example.ProductRelations.dao.BookRepository;
import com.example.ProductRelations.entity.Book;
import com.example.ProductRelations.entity.BookDescription;
import com.example.ProductRelations.entity.BookParameter;
import com.example.ProductRelations.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    void init() {
        Book book1 = new Book("Anxious people", new BigDecimal(300));
        Book book2 = new Book("Bear town", new BigDecimal(300));
        Book book3 = new Book("Little life", new BigDecimal(600));
        Book book4 = new Book("Harry Potter", new BigDecimal(240));
        Book book5 = new Book("The Runaways", new BigDecimal(180));

        Category category1 = new Category("For kids");
        Category category2 = new Category("For adults");

        BookParameter bookParameter1 = new BookParameter("Frederik Backman");
        BookParameter bookParameter2 = new BookParameter("J.D Rowling");
        BookParameter bookParameter3 = new BookParameter("Hanya Yanagihara");
        BookParameter bookParameter4 = new BookParameter("Ulf Stark");

        BookDescription bookDescription1 = new BookDescription("magic story for kids");
        BookDescription bookDescription2 = new BookDescription("Anxious People’s whimsical" +
                " plot serves up unforgettable insights into the human condition and a gentle" +
                " reminder to be compassionate to all the anxious people we encounter every day");
        BookDescription bookDescription3 = new BookDescription(" tragic and transcendent hymn " +
                "to brotherly love, a masterful depiction of heartbreak, and a dark examination of the" +
                " tyranny of memory and the limits of human endurance.");
        BookDescription bookDescription4 = new BookDescription("Beartown explores the hopes that bring " +
                "a small community together, the secrets that tear it apart, and the courage it takes for " +
                "an individual to go against the grain. In this story of a small forest town, Fredrik Backman" +
                " has found the entire world.");
        BookDescription bookDescription5 = new BookDescription("The Runaways is an adventure filled with " +
                "warmth and humor from one of the world's great writers.");
        book1.setBookDescription(bookDescription2);
        book1.setBookParameter(bookParameter1);
        book1.setCategory(Arrays.asList(category2));

        book2.setBookDescription(bookDescription4);
        book2.setBookParameter(bookParameter1);
        book2.setCategory(Arrays.asList(category2));

        book3.setBookDescription(bookDescription3);
        book3.setBookParameter(bookParameter3);
        book3.setCategory(Arrays.asList(category2));

        book4.setBookDescription(bookDescription1);
        book4.setBookParameter(bookParameter2);
        book4.setCategory(Arrays.asList(category1));

        book5.setBookDescription(bookDescription5);
        book5.setBookParameter(bookParameter4);
        book5.setCategory(Arrays.asList(category1));

        bookRepository.saveAll(Arrays.asList(book1,book2,book3,book4,book5));

    }

    @Override
    @Transactional
    public Iterable<Book> getAll() {
         return  bookRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Book book) {
//        book.setCategory(Arrays.asList(categoryName));
//        book.setBookParameter(author);
//        book.setBookDescription(annotation);
        bookRepository.save(book);
    }

//    @Override
//    @Transactional
//    public void deleteBook(Long bookId) {
//        Book tempBook = entityManager.find(Book.class, bookId);
//        entityManager.remove(tempBook);
//    }
//
//    @Override
//    @Transactional
//    public Book getBook(Long bookId) {
//        return entityManager.find(Book.class, bookId);
//    }

}
