package model.da;

import model.entity.Book;
import model.entity.Borrow;
import tools.JDBCProvider;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BorrowDA implements AutoCloseable{
    Connection connection;
    PreparedStatement preparedStatement;

    public BorrowDA() throws SQLException {
        connection= JDBCProvider.getJdbcProvider().getConnection();
    }
    public Borrow add(Borrow borrow) throws SQLException {
        preparedStatement=connection.prepareStatement("SELECT BORROW_SEQ.NEXTVAL id FROM DUAL");
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        borrow.setId(resultSet.getInt("id"));
        preparedStatement=connection.prepareStatement("INSERT INTO BORROW VALUES (?,?,?,?,?)");
        preparedStatement.setInt(1,borrow.getId());
        preparedStatement.setInt(2,borrow.getPersonId());
        preparedStatement.setInt(3, borrow.getBookId());
        preparedStatement.setDate(4, Date.valueOf(borrow.getBorrowDate()));
        preparedStatement.setBoolean(5,true);
        preparedStatement.execute();
        return borrow;
    }
    public Borrow edit(Borrow borrow) throws SQLException {
        preparedStatement=connection.prepareStatement("UPDATE BORROW SET PERSON_ID=?,BOOK_ID=?,BORROW_DATE=? WHERE ID=?");
        preparedStatement.setInt(1,borrow.getPersonId());
        preparedStatement.setInt(2, borrow.getBookId());
        preparedStatement.setDate(3, Date.valueOf(borrow.getBorrowDate()));
        preparedStatement.setInt(4,borrow.getId());
        preparedStatement.execute();
        return borrow;
    }
    public Borrow invalidate(int id) throws SQLException {
        preparedStatement=connection.prepareStatement("UPDATE BORROW SET VALID=? WHERE ID=?");
        preparedStatement.setBoolean(1,false);
        preparedStatement.setInt(2,id);
        preparedStatement.execute();
        return null;
    }
    public Borrow remove(int id) throws SQLException {
        preparedStatement=connection.prepareStatement("DELETE FROM BORROW WHERE ID=?");
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
        return null;
    }
    public List<Borrow> findAll() throws SQLException {
        List<Borrow> borrowList=new ArrayList<>();
        preparedStatement=connection.prepareStatement("SELECT * FROM BORROW");
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            Borrow borrow=new Borrow(resultSet.getInt("ID"),
                    resultSet.getInt("PERSON_ID"),
                    resultSet.getInt("BOOK_ID"),
                    resultSet.getDate("BORROW_DATE").toLocalDate(),resultSet.getBoolean("VALID"));
            borrowList.add(borrow);
        }
        return borrowList;
    }
    public Borrow findById(int id) throws SQLException {
        preparedStatement=connection.prepareStatement("SELECT * FROM BORROW WHERE ID=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        Borrow borrow=new Borrow(resultSet.getInt("ID"),
                resultSet.getInt("PERSON_ID"),
                resultSet.getInt("BOOK_ID"),
                resultSet.getDate("BORROW_DATE").toLocalDate(),resultSet.getBoolean("VALID"));
        return borrow;
    }
    public List<Borrow> reportAll() throws SQLException {
        List<Borrow> borrowList=new ArrayList<>();
        preparedStatement=connection.prepareStatement("SELECT * FROM BORROW_INFO");
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Borrow borrow=new Borrow(resultSet.getInt("BORROW_ID"),
                    resultSet.getString("NAME"),
                    resultSet.getString("LAST_NAME"),
                    resultSet.getString("BOOK_NAME"),
                    resultSet.getDate("BORROW_DATE").toLocalDate(),
                    resultSet.getBoolean("VALIDATION"));
            borrowList.add(borrow);
        }
        return borrowList;
    }
    public List<Borrow> reportByName(String name) throws SQLException {
        List<Borrow> borrowList=new ArrayList<>();
        preparedStatement=connection.prepareStatement("SELECT * FROM BORROW_INFO WHERE NAME=? ");
        preparedStatement.setString(1,name);
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Borrow borrow=new Borrow(resultSet.getInt("BORROW_ID"),
                    resultSet.getString("NAME"),
                    resultSet.getString("LAST_NAME"),
                    resultSet.getString("BOOK_NAME"),
                    resultSet.getDate("BORROW_DATE").toLocalDate(),
                    resultSet.getBoolean("VALIDATION"));
            borrowList.add(borrow);
        }
        return borrowList;
    }
    public List<Borrow> reportByLastName(String lastName) throws SQLException {
        List<Borrow> borrowList=new ArrayList<>();
        preparedStatement=connection.prepareStatement("SELECT * FROM BORROW_INFO WHERE LAST_NAME=? ");
        preparedStatement.setString(1,lastName);
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Borrow borrow=new Borrow(resultSet.getInt("BORROW_ID"),
                    resultSet.getString("NAME"),
                    resultSet.getString("LAST_NAME"),
                    resultSet.getString("BOOK_NAME"),
                    resultSet.getDate("BORROW_DATE").toLocalDate(),
                    resultSet.getBoolean("VALIDATION"));
            borrowList.add(borrow);
        }
        return borrowList;
    }
    public List<Borrow> reportByNameLastName(String name,String lastName) throws SQLException {
        List<Borrow> borrowList=new ArrayList<>();
        preparedStatement=connection.prepareStatement("SELECT * FROM BORROW_INFO WHERE NAME=? AND LAST_NAME=? ");
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,lastName);
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Borrow borrow=new Borrow(resultSet.getInt("BORROW_ID"),
                    resultSet.getString("NAME"),
                    resultSet.getString("LAST_NAME"),
                    resultSet.getString("BOOK_NAME"),
                    resultSet.getDate("BORROW_DATE").toLocalDate(),
                    resultSet.getBoolean("VALIDATION"));
            borrowList.add(borrow);
        }
        return borrowList;
    }
    public List<Borrow> reportByBookName(String bookName) throws SQLException {
        List<Borrow> borrowList=new ArrayList<>();
        preparedStatement=connection.prepareStatement("SELECT * FROM BORROW_INFO WHERE BOOK_NAME=?");
        preparedStatement.setString(1,bookName);
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Borrow borrow=new Borrow(resultSet.getInt("BORROW_ID"),
                    resultSet.getString("NAME"),
                    resultSet.getString("LAST_NAME"),
                    resultSet.getString("BOOK_NAME"),
                    resultSet.getDate("BORROW_DATE").toLocalDate(),
                    resultSet.getBoolean("VALIDATION"));
            borrowList.add(borrow);
        }
        return borrowList;
    }
    public int getBookId(int id) throws SQLException {
        preparedStatement=connection.prepareStatement("SELECT BOOK_ID FROM BORROW WHERE ID=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        int bookId=resultSet.getInt("BOOK_ID");
        return bookId;
    }
    public String getPersonName(int id) throws SQLException {
        preparedStatement=connection.prepareStatement("SELECT NAME, LAST_NAME FROM BORROW_INFO WHERE BORROW_ID=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        String personName=resultSet.getString("NAME")+" "+resultSet.getString("LAST_NAME");
        return personName;
    }
    public String getBookName(int id) throws SQLException {
        preparedStatement=connection.prepareStatement("SELECT BOOK_NAME FROM BORROW_INFO WHERE BORROW_ID=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        String bookName=resultSet.getString("BOOK_NAME");
        return bookName;
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
