package com.example.bookserviceusingmysql.repository;

import com.example.bookserviceusingmysql.bookentity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BookRepository extends JpaRepository<Book,Integer> {
}
