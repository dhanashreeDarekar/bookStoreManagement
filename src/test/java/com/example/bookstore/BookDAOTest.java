package com.example.bookstore;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.sql.SQLException;

public class BookDAOTest {

    String jdbcUrl = "jdbc:mysql://localhost:3306/bookstore";
    String uname = "root";
    String pass = "1234";

//    BookDAO bookdao;

//    @BeforeEach
//    public void init(){
//        bookdao = new BookDAO(jdbcUrl,uname,pass);
//    }

    @Test
    public void connectionTest() throws SQLException {
        BookDAO bookdao = new BookDAO(jdbcUrl,uname,pass);

        Assertions.assertEquals(false,bookdao.connect());
    }


    @Test
    public void getBookTest() throws SQLException {
        BookDAO bookdao = new BookDAO(jdbcUrl,uname,pass);
        Assertions.assertNotNull(bookdao.listAllBooks());
        Assertions.assertEquals("abcd",bookdao.getBook(1).title);
    }

    @Test
    public void insertBookTest() throws SQLException {
        BookDAO bookdao = new BookDAO(jdbcUrl,uname,pass);
        Book book = new Book();
        book.setAuthor("Dhanashree");
        book.setTitle("Japanese");
        book.setPrice(500);

        Assertions.assertEquals(true, bookdao.insertBook(book));
    }

    @Test
    public void updateBookTest() throws SQLException {

        BookDAO bookdao = new BookDAO(jdbcUrl,uname,pass);
        Book book = bookdao.getBook(1);
        book.setAuthor("Dhanu");
        bookdao.updateBook(book);
        Assertions.assertEquals("Dhanu",bookdao.getBook(1).author);

    }


    @Test
    public void deleteBookTest() throws SQLException {

        BookDAO bookdao = new BookDAO(jdbcUrl,uname,pass);
        Book book = bookdao.getBook(3);
        bookdao.deleteBook(book);
        Assertions.assertNull(bookdao.getBook(3));

    }

    




}
