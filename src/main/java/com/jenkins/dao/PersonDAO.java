package com.jenkins.dao;

import com.jenkins.model.Person;

import java.util.List;

public interface PersonDAO {

    List<Person> getAllPersons();
    Person getPersonById(Long id);
    void addPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Long id);


}
