package model.entity;

import java.time.LocalDate;

public class Borrow {
    private int id,personId,bookId;
    private LocalDate borrowDate;
    private Boolean valid;
    private String name,lastName,bookName;

    public Borrow() {
    }

    public Borrow(int id, int personId, int bookId, LocalDate borrowDate) {
        this.id = id;
        this.personId = personId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }

    public Borrow(int id,String name, String lastName, String bookName, LocalDate borrowDate, Boolean valid) {
        this.id=id;
        this.borrowDate = borrowDate;
        this.valid = valid;
        this.name = name;
        this.lastName = lastName;
        this.bookName = bookName;
    }

    public Borrow(int id, int personId, int bookId, LocalDate borrowDate, Boolean valid) {
        this.id = id;
        this.personId = personId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.valid = valid;
    }

    public Borrow(int personId, int bookId, LocalDate borrowDate, Boolean valid) {
        this.personId = personId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.valid = valid;
    }

    public int getId() {
        return id;
    }

    public Borrow setId(int id) {
        this.id = id;
        return this;
    }

    public int getPersonId() {
        return personId;
    }

    public Borrow setPersonId(int personId) {
        this.personId = personId;
        return this;
    }

    public int getBookId() {
        return bookId;
    }

    public Borrow setBookId(int bookId) {
        this.bookId = bookId;
        return this;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public Borrow setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
        return this;
    }

    public Boolean getValid() {
        return valid;
    }

    public Borrow setValid(Boolean valid) {
        this.valid = valid;
        return this;
    }

    public String getName() {
        return name;
    }

    public Borrow setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Borrow setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getBookName() {
        return bookName;
    }

    public Borrow setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", personId=" + personId +
                ", bookId=" + bookId +
                ", borrowDate=" + borrowDate +
                '}';
    }
}
