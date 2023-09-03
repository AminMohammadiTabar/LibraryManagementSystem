package model.bl;

import model.da.BookDA;
import model.entity.Book;

import java.util.List;

public class BookBL {
    public static Book add(Book book) throws Exception {
        try (BookDA bookDA = new BookDA()) {
            return bookDA.add(book);
        }
    }public static Book edit(Book book) throws Exception {
        try (BookDA bookDA = new BookDA()) {
            return bookDA.edit(book);
        }
    }public static Book remove(int id) throws Exception {
        try (BookDA bookDA = new BookDA()) {
            return bookDA.remove(id);
        }
    }public static Book changeAvailability(int id,Boolean availability) throws Exception {
        try (BookDA bookDA = new BookDA()) {
            return bookDA.changeAvailability(id,availability);
        }
    }public static List<Book> findALl() throws Exception {
        try (BookDA bookDA = new BookDA()) {
            return bookDA.findAll();
        }
    }public static Book findById(int id) throws Exception {
        try (BookDA bookDA = new BookDA()) {
            return bookDA.findById(id);
        }
    }
    public static List<Book> findByName(String name) throws Exception {
        try (BookDA bookDA = new BookDA()) {
            return bookDA.findByName(name);
        }
    }
    public static List<Book> findByAuthor(String author) throws Exception {
        try (BookDA bookDA = new BookDA()) {
            return bookDA.findByAuthor(author);
        }
    }
    public static Boolean isAvailable(int id) throws Exception {
        try (BookDA bookDA = new BookDA()) {
            return bookDA.isAvailable(id);
        }
    }
}
