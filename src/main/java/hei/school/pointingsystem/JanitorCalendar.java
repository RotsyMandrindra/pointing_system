package hei.school.pointingsystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import lombok.Data;

@Data
public class JanitorCalendar {
    private Calendar calendar;

    public JanitorCalendar(LocalDate startMonth, LocalDate endMonth, List<LocalDate> publicHolidays) {
        this.calendar = Calendar.getInstance();
    }

    public int getNumberOfPublicHoliday(List<LocalDate> holidays) {
        return holidays.size();
    }

    public long getTotalDaysWorkInAMonth(LocalDate startDate, LocalDate endDate){
        long weekBetween = ChronoUnit.WEEKS.between(startDate, endDate);
        return weekBetween * 7;
    }

    public double getGrossSalaryWithBonusHour(double grossSalary, double bonusRate, long numberOfPublicHolidays){
        return grossSalary * bonusRate * numberOfPublicHolidays;
    }

    public double getTotalGrossSalaryWithPublicHolidays(double grossSalaryPerDay, JanitorCalendar janitorCalendar, double bonusRate, LocalDate startDate, LocalDate endDate, int numberOfPublicHolidays){
        long totalDays = janitorCalendar.getTotalDaysWorkInAMonth(startDate, endDate);
        long regularDays = totalDays - numberOfPublicHolidays;
        double regularDaysSalary = regularDays * grossSalaryPerDay;

        double publicHolidaySalary = numberOfPublicHolidays * bonusRate * grossSalaryPerDay;
        double totalEarnedSalary = Math.round(publicHolidaySalary + regularDaysSalary);
        return totalEarnedSalary;
    }

    public double getSalaryWithoutBonusHourPerHour(int numberHourPerDay, int numberDayPerWeek, double grossSalary, double bonusRate){

        if(bonusRate > 0){
            double grossSalaryWithBonus = grossSalary * bonusRate;
            double salaryEarnedPerDayWithBonus = grossSalaryWithBonus / numberDayPerWeek;
            double salaryEarnedPerDayPerHourWithBonus = salaryEarnedPerDayWithBonus / numberHourPerDay;
            return Math.round(salaryEarnedPerDayPerHourWithBonus);
        }
        double salaryEarnedPerDay = grossSalary / numberDayPerWeek;
        double salaryEarnedPerDayPerHour = salaryEarnedPerDay / numberHourPerDay;
        return Math.round(salaryEarnedPerDayPerHour);
    }
}
