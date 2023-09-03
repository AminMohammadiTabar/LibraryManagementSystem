package model.da;

import model.entity.Person;
import tools.JDBCProvider;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PersonDA implements AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PersonDA() throws SQLException {
        connection= JDBCProvider.getJdbcProvider().getConnection();
    }
    public Person add(Person person) throws SQLException {
        preparedStatement=connection.
                prepareStatement("SELECT PERSON_SEQ.NEXTVAL ID FROM DUAL");
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        person.setId(resultSet.getInt("ID"));
                preparedStatement=connection.prepareStatement("INSERT INTO PERSON VALUES (PERSON_SEQ.NEXTVAL,?,?,?)");
        preparedStatement.setInt(1,person.getId());
        preparedStatement.setString(1,person.getName());
        preparedStatement.setString(2,person.getLastName());
        preparedStatement.setDate(3, Date.valueOf(person.getMembershipStart()));
        preparedStatement.execute();
        return person;
    }
    public Person edit(Person person) throws SQLException {
        preparedStatement=connection.
                prepareStatement("UPDATE PERSON SET NAME=?,LAST_NAME=?,MEMBERSHIP_START=? WHERE ID=?");
        preparedStatement.setString(1,person.getName());
        preparedStatement.setString(2,person.getLastName());
        preparedStatement.setDate(3,Date.valueOf(person.getMembershipStart()));
        preparedStatement.setInt(4,person.getId());
        preparedStatement.execute();
        return person;
    }
    public Person remove(int id) throws SQLException {
        preparedStatement=connection.
                prepareStatement("DELETE FROM PERSON WHERE ID=?");
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
        return null;
    }
    public List<Person> findAll() throws SQLException {
        List<Person> personList=new ArrayList<>();
        preparedStatement=connection.
                prepareStatement("SELECT * FROM PERSON");
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            Person person=new Person(resultSet.getInt("ID"),
                    resultSet.getString("NAME"),
                    resultSet.getString("LAST_NAME"),
                    resultSet.getDate("MEMBERSHIP_START").toLocalDate());
            personList.add(person);
        }
        return personList;
    }
    public Person findById(int id) throws SQLException {
        preparedStatement=connection.
                prepareStatement("SELECT * FROM PERSON WHERE ID=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        Person person=new Person(resultSet.getInt("ID"),
                resultSet.getString("NAME"),
                resultSet.getString("LAST_NAME"),
                resultSet.getDate("MEMBERSHIP_START").toLocalDate());
        return person;
    }
    public List<Person> findByName(String name) throws SQLException {
        List<Person> personList=new ArrayList<>();
        preparedStatement=connection.
                prepareStatement("SELECT * FROM PERSON WHERE NAME=?");
        preparedStatement.setString(1,name);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()) {
            Person person = new Person(resultSet.getInt("ID"),
                    resultSet.getString("NAME"),
                    resultSet.getString("LAST_NAME"),
                    resultSet.getDate("MEMBERSHIP_START").toLocalDate());
            personList.add(person);
        }
        return personList;
    }
    public List<Person> findByLastName(String lastName) throws SQLException {
        List<Person> personList=new ArrayList<>();
        preparedStatement=connection.
                prepareStatement("SELECT * FROM PERSON WHERE LAST_NAME=?");
        preparedStatement.setString(1,lastName);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()) {
            Person person = new Person(resultSet.getInt("ID"),
                    resultSet.getString("NAME"),
                    resultSet.getString("LAST_NAME"),
                    resultSet.getDate("MEMBERSHIP_START").toLocalDate());
            personList.add(person);
        }
        return personList;
    }
    public List<Person> findByMembershipStart(LocalDate date) throws SQLException {
        List<Person> personList=new ArrayList<>();
        preparedStatement=connection.
                prepareStatement("SELECT * FROM PERSON WHERE MEMBERSHIP_START=?");
        preparedStatement.setDate(1,Date.valueOf(date));
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            Person person=new Person(resultSet.getInt("ID"),
                    resultSet.getString("NAME"),
                    resultSet.getString("LAST_NAME"),
                    resultSet.getDate("MEMBERSHIP_START").toLocalDate());
            personList.add(person);
        }
        return personList;
    }
    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
