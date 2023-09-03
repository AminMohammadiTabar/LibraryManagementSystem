package model.da;

import model.entity.Book;
import tools.JDBCProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDA implements AutoCloseable{
    Connection connection;
    PreparedStatement preparedStatement;
    public BookDA() throws SQLException {
        connection= JDBCProvider.getJdbcProvider().getConnection();
    }
    public Book add(Book book) throws SQLException {
        preparedStatement=connection.prepareStatement("SELECT BOOK_SEQ.NEXTVAL id FROM DUAL");
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        book.setId(resultSet.getInt("id"));
        preparedStatement=connection.prepareStatement("INSERT INTO BOOK VALUES (?,?,?,?)");
        preparedStatement.setInt(1,book.getId());
        preparedStatement.setString(2,book.getName());
        preparedStatement.setString(3, book.getAuthor());
        preparedStatement.setBoolean(4,true);
        preparedStatement.execute();
        return book;
    }
    public Book edit(Book book) throws SQLException {
        preparedStatement=connection.prepareStatement("UPDATE BOOK SET NAME=?,AUTHOR=? WHERE ID=?");
        preparedStatement.setString(1, book.getName());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setInt(3,book.getId());
        preparedStatement.execute();
        return book;
    }
    public Book remove(int id) throws SQLException {
        preparedStatement=connection.prepareStatement("DELETE FROM BOOK WHERE ID=?");
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
        return null;
    }
    public Book changeAvailability(int id,Boolean availability) throws SQLException {
        preparedStatement=connection.prepareStatement("UPDATE BOOK SET AVAILABLE=? WHERE ID=?");
        preparedStatement.setBoolean(1,availability);
        preparedStatement.setInt(2,id);
        preparedStatement.execute();
        return null;
    }
    public List<Book> findAll() throws SQLException {
        List<Book> bookList=new ArrayList<>();
        preparedStatement=connection.prepareStatement("SELECT * FROM BOOK");
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            Book book=new Book(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("author"),
                    resultSet.getBoolean("available"));
            bookList.add(book);
        }
        return bookList;
    }

    public Book findById(int id) throws SQLException {
        preparedStatement=connection.prepareStatement("SELECT * FROM BOOK WHERE ID=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        Book book=new Book(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("author"),
                resultSet.getBoolean("available"));
        return book;
    }
    public List<Book> findByName(String name) throws SQLException {
        List<Book> bookList=new ArrayList<>();
        preparedStatement=connection.prepareStatement("SELECT * FROM BOOK WHERE NAME =?");
        preparedStatement.setString(1,name);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()) {
            Book book = new Book(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("author"),
                    resultSet.getBoolean("available"));
            bookList.add(book);
        }
        return bookList;
    }
    public List<Book> findByAuthor(String author) throws SQLException {
        List<Book> bookList=new ArrayList<>();
        preparedStatement=connection.prepareStatement("SELECT * FROM BOOK WHERE AUTHOR =?");
        preparedStatement.setString(1,author);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()) {
            Book book = new Book(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("author"),
                    resultSet.getBoolean("available"));
            bookList.add(book);
        }
        return bookList;
    }
    public Boolean isAvailable(int id) throws SQLException {
        preparedStatement=connection.prepareStatement("SELECT AVAILABLE FROM BOOK WHERE ID=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getBoolean("AVAILABLE");
    }
    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
