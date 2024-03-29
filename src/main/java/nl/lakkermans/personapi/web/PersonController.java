package nl.lakkermans.personapi.web;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nl.lakkermans.personapi.dto.PersonDTO;
import nl.lakkermans.personapi.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/person")
@RequiredArgsConstructor
public class PersonController {

    @NonNull
    private PersonService service;

    @GetMapping
    public List<PersonDTO> getPeople() {
        return service.getPeople();
    }

    @GetMapping("/{personId}")
    public PersonDTO getPerson(@PathVariable("personId") Long id) {
        return service.getPerson(id);
    }

    @PostMapping
    public PersonDTO createPerson(@RequestBody PersonDTO person) {
        return service.createPerson(person);
    }

    @PutMapping("/{personId}")
    public PersonDTO updatePerson(@PathVariable("personId") Long id, @RequestBody PersonDTO person) {
        person.setId(id);
        return service.updatePerson(person);
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<Void> deletePerson(@PathVariable("personId") Long id) {
        service.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}