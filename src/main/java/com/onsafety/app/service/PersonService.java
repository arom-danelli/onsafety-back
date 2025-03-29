package com.onsafety.app.service;

import com.onsafety.app.exception.ResourceNotFoundException;
import com.onsafety.app.model.Person;
import com.onsafety.app.repository.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person findById(Long id){
        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com este ID. número:" + id));
    }

    public Person save(Person person){
        return personRepository.save(person);
    }

    @Transactional
    public Person update(Person person){
        if(person.getId() == null || !personRepository.existsById(person.getId())){
            throw new ResourceNotFoundException("Pessoa não encontrada com este ID");
        }
        return personRepository.save(person);
    }

    @Transactional
    public void delete (Long id){
        if (id == null || !personRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pessoa não encontrada com este ID. número:" + id);
        }
        personRepository.deleteById(id);
    }
}
