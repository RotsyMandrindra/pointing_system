package hei.school.pointingsystem;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {
    private static final Logger log = LoggerFactory.getLogger(EmployeeTest.class);

    @Test
    void testAddEmployee(){
        Person rakoto = new Person("Rakoto", "", LocalDate.of(1997, 12, 5));
        Category guardianCategory = new Category("guardian", 10, 100000);
        WorkingHour workingHour = new WorkingHour(8, 0, 0);
        Salary salaryGuardian = new Salary(100000, workingHour, guardianCategory);
        Employee Rakoto = new Employee(rakoto, 12, LocalDate.of(2023, 4, 12), LocalDate.of(2025, 4, 12), guardianCategory, salaryGuardian);

        Person rabe = new Person("Rabe", "", LocalDate.of(1996, 5, 14));
        Employee Rabe = new Employee(rabe, 13, LocalDate.of(2022, 4, 12), LocalDate.of(2025, 4, 12), guardianCategory, salaryGuardian);

        PointingSystem pointingSystem = new PointingSystem();
        pointingSystem.addEmployee(Rakoto);
        pointingSystem.addEmployee(Rabe);

        int registrationNumberRakoto = Rakoto.getRegistrationNumber();
        int registrationNumberRabe = Rabe.getRegistrationNumber();
        assertEquals(12, registrationNumberRakoto);
        assertEquals(13, registrationNumberRabe);
    }

    @Test
    void testWorkingHour() {
        LocalDate startDate = LocalDate.of(2024, 5, 26);
        LocalDate endDate = LocalDate.of(2024, 7, 7);
        long weeksBetween;
        weeksBetween = ChronoUnit.WEEKS.between(startDate, endDate);

        assertEquals(6, weeksBetween);

        Long totalDaysRakoto = 7 * weeksBetween;
        Long totalNightRakoto = 0 * weeksBetween;
        Long totalNightsRabe = 7 * weeksBetween;
        Long totalDayRabe = 0 * weeksBetween;

        assertEquals(42, totalDaysRakoto + totalNightRakoto);
        assertEquals(42, totalNightsRabe + totalDayRabe);
    }

}
