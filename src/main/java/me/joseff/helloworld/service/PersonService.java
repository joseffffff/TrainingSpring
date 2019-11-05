package me.joseff.helloworld.service;

import me.joseff.helloworld.dao.PersonDao;
import me.joseff.helloworld.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public boolean addPerson(Person person) {
        return this.personDao.addPerson(person);
    }

    public List<Person> getAllPeople() {
        return this.personDao.selectAll();
    }
}
