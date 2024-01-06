package com.example.bookserviceusingmysql;

import com.example.bookserviceusingmysql.bookentity.Book;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BookserviceusingmysqlApplicationTest extends AbstractTest{
    @BeforeEach
    public void setup(){
        super.setUp();
    }
    @Test
   public void getAllBookTest()throws Exception{
       String uri="/book";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status=mvcResult.getResponse().getStatus();
        assertEquals(200,status);
        String content=mvcResult.getResponse().getContentAsString();
        Book[] productlist=super.mapFromJson(content,Book[].class);
        assertTrue(productlist.length>0);
   }



}
