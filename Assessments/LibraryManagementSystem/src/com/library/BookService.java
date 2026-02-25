package com.library;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public void addBook(Long id, String title, String author) {
		if (bookRepository.findById(id) != null) {
			System.out.println("Book with this ID already exists.");
			return;
		}
		bookRepository.save(new Book(id, title, author));
		System.out.println("Book Added Successfully");
	}

	public List<Book> getAvailableBooks() {
		return bookRepository.findAll().stream().filter(Book::isAvailable).toList();
	}

	public Book getBook(Long id) {
		return bookRepository.findById(id);
	}

	public void markAsIssued(Book book) {
		book.setAvailable(false);
	}

	public void markAsReturned(Book book) {
		book.setAvailable(true);
	}
}