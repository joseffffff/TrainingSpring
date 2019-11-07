package me.joseff.helloworld.api;

import me.joseff.helloworld.models.Person;
import me.joseff.helloworld.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;



    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        this.personService.addPerson(person);
    }

    /*
    @GetMapping
    public List<Person> getAllPeople() {
        return this.personService.getAllPeople();
    }
    */


    @GetMapping
    public String test() {
        return "aloha";
    }
}
