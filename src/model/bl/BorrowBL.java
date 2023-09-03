package model.bl;

import model.da.BorrowDA;
import model.entity.Borrow;

import java.sql.SQLException;
import java.util.List;

public class BorrowBL {

    public static Borrow add(Borrow borrow) throws Exception {
        if(BookBL.isAvailable(borrow.getBookId())&&!PersonBL.findById(borrow.getPersonId()).toString().isEmpty()){
            try (BorrowDA borrowDA=new BorrowDA()) {
                BookBL.changeAvailability(borrow.getBookId(),false);
                return borrowDA.add(borrow);
            }
        }
        else{
            return null;
        }
    }
    public static Borrow edit(Borrow borrow) throws Exception {
        try (BorrowDA borrowDA=new BorrowDA()){
            return borrowDA.edit(borrow);
        }
    }
    public static Borrow invalidate(int id) throws Exception{
        try(BorrowDA borrowDA=new BorrowDA()) {
            int bookId= borrowDA.getBookId(id);
            if (!BookBL.isAvailable(bookId)) {
                BookBL.changeAvailability(bookId,true);
                return borrowDA.invalidate(id);
            }
            else{
                return null;
            }
        }
    }
    public static Borrow remove(int id) throws Exception {
        try(BorrowDA borrowDA=new BorrowDA()){
           return borrowDA.remove(id);
        }
    }
    public static Borrow findById(int id) throws Exception{
        try(BorrowDA borrowDA=new BorrowDA()){
            return borrowDA.findById(id);
        }
    }
    public static List<Borrow> findAll() throws Exception{
        try(BorrowDA borrowDA=new BorrowDA()){
            return borrowDA.findAll();
        }
    }
    public static List<Borrow> reportAll() throws Exception {
        try(BorrowDA borrowDA=new BorrowDA()){
            return borrowDA.reportAll();
        }
    }
    public static List<Borrow> reportByName(String name) throws Exception {
        try(BorrowDA borrowDA=new BorrowDA()){
            return borrowDA.reportByName(name);
        }
    }
    public static List<Borrow> reportByLastName(String lastName) throws Exception{
        try(BorrowDA borrowDA=new BorrowDA()){
            return borrowDA.reportByLastName(lastName);
        }
    }
    public static List<Borrow> reportByNameLastName(String name,String lastName) throws Exception {
        try(BorrowDA borrowDA=new BorrowDA()){
            return borrowDA.reportByNameLastName(name,lastName);
        }
    }
    public static List<Borrow> reportByBookName(String bookName) throws Exception {
        try(BorrowDA borrowDA=new BorrowDA()){
            return borrowDA.reportByBookName(bookName);
        }
    }
    public static String getPersonName(int id) throws Exception{
        try(BorrowDA borrowDA=new BorrowDA()){
            return borrowDA.getPersonName(id);
        }
    }
    public static String getBookName(int id) throws Exception{
        try(BorrowDA borrowDA=new BorrowDA()){
            return borrowDA.getBookName(id);
        }
    }
}
