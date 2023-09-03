package control.modelcontroller;

import model.bl.BookBL;
import model.entity.Book;
import tools.ExceptionWrapper;

import java.util.List;

public class BookController {
    public static String add(String name,String author){
        Book book=new Book(name,author,true);
        try{
            BookBL.add(book);
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
        }
        return book.toString();
    }
    public static String edit(int id,String name,String author){
        Book book=new Book(id,name,author);
        try{
            BookBL.edit(book);
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
        }
        return book.toString();
    }
    public static void remove(int id){
        try{
            BookBL.remove(id);
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
        }
    }
    public static Book findById(int id){
        try{
            return BookBL.findById(id);
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
            return null;
        }
    }
    public static List<Book> findAll(){
        try{
            return BookBL.findALl();
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
            return null;
        }
    }
    public static List<Book> findByName(String name){
        try{
            return BookBL.findByName(name);
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
            return null;
        }
    }
    public static List<Book> findByAuthor(String author){
        try{
            return BookBL.findByAuthor(author);
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
            return null;
        }
    }
    public static Boolean isAvailable(int id){
        try {
            return BookBL.isAvailable(id);
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
            return null;
        }
    }
}
