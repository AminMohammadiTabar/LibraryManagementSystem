package model.bl;

import model.da.PersonDA;
import model.entity.Person;

import java.time.LocalDate;
import java.util.List;

public class PersonBL {
    public static Person add(Person person)throws Exception{
        try(PersonDA personDA=new PersonDA()){
            return personDA.add(person);
        }
    }
    public static Person edit(Person person)throws Exception{
        try(PersonDA personDA=new PersonDA()){
            return personDA.edit(person);
        }
    }
    public static void remove(int id)throws Exception{
        try(PersonDA personDA=new PersonDA()){
            personDA.remove(id);
        }
    }
    public static List<Person> findAll() throws Exception {
        try(PersonDA personDA=new PersonDA()){
            return personDA.findAll();
        }
    }
    public static Person findById(int id) throws Exception {
        try(PersonDA personDA=new PersonDA()){
            return personDA.findById(id);
        }
    }
    public static List<Person> findByName(String name) throws Exception {
        try(PersonDA personDA=new PersonDA()){
            return personDA.findByName(name);
        }
    }
    public static List<Person> findByLastName(String lastName) throws Exception {
        try(PersonDA personDA=new PersonDA()){
            return personDA.findByLastName(lastName);
        }
    }
    public static List<Person> findByMembershipStart(LocalDate date) throws Exception {
        try(PersonDA personDA=new PersonDA()){
            return personDA.findByMembershipStart(date);
        }
    }
}
