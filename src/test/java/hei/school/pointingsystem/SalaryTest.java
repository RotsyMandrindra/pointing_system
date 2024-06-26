package hei.school.pointingsystem;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaryTest {

    @Test
    void testRakotoSalaryWithPublicHolidays() {
        List<LocalDate> publicHolidays = Arrays.asList(
                LocalDate.of(2024, 6, 17),
                LocalDate.of(2024, 6, 25),
                LocalDate.of(2024, 6, 26)
        );

        JanitorCalendar rakotoJanitorCalendar = new JanitorCalendar(
                LocalDate.of(2024, 5, 26),
                LocalDate.of(2024, 7, 7),
                publicHolidays
        );

        LocalDate startDate = LocalDate.of(2024, 5, 26);

        LocalDate endDate = LocalDate.of(2024, 7, 7);
        double grossSalaryPerDay = 14285;

        double bonusRate = 1.3;

        double totalSalaryEarned = rakotoJanitorCalendar.getTotalGrossSalary(grossSalaryPerDay, rakotoJanitorCalendar, bonusRate, startDate, endDate);

        assertEquals(612856.959, totalSalaryEarned);
    }

    @Test
    void how_much_rakoto_earns_per_hour(){
        List<LocalDate> publicHolidays = Arrays.asList(
                LocalDate.of(2024, 6, 17),
                LocalDate.of(2024, 6, 25),
                LocalDate.of(2024, 6, 26)
        );

        JanitorCalendar rakotoJanitorCalendar = new JanitorCalendar(
                LocalDate.of(2024, 5, 26),
                LocalDate.of(2024, 7, 7),
                publicHolidays
        );

        double salaryEarnedRakoto = rakotoJanitorCalendar.getSalaryWithoutBonusHourPerHour(10, 7, 100000, 0);

        assertEquals(1429, salaryEarnedRakoto);
    }

    @Test
    void how_much_rabe_earns_per_hour(){
        List<LocalDate> publicHolidays = Arrays.asList(
                LocalDate.of(2024, 6, 17),
                LocalDate.of(2024, 6, 25),
                LocalDate.of(2024, 6, 26)
        );

        JanitorCalendar rabeJanitorCalendar = new JanitorCalendar(
                LocalDate.of(2024, 5, 26),
                LocalDate.of(2024, 7, 7),
                publicHolidays
        );

        double salaryEarnedRabe = rabeJanitorCalendar.getSalaryWithoutBonusHourPerHour(14, 7, 100000, 1.3);

        assertEquals(1327, salaryEarnedRabe);
    }
}
