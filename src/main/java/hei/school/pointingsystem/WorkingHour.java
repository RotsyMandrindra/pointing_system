package hei.school.pointingsystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class WorkingHour {
    private int normalHourDay;
    private int overtimeHour;
    private int daysPerWeek;
    private int normalHourNight;

    public long calculateTotalWorkingHour(LocalDate startDate, LocalDate endDate){
        long weekBetween = ChronoUnit.WEEKS.between(startDate, endDate);
        long totalNormalHourDay = normalHourDay * daysPerWeek * weekBetween;
        long totalNormalHourNight = normalHourNight * daysPerWeek * weekBetween;
        long totalOvertimeHour = overtimeHour * daysPerWeek * weekBetween;
        return totalOvertimeHour + totalNormalHourDay + totalNormalHourNight;
    }

    public double calculateSalaryEarnedPerHourInDay(double grossSalary){
        double grossSalaryPerWeek = grossSalary / daysPerWeek;
        return Math.round(grossSalaryPerWeek / normalHourDay);
    }

    public double calculateSalaryEarnedPerHourInNight(double grossSalary, double additionalHourlyRate){
        double grossSalaryWithAdditionalHourlyRate = grossSalary * additionalHourlyRate / 100;
        double grossSalaryPerWeek = grossSalaryWithAdditionalHourlyRate / daysPerWeek;
        return Math.round(grossSalaryPerWeek / normalHourNight);
    }
}

