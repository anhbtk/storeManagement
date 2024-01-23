package com.store.Store.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
//@Table (name = "book")
public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String title;
    @ManyToOne
    @JoinColumn(name = "bookcategoryid")
    @JsonIgnore
    private BookCategory bookCategory;

    public Book() {
    }

    public Book(String description, String title) {
        this.description = description;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
