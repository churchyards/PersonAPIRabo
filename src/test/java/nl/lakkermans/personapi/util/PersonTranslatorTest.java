package nl.lakkermans.personapi.util;

import nl.lakkermans.personapi.dto.AddressDTO;
import nl.lakkermans.personapi.dto.PersonDTO;
import nl.lakkermans.personapi.model.Address;
import nl.lakkermans.personapi.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class PersonTranslatorTest {

    private Person person;
    private PersonDTO personDTO;

    @Before
    public void setup() {
        LocalDate dob = LocalDate.now().minus(19, ChronoUnit.YEARS);
        person = Person.builder()
                .id(1L)
                .firstName("John")
                .lastName("Smith")
                .dateOfBirth(dob)
                .livingAdress(Address.builder()
                        .street("Smith John 15")
                        .city("John City")
                        .build())
                .build();
        personDTO = PersonDTO.builder()
                .id(1L)
                .firstName("John")
                .lastName("Smith")
                .dateOfBirth(dob)
                .Age(19)
                .address(AddressDTO.builder()
                        .street("Smith John 15")
                        .city("John City")
                        .build())
                .build();
    }

    @Test
    public void testToDTO() {
        assertEquals("Expecting response of the translator to match the personDTO", personDTO, PersonTranslator.toDTO(person));
    }

    @Test
    public void testToModel() {
        assertEquals("Expecting response of the translator to match the perso", person, PersonTranslator.toModel(personDTO));
    }


}