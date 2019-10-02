package nl.lakkermans.personapi.util;

import nl.lakkermans.personapi.dto.AddressDTO;
import nl.lakkermans.personapi.model.Address;

public class AddressTranslator {
    public static AddressDTO toDTO(Address address) {
        return AddressDTO.builder()
                .street(address.getStreet())
                .city(address.getCity())
                .build();
    }

    public static Address toModel(AddressDTO address) {
        return Address.builder()
                .street(address.getStreet())
                .city(address.getCity())
                .build();
    }
}
