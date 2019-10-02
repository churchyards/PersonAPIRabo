package nl.lakkermans.personapi.util;

import java.time.LocalDate;
import java.time.Period;

public class PersonUtil {

    public static int calculateAgeAt(LocalDate dob, LocalDate date) {
        return Period.between(dob, date).getYears();
    }
}
