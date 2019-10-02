package nl.lakkermans.personapi.model;

import lombok.*;
import nl.lakkermans.personapi.util.PersonUtil;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "person", uniqueConstraints = {
        @UniqueConstraint(name = "unique_full_name", columnNames = {"first_name", "last_name"})
})
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @NonNull
    @Embedded
    private Address livingAdress;

    public int getAge() {
        return PersonUtil.calculateAgeAt(dateOfBirth, LocalDate.now());
    }
}
