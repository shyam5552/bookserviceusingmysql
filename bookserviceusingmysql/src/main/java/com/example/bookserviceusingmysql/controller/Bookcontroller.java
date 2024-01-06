package com.example.bookserviceusingmysql.controller;

import com.example.bookserviceusingmysql.bookentity.Book;

import com.example.bookserviceusingmysql.servicel.Bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Bookcontroller {
    @Autowired
    Bookservice bookservice;
    @GetMapping(value = "/book")
    public List<Book> getAllBook(){
        return bookservice.getallbooks();
    }
    @PostMapping(value = "/book")
    public void addbook(@RequestBody Book book){
        bookservice.addbook(book);

    }
    @PutMapping(value = "/book/{book_id}")
    public void updatebook(@RequestBody Book book,@PathVariable int book_id){
        bookservice.updatebook(book,book_id);
    }
    @GetMapping(value = "/book/{book_id}")
    public Book getbookbyid(@PathVariable int book_id){
        return bookservice.getbookbyid(book_id);
    }
    @DeleteMapping(value = "/book/{book_id}")
    public  void deletebook(@PathVariable int book_id){
        bookservice.deletebook(book_id);

    }




}
