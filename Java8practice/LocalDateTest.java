import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class LocalDateTest {

    public static void main(String[] args) {
        // Local Date, Time test code <-> new Date()
        LocalDate currentDate = LocalDate.now();    // the current date
        LocalDate firstAug2014 = LocalDate.of(2014, 8, 1);  // months values start at 1 (2014-08-01)
        LocalDate sixtyFifthDayOf2010 = LocalDate.ofYearDay(2010, 65);  // the 65th day of 2010 (2010-03-06)
        
        LocalTime currentTime = LocalTime.now(); // current time
        LocalTime midday = LocalTime.of(12, 0); // 12:00
        LocalTime afterMidday = LocalTime.of(13, 30, 15); // 13:30:15
        
        LocalTime fromSecondsOfDay = LocalTime.ofSecondOfDay(12345);    // 12345th second of day (03:25:45)
        LocalDateTime currentDateTime = LocalDateTime.now();    // dates with times, e.g. 2014-02-18 19:08:37.950
        LocalDateTime secondAug2014 = LocalDateTime.of(2014, 10, 2, 12, 30);    // 2014-10-02 12:30

        System.out.println(currentDate+" "+currentTime);
    }
}