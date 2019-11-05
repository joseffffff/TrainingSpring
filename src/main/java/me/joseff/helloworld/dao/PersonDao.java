package me.joseff.helloworld.dao;

import me.joseff.helloworld.models.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    public boolean insertPerson(UUID id, Person person);

    default boolean addPerson(Person person) {
        UUID id = UUID.randomUUID();
        return this.insertPerson(id, person);
    }

    public List<Person> selectAll();

    public Optional<Person> findById(UUID id);

    public boolean deletePersonById(UUID id);

    public boolean updatePersonById(UUID id, Person person);
}
