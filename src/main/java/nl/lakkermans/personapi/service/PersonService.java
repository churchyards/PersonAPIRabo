package nl.lakkermans.personapi.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nl.lakkermans.personapi.dto.PersonDTO;
import nl.lakkermans.personapi.model.Person;
import nl.lakkermans.personapi.repo.PersonRepository;
import nl.lakkermans.personapi.util.PersonTranslator;
import nl.lakkermans.personapi.web.exception.PersonNotFoundException;
import nl.lakkermans.personapi.web.exception.PersonNotUniqueException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    @NonNull
    private PersonRepository repository;

    public PersonDTO getPerson(Long id) {
        return repository.findById(id).map(PersonTranslator::toDTO).orElseThrow(PersonNotFoundException::new);
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
        Person savedPerson = repository.save(PersonTranslator.toModel(person));
        return PersonTranslator.toDTO(savedPerson);
    }

    public List<PersonDTO> getPeople() {
        return repository.findAll().stream().map(PersonTranslator::toDTO).collect(Collectors.toList());
    }
}
