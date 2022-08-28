package com.example.ProductRelations.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private BigDecimal price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_description_id")
    private BookDescription bookDescription;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Books_Categories",
    joinColumns = @JoinColumn(name = "book_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private List<Category> category;

    @ManyToOne( cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
    @JoinColumn(name = "book_parameter_id",referencedColumnName = "id")
    private BookParameter bookParameter;

    public Book() {
    }

    public Book(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BookDescription getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(BookDescription bookDescription) {
        this.bookDescription = bookDescription;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public BookParameter getBookParameter() {
        return bookParameter;
    }

    public void setBookParameter(BookParameter bookParameter) {
        this.bookParameter = bookParameter;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", bookDescription=" + bookDescription.getAnnotation() +
                ", category=" + category +
                ", bookParameter=" + bookParameter.getAuthor() +
                '}';
    }
}
