package hei.school.pointingsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SalaryTest {
    @Test
    void testCalculateAdditionalHourSalary() {
        Category category = new Category("normal", 40, 100000);
        WorkingHour workingHour = new WorkingHour(10, 0, 0);
        Salary salary = new Salary(100000, workingHour, category);

        double additionalHourSalary = salary.calculateAdditionalHourSalary();
        assertEquals(0, additionalHourSalary);

        workingHour.setAdditionalHour(8);
        additionalHourSalary = salary.calculateAdditionalHourSalary();
        assertEquals(4000, additionalHourSalary);
    }

    @Test
    void testCalculateOvertimeSalary() {
        Category category = new Category("normal", 40, 100000);
        WorkingHour workingHour = new WorkingHour(10, 0, 0); 
        Salary salary = new Salary(100000, workingHour, category);

        double overtimeSalary = salary.calculateOvertimeSalary();
        assertEquals(0, overtimeSalary);

        workingHour.setOvertimeHour(8);
        overtimeSalary = salary.calculateOvertimeSalary();
        assertEquals(32000, overtimeSalary);
    }
}
