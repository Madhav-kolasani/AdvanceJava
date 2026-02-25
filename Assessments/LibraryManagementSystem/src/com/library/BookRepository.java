package com.library;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    public BookRepository() {
        books.add(new Book(1L, "Java Basics", "James Gosling"));
        books.add(new Book(2L, "Spring Framework", "Rod Johnson"));
        books.add(new Book(3L, "Clean Code", "Robert Martin"));
    }

    public void save(Book book) {
        books.add(book);
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findById(Long id) {
        return books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}