package hei.school.pointingsystem;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SalaryTest {

    @Test
    void testCalculateAdditionalHourSalary() {
        Category category = new Category("janitor", 10, 100000);

        WorkingHour dayWorkingHour = new WorkingHour(10, 0, 0, LocalTime.of(7, 0), LocalTime.of(17, 0));
        Salary salaryDay = new Salary(100000, dayWorkingHour, category);

        dayWorkingHour.setAdditionalHour(8);
        double additionalHourSalaryDayWithExtraHours = salaryDay.calculateAdditionalHourSalary();
        assertEquals(104000, additionalHourSalaryDayWithExtraHours);

        WorkingHour nightWorkingHour = new WorkingHour(0, 0, 8, LocalTime.of(19, 0), LocalTime.of(7, 0));
        Salary salaryNight = new Salary(100000, nightWorkingHour, category);
        double additionalHourSalaryNight = salaryNight.calculateAdditionalHourSalary();
        assertEquals(80000, additionalHourSalaryNight); // Ajusté pour refléter le taux de majoration de 130%
    }

    @Test
    void testCalculateOvertimeSalary() {
        Category category = new Category("normal", 40, 100000);

        WorkingHour dayWorkingHour = new WorkingHour(10, 0, 0, LocalTime.of(8, 0), LocalTime.of(17, 0));
        Salary salaryDay = new Salary(100000, dayWorkingHour, category);
        double overtimeSalaryDay = salaryDay.calculateOvertimeSalary();
        assertEquals(0, overtimeSalaryDay);

        dayWorkingHour.setOvertimeHour(8);
        double overtimeSalaryDayWithExtraHours = salaryDay.calculateOvertimeSalary();
        assertEquals(26000, overtimeSalaryDayWithExtraHours);

        WorkingHour nightWorkingHour = new WorkingHour(0, 8, 0, LocalTime.of(19, 0), LocalTime.of(7, 0));
        Salary salaryNight = new Salary(100000, nightWorkingHour, category);
        double overtimeSalaryNight = salaryNight.calculateOvertimeSalary();
        assertEquals(20000, overtimeSalaryNight);
    }
}
