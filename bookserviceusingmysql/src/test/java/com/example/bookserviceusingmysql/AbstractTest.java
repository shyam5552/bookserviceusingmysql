package com.example.bookserviceusingmysql;

import com.example.bookserviceusingmysql.bookentity.Book;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

@WebAppConfiguration
public abstract class AbstractTest {
    public MockMvc mvc;
    public WebApplicationContext webApplicationContext;
    public void setUp(){
        mvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }
    public String mapToJson(Book book) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writeValueAsString(book);
    }
    public <T> T mapFromJson(String json,Class<T> clazz)throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.readValue(json,clazz);
    }
}
