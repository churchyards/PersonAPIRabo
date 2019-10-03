package nl.lakkermans.personapi.repo;

import nl.lakkermans.personapi.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Override
    List<Person> findAll();

    boolean existsByFirstNameAndLastName(String firstName, String lastName);

    Optional<Person> findByFirstNameAndLastName(String firstName, String lastName);
}
