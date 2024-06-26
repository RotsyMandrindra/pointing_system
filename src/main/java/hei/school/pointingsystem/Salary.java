package hei.school.pointingsystem;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data

public class Salary {

    private double netSalary;
    private final WorkingHour workingHour;
    private final Category category;

    public Salary(double grossSalary, WorkingHour workingHour, Category category, List<LocalDate> publicHolidays) {
        this.workingHour = workingHour;
        this.category = category;
        this.netSalary = calculateNetSalary(grossSalary);
    }

    public double calculateNetSalary(double grossSalary) {
        netSalary = grossSalary - (grossSalary * 20 / 100);
        return netSalary;
    }
}
