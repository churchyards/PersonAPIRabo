package nl.lakkermans.personapi.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(toBuilder = true)
@JsonDeserialize(builder = AddressDTO.AddressDTOBuilder.class)
public class AddressDTO {

    @NonNull
    private String street;
    @NonNull
    private String city;

    @JsonPOJOBuilder(withPrefix = "")
    public static class AddressDTOBuilder {
    }
}
