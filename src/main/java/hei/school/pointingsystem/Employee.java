package hei.school.pointingsystem;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data

public class Employee {
    private Person person;
    private int registrationNumber;
    private LocalDate hireDate;
    private LocalDate contractEndDate;
    private Category category;
    private Salary salary;
    private boolean workAtNight;

    public boolean isWorkingAtNight() {
        return workAtNight;
    }
}
