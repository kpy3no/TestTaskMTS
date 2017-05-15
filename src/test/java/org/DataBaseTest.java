package org;

import junit.framework.TestCase;
import org.example.domain.Person;
import org.example.service.IPersonService;
import org.example.service.PersonService;
import org.example.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by palevo on 12.05.2017.
 */
public class DataBaseTest extends TestCase {
    private IPersonService personService;

    private List<Person> validPersonList = new ArrayList<>();
    @Override
    protected void setUp() throws Exception {
        personService = new PersonService();

        validPersonList.add(new Person("Evgeny","Kuzmin"));
        validPersonList.add(new Person("Mikle","Pazetnov"));
        validPersonList.add(new Person("Julia","Borozenec"));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }


    public void testBasicUsage(){
        for(Person person : validPersonList){
            personService.addPerson(person);
        }

        for (Person person: personService.getAll()){
            System.out.println(person.toString());
        }
    }

    public void testOutputAllData(){
        for (Person person: personService.getAll()){
            System.out.println(person.toString());
        }
    }
}
