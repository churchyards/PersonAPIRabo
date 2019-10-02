package nl.lakkermans.personapi.util;

import nl.lakkermans.personapi.dto.PersonDTO;
import nl.lakkermans.personapi.model.Person;

public class PersonTranslator {
    public static PersonDTO toDTO(Person person) {
        return PersonDTO.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .Age(person.getAge())
                .dateOfBirth(person.getDateOfBirth())
                .address(AddressTranslator.toDTO(person.getLivingAdress()))
                .build();
    }

    public static Person toModel(PersonDTO person) {
        return Person.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .dateOfBirth(person.getDateOfBirth())
                .livingAdress(AddressTranslator.toModel(person.getAddress()))
                .build();
    }
}
