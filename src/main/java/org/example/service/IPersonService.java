package org.example.service;

import org.example.domain.Person;

import java.util.List;

/**
 * Created by palevo on 11.05.2017.
 */
public interface IPersonService {
    List<Person> getAll();
    void updatePerson(Person person);
    void deletePerson(Integer id);
    void addPerson(Person person);
}
