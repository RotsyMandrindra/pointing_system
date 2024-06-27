package hei.school.pointingsystem;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PublicHolidayTest {
    @Test
    void rakotoTestWithPublicHoliday() {
        List<LocalDate> publicHolidays = Arrays.asList(
                LocalDate.of(2024, 6, 26)
        );
        JanitorCalendar rakotoJanitorCalendar = new JanitorCalendar(
                LocalDate.of(2024, 5, 26),
                LocalDate.of(2024, 7, 7),
                publicHolidays
        );

        LocalDate startDate = LocalDate.of(2024, 5, 26);
        LocalDate endDate = LocalDate.of(2024, 7, 7);

        int numberOfPublicHoliday = rakotoJanitorCalendar.getNumberOfPublicHoliday(publicHolidays);

        double grossSalaryWithPublicHolidays = rakotoJanitorCalendar.getTotalGrossSalaryWithPublicHolidays(14285, rakotoJanitorCalendar, 1.5, startDate, endDate, numberOfPublicHoliday);
        double netSalaryWithPublicHoliday = rakotoJanitorCalendar.calculateNetSalary(grossSalaryWithPublicHolidays);

        assertEquals(607113, grossSalaryWithPublicHolidays);
        assertEquals(485690.4, netSalaryWithPublicHoliday);
    }

    @Test
    void rabeTestWithPublicHoliday() {
        List<LocalDate> publicHolidays = Arrays.asList(
                LocalDate.of(2024, 6, 26)
        );
        JanitorCalendar rabeJanitorCalendar = new JanitorCalendar(
                LocalDate.of(2024, 5, 26),
                LocalDate.of(2024, 7, 7),
                publicHolidays
        );

        LocalDate startDate = LocalDate.of(2024, 5, 26);
        LocalDate endDate = LocalDate.of(2024, 7, 7);

        int numberOfPublicHoliday = rabeJanitorCalendar.getNumberOfPublicHoliday(publicHolidays);

        double grossSalaryWithPublicHolidays = rabeJanitorCalendar.getTotalGrossSalaryWithPublicHolidays(18571, rabeJanitorCalendar, 1.5, startDate, endDate, numberOfPublicHoliday);
        double netSalaryWithPublicHoliday = rabeJanitorCalendar.calculateNetSalary(grossSalaryWithPublicHolidays);

        assertEquals(789268, grossSalaryWithPublicHolidays);
        assertEquals(631414.4, netSalaryWithPublicHoliday);
    }
}
