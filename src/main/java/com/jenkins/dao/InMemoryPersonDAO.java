package com.jenkins.dao;

import com.jenkins.model.Person;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPersonDAO implements PersonDAO {
    private final List<Person> persons = new ArrayList<>();

    @Override
    public List<Person> getAllPersons() {
        return new ArrayList<>(persons);
    }

    @Override
    public Person getPersonById(Long id) {
        return persons.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addPerson(Person person) {
        persons.add(person);
    }

    @Override
    public void updatePerson(Person person) {
        persons.removeIf(p -> p.getId().equals(person.getId()));
        persons.add(person);
    }

    @Override
    public void deletePerson(Long id) {
        persons.removeIf(person -> person.getId().equals(id));
    }
}
