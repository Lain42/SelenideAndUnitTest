package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class AgeChecker {
    private static final Logger logger = LoggerFactory.getLogger(AgeChecker.class);

    public static boolean isEighteenYearsOld(String dateOfBirth) {

        LocalDate currentDate = LocalDate.now();

        try {
            LocalDate birthDate = LocalDate.parse(dateOfBirth);
            int age = Period.between(birthDate, currentDate).getYears();
            return age >= 18;
        } catch (DateTimeParseException e) {
            logger.error("Invalid date format. Please use the format YYYY-MM-DD.", e);
            throw e;
        }
    }
}
