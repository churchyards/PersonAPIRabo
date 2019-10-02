package nl.lakkermans.personapi.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class PersonUtilTest {

    @Test
    public void testAgeCalculationBirthday() {
        int age = PersonUtil.calculateAgeAt(LocalDate.of(1990, Month.OCTOBER, 14), LocalDate.of(2020, Month.OCTOBER, 14));
        assertEquals("We expect the age to match.", 30, age);
    }

    @Test
    public void testAgeCalculationNotBirthday() {
        int age = PersonUtil.calculateAgeAt(LocalDate.of(1990, Month.OCTOBER, 14), LocalDate.of(2020, Month.OCTOBER, 13));
        assertEquals("We expect the age to match.", 29, age);
    }
}
