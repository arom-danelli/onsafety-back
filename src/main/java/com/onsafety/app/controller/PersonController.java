package com.onsafety.app.controller;

import com.onsafety.app.model.Person;
import com.onsafety.app.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<Person> GetAllPersons(){
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id){
        Person person = personService.findById(id);
        return ResponseEntity.ok(person);
    }
    @PostMapping
    public ResponseEntity<Person> createPerson(@Valid @RequestBody Person person){
        Person savedPerson = personService.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @Valid @RequestBody Person person){
        person.setId(id);
        Person updatePerson = personService.update(person);
        return ResponseEntity.ok(updatePerson);
    }

        @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id){
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
