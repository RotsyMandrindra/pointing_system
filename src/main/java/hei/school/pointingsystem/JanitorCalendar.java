package hei.school.pointingsystem;

import java.time.LocalDate;
import java.time.ZoneId;
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

    public double getTotalGrossSalary(double grossSalaryPerDay, JanitorCalendar janitorCalendar, double bonusRate, LocalDate startDate, LocalDate endDate){
        List <LocalDate> publicHoliday = new ArrayList<>();
        long numberOfPublicHoliday = janitorCalendar.getNumberOfPublicHoliday(publicHoliday);
        long totalDays = janitorCalendar.getTotalDaysWorkInAMonth(startDate, endDate);

        long regularDay = totalDays - numberOfPublicHoliday;

        double regularDaySalary = regularDay * grossSalaryPerDay;

        double publicHolidaySalary = janitorCalendar.getGrossSalaryWithBonusHour(grossSalaryPerDay, bonusRate, numberOfPublicHoliday);

        return regularDaySalary + publicHolidaySalary;
    }
}
