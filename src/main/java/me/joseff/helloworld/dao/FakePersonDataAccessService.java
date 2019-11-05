package me.joseff.helloworld.dao;

import me.joseff.helloworld.models.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<Person>();

    @Override
    public boolean insertPerson(UUID id, Person person) {
        return DB.add(new Person(id, person.getName()));
    }

    @Override
    public List<Person> selectAll() {
        return this.DB;
    }

    @Override
    public Optional<Person> findById(UUID id) {
        return this.DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean deletePersonById(UUID id) {
        Person person = this.findById(id).get();

        if (person != null) {
            int index = this.DB.indexOf(person);
            this.DB.remove(index);
            return true;
        }

        return false;
    }

    @Override
    public boolean updatePersonById(UUID id, Person person) {
        return false;
    }
}
