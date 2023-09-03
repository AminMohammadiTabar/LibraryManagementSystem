package control.modelcontroller;

import model.bl.PersonBL;
import model.entity.Person;
import tools.ExceptionWrapper;

import java.time.LocalDate;
import java.util.List;

public class PersonController {
        public static String add(String name, String lastName, LocalDate membershipStart){
            Person person=new Person(name,lastName,membershipStart);
            try{
                PersonBL.add(person);
            }
            catch (Exception e) {
                ExceptionWrapper.getMessage(e);
            }
            return person.toString();
        }
    public static String edit(int id,String name, String lastName, LocalDate membershipStart){
        Person person=new Person(id,name,lastName,membershipStart);
        try{
            PersonBL.edit(person);
        }
        catch (Exception e) {
            ExceptionWrapper.getMessage(e);
        }
        return person.toString();
    }
    public static void remove(int id){
            try{
                PersonBL.remove(id);
            } catch (Exception e) {
                ExceptionWrapper.getMessage(e);
            }
    }
    public static List<Person> findAll(){
            try{
                return PersonBL.findAll();
            } catch (Exception e) {
                ExceptionWrapper.getMessage(e);
                return null;
            }
    }
    public static Person findById(int id){
            try {
                return PersonBL.findById(id);
            } catch (Exception e) {
                ExceptionWrapper.getMessage(e);
                return null;
            }
    }
    public static List<Person> findByName(String name){
            try{
                return PersonBL.findByName(name);
            } catch (Exception e) {
                ExceptionWrapper.getMessage(e);
                return null;
            }
    }
    public static List<Person> findByLastname(String lastName){
            try{
                return PersonBL.findByLastName(lastName);
            } catch (Exception e) {
                ExceptionWrapper.getMessage(e);
                return null;
            }
    }
    public static List<Person> findByMembershipStart(LocalDate membershipStart){
            try{
                return PersonBL.findByMembershipStart(membershipStart);
            } catch (Exception e) {
                ExceptionWrapper.getMessage(e);
                return null;
            }
    }

}
