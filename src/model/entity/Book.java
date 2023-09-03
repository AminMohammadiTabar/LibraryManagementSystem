package model.entity;

public class Book {
    private int id;
    private String name,author;
    private Boolean available;

    public Book() {
    }

    public Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Book(String name, String author, Boolean available) {
        this.name = name;
        this.author = author;
        this.available = available;
    }

    public Book(int id, String name, String author, Boolean available) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public Book setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Boolean getAvailable() {
        return available;
    }

    public Book setAvailable(Boolean available) {
        this.available = available;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", available=" + available +
                '}';
    }
}
