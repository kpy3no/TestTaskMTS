package org.example.service;

import org.example.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.example.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by palevo on 11.05.2017.
 */
public class PersonService implements IPersonService {

    private SessionFactory sessionFactory;

    public PersonService() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Person> getAll() {
        List<Person> personList = new ArrayList<>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Person p");
        personList.addAll(q.list());
        session.getTransaction().commit();
        session.close();
        return personList;
    }

    @Override
    public void updatePerson(Person person) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(person);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deletePerson(Integer id) {
        Session session = sessionFactory.openSession();
        Person person = session.get(Person.class, id);
        if (person != null){
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
        }
        session.close();
    }

    @Override
    public void addPerson(Person person) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }
}
