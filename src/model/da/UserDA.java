package model.da;

import model.entity.Book;
import model.entity.User;
import tools.JDBCProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDA implements AutoCloseable {
    Connection connection;
    PreparedStatement preparedStatement;
    public UserDA() throws SQLException {
        connection= JDBCProvider.getJdbcProvider().getConnection();
    }
    public int isUserAuthorised(String username,String password) throws SQLException {
        preparedStatement=connection.prepareStatement("SELECT ID FROM USERPASS WHERE USERNAME=? AND PASSWORD=?," +
                "ACTIVE=?");
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        preparedStatement.setBoolean(3,true);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        User user=new User(resultSet.getInt("ID"),
                resultSet.getString("USERNAME"),
                resultSet.getString("PASSWORD")
        );
        return user.getId();
    }
    public Boolean isUserActive(User user) throws SQLException {
        preparedStatement=connection.prepareStatement("SELECT ACTIVE FROM USERPASS WHERE USERNAME=? AND PASSWORD=?");
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getBoolean("ACTIVE");
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
