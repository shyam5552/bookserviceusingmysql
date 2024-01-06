package com.example.bookserviceusingmysql.servicel;

import com.example.bookserviceusingmysql.bookentity.Book;
import com.example.bookserviceusingmysql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Bookservice {

    @Autowired
    public BookRepository bookRepository;
    public List<Book> getallbooks() {
        return bookRepository.findAll();

    }

    public void addbook(Book book) {
        bookRepository.save(book);
    }

    public void updatebook(Book book, int bookId) {
        bookRepository.save(book);
    }

    public Book getbookbyid(int bookId) {
        return bookRepository.findById(bookId).get();
    }

    public void deletebook(int bookId) {
        bookRepository.deleteById(bookId);
    }
}
