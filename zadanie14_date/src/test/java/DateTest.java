import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import static org.example.Main.generateRandomDate;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class DateTest {

    @Test
    public void isDateNull() {
        LocalDate randomDate = generateRandomDate();

        assertTrue(randomDate != null);
    }

    @Test
    public void isDateInRange(){
        LocalDate randomDate = generateRandomDate();

        LocalDate minDate = LocalDate.of(1900, 1, 1);
        LocalDate maxDate = LocalDate.of(2025, 12, 31);
        assertTrue(randomDate.isAfter(minDate) && randomDate.isBefore(maxDate.plusDays(1)));
    }

    @Test
    public void DayOfWeek(){
        LocalDate randomDate = generateRandomDate();

        DayOfWeek dayOfWeek = randomDate.getDayOfWeek();
        assertTrue(dayOfWeek != null);
    }

    @Test
    public void InvalidDateGeneration(){
        assertThrows(DateTimeException.class, () -> {
            LocalDate invalidDate = LocalDate.of(2025, 2, 30);
        });
    }
}
