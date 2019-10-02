package nl.lakkermans.personapi.repo;

import nl.lakkermans.personapi.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    boolean existsByFirstNameAndLastName(String firstName, String lastName);

    @Override
    List<Person> findAll();
}
