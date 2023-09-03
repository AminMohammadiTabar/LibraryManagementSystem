package model.entity;

import java.time.LocalDate;

public class Person {
    private int id;
    private String name,lastName;
    private LocalDate membershipStart;

    public Person() {
    }

    public Person(String name, String lastName, LocalDate membershipStart) {
        this.name = name;
        this.lastName = lastName;
        this.membershipStart = membershipStart;
    }

    public Person(int id, String name, String lastName, LocalDate membershipStart) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.membershipStart = membershipStart;
    }

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LocalDate getMembershipStart() {
        return membershipStart;
    }

    public Person setMembershipStart(LocalDate membershipStart) {
        this.membershipStart = membershipStart;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", membershipStart=" + membershipStart +
                '}';
    }
}
