package control.modelcontroller;

import model.bl.BorrowBL;
import model.entity.Borrow;
import tools.ExceptionWrapper;

import java.time.LocalDate;
import java.util.List;

public class BorrowController {
    public static String add(int personId, int bookId, LocalDate borrowDate){
        Borrow borrow=new Borrow(personId,bookId,borrowDate,true);
        try {
            BorrowBL.add(borrow);
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
        }
        return borrow.toString();
    }
    public static String edit(int id,int personId,int bookId,LocalDate borrowDate){
        Borrow borrow=new Borrow(id,personId,bookId,borrowDate);
        try{
            BorrowBL.edit(borrow);
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
        }
        return borrow.toString();
    }
    public static void invalidate(int id){
        try{
            BorrowBL.invalidate(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void remove(int id){
        try{
            BorrowBL.remove(id);
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
        }
    }
    public static Borrow findById(int id){
        try{
            return BorrowBL.findById(id);
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
            return null;
        }
    }
    public static List<Borrow> findAll(){
        try {
            return BorrowBL.findAll();
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
            return null;
        }
    }
    public static List<Borrow> reportAll(){
        try{
            return BorrowBL.reportAll();
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
            return null;
        }
    }
    public static List<Borrow> reportByName(String name){
        try{
            return BorrowBL.reportByName(name);
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
            return null;
        }
    }
    public static List<Borrow> reportByLastName(String lastName){
        try{
            return BorrowBL.reportByLastName(lastName);
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
            return null;
        }
    }
    public static List<Borrow> reportByNameLastName(String name,String lastName){
        try{
            return BorrowBL.reportByNameLastName(name,lastName);
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
            return null;
        }
    }
    public static List<Borrow> reportByBookName(String bookName){
        try{
            return BorrowBL.reportByBookName(bookName);
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
            return null;
        }
    }
    public static String getPersonName(int id){
        try{
            return BorrowBL.getPersonName(id);
        }
        catch (Exception  e){
            ExceptionWrapper.getMessage(e);
            return null;
        }
    }
    public static String getBookName(int id){
        try{
            return BorrowBL.getBookName(id);
        }
        catch (Exception  e){
            ExceptionWrapper.getMessage(e);
            return null;
        }
    }
}
