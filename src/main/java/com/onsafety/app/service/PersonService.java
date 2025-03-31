package com.onsafety.app.service;

import com.onsafety.app.exception.ResourceNotFoundException;
import com.onsafety.app.model.Person;
import com.onsafety.app.repository.PersonRepository;
import com.onsafety.app.service.generics.GenericService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService extends GenericService<Person, Long>{


    public PersonService(PersonRepository personRepository) {
        super(personRepository);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return Optional.ofNullable(super.getRepository().findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa com ID " + id + " não foi encontrada.")));
    }

    public boolean existsByCpf(String cpf) {
        return ((PersonRepository) getRepository()).existsByCpf(cpf);
    }


}
