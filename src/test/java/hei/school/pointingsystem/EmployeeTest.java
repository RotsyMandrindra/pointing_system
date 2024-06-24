package hei.school.pointingsystem;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {
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
}
