package entity;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.Period;

public class Age {
    private static final Logger logger = LoggerFactory.getLogger(Age.class);
    private final LocalDate dateOfBirthday;

    public Age(int years) {
        LocalDate date = LocalDate.now().minusYears(years);
        dateOfBirthday = date;
        validateAge();
    }

    public Age(LocalDate date) {
        this.dateOfBirthday = date;
        validateAge();
    }

    public Age() {
        this.dateOfBirthday = LocalDate.now();
    }

    public Age(int year, int month, int day) {
        this.dateOfBirthday = LocalDate.of(year, month, day);
    }

    public int value() {
        return Period.between(dateOfBirthday, LocalDate.now()).getYears();
    }

    private void validateAge() {
        if (value() < 0 || value() > 130) {
            RuntimeException e = new IllegalArgumentException(dateOfBirthday.toString());
            logger.error("incorrect date of birth", e);
            throw e;
        }
    }
}
