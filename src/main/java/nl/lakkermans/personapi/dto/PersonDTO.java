package nl.lakkermans.personapi.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
@JsonDeserialize(builder = PersonDTO.PersonDTOBuilder.class)
public class PersonDTO {

    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    private Integer Age;

    @NonNull
    private LocalDate dateOfBirth;

    @NonNull
    private AddressDTO address;

    @JsonPOJOBuilder(withPrefix = "")
    public static class PersonDTOBuilder {
    }
}
