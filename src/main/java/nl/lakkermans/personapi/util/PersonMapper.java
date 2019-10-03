package nl.lakkermans.personapi.util;

import nl.lakkermans.personapi.dto.PersonDTO;
import nl.lakkermans.personapi.model.Person;

public class PersonMapper {
    public static PersonDTO toDTO(Person person) {
        return PersonDTO.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .Age(person.getAge())
                .dateOfBirth(person.getDateOfBirth())
                .address(AddressMapper.toDTO(person.getLivingAdress()))
                .build();
    }

    public static Person toModel(PersonDTO dto) {
        return Person.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .dateOfBirth(dto.getDateOfBirth())
                .livingAdress(AddressMapper.toModel(dto.getAddress()))
                .build();
    }

    public static void update(Person dbPerson, PersonDTO person) {
        dbPerson.setFirstName(person.getFirstName());
        dbPerson.setLastName(person.getLastName());
        dbPerson.setDateOfBirth(person.getDateOfBirth());
        AddressMapper.update(dbPerson.getLivingAdress(), person.getAddress());
    }
}
