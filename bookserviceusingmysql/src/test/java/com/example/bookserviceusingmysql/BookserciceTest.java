package com.example.bookserviceusingmysql;

import com.example.bookserviceusingmysql.bookentity.Book;
import com.example.bookserviceusingmysql.repository.BookRepository;
import com.example.bookserviceusingmysql.servicel.Bookservice;
import org.assertj.core.util.Streams;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
class BookserciceTest {
	@Autowired
	public Bookservice bookservice;
	@MockBean
	public BookRepository bookRepository;
	@Test
	public void getallbooksTest(){
		when(bookRepository.findAll()).thenReturn(Stream.of(
				new Book(1,"java","shyam","ravi"),
				new Book(2,"java","shyam","ravi")).collect(Collectors.toList()));
		assertEquals(2,bookservice.getallbooks().size());
	}
	@Test
	public void getbookbyidTest(){
		int book_id=1;
		Book b=new Book(1,"java","shyam","ravi");
		when(bookRepository.findById(book_id)).thenReturn(Optional.of(b));
		assertEquals(b,bookservice.getbookbyid(book_id));

	}





}
