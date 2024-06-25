package hei.school.pointingsystem;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    @Test
    void testAddEmployee(){
        Person rakoto = new Person("Rakoto", "", LocalDate.of(1997, 12, 5));
        Category guardianCategory = new Category("guardian", 10, 100000);
        WorkingHour workingHourRakoto = new WorkingHour(10, 0, 7, 0);
        WorkingHour workingHourRabe = new WorkingHour(0, 0, 7, 14);
        Salary salaryGuardianRabe = new Salary(100000, workingHourRabe, guardianCategory);
        Salary salaryGuardianRakoto = new Salary(100000, workingHourRakoto, guardianCategory);
        Employee Rakoto = new Employee(rakoto, 12, LocalDate.of(2023, 4, 12), LocalDate.of(2025, 4, 12), guardianCategory, salaryGuardianRakoto, false);

        Person rabe = new Person("Rabe", "", LocalDate.of(1996, 5, 14));
        Employee Rabe = new Employee(rabe, 13, LocalDate.of(2022, 4, 12), LocalDate.of(2025, 4, 12), guardianCategory, salaryGuardianRabe, true);

        PointingSystem pointingSystem = new PointingSystem();
        pointingSystem.addEmployee(Rakoto);
        pointingSystem.addEmployee(Rabe);

        assertTrue(Rabe.isWorkingAtNight());
        assertFalse(Rakoto.isWorkingAtNight());
    }

    @Test
    void testWorkingHourRakoto() {
        WorkingHour workingHourRakoto = new WorkingHour(10, 0, 7, 0);
        LocalDate startDate = LocalDate.of(2024, 05, 26);
        LocalDate endDate = LocalDate.of(2024, 07, 07);

        long totalWorkingHour = workingHourRakoto.calculateTotalWorkingHour(startDate, endDate);
        assertEquals(420, totalWorkingHour);
    }

    @Test
    void testWorkingHourRabe() {
        WorkingHour workingHourRabe = new WorkingHour(0, 0, 7, 14);
        LocalDate startDate = LocalDate.of(2024, 05, 26);
        LocalDate endDate = LocalDate.of(2024, 07, 07);

        long totalWorkingHour = workingHourRabe.calculateTotalWorkingHour(startDate, endDate);
        assertEquals(588, totalWorkingHour);
    }
}
