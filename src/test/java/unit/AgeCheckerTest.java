package unit;

import org.example.AgeChecker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AgeCheckerTest extends AgeChecker {
    private final LocalDate currentDate = LocalDate.now();
    private final LocalDate eighteenYears = currentDate.minusYears(18);

    @Test(testName = "Test case 1: Person is exactly 18 years old")
    public void testIsEighteenYearsOld() {
        Assert.assertTrue(isEighteenYearsOld(String.valueOf(eighteenYears)),
                "The age was counted incorrect for person 18 y.o");
    }

    @Test(testName = "Test case 2: Person is older than 18 years")
    public void testIsOlderEighteenYearsOld() {
        Assert.assertTrue(isEighteenYearsOld(String.valueOf(eighteenYears.minusDays(1))),
                "The age was counted incorrect for person older than 18 y.o");
    }

    @Test(testName = "Test case 3: Person is younger than 18 years")
    public void testIsYoungerEighteenYearsOld() {
        Assert.assertFalse(isEighteenYearsOld(String.valueOf(eighteenYears.plusDays(1))),
                "The age was counted incorrect for person younger than 18 y.o");
    }

    @Test(testName = "Test case 4: Invalid input", expectedExceptions = DateTimeParseException.class)
    public void testInvalidDateFormat() {
        isEighteenYearsOld("bad-format");
    }
}
