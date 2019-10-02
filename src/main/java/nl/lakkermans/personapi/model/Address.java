package nl.lakkermans.personapi.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @NonNull
    @Column(name = "street")
    private String street;
    @NonNull
    @Column(name = "city")
    private String city;
}
