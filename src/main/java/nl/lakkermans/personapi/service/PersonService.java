package nl.lakkermans.personapi.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nl.lakkermans.personapi.dto.PersonDTO;
import nl.lakkermans.personapi.model.Person;
import nl.lakkermans.personapi.repo.PersonRepository;
import nl.lakkermans.personapi.util.PersonMapper;
import nl.lakkermans.personapi.web.exception.PersonNotFoundException;
import nl.lakkermans.personapi.web.exception.PersonNotUniqueException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    @NonNull
    private PersonRepository repository;

    public PersonDTO getPerson(Long id) {
        return repository.findById(id).map(PersonMapper::toDTO).orElseThrow(PersonNotFoundException::new);
    }

    public List<PersonDTO> getPeople() {
        return repository.findAll().stream().map(PersonMapper::toDTO).collect(Collectors.toList());
    }

    /**
     * This method only saves the user when his firstname and lastname combination aren't in the database yet.
     * Set isolation to repeatable read, otherwise it wouldn't be thread save..
     *
     * @param person the person we want to save.
     * @return The saved PersonDTO with the newly generated id
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public PersonDTO createPerson(PersonDTO person) {
        if (repository.existsByFirstNameAndLastName(person.getFirstName(), person.getLastName())) {
            throw new PersonNotUniqueException();
        }
        Person savedPerson = repository.save(PersonMapper.toModel(person));
        return PersonMapper.toDTO(savedPerson);
    }

    /**
     * This method will update the Person if it's ID already exists in the database AND the possibly new firstName and lastName aren't already taken by an other Person.
     *
     * @param person The DTO that we want to update
     * @return The newly updated PersonDTO
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public PersonDTO updatePerson(PersonDTO person) {
        Person dbPerson = repository.findById(person.getId()).orElseThrow(() -> {
            throw new PersonNotFoundException();
        });

        Optional<Person> byFirstNameAndLastName = repository.findByFirstNameAndLastName(person.getFirstName(), person.getLastName());
        if (byFirstNameAndLastName.isPresent() && !byFirstNameAndLastName.get().getId().equals(person.getId())) {
            throw new PersonNotUniqueException();
        }

        PersonMapper.update(dbPerson, person);
        return PersonMapper.toDTO(repository.save(dbPerson));
    }

    public void deletePerson(Long id) {
        repository.deleteById(id);
    }
}
